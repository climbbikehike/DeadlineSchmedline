package com.lorin.deadlineschmedline.models;

import java.util.Date;

/**
 * Created by Lorin on 4/23/2018.
 */

/**
 * This class holds the data for a component of a Course. For example, a Project or Assignment
 */
public class CourseComponent {
    private Course parentCourse;
    private String name;
    private String componentType;
    private Date dateCreated;
    private Date dateWhenCourseEnds;
    private double hoursWorked;         //The total hours worked on the course thus far.

    public CourseComponent() {
        this("No Name", "Assignment", new Date(), new Date());
    }

    public CourseComponent(String name,
                           String componentType,
                           Date dateCreated,
                           Date dateWhenCourseEnds) {
        this.name = name;
        this.componentType = componentType;
        this.dateCreated = dateCreated;
        this.dateWhenCourseEnds = dateWhenCourseEnds;
        this.hoursWorked = 0;
    }

    public Course getParentCourse() {
        return parentCourse;
    }

    public void setParentCourse(Course newParentCourse) {
        this.parentCourse = newParentCourse;
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

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
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
        this.dateWhenCourseEnds = newEndDate;
    }

    /**
     * Gets the number of hours worked on the course
     * @return returns the hours worked on the course
     */
    public double getHoursWorked() {
        return hoursWorked;
    }
}
