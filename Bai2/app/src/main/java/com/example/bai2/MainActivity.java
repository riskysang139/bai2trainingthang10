package com.example.bai2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView timerTextView;
    private long startTime = 0;
    private Button btnAction;

    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnAction.getText().equals("stop")) {
                    timerHandler.removeCallbacks(timerRunnable);
                    btnAction.setText("start");
                } else {
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    btnAction.setText("stop");
                    btnAction.setText("stop");
                    btnAction.setText("stop");
                    btnAction.setText("stop2");
                    btnAction.setText("stop3");
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        timerHandler.removeCallbacks(timerRunnable);
        btnAction.setText("start");
        btnAction.setText("1");
        btnAction.setText("2");
    }

    private void initView() {
        btnAction = findViewById(R.id.button);
        timerTextView = (TextView) findViewById(R.id.text);
    }
}
