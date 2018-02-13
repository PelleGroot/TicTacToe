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

        int id = view.getId();
        Button button = (Button) findViewById(id);
        String idName = button.getText().toString();
        switch(idName){
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
        Log.d("button", "tileClicked: " + idName + " " + row + " " + column);

      GameTile tile = game.draw(row, column);

        switch(tile) {
            case CROSS:
                // do something;
                break;
            case CIRCLE:
                // do something
                break;
            case INVALID:
                //do something
                break;
        }
    }

    public void resetClicked(){
       game = new Game();

    }


}
