package com.example.qhs.wallpapershopping;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static android.support.test.InstrumentationRegistry.getContext;


public class Splashscreen extends Activity {

    public ImageView bgApp, clover;
    public Animation bgAnim, cloverAnim;
    public LinearLayout textSplash, textHome;
    public Animation frombottom;

    public static int Splash = 0;

    public void onAttachedToWindow() {

        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        StartAnimations();
//        frombottom = AnimationUtils.loadAnimation(getContext(), R.anim.frombottom);
//
//        textSplash = findViewById(R.id.textsplash);
//        textHome = findViewById(R.id.texthome);
//
//        bgApp = findViewById(R.id.bgapp);
//        clover = findViewById(R.id.clover);
//
//        bgAnim = AnimationUtils.loadAnimation(this, R.anim.bganim);
////        cloverAnim = AnimationUtils.loadAnimation(this, R.anim.clovernim);
//        //bgApp.startAnimation(bgAnim);
//        bgApp.animate().translationY(-1900).setDuration(2000).setStartDelay(300);
//        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
//        textSplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);
//        textHome.startAnimation(frombottom);
    }
    //add animation
    private void StartAnimations() {



        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView i = (ImageView) findViewById(R.id.clover);
        i.clearAnimation();
        i.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate2);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.clover);
        iv.clearAnimation();
        iv.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        Splash++;
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Splashscreen.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Splashscreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splashscreen.this.finish();
                }

            }
        };
        splashTread.start();

    }

}