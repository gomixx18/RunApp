package com.example.runapp.runapp;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmentopies extends Fragment implements View.OnClickListener {

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
        Button b = (Button) v.findViewById(R.id.btnpisada);
        b.setOnClickListener(this);
        return v;





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnpisada: ReproducirVideoEnraw( v );

        }
    }

    public void ReproducirVideoEnraw(View v ) {



        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" +
                R.raw.asas));


        videoView.setMediaController(new MediaController(getActivity()));
        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            // create a progress bar while the video file is loading



            public void onPrepared(MediaPlayer mediaPlayer) {



                //if we have a position on savedInstanceState, the video playback should start from here

                videoView.seekTo(position);

                if (position == 0) {

                    videoView.start();

                } else {

                    //if we come from a resumed activity, video playback will be paused

                    videoView.pause();

                }

            }

        });

    }

    private void createNote() {
        getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
