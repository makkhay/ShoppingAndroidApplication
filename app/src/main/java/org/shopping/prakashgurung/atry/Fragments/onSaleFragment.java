package org.shopping.prakashgurung.atry.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopping.prakashgurung.atry.R;

import org.shopping.prakashgurung.atry.Recycler.Album;
import org.shopping.prakashgurung.atry.Recycler.MyRecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by prakashgurung on 1/8/17.
 */

public class onSaleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.onsale_fragment,null);
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.mOnsale);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setAdapter(new MyRecyclerAdapter(this.getActivity(),getOnSaleAlbum()));

        return v;
    }

    private ArrayList<Album> getOnSaleAlbum() {
        // Collection of featured
        ArrayList<Album> albums = new ArrayList<>();
        Album album = new Album("Green Lehenga \nPrice: $30", R.drawable.green1);
        albums.add(album);

        album = new Album("Yellow Lehenga",R.drawable.yellow);
        albums.add(album);

        return albums;



    }


    //Set title For the fragment

    public String toString(){
        return "OnSale";
    }




}
