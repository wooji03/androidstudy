    package com.example.b.a19_fragment2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_blank, container, false);
        final TextView textView = (TextView) v.findViewById(R.id.textViewCount);
        Button btnIcrease = (Button) v.findViewById(R.id.btnIcrease);
        btnIcrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int val = Integer.parseInt(textView.getText().toString());
                val++;
                textView.setText(""+val);
            }
        });
        return v;

    }

}
