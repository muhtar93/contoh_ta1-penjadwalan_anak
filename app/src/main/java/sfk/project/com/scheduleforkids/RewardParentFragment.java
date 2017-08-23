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

import sfk.project.com.scheduleforkids.adapter.MenuRewardOrtuAdapter;
import sfk.project.com.scheduleforkids.model.Reward;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class RewardParentFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MenuRewardOrtuAdapter notificationAdapter;
    private List<Reward> notificationList = new ArrayList<>();

    private FloatingActionButton fabAdd;

    public RewardParentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reward_menu_ortu, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        fabAdd = (FloatingActionButton) view.findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRewardParentActivity.class);
                startActivity(intent);
            }
        });

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new MenuRewardOrtuAdapter(notificationList, getActivity());
        recyclerView.setAdapter(notificationAdapter);

        return view;
    }

    private void initializeData() {
        notificationList.clear();
        notificationList.add(new Reward("Pevita", "Liburan", "750 Poin", R.drawable.liburan));
        notificationList.add(new Reward("Keenan", "Es Krim", "50 Poin", R.drawable.es_krim));
        notificationList.add(new Reward("Keenan", "Mobil-mobilan", "300 Poin", R.drawable.car));
    }
}

