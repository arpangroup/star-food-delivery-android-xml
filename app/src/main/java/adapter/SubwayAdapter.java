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
import model.SubwayModel;
import ws.design.stardelivery.R;

public class SubwayAdapter extends RecyclerView.Adapter<SubwayAdapter.ViewHolder> {

    Context context;
    ArrayList<SubwayModel> models;

    public SubwayAdapter(Context context, ArrayList<SubwayModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public SubwayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subway, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SubwayAdapter.ViewHolder holder, final int position) {

        holder.opRoad_txt.setText(models.get(position).getOpRoad_txt());
        holder.rating_txt.setText(models.get(position).getRating_txt());
        holder.time_txt.setText(models.get(position).getTime_txt());

        if(position == 5){
            holder.view.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView  opRoad_txt,rating_txt,time_txt;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            opRoad_txt = itemView.findViewById(R.id.opRoad_txt);
            rating_txt = itemView.findViewById(R.id.rating_txt);
            time_txt = itemView.findViewById(R.id.time_txt);

            view = itemView.findViewById(R.id.view);
        }
    }
}
