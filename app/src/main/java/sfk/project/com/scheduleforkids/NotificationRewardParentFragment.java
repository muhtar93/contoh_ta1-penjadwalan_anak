package sfk.project.com.scheduleforkids;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sfk.project.com.scheduleforkids.adapter.MenuHistoryRewardAdapter;
import sfk.project.com.scheduleforkids.model.Reward;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class NotificationRewardParentFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MenuHistoryRewardAdapter notificationAdapter;
    private List<Reward> notificationList = new ArrayList<>();
    private TextView textViewOk;

    public NotificationRewardParentFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_reward_parent, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        textViewOk = (TextView) view.findViewById(R.id.textOk);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new MenuHistoryRewardAdapter(notificationList,getActivity());
        recyclerView.setAdapter(notificationAdapter);

        textViewOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getActivity());
                alertDialogBuilder
                        .setMessage("Apakah anda yakin akan menerima semua notifikasi?")
                        .setCancelable(false)
                        .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                getActivity().finish();
                            }
                        })
                        .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();
            }
        });

        return view;
    }

    private void initializeData(){
        notificationList.add(new Reward("Pevita","Liburan","750 Point",R.drawable.girl));
        notificationList.add(new Reward("Keenan","PS 3","750 Point",R.drawable.boy));
    }

}
