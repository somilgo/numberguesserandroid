package com.site11.somil.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public int trueVal;
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView thePrompt = (TextView) (findViewById(R.id.instruct));
        final Button subButton = (Button) (findViewById(R.id.enterButton));
        final EditText field = (EditText) (findViewById(R.id.editText));
        final int origcolor = thePrompt.getCurrentTextColor();

        trueVal = (int) (Math.random() * 100 + 1);
        counter = 0;

        subButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                if (subButton.getText().equals("New Game"))
                {
                    trueVal = (int) (Math.random() * 100 + 1);
                    subButton.setText(R.string.buttonText);
                    thePrompt.setText(R.string.prompt);
                    thePrompt.setTextColor(origcolor);
                    //thePrompt.setTextSize(30);
                }
                else {
                    int guessVal = Functions.tryParse((field.getText().toString()));
                    if (guessVal == -1) {
                        thePrompt.setText("Please input a valid number...");
                    } else if (guessVal < trueVal) {
                        thePrompt.setText("Higher...");
                        field.setText("");
                        counter++;
                    } else if (guessVal > trueVal) {
                        thePrompt.setText("Lower...");
                        field.setText("");
                        counter++;
                    } else {
                        counter++;
                        thePrompt.setText("You guessed it in " + counter  + " guesses!");
                        thePrompt.setTextColor(Color.rgb(255, 94, 94));
                        //thePrompt.setTextSize(50);
                        field.setText("");
                        subButton.setText("New Game");
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
