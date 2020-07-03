package ws.design.stardelivery;


import android.graphics.Color;
import androidx.core.app.Fragment;
import androidx.core.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fragment.CartFragment;
import fragment.HomeFragment;
import fragment.MoreFragment;
import fragment.OfferFragment;
import fragment.SearchFragment;

public class DemoActivity extends AppCompatActivity  implements View.OnClickListener  {


    LinearLayout home_Ll, offer_Ll, search_Ll, cart_Ll, more_Ll;
    ImageView home_Img, offer_Img, search_Img, cart_Img, more_Img;
    TextView home_Txt, offer_Txt, search_Txt, cart_Txt, more_Txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        home_Ll = findViewById(R.id.home_Ll);
        offer_Ll = findViewById(R.id.offer_Ll);
        search_Ll = findViewById(R.id.search_Ll);
        cart_Ll = findViewById(R.id.cart_Ll);
        more_Ll = findViewById(R.id.more_Ll);

        home_Img = findViewById(R.id.home_Img);
        offer_Img = findViewById(R.id.offer_Img);
        search_Img = findViewById(R.id.search_Img);
        cart_Img = findViewById(R.id.cart_Img);
        more_Img = findViewById(R.id.more_Img);

        home_Txt = findViewById(R.id.home_Txt);
        offer_Txt = findViewById(R.id.offer_Txt);
        search_Txt = findViewById(R.id.search_Txt);
        cart_Txt = findViewById(R.id.cart_Txt);
        more_Txt = findViewById(R.id.more_Txt);

        home_Ll.setOnClickListener(this);
        offer_Ll.setOnClickListener(this);
        search_Ll.setOnClickListener(this);
        cart_Ll.setOnClickListener(this);
        more_Ll.setOnClickListener(this);

        replace_fragment(new HomeFragment());

        home_Img.setImageResource(R.drawable.ic_home_blue);
        home_Txt.setTextColor(Color.parseColor("#2546b0"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_Ll:

                home_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                offer_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                search_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                cart_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                more_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);

                home_Txt.setTextColor(Color.parseColor("#2546b0"));
                offer_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                search_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                cart_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                more_Txt.setTextColor(Color.parseColor("#1c1a2f"));

                replace_fragment(new HomeFragment());
                break;

            case R.id.offer_Ll:
                home_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                offer_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                search_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                cart_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                more_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);

                home_Txt.setTextColor(Color.parseColor("#2546b0"));
                offer_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                search_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                cart_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                more_Txt.setTextColor(Color.parseColor("#1c1a2f"));

                replace_fragment(new OfferFragment());
                break;

            case R.id.search_Ll:
                home_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                offer_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                search_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                cart_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                more_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);

                home_Txt.setTextColor(Color.parseColor("#2546b0"));
                offer_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                search_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                cart_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                more_Txt.setTextColor(Color.parseColor("#1c1a2f"));

                replace_fragment(new SearchFragment());
                break;

            case R.id.cart_Ll:
                home_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                offer_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                search_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                cart_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                more_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);

                home_Txt.setTextColor(Color.parseColor("#2546b0"));
                offer_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                search_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                cart_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                more_Txt.setTextColor(Color.parseColor("#1c1a2f"));

                replace_fragment(new CartFragment());
                break;

            case R.id.more_Ll:
                home_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                offer_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                search_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                cart_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);
                more_Img.setImageResource(R.drawable.ic_attach_money_black_24dp);

                home_Txt.setTextColor(Color.parseColor("#2546b0"));
                offer_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                search_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                cart_Txt.setTextColor(Color.parseColor("#1c1a2f"));
                more_Txt.setTextColor(Color.parseColor("#1c1a2f"));

                replace_fragment(new MoreFragment());
                break;
        }


    }
    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentData_container, fragment);
        transaction.commit();
    }
}