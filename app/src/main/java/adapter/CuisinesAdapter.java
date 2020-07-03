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

import model.CuisinesModel;
import model.FoodModel;
import ws.design.stardelivery.R;

public class CuisinesAdapter extends RecyclerView.Adapter<CuisinesAdapter.ViewHolder> {

    Context context;
    ArrayList<CuisinesModel> models;

    public CuisinesAdapter(Context context, ArrayList<CuisinesModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public CuisinesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cuisines, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CuisinesAdapter.ViewHolder holder, final int position) {
        holder.chinesses_img.setImageResource(models.get(position).getChinesses_img());

        holder.no_of_restaurants_txt.setText(models.get(position).getNo_of_restaurants_txt());
        holder.chinesses_txt.setText(models.get(position).getChinesses_txt());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView chinesses_img;
        TextView no_of_restaurants_txt,chinesses_txt;

        public ViewHolder(View itemView) {
            super(itemView);
            chinesses_img = itemView.findViewById(R.id.chinesses_img);
            no_of_restaurants_txt = itemView.findViewById(R.id.no_of_restaurants_txt);
            chinesses_txt = itemView.findViewById(R.id.chinesses_txt);
        }
    }
}
