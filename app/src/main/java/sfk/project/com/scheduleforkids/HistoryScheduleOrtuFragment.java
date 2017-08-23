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

import sfk.project.com.scheduleforkids.R;
import sfk.project.com.scheduleforkids.adapter.MenuHistoryScheduleAdapter;
import sfk.project.com.scheduleforkids.model.Schedule;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class HistoryScheduleOrtuFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MenuHistoryScheduleAdapter notificationAdapter;
    private List<Schedule> notificationList = new ArrayList<>();
    private TextView textViewHapus;

    public HistoryScheduleOrtuFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history_schedule_menu_ortu, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        textViewHapus = (TextView) view.findViewById(R.id.textDelete);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new MenuHistoryScheduleAdapter(notificationList);
        recyclerView.setAdapter(notificationAdapter);

        textViewHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getActivity());
                alertDialogBuilder
                        .setMessage("Apakah anda yakin akan menghapus semua histori?")
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
        notificationList.add(new Schedule("Pevita","Cuci Piring", "Sat, August, 12th 2017", "12.00 pm","15 Point",R.drawable.cuci_piring));
        notificationList.add(new Schedule("Keenan","Pel Lantai", "Sat, August, 12th 2017", "08.00 am","15 Point",R.drawable.tidur));
    }

}