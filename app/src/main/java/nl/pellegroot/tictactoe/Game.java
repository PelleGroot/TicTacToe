package nl.pellegroot.tictactoe;

import android.util.Log;

import java.io.Serializable;

public class Game implements Serializable{
    final private int BOARD_SIZE = 3;
    private GameTile[][] board;
    private Boolean playerOneTurn; // if true, player 1's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        // start a new game
        board = new GameTile[BOARD_SIZE][BOARD_SIZE];
        // create board of blank tiles
        for(int i=0; i<BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = GameTile.BLANK;
            }
        }
        // set game to in progress and give player one the turn
        playerOneTurn = true;
        gameOver = false;
    }

    public GameTile draw(int row, int column){
        // check if the clicked tile is empty
        if ((board[row][column] == GameTile.BLANK) && (!gameOver)){
            // write the tile to cross or circle depending on who's turn it is
            if (playerOneTurn){
                playerOneTurn = false;
                movesPlayed += 1;
                board[row][column] = GameTile.CROSS;
                return GameTile.CROSS;
            }
            else{
                playerOneTurn = true;
                movesPlayed += 1;
                board[row][column] = GameTile.CIRCLE;
                return GameTile.CIRCLE;
            }
        }
        // move is invalid
        else{
            return GameTile.INVALID;
        }
    }

    public GameState gameState(){
        // if player one wins
        if((board[0][0]== GameTile.CROSS && board[0][1] == GameTile.CROSS && board[0][2]== GameTile.CROSS)||
                (board[1][0]== GameTile.CROSS && board[1][1] == GameTile.CROSS && board[1][2]== GameTile.CROSS)||
                (board[2][0]== GameTile.CROSS && board[2][1] == GameTile.CROSS && board[2][2]== GameTile.CROSS)||
                (board[0][0]== GameTile.CROSS && board[1][0] == GameTile.CROSS && board[2][0]== GameTile.CROSS)||
                (board[0][1]== GameTile.CROSS && board[1][1] == GameTile.CROSS && board[2][1]== GameTile.CROSS)||
                (board[0][2]== GameTile.CROSS && board[1][2] == GameTile.CROSS && board[2][2]== GameTile.CROSS)||
                (board[0][0]== GameTile.CROSS && board[1][1] == GameTile.CROSS && board[2][2]== GameTile.CROSS)||
                (board[0][2]== GameTile.CROSS && board[1][1] == GameTile.CROSS && board[2][0]== GameTile.CROSS)){
//            Log.d("GameState", "PlayerOne");
            // end the game
            gameOver = true;
            return GameState.PLAYER_ONE;
        }
        // if player 2 wins
        else if((board[0][0]== GameTile.CIRCLE && board[0][1] == GameTile.CIRCLE && board[0][2]== GameTile.CIRCLE)||
                (board[1][0]== GameTile.CIRCLE && board[1][1] == GameTile.CIRCLE && board[1][2]== GameTile.CIRCLE)||
                (board[2][0]== GameTile.CIRCLE && board[2][1] == GameTile.CIRCLE && board[2][2]== GameTile.CIRCLE)||
                (board[0][0]== GameTile.CIRCLE && board[1][0] == GameTile.CIRCLE && board[2][0]== GameTile.CIRCLE)||
                (board[0][1]== GameTile.CIRCLE && board[1][1] == GameTile.CIRCLE && board[2][1]== GameTile.CIRCLE)||
                (board[0][2]== GameTile.CIRCLE && board[1][2] == GameTile.CIRCLE && board[2][2]== GameTile.CIRCLE)||
                (board[0][0]== GameTile.CIRCLE && board[1][1] == GameTile.CIRCLE && board[2][2]== GameTile.CIRCLE)||
                (board[0][2]== GameTile.CIRCLE && board[1][1] == GameTile.CIRCLE && board[2][0]== GameTile.CIRCLE)){
//            Log.d("GameState", "PlayerTwo");
            // end the game
            gameOver = true;
            return GameState.PLAYER_TWO;
        }
        // game is a draw
        else if (movesPlayed == 9){
            // end the game
            gameOver = true;
            return GameState.DRAW;
        }
        else {
            // game is in process
            return GameState.IN_PROGRESS;
        }
    }
}