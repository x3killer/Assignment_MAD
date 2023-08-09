package my.edu.utar.assignment_mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private EditText Percentage;
    private EditText Totalamount;
    private TextView fResult;
    private Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);
        Percentage = findViewById(R.id.et3);
        Totalamount = findViewById(R.id.et1);
        btnCal = findViewById(R.id.btnCal);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputPercentage = Percentage.getText().toString();
                inputPercentage = inputPercentage.replace("%","");
                String[] arrayPercent = inputPercentage.split(",");


                String amount = Totalamount.getText().toString();
                amount = amount.replace("RM","");
                float bAmount = Float.parseFloat(amount);
                double totalPercentage = 0.0;
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < arrayPercent.length; i++) {
                    String item = arrayPercent[i];
                    float bill = bAmount*(Float.parseFloat(item)/100);
                    result.append("Person ").append(i + 1).append(": RM").append(String.format("%.2f", bill)).append("\n");
                    totalPercentage += Double.parseDouble(item);
                }



                Intent nxt = new Intent(MainActivity3.this,MainActivity5.class);
                nxt.putExtra("Total Amount of Bill: RM",bAmount);
                nxt.putExtra("pass", (Serializable) result);
                startActivity(nxt);

            }

        });
    }
}

