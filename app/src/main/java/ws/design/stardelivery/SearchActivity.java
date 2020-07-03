package ws.design.stardelivery;

import android.graphics.Color;
import android.os.Bundle;
import androidx.core.app.Fragment;
import androidx.core.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.DishesAdapter;
import adapter.SearchAdapter;
import fragment.DoshRateFragment;
import model.DishesModel;
import model.SearchModel;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    /*-------RESTAURANTS RecyclerView Data--------*/
    Integer[] chinesses_img = {R.drawable.s_biryani, R.drawable.search1};
    String[] lunchbox_txt = {"SubWay", "SubWay"};
    String[] side_txt = {"North Indian", "North Indian, italian, deserts"};
    String[] areya_txt = {"New alkaprui", "Fatehgunj"};
    String[] discount_txt = {"GET 30% OFF", "GET 30% OFF"};
    String[] rating_txt = {"4.6", "3.7"};
    String[] time_txt = {"Deliver in 30 min.", "Deliver in 45 min."};

    private RecyclerView recyclerView;
    private SearchAdapter foodItaliAdapter;
    private ArrayList<SearchModel> foodItaliModels;

    /*------------Dishes RecyclerView Data------------*/
    String[] dosa_txt = {"Sada dosa", "Rava dosa", "Masala Dosa"};

    private RecyclerView recyclerView1;
    private DishesAdapter dishesAdapter;
    private ArrayList<DishesModel> dishesModels;

    /*-----------------onClick Change the tab------------- */
    LinearLayout restaurants_linear, dishes_linear;
    TextView restaurants_txt, dishes_txt;
    ImageView viewline1, viewline2;
    LinearLayout restaurent_data, dishes_data, add_item_linear;

    /*----------Custom bottomBar---------*/
    LinearLayout home_linear, offer_linear, search_linear, cart_linear, more_linear;
    ImageView home, offer, search, cart, more;
    TextView hometxt, offertxt, searchtxt, carttxt, moretxt;

    EditText lunchbox_et;

    FrameLayout frame;
    Fragment fragment;
    String sadaDosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        sadaDosa = getIntent().getStringExtra("sadaDosa");

        add_item_linear = findViewById(R.id.add_item_linear);
        lunchbox_et = findViewById(R.id.lunchbox_et);
        frame = findViewById(R.id.frame);


        restaurants_linear = (LinearLayout) findViewById(R.id.restaurants_linear);
        dishes_linear = (LinearLayout) findViewById(R.id.dishes_linear);

        restaurants_txt = (TextView) findViewById(R.id.restaurants_txt);
        dishes_txt = (TextView) findViewById(R.id.dishes_txt);

        viewline1 = (ImageView) findViewById(R.id.viewline1);
        viewline2 = (ImageView) findViewById(R.id.viewline2);

        restaurent_data = (LinearLayout) findViewById(R.id.restaurent_data);
        dishes_data = (LinearLayout) findViewById(R.id.dishes_data);

        restaurants_linear.setOnClickListener(this);
        dishes_linear.setOnClickListener(this);



        /*--------Restaurant RecyclerView here-------------- */

        recyclerView = findViewById(R.id.restaurants_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        foodItaliModels = new ArrayList<>();

        for (int i = 0; i < chinesses_img.length; i++) {
            SearchModel ab = new SearchModel
                    (chinesses_img[i], lunchbox_txt[i], side_txt[i], areya_txt[i], discount_txt[i], rating_txt[i], time_txt[i]);
            foodItaliModels.add(ab);
        }
        foodItaliAdapter = new SearchAdapter(SearchActivity.this, foodItaliModels);
        recyclerView.setAdapter(foodItaliAdapter);

        /*--------Dishes RecyclerView here-------------- */

        recyclerView1 = findViewById(R.id.dishes_recycler);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(SearchActivity.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        dishesModels = new ArrayList<>();

        for (int i = 0; i < dosa_txt.length; i++) {
            DishesModel ab = new DishesModel(dosa_txt[i]);
            dishesModels.add(ab);
        }
        dishesAdapter = new DishesAdapter(SearchActivity.this, dishesModels);
        recyclerView1.setAdapter(dishesAdapter);

        /*------------Custom bottomBar data---------------*/
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

        fragment = new DoshRateFragment();
        loadFragment(fragment);

        if (sadaDosa != null){
            frame.setVisibility(View.VISIBLE);
            dishes_data.setVisibility(View.VISIBLE);

            //inside
            restaurants_txt.setTextColor(Color.parseColor("#777779"));
            dishes_txt.setTextColor(Color.parseColor("#1c1a2f"));
            viewline1.setVisibility(View.GONE);
            frame.setVisibility(View.VISIBLE);
            viewline2.setVisibility(View.VISIBLE);
            restaurent_data.setVisibility(View.GONE);
            dishes_data.setVisibility(View.VISIBLE);
        }
    }

    private void loadFragment(Fragment fragment) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.restaurants_linear:
                frame.setVisibility(View.GONE);
                restaurants_txt.setTextColor(Color.parseColor("#1c1a2f"));
                dishes_txt.setTextColor(Color.parseColor("#777779"));
                viewline1.setVisibility(View.VISIBLE);
                viewline2.setVisibility(View.GONE);
                restaurent_data.setVisibility(View.VISIBLE);
                dishes_data.setVisibility(View.GONE);

                lunchbox_et.setHint("Lunchbox");
                break;

            case R.id.dishes_linear:
                restaurants_txt.setTextColor(Color.parseColor("#777779"));
                dishes_txt.setTextColor(Color.parseColor("#1c1a2f"));
                viewline1.setVisibility(View.GONE);
                frame.setVisibility(View.VISIBLE);
                viewline2.setVisibility(View.VISIBLE);
                restaurent_data.setVisibility(View.GONE);
                dishes_data.setVisibility(View.VISIBLE);
                lunchbox_et.setHint("Dosa");
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

    public void loadFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.myfragment, fragment);
        transaction.commit();
    }
}