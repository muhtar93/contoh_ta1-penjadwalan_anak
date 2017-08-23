package sfk.project.com.scheduleforkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sfk.project.com.scheduleforkids.EditProfileParentActivity;
import sfk.project.com.scheduleforkids.R;

public class ProfileParentFragment extends Fragment {
    private FloatingActionButton floatingActionButton;

    public ProfileParentFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_setting_menu_ortu, container, false);
        floatingActionButton = (FloatingActionButton)itemView.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EditProfileParentActivity.class));
            }
        });
        return itemView;
    }

}