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
import fragment.TestFragmetn;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linear_home,linear_offer,linear_cart,linear_search,linear_more;
    ImageView home_img,offer_img,cart_img,search_img,more_img;
    TextView home_txt,offer_txt,cart_txt,search_txt,more_txt;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        linear_home = findViewById(R.id.linear_home);
        linear_offer = findViewById(R.id.linear_offer);
        linear_cart = findViewById(R.id.linear_cart);
        linear_search = findViewById(R.id.linear_search);
        linear_more = findViewById(R.id.linear_more);

        home_img = findViewById(R.id.home_img);
        offer_img = findViewById(R.id.offer_img);
        cart_img = findViewById(R.id.cart_img);
        search_img = findViewById(R.id.search_img);
        more_img = findViewById(R.id.more_img);

        home_txt = findViewById(R.id.home_txt);
        offer_txt = findViewById(R.id.offer_txt);
        cart_txt = findViewById(R.id.cart_txt);
        search_txt = findViewById(R.id.search_txt);
        more_txt = findViewById(R.id.more_txt);

        linear_home.setOnClickListener(this);
        linear_offer.setOnClickListener(this);
        linear_cart.setOnClickListener(this);
        linear_search.setOnClickListener(this);
        linear_more.setOnClickListener(this);


        fragment = new TestFragmetn();
        loadFragment(fragment);
    }

    @Override
    public void onClick(View v) {

        Fragment fragment;

        switch (v.getId()){

            case R.id.linear_home:

                home_img.setImageResource(R.drawable.ic_home_blue);
                offer_img.setImageResource(R.drawable.ic_offer_black);
                cart_img.setImageResource(R.drawable.ic_cart_black);
                search_img.setImageResource(R.drawable.ic_search_black);
                more_img.setImageResource(R.drawable.ic_more_black);


                home_txt.setTextColor(Color.parseColor("#2546b0"));
                offer_txt.setTextColor(Color.parseColor("#000000"));
                cart_txt.setTextColor(Color.parseColor("#000000"));
                search_txt.setTextColor(Color.parseColor("#000000"));
                more_txt.setTextColor(Color.parseColor("#000000"));

                fragment = new HomeFragment();
                loadFragment(fragment);


                break;

            case R.id.linear_offer:

                home_img.setImageResource(R.drawable.ic_home_black);
                offer_img.setImageResource(R.drawable.ic_offer_blue);
                cart_img.setImageResource(R.drawable.ic_cart_black);
                search_img.setImageResource(R.drawable.ic_search_black);
                more_img.setImageResource(R.drawable.ic_more_black);


                home_txt.setTextColor(Color.parseColor("#000000"));
                offer_txt.setTextColor(Color.parseColor("#2546b0"));
                cart_txt.setTextColor(Color.parseColor("#000000"));
                search_txt.setTextColor(Color.parseColor("#000000"));
                more_txt.setTextColor(Color.parseColor("#000000"));

                fragment = new OfferFragment();
                loadFragment(fragment);


                break;

            case R.id.linear_cart:


                home_img.setImageResource(R.drawable.ic_home_black);
                offer_img.setImageResource(R.drawable.ic_offer_black);
                cart_img.setImageResource(R.drawable.ic_cart_blue);
                search_img.setImageResource(R.drawable.ic_search_black);
                more_img.setImageResource(R.drawable.ic_more_black);


                home_txt.setTextColor(Color.parseColor("#000000"));
                offer_txt.setTextColor(Color.parseColor("#000000"));
                cart_txt.setTextColor(Color.parseColor("#2546b0"));
                search_txt.setTextColor(Color.parseColor("#000000"));
                more_txt.setTextColor(Color.parseColor("#000000"));

                fragment = new CartFragment();
                loadFragment(fragment);

                break;

            case R.id.linear_search:

                home_img.setImageResource(R.drawable.ic_home_black);
                offer_img.setImageResource(R.drawable.ic_offer_black);
                cart_img.setImageResource(R.drawable.ic_cart_black);
                search_img.setImageResource(R.drawable.ic_search_blue);
                more_img.setImageResource(R.drawable.ic_more_black);


                home_txt.setTextColor(Color.parseColor("#000000"));
                offer_txt.setTextColor(Color.parseColor("#000000"));
                cart_txt.setTextColor(Color.parseColor("#000000"));
                search_txt.setTextColor(Color.parseColor("#2546b0"));
                more_txt.setTextColor(Color.parseColor("#000000"));

                fragment = new SearchFragment();
                loadFragment(fragment);



                break;

            case R.id.linear_more:


                home_img.setImageResource(R.drawable.ic_home_black);
                offer_img.setImageResource(R.drawable.ic_offer_black);
                cart_img.setImageResource(R.drawable.ic_cart_black);
                search_img.setImageResource(R.drawable.ic_search_black);
                more_img.setImageResource(R.drawable.ic_more_blue);


                home_txt.setTextColor(Color.parseColor("#000000"));
                offer_txt.setTextColor(Color.parseColor("#000000"));
                cart_txt.setTextColor(Color.parseColor("#000000"));
                search_txt.setTextColor(Color.parseColor("#000000"));
                more_txt.setTextColor(Color.parseColor("#2546b0"));



                fragment = new MoreFragment();
                loadFragment(fragment);

                break;
        }
    }

    /*load fragment method can be here*/

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framlayout, fragment);
        transaction.commit();
    }
}
