package com.aswin.boomview;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button butcls,but;
    ImageView locio;
    LinearLayout backcon,hv;

    Animation fromsmall,fromnothing,forloci,togo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butcls=(Button)findViewById(R.id.butcls);
        but=(Button)findViewById(R.id.but);
        locio=(ImageView)findViewById(R.id.locion);
        backcon=(LinearLayout)findViewById(R.id.hc);
        hv=(LinearLayout)findViewById(R.id.hv);
        backcon.setAlpha(0);
        hv.setAlpha(0);
        locio.setVisibility(View.GONE);


        fromsmall=AnimationUtils.loadAnimation(this,R.anim.fromsmall);

        fromnothing=AnimationUtils.loadAnimation(this,R.anim.fromnothing);
        forloci=AnimationUtils.loadAnimation(this,R.anim.forloci);
        togo=AnimationUtils.loadAnimation(this,R.anim.togo);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backcon.setAlpha(1);
                backcon.startAnimation(fromsmall);

                hv.setAlpha(1);
                hv.startAnimation(fromnothing);

                locio.setVisibility(View.VISIBLE);
                locio.startAnimation(forloci);



            }
        });

        butcls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backcon.startAnimation(togo);
                hv.startAnimation(togo);
               locio.startAnimation(togo);
               locio.setVisibility(View.GONE);


                ViewCompat.animate(backcon).setStartDelay(1000).alpha(0).start();
                ViewCompat.animate(hv).setStartDelay(1000).alpha(0).start();


            }
        });




    }
}
