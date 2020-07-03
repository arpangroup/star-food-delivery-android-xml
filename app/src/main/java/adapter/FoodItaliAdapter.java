package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.FoodItaliModel;
import model.FoodModel;
import ws.design.stardelivery.R;
import ws.design.stardelivery.RestaurantProfile1Activity;

public class FoodItaliAdapter extends RecyclerView.Adapter<FoodItaliAdapter.ViewHolder> {

    Context context;
    ArrayList<FoodItaliModel> models;

    public FoodItaliAdapter(Context context, ArrayList<FoodItaliModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public FoodItaliAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fooditali, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodItaliAdapter.ViewHolder holder, final int position) {
        holder.pavbhaji.setImageResource(models.get(position).getPavbhaji());
        holder.address.setText(models.get(position).getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, RestaurantProfile1Activity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pavbhaji;
        TextView address;

        public ViewHolder(View itemView) {
            super(itemView);
            pavbhaji = itemView.findViewById(R.id.pavbhaji);
            address = itemView.findViewById(R.id.address);
        }
    }
}
