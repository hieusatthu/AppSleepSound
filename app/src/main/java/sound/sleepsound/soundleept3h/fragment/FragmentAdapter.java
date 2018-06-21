package sound.sleepsound.soundleept3h.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by songsong on 4/4/2018.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList;
    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragmentList=fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
