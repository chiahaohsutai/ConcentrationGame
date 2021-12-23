import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javalib.worldimages.*;

//Utils class for array functions and constructors
class Utils {

  /* TEMPLATE:
   * methods:
   * ... this.setColor(Card) ...    - Color
   * ... this.generateX(int) ...    - int
   * ... this.generateY(int) ...    - int
   * ... this.checkSuit(String) ... - String
   * ... this.checkRank(int) ...    - int
   * ... this.makeDeck() ...        - ArrayList<Card>
   * ... this.makeBoard() ...       - ArrayList<ArrayList<Card>>
   * ... this.shuffle(ArrayList<Card>, Random) ... - ArrayList<Card>
   * ... this.countFaceUp(ArrayList<ArrayList<Card>>) ... - int
   * ... this.checkCards(ArrayList<Card>) ... - boolean
   * ... this.drawTimer(int) ... - WorldImage
   * ... this.drawMoves(int) ... - WorldImage
   * ... this.Cheat(boolean) ... - WorldImage
   */

  // sets the color according to the suit
  Color setColor(Card card) {
    if (card.suit.equals("♣") || card.suit.equals("♠")) {
      return Color.black;
    }
    else {
      return Color.red;
    }
  }

  // generate the approbate x position based on column number
  int generateX(int col) {
    if (col < 0 || col > 13) {
      throw new IllegalArgumentException("Wrong index");
    }
    return 30 + col * 50;
  }

  // generate the appropriate y position based on row
  int generateY(int row) {
    if (row < 0 || row > 4) {
      throw new IllegalArgumentException("Wrong index");
    }
    return 40 + row * 70;
  }

  // checks that the suit is valid
  String checkSuit(String suit) {
    if (suit.equals("♠") || suit.equals("♥") 
        || suit.equals("♦") || suit.equals("♣")) {
      return suit;
    }
    else {
      throw new IllegalArgumentException("Incorrect suit");
    }
  }

  // checks that the rank is a valid value
  int checkRank(int rank) {
    if (rank >= 0 && rank <= 13) {
      return rank;
    }
    else {
      throw new IllegalArgumentException("Incorrect rank");
    }
  }

  // generates a deck of cards
  ArrayList<Card> makeDeck() {
    // makes a local list that will store the deck
    ArrayList<Card> result = new ArrayList<Card>();

    // adds all suits for 1 rank value
    for (int curr = 1; curr < 14; curr++) {
      result.add(new Card(curr, "♠"));
      result.add(new Card(curr, "♥"));
      result.add(new Card(curr, "♦"));
      result.add(new Card(curr, "♣"));
    }

    // returns mutated list
    return result;
  }

  // makes a 1D ArrayList into a 4x13 2D ArrayList
  ArrayList<ArrayList<Card>> makeBoard(ArrayList<Card> deck) {
    // makes a local 2D list that will store the board
    ArrayList<ArrayList<Card>> result = new ArrayList<ArrayList<Card>>();

    // adds ArrayList<Deck> to the result
    for (int row = 0; row < 4; row++) {
      ArrayList<Card> temp = new ArrayList<Card>();
      for (int col = 0; col < 13; col++) {
        temp.add(deck.get(col));
      }
      result.add(temp);
      deck.removeAll(temp);
    }

    // returns mutated list
    return result;
  }

  // shuffles a list of cards
  ArrayList<Card> shuffle(ArrayList<Card> deck, Random rand) {
    // generates a random number and shifts cards accordingly
    for (int i = 0; i < deck.size(); i++) {
      int shiftBy = rand.nextInt(deck.size());
      Card card = deck.get(shiftBy);
      deck.set(shiftBy, deck.set(i, card));
    }

    // returns mutated deck
    return deck;
  }

  // Checks how many cards are face up in a board
  int countFaceUp(ArrayList<ArrayList<Card>> board) {
    int count = 0;
    for (int row = 0; row < board.size(); row++) {
      // gets the current row of cards
      ArrayList<Card> temp = board.get(row);

      for (int col = 0; col < temp.size(); col++) {
        if (temp.get(col).faceUp) {
          count += 1;
        }
      }
    }
    return count;
  }

  // check if the cards match, both in rank and suit color
  boolean checkCards(ArrayList<Card> cards) {
    Card card1 = cards.get(0);
    Card card2 = cards.get(1);
    if (card1.rank == card2.rank) {
      if (card1.suit.equals("♠")) {
        return card2.suit.equals("♣");
      }
      else if (card1.suit.equals("♣")) {
        return card2.suit.equals("♠");
      }
      else if (card1.suit.equals("♥")) {
        return card2.suit.equals("♦");
      }
      else {
        return card2.suit.equals("♥");
      }
    }
    else {
      return false;
    }
  }

  // draws the timer
  WorldImage drawTimer(int time) {
    return new OverlayImage(new TextImage("Time Elapsed: " + String.valueOf(time), Color.WHITE),
        new RectangleImage(160, 30, OutlineMode.SOLID, Color.BLUE));
  }

  // draws the move counter
  WorldImage drawMoves(int moves) {
    return new OverlayImage(new TextImage("Moves Counter: " + String.valueOf(moves), Color.WHITE),
        new RectangleImage(160, 30, OutlineMode.SOLID, Color.BLACK));
  }

  // draws the active cheat indicator
  WorldImage drawCheat(boolean cheat) {
    if (cheat) {
      return new OverlayImage(new TextImage("Cheat: ON", Color.WHITE),
          new RectangleImage(80, 30, OutlineMode.SOLID, Color.RED));
    }
    else {
      return new OverlayImage(new TextImage("Cheat: OFF", Color.WHITE),
          new RectangleImage(80, 30, OutlineMode.SOLID, Color.GREEN));
    }
  }
}