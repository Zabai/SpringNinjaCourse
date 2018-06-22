package com.zarmas.ninjabackend.service.implementation;

import com.zarmas.ninjabackend.entity.Course;
import com.zarmas.ninjabackend.repository.CourseJpaRepository;
import com.zarmas.ninjabackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServiceImplementation")
public class CourseServiceImplementation implements CourseService {
    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository repository;

    @Override
    public List<Course> listAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public boolean removeCourse(Course course) {
        repository.delete(course);
        return true;
    }
}
