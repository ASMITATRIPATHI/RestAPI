package com.example.courseapidata.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public  List<Course> getAllCourses(String topicId){
        //return topics;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }
    
    public Course getCourse(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).orElse(null);
    }
    
    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
