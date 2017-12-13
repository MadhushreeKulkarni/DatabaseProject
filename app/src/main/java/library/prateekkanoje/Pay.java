package library.prateekkanoje;

/**
 * Created by kanoj on 12/9/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pay extends AppCompatActivity {
    Button p1,p2,p3,p4;
    private static final String TAG ="Menu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        p1=(Button)findViewById(R.id.gb);
        p2=(Button)findViewById(R.id.card);
       p3=(Button)findViewById(R.id.cash);
        p4=(Button)findViewById(R.id.final_page);
       p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Toast.makeText(getBaseContext(), "Payment method is Goat bucks",
                        Toast.LENGTH_SHORT).show();
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Toast.makeText(getBaseContext(), "Payment method is card",
                        Toast.LENGTH_SHORT).show();
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Toast.makeText(getBaseContext(), "Payment method is cash",
                        Toast.LENGTH_SHORT).show();
            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Intent intent = new Intent(Pay.this,Thankyou.class);
                startActivity(intent);
            }
        });
    }
}
