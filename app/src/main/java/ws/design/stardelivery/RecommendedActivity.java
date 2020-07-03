package ws.design.stardelivery;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.RecipeAdapter;
import model.RecommendedModel;

public class RecommendedActivity extends AppCompatActivity {

    Integer[] birani = {R.drawable.recommendedimg1, R.drawable.recommendedimg2, R.drawable.recommendedimg3,
            R.drawable.recommendedimg1, R.drawable.recommendedimg1, R.drawable.recommendedimg2, R.drawable.recommendedimg3,
            R.drawable.recommendedimg1};

    String[] rice_txt = {"Basmati Rice Lunchbox","Basmati Rice Lunchbox","Basmati Rice Lunchbox",
    "Basmati Rice Lunchbox","Basmati Rice Lunchbox","Basmati Rice Lunchbox","Basmati Rice Lunchbox",
    "Basmati Rice Lunchbox"};

    String[] paneer_txt = {"Paneer Biryani","Paneer Biryani","Paneer Biryani","Paneer Biryani",
    "Paneer Biryani","Paneer Biryani","Paneer Biryani","Paneer Biryani"};

    private RecyclerView recyclerView;
    private RecipeAdapter recipiAdapter;
    private ArrayList<RecommendedModel> foodModels;

    TextView number_Txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended);


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        number_Txt = findViewById(R.id.number_Txt);

        recyclerView = findViewById(R.id.recipi_recycle);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecommendedActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        foodModels = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            RecommendedModel ab = new RecommendedModel(birani[i], rice_txt[i], paneer_txt[i]);
            foodModels.add(ab);
        }
        recipiAdapter = new RecipeAdapter(RecommendedActivity.this, foodModels);
        recyclerView.setAdapter(recipiAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
                    number_Txt.setText(String.valueOf(0 + 1));
                } else {
                    int pos = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                    number_Txt.setText(String.valueOf(pos + 1));
                }
            }
        });
    }
}