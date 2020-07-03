package ws.design.stardelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IndividualItem1Activity extends AppCompatActivity {

    int defult = 220;
    int result;

    TextView plus_text, increase_txt, minus_txt, add_item_txt;
    LinearLayout add_cart_linear, item_incrementcart_linear;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_item1);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        plus_text = findViewById(R.id.plus_text);
        increase_txt = findViewById(R.id.increase_txt);
        minus_txt = findViewById(R.id.minus_txt);
        add_item_txt = findViewById(R.id.add_item_txt);
        add_cart_linear = findViewById(R.id.add_cart_linear);

        item_incrementcart_linear = findViewById(R.id.item_incrementcart_linear);
        total = findViewById(R.id.total);

        add_item_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_item_txt.setVisibility(View.GONE);
                add_cart_linear.setVisibility(View.VISIBLE);

            }
        });

        plus_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(String.valueOf(increase_txt.getText()));
                count++;
                result = defult*count;
                increase_txt.setText(String.valueOf(count));
                total.setText(String.valueOf(result));
            }
        });

        minus_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(String.valueOf(increase_txt.getText()));
//                condition last value is 1
                if (count > 1) {
                    count--;
                    result = result - defult;
                    // result = defult - count;
                    increase_txt.setText(String.valueOf(count));
                    total.setText(String.valueOf(result));
                } else {
                    add_item_txt.setVisibility(View.VISIBLE);
                    add_cart_linear.setVisibility(View.GONE);
                }
            }
        });
    }
}
