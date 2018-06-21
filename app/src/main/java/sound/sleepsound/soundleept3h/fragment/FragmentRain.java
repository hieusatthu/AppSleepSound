package sound.sleepsound.soundleept3h.fragment;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.TimedMetaData;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;
import sound.sleepsound.soundleept3h.R;

/**
 * Created by songsong on 4/4/2018.
 */

public class FragmentRain extends Fragment implements View.OnClickListener {
    private ImageView imgRain, imgRainStorm, imgRainThunder, imgRainNight, imgRainForest, imgRainWindow, imgRainUmrella, imgRainSummer, imgRainSmall;
    private boolean checkItemRainRain = true;
    private boolean checkItemRainStorm = true;
    private boolean checkItemRainThunder = true;
    private boolean checkItemRainNight = true;
    private boolean checkItemRainForest = true;
    private boolean checkItemRainWindow = true;
    private boolean checkItemRainUmbrella = true;
    private boolean checkItemRainSummer = true;
    private boolean checkItemRainSmall = true;

    //
    private MediaPlayer mpRain;
    private MediaPlayer mprRainStorm;
    private MediaPlayer mpRainThunder;
    private MediaPlayer mpRainNight;
    private MediaPlayer mpRainForest;
    private MediaPlayer mpRainWindow;
    private MediaPlayer mpRainUmrella;
    private MediaPlayer mpRainSummer;
    private MediaPlayer mpRainSmall;
    //
    private SeekBar seekBar;

