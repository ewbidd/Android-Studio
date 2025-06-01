package com.example.fragmentandtablayout;

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

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment2, container, false);

        Button btnToFragment1 = view.findViewById(R.id.btnToFragment1Fragment2);
        Button btnToFragment3 = view.findViewById(R.id.btnToFragment3Fragment2);
        Button btnToTabLayout = view.findViewById(R.id.btnToTabLayoutFragment2);

        btnToFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pindah ke fragment 1", Toast.LENGTH_SHORT).show();
                ((FragmentActivity)getActivity()).setViewPager(0);
            }
        });

        btnToFragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pindah ke fragment 3", Toast.LENGTH_SHORT).show();
                ((FragmentActivity)getActivity()).setViewPager(2);
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
