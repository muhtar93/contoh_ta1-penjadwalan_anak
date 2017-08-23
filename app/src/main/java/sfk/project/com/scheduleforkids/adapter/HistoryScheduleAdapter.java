package sfk.project.com.scheduleforkids.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sfk.project.com.scheduleforkids.R;
import sfk.project.com.scheduleforkids.listener.ItemClickListener;
import sfk.project.com.scheduleforkids.model.Notification;

/**
 * Created by muhtar on 8/16/17.
 */

public class HistoryScheduleAdapter extends RecyclerView.Adapter<HistoryScheduleAdapter.MyViewHolder> {
    private List<Notification> notificationList;
    private Context context;

    public HistoryScheduleAdapter(List<Notification> notificationList, Context context) {
        this.notificationList = notificationList;
        this.context = context;
    }

    public HistoryScheduleAdapter(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_history_schedule, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public TextView point;
        public ImageView img;

        private ItemClickListener clickListener;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.notification);
            point = (TextView) view.findViewById(R.id.point);
            img = (ImageView) view.findViewById(R.id.image);
            view.setOnClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
//            clickListener.onClick(view);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Notification notification = notificationList.get(position);
        holder.title.setText(notification.getTitle());
        holder.point.setText(notification.getPoint());
        holder.img.setImageResource(notification.getImg());
        /*holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailCatalog = new Intent(context, EditRewardParentActivity.class);
                context.startActivity(detailCatalog);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }
}
