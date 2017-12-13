package library.prateekkanoje;

/**
 * Created by kanoj on 12/9/2017.
 */

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowId;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import library.prateekkanoje.constant.SQLCommand;
import library.prateekkanoje.util.DBOperator;

public class Order extends AppCompatActivity {
    Button bac,pay,res,or;
    EditText quan, cal_value, price_value,amount;
    TextView FoodName;
    private static final String TAG ="Order";
    String category=null;
    Cursor cursor=null;
    SharedPreferences pref=null;
    String customerID=null;
    @Override
    /*
    *  ContentValues values=new ContentValues();

            values.put("qtyord",);
            values.put("FROM_DATE",leave.getFromDATE());

            value=sqLiteDatabase.insert(SQLConstant.leave,null,values);
        }
        //insert into orders values();

    * */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        bac=(Button)findViewById(R.id.b_btn);
        pay=(Button)findViewById(R.id.pay_btn);
        res=(Button)findViewById(R.id.a_btn);
        quan=(EditText)findViewById(R.id.quant);
        amount=(EditText)findViewById(R.id.Total);
        Bundle b = getIntent().getExtras();
        category=b.getString("Category");
        FoodName=(TextView) findViewById(R.id.FoodName);
        FoodName.setText(b.getString("Category"));
        cal_value=(EditText)findViewById(R.id.Cal_value);
        price_value=(EditText)findViewById(R.id.Price_Value);
        amount.setEnabled(false);
        pref=getSharedPreferences("MSK",MODE_PRIVATE);
        customerID=pref.getString("Cust_ID",null);
        cursor= DBOperator.getInstance().execQuery(SQLCommand.menu_cal_price_query, new String[]{category});
        try{
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                cal_value.setText(cursor.getString(cursor.getColumnIndex("f_cal")));
                price_value.setText(cursor.getString(cursor.getColumnIndex("f_price")));
            }
            price_value.setEnabled(false);
            cal_value.setEnabled(false);
        }catch(SQLException e) {
            Log.e("Order",e.getMessage());

        }finally {
            cursor.close();
        }


       bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                Intent intent = new Intent(Order.this,Breakfast.class);
                startActivity(intent);
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Starting");
                ContentValues cv=new ContentValues();
                cv.put("cust_id",customerID);
                cv.put("qtyord",Integer.parseInt(quan.getText().toString()));
                long rowsInserted=DBOperator.getInstance().insert(cv,"orders");
                Intent intent = new Intent(Order.this,Pay.class);
                startActivity(intent);
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateAMT();
            }
        });


    }

    private void calculateAMT(){
        int quantity=Integer.parseInt(quan.getText().toString());
        double price=Double.parseDouble(price_value.getText().toString());
        double finalPrice=quantity * price;
        amount.setText(Double.toString(finalPrice));
    }


}


