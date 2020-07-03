package ws.design.stardelivery;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.FoodAdapter;
import adapter.FoodItaliAdapter;
import model.FoodItaliModel;
import model.FoodModel;

public class HomePageOrderStatusActivity extends AppCompatActivity implements View.OnClickListener {

    Integer[] food_img = {R.drawable.image_home1, R.drawable.image_home2, R.drawable.image_home3,
            R.drawable.image_home4};

    String[] discount_txt = {"45% OFF!","BREAKFAST AT","SANDWICH’S","SALAD’s"};
    String[] coupon_txt = {"COUPON ‘STAR200’","50% OFF","START FROM ₹ 20","SUPER HEALTHY"};
    String[] restaurants_txt = {"AMAYA FREN RESIDENCY VADODARA","IN 20 RESTAURANTS",
            "EXPLORE NOW","EXPLORE NOW"};

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private ArrayList<FoodModel> foodModels;


    Integer[] pavbhaji = {R.drawable.pavbhaji, R.drawable.panipuri, R.drawable.panner,
            R.drawable.tawarice, R.drawable.matersabji, R.drawable.popato,
            R.drawable.pavbhaji, R.drawable.panipuri, R.drawable.panner,
            R.drawable.tawarice, R.drawable.matersabji, R.drawable.popato};

    String[] address = {"North Indian", "North Indian, italian, deserts", "North Indian"
            , "North Indian", "North Indian", "North Indian","North Indian", "North Indian",
            " italian, deserts", "North Indian","North Indian", "North Indian"};

    private RecyclerView recyclerView1;
    private FoodItaliAdapter foodItaliAdapter;
    private ArrayList<FoodItaliModel> foodItaliModels;
    Spinner spinner;

    /*----------Custom Bottombar---------*/
    LinearLayout home_linear, offer_linear, search_linear, cart_linear, more_linear;
    ImageView home, offer, search, cart, more;
    TextView hometxt, offertxt, searchtxt, carttxt, moretxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_order_status);

        /*----------Recycler view code------------*/

        recyclerView = findViewById(R.id.orderfood_recycle);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(HomePageOrderStatusActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        foodModels = new ArrayList<>();

        for (int i = 0; i < food_img.length; i++) {
            FoodModel ab = new FoodModel(food_img[i],discount_txt[i],coupon_txt[i],restaurants_txt[i]);
            foodModels.add(ab);
        }
        foodAdapter = new FoodAdapter(HomePageOrderStatusActivity.this, foodModels);
        recyclerView.setAdapter(foodAdapter);

        /*----------Recycler view code------------*/
        recyclerView1 = findViewById(R.id.orderfooditali_recycle);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(HomePageOrderStatusActivity.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        foodItaliModels = new ArrayList<>();

        for (int i = 0; i < pavbhaji.length; i++) {
            FoodItaliModel ab = new FoodItaliModel(pavbhaji[i], address[i]);
            foodItaliModels.add(ab);
        }
        foodItaliAdapter = new FoodItaliAdapter(HomePageOrderStatusActivity.this, foodItaliModels);
        recyclerView1.setAdapter(foodItaliAdapter);

        /*-------Spinner Code---------------*/

//        spinner = findViewById(R.id.spinner);
//        List<String> list = new ArrayList<String>();
//        list.add("HOME");
//        list.add("HOME");
//        list.add("HOME");
//        list.add("HOME");
//        list.add("HOME");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(HomePageOrderStatusActivity.this, R.layout.item_spinnerdata,
//                R.id.spinner_text1, list);
//        spinner.setAdapter(dataAdapter);

        /*------Custom Bottombar data---------------*/
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
        home.setImageResource(R.drawable.ic_home_blue);
        hometxt.setTextColor(Color.parseColor("#2546b0"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
