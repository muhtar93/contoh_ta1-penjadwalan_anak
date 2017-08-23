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

import sfk.project.com.scheduleforkids.adapter.HistoryScheduleAdapter;
import sfk.project.com.scheduleforkids.adapter.NotificationScheduleChildAdapter;
import sfk.project.com.scheduleforkids.model.Notification;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationScheduleChildFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private NotificationScheduleChildAdapter notificationScheduleChildAdapter;
    private List<Notification> notificationList = new ArrayList<>();
    private TextView textViewHapus;
    private Notification notification;

    public NotificationScheduleChildFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history_schedule, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        textViewHapus = (TextView) view.findViewById(R.id.textDelete);
        //recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(true);

        initializeData();

        notificationScheduleChildAdapter = new NotificationScheduleChildAdapter(notificationList);
        recyclerView.setAdapter(notificationScheduleChildAdapter);

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

        //notificationList.add(0, notification);
        notificationScheduleChildAdapter.notifyItemInserted(0);
        recyclerView.scrollToPosition(0);

        return view;
    }

    private void initializeData(){
        notificationList.add(new Notification("Sekolah","24 Poin",R.drawable.school, "07:00"));
        notificationList.add(new Notification("Mengerjakan PR", "30 Poin",R.drawable.pr,"13:00"));
        notificationList.add(new Notification("Cuci Piring", "50 Poin",R.drawable.cuci_piring, "14:00"));
        notificationList.add(new Notification("Tidur", "50 Poin",R.drawable.tidur,"20:00"));
    }

}
