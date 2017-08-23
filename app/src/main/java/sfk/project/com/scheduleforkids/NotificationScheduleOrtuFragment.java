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
import sfk.project.com.scheduleforkids.adapter.MenuNotificationScheduleAdapter;
import sfk.project.com.scheduleforkids.model.Schedule;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class NotificationScheduleOrtuFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MenuNotificationScheduleAdapter notificationAdapter;
    private List<Schedule> notificationList = new ArrayList<>();

    public NotificationScheduleOrtuFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_schedule_menu_ortu, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new MenuNotificationScheduleAdapter(notificationList,getActivity());
        recyclerView.setAdapter(notificationAdapter);

        return view;
    }

    private void initializeData(){
        notificationList.add(new Schedule("Pevita","Cuci Piring", "Sat, August, 12th 2017", "12.00 pm","15 Point",R.drawable.cuci_piring));
        notificationList.add(new Schedule("Keenan","Pel Lantai", "Sat, August, 12th 2017", "08.00 am","15 Point",R.drawable.cuci_piring));
    }

}