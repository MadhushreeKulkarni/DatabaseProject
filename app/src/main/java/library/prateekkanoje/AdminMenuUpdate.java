package library.prateekkanoje;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import library.prateekkanoje.constant.SQLCommand;
import library.prateekkanoje.util.DBOperator;

/**
 * Created by Madhushree on 12/11/2017.
 */

public class AdminMenuUpdate extends  AppCompatActivity {

    EditText sandwich, bagel, samosa, coffee, ricebowl, salad, chickenpizza, pasta;
    Button editButton,submitButton;
    HashMap<String,Double> map=new HashMap<String,Double>();
    List<String> where=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminmenuupdate);

        sandwich = (EditText) findViewById(R.id.Sandwich_price);
        bagel = (EditText) findViewById(R.id.Bagel_price);
        samosa = (EditText) findViewById(R.id.Samosa_price);
        coffee = (EditText) findViewById(R.id.Coffee_price);
        ricebowl = (EditText) findViewById(R.id.RiceBowl_price);
        salad = (EditText) findViewById(R.id.Salad_price);
        chickenpizza = (EditText) findViewById(R.id.Pizza_price);
        pasta = (EditText) findViewById(R.id.Pasta_price);


        editButton = (Button) findViewById(R.id.Edit_price);
        submitButton = (Button) findViewById(R.id.Update_price);

        sandwich.setEnabled(false);
        bagel.setEnabled(false);
        samosa.setEnabled(false);
        coffee.setEnabled(false);
        ricebowl.setEnabled(false);
        salad.setEnabled(false);
        chickenpizza.setEnabled(false);
        pasta.setEnabled(false);

        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.admin_food_query, null);
        //cursor.moveToLast();
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex("f_name")).contains("Sandwich")) {
                sandwich.setText(Double.toString(cursor.getDouble(cursor.getColumnIndex("f_price"))));
            } else if (cursor.getString(cursor.getColumnIndex("f_name")).contains("Bagel")) {
                bagel.setText(Double.toString(cursor.getDouble(cursor.getColumnIndex("f_price"))));
            } else if (cursor.getString(cursor.getColumnIndex("f_name")).contains("Samosa")) {
                samosa.setText(Double.toString(cursor.getDouble(cursor.getColumnIndex("f_price"))));
            } else if (cursor.getString(cursor.getColumnIndex("f_name")).contains("CoffeE")) {
                coffee.setText(Double.toString(cursor.getDouble(cursor.getColumnIndex("f_price"))));
            } else if (cursor.getString(cursor.getColumnIndex("f_name")).contains("Rice Bowl")) {
                ricebowl.setText(Double.toString(cursor.getDouble(cursor.getColumnIndex("f_price"))));
            } else if (cursor.getString(cursor.getColumnIndex("f_name")).contains("Salad")) {
                salad.setText(Double.toString(cursor.getDouble(cursor.getColumnIndex("f_price"))));
            } else if (cursor.getString(cursor.getColumnIndex("f_name")).contains("Chicken Pizza")) {
                chickenpizza.setText(Double.toString(cursor.getDouble(cursor.getColumnIndex("f_price"))));
            } else if (cursor.getString(cursor.getColumnIndex("f_name")).contains("Pasta")) {
                pasta.setText(Double.toString(cursor.getDouble(cursor.getColumnIndex("f_price"))));
            }
            Log.e("Admin", cursor.getString(cursor.getColumnIndex("f_name")));
            Log.e("Admin", cursor.getString(cursor.getColumnIndex("f_price")));
            //DBOperator.getInstance().closeDB();
        }
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("", "onClick: edit");
                sandwich.setEnabled(true);
                bagel.setEnabled(true);
                samosa.setEnabled(true);
                coffee.setEnabled(true);
                ricebowl.setEnabled(true);
                salad.setEnabled(true);
                chickenpizza.setEnabled(true);
                pasta.setEnabled(true);
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("", "onClick: Submit");
                ContentValues cn=new ContentValues();
                if(sandwich.getText()!=null && sandwich.getText().length()>0){
                    map.put("f11",Double.parseDouble(sandwich.getText().toString()));

                }
                if(bagel.getText()!=null && bagel.getText().length()>0){
                    map.put("f12",Double.parseDouble(bagel.getText().toString()));
                }
                if(samosa.getText()!=null && samosa.getText().length()>0){
                    map.put("f13",Double.parseDouble(samosa.getText().toString()));

                }
                if(coffee.getText()!=null && coffee.getText().length()>0){
                    map.put("f14",Double.parseDouble(coffee.getText().toString()));
                }
                if(ricebowl.getText()!=null && ricebowl.getText().length()>0){
                    map.put("f21",Double.parseDouble(ricebowl.getText().toString()));
                }
                if(salad.getText()!=null && salad.getText().length()>0){
                    map.put("f22",Double.parseDouble(salad.getText().toString()));
                }
                if(chickenpizza.getText()!=null && chickenpizza.getText().length()>0){
                    map.put("f23",Double.parseDouble(chickenpizza.getText().toString()));
                }
                if(pasta.getText()!=null && pasta.getText().length()>0){
                    map.put("f24",Double.parseDouble(pasta.getText().toString()));
                }
                int i=DBOperator.getInstance().update("food",map);
                if(i>0){
                    Toast.makeText(AdminMenuUpdate.this, "Updated", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}