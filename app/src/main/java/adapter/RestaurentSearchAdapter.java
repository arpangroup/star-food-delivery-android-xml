package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import model.RestaurentSearchModel;
import model.SearchModel;
import ws.design.stardelivery.R;

public class RestaurentSearchAdapter extends RecyclerView.Adapter<RestaurentSearchAdapter.ViewHolder> {

    Context context;
    ArrayList<RestaurentSearchModel> models;

    public RestaurentSearchAdapter(Context context, ArrayList<RestaurentSearchModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public RestaurentSearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurent_search, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RestaurentSearchAdapter.ViewHolder holder, final int position) {
        holder.brown_burger_txt.setText(models.get(position).getBrown_burger_txt());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView brown_burger_txt;

        public ViewHolder(View itemView) {
            super(itemView);
            brown_burger_txt = itemView.findViewById(R.id.brown_burger_txt);
        }
    }
}
