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

import sfk.project.com.scheduleforkids.AddChildActivity;
import sfk.project.com.scheduleforkids.R;
import sfk.project.com.scheduleforkids.adapter.MenuChildOrtuAdapter;
import sfk.project.com.scheduleforkids.model.Child;

/**
 * Created by Toshiba-PC on 8/20/2017.
 */

public class ChildDataParentFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MenuChildOrtuAdapter notificationAdapter;
    private List<Child> notificationList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    public ChildDataParentFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_menu_ortu, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        initializeData();

        notificationAdapter = new MenuChildOrtuAdapter(notificationList, getActivity());
        recyclerView.setAdapter(notificationAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AddChildActivity.class));
            }
        });

        return view;
    }

    private void initializeData(){
        notificationList.clear();
        notificationList.add(new Child("Pevita","Bandung, 25 Oktober 2007", "pevita25", "","1050 poin",R.drawable.girl));
        notificationList.add(new Child("Keenan","Bandung, 24 Oktober 2009", "keenan24", "","1000 poin",R.drawable.boy));
    }

}