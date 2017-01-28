package org.shopping.prakashgurung.atry.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopping.prakashgurung.atry.R;

/**
 * Created by prakashgurung on 1/8/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img;
    TextView nameTxt;
    ItemClickListener itemClickListener;

    public MyViewHolder(View itemView) {

        super(itemView);

        nameTxt=(TextView) itemView.findViewById(R.id.nameTxt);
        img = (ImageView) itemView.findViewById(R.id.movieImage);

        itemView.setOnClickListener(this);



    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;

    }


    @Override
    public void onClick(View v) {

        this.itemClickListener.onItemClick(v,getLayoutPosition());


    }
}
