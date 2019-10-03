package com.example.inmobiliariafinal.ui.gallery;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.inmobiliariafinal.MainActivity;
import com.example.inmobiliariafinal.MenuActivity;
import com.example.inmobiliariafinal.Propiedades;
import com.example.inmobiliariafinal.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import Model.Inmueble;

public class GalleryFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AppBarLayout appBarLayout;

    private TextView direccion;
    private TextView ambientes;
    private TextView tipo;
    private TextView uso;


    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        viewPager= root.findViewById(R.id.viewPager);
        appBarLayout= root.findViewById(R.id.appBar);
        tabLayout=new TabLayout(getContext());
        appBarLayout.addView(tabLayout);

        ViewPageAdapter vpa=new ViewPageAdapter(getChildFragmentManager());

        for (Inmueble i: MainActivity.propiedades){ vpa.addFragment(new Propiedades(i),i.getDireccion());}
        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);



        return root;
    }


    public class ViewPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList= new ArrayList<>();
        private List<String> titulosFragments = new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
        public CharSequence getPageTitle(int posicion){
            return titulosFragments.get(posicion);
        }
        public void addFragment(Fragment fragment, String titulo){
            fragmentList.add(fragment);
            titulosFragments.add(titulo);
        }

    }
}