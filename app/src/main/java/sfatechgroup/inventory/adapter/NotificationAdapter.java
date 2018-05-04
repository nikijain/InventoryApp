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

public class NotificationAdapter  extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<DetailsModel> detailsModels;
    private Context context;

    public NotificationAdapter(List<DetailsModel> detailsModels, Context context) {
        this.detailsModels = detailsModels;
        this.context = context;
    }

    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_adapter, parent, false);
        return new NotificationAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final NotificationAdapter.ViewHolder holder, final int position) {
        holder.txtNotificationText.setText(detailsModels.get(position).getDrugFullName());

    }

    @Override
    public int getItemCount() {
        return detailsModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNotificationText;

        ViewHolder(View itemView) {
            super(itemView);

            txtNotificationText = (TextView) itemView.findViewById(R.id.txtNotificationText);


        }
    }
}