package com.zarmas.ninjabackend.controller;

import com.zarmas.ninjabackend.entity.Course;
import com.zarmas.ninjabackend.service.CourseService;
import com.zarmas.ninjabackend.service.implementation.CourseServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final String COURSES_VIEW = "courses";

    @Autowired
    @Qualifier("courseServiceImplementation")
    private CourseService courseService;

    @GetMapping("/")
    public ModelAndView listAllCourses() {
        ModelAndView mav = new ModelAndView(COURSES_VIEW);
        mav.addObject("courses", courseService.listAllCourses());
        return mav;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course) {
        courseService.addCourse(course);
        return "redirect:/courses/";
    }
}
