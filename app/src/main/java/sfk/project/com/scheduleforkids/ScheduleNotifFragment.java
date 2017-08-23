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

import sfk.project.com.scheduleforkids.adapter.NotificationAdapter;
import sfk.project.com.scheduleforkids.model.Notification;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleNotifFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private NotificationAdapter notificationAdapter;
    private List<Notification> notificationList = new ArrayList<>();

    public ScheduleNotifFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule_notif, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(notificationAdapter);

        return view;
    }

    private void initializeData(){
        notificationList.add(new Notification("Cuci piring"));
        notificationList.add(new Notification("Bangun pagi"));
        notificationList.add(new Notification("Membereskan tempat tidur"));
    }

}
