package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
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

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText numberText = (EditText) findViewById(R.id.number_text);
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
            intent.setData(Uri.parse("num:" + numberText.getText().toString()));
            startActivity(intent);
        }
    }

}
