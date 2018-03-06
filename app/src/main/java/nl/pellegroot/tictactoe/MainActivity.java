package nl.pellegroot.tictactoe;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public int row;
    public int column;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public  void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        // create game
        if (inState == null){
             // create new game
            game = new Game();
        }
        else {
            // restore old game
            game = (Game) inState.getSerializable("current");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("current", game);
    }

    public void tileClicked(View view){

        // create textview
        TextView textview = (TextView) findViewById(R.id.textView1);

        // find the id of the button is clicked
        int id = view.getId();
        Button button = (Button) findViewById(id);

        // find the tag of the clicked button
        String ButTag = button.getTag().toString();
        Log.d("Before cases ", "tileClicked: " + ButTag);
        // set the row and column number of the clicked button
        switch(ButTag){
            case "But1":
                row = 0;
                column = 0;
                break;
            case "But2":
                row = 1;
                column = 0;
                break;
            case "But3":
                row = 2;
                column = 0;
                break;
            case "But4":
                row = 0;
                column = 1;
                break;
            case "But5":
                row = 1;
                column = 1;
                break;
            case "But6":
                row = 2;
                column = 1;
                break;
            case "But7":
                row = 0;
                column = 2;
                break;
            case "But8":
                row = 1;
                column = 2;
                break;
            case "But9":
                row = 2;
                column = 2;
                break;
        }
        Log.d("button", "tileClicked: " + ButTag + " " + row + " " + column);

        // draw the game
        GameTile tile = game.draw(row, column);

        switch(tile) {
            case CROSS:
                // switch current empty spot with an X
                button.setText("X");
                break;

            case CIRCLE:
                // switch current empty spot with an O
                button.setText("O");
                break;

            case INVALID:
                // move is invalid, show error?
                textview.setText("Invalid move");
                break;
        }
        GameState gamestate;
        // check the state of the game and write messages
        switch(gamestate = game.gameState()){
            case PLAYER_ONE:
                textview.setText("Player one wins!");
                break;
            case PLAYER_TWO:
                textview.setText("Player two wins!");
                break;
            case DRAW:
                textview.setText("It is a draw!");
                break;
            case IN_PROGRESS:
                break;
        }
        Log.d("Gamestate:", " " + gamestate);
    }

    private void clearButtonText(@IdRes int id) {
        // clear button method
        Button button = (Button) findViewById(id);
        button.setText("");
    }

    private void clearScreen() {
        // selects buttons to clear
        clearButtonText(R.id.But1);
        clearButtonText(R.id.But2);
        clearButtonText(R.id.But3);
        clearButtonText(R.id.But4);
        clearButtonText(R.id.But5);
        clearButtonText(R.id.But6);
        clearButtonText(R.id.But7);
        clearButtonText(R.id.But8);
        clearButtonText(R.id.But9);

        // clear the textview
        TextView textview = (TextView) findViewById(R.id.textView1);
        textview.setText("");
    }

    // to clean the whole screen
    public void resetClicked(View view){
        // create new game
        game = new Game();
        // reset UI
        this.clearScreen();
    }
}
// TODO: Figure out why the onClick all of a sudden doesn't work anymore