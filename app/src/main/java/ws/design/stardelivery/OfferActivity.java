package ws.design.stardelivery;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.OfferAdapter;
import model.RecommendedModel;

public class OfferActivity extends AppCompatActivity implements View.OnClickListener {

    TextView veg_txt,non_veg_txt,rs_txt;


    Integer[] birani = {R.drawable.offerimg1, R.drawable.offerimg2, R.drawable.offerimg3,
            R.drawable.offerimg4, R.drawable.offerimg5, R.drawable.offerimg6};

    String[] rice_txt = {"Basmati Rice Lunchbox", "Basmati Rice Lunchbox", "Kulcha Bread Lunchbox"
            , "Basmati Rice Lunchbox", "Maji Varieties", "Maji Varieties"};

    String[] panner_txt = {"Paneer Biryani", "Chicken Biryani", "Chole Kulcha Lunchbox "
            , "Dal Makhani & Rice", "Egg Afghani Thou", "Egg Afghani Thou"};

    private RecyclerView recyclerView1;
    private OfferAdapter offerAdapter;
    private ArrayList<RecommendedModel> recommendedModels;

    LinearLayout home_linear,offer_linear,search_linear,cart_linear, more_linear;
    ImageView home, offer, search, cart, more;
    TextView hometxt, offertxt, searchtxt, carttxt, moretxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        veg_txt = (TextView)findViewById(R.id.veg_txt);
        non_veg_txt = (TextView)findViewById(R.id.non_veg_txt);
        rs_txt = (TextView)findViewById(R.id.rs_txt);

        veg_txt.setOnClickListener(this);
        non_veg_txt.setOnClickListener(this);
        rs_txt.setOnClickListener(this);

        rs_txt.setTextColor(Color.parseColor("#ffffff"));
        rs_txt.setBackgroundResource(R.drawable.rectangle_blue);

        //1
        recyclerView1 = findViewById(R.id.offer_recycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(OfferActivity.this, 2);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        recommendedModels = new ArrayList<>();

        for (int i = 0; i < birani.length; i++) {
            RecommendedModel ab = new RecommendedModel(birani[i], rice_txt[i], panner_txt[i]);
            recommendedModels.add(ab);
        }
        offerAdapter = new OfferAdapter(OfferActivity.this, recommendedModels);
        recyclerView1.setAdapter(offerAdapter);
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


        cart.setImageResource(R.drawable.ic_cart_blue);
        carttxt.setTextColor(Color.parseColor("#2546b0"));

        home_linear.setOnClickListener(this);
        offer_linear.setOnClickListener(this);
        search_linear.setOnClickListener(this);
        cart_linear.setOnClickListener(this);
        more_linear.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.veg_txt:
                veg_txt.setTextColor(Color.parseColor("#ffffff"));
                non_veg_txt.setTextColor(Color.parseColor("#777779"));
                rs_txt.setTextColor(Color.parseColor("#777779"));

                veg_txt.setBackgroundResource(R.drawable.rectangle_blue);
                non_veg_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                rs_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                break;

            case R.id.non_veg_txt:
                veg_txt.setTextColor(Color.parseColor("#777779"));
                non_veg_txt.setTextColor(Color.parseColor("#ffffff"));
                rs_txt.setTextColor(Color.parseColor("#777779"));

                veg_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                non_veg_txt.setBackgroundResource(R.drawable.rectangle_blue);
                rs_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                break;

            case R.id.rs_txt:
                veg_txt.setTextColor(Color.parseColor("#777779"));
                non_veg_txt.setTextColor(Color.parseColor("#777779"));
                rs_txt.setTextColor(Color.parseColor("#ffffff"));

                veg_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                non_veg_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                rs_txt.setBackgroundResource(R.drawable.rectangle_blue);
                break;

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
