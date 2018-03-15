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

        // retrieve and set the buttons clicked and textview
        Button button1 = (Button) findViewById(R.id.But1);
        Button button2 = (Button) findViewById(R.id.But2);
        Button button3 = (Button) findViewById(R.id.But3);
        Button button4 = (Button) findViewById(R.id.But4);
        Button button5 = (Button) findViewById(R.id.But5);
        Button button6 = (Button) findViewById(R.id.But6);
        Button button7 = (Button) findViewById(R.id.But7);
        Button button8 = (Button) findViewById(R.id.But8);
        Button button9 = (Button) findViewById(R.id.But9);
        TextView textView = (TextView) findViewById(R.id.textView1);

        button1.setText(inState.getString("BUT1"));
        button2.setText(inState.getString("BUT2"));
        button3.setText(inState.getString("BUT3"));
        button4.setText(inState.getString("BUT4"));
        button5.setText(inState.getString("BUT5"));
        button6.setText(inState.getString("BUT6"));
        button7.setText(inState.getString("BUT7"));
        button8.setText(inState.getString("BUT8"));
        button9.setText(inState.getString("BUT9"));
        textView.setText(inState.getString("TEXTVIEW"));
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        // save the gamestate
        outState.putSerializable("current", game);

        // save the buttons clicked and the textview
        Button button1 = (Button) findViewById(R.id.But1);
        Button button2 = (Button) findViewById(R.id.But2);
        Button button3 = (Button) findViewById(R.id.But3);
        Button button4 = (Button) findViewById(R.id.But4);
        Button button5 = (Button) findViewById(R.id.But5);
        Button button6 = (Button) findViewById(R.id.But6);
        Button button7 = (Button) findViewById(R.id.But7);
        Button button8 = (Button) findViewById(R.id.But8);
        Button button9 = (Button) findViewById(R.id.But9);
        TextView textView = (TextView) findViewById(R.id.textView1);

        outState.putString("BUT1", (button1.getText()).toString());
        outState.putString("BUT2", (button2.getText()).toString());
        outState.putString("BUT3", (button3.getText()).toString());
        outState.putString("BUT4", (button4.getText()).toString());
        outState.putString("BUT5", (button5.getText()).toString());
        outState.putString("BUT6", (button6.getText()).toString());
        outState.putString("BUT7", (button7.getText()).toString());
        outState.putString("BUT8", (button8.getText()).toString());
        outState.putString("BUT9", (button9.getText()).toString());
        outState.putString("TEXTVIEW", (textView.getText().toString()));
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