import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldImage;
import tester.Tester;

// tests for the utils class
class UtilsTests {
  //constants for cards
  static int CARDW = 40;
  static int CARDH = 60;

  // cards for tests
  Utils util = new Utils();
  Card card1 = new Card(2, "♣");
  Card card2 = new Card(4, "♠");
  Card card3 = new Card(13, "♥");
  Card card4 = new Card(1, "♦");
  Card card5 = new Card(2, "♦");
  Card card6 = new Card(3, "♦");
  Card card7 = new Card(4, "♦");
  Card card8 = new Card(5, "♦");
  Card card9 = new Card(6, "♦");
  Card card10 = new Card(7, "♦");
  Card card11 = new Card(8, "♦");
  Card card12 = new Card(9, "♦");
  Card card13 = new Card(10, "♦");

  Card card1Up = new Card(2, "♣");
  Card card2Up = new Card(4, "♠");
  Card card3Up = new Card(13, "♥");
  Card card4Up = new Card(1, "♦");
  Card card5Up = new Card(2, "♦");
  Card card6Up = new Card(3, "♦");

  // cards to test generating a deck using utils
  Card card_spade1 = new Card(1, "♠");
  Card card_heart1 = new Card(1, "♥");
  Card card_diamond1 = new Card(1, "♦");
  Card card_club1 = new Card(1, "♣");

  Card card_spade2 = new Card(2, "♠");
  Card card_heart2 = new Card(2, "♥");
  Card card_diamond2 = new Card(2, "♦");
  Card card_club2 = new Card(2, "♣");

  Card card_spade3 = new Card(3, "♠");
  Card card_heart3 = new Card(3, "♥");
  Card card_diamond3 = new Card(3, "♦");
  Card card_club3 = new Card(3, "♣");

  Card card_spade4 = new Card(4, "♠");
  Card card_heart4 = new Card(4, "♥");
  Card card_diamond4 = new Card(4, "♦");
  Card card_club4 = new Card(4, "♣");

  Card card_spade5 = new Card(5, "♠");
  Card card_heart5 = new Card(5, "♥");
  Card card_diamond5 = new Card(5, "♦");
  Card card_club5 = new Card(5, "♣");

  Card card_spade6 = new Card(6, "♠");
  Card card_heart6 = new Card(6, "♥");
  Card card_diamond6 = new Card(6, "♦");
  Card card_club6 = new Card(6, "♣");

  Card card_spade7 = new Card(7, "♠");
  Card card_heart7 = new Card(7, "♥");
  Card card_diamond7 = new Card(7, "♦");
  Card card_club7 = new Card(7, "♣");

  Card card_spade8 = new Card(8, "♠");
  Card card_heart8 = new Card(8, "♥");
  Card card_diamond8 = new Card(8, "♦");
  Card card_club8 = new Card(8, "♣");

  Card card_spade9 = new Card(9, "♠");
  Card card_heart9 = new Card(9, "♥");
  Card card_diamond9 = new Card(9, "♦");
  Card card_club9 = new Card(9, "♣");

  Card card_spade10 = new Card(10, "♠");
  Card card_heart10 = new Card(10, "♥");
  Card card_diamond10 = new Card(10, "♦");
  Card card_club10 = new Card(10, "♣");

  Card card_spade11 = new Card(11, "♠");
  Card card_heart11 = new Card(11, "♥");
  Card card_diamond11 = new Card(11, "♦");
  Card card_club11 = new Card(11, "♣");

  Card card_spade12 = new Card(12, "♠");
  Card card_heart12 = new Card(12, "♥");
  Card card_diamond12 = new Card(12, "♦");
  Card card_club12 = new Card(12, "♣");

  Card card_spade13 = new Card(13, "♠");
  Card card_heart13 = new Card(13, "♥");
  Card card_diamond13 = new Card(13, "♦");
  Card card_club13 = new Card(13, "♣");

  // ArrayList to test card matches
  ArrayList<Card> pair1 = new ArrayList<Card>(Arrays.asList(this.card_heart10, 
      this.card_diamond10));
  ArrayList<Card> pair2 = new ArrayList<Card>(Arrays.asList(this.card_diamond5, 
      this.card_heart5));
  ArrayList<Card> pair3 = new ArrayList<Card>(Arrays.asList(this.card_club13, 
      this.card_spade13));
  ArrayList<Card> pair4 = new ArrayList<Card>(Arrays.asList(this.card_spade1, 
      this.card_club1));
  ArrayList<Card> pair5 = new ArrayList<Card>(Arrays.asList(this.card_diamond11, 
      this.card_spade4));
  ArrayList<Card> pair6 = new ArrayList<Card>(Arrays.asList(this.card_spade1, 
      this.card_heart1));

