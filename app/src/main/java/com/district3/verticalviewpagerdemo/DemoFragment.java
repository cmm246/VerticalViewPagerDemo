package com.district3.verticalviewpagerdemo;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chung on 4/16/16.
 */
public class DemoFragment extends Fragment {

    private ImageView mImageView;
    private TextView mPageNumber;
    private TextView mDescription;
    private Place mPlace;
    private Context thiscontext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource that'll be returned
        View rootView = inflater.inflate(R.layout.fragment_demo, container, false);

        // Get the arguments that was supplied when the fragment was instantiated in the CustomPagerAdapter
        Bundle args = getArguments();

        //((TextView) rootView.findViewById(R.id.text)).setText("Page " + args.getInt("page_position"));
        thiscontext = container.getContext();
        mImageView = (ImageView) rootView.findViewById(R.id.placeImage);
        mPlace = PlaceData.placeList().get(args.getInt("page_position"));
        mImageView.setImageResource(mPlace.getImageResourceId(thiscontext));
        Bitmap photo = BitmapFactory.decodeResource(getResources(), mPlace.getImageResourceId(thiscontext));
        mImageView.setImageBitmap(photo);

        mPageNumber = (TextView) rootView.findViewById(R.id.myPageNumber);
        mPageNumber.setText("" + (args.getInt("page_position")+1));

        mDescription = (TextView) rootView.findViewById(R.id.myDescription);
        mDescription.setText("Huge underground party at the Metropolis. Are you ready?");

        return rootView;
    }

}
