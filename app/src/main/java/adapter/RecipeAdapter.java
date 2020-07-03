package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import model.FoodModel;
import model.RecommendedModel;
import ws.design.stardelivery.CartActivity;
import ws.design.stardelivery.R;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    Context context;
    ArrayList<RecommendedModel> models;

    int defult = 220;
    int result;

    public RecipeAdapter(Context context, ArrayList<RecommendedModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeAdapter.ViewHolder holder, final int position) {

        holder.birani.setImageResource(models.get(position).getBirani());

        holder.rice_txt.setText(models.get(position).getRice_txt());
        holder.paneer_txt.setText(models.get(position).getPaneer_txt());

        holder.add_item_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.add_item_txt.setVisibility(View.GONE);
                holder.add_cart_linear.setVisibility(View.VISIBLE);

            }
        });

        holder.plus_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(String.valueOf(holder.increase_txt.getText()));
                count++;
                result = defult * count;
                holder.increase_txt.setText(String.valueOf(count));
                holder.total.setText(String.valueOf(result));
                Animation animation1 = AnimationUtils.loadAnimation(context, R.anim.slide_up);
                holder.increase_txt.startAnimation(animation1);
            }
        });

        holder.minus_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(String.valueOf(holder.increase_txt.getText()));
//                condition last value is 1
                if (count > 1) {
                    count--;
                    result = result - defult;
                    // result = defult - count;
                    holder.increase_txt.setText(String.valueOf(count));
                    holder.total.setText(String.valueOf(result));
                } else {
                    holder.add_item_txt.setVisibility(View.VISIBLE);
                    holder.add_cart_linear.setVisibility(View.GONE);
                }
                Animation animation1 = AnimationUtils.loadAnimation(context, R.anim.slide_down);
                holder.increase_txt.startAnimation(animation1);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CartActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView birani;
        TextView rice_txt, paneer_txt;

        TextView plus_text, increase_txt, minus_txt, add_item_txt, total;
        LinearLayout add_cart_linear;

        public ViewHolder(View itemView) {
            super(itemView);
            birani = itemView.findViewById(R.id.birani);
            rice_txt = itemView.findViewById(R.id.rice_txt);
            paneer_txt = itemView.findViewById(R.id.paneer_txt);

            plus_text = itemView.findViewById(R.id.plus_text);
            increase_txt = itemView.findViewById(R.id.increase_txt);
            minus_txt = itemView.findViewById(R.id.minus_txt);

            add_item_txt = itemView.findViewById(R.id.add_item_txt);
            add_cart_linear = itemView.findViewById(R.id.add_cart_linear);
            total = itemView.findViewById(R.id.total);
        }
    }
}
