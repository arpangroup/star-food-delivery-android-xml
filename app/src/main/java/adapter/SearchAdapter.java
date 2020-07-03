package adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.ArrayList;
import model.SearchModel;
import model.SubwayModel;
import ws.design.stardelivery.R;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    Context context;
    ArrayList<SearchModel> models;
    Dialog slideDialog;

    String opRoad_txt[] = {"OP ROAD, AKOTA","KARELIBAUGH, VADODARA","AKOTA, VADODARA","VASNA ROAD",
            "BHAILI ROADBHAILI ROAD","MANJALPUR"};

    String rating_txt[] = {"3.2","4.6","4.7","2.3","3.9","4.6"};
    String time_txt[] = {"27 MINS","30 MINS","30 MINS","35 MINS","40 MINS","50 MINS"};

    RecyclerView recyclerView;
    SubwayAdapter subwayAdapter;
    ArrayList<SubwayModel>subwayModels;

    public SearchAdapter(Context context, ArrayList<SearchModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.chinesses_img.setImageResource(models.get(position).getChinesses_img());

        holder.lunchbox_txt.setText(models.get(position).getLunchbox_txt());
        holder.side_txt.setText(models.get(position).getSide_txt());
        holder.area_txt.setText(models.get(position).getAreya_txt());
        holder.discount_txt.setText(models.get(position).getDiscount_txt());
        holder.rating_txt.setText(models.get(position).getRating_txt());
        holder.time_txt.setText(models.get(position).getTime_txt());

        if (position == 1) {
            holder.discount_txt.setVisibility(View.GONE);
        }

        if(position == 0){
            holder.best_Saller.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideDialog = new Dialog(context, R.style.CustomDialogAnimation);
                slideDialog.setContentView(R.layout.activity_multiple_outlets);

                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Window window = slideDialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());

                int width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.60);
                int height = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.65);

                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                layoutParams.gravity = Gravity.BOTTOM;

                recyclerView = slideDialog.findViewById(R.id.subway_recycler);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                subwayModels = new ArrayList<>();

                for (int i = 0; i < opRoad_txt.length; i++) {
                    SubwayModel ab = new SubwayModel(opRoad_txt[i], rating_txt[i], time_txt[i]);
                    subwayModels.add(ab);
                }
                subwayAdapter = new SubwayAdapter(context, subwayModels);
                recyclerView.setAdapter(subwayAdapter);
                slideDialog.getWindow().setAttributes(layoutParams);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView chinesses_img;
        TextView lunchbox_txt, side_txt, area_txt, discount_txt, rating_txt, time_txt;
        FrameLayout best_Saller;

        public ViewHolder(View itemView) {
            super(itemView);
            chinesses_img = itemView.findViewById(R.id.chinesses_img);
            lunchbox_txt = itemView.findViewById(R.id.lunchbox_txt);
            side_txt = itemView.findViewById(R.id.side_txt);
            area_txt = itemView.findViewById(R.id.area_txt);
            discount_txt = itemView.findViewById(R.id.discount_txt);
            rating_txt = itemView.findViewById(R.id.rating_txt);
            time_txt = itemView.findViewById(R.id.time_txt);
            best_Saller = itemView.findViewById(R.id.best_Saller);
        }
    }
}