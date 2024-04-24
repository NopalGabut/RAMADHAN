package com.example.ramadhan;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class HomeActivity extends Activity {
    Button roundedButton;
    Button roundButtonRestart;
    TextView textView; // text view angka

    TextView textHome;
    int restart;

    int restartbutton = 0;

    int restart1 = restartbutton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        roundedButton = findViewById(R.id.roundedButton);
        roundButtonRestart = findViewById(R.id.roundedButton1);
        textView = findViewById(R.id.Toast);
        textHome = findViewById(R.id.textHome);
    }

    public void button(View view) {
        // Menambahkan 1 ke nilai saat ini
        restart++;
        // Mengatur teks TextView dengan nilai yang baru
        textView.setText(String.valueOf(restart));
    }

    public void Button_Restart(View view) {
        restart1 = 0; // Set nilai restart1 kembali ke 0
        restart = 0; // Reset nilai restart
        textView.setText(String.valueOf(restart1));
        textHome.setText("Pilih terlebih dahulu");
    }

    public void Alhamdulilah(View view) {
        textView.setText(String.valueOf(restart1));
        textHome.setText("الحمد لله");
    }


    public void subnAllah(View view) {
        textView.setText(String.valueOf(restart1));
        textHome.setText("سُبْحَانَ ٱللَّٰهِ ");
    }


    public void astaga(View view) {
        textView.setText(String.valueOf(restart1));
        textHome.setText("اَسْتَغْفِرُ اللهَ الْعَظِيْمَ");
    }

    public void takbir(View view) {
        textView.setText(String.valueOf(restart1));
        textHome.setText("ٱللَّٰهُ أَكْبَرُ");
    }


    public void lailah(View view) {
        textView.setText(String.valueOf(restart1));
        textHome.setText(" لَا إِلَهَ إِلاَّ الله");

    }
}
