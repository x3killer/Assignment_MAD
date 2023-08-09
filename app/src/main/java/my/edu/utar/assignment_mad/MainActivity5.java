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

public class MainActivity5 extends AppCompatActivity {

    private TextView resultn;
    private TextView result;
    private ImageButton save;
    private Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main5);

        resultn = findViewById(R.id.rn1);
        result = findViewById(R.id.r1);
        save = findViewById(R.id.IB1);
        share = findViewById(R.id.share2);

        Intent nxtp = getIntent();
        float amount = nxtp.getFloatExtra("Total Amount of Bill: RM", 0);
        String result5 = (String) nxtp.getSerializableExtra("pass");


        resultn.setText("Total amount of Bill is: RM" + String.format("%.2f", amount));
        result.setText(result5);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("SharePref",MODE_PRIVATE);
                SharedPreferences.Editor prefeditor = pref.edit();
                prefeditor.putString("Total",String.format("%.2f", amount));
                prefeditor.putString("p" , result5);
                prefeditor.commit();
            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,result5);
                intent.setType("text/plain");


                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
            }
        });


    }
}