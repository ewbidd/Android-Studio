package com.tugas.platform.modullima;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment3, container, false);

        Button btnToFragment1 = view.findViewById(R.id.btnToFragment1Fragment3);
        Button btnToFragment2 = view.findViewById(R.id.btnToFragment2Fragment3);
        Button btnToTabLayout = view.findViewById(R.id.btnToTabLayoutFragment3);

        btnToFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pindah ke fragment 1", Toast.LENGTH_SHORT).show();
                ((FragmentActivity)getActivity()).setViewPager(0);
            }
        });

        btnToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pindah ke fragment 2", Toast.LENGTH_SHORT).show();
                ((FragmentActivity)getActivity()).setViewPager(1);
            }
        });

        btnToTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pindah ke tab layout", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), TabLayoutActivity.class);
                startActivity(i);
            }
        });

        return view;
    }
}

