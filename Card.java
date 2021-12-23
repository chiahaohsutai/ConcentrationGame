import java.awt.Color;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldImage;
import tester.Tester;

//represents a card in a game
class Card {
  static int CARDW = 40;
  static int CARDH = 60;
  int rank;
  String suit;
  Color color;
  boolean faceUp;
  boolean matched;
  boolean selected;

  Card(int rank, String suit) {
    this.rank = new Utils().checkRank(rank);
    this.suit = new Utils().checkSuit(suit);
    this.color = new Utils().setColor(this);
    this.faceUp = false;
    this.matched = false;
    this.selected = false;
  }

  /* TEMPLATE:
   * fields:
   * ... this.rank     ... - int
   * ... this.suit     ... - String
   * ... this.color    ... - Color
   * ... this.faceUp   ... - boolean
   * ... this.matched  ... - boolean
   * ... this.selected ... - boolean
   * methods:
   * ... this.drawCard ... - WorldImage
   * ... this.inRange(int, int, Posn) ... boolean
   */

  // checks if a posn is within a cards range
  boolean inRange(int row, int col, Posn pos) { 
    return (pos.x >= 10 + 50 * col) && (pos.x <= 50 * (col + 1)) 
        && (pos.y >= 10 + 70 * row) && (pos.y <= 70 * (row + 1));
  }

  // draws a card
  WorldImage drawCard() {

    // overlays an object indicating the card has been matched and is no
    // longer in play
    if (this.matched) {
      return new OverlayImage(new RectangleImage(CARDW, 
          CARDH, OutlineMode.OUTLINE, Color.GREEN), 
          new OverlayImage(new TextImage(String.valueOf(rank) + this.suit, this.color),
              new RectangleImage(CARDW, CARDH, 
                  OutlineMode.OUTLINE, Color.gray)));
    }

    // draws the cards showing suit + rank, as well as an outline showing this
    // is currently selected
    else if (this.faceUp && this.selected) {
      return new OverlayImage(new RectangleImage(CARDW, 
          CARDH, OutlineMode.OUTLINE, Color.BLUE),
          new OverlayImage(new TextImage(String.valueOf(rank) + this.suit, this.color),
              new RectangleImage(CARDW, CARDH, 
                  OutlineMode.OUTLINE, Color.gray)));
    } 

    // draws the cards showing suit + rank 
    else if (this.faceUp) {
      return new OverlayImage(new TextImage(String.valueOf(rank) + this.suit, this.color),
          new RectangleImage(CARDW, CARDH, 
              OutlineMode.OUTLINE, Color.gray));
    } 

    // overlays an object on top of the card to hide the card, showing it is face down
    else {
      return new OverlayImage(new RectangleImage(CARDW, 
          CARDH, OutlineMode.SOLID, Color.gray), 
          new OverlayImage(new TextImage(String.valueOf(rank) + this.suit, this.color),
              new RectangleImage(CARDW, CARDH, 
                  OutlineMode.OUTLINE, Color.gray)));
    }
  }
} 

// tests for card class 
class CardTests {

  // constants for cards
  static int CARDW = 40;
  static int CARDH = 60;

  // Card Examples
  Card card1 = new Card(2, "♣");

  // Posn Examples
  // Position Examples
  Posn posOutRange = new Posn(0, 0);
  Posn posInRange = new Posn(20, 20);

  // test for InRange
  void testInRange(Tester t) {
    t.checkExpect(this.card1.inRange(0, 0, this.posInRange), true);
    t.checkExpect(this.card1.inRange(0, 0, this.posOutRange), false);
  }

  //test drawCard
  void testDrawCard(Tester t) {
    this.card1.faceUp = false;
    t.checkExpect(this.card1.drawCard(), new OverlayImage(new RectangleImage(CARDW, 
        CARDH, OutlineMode.SOLID, Color.gray), 
        new OverlayImage(new TextImage("2♣", Color.black),
            new RectangleImage(CARDW, CARDH, 
                OutlineMode.OUTLINE, Color.gray))));
    this.card1.faceUp = true;
    t.checkExpect(this.card1.drawCard(), new OverlayImage(new TextImage("2♣", Color.black),
        new RectangleImage(CARDW, CARDH, 
            OutlineMode.OUTLINE, Color.gray)));
    this.card1.faceUp = false;
    this.card1.matched = true;
    t.checkExpect(this.card1.drawCard(), new OverlayImage(new RectangleImage(CARDW, 
        CARDH, OutlineMode.OUTLINE, Color.GREEN), 
        new OverlayImage(new TextImage("2♣", Color.black),
            new RectangleImage(CARDW, CARDH, 
                OutlineMode.OUTLINE, Color.gray))));
    this.card1.matched = false;
  }
}