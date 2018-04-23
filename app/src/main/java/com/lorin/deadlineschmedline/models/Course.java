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
    private double hoursWorked;         //The total hours worked on the course thus far.

    public Course() {
        this("No Name", new Date(), new Date(), 0);
    }

    public Course(String name,
                  Date dateCreated,
                  Date dateWhenCourseEnds,
                  double hoursWorked) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateWhenCourseEnds = dateWhenCourseEnds;
        this.hoursWorked = hoursWorked;
    }

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

    /**
     * Gets the number of hours worked on the course
     * @return returns the hours worked on the course
     */
    public double getHoursWorked() {
        return hoursWorked;
    }
}
