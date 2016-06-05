package com.example.runapp.runapp;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentopies extends Fragment {

    private VideoView videoView;

    private int position = 0;


    public Fragmentopies() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmentopies, container, false);

        videoView = (VideoView) v.findViewById(R.id.videoView);
        Button b = (Button) v.findViewById(R.id.pronador);



        Button MiBoton = (Button) v.findViewById(R.id.pronador);
        Button MiBoton2 = (Button) v.findViewById(R.id.tiiposPP);

        MiBoton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View arg0) {


                Intent intento = new Intent(getActivity(), VideoActivity.class);
                startActivity(intento);

            }

        });

        MiBoton2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View arg0) {
                Intent intento = new Intent(getActivity(), tiposdetennis.class);
                startActivity(intento);
                getActivity().finish();
            }

        });


        return v;





    }


    public void ReproducirVideoEnraw( ) {
    //videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" +
      //          R.raw.asas));
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(position);

                if (position == 0) {

                    videoView.start();

                } else {
                    videoView.pause();

                }

            }

        });

    }

}
