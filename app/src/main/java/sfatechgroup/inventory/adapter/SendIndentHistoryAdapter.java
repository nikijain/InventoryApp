package sfatechgroup.inventory.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import sfatechgroup.inventory.IndentDetailActivity;
import sfatechgroup.inventory.R;
import sfatechgroup.inventory.model.DetailsModel;

public class SendIndentHistoryAdapter extends RecyclerView.Adapter<SendIndentHistoryAdapter.ViewHolder> {

    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout viewColor, layout;
        TextView txtInfection;
        RelativeLayout relLayout;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            viewColor = (LinearLayout) itemView.findViewById(R.id.viewColor);
            txtInfection = (TextView) itemView.findViewById(R.id.txtInfection);
            relLayout = (RelativeLayout) itemView.findViewById(R.id.relLayout);
            layout = (LinearLayout) itemView.findViewById(R.id.layout);
            //image  = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    List<DetailsModel> detailsModels;

    public SendIndentHistoryAdapter(Context context, List<DetailsModel> detailsModels) {
        this.context = context;
        this.detailsModels = detailsModels;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public SendIndentHistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.indenthistory_adapter_layout, viewGroup, false);
        SendIndentHistoryAdapter.ViewHolder pvh = new SendIndentHistoryAdapter.ViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(SendIndentHistoryAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.txtInfection.setText(detailsModels.get(i).getDrugName());
        viewHolder.relLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, IndentDetailActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return detailsModels.size();
    }
}