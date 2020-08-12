package com.example.androidcharacter.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.androidcharacter.R;
import com.example.androidcharacter.data.AndroidImageAssets;

/**
 * Created Master List Fragment
 */
public class MasterListFragment extends Fragment {
    // triggers a call back to the main activity
    OnImageClickListner onImageClickListner;

    // interface for image selected
    public interface OnImageClickListner{
        void onImageSelected(int position);
    }

    /**
     * The Lifecycle Where activity and fragment connects
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // check if attach
        try {
            onImageClickListner = (OnImageClickListner) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"is not implemented");
        }
    }
    // necessary empty constructor
    public MasterListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = rootView.findViewById(R.id.imaged_grid_view);
        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(masterListAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get the position
                onImageClickListner.onImageSelected(position);
            }
        });
        return rootView;
    }
}