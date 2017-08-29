package edu.udacity.student.udacity_engagement_monetization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DefaultAdListener;
import com.amazon.device.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Register to show who the creator is
        AdRegistration.setAppKey("sample-app-v1_pub-2");
        //create our ad
        this.interstitialAd = new InterstitialAd(this);
        //load our ad
        interstitialAd.loadAd();
        //ad listener
        this.interstitialAd.setListener(new MyCustomListener());
    }

    class MyCustomListener extends DefaultAdListener {
        @Override
        public void onAdLoaded(Ad ad, AdProperties adProp) {
            MainActivity.this.interstitialAd.showAd();
        }

        @Override
        public void onAdFailedToLoad(Ad ad, AdError err) {

        }

        @Override
        public void onAdDismissed(Ad ad) {

        }
    }
}
