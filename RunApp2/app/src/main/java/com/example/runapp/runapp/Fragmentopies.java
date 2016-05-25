package com.example.runapp.runapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentopies extends Fragment implements View.OnClickListener {


    public Fragmentopies() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmentopies, container, false);

        Button b = (Button) v.findViewById(R.id.btnpisada);
        b.setOnClickListener(this);
        return v;





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnpisada:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6Jg_zITS0i4")));
                break;
        }
    }

}
