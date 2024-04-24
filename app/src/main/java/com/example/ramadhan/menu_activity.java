package com.example.ramadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramadhan.api.ApiService;
import com.example.ramadhan.api.ApiUrl;
import com.example.ramadhan.model.ModelJadwal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class menu_activity extends AppCompatActivity {
    private TextView textClock, textDate;
    private long lastClickTime = 0;
    private TextView text1,text2,text3,text4,text5;
    private FloatingActionButton refresh;
    private ProgressDialog progressDialog;

    private ImageButton button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        textClock = findViewById(R.id.clock);
        textDate = findViewById(R.id.date);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        refresh = findViewById(R.id.refresh);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_activity.this, DoanActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_activity.this, kiblatActivity.class);
                startActivity(intent);
            }
        });

        getJadwal();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJadwal();
            }
        });


        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                Date date = new Date();


                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat clockFormat = new SimpleDateFormat("HH:mm:ss a");
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");

                String currentTime = clockFormat.format(date);
                String currentDate = dateFormat.format(date);


                textClock.setText(currentTime);
                textDate.setText(currentDate);


                handler.postDelayed(this, 1000);
            }
        });
    }


    @Override
    public void onBackPressed() {
        long now = System.currentTimeMillis();
        if (now - lastClickTime < 1500) {
            super.onBackPressed();
        } else {
            showToast("Ketuk sekali lagi untuk keluar");
        }
        lastClickTime = now;
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void getJadwal(){

        progressDialog = new ProgressDialog(menu_activity.this);
        progressDialog.setMessage("Silahkan Tunggu...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_ROOT_HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ModelJadwal> call = apiService.getJadwal();

        call.enqueue(new Callback<ModelJadwal>() {
            @Override
            public void onResponse(Call<ModelJadwal> call, Response<ModelJadwal> response) {

                progressDialog.dismiss();

            if(response.isSuccessful()){
                text1.setText(response.body().getItems().get(0).getFajr());
                text2.setText(response.body().getItems().get(0).getDhuhr());
                text3.setText(response.body().getItems().get(0).getAsr());
                text4.setText(response.body().getItems().get(0).getMaghrib());
                text5.setText(response.body().getItems().get(0).getIsha());
            }else {

            }
            }

            @Override
            public void onFailure(Call<ModelJadwal> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(menu_activity.this, "Sorry, Please try Again",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
