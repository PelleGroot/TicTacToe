package nl.pellegroot.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public int row;
    public int column;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Game game = new Game();

    public void tileClicked(View view){

        // find the id of the button is clicked
        int id = view.getId();
        Button button = (Button) findViewById(id);

        // find the tag of the clicked button
        String ButTag = button.getTag().toString();

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
//        Log.d("button", "tileClicked: " + ButTag + " " + row + " " + column + " " + view.findViewWithTag(ButTag));

        // draw
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

                break;
        }
    }

    public void resetClicked(View view){
        game = new Game();
        // reset UI
//        for(int i=1; i<10; i++){
//            String ButTag = ("But" + i);
//            Button button = view.findViewWithTag(ButTag);
//            button.setText(" ");
//        }
    }


}