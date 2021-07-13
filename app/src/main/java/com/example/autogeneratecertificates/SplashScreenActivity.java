package com.example.autogeneratecertificates;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        EasySplashScreen config = new EasySplashScreen( SplashScreenActivity.this )
                .withFullScreen()
                .withTargetActivity( MainActivity.class )
                .withSplashTimeOut( 4000 )
                .withBackgroundResource( R.drawable.gradient_splash_background )
                .withHeaderText( "" )
                .withFooterText( "Copyright 2021" )
                .withBeforeLogoText( "" )
                .withAfterLogoText( "CertiGen" )
                .withLogo( R.mipmap.ic_launcher_round );
                //.withLogo( R.drawable.logo_certigen );

        config.getHeaderTextView().setTextColor( Color.BLACK );
        config.getAfterLogoTextView().setTextColor( Color.WHITE );
        config.getBeforeLogoTextView().setTextColor( Color.BLUE );
        config.getFooterTextView().setTextColor( Color.WHITE );

        View splashscreen = config.create();
        setContentView( splashscreen );
    }
}