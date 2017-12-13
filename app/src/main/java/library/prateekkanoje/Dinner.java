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


public class Dinner extends AppCompatActivity implements OnClickListener {

    Button btn1, btn2, btn3, btn4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinner);
       btn1 = (Button) this.findViewById(R.id.riced_btn);
        btn1.setOnClickListener(this);
      btn2 = (Button) this.findViewById(R.id.saladd_btn);
        btn2.setOnClickListener(this);
        btn3 = (Button) this.findViewById(R.id.pizzad_btn);
        btn3.setOnClickListener(this);
       btn4 = (Button) this.findViewById(R.id.pastad_btn);
        btn4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(Dinner.this,Order.class);
        if (id == R.id.riced_btn) {
// Check out a menu

            Toast.makeText(getBaseContext(), "Rice Bowl Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Rice Bowl");
            startActivity(intent);
        }
        else if (id == R.id.saladd_btn) {
            Toast.makeText(getBaseContext(), "Salad Salad",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Salad");
            startActivity(intent); }

        else if (id == R.id.pizzad_btn) {
                Toast.makeText(getBaseContext(), " Chicken Pizza Selected",
                        Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Chicken Pizza");
            startActivity(intent); }

        else if (id == R.id.pastad_btn) {
            Toast.makeText(getBaseContext(), "Pasta Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Pasta");
            startActivity(intent); }

            }

        }



