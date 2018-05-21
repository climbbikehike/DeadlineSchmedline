package com.lorin.deadlineschmedline.adapters;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.lorin.deadlineschmedline.R;
import com.lorin.deadlineschmedline.models.Course;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * RecyclerView adapter for a list of Courses.
 */
public class CourseAdapter extends FirestoreAdapter<CourseAdapter.ViewHolder> {

    public interface OnCourseSelectedListener {

        void onCourseSelected(DocumentSnapshot course);

    }

    private OnCourseSelectedListener mListener;

    public CourseAdapter(Query query, OnCourseSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.course_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_course_item)
        TextView courseNameView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot,
                         final OnCourseSelectedListener listener) {

          //  Restaurant restaurant = snapshot.toObject(Restaurant.class);
            Course course = snapshot.toObject(Course.class);
            Resources resources = itemView.getResources();

            // Load image
            //This is a remnant of the original android sample code. Use to add images later?
            /*Glide.with(imageView.getContext())
                    .load(restaurant.getPhoto())
                    .into(imageView);*/

            courseNameView.setText(course.getName());

            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onCourseSelected(snapshot);
                    }
                }
            });
        }

    }
}
