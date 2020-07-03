package ws.design.stardelivery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import adapter.ListAdapter;
import model.ListModel;

public class ListActivity extends AppCompatActivity {


    String[] text_list = {"1.SplashScreenActivity","2.SignUp1Activity","3.SignUp2Activity",
            "4.OTPActivity","5.LoginScreenActivity","6.OffersActivity",
            "7.OfferActivity","8.CuisinesActivity","9.CuisineDetailActivity",
            "10.RestaurantSearchActivity", "11.SearchActivity","12.AddNewCardActivity",
            "13.IndividualItemActivity","14.IndividualItemActivity1","15.RestaurantProfile1Activity",
            "16.RecommendedActivity","17.FavouriteRestaurantActivity","18.HomePageNavigationActivity",
            "19.HomePageOrderStatusActivity","20.HomePageWithRateFoodActivity","21.CartActivity",
            "22.OrderHistory1Activity","23.OrderHistory2Activity","24.LocationActivity",
            "25.ChangeAddressActivity","26.SavedAddressesActivity","27.MoreDetail1Activity",
            "28.MoreDetail2Activity","29.MoreDetail3Activity","30.PaymentsActivity",
            "31.PaymentMethodsActivity","32.MyAccountPageActivity","33.AddDeliveryLocationActivity",
            "34.TrackOrder1Activity","35.TrackOrder2Activity","36.TrackOrder3Activity",
            "37.TrackOrder4Activity","38.OnTheWayActivity"};

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private ArrayList<ListModel> listModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.list_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        listModels = new ArrayList<>();

        for (int i = 0; i < text_list.length; i++) {
            ListModel ab = new ListModel(text_list[i]);
            listModels.add(ab);
        }
        listAdapter = new ListAdapter(ListActivity.this, listModels);
        recyclerView.setAdapter(listAdapter);
    }
}
