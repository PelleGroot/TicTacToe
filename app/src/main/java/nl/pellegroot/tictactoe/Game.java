package nl.pellegroot.tictactoe;

public class Game {
    final private int BOARD_SIZE = 3;
    private GameTile[][] board;

    public Boolean playerOneTurn; // if true, player 1's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        board = new GameTile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = GameTile.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public GameTile draw(int row, int column){
        if (board[row][column] == GameTile.BLANK){
            if (playerOneTurn){
                playerOneTurn = false;
                return GameTile.CROSS;
            }
            else{
                playerOneTurn = true;
                return GameTile.CIRCLE;
            }
        }
        else{
            return GameTile.INVALID;
        }
    }
}