import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFourGUI {

    public static final int ROWS = ConnectFour.ROWS;
    public static final int COLUMNS = ConnectFour.COLUMNS;

    public static final Color PLAYER1 = ConnectFour.PLAYER1;
    public static final Color PLAYER2 = ConnectFour.PLAYER2;
    public static final Color NONE = ConnectFour.NONE;
    public static final Color BOARD_COLOR = Color.BLUE;
//  previous results of games
    public static int record1 = ConnectFour.record1;
    public static int record2 = ConnectFour.record2;
    
    // GUI components
    private final JFrame boardFrame;
    private final BoardPanel boardPanel;
    private final JLabel statusLabel;
    
    private Color[][] board;
    private Color currentPlayer;

//    Construct and display GUI.
    public static void showGUI(final Color[][] board,
                               final Color firstPlayer) {
        // For thread safety, invoke GUI code on event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ConnectFourGUI gui =
                        new ConnectFourGUI(board, firstPlayer);
                gui.startGame();
            }
        });
    }
    
    
//     GUI Constructor 
    ConnectFourGUI(Color[][] board, Color player) {
        this.board = board;
        this.currentPlayer = player;
        boardFrame = new JFrame();
        boardFrame.setTitle("Connect Four");

        boardPanel = new BoardPanel();
        boardPanel.setPreferredSize( new Dimension(700, 600) );
        boardPanel.addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( MouseEvent e ) {
                int x = e.getX();
                int y = e.getY();
                doMouseClick(x, y);
            }
        });

        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel();
        JButton RecordButton=new JButton("Record");
        JButton ResetButton=new JButton("Reset");
        
        statusPanel.add(RecordButton);
        statusPanel.add(ResetButton);
        
//        if click the reset button, the game be initialed
        ResetButton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){
            	Color[][] board = new Color[ROWS][COLUMNS];
            	board=ConnectFour.initialBoard();
        		ConnectFourGUI.showGUI(board, PLAYER1); 
        	        }  
        	    });  
//        if click the record button, it will show the record of previous game
        RecordButton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){
        		JOptionPane.showMessageDialog ( null, "Player1 WinRecord: "+record1+"\n"+
        	"Player2 WinRecord: "+record2+"\n","Record Board",
                        JOptionPane.INFORMATION_MESSAGE );
        	}
        });
        
        statusPanel.add(statusLabel);
        updateStatusLabel();

        boardFrame.add(boardPanel, BorderLayout.CENTER);
        boardFrame.add(statusPanel, BorderLayout.PAGE_END);

        boardFrame.pack();
        boardFrame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        boardFrame.setLocationRelativeTo (null);
        boardFrame.setVisible (true);
    }

//    draw the board
    private class BoardPanel extends JPanel {

        public BoardPanel() {
            setBackground(BOARD_COLOR);
        }

        public int getRowHeight() {
            return getHeight() / ConnectFour.ROWS;
        }

        public int getColumnWidth() {
            return getWidth() / ConnectFour.COLUMNS;
        }

        public void paintComponent( Graphics g ) {
            super.paintComponent(g);

            int rowHeight = getRowHeight();
            int colWidth = getColumnWidth();
            int i = rowHeight / 8;
            int j = colWidth / 8;

            for(int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLUMNS; col++) {
                    g.setColor(board[ROWS-row-1][col]);
                    g.fillOval( col * colWidth + j,
                            row * rowHeight + i,
                            colWidth - 2*j,
                            rowHeight - 2*i);
                }
            }
        }
    }

//    if mouse click on the board
    private void doMouseClick(int x, int y) {
        int column = x / boardPanel.getColumnWidth();

            if( ConnectFour.isLegal(board, column) ) {
                putPiece(column);
            } else {
                System.out.println("player attempted illegal move at column " + column);
            }

    }

//    Put a piece for the current player in the given column and repaint the board
    private void putPiece(int column) {
        ConnectFour.put(board, currentPlayer,column);
        currentPlayer = ConnectFour.nextplayer(currentPlayer);
        boardFrame.repaint();

        checkForWin();
    }


//  See if anyone has won and announce it if someone have
    private void checkForWin() {
        statusLabel.setText("Checking for win...");

        // Checking for win may take some time, so use background
        // thread to keep GUI from locking up.
        SwingWorker<Color, Object> worker = new SwingWorker<Color, Object>() {
            public Color doInBackground() {
                return ConnectFour.winner(board);
            }

            protected void done() {
                Color winner = null;
                try {
                    winner = get();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                boolean gameOver = true;
                if( winner == PLAYER1 ) {
                    statusLabel.setText("Game over: Player1 Wins!");
                    JOptionPane.showMessageDialog ( null, "Player1 Wins!", "Game Over",
                            JOptionPane.INFORMATION_MESSAGE );
                    record1++;
                } else if( winner == PLAYER2 ) {
                    statusLabel.setText("Game over: Player2 Wins!");
                    JOptionPane.showMessageDialog ( null, "Player2 Wins!", "Game Over",
                            JOptionPane.INFORMATION_MESSAGE );
                    record2++;
                } else if (ConnectFour.isfull(board)) {
                    statusLabel.setText("Game over: Draw");
                    JOptionPane.showMessageDialog ( null, "Draw Game!", "Game Over",
                            JOptionPane.INFORMATION_MESSAGE );
                } else {
                    gameOver = false;
                    updateStatusLabel();
                }

                if(gameOver) {
                	Color[][] board = new Color[ROWS][COLUMNS];
                	board=ConnectFour.initialBoard();
            		ConnectFourGUI.showGUI(board, PLAYER1);
                }
                else if(currentPlayer == ConnectFour.nextplayer(currentPlayer)) ;
            }
        };
        worker.execute();
    }

//to mention which player will move
    private void updateStatusLabel() {
        if(currentPlayer == PLAYER1) {
            statusLabel.setText("Player1's turn");
        } else if(currentPlayer == PLAYER2) {
            statusLabel.setText("Player2's turn");
        } else{
        	statusLabel.setText("error");
        }
    }

//start the game
    private void startGame() {
        checkForWin();
    }

}