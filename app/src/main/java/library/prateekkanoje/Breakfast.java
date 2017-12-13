package library.prateekkanoje;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by ananyajoshi on 03/12/17.
 */


public class Breakfast extends AppCompatActivity implements OnClickListener {

    Button btn1, btn2, btn3, btn4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast);
        btn1 = (Button) this.findViewById(R.id.sandwich_btn);
        btn1.setOnClickListener(this);
        btn2 = (Button) this.findViewById(R.id.bagel_btn);
        btn2.setOnClickListener(this);
        btn3 = (Button) this.findViewById(R.id.samosa_btn);
        btn3.setOnClickListener(this);
        btn4 = (Button) this.findViewById(R.id.coffee_btn);
        btn4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(Breakfast.this,Order.class);
        if (id == R.id.sandwich_btn) {
// Check out a menu

            Toast.makeText(getBaseContext(), "Sandwich Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Sandwich");
            startActivity(intent);
        }
        else if (id == R.id.bagel_btn) {
            Toast.makeText(getBaseContext(), "Bagel Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Bagel");
            startActivity(intent); }

        else if (id == R.id.samosa_btn) {
            Toast.makeText(getBaseContext(), " Samosa Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Samosa");
            startActivity(intent); }

        else if (id == R.id.coffee_btn) {
            Toast.makeText(getBaseContext(), "Coffee Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","CoffeE");
            startActivity(intent); }

    }

}



