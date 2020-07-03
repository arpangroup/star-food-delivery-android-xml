package ws.design.stardelivery;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import androidx.core.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    int defult = 220;
    int result;

    TextView plus_text, increase_txt, minus_txt, add_item_txt;
    LinearLayout add_cart_linear, item_incrementcart_linear;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.changeaddress_txt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),ChangeAddressActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.process_linear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),PaymentsActivity.class);
                startActivity(i);
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

                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                increase_txt.startAnimation(animation1);
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

                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                increase_txt.startAnimation(animation1);
            }
        });

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        ctl.setTitle("CART (Lunchbox)");
        ctl.setCollapsedTitleTextColor(Color.parseColor("#000000"));
        ctl.setContentScrim(getDrawable(R.color.white));
        ctl.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        ctl.setExpandedTitleTextAppearance(R.style.expandedAppBar);
        ctl.setExpandedTitleColor(Color.parseColor("#000000"));
        ctl.setCollapsedTitleTextColor(Color.parseColor("#000000"));
        Typeface typeface = ResourcesCompat.getFont(this, R.font.roboto_medium);
        ctl.setCollapsedTitleTypeface(typeface);
        ctl.setExpandedTitleTypeface(typeface);
    }
}