package sfk.project.com.scheduleforkids.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sfk.project.com.scheduleforkids.DetailRewardParentActivity;
import sfk.project.com.scheduleforkids.R;
import sfk.project.com.scheduleforkids.listener.ItemClickListener;
import sfk.project.com.scheduleforkids.model.Reward;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class MenuNotificationRewardAdapter extends RecyclerView.Adapter<MenuNotificationRewardAdapter.MyViewHolder>{

    private List<Reward> notificationList;
    private Context context;

    public MenuNotificationRewardAdapter(List<Reward> notificationList) {
        this.notificationList = notificationList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_history_reward_ortu, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public TextView reward;
        public TextView point;
        public ImageView photo;
        private ItemClickListener clickListener;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.notification);
            reward = (TextView) view.findViewById(R.id.reward);
            point = (TextView) view.findViewById(R.id.point);
            photo = (ImageView) view.findViewById(R.id.photo);
            view.setOnClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            //clickListener.onClick(view);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Reward notification = notificationList.get(position);
        holder.title.setText(notification.getTitle());
        holder.reward.setText(notification.getReward());
        holder.point.setText(notification.getPoint());
        holder.photo.setImageResource(notification.getPhoto());
        /*holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailCatalog = new Intent(context, DetailRewardParentActivity.class);
                context.startActivity(detailCatalog);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }
}