package com.lorin.deadlineschmedline.models;

import java.util.Date;

/**
 * This class represents a Timecard, an object that contains the start
 * time, end time, and total hours worked for a work session on a particular course.
 */
public class Timecard {

    private Course course;
    private Long startTime;
    private Long endTime;
    private Long hoursWorked;

    public Timecard(Course course, Long startTime, Long endTime) {
        this.course = course;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // TODO consider replacing with a default date some time in the future
    public Timecard() {
        this(new Course(), (new Date()).getTime(), (new Date()).getTime());
    }

    public Long calculateHoursWorked() {
        return (endTime - startTime);
    }

    public Course getCourse() {
        return course;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Long getHoursWorked() {
        return hoursWorked;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setHoursWorked(Long hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
