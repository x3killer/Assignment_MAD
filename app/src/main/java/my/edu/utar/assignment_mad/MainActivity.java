package my.edu.utar.assignment_mad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText tvTotalBillAmount;
    private EditText tvNumberOfPeople;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        tvTotalBillAmount = findViewById(R.id.tv1);
        tvNumberOfPeople = findViewById(R.id.tv2);
        btnCalculate = findViewById(R.id.btncal);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSplitBill();
            }
        });
    }

    private void calculateSplitBill() {
        String billAmountS = tvTotalBillAmount.getText().toString();
        billAmountS = billAmountS.replace("RM", "");
        String noPeople = tvNumberOfPeople.getText().toString();
        float billAmount = Float.parseFloat(billAmountS);
        int numberOfPeople = Integer.parseInt(noPeople);
        double splitAmount = billAmount / numberOfPeople;

        Intent nxt = new Intent(MainActivity.this,MainActivity4.class);
        nxt.putExtra("Total Amount of Bill: RM",billAmount);
        nxt.putExtra("Number of Person: ",numberOfPeople);
        nxt.putExtra("Each person needs to pay: RM" ,splitAmount);
        startActivity(nxt);
    }
}