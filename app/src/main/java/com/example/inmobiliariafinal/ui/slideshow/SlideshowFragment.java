package com.example.inmobiliariafinal.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliariafinal.MainActivity;
import com.example.inmobiliariafinal.R;
import com.example.inmobiliariafinal.ui.ListAdapter;

import java.util.ArrayList;

import Model.Inquilino;

public class SlideshowFragment extends Fragment {
    private ArrayList<Inquilino> lista= new ArrayList<>();

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        lista=MainActivity.inquilinos;
        ArrayAdapter<Inquilino> adapter= new ListAdapter(getActivity(), R.layout.item_inquilino, lista, inflater);
        ListView lv= root.findViewById(R.id.ListInquilinos);
        lv.setAdapter(adapter);
        return root;
    }
}