package sound.sleepsound.soundleept3h;

import android.app.Dialog;
import android.app.admin.DeviceAdminInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import com.eftimoff.viewpagertransformers.BackgroundToForegroundTransformer;
import com.eftimoff.viewpagertransformers.CubeInTransformer;
import com.eftimoff.viewpagertransformers.DefaultTransformer;
import com.eftimoff.viewpagertransformers.DepthPageTransformer;
import com.eftimoff.viewpagertransformers.FlipHorizontalTransformer;
import com.eftimoff.viewpagertransformers.RotateUpTransformer;
import com.eftimoff.viewpagertransformers.StackTransformer;
import com.eftimoff.viewpagertransformers.ZoomInTransformer;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator;
import sound.sleepsound.soundleept3h.fragment.FragmentAdapter;
import sound.sleepsound.soundleept3h.fragment.FragmentMucsic;
import sound.sleepsound.soundleept3h.fragment.FragmentNight;
import sound.sleepsound.soundleept3h.fragment.FragmentOcean;
import sound.sleepsound.soundleept3h.fragment.FragmentRain;
import sound.sleepsound.soundleept3h.fragment.FragmentSummer;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener,NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private FragmentAdapter adapter;
    private  CountDownTimer timerRain;
    private AdView banner;

    private long ads=0;
    //
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        //requestAds();
        //




        setSupportActionBar(toolbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(adapter);

        //control.pause();
        toolbar.setBackgroundResource(R.drawable.backgroudn_fragment_rain);
        bottomNavigationView.setBackgroundResource(R.drawable.backgroudn_fragment_rain);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setPageTransformer(true,new StackTransformer());

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_clock:
//                        FragmentRain fragmentRain=(FragmentRain)getSupportFragmentManager().findFragmentById(R.id.fragment_rain);
//                        fragmentRain.helo();
                        // lấy ra fragment thứ 0 trong danh sách
                        showDialogSetTime();
                        break;
                    case R.id.menu_rate:
                        rateApp();
                        break;
                }
                return true;
            }
        });
    }
    private void startSetTime(int time)
    {

        // Fragment rain
        final Fragment pageRain = fragmentList.get(0);
        final Fragment pageOcean = fragmentList.get(1);
        final Fragment pageSummer = fragmentList.get(2);
        final Fragment pageNight = fragmentList.get(3);
        final Fragment pageMusic = fragmentList.get(4);
        //Fragment page = getSupportFragmentManager()
        //     .findFragmentByTag("android:switcher:" + R.id.viewpager + ":" + 0);
//        if (pageRain!= null &&  pageRain.isAdded()){
             //ép kiểu page sang FragmentRain
            final FragmentRain fragmentRain=(FragmentRain)pageRain;
            final FragmentOcean fragmentOcean=(FragmentOcean)pageOcean;
            final FragmentSummer fragmentSummer=(FragmentSummer)pageSummer;
            final FragmentNight fragmentNight=(FragmentNight)pageNight;
            final FragmentMucsic fragmentMusic=(FragmentMucsic)pageMusic;

            timerRain =new CountDownTimer(time*60000,time*60000) {
                @Override
                public void onTick(long l) {
                }

                @Override
                public void onFinish() {
                    fragmentRain.stopAllSoundRain();
                    fragmentOcean.stopAllSoundOcean();
                    fragmentSummer.stopAllSoundSummer();
                    fragmentNight.stopAllSoundNight();
                    fragmentMusic.stopAllSoundMusic();
                }
            };
            timerRain.start();
        }


  // }
    private void showDialogSetTime()
    {
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.layout_set_time);
        final EditText edtSetTime=(EditText)dialog.findViewById(R.id.edt_set_time);
        Button btnConfirm=(Button)dialog.findViewById(R.id.btn_confirm);
        Button btnCancel=(Button)dialog.findViewById(R.id.btn_cancel);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSetTime.getText().toString().trim().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please input time play ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    startSetTime(Integer.parseInt(edtSetTime.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Set time playing success", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "^_^", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

    }
    //
    private void anhXa() {
        // toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_bar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentRain());
        fragmentList.add(new FragmentOcean());
        fragmentList.add(new FragmentSummer());
        fragmentList.add(new FragmentNight());
        fragmentList.add(new FragmentMucsic());
        adapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);

    }

    // click item menu appbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // click item menu navigationbar
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_rain:
                viewPager.setCurrentItem(0);
                return true;
            case R.id.menu_item_ocean:
                viewPager.setCurrentItem(1);
                return true;
            case R.id.menu_item_summer:
                viewPager.setCurrentItem(2);
                return true;
            case R.id.menu_item_night:
                viewPager.setCurrentItem(3);
                return true;
            case R.id.menu_item_music:
                viewPager.setCurrentItem(4);
                return true;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        ads++;
        if(ads%6==0)
        {
            AdRequest adRequest = new AdRequest.Builder().build();

            interstitial = new InterstitialAd(MainActivity.this);

            interstitial.setAdUnitId(getString(R.string.quang_cao_trung_gian_test));
            interstitial.loadAd(adRequest);

            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {

                    //displayInterstitial();
                }
            });
            //

        }
        setSelectedCurentNavi(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private void setSelectedCurentNavi(int positon) {
        switch (positon) {
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.menu_item_rain);
                toolbar.setBackgroundResource(R.drawable.backgroudn_fragment_rain);
                bottomNavigationView.setBackgroundResource(R.drawable.backgroudn_fragment_rain);

                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.menu_item_ocean);
                toolbar.setBackgroundResource(R.drawable.backgroudn_fragment_ocean);
                bottomNavigationView.setBackgroundResource(R.drawable.backgroudn_fragment_ocean);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.menu_item_summer);
                toolbar.setBackgroundResource(R.drawable.backgroudn_fragment_summer);
                bottomNavigationView.setBackgroundResource(R.drawable.backgroudn_fragment_summer);
                break;
            case 3:
                bottomNavigationView.setSelectedItemId(R.id.menu_item_night);
                toolbar.setBackgroundResource(R.drawable.backgroudn_fragment_night);
                bottomNavigationView.setBackgroundResource(R.drawable.backgroudn_fragment_night);
                break;
            case 4:
                bottomNavigationView.setSelectedItemId(R.id.menu_item_music);
                toolbar.setBackgroundResource(R.drawable.backgroudn_fragment_music);
                bottomNavigationView.setBackgroundResource(R.drawable.backgroudn_fragment_music);
                break;
        }
    }

    @Override
    public void onBackPressed() {

        onPreesBack();

    }

    private void requestAds(){
        MobileAds.initialize(this,"ca-app-pub-3993663896557065~5513468486");
       // banner = (AdView)findViewById(R.id.banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);
    }

    private void rateApp()
    {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }
    private void onPreesBack()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this,R.style.MyDialogTheme);
        builder.setTitle("Notification");
        builder.setIcon(R.mipmap.ic_star);
        builder.setMessage("Please RATE this app 5*");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                rateApp();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();
    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

}
