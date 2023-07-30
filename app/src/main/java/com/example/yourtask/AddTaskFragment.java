package com.example.yourtask;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTaskFragment extends Fragment {
    private Button addTaskButton;

    public AddTaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);

        addTaskButton = view.findViewById(R.id.addTaskButton);
        TextInputLayout task3InputLayout = view.findViewById(R.id.task3InputLayout);
        task3InputLayout.setVisibility(View.GONE);
        Button selectTimeButton = view.findViewById(R.id.selectTime);
        Button selectTimeButton2 = view.findViewById(R.id.selectTime2);
        Button selectTimeButton3 = view.findViewById(R.id.selectTime3);
        selectTimeButton3.setVisibility(View.GONE);

        selectTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(view);
            }
        });
        selectTimeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog2(view);
            }
        });
        selectTimeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog3(view);
            }
        });

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task3InputLayout.setVisibility(View.VISIBLE);
                selectTimeButton3.setVisibility(View.VISIBLE);
                task3InputLayout.setHint("Task 3");
                }

        });

        // Set the current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = dateFormat.format(new Date());
        TextView dateTextView = view.findViewById(R.id.dateTextView);
        dateTextView.setText(currentDate);

        return view;
    }
    private void showTimePickerDialog(View fragmentView) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Format the selected time as per your requirement
                        String formattedTime = formatTime(hourOfDay, minute);

                        // Set the selected time in the TextView
                        Button selectTimeButton = fragmentView.findViewById(R.id.selectTime);
                        selectTimeButton.setText(formattedTime);
                    }
                },
                0, 0, false
        );
        timePickerDialog.show();
    }

    private void showTimePickerDialog2(View fragmentView) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Format the selected time as per your requirement
                        String formattedTime = formatTime(hourOfDay, minute);

                        // Set the selected time in the TextView
                        Button selectTimeButton2 = fragmentView.findViewById(R.id.selectTime2);
                        selectTimeButton2.setText(formattedTime);
                    }
                },
                0, 0, false
        );
        timePickerDialog.show();
    }

    private void showTimePickerDialog3(View fragmentView) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Format the selected time as per your requirement
                        String formattedTime = formatTime(hourOfDay, minute);

                        // Set the selected time in the TextView
                        Button selectTimeButton3 = fragmentView.findViewById(R.id.selectTime3);
                        selectTimeButton3.setText(formattedTime);
                    }
                },
                0, 0, false
        );
        timePickerDialog.show();
    }

    private String formatTime(int hourOfDay, int minute) {
        // Convert 24-hour format to 12-hour format
        String format;
        if (hourOfDay == 0) {
            hourOfDay = 12;
            format = "AM";
        } else if (hourOfDay == 12) {
            format = "PM";
        } else if (hourOfDay > 12) {
            hourOfDay -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        // Format the hour and minute values
        String hourString = String.valueOf(hourOfDay);
        String minuteString = String.valueOf(minute);
        if (hourOfDay < 10) {
            hourString = "0" + hourString;
        }
        if (minute < 10) {
            minuteString = "0" + minuteString;
        }

        // Return the formatted time string
        return hourString + ":" + minuteString + format;
    }



}