package ws.design.stardelivery;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Objects;

import adapter.BasmatiAdapter;
import adapter.RecommendedAdapter;
import model.BasmatiModel;
import model.RecommendedModel;

public class RestaurantProfile1Activity extends AppCompatActivity {

    Integer[] birani = {R.drawable.birani1, R.drawable.birani2, R.drawable.birani3,
            R.drawable.birani4, R.drawable.birani5, R.drawable.birani6};

    String[] rice_txt = {"Basmati Rice Lunchbox", "Basmati Rice Lunchbox", "Kulcha Bread Lunchbox"
            , "Basmati Rice Lunchbox", "Maji Varieties", "Maji Varieties"};

    String[] panner_txt = {"Paneer Biryani", "Chicken Biryani", "Chole Kulcha Lunchbox "
            , "Dal Makhani & Rice", "Egg Afghani Thou", "Egg Afghani Thou"};

     RecyclerView recyclerView1;
     RecommendedAdapter recommendedAdapter;
     ArrayList<RecommendedModel> recommendedModels;

    Button btn_menu;


    Integer[] nonveg_img = {R.drawable.ic_nonveg, R.drawable.ic_nonveg, R.drawable.ic_nonveg,
            R.drawable.ic_nonveg};
    String[] biryani_txt = {"Paneer Biryani", "Chicken Biryani", "Rajma Chawal Lunchbox",
            "Paneer Methi Chaman & Rice\nLunchbox"};

     RecyclerView basmatirice_recycle;
     BasmatiAdapter basmatiAdapter;
     ArrayList<BasmatiModel> basmatiModels;

    Integer[] nonveg_img1 = {R.drawable.ic_nonveg, R.drawable.ic_nonveg, R.drawable.ic_nonveg,
            R.drawable.ic_nonveg};
    String[] biryani_txt1 = {"Paneer Biryani", "Chicken Biryani", "Rajma Chawal Lunchbox",
            "Paneer Methi Chaman & Rice\nLunchbox"};

     RecyclerView recyclerView3;
     BasmatiAdapter basmatiAdapter1;
     ArrayList<BasmatiModel> basmatiModels1;

    RelativeLayout relative_layout;

    ImageView search_Img;
    Dialog slideDialog;

    LinearLayout linear_up,linear_down,linear_kulcha_down,linear_kulcha_up;
    LinearLayout item_incrementcart_linear;
    LinearLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_profile1);


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        item_incrementcart_linear = findViewById(R.id.item_incrementcart_linear);

//1
        recyclerView1 = findViewById(R.id.recommended_recycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(RestaurantProfile1Activity.this, 2);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        recommendedModels = new ArrayList<>();

        for (int i = 0; i < birani.length; i++) {
            RecommendedModel ab = new RecommendedModel(birani[i], rice_txt[i], panner_txt[i]);
            recommendedModels.add(ab);
        }
        recommendedAdapter = new RecommendedAdapter(RestaurantProfile1Activity.this, recommendedModels);
        recyclerView1.setAdapter(recommendedAdapter);

//        2

        basmatirice_recycle = findViewById(R.id.basmatirice_recycle);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(RestaurantProfile1Activity.this);
        basmatirice_recycle.setLayoutManager(layoutManager1);
        basmatirice_recycle.setItemAnimator(new DefaultItemAnimator());

        basmatiModels = new ArrayList<>();

        for (int i = 0; i < nonveg_img.length; i++) {
            BasmatiModel ab = new BasmatiModel(nonveg_img[i], biryani_txt[i]);
            basmatiModels.add(ab);
        }
        basmatiAdapter = new BasmatiAdapter(RestaurantProfile1Activity.this, basmatiModels);
        basmatirice_recycle.setAdapter(basmatiAdapter);
//3
        recyclerView3 = findViewById(R.id.kulcha_recycle);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(RestaurantProfile1Activity.this);
        recyclerView3.setLayoutManager(layoutManager2);
        recyclerView3.setItemAnimator(new DefaultItemAnimator());

        basmatiModels1 = new ArrayList<>();

        for (int i = 0; i < nonveg_img1.length; i++) {
            BasmatiModel ab = new BasmatiModel(nonveg_img1[i], biryani_txt1[i]);
            basmatiModels1.add(ab);
        }
        basmatiAdapter1 = new BasmatiAdapter(RestaurantProfile1Activity.this, basmatiModels1);
        recyclerView3.setAdapter(basmatiAdapter1);

        btn_menu = findViewById(R.id.btn_menu);

        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,0,0,50);
        btn_menu.setLayoutParams(params);

        relative_layout = (RelativeLayout) findViewById(R.id.relative_layout);

        search_Img = findViewById(R.id.search_Img);
        search_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slideDialog = new Dialog(RestaurantProfile1Activity.this, R.style.CustomDialogAnimation1);
                Objects.requireNonNull(slideDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                // Setting dialogview
                Window window = slideDialog.getWindow();
              window.setGravity(Gravity.TOP);

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                slideDialog.setContentView(R.layout.layout_searchitem);

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());

                //int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.480);

                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                layoutParams.gravity = Gravity.TOP;

                slideDialog.getWindow().setAttributes(layoutParams);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();
            }
        });

        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                slideDialog = new Dialog(RestaurantProfile1Activity.this, R.style.CustomDialogAnimation);
                Objects.requireNonNull(slideDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                // Setting dialogview
                Window window = slideDialog.getWindow();
                  window.setGravity(Gravity.TOP);

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                slideDialog.setContentView(R.layout.restaurant_profile_menu_popup);

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());

                //int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.90);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.580);

                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                layoutParams.gravity = Gravity.BOTTOM;

                slideDialog.getWindow().setAttributes(layoutParams);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();
            }
        });


        linear_up = findViewById(R.id.linear_up);
        linear_down = findViewById(R.id.linear_down);

        linear_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_up.setVisibility(View.GONE);
                linear_down.setVisibility(View.VISIBLE);
                basmatirice_recycle.setVisibility(View.VISIBLE);
            }
        });

        linear_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_down.setVisibility(View.GONE);
                linear_up.setVisibility(View.VISIBLE);
                basmatirice_recycle.setVisibility(View.GONE);
            }
        });

        linear_kulcha_down = findViewById(R.id.linear_kulcha_down);
        linear_kulcha_up = findViewById(R.id.linear_kulcha_up);

        linear_kulcha_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_kulcha_up.setVisibility(View.GONE);
                linear_kulcha_down.setVisibility(View.VISIBLE);
                recyclerView3.setVisibility(View.VISIBLE);
            }
        });

        linear_kulcha_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_kulcha_down.setVisibility(View.GONE);
                linear_kulcha_up.setVisibility(View.VISIBLE);
                recyclerView3.setVisibility(View.GONE);
            }
        });
    }

    public void snakbarLayout() {
        item_incrementcart_linear.setVisibility(View.VISIBLE);
        params.setMargins(0,0,0,15);
        btn_menu.setLayoutParams(params);
    }

    public void snakbarLayout2() {
    item_incrementcart_linear.setVisibility(View.GONE);
    }
}