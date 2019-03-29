package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var03ChooseNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_choose_number);
        Button play_button = (Button) findViewById(R.id.play_button);
        play_button.setOnClickListener(buttonClickListener);
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText numberText = (EditText) findViewById(R.id.number_text);
            String content = numberText.getText().toString();
            if(isNumeric((content))) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
                intent.putExtra("ro.pub.cs.systems.eim.practicaltest01var06.num", numberText.getText().toString());
                startActivity(intent);
            }
        }
    }

}
