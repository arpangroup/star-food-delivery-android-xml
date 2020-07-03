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

public class OffersActivity extends AppCompatActivity {

    Integer[] pavbhaji = {R.drawable.pavbhaji,R.drawable.panipuri,R.drawable.panner,
            R.drawable.tawarice,R.drawable.matersabji,R.drawable.popato};

    String[] address = {"North Indian","North Indian, italian, deserts","North Indian"
            ,"North Indian","North Indian","North Indian"};

    private RecyclerView recyclerView1;
    private FoodItaliAdapter foodItaliAdapter;
    private ArrayList<FoodItaliModel> foodItaliModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView1 = findViewById(R.id.offer_recycle);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(OffersActivity.this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        foodItaliModels = new ArrayList<>();

        for (int i = 0; i < pavbhaji.length; i++) {
            FoodItaliModel ab = new FoodItaliModel(pavbhaji[i],address[i]);
            foodItaliModels.add(ab);
        }
        foodItaliAdapter = new FoodItaliAdapter(OffersActivity.this, foodItaliModels);
        recyclerView1.setAdapter(foodItaliAdapter);

    }
}
