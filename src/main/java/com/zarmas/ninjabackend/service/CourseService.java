package com.zarmas.ninjabackend.service;

import com.zarmas.ninjabackend.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> listAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Course course);
    boolean removeCourse(Course course);
}
