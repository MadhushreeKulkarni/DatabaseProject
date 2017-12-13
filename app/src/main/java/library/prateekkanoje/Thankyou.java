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
import android.widget.EditText;

public class Thankyou extends AppCompatActivity {
    Button b2, b1;
    private static final String TAG ="Menu";
    EditText ThankyouID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou);
        ThankyouID=(EditText) this.findViewById(R.id.ThankyouID);
        ThankyouID.setEnabled(false);
       b2=(Button)findViewById(R.id.again);
        b1=(Button)findViewById(R.id.main_menu);


       b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Intent intent = new Intent(Thankyou.this,Menu.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Intent intent = new Intent(Thankyou.this,LogInActivity.class);
                startActivity(intent);
            }
        });


    }
}