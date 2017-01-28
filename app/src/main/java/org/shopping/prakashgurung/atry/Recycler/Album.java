package org.shopping.prakashgurung.atry.Recycler;

/**
 * Created by prakashgurung on 1/8/17.
 */

public class Album {


   private String name;
   private int image;


    public Album(String name, int image){
        this.name=name;
        this.image=image;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
