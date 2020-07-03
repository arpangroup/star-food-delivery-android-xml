package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.DishesModel;
import ws.design.stardelivery.R;
import ws.design.stardelivery.SearchActivity;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.ViewHolder> {
    Context context;
    ArrayList<DishesModel> models;

    public DishesAdapter(Context context, ArrayList<DishesModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public DishesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dishes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DishesAdapter.ViewHolder holder, final int position) {

        holder.dosa_txt.setText(models.get(position).getDosa_txt());

        holder.dosh_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*--------Fragment load onClick-----------*/
                ((SearchActivity) context).findViewById(R.id.dishes_recycler).setVisibility(View.GONE);
                ((SearchActivity) context).loadFragment();
            }
        });

        if (position == 0) {
            holder.dotted_line.setVisibility(View.VISIBLE);
            holder.dishes_txt.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dosa_txt, dishes_txt;
        LinearLayout dosh_linear;
        View viewline;
        ImageView dotted_line;

        public ViewHolder(View itemView) {
            super(itemView);
            dosa_txt = itemView.findViewById(R.id.dosa_txt);
            dosh_linear = itemView.findViewById(R.id.dosh_linear);
            dishes_txt = itemView.findViewById(R.id.dishes_txt);
            dotted_line = itemView.findViewById(R.id.dotted_line);
            viewline = itemView.findViewById(R.id.viewline);
        }
    }
}