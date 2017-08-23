package sfk.project.com.scheduleforkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sfk.project.com.scheduleforkids.AddScheduleActivity;
import sfk.project.com.scheduleforkids.R;
import sfk.project.com.scheduleforkids.adapter.MenuScheduleOrtuAdapter;
import sfk.project.com.scheduleforkids.model.Schedule;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class ScheduleParentFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MenuScheduleOrtuAdapter notificationAdapter;
    private List<Schedule> notificationList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    public ScheduleParentFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule_menu_ortu, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new MenuScheduleOrtuAdapter(notificationList,getActivity());
        recyclerView.setAdapter(notificationAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddScheduleActivity.class));
            }
        });

        return view;
    }

    private void initializeData(){
        notificationList.clear();
        notificationList.add(new Schedule("Pevita","Sekolah", "Sabtu, 12 Agustus 2017", "07:00","15 Poin", R.drawable.school));
        notificationList.add(new Schedule("Keenan","Mengerjakan PR", "Sabtu, 12 Agustus 2017", "12:00","15 Poin", R.drawable.pr));
        notificationList.add(new Schedule("Keenan","Cuci Piring", "Sabtu, 12 Agustus 2017", "13:00","15 Poin", R.drawable.cuci_piring));
        notificationList.add(new Schedule("Keenan","Tidur", "Sabtu, 12 Agustus 2017", "21:00","15 Poin", R.drawable.tidur));
    }

}