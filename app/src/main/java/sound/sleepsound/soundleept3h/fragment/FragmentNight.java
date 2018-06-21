package sound.sleepsound.soundleept3h.fragment;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import me.relex.circleindicator.CircleIndicator;
import sound.sleepsound.soundleept3h.R;

/**
 * Created by songsong on 4/4/2018.
 */

public class FragmentNight extends Fragment implements View.OnClickListener{
    private ImageView imgNightStorm,imgNightLandScape,imgNightLadyBird,imgNightMoon,imgNightSleep,imgNightBirdHome
            ,imgNightWolf,imgNightBat,imgNightLamp;
    private boolean checkItemNightStorm = true;
    private boolean checkItemNightLandScape = true;
    private boolean checkItemNightLadyBird = true;
    private boolean checkItemNightMoon = true;
    private boolean checkItemNightSleep = true;
    private boolean checkItemNightBirdHome = true;
    private boolean checkItemNightWolf = true;
    private boolean checkItemNightBat = true;
    private boolean checkItemNightLamp = true;
    private CircleIndicator circleIndicator;
    //
    private MediaPlayer mpNightStorm;
    private MediaPlayer mpNightLanScape;
    private MediaPlayer mpNightLadyBird;
    private MediaPlayer mpNightMoon;
    private MediaPlayer mpNightSleep;
    private MediaPlayer mpNightBirdHome;
    private MediaPlayer mpNightWolf;
    private MediaPlayer mpNightBat;
    private MediaPlayer mpNightLamp;
    //
    private SeekBar seekBar;
    private AudioManager audioManager;
    //

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment_night,container,false);
        anhXa(view);
        imgNightStorm.setOnClickListener(this);
        imgNightLandScape.setOnClickListener(this);
        imgNightLadyBird.setOnClickListener(this);
        imgNightSleep.setOnClickListener(this);
        imgNightBirdHome.setOnClickListener(this);
        imgNightWolf.setOnClickListener(this);
        imgNightBat.setOnClickListener(this);
        imgNightMoon.setOnClickListener(this);
        imgNightLamp.setOnClickListener(this);
        circleIndicator=view.findViewById(R.id.indicator_rain);
        ViewPager viewPager=getActivity().findViewById(R.id.viewpager);
        circleIndicator.setViewPager(viewPager);
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.addToBackStack(null);
        initMediaNight();
        initControl();
        return view;
    }
    private void anhXa(View view) {
        imgNightStorm=view.findViewById(R.id.ic_night_storm);
        imgNightLandScape=view.findViewById(R.id.ic_night_landscape);
        imgNightLadyBird=view.findViewById(R.id.ic_night_ladybird);
        imgNightMoon=view.findViewById(R.id.ic_night_moon);
        imgNightSleep=view.findViewById(R.id.ic_night_sleep);
        imgNightBirdHome=view.findViewById(R.id.ic_night_home_bird);
        imgNightWolf=view.findViewById(R.id.ic_night_wolf);
        imgNightBat=view.findViewById(R.id.ic_night_bat);
        imgNightLamp=view.findViewById(R.id.ic_night_lamp);
        //
        seekBar=view.findViewById(R.id.seekbar_ocean);
    }

    @Override
    public void onClick(View view) {
        int idView=view.getId();
        switch (idView)
        {
            case R.id.ic_night_storm:
                if(checkItemNightStorm == true){
                    mpNightStorm.start();
                    mpNightStorm.setLooping(true);
                    imgNightStorm.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightStorm = false;
                }else{
                    mpNightStorm.pause();
                    imgNightStorm.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightStorm = true;
                }
                break;
            case R.id.ic_night_landscape:
                if(checkItemNightLandScape == true){
                    mpNightLanScape.start();
                    mpNightLanScape.setLooping(true);
                    imgNightLandScape.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightLandScape = false;
                }else{
                    mpNightLanScape.pause();
                    imgNightLandScape.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightLandScape = true;
                }
                break;
            case R.id.ic_night_ladybird:
                if(checkItemNightLadyBird == true){
                    mpNightLadyBird.start();
                    mpNightLadyBird.setLooping(true);
                    imgNightLadyBird.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightLadyBird = false;
                }else{
                    mpNightLadyBird.pause();
                    imgNightLadyBird.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightLadyBird = true;
                }
                break;
            case R.id.ic_night_moon:
                if(checkItemNightMoon == true){
                    mpNightMoon.start();
                    mpNightMoon.setLooping(true);
                    imgNightMoon.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightMoon = false;
                }else{
                    mpNightMoon.pause();
                    imgNightMoon.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightMoon = true;
                }
                break;
            case R.id.ic_night_sleep:
                if(checkItemNightSleep == true){
                    mpNightSleep.start();
                    mpNightSleep.setLooping(true);
                    imgNightSleep.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightSleep = false;
                }else{
                    mpNightSleep.pause();
                    imgNightSleep.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightSleep = true;
                }
                break;
            case R.id.ic_night_home_bird:
                if(checkItemNightBirdHome == true){
                    mpNightBirdHome.start();
                    mpNightBirdHome.setLooping(true);
                    imgNightBirdHome.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightBirdHome = false;
                }else{
                    mpNightBirdHome.pause();
                    imgNightBirdHome.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightBirdHome = true;
                }
                break;
            case R.id.ic_night_wolf:
                if(checkItemNightWolf == true){
                    mpNightWolf.start();
                    mpNightWolf.setLooping(true);
                    imgNightWolf.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightWolf = false;
                }else{
                    mpNightWolf.pause();
                    imgNightWolf.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightWolf = true;
                }
                break;
            case R.id.ic_night_bat:
                if(checkItemNightBat== true){
                    mpNightBat.start();
                    mpNightBat.setLooping(true);
                    imgNightBat.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightBat = false;
                }else{
                    mpNightBat.pause();
                    imgNightBat.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightBat = true;
                }
                break;
            case R.id.ic_night_lamp:
                if(checkItemNightLamp == true){
                    mpNightLamp.start();
                    mpNightLamp.setLooping(true);
                    imgNightLamp.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemNightLamp = false;
                }else{
                    mpNightLamp.pause();
                    imgNightLamp.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemNightLamp = true;
                }
                break;
        }
    }
    private void initMediaNight() {
        //
        mpNightStorm = MediaPlayer.create(getContext(), R.raw.winter_main);
        mpNightLanScape = MediaPlayer.create(getContext(), R.raw.iceflakes);
        mpNightLadyBird = MediaPlayer.create(getContext(), R.raw.owls);
        mpNightMoon = MediaPlayer.create(getContext(), R.raw.cave_main);
        mpNightSleep = MediaPlayer.create(getContext(), R.raw.rain_main);
        mpNightBirdHome = MediaPlayer.create(getContext(), R.raw.crikets);
        mpNightWolf = MediaPlayer.create(getContext(), R.raw.wolves);
        mpNightBat = MediaPlayer.create(getContext(), R.raw.cave_main);
        mpNightLamp = MediaPlayer.create(getContext(), R.raw.birds);
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

    public void stopAllSoundNight()
    {
         mpNightStorm.stop();
         mpNightLanScape.stop();
         mpNightLadyBird.stop();
         mpNightMoon.stop();
         mpNightSleep.stop();
         mpNightBirdHome.stop();
         mpNightWolf.stop();
         mpNightBat.stop();
         mpNightLamp.stop();
    }
}
