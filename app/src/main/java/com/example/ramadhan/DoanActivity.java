package com.example.ramadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DoanActivity extends AppCompatActivity {
    TextView detailsText, details2Text, details3Text, details4Text, details5Text, details6Text;
    LinearLayout layout, layout2, layout3, layout4, layout5, layout6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doan);

        detailsText = findViewById(R.id.details);
        details2Text = findViewById(R.id.details2);
        details3Text = findViewById(R.id.details3);
        details4Text = findViewById(R.id.details4);
        details5Text = findViewById(R.id.details5);
        details6Text = findViewById(R.id.details6);

        layout = findViewById(R.id.layout);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        layout6 = findViewById(R.id.layout6);
    }

    public void expand(View view) {
        int v = (detailsText.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailsText.setVisibility(v);
    }

    public void doa2(View view) {
        int v = (details2Text.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
        details2Text.setVisibility(v);
    }

    public void doa3(View view) {
        int v = (details3Text.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout3, new AutoTransition());
        details3Text.setVisibility(v);
    }

    public void doa4(View view) {
        int v = (details4Text.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout4, new AutoTransition());
        details4Text.setVisibility(v);
    }

    public void doa5(View view) {
        int v = (details5Text.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout5, new AutoTransition());
        details5Text.setVisibility(v);
    }

    public void doa6(View view) {
        int v = (details6Text.getVisibility() == View.GONE)? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout6, new AutoTransition());
        details6Text.setVisibility(v);
    }
}