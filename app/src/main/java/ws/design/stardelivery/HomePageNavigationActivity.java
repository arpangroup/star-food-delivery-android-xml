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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.FoodAdapter;
import adapter.FoodItaliAdapter;
import model.FoodItaliModel;
import model.FoodModel;

public class HomePageNavigationActivity extends AppCompatActivity implements View.OnClickListener {


    Integer[] food_img = {R.drawable.image_home1, R.drawable.image_home2, R.drawable.image_home3,
            R.drawable.image_home4};

    String[] discount_txt = {"45% OFF!", "BREAKFAST AT", "SANDWICH’S", "SALAD’s"};
    String[] coupon_txt = {"COUPON ‘STAR200’", "50% OFF", "START FROM ₹ 20", "SUPER HEALTHY"};
    String[] restaurants_txt = {"AMAYA FREN RESIDENCY VADODARA", "IN 20 RESTAURANTS",
            "EXPLORE NOW", "EXPLORE NOW"};

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

    LinearLayout filter_liner;

    Dialog slideDialog;

    RadioButton radio1, radio2, radio3, radio4;
    TextView sort_txt, cuisines_txt, offers_txt;
    LinearLayout select_item_linear;

    LinearLayout cancel;

    /*----------Custom Bottombar---------*/
    LinearLayout home_linear, offer_linear, search_linear, cart_linear, more_linear;
    ImageView home, offer, search, cart, more;
    TextView hometxt, offertxt, searchtxt, carttxt, moretxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_navigation);


        findViewById(R.id.home_spinner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),LocationActivity.class);
                startActivity(i);
            }
        });
        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.food_recycle);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(HomePageNavigationActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        foodModels = new ArrayList<>();

        for (int i = 0; i < food_img.length; i++) {
            FoodModel ab = new FoodModel(food_img[i], discount_txt[i], coupon_txt[i], restaurants_txt[i]);
            foodModels.add(ab);
        }
        foodAdapter = new FoodAdapter(HomePageNavigationActivity.this, foodModels);
        recyclerView.setAdapter(foodAdapter);

        /*----------Recycler view code------------*/
        recyclerView1 = findViewById(R.id.fooditali_recycle);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(HomePageNavigationActivity.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        foodItaliModels = new ArrayList<>();

        for (int i = 0; i < pavbhaji.length; i++) {
            FoodItaliModel ab = new FoodItaliModel(pavbhaji[i], address[i]);
            foodItaliModels.add(ab);
        }
        foodItaliAdapter = new FoodItaliAdapter(HomePageNavigationActivity.this, foodItaliModels);
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

        search_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),RestaurantSearchActivity.class);
                startActivity(i);

            }
        });

        offer_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(getBaseContext(),OfferActivity.class);
                startActivity(j);
            }
        });

        cart_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(getBaseContext(),CartActivity.class);
                startActivity(j);
            }
        });

        more_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),MyAccountPageActivity.class);
                startActivity(i);
            }
        });



        /*-----------Onclick popup open layout---------------*/
        filter_liner = findViewById(R.id.filter_liner);
        filter_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slideDialog = new Dialog(HomePageNavigationActivity.this, R.style.CustomDialogAnimation);
                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                // Setting dialogview
                Window window = slideDialog.getWindow();
                //  window.setGravity(Gravity.BOTTOM);

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                slideDialog.setContentView(R.layout.activity_sorting);

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());

                //int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.730);

                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                layoutParams.gravity = Gravity.BOTTOM;

                slideDialog.getWindow().setAttributes(layoutParams);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);

                radio1 = slideDialog.findViewById(R.id.radio1);
                radio2 = slideDialog.findViewById(R.id.radio2);
                radio3 = slideDialog.findViewById(R.id.radio3);
                radio4 = slideDialog.findViewById(R.id.radio4);

                sort_txt = slideDialog.findViewById(R.id.sort_txt);
                cuisines_txt = slideDialog.findViewById(R.id.cuisines_txt);
                offers_txt = slideDialog.findViewById(R.id.offers_txt);

                select_item_linear =  slideDialog.findViewById(R.id.select_item_linear);

                cancel = slideDialog.findViewById(R.id.cancel);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        slideDialog.dismiss();
                    }
                });

