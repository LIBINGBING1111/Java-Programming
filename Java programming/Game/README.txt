1.Players:
There are 2 players required in this game. The player1 which plays red will make the first move, and the player2 which plays yellow will make the second move. Player 1 and player2 will play ,taking turns. 
2.How to play:
If it¡¯s anyone¡¯s turn, this player can make his or her move. The specific rule is that this player click any columns of the board, and the color of this player will drop to the top of this particular column. If one make a move to a full column, it will mention that ¡°player attempted illegal move at column X¡±
3.Outcomes:
There are three outcomes of one round: player1 wins, player2 wins and draw game.
If anyone becomes the first to connect four of one¡¯s own color next to other vertically, horizontally, or diagonally, the player will win. The game will end.
4.Important functionality
There is a status at the bottom of the board says ¡°player1¡¯s turn¡± or ¡°player2¡¯s turn¡±. The players can be told whose turn it is now.
There is reset button at the bottom of the board, if one clicks on it, it will start a new game.
There is record button at the bottom of the board, it will show the previous results of these two players.
5.test for each class
There are two variables I use in the test part: passed test and total test, and also a variable count ,it will get 1 when pass a test. The function I use are:
testConstants() to Make sure the constants in ConnectFour.java are as theyshould be.
testnextplayer() to test the performance nextplayer() in ConnectFour
testput() to test the performance of put() in ConnectFour
testisLegal() to test the performance of isLeagal() in ConnectFour
testisFull() to test the performance of isFull() in ConnectFour
testHorizontalWinner(), testVerticalWinner(), testDiagonalWinner1(), testDiagonalWinner2() are the test for three ways one can win.
