package com.example.exerciseschool.Service;

import com.example.exerciseschool.Api.ApiException;
import com.example.exerciseschool.Model.Course;
import com.example.exerciseschool.Model.Student;
import com.example.exerciseschool.Model.Teacher;
import com.example.exerciseschool.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;


    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id , Course course){
        Course course1 = courseRepository.findCourseById(id);
        if(course1==null){
            throw new ApiException("course id not found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);
    }


    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("course id not found");
        }
        courseRepository.delete(course);
    }


    public String getTeacherByCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("course id not found");
        }
        return course.getTeacher().getName();
    }


    public Set<Student> getAllStudentByCourse(Integer id){

        Course course = courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("course id not found");
        }

        return course.getStudents();

    }
}
