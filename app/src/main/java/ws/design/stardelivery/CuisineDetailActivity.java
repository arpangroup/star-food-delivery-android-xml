package ws.design.stardelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import adapter.FoodItaliAdapter;
import model.FoodItaliModel;

public class CuisineDetailActivity extends AppCompatActivity {

    Integer[] pavbhaji = {R.drawable.pavbhaji, R.drawable.panipuri, R.drawable.panner,
            R.drawable.tawarice, R.drawable.matersabji, R.drawable.popato,
            R.drawable.pavbhaji, R.drawable.panipuri, R.drawable.panner,
            R.drawable.tawarice, R.drawable.matersabji, R.drawable.popato};

    String[] address = {"North Indian, italian, deserts", "North Indian", "North Indian"
            , "North Indian", "North Indian", "North Indian","North Indian, italian," +
            " deserts", "North Indian", "North Indian"
            , "North Indian", "North Indian", "North Indian"};

    private RecyclerView recyclerView;
    private FoodItaliAdapter foodItaliAdapter;
    private ArrayList<FoodItaliModel> foodItaliModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_detail);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.cuisines_recycle);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(CuisineDetailActivity.this);
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        foodItaliModels = new ArrayList<>();

        for (int i = 0; i < pavbhaji.length; i++) {
            FoodItaliModel ab = new FoodItaliModel(pavbhaji[i], address[i]);
            foodItaliModels.add(ab);
        }
        foodItaliAdapter = new FoodItaliAdapter(CuisineDetailActivity.this, foodItaliModels);
        recyclerView.setAdapter(foodItaliAdapter);
    }
}