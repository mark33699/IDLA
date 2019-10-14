package com.example.idla.Lesson16;

import android.Manifest;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.widget.TextView;

import com.example.idla.BaseActivity;
import com.example.idla.R;

import java.util.Timer;
import java.util.TimerTask;

//import androidx.core.os.CancellationSignal;

public class Lesson16Activity extends BaseActivity
{
    private TextView textView;
    private Timer timer;
    private int timeCount;

    private KeyguardManager mKeyguardManager;
    private FingerprintManager fingerprintManager;
    private CancellationSignal cancellationSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson16);
        textView = findViewById(R.id.textView14);
        fingerCheck();
    }

    private void fingerCheck()
    {
//        mKeyguardManager = (KeyguardManager)getSystemService(Activity.KEYGUARD_SERVICE);
//        if (!mKeyguardManager.isKeyguardSecure())
//        {
//            //是否有設定 fingerprint screen lock
//            return;
//        }

        if (checkSelfPermission(Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED)
        {
            fingerprintManager = (FingerprintManager)getSystemService(Activity.FINGERPRINT_SERVICE);
            if (!fingerprintManager.isHardwareDetected())
            {
                textView.setText("您的裝置不支援指紋辨識功能");
                return;
            }

            if (!fingerprintManager.hasEnrolledFingerprints())
            {
                textView.setText("您尚未設定指紋");
                return;
            }
        }
        else
        {
            textView.setText("請允許檢查指紋");
            return;
        }

        fingerListen();
    }

    private void fingerListen()
    {
        timeCount = 0;
        timer = new Timer(true);
        timer.schedule(new Lesson16TimerTask(), 1000, 1000);

        cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(null,cancellationSignal,0,mAuthenticationCallback,null);
    }

    public class Lesson16TimerTask extends TimerTask
    {
        public void run()
        {
            runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    switch (timeCount % 4)
                    {
                        case 0:
                            textView.setText("請使用指紋辨識＼");
                            break;
                        case 1:
                            textView.setText("請使用指紋辨識｜");
                            break;
                        case 2:
                            textView.setText("請使用指紋辨識／");
                            break;
                        case 3:
                            textView.setText("請使用指紋辨識－");
                            break;
                    }
                    timeCount ++;
                }
            });
        }
    }

    FingerprintManager.AuthenticationCallback mAuthenticationCallback
            = new FingerprintManager.AuthenticationCallback()
    {
        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString)
        {
            timer.cancel();
            textView.setText("辨識錯誤\n" + errorCode + "\n" + errString);
        }

        @Override
        public void onAuthenticationFailed()
        {
            textView.setText("辨識失敗");
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result)
        {
            timer.cancel();
            textView.setText("辨識通過");
        }
    };

    @Override
    public void onPause()
    {
        super.onPause();
        if (cancellationSignal != null)
        {
            cancellationSignal.cancel();
            cancellationSignal = null;
        }
    }
}
