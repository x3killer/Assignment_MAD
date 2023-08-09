package my.edu.utar.assignment_mad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main6);

        result = findViewById(R.id.rn);

        SharedPreferences pref = getSharedPreferences("SharePref",MODE_PRIVATE);
        String amount = pref.getString("Total","N/A");
        String split = pref.getString("price","N/A");
        String loop = pref.getString("p","N/A");

        result.setText("Total Amount of Bill: RM " + amount
        + "\nEach person needs to pay: RM " + split + "\n"+loop);





    }
}