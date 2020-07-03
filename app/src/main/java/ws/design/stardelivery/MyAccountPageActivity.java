package ws.design.stardelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import adapter.AccountAdapter;
import adapter.CuisinesAdapter;
import adapter.ListAdapter;
import model.AccountModel;
import model.CuisinesModel;
import model.ListModel;

public class MyAccountPageActivity extends AppCompatActivity {

    LinearLayout myAccount_1, myAccount_2, linear_selection,food_linear1, food_linear2, favourite_linear;


    String[] pavbhaji_txt = {"Pavbhaji 2X, Extra bun 4X", "Chole Kulche 1X, Kulcha 3X,\nPepsi 500ml 3X"};
    Integer[] pavbhaji_img = {R.drawable.pavbhaji, R.drawable.chana_img};

    RecyclerView recyclerView;
    AccountAdapter accountAdapter;
    ArrayList<AccountModel> accountModels;

    LinearLayout manage_linear,payment_linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_page);

        food_linear1 = (LinearLayout) findViewById(R.id.food_linear1);
        food_linear2 = (LinearLayout) findViewById(R.id.food_linear2);

        manage_linear = findViewById(R.id.manage_linear);
        manage_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),SavedAddressesActivity.class);
                startActivity(i);
            }
        });

        payment_linear = findViewById(R.id.payment_linear);
        payment_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),PaymentMethodsActivity.class);
                startActivity(i);
            }
        });

        favourite_linear = findViewById(R.id.favourite_linear);
        favourite_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), FavouriteRestaurantActivity.class);
                startActivity(i);
            }
        });

        food_linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food_linear1.setVisibility(View.GONE);
                food_linear2.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        food_linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food_linear1.setVisibility(View.VISIBLE);
                food_linear2.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
            }
        });

        /*----------Recycler view code------------*/
        recyclerView = findViewById(R.id.food_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyAccountPageActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        accountModels = new ArrayList<>();

        for (int i = 0; i < pavbhaji_txt.length; i++) {
            AccountModel ab = new AccountModel(pavbhaji_txt[i], pavbhaji_img[i]);
            accountModels.add(ab);
        }
        accountAdapter = new AccountAdapter(MyAccountPageActivity.this, accountModels);
        recyclerView.setAdapter(accountAdapter);

        myAccount_1 = (LinearLayout) findViewById(R.id.myAccount_1);
        myAccount_2 = (LinearLayout) findViewById(R.id.myAccount_2);
        linear_selection = (LinearLayout) findViewById(R.id.linear_selection);

        myAccount_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myAccount_1.setVisibility(View.GONE);
                myAccount_2.setVisibility(View.VISIBLE);
                linear_selection.setVisibility(View.VISIBLE);

            }
        });

        myAccount_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAccount_1.setVisibility(View.VISIBLE);
                myAccount_2.setVisibility(View.GONE);
                linear_selection.setVisibility(View.GONE);
            }
        });
    }
}
