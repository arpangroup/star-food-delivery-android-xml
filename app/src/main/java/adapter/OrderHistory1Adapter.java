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

import model.AccountModel;
import model.OrderHistory1Model;
import ws.design.stardelivery.MoreDetail3Activity;
import ws.design.stardelivery.R;

public class OrderHistory1Adapter extends RecyclerView.Adapter<OrderHistory1Adapter.ViewHolder> {

    Context context;
    ArrayList<OrderHistory1Model> models;

    public OrderHistory1Adapter(Context context, ArrayList<OrderHistory1Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public OrderHistory1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orderhistory1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderHistory1Adapter.ViewHolder holder, final int position) {

        holder.pavbhaji_img.setImageResource(models.get(position).getPavbhaji_img());
        holder.delivered_txt.setText(models.get(position).getDelivered_txt());

        if(position == 0){
            holder.delivered_txt.setBackgroundResource(R.drawable.rectangle_green);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(context, MoreDetail3Activity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pavbhaji_img;
        TextView delivered_txt;

        public ViewHolder(View itemView) {
            super(itemView);
            pavbhaji_img = itemView.findViewById(R.id.pavbhaji_img);
            delivered_txt = itemView.findViewById(R.id.delivered_txt);
        }
    }
}
