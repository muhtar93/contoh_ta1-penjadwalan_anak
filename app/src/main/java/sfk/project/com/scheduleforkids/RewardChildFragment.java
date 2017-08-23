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

import sfk.project.com.scheduleforkids.adapter.RewardChildAdapter;
import sfk.project.com.scheduleforkids.model.Notification;


/**
 * A simple {@link Fragment} subclass.
 */
public class RewardChildFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RewardChildAdapter notificationAdapter;
    private List<Notification> notificationList = new ArrayList<>();

    public RewardChildFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reward, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new RewardChildAdapter(notificationList, getActivity());
        recyclerView.setAdapter(notificationAdapter);

        return view;
    }

    private void initializeData(){
        notificationList.clear();
        notificationList.add(new Notification("Liburan","750 Poin",R.drawable.liburan));
        notificationList.add(new Notification("Es Krim", "50 Poin",R.drawable.es_krim));
        notificationList.add(new Notification("Mobil-mobilan", "50 Poin",R.drawable.car));
    }

}
