package com.lorin.deadlineschmedline.models;

import android.view.View;
import android.widget.TextView;

import com.lorin.deadlineschmedline.R;

/**
 * Created by Lorin on 5/20/2018.
 */

public class CourseViewHolder {
    public TextView mCourseListItem;

    public CourseViewHolder(View itemView) {
        super(itemView);
        mCourseListItem = (TextView) itemView.findViewById(R.id.tv_course_item);
    }

}
