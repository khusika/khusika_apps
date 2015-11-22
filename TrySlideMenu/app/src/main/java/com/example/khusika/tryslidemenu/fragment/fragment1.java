package com.example.khusika.tryslidemenu.fragment;

/**
 * Created by khusika on 22/11/15.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khusika.tryslidemenu.R;

public class fragment1 extends Fragment {
    public fragment1() {
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment1, container, false);
            return rootView;
        }
}
