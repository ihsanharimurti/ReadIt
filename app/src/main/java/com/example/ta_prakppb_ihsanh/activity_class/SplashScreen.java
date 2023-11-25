package com.example.ta_prakppb_ihsanh.activity_class;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ta_prakppb_ihsanh.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Buat objek Handler untuk menunda perpindahan aktivitas
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent ke LoginActivity setelah 2 detik
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Tutup SplashScreen agar tidak bisa kembali ke sana
            }
        }, 2000); // Menunda selama 2000 milidetik (2 detik)
    }
}
