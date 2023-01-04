## ConcentrationGame

### Project Description:

A standard play of this game starts by shuffling a standard deck of 52 cards, and dealing them out into 4 rows of 13 cards, where each card is flipped face down.
The primary rule of the game is: The player exposes two cards. If they have the same value, the cards are taken out of the game play and the score is decreased by one. If they do not have the same value, they are flipped back to face down. The game is over when all of the matching pairs have been found.
The score of the game is the number of remaining pairs in the game. The goal of the game is to obtain the lowest score: a perfect zero means the player has found all of the pairs in the game. The player should be able to click on each card to flip it to face up. The player wins if all of the pairs have been found and the game ends. If the game has not ended, allow the use of the ‘r’ key to reset the game and create a new board.

Additional Features: 
- A timer keeping track of the seconds elapsed in game
- A move counter that tracks the number of pairs of cards chosen
- Game require player to match suit and rank (Hearts are matched with Diamonds and Spades with Clubs)
- Cheat ability that can be toggled by pressing 'h'
  - Shows all the previously clicked cards
  - Clicking is disabled while cheat mode is on
  - This can be toggled on and off

### How to play:

To play please do the following:
- Download all the files in the repository
- Add the .java files to your project folder
- Add the .jar files as external libraries to the project's classpath
- In your run configurations:
  - Under main, for your main class write: tester.Main
  - Under arguments, for your program arguments write: RunConcentration
- If you want to run all the tests, write the following for your program arguments:
  - RunConcentration
  - UtilsTests
  - GameTests
  - CardTests

Image of the game:

![Screen Shot 2021-12-23 at 2 32 36 PM](https://user-images.githubusercontent.com/89400862/147286259-f61221e7-d8ca-4371-93fd-edd4b83d433b.png)
![image](https://user-images.githubusercontent.com/89400862/210664526-11f0f500-fcce-4bf5-8ca2-72a32d247afa.png)
