import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javalib.impworld.*;
import javalib.worldimages.*;
import tester.Tester;

/*
 * ENHANCEMENTS:
 * - Graphics: We used multiple UI elements to enhance our game, such as
 * -- Highlighting the chosen and matched cards blue and green respectively
 * -- Timer, Move Counter, and Cheat Indicator for our other enhancements
 * -- The color representing each suit is on the card
 * 
 * - New Features: We added multiple new features to the game including
 * -- A timer keeping track of the seconds elapsed in game
 * -- A move counter that tracks the number of pairs of cards chosen
 * --> This is then shown to the player after completing the game
 * -- Increased game difficulty by requiring the suit colors to match as well as rank
 * -- Added a cheat function accessible by pressing "h" at any time
 * --> This shows all previously chosen cards in the game 
 * --> Disables clicking while active
 * --> Can be toggled on and off
 */

// represents the concentration game
class ConcentrationGame extends World {
  static int SCREENW = 660;
  static int SCREENH = 330;
  ArrayList<ArrayList<Card>> cards;
  ArrayList<Card> cardsFaceUp;
  int time;
  ArrayList<Card> prevPicked;
  int moves;
  int matches;
  boolean cheat;

  // Constructor
  ConcentrationGame(ArrayList<ArrayList<Card>> cards) {
    this.cards = cards;
    this.cardsFaceUp = new ArrayList<Card>();
    this.time = 0;
    this.prevPicked = new ArrayList<Card>();
    this.moves = 0;
    this.matches = 0;
    this.cheat = false;
  }

  /* TEMPLATE:
   * fields:
   * ... this.cards       ... - ArrayList<ArrayList<Card>>
   * ... this.cardsFaceUp ... - ArrayList<Card>
   * ... this.time        ... - int
   * ... this.prevPicked  ... - ArrayList<Card>
   * ... this.moves       ... - int
   * ... this.matches     ... - int
   * ... this.cheat       ... - boolean
   * methods:
   * ... this.makeScene()        ... - WorldScene
   * ... this.onKeyEvent(String) ... - void
   * ... this.onKeyTest(String)  ... - void
   * ... this.onTick()           ... - void
   * ... this.onMouseClicked()   ... - void
   * ... this.lastScene(String)  ... - WorldScene
   */

  // draws the world scene
  public WorldScene makeScene() {
    // makes a local where all images are draw onto
    WorldScene result = new WorldScene(SCREENW, SCREENH);

    // draws all the cards onto the scene
    for (int row = 0; row < this.cards.size(); row++) {
      ArrayList<Card> temp = this.cards.get(row);
      for (int col = 0; col < temp.size(); col++) {

        // uses utils methods to generate appropriate position for each card
        result.placeImageXY(temp.get(col).drawCard(), new Utils().generateX(col), 
            new Utils().generateY(row));
      }
    }

    result.placeImageXY(new Utils().drawTimer(this.time), 580, 310);
    result.placeImageXY(new Utils().drawCheat(this.cheat), 50, 310);
    result.placeImageXY(new Utils().drawMoves(this.moves), 330, 310);

    // returns mutated WorldScene
    return result;
  } 

  // onKeyEvent for keystroke inputs
  public void onKeyEvent(String key) { 
    // resets the game when the user hits the 'r' key
    if (key.equals("r")) {
      this.cards = new Utils().makeBoard(new Utils().shuffle(new Utils().makeDeck(), 
          new Random())); 
    }

    // toggles all previously picked cards to become face up on 'h' key
    if (key.equals("h")) {
      for (Card c : this.prevPicked) {
        c.faceUp = !c.faceUp;
      }
      this.cheat = !this.cheat;
    }
  }


  // onkeyEvent but for tests
  public void onKeyEventTest(String key) {
    if (key.equals("r")) {
      this.cards = new Utils().makeBoard(new Utils().shuffle(new Utils().makeDeck(), 
          new Random(1))); 
    }

    if (key.equals("h")) {
      for (Card c : this.prevPicked) {
        c.faceUp = !c.faceUp;
      }
    }
  }

  // mutates the world on every tick
  public void onTick() {
    this.time++;
    // ends the game if the matches are equal to 26
    // requires an extra click upon finding the final pair
    if (this.matches == 26) {
      this.endOfWorld("Game Complete! You used " + String.valueOf(this.moves) + " moves");
    }
  }

  // flips a card over when its clicked on
  public void onMouseClicked(Posn pos) {
    if (!this.cheat) {
      // counts the number of cards facing up
      int faceUpNumber = new Utils().countFaceUp(this.cards);

      //Once two cards are flipped over, begins checking for matches
      if (faceUpNumber == 2) {
        if (new Utils().checkCards(this.cardsFaceUp)) {
          for (Card c : this.cardsFaceUp) {
            c.matched = true;
            c.faceUp = false;
            c.selected = false;
          }
          this.matches += 1;
        }

        // If not matching, the following occurs.
        else {
          for (Card c : this.cardsFaceUp) {
            c.faceUp = false;
            c.selected = false;
            if (this.prevPicked.indexOf(c) == -1) {
              this.prevPicked.add(c);
            }
          }
        }
        this.moves++;
        this.cardsFaceUp.clear();
      }

      for (int row = 0; row < this.cards.size(); row++) {
        // temporary list for the current row of cards
        ArrayList<Card> temp = this.cards.get(row);

        for (int col = 0; col < temp.size(); col++) {
          // tracks current card
          Card curr = temp.get(col);

          // determines if the chosen card is clickable, flips it if so
          if (curr.inRange(row, col, pos) && !curr.matched && !curr.faceUp) {
            this.cardsFaceUp.add(curr);
            curr.faceUp = true;
            curr.selected = true;
            if (this.prevPicked.indexOf(curr) != -1) {
              this.prevPicked.remove(curr);
            }
          }
        }
      }
    }
  }
  
  //shows ending scene
  public WorldScene lastScene(String s) {
    WorldScene result = new WorldScene(SCREENW, SCREENH);
    result.placeImageXY(new OverlayImage(new TextImage(s, Color.BLACK),
        new RectangleImage(400, 80, OutlineMode.SOLID, Color.GREEN)), 
        SCREENW / 2, SCREENH / 2);
    return result;
  }
}

// to run the concentration game
class RunConcentration {
  // runs ConcentrationGame
  void testBigBang(Tester t) {
    ConcentrationGame world = new ConcentrationGame(new Utils().makeBoard(
        new Utils().shuffle(new Utils().makeDeck(), new Random())));
    int worldWidth = 660;
    int worldHeight = 330;
    double tickRate = 1;
    world.bigBang(worldWidth, worldHeight, tickRate);
  } 
}