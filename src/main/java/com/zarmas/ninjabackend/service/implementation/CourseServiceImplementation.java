package com.zarmas.ninjabackend.service.implementation;

import com.zarmas.ninjabackend.converter.CourseConverter;
import com.zarmas.ninjabackend.entity.Course;
import com.zarmas.ninjabackend.model.CourseModel;
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

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter converter;

    @Override
    public List<Course> listAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course addCourse(CourseModel course) {
        return repository.save(converter.modelToEntity(course));
    }

    @Override
    public Course updateCourse(CourseModel course) {
        return repository.save(converter.modelToEntity(course));
    }

    @Override
    public boolean removeCourse(CourseModel course) {
        repository.delete(converter.modelToEntity(course));
        return true;
    }
}
