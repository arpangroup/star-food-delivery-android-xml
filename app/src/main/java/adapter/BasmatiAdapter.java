package adapter;

import android.content.Context;
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

import model.BasmatiModel;
import model.FoodModel;
import ws.design.stardelivery.R;

public class BasmatiAdapter extends RecyclerView.Adapter<BasmatiAdapter.ViewHolder> {

    Context context;
    ArrayList<BasmatiModel> models;

    int defult = 143;
    int result;
    public BasmatiAdapter(Context context, ArrayList<BasmatiModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public BasmatiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_basmati, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BasmatiAdapter.ViewHolder holder, final int position) {
        holder.biryani_txt.setText(models.get(position).getBiryani_txt());
    //    holder.price_txt.setText(models.get(position).getPrice_txt());

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
                result = defult*count;
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
                if (count > 1) {
                    count--;
                    result = result - defult;
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
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView nonveg_img;
        TextView biryani_txt,add_item_txt,minus_txt,increase_txt
                ,plus_text,total;
        LinearLayout add_cart_linear;

        public ViewHolder(View itemView) {
            super(itemView);
            nonveg_img = itemView.findViewById(R.id.nonveg_img);
            biryani_txt = itemView.findViewById(R.id.biryani_txt);

            add_item_txt = itemView.findViewById(R.id.add_item_txt);
            minus_txt = itemView.findViewById(R.id.minus_txt);
            increase_txt = itemView.findViewById(R.id.increase_txt);
            plus_text = itemView.findViewById(R.id.plus_text);

            add_cart_linear = itemView.findViewById(R.id.add_cart_linear);
            total = itemView.findViewById(R.id.total);
        }
    }
}
