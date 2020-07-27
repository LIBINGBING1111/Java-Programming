
import java.awt.Color;


public class ConnectFour {
	
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    public static final Color PLAYER1 = Color.RED;
    public static final Color PLAYER2 = Color.YELLOW;
    public static final Color NONE = Color.WHITE;
//    previous results of games
    public static int record1 = 0;
	public static int record2 = 0;

	
//put a color into the board on the top of a given column
    public static void put(Color[][] board, Color color, int column) {

        for(int i = 0; i < ROWS; i++) {
            if(board[i][column] == NONE) {
                board[i][column] = color;
                break;
            }
        }
    }

//check if the board is full
    public static boolean isfull(Color[][] board) {
        for(int c = 0; c < COLUMNS; c++) {
            if(board[ROWS-1][c] == NONE) {
                return false;
            }
        }
        return true;
    }

//  check if it is a legal move
    public static boolean isLegal(java.awt.Color[][] board, int column) {
        return column >= 0 && column < COLUMNS && board[ROWS-1][column] == NONE;
    }

//  return the color for the opponent
    public static Color nextplayer(java.awt.Color color) {
        return color == PLAYER1 ? PLAYER2 : PLAYER1;
    }


//    Check for a win starting at a given location and heading in a given direction
    public static Color winAt(Color[][] board, int r, int c,
                              int i, int j) {
        Color possible = board[r][c];
        int row, col, multiplier = 1;
        if(possible == NONE){
            return NONE;
        }
        do {
            if(multiplier == 4){
                return possible;
            }
            row = i * multiplier + r;
            col = j * multiplier + c;
            multiplier++;
        } while(row >= 0 && row < ROWS && col >= 0 && col < COLUMNS && board[row][col] == possible);
        return NONE;
    }



//Check the entire board for a win and return the color of the winner 
    public static Color winner(Color[][] board) {
        Color color;
        for (int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLUMNS; col++){
                // check all 8 directions
                for(int r_offset = -1; r_offset <= 1; r_offset++){
                    for(int c_offset = -1; c_offset <= 1; c_offset++){
                        if(!(r_offset == 0 && c_offset == 0)){
                            color = winAt(board, row, col, r_offset, c_offset);
                            if(color != NONE){
                                return color;
                            }
                        }
                    }
                }
            }
        }
        return NONE;
    }

    
// the look of the initial board, fill board with empty spaces
    public static Color[][] initialBoard() {
    	Color[][] board = new Color[ROWS][COLUMNS];
        for(int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = NONE;
            }
        }
        return board;
    }
    
//    Creates the initial board and starts game GUI
    public static void main(String[] args) {
    	Color[][] board = new Color[ROWS][COLUMNS];
    	board=initialBoard();

        // show the GUI and then start the game
        ConnectFourGUI.showGUI(board, PLAYER1);

    }


}