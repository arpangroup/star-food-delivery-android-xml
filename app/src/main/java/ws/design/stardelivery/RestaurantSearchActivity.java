package ws.design.stardelivery;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.RestaurentSearchAdapter;
import model.RestaurentSearchModel;

public class RestaurantSearchActivity extends AppCompatActivity implements View.OnClickListener {

    String[] brown_burger_txt = {"Brown Burger", "Pavbhaji", "Cafe Mocha"};

    private RecyclerView recyclerView;
    private RestaurentSearchAdapter adapter;
    private ArrayList<RestaurentSearchModel> models;

    LinearLayout home_linear,offer_linear,search_linear,cart_linear, more_linear;
    ImageView home, offer, search, cart, more;
    TextView hometxt, offertxt, searchtxt, carttxt, moretxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_search);

        findViewById(R.id.re_search_linear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),SearchActivity.class);
                startActivity(i);
            }
        });
        recyclerView = findViewById(R.id.restaurant_search_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantSearchActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        models = new ArrayList<>();

        for (int i = 0; i < brown_burger_txt.length; i++) {
            RestaurentSearchModel ab = new RestaurentSearchModel(brown_burger_txt[i]);
            models.add(ab);
        }
        adapter = new RestaurentSearchAdapter(RestaurantSearchActivity.this, models);
        recyclerView.setAdapter(adapter);

        home_linear = findViewById(R.id.home_linear);
        offer_linear = findViewById(R.id.offer_linear);
        search_linear = findViewById(R.id.search_linear);
        cart_linear = findViewById(R.id.cart_linear);
        more_linear = findViewById(R.id.more_linear);

        home = findViewById(R.id.homeimg);
        offer = findViewById(R.id.offerimg);
        search = findViewById(R.id.searchimg);
        cart = findViewById(R.id.cartimg);
        more = findViewById(R.id.moreimg);

        hometxt = findViewById(R.id.hometxt);
        offertxt = findViewById(R.id.offertxt);
        searchtxt = findViewById(R.id.searchtxt);
        carttxt = findViewById(R.id.carttxt);
        moretxt = findViewById(R.id.moretxt);

        home_linear.setOnClickListener(this);
        offer_linear.setOnClickListener(this);
        search_linear.setOnClickListener(this);
        cart_linear.setOnClickListener(this);
        more_linear.setOnClickListener(this);

        search.setImageResource(R.drawable.search_blue);
        searchtxt.setTextColor(Color.parseColor("#2546b0"));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.home_linear:
                home.setImageResource(R.drawable.ic_home_blue);
                offer.setImageResource(R.drawable.ic_offer_black);
                search.setImageResource(R.drawable.search_black);
                cart.setImageResource(R.drawable.ic_cart_black);
                more.setImageResource(R.drawable.more_black);

                hometxt.setTextColor(Color.parseColor("#2546b0"));
                offertxt.setTextColor(Color.parseColor("#1c1a2f"));
                searchtxt.setTextColor(Color.parseColor("#1c1a2f"));
                carttxt.setTextColor(Color.parseColor("#1c1a2f"));
                moretxt.setTextColor(Color.parseColor("#1c1a2f"));
                break;

            case R.id.offer_linear:
                home.setImageResource(R.drawable.ic_home_black);
                offer.setImageResource(R.drawable.ic_offer_blue);
                search.setImageResource(R.drawable.search_black);
                cart.setImageResource(R.drawable.ic_cart_black);
                more.setImageResource(R.drawable.more_black);

                hometxt.setTextColor(Color.parseColor("#1c1a2f"));
                offertxt.setTextColor(Color.parseColor("#2546b0"));
                searchtxt.setTextColor(Color.parseColor("#1c1a2f"));
                carttxt.setTextColor(Color.parseColor("#1c1a2f"));
                moretxt.setTextColor(Color.parseColor("#1c1a2f"));
                break;

            case R.id.search_linear:
                home.setImageResource(R.drawable.ic_home_black);
                offer.setImageResource(R.drawable.ic_offer_black);
                search.setImageResource(R.drawable.search_blue);
                cart.setImageResource(R.drawable.ic_cart_black);
                more.setImageResource(R.drawable.more_black);

                hometxt.setTextColor(Color.parseColor("#1c1a2f"));
                offertxt.setTextColor(Color.parseColor("#1c1a2f"));
                searchtxt.setTextColor(Color.parseColor("#2546b0"));
                carttxt.setTextColor(Color.parseColor("#1c1a2f"));
                moretxt.setTextColor(Color.parseColor("#1c1a2f"));
                break;

            case R.id.cart_linear:
                home.setImageResource(R.drawable.ic_home_black);
                offer.setImageResource(R.drawable.ic_offer_black);
                search.setImageResource(R.drawable.search_black);
                cart.setImageResource(R.drawable.ic_cart_blue);
                more.setImageResource(R.drawable.more_black);

                hometxt.setTextColor(Color.parseColor("#1c1a2f"));
                offertxt.setTextColor(Color.parseColor("#1c1a2f"));
                searchtxt.setTextColor(Color.parseColor("#1c1a2f"));
                carttxt.setTextColor(Color.parseColor("#2546b0"));
                moretxt.setTextColor(Color.parseColor("#1c1a2f"));
                break;

            case R.id.more_linear:
                home.setImageResource(R.drawable.ic_home_black);
                offer.setImageResource(R.drawable.ic_offer_black);
                search.setImageResource(R.drawable.search_black);
                cart.setImageResource(R.drawable.ic_cart_black);
                more.setImageResource(R.drawable.more_blue);

                hometxt.setTextColor(Color.parseColor("#1c1a2f"));
                offertxt.setTextColor(Color.parseColor("#1c1a2f"));
                searchtxt.setTextColor(Color.parseColor("#1c1a2f"));
                carttxt.setTextColor(Color.parseColor("#1c1a2f"));
                moretxt.setTextColor(Color.parseColor("#2546b0"));
                break;
        }
    }
}
