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

import sfk.project.com.scheduleforkids.adapter.RewardChildHistoryAdapter;
import sfk.project.com.scheduleforkids.adapter.RewardChildNotificationAdapter;
import sfk.project.com.scheduleforkids.model.Notification;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationRewardChildFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RewardChildNotificationAdapter rewardChildNotificationAdapter;
    private List<Notification> notificationList = new ArrayList<>();
    private TextView textViewHapus;

    public NotificationRewardChildFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history_reward_child, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        textViewHapus = (TextView) view.findViewById(R.id.textDelete);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        rewardChildNotificationAdapter = new RewardChildNotificationAdapter(notificationList,getActivity());
        recyclerView.setAdapter(rewardChildNotificationAdapter);

        textViewHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getActivity());
                alertDialogBuilder
                        .setMessage("Apakah anda yakin akan menghapus semua pemberitahuan?")
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
        notificationList.add(new Notification("Liburan","750 Poin",R.drawable.liburan));
        notificationList.add(new Notification("Es Krim", "50 Poin",R.drawable.es_krim));
        notificationList.add(new Notification("Mobil-mobilan", "50 Poin",R.drawable.car));
    }

}
