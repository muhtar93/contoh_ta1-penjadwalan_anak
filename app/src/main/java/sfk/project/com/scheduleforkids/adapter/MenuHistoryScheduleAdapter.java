package sfk.project.com.scheduleforkids.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sfk.project.com.scheduleforkids.R;
import sfk.project.com.scheduleforkids.listener.ItemClickListener;
import sfk.project.com.scheduleforkids.model.Schedule;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class MenuHistoryScheduleAdapter extends RecyclerView.Adapter<MenuHistoryScheduleAdapter.MyViewHolder>{

    private List<Schedule> notificationList;

    public MenuHistoryScheduleAdapter(List<Schedule> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_history_schedule_ortu, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public TextView schedule;
        public TextView date;
        public TextView times;
        public TextView point;
        public ImageView image;
        private ItemClickListener clickListener;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.notification);
            schedule = (TextView) view.findViewById(R.id.schedule);
            date = (TextView) view.findViewById(R.id.date);
            times = (TextView) view.findViewById(R.id.times);
            point = (TextView) view.findViewById(R.id.point);
            image = (ImageView) view.findViewById(R.id.image);
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
        Schedule notification = notificationList.get(position);
        holder.title.setText(notification.getTitle());
        holder.schedule.setText(notification.getSchedule());
        holder.date.setText(notification.getDate());
        holder.times.setText(notification.getTimes());
        holder.point.setText(notification.getPoint());
        holder.image.setImageResource(notification.getImage());
        /*holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailCatalog = new Intent(context, DetailTaskActivity.class);
                context.startActivity(detailCatalog);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }
}