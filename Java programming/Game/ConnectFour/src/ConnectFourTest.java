public class ConnectFourTest {

    private static int passedTest = 0;
    private static int totalTests = 0;

    public static void testConstants() {
        count(ConnectFour.COLUMNS==7);
        count(ConnectFour.ROWS==6);
        count(ConnectFour.PLAYER2 != ConnectFour.PLAYER1);
        count(ConnectFour.PLAYER1 != ConnectFour.NONE);
        count(ConnectFour.NONE != ConnectFour.PLAYER2);
    }

    
    public static java.awt.Color[][] emptyBoard() {
        java.awt.Color[][] result =
                new java.awt.Color[ConnectFour.ROWS][ConnectFour.COLUMNS];
        for (int r = 0; r < result.length; r++) {
            for (int c = 0; c < result[r].length; c++) {
                result[r][c] = ConnectFour.NONE;
            }
        }
        return result;
    }

    public static void testnextplayer() {
        count(ConnectFour.PLAYER1 == ConnectFour.nextplayer(ConnectFour.PLAYER2));
        count(ConnectFour.PLAYER2 == ConnectFour.nextplayer(ConnectFour.PLAYER1));
    }

    public static void testput() {
        java.awt.Color[][] board = emptyBoard();
        ConnectFour.put(board, ConnectFour.PLAYER1, 3);
        count(ConnectFour.PLAYER1 == board[0][3]);
        ConnectFour.put(board, ConnectFour.PLAYER2, 3);
        count(ConnectFour.PLAYER2 == board[1][3]);
        count(ConnectFour.PLAYER1 == board[0][3]);
    }

    public static void testisLegal() {
        java.awt.Color[][] board = emptyBoard();
        count(!ConnectFour.isLegal(board, -1));
        count(!ConnectFour.isLegal(board, 7));
        count(ConnectFour.isLegal(board, 0));
        count(ConnectFour.isLegal(board, 1));
        count(ConnectFour.isLegal(board, 2));
        count(ConnectFour.isLegal(board, 3));
        count(ConnectFour.isLegal(board, 4));
        count(ConnectFour.isLegal(board, 5));
        count(ConnectFour.isLegal(board, 6));
        ConnectFour.put(board, ConnectFour.PLAYER2, 1);
        ConnectFour.put(board, ConnectFour.PLAYER1, 1);
        ConnectFour.put(board, ConnectFour.PLAYER2, 1);
        ConnectFour.put(board, ConnectFour.PLAYER1, 1);
        ConnectFour.put(board, ConnectFour.PLAYER2, 1);
        count(ConnectFour.isLegal(board, 1));
        ConnectFour.put(board, ConnectFour.PLAYER1, 1);
        count(!ConnectFour.isLegal(board, 1));
    }

    public static void testisFull() {
        java.awt.Color[][] board = emptyBoard();
        for (int r = 0; r < ConnectFour.ROWS; r++) {
            for (int c = 0; c < ConnectFour.COLUMNS; c++) {
                count(!ConnectFour.isfull(board));
                ConnectFour.put(board, ConnectFour.PLAYER2, c);
            }
        }
        count(ConnectFour.isfull(board));
    }

    public static void testHorizontalWinner() {
        java.awt.Color[][] board = emptyBoard();
        count(ConnectFour.NONE == ConnectFour.winner(board));
        for (int i = 2; i < 6; i++) {
            ConnectFour.put(board, ConnectFour.PLAYER2, i);
        }
        count(ConnectFour.PLAYER2 == ConnectFour.winner(board));
        count(ConnectFour.PLAYER2 == ConnectFour.winAt(board, 0, 2, 0, 1));
        count(ConnectFour.PLAYER2 == ConnectFour.winAt(board, 0, 5, 0, -1));
        count(ConnectFour.NONE == ConnectFour.winAt(board, 0, 1, 0, 1));
        count(ConnectFour.NONE == ConnectFour.winAt(board, 0, 3, 0, 1));
    }

    public static void testVerticalWinner() {
        java.awt.Color[][] board = emptyBoard();
        for (int i = 0; i < 4; i++) {
            ConnectFour.put(board, ConnectFour.PLAYER1, 6);
        }
        count(ConnectFour.PLAYER1 == ConnectFour.winner(board));
        count(ConnectFour.PLAYER1 == ConnectFour.winAt(board, 0, 6, 1, 0));
        count(ConnectFour.PLAYER1 == ConnectFour.winAt(board, 3, 6, -1, 0));
        count(ConnectFour.NONE == ConnectFour.winAt(board, 1, 6, 1, 0));
        count(ConnectFour.NONE == ConnectFour.winAt(board, 4, 6, -1, 0));
    }

    public static void testDiagonalWinner1() {
        java.awt.Color[][] board = emptyBoard();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                ConnectFour.put(board, ConnectFour.PLAYER1, i);
            }
            ConnectFour.put(board, ConnectFour.PLAYER2, i);
        }
        count(ConnectFour.PLAYER2 == ConnectFour.winner(board));
        count(ConnectFour.PLAYER2 == ConnectFour.winAt(board, 0, 0, 1, 1));
        count(ConnectFour.NONE == ConnectFour.winAt(board, 1, 1, 1, 1));
        count(ConnectFour.PLAYER2 == ConnectFour.winAt(board, 3, 3, -1, -1));
        count(ConnectFour.NONE == ConnectFour.winAt(board, 4, 4, -1, -1));    }

    public static void testDiagonalWinner2() {
        java.awt.Color[][] board = emptyBoard();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                ConnectFour.put(board, ConnectFour.PLAYER2, 5 - i);
            }
            ConnectFour.put(board, ConnectFour.PLAYER1, 5 - i);
        }
        count(ConnectFour.PLAYER1 == ConnectFour.winner(board));
        count(ConnectFour.PLAYER1 == ConnectFour.winAt(board, 0, 5, 1, -1));
        count(ConnectFour.NONE == ConnectFour.winAt(board, 1, 4, 1, -1));
        count(ConnectFour.PLAYER1 == ConnectFour.winAt(board, 3, 2, -1, 1));
        count(ConnectFour.NONE == ConnectFour.winAt(board, 4, 1, -1, 1));
    }

    private static void count(boolean i) {
        if(i) {
            passedTest++;
        } else {
            new Exception("Failed Test").printStackTrace();
        }
        totalTests++;
    }

    public static void main(String[] args) {
        clearCounts();
        testConstants();
        testnextplayer();
        testput();
        testisLegal();
        testisFull();
        testHorizontalWinner();
        testVerticalWinner();
        testDiagonalWinner1();
        testDiagonalWinner2();

        System.out.println("Passed " + passedTest + " out of " + totalTests + " tests.");
    }
    private static void clearCounts() {
        passedTest = 0;
        totalTests = 0;
    }
}