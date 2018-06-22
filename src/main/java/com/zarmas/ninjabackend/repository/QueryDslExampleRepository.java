package com.zarmas.ninjabackend.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.zarmas.ninjabackend.entity.Course;
import com.zarmas.ninjabackend.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("queryDslExampleRepository")
public class QueryDslExampleRepository {
     private QCourse qCourse = QCourse.course;

     @PersistenceContext
     private EntityManager em;

     public void findById(int id) {
         JPAQuery<Course> query = new JPAQuery<>(em);
         Course course = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(id)).fetchOne();
     }

     public void findByHourInterval(int from, int to) {
         JPAQuery<Course> query = new JPAQuery<>(em);
         List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(from, to)).fetch();
     }
}
