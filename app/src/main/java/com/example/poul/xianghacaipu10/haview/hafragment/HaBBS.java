package com.example.poul.xianghacaipu10.haview.hafragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poul.xianghacaipu10.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HaBBS extends Fragment {


    public HaBBS() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bbs, container, false);
    }

}
