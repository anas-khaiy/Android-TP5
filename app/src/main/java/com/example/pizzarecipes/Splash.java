package com.example.pizzarecipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    private ImageView imageLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        Thread t1=new Thread(){

            @Override
            public void run() {
                try {

                    imageLoading=findViewById(R.id.load);

                    RotateAnimation rotate = new RotateAnimation(
                            0, 360,
                            Animation.RELATIVE_TO_SELF, 0.5f,
                            Animation.RELATIVE_TO_SELF, 0.5f
                    );

                    rotate.setDuration(1000);
                    rotate.setRepeatCount(Animation.INFINITE);
                    rotate.setInterpolator(new android.view.animation.LinearInterpolator());

                    // Start the animation
                    imageLoading.startAnimation(rotate);

                    sleep(5000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    Intent intent = new Intent(Splash.this, list_pizza.class);
                    startActivity(intent);
                }
            }
        };

        t1.start();



    }


    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}