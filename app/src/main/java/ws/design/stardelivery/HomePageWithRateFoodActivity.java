package ws.design.stardelivery;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.FoodAdapter;
import adapter.FoodItaliAdapter;
import model.FoodItaliModel;
import model.FoodModel;

public class HomePageWithRateFoodActivity extends AppCompatActivity implements View.OnClickListener {

    Integer[] food_img = {R.drawable.image_home1, R.drawable.image_home2, R.drawable.image_home3,
            R.drawable.image_home4};

    String[] discount_txt = {"45% OFF!","BREAKFAST AT","SANDWICH’S","SALAD’s"};
    String[] coupon_txt = {"COUPON ‘STAR200’","50% OFF","START FROM ₹ 20","SUPER HEALTHY"};
    String[] restaurants_txt = {"AMAYA FREN RESIDENCY VADODARA","IN 20 RESTAURANTS",
            "EXPLORE NOW","EXPLORE NOW"};
     RecyclerView recyclerView;
     FoodAdapter foodAdapter;
     ArrayList<FoodModel> foodModels;

    Integer[] pavbhaji = {R.drawable.pavbhaji, R.drawable.panipuri, R.drawable.panner,
            R.drawable.tawarice, R.drawable.matersabji, R.drawable.popato,
            R.drawable.pavbhaji, R.drawable.panipuri, R.drawable.panner,
            R.drawable.tawarice, R.drawable.matersabji, R.drawable.popato};

    String[] address = {"North Indian", "North Indian, italian, deserts", "North Indian"
            , "North Indian", "North Indian", "North Indian","North Indian", "North Indian",
            " italian, deserts", "North Indian","North Indian", "North Indian"};

     RecyclerView recyclerView1;
     FoodItaliAdapter foodItaliAdapter;
     ArrayList<FoodItaliModel> foodItaliModels;

    Dialog slideDialog;


    TextView taste_txt,portion_txt,food_txt;
    RatingBar ratingBarFood;

    /*----------Custom Bottombar---------*/
    LinearLayout home_linear, offer_linear, search_linear, cart_linear, more_linear;
    ImageView home, offer, search, cart, more;
    TextView hometxt, offertxt, searchtxt, carttxt, moretxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_with_rate_food);

        ratingBarFood = (RatingBar) findViewById(R.id.ratingBarFood);

        ratingBarFood.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String ratingValue = String.valueOf(ratingBarFood.getRating());
                slideDialog = new Dialog(HomePageWithRateFoodActivity.this, R.style.CustomDialogAnimation);
                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Window window = slideDialog.getWindow();

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                slideDialog.setContentView(R.layout.item_rate_popup_filled);

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());

                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.650);

                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                layoutParams.gravity = Gravity.BOTTOM;

                slideDialog.getWindow().setAttributes(layoutParams);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);


                taste_txt = slideDialog.findViewById(R.id.taste_txt);
                portion_txt = slideDialog.findViewById(R.id.portion_txt);
                food_txt = slideDialog.findViewById(R.id.food_txt);
                ratingBar = slideDialog.findViewById(R.id.ratingBar);
                ratingBar.setRating(Float.parseFloat(ratingValue));

                taste_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        taste_txt.setTextColor(Color.parseColor("#ffffff"));
                        portion_txt.setTextColor(Color.parseColor("#90959f"));
                        food_txt.setTextColor(Color.parseColor("#90959f"));
                        taste_txt.setBackgroundResource(R.drawable.rectangle_green);
                        portion_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                        food_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                    }
                });
                portion_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        taste_txt.setTextColor(Color.parseColor("#90959f"));
                        portion_txt.setTextColor(Color.parseColor("#ffffff"));
                        food_txt.setTextColor(Color.parseColor("#90959f"));
                        taste_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                        portion_txt.setBackgroundResource(R.drawable.rectangle_green);
                        food_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                    }
                });
                food_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        taste_txt.setTextColor(Color.parseColor("#90959f"));
                        portion_txt.setTextColor(Color.parseColor("#90959f"));
                        food_txt.setTextColor(Color.parseColor("#ffffff"));
                        taste_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                        portion_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                        food_txt.setBackgroundResource(R.drawable.rectangle_green);
                    }
                });

                slideDialog.show();
            }
        });

        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.food_recycle);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(HomePageWithRateFoodActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        foodModels = new ArrayList<>();

        for (int i = 0; i < food_img.length; i++) {
            FoodModel ab = new FoodModel(food_img[i],discount_txt[i],coupon_txt[i],restaurants_txt[i]);
            foodModels.add(ab);
        }
        foodAdapter = new FoodAdapter(HomePageWithRateFoodActivity.this, foodModels);
        recyclerView.setAdapter(foodAdapter);

        /*----------Recycler view code------------*/

        recyclerView1 = findViewById(R.id.fooditali_recycle);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(HomePageWithRateFoodActivity.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        foodItaliModels = new ArrayList<>();

        for (int i = 0; i < pavbhaji.length; i++) {
            FoodItaliModel ab = new FoodItaliModel(pavbhaji[i],address[i]);
            foodItaliModels.add(ab);
        }
        foodItaliAdapter = new FoodItaliAdapter(HomePageWithRateFoodActivity.this, foodItaliModels);
        recyclerView1.setAdapter(foodItaliAdapter);

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
        RatingBar ratingBar = findViewById(R.id.ratingBar);
    }

    public void rateSubmit(View view) {
        String ratingValue = String.valueOf(ratingBarFood.getRating());
        Intent intent = new Intent(HomePageWithRateFoodActivity.this,RateFiledPopActivity.class);
        intent.putExtra("rating",ratingValue);
        startActivity(intent);
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