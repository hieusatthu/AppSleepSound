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

public class FragmentSummer extends Fragment implements View.OnClickListener {
    private ImageView imgSummerBird, imgSummerForest, imgSummerLeaf,
            imgSummerLadyBird, imgSummerTree, imgSummerSun, imgSummerMorning, imgSummerCafe, imgSummerDry;
    private boolean checkItemSummerBird = true;
    private boolean checkItemSummerForest = true;
    private boolean checkItemSummerLeaf = true;
    private boolean checkItemLadyBird = true;
    private boolean checkItemSummerTree = true;
    private boolean checkItemSummerSun = true;
    private boolean checkItemSummerMorning = true;
    private boolean checkItemSummerCafe = true;
    private boolean checkItemSummerDry = true;
    private CircleIndicator circleIndicator;
    //
    private MediaPlayer mpSummerBird;
    private MediaPlayer mprSummerForest;
    private MediaPlayer mpSummerLeaf;
    private MediaPlayer mpSummerLadyBird;
    private MediaPlayer mpSummerTree;
    private MediaPlayer mpSummerSun;
    private MediaPlayer mpSummerMorning;
    private MediaPlayer mpSummerCafe;
    private MediaPlayer mpSummerDry;
    //
    private SeekBar seekBar;
    private AudioManager audioManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_summer, container, false);
        anhXa(view);
        imgSummerBird.setOnClickListener(this);
        imgSummerForest.setOnClickListener(this);
        imgSummerLeaf.setOnClickListener(this);
        imgSummerLadyBird.setOnClickListener(this);
        imgSummerTree.setOnClickListener(this);
        imgSummerSun.setOnClickListener(this);
        imgSummerMorning.setOnClickListener(this);
        imgSummerCafe.setOnClickListener(this);
        imgSummerDry.setOnClickListener(this);
        circleIndicator = view.findViewById(R.id.indicator_rain);
        ViewPager viewPager = getActivity().findViewById(R.id.viewpager);
        circleIndicator.setViewPager(viewPager);
        //
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction= manager.beginTransaction();
        transaction.addToBackStack(null);
        initMediaSummer();
        initControl();

        return view;
    }

    private void anhXa(View view) {
        imgSummerBird = view.findViewById(R.id.ic_summer_bird);
        imgSummerForest = view.findViewById(R.id.ic_summer_forest);
        imgSummerLeaf = view.findViewById(R.id.ic_summer_leaf);
        imgSummerLadyBird = view.findViewById(R.id.ic_summer_ladybird);
        imgSummerTree = view.findViewById(R.id.ic_summer_tree);
        imgSummerSun = view.findViewById(R.id.ic_summer_sun);
        imgSummerMorning = view.findViewById(R.id.ic_summer_morning);
        imgSummerCafe = view.findViewById(R.id.ic_summer_caffe);
        imgSummerDry = view.findViewById(R.id.ic_summer_dry);
        //
        seekBar = view.findViewById(R.id.seekbar_summer);
    }

    @Override
    public void onClick(View view) {

        int idView = view.getId();
        switch (idView) {
            case R.id.ic_summer_bird:
                if (checkItemSummerBird == true) {
                    mpSummerBird.start();
                    mpSummerBird.setLooping(true);
                    imgSummerBird.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemSummerBird = false;
                } else {
                    mpSummerBird.pause();
                    imgSummerBird.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemSummerBird = true;
                }
                break;
            case R.id.ic_summer_forest:
                if (checkItemSummerForest == true) {
                    mprSummerForest.start();
                    mprSummerForest.setLooping(true);
                    imgSummerForest.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemSummerForest = false;
                } else {
                    mprSummerForest.pause();
                    imgSummerForest.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemSummerForest = true;
                }
                break;
            case R.id.ic_summer_leaf:
                if (checkItemSummerLeaf == true) {
                    mpSummerLeaf.start();
                    mpSummerLeaf.setLooping(true);
                    imgSummerLeaf.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemSummerLeaf = false;
                } else {
                    mpSummerLeaf.pause();
                    imgSummerLeaf.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemSummerLeaf = true;
                }
                break;
            case R.id.ic_summer_ladybird:
                if (checkItemLadyBird == true) {
                    mpSummerLadyBird.start();
                    mpSummerLadyBird.setLooping(true);
                    imgSummerLadyBird.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemLadyBird = false;
                } else {
                    mpSummerLadyBird.pause();
                    imgSummerLadyBird.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemLadyBird = true;
                }
                break;
            case R.id.ic_summer_tree:
                if (checkItemSummerTree == true) {
                    mpSummerTree.start();
                    mpSummerTree.setLooping(true);
                    imgSummerTree.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemSummerTree = false;
                } else {
                    mpSummerTree.pause();
                    imgSummerTree.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemSummerTree = true;
                }
                break;
            case R.id.ic_summer_sun:
                if (checkItemSummerSun == true) {
                    mpSummerSun.start();
                    mpSummerSun.setLooping(true);
                    imgSummerSun.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemSummerSun = false;
                } else {
                    mpSummerSun.pause();
                    imgSummerSun.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemSummerSun = true;
                }
                break;
            case R.id.ic_summer_morning:
                if (checkItemSummerMorning == true) {
                    mpSummerMorning.start();
                    mpSummerMorning.setLooping(true);
                    imgSummerMorning.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemSummerMorning = false;
                } else {
                    mpSummerMorning.pause();
                    imgSummerMorning.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemSummerMorning = true;
                }
                break;
            case R.id.ic_summer_caffe:
                if (checkItemSummerCafe == true) {
                    mpSummerCafe.start();
                    mpSummerCafe.setLooping(true);
                    imgSummerCafe.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemSummerCafe = false;
                } else {
                    mpSummerCafe.pause();
                    imgSummerCafe.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemSummerCafe = true;
                }
                break;
            case R.id.ic_summer_dry:
                if (checkItemSummerDry == true) {
                    mpSummerDry.start();
                    mpSummerDry.setLooping(true);
                    imgSummerDry.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemSummerDry = false;
                } else {
                    mpSummerDry.pause();
                    imgSummerDry.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemSummerDry = true;
                }
                break;
        }
    }

    private void initMediaSummer() {
        mpSummerBird = MediaPlayer.create(getContext(), R.raw.birds);
        mprSummerForest = MediaPlayer.create(getContext(), R.raw.autumn_forest_main);
        mpSummerLeaf = MediaPlayer.create(getContext(), R.raw.winter_main);
        mpSummerLadyBird = MediaPlayer.create(getContext(), R.raw.owls);
        mpSummerTree = MediaPlayer.create(getContext(), R.raw.rainforest_main);
        mpSummerSun = MediaPlayer.create(getContext(), R.raw.fire);
        mpSummerMorning = MediaPlayer.create(getContext(), R.raw.gong_bell);
        mpSummerCafe = MediaPlayer.create(getContext(), R.raw.creek);
        mpSummerDry = MediaPlayer.create(getContext(), R.raw.winter_main);

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
   public void stopAllSoundSummer()
   {
        mpSummerBird.stop();
        mprSummerForest.stop();
        mpSummerLeaf.stop();
        mpSummerLadyBird.stop();
        mpSummerTree.stop();
        mpSummerSun.stop();
        mpSummerMorning.stop();
        mpSummerCafe.stop();
        mpSummerDry.stop();
   }
}
