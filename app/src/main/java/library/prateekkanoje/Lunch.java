package library.prateekkanoje;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class Lunch extends AppCompatActivity implements OnClickListener {

    Button btn1, btn2, btn3, btn4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch);
        btn1 = (Button) this.findViewById(R.id.rice_btn);

        btn2 = (Button) this.findViewById(R.id.salad_btn);

        btn3 = (Button) this.findViewById(R.id.pizza_btn);

        btn4 = (Button) this.findViewById(R.id.pasta_btn);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(Lunch.this,Order.class);
        if (id == R.id.rice_btn) {
// Check out a menu

            Toast.makeText(getBaseContext(), "Rice Bowl Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Rice Bowl");
            startActivity(intent);
        }
        else if (id == R.id.salad_btn) {
            Toast.makeText(getBaseContext(), "Salad Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Salad");
            startActivity(intent); }

        else if (id == R.id.pizza_btn) {
            Toast.makeText(getBaseContext(), " Chicken Pizza Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Chicken Pizza");
            startActivity(intent); }

        else if (id == R.id.pasta_btn) {
            Toast.makeText(getBaseContext(), "Pasta Selected",
                    Toast.LENGTH_SHORT).show();
            intent.putExtra("Category","Pasta");
            startActivity(intent); }

    }

}



