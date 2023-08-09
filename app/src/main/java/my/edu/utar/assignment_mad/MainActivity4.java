package my.edu.utar.assignment_mad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    private TextView resultp;
    private TextView resultn;
    private TextView result;
    private ImageButton save;
    private Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main4);

        resultp = findViewById(R.id.rp);
        resultn = findViewById(R.id.rn);
        result = findViewById(R.id.r);
        save = findViewById(R.id.IB);
        share = findViewById(R.id.share1);

        Intent nxtp = getIntent();
        float amount = nxtp.getFloatExtra("Total Amount of Bill: RM", 0);
        double split = nxtp.getDoubleExtra("Each person needs to pay: RM", 0);
        int noPeo = nxtp.getIntExtra("Number of Person: ", 0);


            resultn.setText("Number of Person: " + noPeo);
            resultp.setText("Total Amount of Bill: RM" + String.format("%.2f", amount));
            result.setText("Each person needs to pay: RM" + String.format("%.2f", split));


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("SharePref",MODE_PRIVATE);
                SharedPreferences.Editor prefeditor = pref.edit();
                prefeditor.putString("Total",String.format("%.2f", amount));
                prefeditor.putString("price" ,String.format("%.2f", split));
                prefeditor.commit();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String message="The amount you need to pay is: RM" + String.format("%.2f", split);
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("text/plain");


                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
            }
        });


    }
}