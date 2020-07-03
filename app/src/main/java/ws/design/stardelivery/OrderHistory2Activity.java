package ws.design.stardelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import adapter.AccountAdapter;
import adapter.OrderHistory2Adapter;
import model.AccountModel;
import model.OrderHistory2Model;

public class OrderHistory2Activity extends AppCompatActivity {

    String [] delivered_txt = {"TRACK ORDER","DELIVERED","DELIVERED","DELIVERED"};

    private RecyclerView recyclerView;
    private OrderHistory2Adapter orderHistory2Adapter;
    private ArrayList<OrderHistory2Model> orderHistory2Models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history2);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.orderHistory_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OrderHistory2Activity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        orderHistory2Models = new ArrayList<>();

        for (int i = 0; i < delivered_txt.length; i++) {
            OrderHistory2Model ab = new OrderHistory2Model(delivered_txt[i]);
            orderHistory2Models.add(ab);
        }
        orderHistory2Adapter = new OrderHistory2Adapter(OrderHistory2Activity.this, orderHistory2Models);
        recyclerView.setAdapter(orderHistory2Adapter);
    }
}
