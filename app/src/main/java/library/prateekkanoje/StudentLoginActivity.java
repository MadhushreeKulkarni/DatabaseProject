package library.prateekkanoje;

/**
 * Created by Janelle on 2017/12/7.
 */

import library.prateekkanoje.constant.SQLCommand;
import library.prateekkanoje.util.DBOperator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.Cursor;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;


public class StudentLoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button logBtn;
    EditText uid_texted, psd_texted;
    SharedPreferences.Editor pref=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);
        //copy database file
        pref=getSharedPreferences("MSK",MODE_PRIVATE).edit();
        logBtn = (Button) this.findViewById(R.id.log_btn);
        logBtn.setOnClickListener(this);

        uid_texted = (EditText) this.findViewById(R.id.stuid_edittext);
        psd_texted = (EditText) this.findViewById(R.id.stu_psw_edittext);
    }

    public void onClick(View v) {

         /*get password from database for particular student_id*/
         if(uid_texted.getText()!=null && uid_texted.getText().toString().length()>0){
             Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.Student_Login_QUERY, new String[]{uid_texted.getText().toString()});
             final boolean b = cursor.moveToFirst();
             Log.i(cursor.getString(0), "PASSWORD");
             Log.i(uid_texted.getText().toString(), "ID");

             if (cursor.getCount() <= 0) {
                 String data1 = "no such id";
                 Log.i(data1, "WRONG ID");
                 Toast.makeText(getApplicationContext(), "PROVIDE CORRECT ID", Toast.LENGTH_SHORT).show();
             }

        /*if password entered is correct then StudentEvent screen*/

             else {
                 String db_password = cursor.getString(0);
                 Log.d(db_password, "PASSWORD");

                 if (db_password.equals(psd_texted.getText().toString())) {
                     pref.putString("Cust_ID",uid_texted.getText().toString()).commit();
                     uid_texted.setText("");
                     psd_texted.setText("");
                     Intent intent = new Intent(this,Menu.class);
                     intent.putExtra("student_id", uid_texted.getText().toString());
                     this.startActivity(intent);
                 } else {
                     Toast.makeText(getApplicationContext(), "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
                 }
             }
         }

    }

}



            /*int id=v.getId();
        if (id==R.id.log_btn){
//go back to student login screen
            String[] a=new String[1];
            a[0]=uid_texted.getText().toString();
            Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.Student_Login_QUERY,a);
            cursor.moveToFirst();
            String psw_from_cursor;
            psw_from_cursor=cursor.getString(cursor.getColumnIndex("cust_pwd"));
            if (psw_from_cursor.equals(psd_texted.getText().toString())){
                Intent intent = new Intent(this, LogInActivity.class);
                this.startActivity(intent);
            }else{
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        }else if (id==R.id.back_btn){
            //go back to admin login screen
            Intent intent = new Intent(this, LogInActivity.class);
            this.startActivity(intent);
        }
    }

}
*/