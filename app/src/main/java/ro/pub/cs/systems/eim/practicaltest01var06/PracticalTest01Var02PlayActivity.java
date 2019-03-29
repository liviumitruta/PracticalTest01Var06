package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {

    private static int score = 0;
    private static int num = 0;
    private static int guess = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);
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

        TextView number_text = (TextView) findViewById(R.id.guessText);

        Intent intent = getIntent();
        if (intent != null) {
            String number = intent.getStringExtra("ro.pub.cs.systems.eim.practicaltest01var06.num");
            if (number != null) {
                num = Integer.valueOf(number);
            }
        }

        TextView score_field = (TextView) findViewById(R.id.scoreText);
        score_field.setText(Integer.toString(score));

        Button gen_button = (Button) findViewById(R.id.generate);
        gen_button.setOnClickListener(buttonClickListenerG);

        Button check_button = (Button) findViewById(R.id.check);
        check_button.setOnClickListener(buttonClickListenerS);

    }

    private ButtonClickListener buttonClickListenerG = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            Random r = new Random();
            TextView guessText = (TextView) findViewById(R.id.guessText);
            int val = r.nextInt(4);
            guess = val;
            guessText.setText(Integer.toString(val));
        }
    }


    private ButtonClickListenerS buttonClickListenerS = new ButtonClickListenerS();

    private class ButtonClickListenerS implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            if(guess == num) {
                score += 1;
                TextView score_field = (TextView) findViewById(R.id.scoreText);
                score_field.setText(Integer.toString(score));
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("guess", Integer.toString(guess));
        savedInstanceState.putString("score", Integer.toString(score));
        savedInstanceState.putString("num", Integer.toString(num));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("guess")) {
            TextView guess_field = (TextView)findViewById(R.id.guessText);
            guess = Integer.getInteger(savedInstanceState.getString("guess"));
            guess_field.setText(savedInstanceState.getString("guess"));
        }
        if (savedInstanceState.containsKey("score")) {
            TextView score_field = (TextView)findViewById(R.id.scoreText);
            score = Integer.getInteger(savedInstanceState.getString("score"));
            score_field.setText(savedInstanceState.getString("score"));
        }
        if (savedInstanceState.containsKey("num")) {
            num = Integer.getInteger(savedInstanceState.getString("num"));
        }
    }


}
