import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javalib.impworld.WorldScene;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldImage;
import tester.Tester;

class GameTests {
  //constants
  static int CARDW = 40;
  static int CARDH = 60;

  // Examples of 2d Array for testing
  Card card1;
  Card card2;
  Card card3;
  Card card4;
  Card card5;
  Card card6;
  Card card7;
  Card card8;
  Card card9 = new Card(2, "♣");
  Card card0;
  Card card10;
  Card card11;


  // Images for cards -- cards 1-4
  WorldImage card1img = new OverlayImage(new TextImage("2♣", Color.black),
      new RectangleImage(CARDW, 
          CARDH, OutlineMode.OUTLINE, Color.gray));
  WorldImage card2img = new OverlayImage(new TextImage("4♠", Color.black),
      new RectangleImage(CARDW, 
          CARDH, OutlineMode.OUTLINE, Color.gray));
  WorldImage card3img = new OverlayImage(new TextImage("13♥", Color.red),
      new RectangleImage(CARDW, 
          CARDH, OutlineMode.OUTLINE, Color.gray));
  WorldImage card4img = new OverlayImage(new TextImage("1♦", Color.red),
      new RectangleImage(CARDW, 
          CARDH, OutlineMode.OUTLINE, Color.gray));

  //Images for cards -- cards 5-8
  WorldImage card5img = new OverlayImage(new RectangleImage(CARDW, 
      CARDH, OutlineMode.SOLID, Color.gray), 
      new OverlayImage(new TextImage("6♠", Color.black),
          new RectangleImage(CARDW, CARDH, 
              OutlineMode.OUTLINE, Color.gray)));
  WorldImage card6img = new OverlayImage(new RectangleImage(CARDW, 
      CARDH, OutlineMode.SOLID, Color.gray), 
      new OverlayImage(new TextImage("2♥", Color.red),
          new RectangleImage(CARDW, CARDH, 
              OutlineMode.OUTLINE, Color.gray)));
  WorldImage card7img = new OverlayImage(new RectangleImage(CARDW, 
      CARDH, OutlineMode.SOLID, Color.gray), 
      new OverlayImage(new TextImage("10♦", Color.red),
          new RectangleImage(CARDW, CARDH, 
              OutlineMode.OUTLINE, Color.gray)));
  WorldImage card8img = new OverlayImage(new RectangleImage(CARDW, 
      CARDH, OutlineMode.SOLID, Color.gray), 
      new OverlayImage(new TextImage("2♣", Color.black),
          new RectangleImage(CARDW, CARDH, 
              OutlineMode.OUTLINE, Color.gray)));

  // WordScene with all the cards place on it
  WorldScene ws;
  WorldScene end;

  // ArrayLists
  ArrayList<Card> row1; 
  ArrayList<Card> row2;
  ArrayList<Card> rowtest;
  ArrayList<ArrayList<Card>> testBoard;
  ArrayList<ArrayList<Card>> testBoard1;
  ArrayList<ArrayList<Card>> noShuffleBoard;

  // ConcentrationGame Examples
  ConcentrationGame game1;
  ConcentrationGame game2;
  ConcentrationGame game3;

  // initialize cards and Arrays
  void init() {
    this.card0 = new Card(2, "♣");
    this.card1 = new Card(2, "♣");
    this.card2 = new Card(4, "♠");
    this.card3 = new Card(13, "♥");
    this.card4 = new Card(1, "♦");
    this.card5 = new Card(6, "♠");
    this.card6 = new Card(2, "♥");
    this.card7 = new Card(10, "♦");
    this.card8 = new Card(2, "♣");
    this.card9.faceUp = true;
    this.card10 = new Card(10, "♥");
    this.card11 = new Card(10, "♥");
    this.card11.selected = true;
    this.card11.faceUp = true;
    this.rowtest = new ArrayList<Card>(Arrays.asList(this.card10, this.card11));
    this.row1 = new ArrayList<Card>(Arrays.asList(this.card1, this.card2, 
        this.card3, this.card4)); 
    this.row2 = new ArrayList<Card>(Arrays.asList(this.card5, this.card6, 
        this.card7, this.card8));
    this.testBoard = new ArrayList<ArrayList<Card>>(
        Arrays.asList(this.row1, this.row2));
    this.testBoard1 = new ArrayList<ArrayList<Card>>(
        Arrays.asList(this.rowtest));
    this.game2 = new ConcentrationGame(this.testBoard);
    this.game2.prevPicked.add(this.card1);
    this.card0.faceUp = true;
    this.game3 = new ConcentrationGame(this.testBoard1);
    this.game1 = new ConcentrationGame(new Utils().makeBoard(
        new Utils().makeDeck()));
    this.noShuffleBoard = new Utils().makeBoard(new Utils().makeDeck());
  }

