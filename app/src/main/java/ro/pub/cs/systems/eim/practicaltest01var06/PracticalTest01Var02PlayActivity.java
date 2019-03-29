package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {

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
                number_text.setText(number);
            }
        }

        Button gen_button = (Button) findViewById(R.id.generate);
        gen_button.setOnClickListener(buttonClickListenerG);

    }

    private ButtonClickListener buttonClickListenerG = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            Random r = new Random();
            TextView guessText = (TextView) findViewById(R.id.guessText);
            int val = r.nextInt(10);
            guessText.setText(Integer.toString(val));
        }
    }



}
