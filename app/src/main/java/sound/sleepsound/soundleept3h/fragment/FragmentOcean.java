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

public class FragmentOcean extends Fragment implements View.OnClickListener {
    private ImageView imgOceanForest,imgOceanBoat,imgOceanWave,imgOceanWater,imgOceanDolphin,imgOceanShark,
    imgOceanCoral,imgOceanWeel,imgOceanBoatTwo;
    private boolean checkItemOceanForest = true;
    private boolean checkItemOceanBoat = true;
    private boolean checkItemOceanWave = true;
    private boolean checkItemOceanWater = true;
    private boolean checkItemOceanDolphin = true;
    private boolean checkItemOceanShark = true;
    private boolean checkItemOceanCoral = true;
    private boolean checkItemOceanWeel = true;
    private boolean checkItemOceanBoatTwo = true;
    private CircleIndicator circleIndicator;

    //
    //
    private MediaPlayer mpOceanForest;
    private MediaPlayer mpOceanBoat;
    private MediaPlayer mpOceanWave;
    private MediaPlayer mpOceanWater;
    private MediaPlayer mpOceanDolphin;
    private MediaPlayer mpOceanShark;
    private MediaPlayer mpOceanCoral;
    private MediaPlayer mpOceanWeel;
    private MediaPlayer mpOceanBoatTwo;
    //
    private SeekBar seekBar;
    private AudioManager audioManager;
    //


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_ocean, container, false);
        anhXa(view);
        imgOceanForest.setOnClickListener(this);
        imgOceanBoat.setOnClickListener(this);
        imgOceanWave.setOnClickListener(this);
        imgOceanWater.setOnClickListener(this);
        imgOceanDolphin.setOnClickListener(this);
        imgOceanCoral.setOnClickListener(this);
        imgOceanWeel.setOnClickListener(this);
        imgOceanBoatTwo.setOnClickListener(this);
        imgOceanShark.setOnClickListener(this);
        circleIndicator=view.findViewById(R.id.indicator_rain);
        ViewPager viewPager=getActivity().findViewById(R.id.viewpager);
        circleIndicator.setViewPager(viewPager);
        //
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.addToBackStack(null);
        //
        initMediaOcean();
        //
        initControl();
        return view;
    }

    private void anhXa(View view) {
        imgOceanForest=(ImageView)view.findViewById(R.id.ic_ocean_forest);
        imgOceanBoat=(ImageView)view.findViewById(R.id.ic_ocean_boat);
        imgOceanWave=(ImageView)view.findViewById(R.id.ic_ocean_wave);
        imgOceanWater=(ImageView)view.findViewById(R.id.ic_ocean_water);
        imgOceanDolphin=(ImageView)view.findViewById(R.id.ic_ocean_dolphin);
        imgOceanShark=(ImageView)view.findViewById(R.id.ic_ocean_shark);
        imgOceanCoral=(ImageView)view.findViewById(R.id.ic_ocean_coral);
        imgOceanWeel=(ImageView)view.findViewById(R.id.ic_ocean_wheel);
        imgOceanBoatTwo=(ImageView)view.findViewById(R.id.ic_ocean_boat_two);
        //
        seekBar=view.findViewById(R.id.seekbar_ocean);
    }

    @Override
    public void onClick(View view) {
        int idView=view.getId();
        switch (idView)
        {
            case R.id.ic_ocean_forest:
                if(checkItemOceanForest == true){
                    mpOceanForest.start();
                    mpOceanForest.setLooping(true);
                    imgOceanForest.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanForest = false;
                }else{
                    mpOceanForest.pause();
                    imgOceanForest.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanForest = true;
                }
                break;
            case R.id.ic_ocean_boat:
                if(checkItemOceanBoat == true){
                    mpOceanBoat.start();
                    mpOceanBoat.setLooping(true);
                    imgOceanBoat.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanBoat = false;
                }else{
                    mpOceanBoat.pause();
                    imgOceanBoat.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanBoat = true;
                }
                break;
            case R.id.ic_ocean_wave:
                if(checkItemOceanWave == true){
                    mpOceanWave.start();
                    mpOceanWave.setLooping(true);
                    imgOceanWave.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanWave = false;
                }else{
                    mpOceanWave.pause();
                    imgOceanWave.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanWave = true;
                }
                break;
            case R.id.ic_ocean_water:
                if(checkItemOceanWater == true){
                    mpOceanWater.start();
                    mpOceanWater.setLooping(true);
                    imgOceanWater.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanWater = false;
                }else{
                    mpOceanWater.pause();
                    imgOceanWater.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanWater = true;
                }
                break;
            case R.id.ic_ocean_dolphin:
                if(checkItemOceanDolphin == true){
                    mpOceanDolphin.start();
                    mpOceanDolphin.setLooping(true);
                    imgOceanDolphin.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanDolphin = false;
                }else{
                    mpOceanDolphin.pause();
                    imgOceanDolphin.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanDolphin = true;
                }
                break;
            case R.id.ic_ocean_shark:
                if(checkItemOceanShark == true){
                    mpOceanShark.start();
                    mpOceanShark.setLooping(true);
                    imgOceanShark.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanShark = false;
                }else{
                    mpOceanShark.pause();
                    imgOceanShark.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanShark = true;
                }
                break;
            case R.id.ic_ocean_coral:
                if(checkItemOceanCoral == true){
                    mpOceanCoral.start();
                    mpOceanCoral.setLooping(true);
                    imgOceanCoral.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanCoral = false;
                }else{
                    mpOceanCoral.pause();
                    imgOceanCoral.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanCoral = true;
                }
                break;
            case R.id.ic_ocean_wheel:
                if(checkItemOceanWeel == true){
                    mpOceanWeel.start();
                    mpOceanWeel.setLooping(true);
                    imgOceanWeel.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanWeel = false;
                }else{
                    mpOceanWeel.pause();
                    imgOceanWeel.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanWeel = true;
                }
                break;
            case R.id.ic_ocean_boat_two:
                if(checkItemOceanBoatTwo == true){
                    mpOceanBoatTwo.start();
                    mpOceanBoatTwo.setLooping(true);
                    imgOceanBoatTwo.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemOceanBoatTwo = false;
                }else{
                    mpOceanBoatTwo.pause();
                    imgOceanBoatTwo.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemOceanBoatTwo = true;
                }
                break;
        }
    }
    private void initMediaOcean() {
        mpOceanForest = MediaPlayer.create(getContext(), R.raw.winter_main);
        mpOceanBoat = MediaPlayer.create(getContext(), R.raw.ocean_main);
        mpOceanWave = MediaPlayer.create(getContext(), R.raw.ocean_main);
        mpOceanWater = MediaPlayer.create(getContext(), R.raw.cave_main);
        mpOceanDolphin = MediaPlayer.create(getContext(), R.raw.creek);
        mpOceanShark = MediaPlayer.create(getContext(), R.raw.ocean_main);
        mpOceanCoral = MediaPlayer.create(getContext(), R.raw.airplane_main);
        mpOceanWeel = MediaPlayer.create(getContext(), R.raw.car_main);
        mpOceanBoatTwo = MediaPlayer.create(getContext(), R.raw.airplane_main);
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
    public void stopAllSoundOcean()
    {
         mpOceanForest.stop();
         mpOceanBoat.stop();
         mpOceanWave.stop();
         mpOceanWater.stop();
         mpOceanDolphin.stop();
         mpOceanShark.stop();
         mpOceanCoral.stop();
         mpOceanWeel.stop();
         mpOceanBoatTwo.stop();
    }
}
