package library.prateekkanoje;

/**
 * Created by Janelle on 2017/12/7.
 */

import library.prateekkanoje.constant.SQLCommand;
import library.prateekkanoje.util.DBOperator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity implements OnClickListener {

    Button stuBtn,adBtn;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_app);
        //copy database file

        stuBtn=(Button)this.findViewById(R.id.student_btn);
        stuBtn.setOnClickListener(this);
        adBtn=(Button)this.findViewById(R.id.admin_btn);
        adBtn.setOnClickListener(this);

        try {
            DBOperator.copyDB(getBaseContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v)
    {
        int id=v.getId();
        /*student login screen*/
        if (id==R.id.student_btn){
            Intent intent = new Intent(this, StudentLoginActivity.class);
            this.startActivity(intent);
        }else if (id==R.id.admin_btn){
            //go back to admin login screen
            Intent intent = new Intent(this, AdminLoginActivity.class);
            this.startActivity(intent);
        }
    }
}

