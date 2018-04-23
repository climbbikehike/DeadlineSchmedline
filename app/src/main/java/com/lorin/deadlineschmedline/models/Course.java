package com.lorin.deadlineschmedline.models;

/**
 * Created by Lorin on 4/23/2018.
 */

import java.util.Date;

/**
 * This class contains the data for a Course that will be tracked.
 */
public class Course {
    private String name;
    private Date dateCreated;
    private Date dateWhenCourseEnds;

    /**
     * Gets the name of the course
     * @return the name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course
     * @param newName the new name for the course
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Gets the date the course was created
     * @return the date created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Gets the date when the course ends
     * @return date the course ends
     */
    public Date getDateWhenCourseEnds() {
        return dateWhenCourseEnds;
    }

    /**
     * Sets a new end date for the course
     * @param newEndDate the new date to set to
     */
    public void setDateWhenCourseEnds(Date newEndDate) {
        dateWhenCourseEnds = newEndDate;
    }
}
