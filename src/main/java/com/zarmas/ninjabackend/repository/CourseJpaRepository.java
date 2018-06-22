package com.zarmas.ninjabackend.repository;

import com.zarmas.ninjabackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {
    Course findByPrice(int price);
    Course findByPriceAndName(int price, String name);
    Course findByNameOrPrice(String name, int price);
    List<Course> findByNameOrderByHours(String name);
}
