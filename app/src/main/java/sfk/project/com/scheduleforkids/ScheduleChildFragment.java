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

import sfk.project.com.scheduleforkids.adapter.ScheduleChildAdapter;
import sfk.project.com.scheduleforkids.model.Notification;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleChildFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ScheduleChildAdapter notificationAdapter;
    private List<Notification> notificationList = new ArrayList<>();
    private FloatingActionButton floatingActionButton, floatingActionButtonEdit;

    public ScheduleChildFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);

        initializeData();

        notificationAdapter = new ScheduleChildAdapter(notificationList,getActivity());
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
        notificationList.add(new Notification("Sekolah","24 Poin",R.drawable.school));
        notificationList.add(new Notification("Mengerjakan PR", "30 Poin",R.drawable.pr));
        notificationList.add(new Notification("Cuci Piring", "50 Poin",R.drawable.cuci_piring));
        notificationList.add(new Notification("Tidur", "50 Poin",R.drawable.tidur));
    }

}
