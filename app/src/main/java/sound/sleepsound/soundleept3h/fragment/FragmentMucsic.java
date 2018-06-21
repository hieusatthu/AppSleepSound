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

public class FragmentMucsic extends Fragment implements View.OnClickListener{

    private ImageView imgMusicPiano,imgMusicGuitar,imgMucsicNotes,imgMusicWater,imgMusicDolphin,
    imgMusicRadio,imgMusicCoral,imgMusicWeel,imgMusicBoatTwo;
    private boolean checkItemMusicPiano=true;
    private boolean checkItemMusicGuitar=true;
    private boolean checkItemMusicNotes=true;
    private boolean checkItemMusicWater=true;
    private boolean checkItemMusicDolphin=true;
    private boolean checkItemMusicRadio=true;
    private boolean checkItemMusicCoral=true;
    private boolean checkItemMusicWeel=true;
    private boolean checkItemMusicBoatTwo=true;
    private CircleIndicator circleIndicator;
    //
    private MediaPlayer mpMusicPiano;
    private MediaPlayer mpMusicGuitar;
    private MediaPlayer mpMusicNotes;
    private MediaPlayer mpMusicWater;
    private MediaPlayer mpMusicDolphin;
    private MediaPlayer mpMusicRadio;
    private MediaPlayer mpMusicCoral;
    private MediaPlayer mpMusicWeel;
    private MediaPlayer mpMusicBoatTwo;
    //
    private SeekBar seekBar;
    private AudioManager audioManager;
    //

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment_music,container,false);
        anhXa(view);
        imgMusicPiano.setOnClickListener(this);
        imgMusicGuitar.setOnClickListener(this);
        imgMucsicNotes.setOnClickListener(this);
        imgMusicWater.setOnClickListener(this);
        imgMusicDolphin.setOnClickListener(this);
        imgMusicCoral.setOnClickListener(this);
        imgMusicWeel.setOnClickListener(this);
        imgMusicBoatTwo.setOnClickListener(this);
        imgMusicRadio.setOnClickListener(this);
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
        imgMusicPiano=view.findViewById(R.id.ic_music_piano);
        imgMusicGuitar=view.findViewById(R.id.ic_music_guitar);
        imgMucsicNotes=view.findViewById(R.id.ic_music_notes);
        imgMusicWater=view.findViewById(R.id.ic_music_water);
        imgMusicDolphin=view.findViewById(R.id.ic_music_dolphin);
        imgMusicRadio=view.findViewById(R.id.ic_music_radio);
        imgMusicWeel=view.findViewById(R.id.ic_music_wheel);
        imgMusicBoatTwo=view.findViewById(R.id.ic_music_boat_two);
        imgMusicCoral=view.findViewById(R.id.ic_music_coral);
        //
        seekBar=view.findViewById(R.id.seekbar_ocean);
    }

    @Override
    public void onClick(View view) {
        int idView=view.getId();
        switch (idView)
        {
            case R.id.ic_music_piano:
                if(checkItemMusicPiano == true){
                    mpMusicPiano.start();
                    mpMusicPiano.setLooping(true);
                    imgMusicPiano.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicPiano = false;
                }else{
                    mpMusicPiano.pause();
                    imgMusicPiano.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicPiano = true;
                }
                break;
            case R.id.ic_music_guitar:
                if(checkItemMusicGuitar == true){
                    mpMusicGuitar.start();
                    mpMusicGuitar.setLooping(true);
                    imgMusicGuitar.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicGuitar = false;
                }else{
                    mpMusicGuitar.pause();
                    imgMusicGuitar.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicGuitar = true;
                }
                break;
            case R.id.ic_music_notes:
                if(checkItemMusicNotes == true){
                    mpMusicNotes.start();
                    mpMusicNotes.setLooping(true);
                    imgMucsicNotes.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicNotes = false;
                }else{
                    mpMusicNotes.pause();
                    imgMucsicNotes.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicNotes = true;
                }
                break;
            case R.id.ic_music_water:
                if(checkItemMusicWater == true){
                    mpMusicWater.start();
                    mpMusicWater.setLooping(true);
                    imgMusicWater.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicWater = false;
                }else{
                    mpMusicWater.pause();
                    imgMusicWater.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicWater = true;
                }
                break;
            case R.id.ic_music_dolphin:
                if(checkItemMusicDolphin == true){
                    mpMusicDolphin.start();
                    mpMusicDolphin.setLooping(true);
                    imgMusicDolphin.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicDolphin = false;
                }else{
                    mpMusicDolphin.pause();
                    imgMusicDolphin.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicDolphin = true;
                }
                break;
            case R.id.ic_music_radio:
                if(checkItemMusicRadio == true){
                    mpMusicRadio.start();
                    mpMusicRadio.setLooping(true);
                    imgMusicRadio.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicRadio = false;
                }else{
                    mpMusicRadio.pause();
                    imgMusicRadio.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicRadio = true;
                }
                break;
            case R.id.ic_music_wheel:
                if(checkItemMusicWeel == true){
                    mpMusicWeel.start();
                    mpMusicWeel.setLooping(true);
                    imgMusicWeel.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicWeel = false;
                }else{
                    mpMusicWeel.pause();
                    imgMusicWeel.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicWeel = true;
                }
                break;
            case R.id.ic_music_boat_two:
                if(checkItemMusicBoatTwo == true){
                    mpMusicBoatTwo.start();
                    mpMusicBoatTwo.setLooping(true);
                    imgMusicBoatTwo.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicBoatTwo = false;
                }else{
                    mpMusicBoatTwo.pause();
                    imgMusicBoatTwo.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicBoatTwo = true;
                }
                break;
            case R.id.ic_music_coral:
                if(checkItemMusicCoral == true){
                    mpMusicCoral.start();
                    mpMusicCoral.setLooping(true);
                    imgMusicCoral.setBackgroundResource(R.drawable.click_item_fragment);
                    checkItemMusicCoral = false;
                }else{
                    mpMusicCoral.pause();
                    imgMusicCoral.setBackgroundResource(R.drawable.unclick_item_fragment);
                    checkItemMusicCoral = true;
                }
                break;

        }
    }
    private void initMediaNight() {

        mpMusicPiano = MediaPlayer.create(getContext(), R.raw.piano);
        mpMusicGuitar = MediaPlayer.create(getContext(), R.raw.harp);
        mpMusicNotes = MediaPlayer.create(getContext(), R.raw.piano_2);
        mpMusicWater = MediaPlayer.create(getContext(), R.raw.cave_main);
        mpMusicDolphin = MediaPlayer.create(getContext(), R.raw.creek);
        mpMusicRadio = MediaPlayer.create(getContext(), R.raw.iceflakes);
        mpMusicCoral = MediaPlayer.create(getContext(), R.raw.wolves);
        mpMusicWeel = MediaPlayer.create(getContext(), R.raw.crikets);
        mpMusicBoatTwo = MediaPlayer.create(getContext(), R.raw.ocean_main);
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

    public void stopAllSoundMusic()
    {
        mpMusicPiano.stop();
        mpMusicGuitar.stop();
        mpMusicNotes.stop();
        mpMusicWater.stop();
        mpMusicDolphin.stop();
        mpMusicRadio.stop();
        mpMusicCoral.stop();
        mpMusicWeel.stop();
        mpMusicBoatTwo.stop();
    }
}