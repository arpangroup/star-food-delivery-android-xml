package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.FoodModel;
import ws.design.stardelivery.OffersActivity;
import ws.design.stardelivery.R;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    Context context;
    ArrayList<FoodModel> models;

    public FoodAdapter(Context context, ArrayList<FoodModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodAdapter.ViewHolder holder, final int position) {
        holder.food_img.setImageResource(models.get(position).getFood_img());

        holder.discount_txt.setText(models.get(position).getDiscount_txt());
        holder.coupon_txt.setText(models.get(position).getCoupon_txt());
        holder.restaurants_txt.setText(models.get(position).getRestaurants_txt());


        if(position == 2){
            holder.discount_txt.setTextColor(Color.parseColor("#ffffff"));
            holder.coupon_txt.setTextColor(Color.parseColor("#ffffff"));
            holder.restaurants_txt.setTextColor(Color.parseColor("#ffffff"));

            holder.shado.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, OffersActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView food_img,shado;
        TextView discount_txt,coupon_txt,restaurants_txt;

        public ViewHolder(View itemView) {
            super(itemView);
            food_img = itemView.findViewById(R.id.food_img);

            discount_txt = itemView.findViewById(R.id.discount_txt);
            coupon_txt = itemView.findViewById(R.id.coupon_txt);
            restaurants_txt = itemView.findViewById(R.id.restaurants_txt);
            shado = itemView.findViewById(R.id.shado);
        }
    }
}
