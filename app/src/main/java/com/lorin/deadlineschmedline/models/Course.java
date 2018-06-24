package com.lorin.deadlineschmedline.models;

/**
 * Created by Lorin on 4/23/2018.
 */

import java.io.Serializable;
import java.util.Date;

/**
 * This class contains the data for a Course that will be tracked.
 */
public class Course implements Serializable {
    private String name;
    private Long dateCreated;
    private Long dateWhenCourseEnds;
    private Long startTime;
    private Long endTime;
    private boolean timeStampStarted = false;
    private Double hoursWorked;         //The total hours worked on the course thus far.
    private final static double MILLIS_IN_ONE_HOUR = 3600000.0;

    public Course() {
        this("No Name", new Date().getTime(), new Date().getTime(), 0);
    }

    public Course(String name,
                  Long dateCreated,
                  Long dateWhenCourseEnds,
                  double hoursWorked) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateWhenCourseEnds = dateWhenCourseEnds;
        this.hoursWorked = hoursWorked;
    }

    /**
     * Updates the total hours worked
     *TODO add the functionality to add timestamps
     */
    public void updateHourWorked() {
        hoursWorked = hoursWorked + ((endTime - startTime) / MILLIS_IN_ONE_HOUR);
        //add timestamp functionality
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long timeOfStart) {
        startTime = timeOfStart;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long timeOfFinish) {
        endTime = timeOfFinish;
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
    public Long getDateCreated() {
        return dateCreated;
    }

    /**
     * Gets the date when the course ends
     * @return date the course ends
     */
    public Long getDateWhenCourseEnds() {
        return dateWhenCourseEnds;
    }

    /**
     * Sets a new end date for the course
     * @param newEndDate the new date to set to
     */
    public void setDateWhenCourseEnds(Long newEndDate) {
        dateWhenCourseEnds = newEndDate;
    }

    /**
     * Gets the number of hours worked on the course
     * @return returns the hours worked on the course
     */
    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Long hoursToAdd) {
        hoursWorked = hoursWorked + hoursToAdd;
    }

    public boolean getTimeStampStarted() {
        return timeStampStarted;
    }

    public void setTimeStampStarted(Boolean timeStampStarted) {
        this.timeStampStarted = timeStampStarted;
    }
}
