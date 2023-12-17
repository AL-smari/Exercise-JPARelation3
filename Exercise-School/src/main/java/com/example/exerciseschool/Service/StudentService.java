package com.example.exerciseschool.Service;

import com.example.exerciseschool.Api.ApiException;
import com.example.exerciseschool.Model.Course;
import com.example.exerciseschool.Model.Student;
import com.example.exerciseschool.Repository.CourseRepository;
import com.example.exerciseschool.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id , Student student){
        Student student1 = studentRepository.findStudentById(id);
        if(student1==null){
            throw new ApiException("student id not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
        studentRepository.save(student1);
    }


    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("student id not found");
        }
        studentRepository.delete(student);
    }


    public void assignStudentToCourse(Integer student_id,Integer course_id){
        Student student = studentRepository.findStudentById(student_id);
        Course course =courseRepository.findCourseById(course_id);

        if(student==null){
            throw new ApiException("student id not found");
        }
        if(course==null){
            throw new ApiException("course id not found");
        }

        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }


    public void changeMajor(Integer id , String major){
        Student student = studentRepository.findStudentById(id);

        if(student==null){
            throw new ApiException("student id not found");
        }

        for (Course course: student.getCourses()){
            course.getStudents().remove(student);
            courseRepository.save(course);
        }

        student.setMajor(major);
        student.setCourses(null);
        studentRepository.save(student);
    }
}
