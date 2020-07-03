package ws.design.stardelivery;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import androidx.core.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import adapter.FoodItaliAdapter;
import model.FoodItaliModel;

public class FavouriteRestaurantActivity extends AppCompatActivity {
    Integer[] pavbhaji = {R.drawable.pavbhaji, R.drawable.panipuri, R.drawable.panner,
            R.drawable.tawarice, R.drawable.matersabji, R.drawable.popato,R.drawable.pavbhaji, R.drawable.panipuri, R.drawable.panner,
            R.drawable.tawarice, R.drawable.matersabji, R.drawable.popato};

    String[] address = {"North Indian", "North Indian, italian, deserts", "North Indian"
            , "North Indian", "North Indian", "North Indian","North Indian", "North Indian, italian, deserts", "North Indian"
            , "North Indian", "North Indian", "North Indian"};

    private RecyclerView recyclerView1;
    private FoodItaliAdapter foodItaliAdapter;
    private ArrayList<FoodItaliModel> foodItaliModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_restaurant);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*----------Recycler view code------------*/
        recyclerView1 = findViewById(R.id.offer_recycle);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(FavouriteRestaurantActivity.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        foodItaliModels = new ArrayList<>();

        for (int i = 0; i < pavbhaji.length; i++) {
            FoodItaliModel ab = new FoodItaliModel(pavbhaji[i], address[i]);
            foodItaliModels.add(ab);
        }
        foodItaliAdapter = new FoodItaliAdapter(FavouriteRestaurantActivity.this, foodItaliModels);
        recyclerView1.setAdapter(foodItaliAdapter);


        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        ctl.setTitle("Favourite Restaurants");
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
