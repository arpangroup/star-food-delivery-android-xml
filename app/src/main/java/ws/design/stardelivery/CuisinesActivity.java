package ws.design.stardelivery;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import androidx.core.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import adapter.CuisinesAdapter;
import model.CuisinesModel;

public class CuisinesActivity extends AppCompatActivity {


    Integer[] chinesses_img = {R.drawable.khaman, R.drawable.saled, R.drawable.panner_roti,
            R.drawable.pasta, R.drawable.rice_mag};

    String[] no_of_restaurants_txt = {"31 Restaurants", "41 Restaurants", "31 Restaurants"
            , "41 Restaurants", "31 Restaurants"};

    String[] chinesses_txt = {"GUJARATI", "CHINESSE", "PUNJABI", "ITILIAN", "INDIAN"};

    private RecyclerView recyclerView;
    private CuisinesAdapter cuisinesAdapter;
    private ArrayList<CuisinesModel> cuisinesModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisines);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.cuisines_recycle);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(CuisinesActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        cuisinesModels = new ArrayList<>();

        for (int i = 0; i < chinesses_img.length; i++) {
            CuisinesModel ab = new CuisinesModel(chinesses_img[i], no_of_restaurants_txt[i], chinesses_txt[i]);
            cuisinesModels.add(ab);
        }
        cuisinesAdapter = new CuisinesAdapter(CuisinesActivity.this, cuisinesModels);
        recyclerView.setAdapter(cuisinesAdapter);


        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        ctl.setTitle("CUISINE’s");
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
