package sfatechgroup.inventory.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import sfatechgroup.inventory.R;
import sfatechgroup.inventory.model.DetailsModel;

public class RateContractAdapter extends RecyclerView.Adapter<RateContractAdapter.ViewHolder> {

    private List<DetailsModel> detailsModels;
    private Context context;
    int currentPosition = -1;

    public RateContractAdapter(List<DetailsModel> detailsModels, Context context) {
        this.detailsModels = detailsModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rate_contract_adapter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.textViewName.setText(detailsModels.get(position).getDrugName());
        holder.txtDrugName.setText(detailsModels.get(position).getDrugFullName());
        holder.txtDrugType.setText(detailsModels.get(position).getDrugType());
        holder.txtCategory.setText(detailsModels.get(position).getCategory());
        holder.txtUnitPrize.setText(detailsModels.get(position).getUnitPrize());
        holder.linearLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);

        }
        holder.textViewName.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the position of the item to expand it
                currentPosition = position;

                //reloding the list
                notifyDataSetChanged();
            }
        });

        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.KITKAT) {
            if (position % 2 == 0) {
                holder.viewColor.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
            } else if (position % 2 == 1) {
                holder.viewColor.setBackgroundColor(ContextCompat.getColor(context, R.color.colorOrange));
            }
        }

    }

    @Override
    public int getItemCount() {
        return detailsModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, txtDrugName, txtDrugType, txtCategory, txtPackingSize, txtUnitPrize;
        LinearLayout linearLayout, viewColor;

        ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            txtDrugName = (TextView) itemView.findViewById(R.id.txtDrugName);
            txtDrugType = (TextView) itemView.findViewById(R.id.txtDrugType);
            txtCategory = (TextView) itemView.findViewById(R.id.txtCategory);
            txtPackingSize = (TextView) itemView.findViewById(R.id.txtPackingSize);
            txtUnitPrize = (TextView) itemView.findViewById(R.id.txtUnitPrize);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            viewColor = (LinearLayout) itemView.findViewById(R.id.viewColor);
        }
    }
}