package library.prateekkanoje;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CursorAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import library.prateekkanoje.constant.SQLCommand;
import library.prateekkanoje.util.DBOperator;

/**
 * Created by Madhushree on 12/13/2017.
 */

public class OrderDetails  extends AppCompatActivity{

    private TableLayout tableLayout;
    private TableRow newTR;
    private Cursor cursor=null;
    @Override
    protected  void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.orderhistory);

        tableLayout=(TableLayout)findViewById(R.id.tblLayout);
        newTR=(TableRow)findViewById(R.id.tableRow1);

        tableLayout.setColumnStretchable(0, true); //first column
        tableLayout.setColumnStretchable(1, true); //second column
        tableLayout.setColumnStretchable(2, false); //third column

        cursor= DBOperator.getInstance().execQuery(SQLCommand.admin_orders,null);
        while(cursor.moveToNext()){
            TableRow tmp = new TableRow(OrderDetails.this);
            TextView tvID = new TextView(OrderDetails.this);
            tvID.setText(cursor.getString(cursor.getColumnIndex("o_id")));
            tvID.setTextSize(20);
            tvID.setTypeface(null, Typeface.BOLD);
            TextView tvName = new TextView(OrderDetails.this);
            tvName.setText(cursor.getString(cursor.getColumnIndex("cust_id")));
            tvName.setTextSize(20);
            tvName.setTypeface(null, Typeface.BOLD);
            TextView tvNames = new TextView(OrderDetails.this);
            tvNames.setText(cursor.getString(cursor.getColumnIndex("qtyord")));
            tvNames.setTextSize(20);
            tvNames.setTypeface(null, Typeface.BOLD);

            tmp.addView(tvID);
            tmp.addView(tvName);
            tmp.addView(tvNames);
            tableLayout.addView(tmp);
        }

    }
}