    private CircleIndicator circleIndicator;;
    private AudioManager audioManager;







    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_rain, container, false);
        anhXa(view);
        initMediaRain();
        initControl();
        imgRain.setOnClickListener(this);
        imgRainStorm.setOnClickListener(this);
        imgRainThunder.setOnClickListener(this);
        imgRainNight.setOnClickListener(this);
        imgRainForest.setOnClickListener(this);
        imgRainWindow.setOnClickListener(this);
        imgRainUmrella.setOnClickListener(this);
        imgRainSummer.setOnClickListener(this);
        imgRainSmall.setOnClickListener(this);

        circleIndicator=view.findViewById(R.id.indicator_rain);
        ViewPager viewPager=getActivity().findViewById(R.id.viewpager);
        circleIndicator.setViewPager(viewPager);


        return view;
    }

    private void initControl() {

        audioManager=(AudioManager)getActivity().getSystemService(getContext().AUDIO_SERVICE);
        seekBar.setMax(audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBar.setProgress(audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void helo()
    {
        Log.d("AAA","okok");
    }

    private void initMediaRain() {
        mpRain = MediaPlayer.create(getContext(), R.raw.rain_main);
        mprRainStorm = MediaPlayer.create(getContext(), R.raw.rain_main);
        mpRainThunder = MediaPlayer.create(getContext(), R.raw.thunders);
        mpRainNight = MediaPlayer.create(getContext(), R.raw.train_rain);
        mpRainForest = MediaPlayer.create(getContext(), R.raw.rain_in_forest_main);
        mpRainWindow = MediaPlayer.create(getContext(), R.raw.train_main);
        mpRainUmrella = MediaPlayer.create(getContext(), R.raw.rainforest_main);
        mpRainSummer = MediaPlayer.create(getContext(), R.raw.rainforest_birds);
        mpRainSmall = MediaPlayer.create(getContext(), R.raw.rain_main);

    }

    private void anhXa(View view) {
        imgRain = (ImageView) view.findViewById(R.id.img_rain);
        imgRainStorm = (ImageView) view.findViewById(R.id.ic_rain_storm);
        imgRainThunder = (ImageView) view.findViewById(R.id.ic_rain_thunder);
        imgRainNight = (ImageView) view.findViewById(R.id.ic_rain_night);
        imgRainForest = (ImageView) view.findViewById(R.id.ic_rain_forest);
        imgRainWindow = (ImageView) view.findViewById(R.id.ic_rain_window);
        imgRainUmrella = (ImageView) view.findViewById(R.id.ic_rain_umbrella);
        imgRainSummer = (ImageView) view.findViewById(R.id.ic_rain_summer);
        imgRainSmall = (ImageView) view.findViewById(R.id.ic_rain_small);
        seekBar=view.findViewById(R.id.seekbar_rain);

    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();
        switch (idView) {
            case R.id.img_rain:
                if (checkItemRainRain == true) {
                    imgRain.setBackgroundResource(R.drawable.click_item_fragment);
                    mpRain.start();
                    mpRain.setLooping(true);
                    audioManager.stopBluetoothSco();
                    //test();
                    checkItemRainRain = false;
                } else {
                    imgRain.setBackgroundResource(R.drawable.unclick_item_fragment);
                    mpRain.pause();
                    checkItemRainRain = true;
                }
                break;
            case R.id.ic_rain_storm:
                if (checkItemRainStorm == true) {
                    mprRainStorm.start();
                    mprRainStorm.setLooping(true);

                    imgRainStorm.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemRainStorm = false;
                } else {
                    mprRainStorm.pause();
                    imgRainStorm.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemRainStorm = true;
                }
                break;
            case R.id.ic_rain_thunder:
                if (checkItemRainThunder == true) {
                    mpRainThunder.start();
                    mpRainThunder.setLooping(true);
                    imgRainThunder.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemRainThunder = false;
                } else {
                    mpRainThunder.pause();
                    imgRainThunder.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemRainThunder = true;
                }
                break;
            case R.id.ic_rain_night:
                if (checkItemRainNight == true) {
                    mpRainNight.start();
                    mpRainNight.setLooping(true);
                    imgRainNight.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemRainNight = false;
                } else {
                    mpRainNight.pause();
                    imgRainNight.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemRainNight = true;
                }
                break;
            case R.id.ic_rain_forest:
                if (checkItemRainForest == true) {
                    mpRainForest.start();
                    mpRainForest.setLooping(true);
                    imgRainForest.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemRainForest = false;
                } else {
                    mpRainForest.pause();
                    imgRainForest.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemRainForest = true;
                }
                break;
            case R.id.ic_rain_window:
                if (checkItemRainWindow == true) {
                    mpRainWindow.start();
                    mpRainWindow.setLooping(true);
                    imgRainWindow.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemRainWindow = false;
                } else {
                    mpRainWindow.pause();
                    imgRainWindow.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemRainWindow = true;
                }
                break;
            case R.id.ic_rain_umbrella:
                if (checkItemRainUmbrella == true) {
                    mpRainUmrella.start();
                    mpRainUmrella.setLooping(true);
                    imgRainUmrella.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemRainUmbrella = false;
                } else {
                    mpRainUmrella.pause();
                    imgRainUmrella.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemRainUmbrella = true;
                }
                break;
            case R.id.ic_rain_summer:
                if (checkItemRainSummer == true) {
                    mpRainSummer.start();
                    mpRainSummer.setLooping(true);
                    imgRainSummer.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemRainSummer = false;
                } else {
                    mpRainSummer.pause();
                    imgRainSummer.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemRainSummer = true;
                }
                break;
            case R.id.ic_rain_small:
                if (checkItemRainSmall == true) {
                    mpRainSmall.start();
                    mpRainSmall.setLooping(true);
                    imgRainSmall.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemRainSmall = false;
                } else {
                    mpRainSmall.pause();
                    imgRainSmall.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemRainSmall = true;
                }
                break;
        }
    }

   public void stopAllSoundRain()
   {
       mpRain.stop();
       mprRainStorm.stop();
       mpRainThunder.stop();
       mpRainNight.stop();
       mpRainForest.stop();
       mpRainWindow.stop();
       mpRainUmrella.stop();
       mpRainSummer.stop();
       mpRainSmall.stop();
   }
}
