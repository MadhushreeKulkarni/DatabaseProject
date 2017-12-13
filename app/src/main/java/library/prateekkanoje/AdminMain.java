package library.prateekkanoje;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Madhushree on 12/13/2017.
 */

public class AdminMain extends AppCompatActivity{

    private Button menuUpdate,historyView;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.admin_main);
        menuUpdate=(Button)findViewById(R.id.update_btn);
        historyView=(Button)findViewById(R.id.history_btn);


        menuUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AdminMain", "onClick: Starting");
                Intent intent = new Intent(AdminMain.this,AdminMenuUpdate.class);
                startActivity(intent);
            }
        });
        historyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AdminMain", "onClick: Starting");
                Intent intent = new Intent(AdminMain.this,OrderDetails.class);
                startActivity(intent);
            }
        });

    }
}