  // initialize cards faceUp or faceDown 
  void initCards() {
    this.card1.faceUp = true;
    this.card2.faceUp = true;
    this.card3.faceUp = true;
    this.card4.faceUp = true;
    this.card5.faceUp = false;
    this.card6.faceUp = false;
    this.card7.faceUp = false;
    this.card8.faceUp = false; 
  }

  // places cards on the WorldScene
  void initWorld() {
    this.game1 = new ConcentrationGame(new Utils().makeBoard(
        new Utils().makeDeck()));
    this.ws = new WorldScene(660, 330);
    this.ws.placeImageXY(this.card1img, 30, 40);
    this.ws.placeImageXY(this.card2img, 80, 40);
    this.ws.placeImageXY(this.card3img, 130, 40);
    this.ws.placeImageXY(this.card4img, 180, 40);
    this.ws.placeImageXY(this.card5img, 30, 110);
    this.ws.placeImageXY(this.card6img, 80, 110);
    this.ws.placeImageXY(this.card7img, 130, 110);
    this.ws.placeImageXY(this.card8img, 180, 110);
    this.ws.placeImageXY(new Utils().drawTimer(0), 580, 310);
    this.ws.placeImageXY(new Utils().drawCheat(false), 50, 310);
    this.ws.placeImageXY(new Utils().drawMoves(0), 330, 310);
    this.end = new WorldScene(660, 330);
    this.end.placeImageXY(new OverlayImage(new TextImage("Congratulations", Color.BLACK),
        new RectangleImage(400, 80, OutlineMode.SOLID, Color.GREEN)), 
        660 / 2, 330 / 2);
  }

  // test for mouse functionality
  void testOnMouseClicked(Tester t) {
    this.init();
    t.checkExpect(this.game3.cards.get(0).get(0), this.card10);
    this.game3.onMouseClicked(new Posn(20, 20));
    t.checkExpect(this.game3.cards.get(0).get(0), 
        this.card11);
  }

  // test onTick
  void testOnTick(Tester t) {
    this.init();
    t.checkExpect(this.game1.time, 0);
    this.game1.onTick();
    t.checkExpect(this.game1.time, 1);
  }

  // test lastScene()
  void testLastScene(Tester t) {
    this.initWorld();
    t.checkExpect(this.game1.lastScene("Congratulations"), this.end);
  }

  // test makeScene
  void testMakeScene(Tester t) {
    this.init();
    this.initCards();
    this.initWorld();
    t.checkExpect(new ConcentrationGame(this.testBoard).makeScene(), 
        this.ws);
  }

  // test onKeyEvent
  void testOnKeyEvent(Tester t) {
    this.init();
    t.checkExpect(this.game1.cards, this.noShuffleBoard);
    this.game1.onKeyEventTest("r");
    t.checkExpect(this.game1.cards, new Utils().makeBoard(new Utils().shuffle(
        new Utils().makeDeck(), new Random(1))));
    this.init();
    this.game1.onKeyEventTest("y");
    t.checkExpect(this.game1.cards, this.noShuffleBoard);
    this.game2.prevPicked.clear();
    this.init();
    this.game2.onKeyEventTest("h");
    t.checkExpect(this.game2.prevPicked.get(0), this.card0);
  }
}