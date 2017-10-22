package com.mydroid.ui.masterlist

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.mydroid.di.scopes.ActivityScope
import javax.inject.Inject


/**
 * @author lusinabrian on 22/10/17.
 * @Notes Displays a list of Droid images in a Grid view
 */

class MasterListAdapter
@Inject
constructor(@ActivityScope val context : Context, var imageIdArrayList: ArrayList<Int>): BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            // If the view is not recycled, this creates a new ImageView to hold an image
            imageView = ImageView(context)
            // Define the layout parameters
            imageView.adjustViewBounds = true
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }

        // Set the image resource and return the newly created ImageView
        imageView.setImageResource(imageIdArrayList.get(position))
        return imageView
    }

    override fun getItem(position: Int): Any {
        return Any()
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount() = imageIdArrayList.size

}