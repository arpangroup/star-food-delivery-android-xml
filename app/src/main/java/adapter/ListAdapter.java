package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.ListModel;
import ws.design.stardelivery.AddDeliveryLocationActivity;
import ws.design.stardelivery.AddNewCardActivity;
import ws.design.stardelivery.CartActivity;
import ws.design.stardelivery.ChangeAddressActivity;
import ws.design.stardelivery.CuisineDetailActivity;
import ws.design.stardelivery.CuisinesActivity;
import ws.design.stardelivery.FavouriteRestaurantActivity;
import ws.design.stardelivery.HomePageOrderStatusActivity;
import ws.design.stardelivery.HomePageWithRateFoodActivity;
import ws.design.stardelivery.HomePageNavigationActivity;
import ws.design.stardelivery.IndividualItem1Activity;
import ws.design.stardelivery.IndividualItemActivity;
import ws.design.stardelivery.LocationActivity;
import ws.design.stardelivery.MoreDetail1Activity;
import ws.design.stardelivery.MoreDetail2Activity;
import ws.design.stardelivery.MyAccountPageActivity;
import ws.design.stardelivery.OTPActivity;
import ws.design.stardelivery.OfferActivity;
import ws.design.stardelivery.OffersActivity;
import ws.design.stardelivery.MoreDetail3Activity;
import ws.design.stardelivery.OnTheWayActivity;
import ws.design.stardelivery.OrderHistory1Activity;
import ws.design.stardelivery.OrderHistory2Activity;
import ws.design.stardelivery.PaymentMethodsActivity;
import ws.design.stardelivery.PaymentsActivity;
import ws.design.stardelivery.R;
import ws.design.stardelivery.RecommendedActivity;
import ws.design.stardelivery.RestaurantProfile1Activity;
import ws.design.stardelivery.RestaurantSearchActivity;
import ws.design.stardelivery.SavedAddressesActivity;
import ws.design.stardelivery.SearchActivity;
import ws.design.stardelivery.SignUp2Activity;
import ws.design.stardelivery.SignUp1Activity;
import ws.design.stardelivery.SplashScreenActivity;
import ws.design.stardelivery.LoginScreenActivity;
import ws.design.stardelivery.TrackOrder1Activity;
import ws.design.stardelivery.TrackOrder2Activity;
import ws.design.stardelivery.TrackOrder3Activity;
import ws.design.stardelivery.TrackOrder4Activity;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Context context;
    ArrayList<ListModel> models;

    public ListAdapter(Context context, ArrayList<ListModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ViewHolder holder, final int position) {
        holder.text_list.setText(models.get(position).getText_list());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent i = new Intent(context, SplashScreenActivity.class);
                    context.startActivity(i); }
                else if (position == 1) {
                    Intent i = new Intent(context, SignUp1Activity.class);
                    context.startActivity(i); }
                else if (position == 2) {
                    Intent i = new Intent(context, SignUp2Activity.class);
                    context.startActivity(i); }
                else if (position == 3) {
                    Intent i = new Intent(context, OTPActivity.class);
                    context.startActivity(i); }
                else if (position == 4) {
                    Intent i = new Intent(context, LoginScreenActivity.class);
                    context.startActivity(i); }
                else if (position == 5) {
                    Intent i = new Intent(context, OffersActivity.class);
                    context.startActivity(i); }
                else if (position == 6) {
                    Intent i = new Intent(context, OfferActivity.class);
                    context.startActivity(i); }
                else if (position == 7) {
                    Intent i = new Intent(context, CuisinesActivity.class);
                    context.startActivity(i); }
                else if (position == 8) {
                    Intent i = new Intent(context, CuisineDetailActivity.class);
                    context.startActivity(i); }
                else if (position == 9) {
                    Intent i = new Intent(context, RestaurantSearchActivity.class);
                    context.startActivity(i); }
                else if (position == 10) {
                    Intent i = new Intent(context, SearchActivity.class);
                    context.startActivity(i); }
                else if (position == 11) {
                    Intent i = new Intent(context, AddNewCardActivity.class);
                    context.startActivity(i); }
                else if (position == 12) {
                    Intent i = new Intent(context, IndividualItemActivity.class);
                    context.startActivity(i); }
                else if (position == 13) {
                    Intent i = new Intent(context, IndividualItem1Activity.class);
                    context.startActivity(i); }
                else if (position == 14) {
                    Intent i = new Intent(context, RestaurantProfile1Activity.class);
                    context.startActivity(i); }
                else if (position == 15) {
                    Intent i = new Intent(context, RecommendedActivity.class);
                    context.startActivity(i); }
                else if (position == 16) {
                    Intent i = new Intent(context, FavouriteRestaurantActivity.class);
                    context.startActivity(i); }
                else if (position == 17) {
                    Intent i = new Intent(context, HomePageNavigationActivity.class);
                    context.startActivity(i); }
                else if (position == 18) {
                    Intent i = new Intent(context, HomePageOrderStatusActivity.class);
                    context.startActivity(i); }
                else if (position == 19) {
                    Intent i = new Intent(context, HomePageWithRateFoodActivity.class);
                    context.startActivity(i); }
                else if (position == 20) {
                    Intent i = new Intent(context, CartActivity.class);
                    context.startActivity(i); }
                else if (position == 21) {
                    Intent i = new Intent(context, OrderHistory1Activity.class);
                    context.startActivity(i); }
                else if (position == 22) {
                    Intent i = new Intent(context, OrderHistory2Activity.class);
                    context.startActivity(i); }
                else if (position == 23) {
                    Intent i = new Intent(context, LocationActivity.class);
                    context.startActivity(i); }
                else if (position == 24) {
                    Intent i = new Intent(context, ChangeAddressActivity.class);
                    context.startActivity(i); }
                else if (position == 25) {
                    Intent i = new Intent(context, SavedAddressesActivity.class);
                    context.startActivity(i); }
                else if (position == 26) {
                    Intent i = new Intent(context, MoreDetail1Activity.class);
                    context.startActivity(i); }
                else if (position == 27) {
                    Intent i = new Intent(context, MoreDetail2Activity.class);
                    context.startActivity(i); }
                else if (position == 28) {
                    Intent i = new Intent(context, MoreDetail3Activity.class);
                    context.startActivity(i); }
                else if (position == 29) {
                    Intent i = new Intent(context, PaymentsActivity.class);
                    context.startActivity(i); }
                else if (position == 30) {
                    Intent i = new Intent(context, PaymentMethodsActivity.class);
                    context.startActivity(i); }
                else if (position == 31) {
                    Intent i = new Intent(context, MyAccountPageActivity.class);
                    context.startActivity(i); }
                else if (position == 32) {
                    Intent i = new Intent(context, AddDeliveryLocationActivity.class);
                    context.startActivity(i); }
                else if (position == 33) {
                    Intent i = new Intent(context, TrackOrder1Activity.class);
                    context.startActivity(i); }
                else if (position == 34) {
                    Intent i = new Intent(context, TrackOrder2Activity.class);
                    context.startActivity(i); }
                else if (position == 35) {
                    Intent i = new Intent(context, TrackOrder3Activity.class);
                    context.startActivity(i); }
                else if (position == 36) {
                    Intent i = new Intent(context, TrackOrder4Activity.class);
                    context.startActivity(i); }
                else if (position == 37) {
                    Intent i = new Intent(context, OnTheWayActivity.class);
                    context.startActivity(i); }
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_list;

        public ViewHolder(View itemView) {
            super(itemView);
            text_list = itemView.findViewById(R.id.text_list);
        }
    }
}
