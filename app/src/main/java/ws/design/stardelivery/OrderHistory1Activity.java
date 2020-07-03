package ws.design.stardelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import adapter.OrderHistory1Adapter;
import adapter.OrderHistory2Adapter;
import model.OrderHistory1Model;
import model.OrderHistory2Model;

public class OrderHistory1Activity extends AppCompatActivity {

    Integer [] pavbhaji_img = {R.drawable.pavbhaji,R.drawable.chana_img,R.drawable.pavbhaji,R.drawable.chana_img};
    String [] delivered_txt = {"TRACK ORDER","DELIVERED","DELIVERED","DELIVERED"};

    private RecyclerView recyclerView;
    private OrderHistory1Adapter orderHistory1Adapter;
    private ArrayList<OrderHistory1Model> orderHistory1Models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history1);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.orderHistory_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OrderHistory1Activity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        orderHistory1Models = new ArrayList<>();

        for (int i = 0; i < pavbhaji_img.length; i++) {
            OrderHistory1Model ab = new OrderHistory1Model(pavbhaji_img[i],delivered_txt[i]);
            orderHistory1Models.add(ab);
        }
        orderHistory1Adapter = new OrderHistory1Adapter(OrderHistory1Activity.this, orderHistory1Models);
        recyclerView.setAdapter(orderHistory1Adapter);
    }
}
