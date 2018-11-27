package com.example.vicky.fullscreenads

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this,getString(R.string.admob_app_id))

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId= getString(R.string.interstital_ad_id)
        mInterstitialAd.loadAd(AdRequest.Builder().build())


        btn_load_ad.setOnClickListener {
            if(mInterstitialAd.isLoaded)
                mInterstitialAd.show()
        }

    }
}
