package com.district3.verticalviewpagerdemo;

import java.util.ArrayList;

/**
 * Created by chung on 4/16/16.
 */
public class PlaceData {

    // "Bora Bora", "Canada", "Dubai", "Hong Kong", "Iceland", "India", "Kenya", "London", "Switzerland", "Sydney"
    public static String[] placeNameArray = {"dj", "Businessmen", "cheesetasting", "crowd", "guitarinspirationmusic", "karaokemicrophone", "walkofftheearth"};

    public static ArrayList<Place> placeList() {
        ArrayList<Place> list = new ArrayList<>();
        for (int i = 0; i < placeNameArray.length; i++) {
            Place place = new Place();
            place.name = placeNameArray[i];
            place.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
            if (i == 2 || i == 5) {
                place.isFav = true;
            }
            list.add(place);
        }
        return (list);
    }

}
