package sfk.project.com.scheduleforkids;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sfk.project.com.scheduleforkids.R;
import sfk.project.com.scheduleforkids.adapter.MenuNotificationRewardAdapter;
import sfk.project.com.scheduleforkids.model.Reward;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class NotificationRewardOrtuFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MenuNotificationRewardAdapter notificationAdapter;
    private List<Reward> notificationList = new ArrayList<>();

    public NotificationRewardOrtuFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_reward_menu_ortu, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new MenuNotificationRewardAdapter(notificationList);
        recyclerView.setAdapter(notificationAdapter);

        return view;
    }

    private void initializeData(){
        notificationList.add(new Reward("Pevita","Liburan","750 Poin",R.drawable.girl));
        notificationList.add(new Reward("Keenan","PS 3","750 Poin",R.drawable.boy));
    }

}