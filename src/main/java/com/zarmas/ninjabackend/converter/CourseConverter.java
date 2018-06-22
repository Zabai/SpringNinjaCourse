package com.zarmas.ninjabackend.converter;

import com.zarmas.ninjabackend.entity.Course;
import com.zarmas.ninjabackend.model.CourseModel;
import org.springframework.stereotype.Component;

@Component("courseConverter")
public class CourseConverter {
    public CourseModel entityToModel(Course entity) {
        CourseModel model = new CourseModel();

        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setPrice(entity.getPrice());
        model.setHours(entity.getHours());

        return model;
    }

    public Course modelToEntity(CourseModel model) {
        Course entity = new Course();

        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
        entity.setHours(model.getHours());

        return entity;
    }
}