//
//                apply_btn = slideDialog.findViewById(R.id.apply_btn);
//                apply_btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent i = new Intent(getBaseContext(),SearchActivity.class);
//                        startActivity(i);
//                    }
//                });
                radio1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        radio1.setChecked(true);
                        radio2.setChecked(false);
                        radio3.setChecked(false);
                        radio4.setChecked(false);
                    }
                });

                radio2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        radio1.setChecked(false);
                        radio2.setChecked(true);
                        radio3.setChecked(false);
                        radio4.setChecked(false);
                    }
                });

                radio3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        radio1.setChecked(false);
                        radio2.setChecked(false);
                        radio3.setChecked(true);
                        radio4.setChecked(false);
                    }
                });

                radio4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        radio1.setChecked(false);
                        radio2.setChecked(false);
                        radio3.setChecked(false);
                        radio4.setChecked(true);
                    }
                });

                sort_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sort_txt.setTextColor(Color.parseColor("#1c1a2f"));
                        cuisines_txt.setTextColor(Color.parseColor("#777779"));
                        offers_txt.setTextColor(Color.parseColor("#777779"));

                        sort_txt.setBackgroundResource(R.drawable.rectangle_white);
                        cuisines_txt.setBackgroundResource(R.drawable.rectangle_darkgray);
                        offers_txt.setBackgroundResource(R.drawable.rectangle_darkgray);

                        select_item_linear.setVisibility(View.VISIBLE);

                        radio1.setVisibility(View.VISIBLE);
                        radio2.setVisibility(View.VISIBLE);
                        radio3.setVisibility(View.VISIBLE);
                        radio4.setVisibility(View.VISIBLE);
                    }
                });


                cuisines_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        sort_txt.setTextColor(Color.parseColor("#777779"));
                        cuisines_txt.setTextColor(Color.parseColor("#1c1a2f"));
                        offers_txt.setTextColor(Color.parseColor("#777779"));

                        sort_txt.setBackgroundResource(R.drawable.rectangle_darkgray);
                        cuisines_txt.setBackgroundResource(R.drawable.rectangle_white);
                        offers_txt.setBackgroundResource(R.drawable.rectangle_darkgray);

                        select_item_linear.setVisibility(View.VISIBLE);

                        radio1.setVisibility(View.VISIBLE);
                        radio2.setVisibility(View.VISIBLE);
                        radio3.setVisibility(View.VISIBLE);
                        radio4.setVisibility(View.GONE);
                    }
                });
                offers_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sort_txt.setTextColor(Color.parseColor("#777779"));
                        cuisines_txt.setTextColor(Color.parseColor("#777779"));
                        offers_txt.setTextColor(Color.parseColor("#1c1a2f"));

                        sort_txt.setBackgroundResource(R.drawable.rectangle_darkgray);
                        cuisines_txt.setBackgroundResource(R.drawable.rectangle_darkgray);
                        offers_txt.setBackgroundResource(R.drawable.rectangle_white);

                        select_item_linear.setVisibility(View.VISIBLE);

                        radio1.setVisibility(View.VISIBLE);
                        radio2.setVisibility(View.VISIBLE);
                        radio3.setVisibility(View.GONE);
                        radio4.setVisibility(View.GONE);
                    }
                });

                slideDialog.show();
            }
        });
//        /*-------Spinner Code---------------*/
//        spinner = findViewById(R.id.spinner);
//
//        List<String> list = new ArrayList<String>();
//        list.add("HOME");
//        list.add("HOME");
//        list.add("HOME");
//        list.add("HOME");
//        list.add("HOME");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(HomePageNavigationActivity.this, R.layout.item_spinnerdata,
//                R.id.spinner_text1, list);
//        spinner.setAdapter(dataAdapter);
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
