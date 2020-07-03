package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.AccountModel;
import model.OrderHistory2Model;
import ws.design.stardelivery.R;

public class OrderHistory2Adapter extends RecyclerView.Adapter<OrderHistory2Adapter.ViewHolder> {

    Context context;
    ArrayList<OrderHistory2Model> models;

    public OrderHistory2Adapter(Context context, ArrayList<OrderHistory2Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public OrderHistory2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orderhistory2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderHistory2Adapter.ViewHolder holder, final int position) {

        holder.delivered_txt.setText(models.get(position).getDelivered_txt());

        if(position == 0){
            holder.delivered_txt.setBackgroundResource(R.drawable.rectangle_green);
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView delivered_txt;

        public ViewHolder(View itemView) {
            super(itemView);
            delivered_txt = itemView.findViewById(R.id.delivered_txt);
        }
    }
}
