package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import model.AccountModel;
import ws.design.stardelivery.MoreDetail3Activity;
import ws.design.stardelivery.OrderHistory1Activity;
import ws.design.stardelivery.R;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

    Context context;
    ArrayList<AccountModel> models;

    public AccountAdapter(Context context, ArrayList<AccountModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public AccountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AccountAdapter.ViewHolder holder, final int position) {

        holder.pavbhaji_txt.setText(models.get(position).getPavbhaji_txt());
        holder.pavbhaji_img.setImageResource(models.get(position).getPavbhaji_img());

        if (position == 0) {
            holder.view_line.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, OrderHistory1Activity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView pavbhaji_txt;
        ImageView pavbhaji_img, view_line;

        public ViewHolder(View itemView) {
            super(itemView);
            pavbhaji_txt = itemView.findViewById(R.id.pavbhaji_txt);
            view_line = itemView.findViewById(R.id.view_line);
            pavbhaji_img = itemView.findViewById(R.id.pavbhaji_img);
        }
    }
}
