package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int enterNumber;

    EditText numberInput;

    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = (EditText) findViewById(R.id.numberInput);

        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNumber = Integer.valueOf(numberInput.getText().toString());
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void onButtonClick(View view){
        TextView randomNumber = this.findViewById(R.id.HelloWorldTextView);
        Random r = new Random();
        int number = r.nextInt(6);
        randomNumber.setText(Integer.toString(number));
        //set score as 0
        int Score = 0;
        TextView congratsMessage = this.findViewById(R.id.congratulationsTextView);
        //TextView scoreView = this.findViewById(R.id.scoreTextView);
        if(enterNumber == number)
        {
            Score = Score + 1;
            congratsMessage.setText("Congratulations!");
            //scoreView.setText(Score);
        }
        else
        {
            congratsMessage.setText("Better luck next time :(");
            //scoreView.setText(Score);
        }

    }
/*
    public void shareMessage (View view) {
        String inputedNumber = ((EditText) findViewById(R.id.numberText)).getText().toString();
        TextView randomNumber = this.findViewById(R.id.textView);
        if(inputedNumber = randomNumber)
        {
            //display congratulations
        }
    }

 */
}
