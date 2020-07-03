package ws.design.stardelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.CuisinesAdapter;
import adapter.SubwayAdapter;
import model.CuisinesModel;
import model.SubwayModel;

public class MultipleOutletsActivity extends AppCompatActivity {

    String opRoad_txt[] = {"OP ROAD, AKOTA","KARELIBAUGH, VADODARA","AKOTA, VADODARA","VASNA ROAD",
    "BHAILI ROADBHAILI ROAD","MANJALPUR"};

    String rating_txt[] = {"3.2","4.6","4.7","2.3","3.9","4.6"};
    String time_txt[] = {"27 MINS","30 MINS","30 MINS","35 MINS","40 MINS","50 MINS"};

    RecyclerView recyclerView;
    SubwayAdapter subwayAdapter;
    ArrayList<SubwayModel>subwayModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_outlets);

        recyclerView = findViewById(R.id.subway_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MultipleOutletsActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        subwayModels = new ArrayList<>();

        for (int i = 0; i < opRoad_txt.length; i++) {
            SubwayModel ab = new SubwayModel(opRoad_txt[i], rating_txt[i], time_txt[i]);
            subwayModels.add(ab);
        }
        subwayAdapter = new SubwayAdapter(MultipleOutletsActivity.this, subwayModels);
        recyclerView.setAdapter(subwayAdapter);
    }
}