  // Arrays for the board
  ArrayList<Card> row1 = new ArrayList<Card>(Arrays.asList(this.card_spade1,
      this.card_heart1, this.card_diamond1, this.card_club1, this.card_spade2,
      this.card_heart2, this.card_diamond2, this.card_club2, this.card_spade3,
      this.card_heart3, this.card_diamond3, this.card_club3, this.card_spade4));
  ArrayList<Card> row2 = new ArrayList<Card>(Arrays.asList(this.card_heart4, 
      this.card_diamond4, this.card_club4, this.card_spade5, this.card_heart5, 
      this.card_diamond5, this.card_club5, this.card_spade6, this.card_heart6, 
      this.card_diamond6, this.card_club6, this.card_spade7,this.card_heart7));
  ArrayList<Card> row3 = new ArrayList<Card>(Arrays.asList(this.card_diamond7, 
      this.card_club7, this.card_spade8, this.card_heart8, this.card_diamond8, 
      this.card_club8, this.card_spade9, this.card_heart9, this.card_diamond9, 
      this.card_club9, this.card_spade10, this.card_heart10,  this.card_diamond10));
  ArrayList<Card> row4 = new ArrayList<Card>(Arrays.asList(this.card_club10, 
      this.card_spade11, this.card_heart11, this.card_diamond11, this.card_club11, 
      this.card_spade12, this.card_heart12, this.card_diamond12, this.card_club12, 
      this.card_spade13, this.card_heart13, this.card_diamond13, this.card_club13));

  // Arrays for board with cards that are face up and face down
  ArrayList<Card> row01 = new ArrayList<Card>(Arrays.asList(this.card1Up, this.card2Up,
      this.card3Up));  
  ArrayList<Card> row02 = new ArrayList<Card>(Arrays.asList(this.card4Up, this.card5Up,
      this.card6Up));

  // array lists
  ArrayList<Card> deck;
  ArrayList<ArrayList<Card>> board;
  ArrayList<Card> deckForTest;
  ArrayList<Card> deckForTest2;
  ArrayList<ArrayList<Card>> board2;

  // Examples World Images
  WorldImage timer = new OverlayImage(new TextImage("Time Elapsed: " + "0", Color.WHITE),
      new RectangleImage(160, 30, OutlineMode.SOLID, Color.BLUE));
  WorldImage moves = new OverlayImage(new TextImage("Moves Counter: " + "1", Color.WHITE),
      new RectangleImage(160, 30, OutlineMode.SOLID, Color.BLACK));
  WorldImage ctrue = new OverlayImage(new TextImage("Cheat: ON", Color.WHITE),
      new RectangleImage(80, 30, OutlineMode.SOLID, Color.RED));
  WorldImage cfalse = new OverlayImage(new TextImage("Cheat: OFF", Color.WHITE),
      new RectangleImage(80, 30, OutlineMode.SOLID, Color.GREEN));

  // sets the initial condition for the 52 card deck and arrays
  void init() {
    // ArrayList with all 52 cards
    this.deck = new ArrayList<Card>(Arrays.asList(this.card_spade1,
        this.card_heart1, this.card_diamond1, this.card_club1, this.card_spade2,
        this.card_heart2, this.card_diamond2, this.card_club2, this.card_spade3,
        this.card_heart3, this.card_diamond3, this.card_club3, this.card_spade4,
        this.card_heart4, this.card_diamond4, this.card_club4, this.card_spade5,
        this.card_heart5, this.card_diamond5, this.card_club5, this.card_spade6,
        this.card_heart6, this.card_diamond6, this.card_club6, this.card_spade7,
        this.card_heart7, this.card_diamond7, this.card_club7, this.card_spade8,
        this.card_heart8, this.card_diamond8, this.card_club8, this.card_spade9,
        this.card_heart9, this.card_diamond9, this.card_club9, this.card_spade10,
        this.card_heart10, this.card_diamond10, this.card_club10, this.card_spade11,
        this.card_heart11, this.card_diamond11, this.card_club11, this.card_spade12,
        this.card_heart12, this.card_diamond12, this.card_club12, this.card_spade13,
        this.card_heart13, this.card_diamond13, this.card_club13));

    // 2D ArrayList Representing a board
    this.board = new ArrayList<ArrayList<Card>>(Arrays.asList(this.row1,
        this.row2, this.row3, this.row4));

    // 2D Array List for a 2 by 3 board
    this.card1Up.faceUp = true;
    this.card3Up.faceUp = true;
    this.card4Up.faceUp = true;
    this.board2 = new ArrayList<ArrayList<Card>>(Arrays.asList(this.row01, 
        this.row02));
  }

