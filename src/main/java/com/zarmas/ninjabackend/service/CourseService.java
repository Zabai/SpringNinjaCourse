package com.zarmas.ninjabackend.service;

import com.zarmas.ninjabackend.entity.Course;
import com.zarmas.ninjabackend.model.CourseModel;

import java.util.List;

public interface CourseService {
    List<Course> listAllCourses();
    Course addCourse(CourseModel course);
    Course updateCourse(CourseModel course);
    boolean removeCourse(CourseModel course);
}
