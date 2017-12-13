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

public class Menu extends AppCompatActivity {
    Button breakfast,lunch,dinner;
    private static final String TAG ="Menu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        breakfast=(Button)findViewById(R.id.breakfast_btn);
        lunch=(Button)findViewById(R.id.lunch_btn);
       dinner=(Button)findViewById(R.id.dinner_btn);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Intent intent = new Intent(Menu.this,Breakfast.class);
                startActivity(intent);
            }
        });

        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Intent intent = new Intent(Menu.this,Lunch.class);
                startActivity(intent);
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Intent intent = new Intent(Menu.this,Dinner.class);
                startActivity(intent);
            }
        });

    }
}
