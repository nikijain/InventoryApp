package sfatechgroup.inventory.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import sfatechgroup.inventory.R;
import sfatechgroup.inventory.model.DetailsModel;

public class LunPurchaseDetailAdapter extends RecyclerView.Adapter<LunPurchaseDetailAdapter.ViewHolder> {

    private List<DetailsModel> detailsModels;
    private Context context;
    int currentPosition = -1;

    public LunPurchaseDetailAdapter(List<DetailsModel> detailsModels, Context context) {
        this.detailsModels = detailsModels;
        this.context = context;
    }

    @Override
    public LunPurchaseDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.purchase_detail_adapter, parent, false);
        return new LunPurchaseDetailAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final LunPurchaseDetailAdapter.ViewHolder holder, final int position) {

        holder.txtDrugName.setText(detailsModels.get(position).getDrugName());
        holder.txtDrugType.setText(detailsModels.get(position).getDrugType());
        holder.txtPackingSize.setText(detailsModels.get(position).getPackingSize());
        holder.txtTotalQuantity.setText("");
        holder.txtBatchNo.setText("");
        holder.txtLicenseNumber.setText("");
        holder.txtExpiryDate.setText("");
        holder.txtSupplier.setText("");
        holder.txtCategory.setText("");

        holder.linearLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //creating an animation
            holder.layoutMain.setBackgroundColor(ContextCompat.getColor(context, R.color.transGrey));
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);

        }
        else {
            holder.layoutMain.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));
            holder.linearLayout.setVisibility(View.GONE);
        }
        holder.layoutMain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //getting the position of the item to expand it
                        currentPosition = position;

                        //reloding the list
                        notifyDataSetChanged();
                    }
                });


    }

    @Override
    public int getItemCount() {
        return detailsModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout, layoutMain;
        TextView txtDrugName, txtDrugType, txtPackingSize, txtTotalQuantity, txtBatchNo, txtLicenseNumber, txtExpiryDate, txtSupplier, txtCategory;

        ViewHolder(View itemView) {
            super(itemView);
            layoutMain = (LinearLayout) itemView.findViewById(R.id.layoutMain);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            txtDrugName = (TextView) itemView.findViewById(R.id.txtDrugName);
            txtDrugType = (TextView) itemView.findViewById(R.id.txtDrugType);
            txtPackingSize = (TextView) itemView.findViewById(R.id.txtPackingSize);
            txtTotalQuantity = (TextView) itemView.findViewById(R.id.txtTotalQuantity);
            txtBatchNo = (TextView) itemView.findViewById(R.id.txtBatchNo);
            txtLicenseNumber = (TextView) itemView.findViewById(R.id.txtLicenseNumber);
            txtExpiryDate = (TextView) itemView.findViewById(R.id.txtExpiryDate);
            txtSupplier = (TextView) itemView.findViewById(R.id.txtSupplier);
            txtCategory = (TextView) itemView.findViewById(R.id.txtCategory);
        }
    }
}