  // condition for before and after a deck is shuffled
  void shuffledDeck() {
    this.deckForTest2 = new ArrayList<Card>(Arrays.asList(this.card1, this.card5, 
        this.card8, this.card10, this.card9, this.card12, this.card3, this.card4, 
        this.card7, this.card11, this.card6, this.card13, this.card2));
    this.deckForTest = new ArrayList<Card>(Arrays.asList(this.card1, this.card2, 
        this.card3, this.card4, this.card5, this.card6, this.card7, this.card8, 
        this.card9, this.card10, this.card11, this.card12, this.card13));
  }

  // test drawTimer, drawCheat, drawMoves
  void testDraws(Tester t) {
    t.checkExpect(this.util.drawTimer(0), this.timer);
    t.checkExpect(this.util.drawCheat(false), this.cfalse);
    t.checkExpect(this.util.drawCheat(true), this.ctrue);
    t.checkExpect(this.util.drawMoves(1), this.moves);
  }

  // test setColor
  void testSetColor(Tester t) {
    t.checkExpect(this.util.setColor(this.card1), Color.black);
    t.checkExpect(this.util.setColor(this.card2), Color.black);
    t.checkExpect(this.util.setColor(this.card3), Color.red);
    t.checkExpect(this.util.setColor(this.card4), Color.red);
  }

  // test generateX and generateY
  void testGeneratePos(Tester t) {
    t.checkExpect(this.util.generateX(0), 30);
    t.checkExpect(this.util.generateX(4), 230);
    t.checkExpect(this.util.generateY(1), 110);
    t.checkExpect(this.util.generateY(0), 40);
    t.checkException(new IllegalArgumentException("Wrong index"), new Utils(), "generateX", -1);
    t.checkException(new IllegalArgumentException("Wrong index"), new Utils(), "generateX", 14);
    t.checkException(new IllegalArgumentException("Wrong index"), new Utils(), "generateY", -1);
    t.checkException(new IllegalArgumentException("Wrong index"), new Utils(), "generateY", 5);
  }

  // test makeDeck
  void testMakeDeck(Tester t) {
    this.init();
    t.checkExpect(this.util.makeDeck(), this.deck);
  }

  // test makeBoard
  void testMakeBoard(Tester t) {
    this.init();
    t.checkExpect(this.util.makeBoard(this.deck), this.board);
  }

  // test shuffle
  void testShuffle(Tester t) {
    this.shuffledDeck();
    t.checkExpect(new Utils().shuffle(this.deckForTest, new Random(1)), this.deckForTest2);
  }

  // test for the Card constructor
  void testCardsConstructor(Tester t) {
    t.checkConstructorException(new IllegalArgumentException("Incorrect suit"), "Card", 2, "hola");
    t.checkConstructorException(new IllegalArgumentException("Incorrect rank"), "Card", -1, "♠");
    t.checkConstructorException(new IllegalArgumentException("Incorrect rank"), "Card", 20, "♠");
  }

  // test checkCards
  void testCheckCards(Tester t) {
    t.checkExpect(new Utils().checkCards(this.pair1), true);
    t.checkExpect(new Utils().checkCards(this.pair2), true);
    t.checkExpect(new Utils().checkCards(this.pair3), true);
    t.checkExpect(new Utils().checkCards(this.pair4), true);
    t.checkExpect(new Utils().checkCards(this.pair5), false);
    t.checkExpect(new Utils().checkCards(this.pair6), false);
  }

  // test countFaceUp
  void testCountFaceUp(Tester t) {
    this.init();
    t.checkExpect(new Utils().countFaceUp(this.board), 0);
    t.checkExpect(new Utils().countFaceUp(this.board2), 3);
  }
}