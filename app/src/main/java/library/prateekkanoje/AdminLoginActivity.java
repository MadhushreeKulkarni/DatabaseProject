package library.prateekkanoje;

/**
 * Created by Janelle on 2017/12/7.
 */
import library.prateekkanoje.constant.SQLCommand;
import library.prateekkanoje.util.DBOperator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;


public class AdminLoginActivity extends AppCompatActivity implements OnClickListener {
    Button logBtn;
    EditText aid_texted, apsd_texted;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_login);
        //copy database file

        logBtn = (Button) this.findViewById(R.id.log_btn);
        logBtn.setOnClickListener(this);

        aid_texted = (EditText) this.findViewById(R.id.adid_edittext);
        apsd_texted = (EditText) this.findViewById(R.id.ad_psw_edittext);
    }

    public void onClick(View v) {

        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.Ad_login_QUERY, new String[]{aid_texted.getText().toString()});
        cursor.moveToFirst();

        if (cursor.getCount() <= 0) {
            String data1 = "no such name";
            Log.i(data1, "WRONG NAME");
            Toast.makeText(getApplicationContext(), "WRONG USERNAME", Toast.LENGTH_SHORT).show();
        } else {
            String db_password = cursor.getString(0);
            Log.d(db_password, "PASSWORD");
            // do what ever you want here
            if (db_password.equals(apsd_texted.getText().toString())) {
                aid_texted.setText("");
                apsd_texted.setText("");
                Intent intent = new Intent(this, AdminMain.class);
                intent.putExtra("Admin ID", cursor.getString(cursor.getColumnIndex("ad_pwd")));
                this.startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
            }
        }
    }
}









       /* int id = v.getId();
        if (id == R.id.log_btn) {
//go back to student login screen
            String[] a = new String[1];
            a[0] = uid_texted.getText().toString();
            Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.Ad_login_QUERY, a);
            cursor.moveToFirst();
            String psw_from_cursor;
            psw_from_cursor = cursor.getString(cursor.getColumnIndex("cust_pwd"));
            if (psw_from_cursor.equals(psd_texted.getText().toString())) {
                Intent intent = new Intent(this, LogInActivity.class);
                this.startActivity(intent);
            } else {
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.back_btn) {
            //go back to admin login screen
            Intent intent = new Intent(this, LogInActivity.class);
            this.startActivity(intent);
        }
    }
}
*/
