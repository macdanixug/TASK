package com.example.yourtask;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewTasksFragment extends Fragment {

    private MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;
    private boolean isPlaying1, isPlaying2, isPlaying3;

    public ViewTasksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_tasks, container, false);

        // Set the current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = dateFormat.format(new Date());
        TextView dateTextView = view.findViewById(R.id.dateTextView);
        dateTextView.setText(currentDate);

        // Initialize MediaPlayer objects
        mediaPlayer1 = MediaPlayer.create(requireContext(), R.raw.aud1);
        mediaPlayer2 = MediaPlayer.create(requireContext(), R.raw.aud2);
        mediaPlayer3 = MediaPlayer.create(requireContext(), R.raw.aud3);

        // Set completion listener for each audio file
        mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                isPlaying1 = false;
            }
        });

        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                isPlaying2 = false;
            }
        });

        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                isPlaying3 = false;
            }
        });

        // Set click listeners for play and pause icons
        ImageView play1 = view.findViewById(R.id.play);
        ImageView pause1 = view.findViewById(R.id.pause);
        ImageView play2 = view.findViewById(R.id.play2);
        ImageView pause2 = view.findViewById(R.id.pause2);
        ImageView play3 = view.findViewById(R.id.play3);
        ImageView pause3 = view.findViewById(R.id.pause3);

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying1) {
                    mediaPlayer1.pause();
                    isPlaying1 = false;
                } else {
                    if (isPlaying2) {
                        mediaPlayer2.pause();
                        isPlaying2 = false;
                    }
                    if (isPlaying3) {
                        mediaPlayer3.pause();
                        isPlaying3 = false;
                    }
                    mediaPlayer1.start();
                    isPlaying1 = true;
                }
            }
        });

        pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying1) {
                    mediaPlayer1.pause();
                    isPlaying1 = false;
                }
            }
        });


        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying2) {
                    mediaPlayer2.pause();
                    isPlaying2 = false;
                } else {
                    if (isPlaying1) {
                        mediaPlayer1.pause();
                        isPlaying1 = false;
                    }
                    if (isPlaying3) {
                        mediaPlayer3.pause();
                        isPlaying3 = false;
                    }
                    mediaPlayer2.start();
                    isPlaying2 = true;
                 }
            }
        });
        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying2) {
                    mediaPlayer2.pause();
                    isPlaying2 = false;
                }
            }
        });

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying3) {
                    mediaPlayer3.pause();
                    isPlaying3 = false;
                } else {
                    if (isPlaying1) {
                        mediaPlayer1.pause();
                        isPlaying1 = false;
                    }
                    if (isPlaying2) {
                        mediaPlayer2.pause();
                        isPlaying2 = false;
                    }
                    mediaPlayer3.start();
                    isPlaying3 = true;
                }
            }
        });
        pause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying3) {
                    mediaPlayer3.pause();
                    isPlaying3 = false;
                }
            }
        });

        return view;
    }
}
