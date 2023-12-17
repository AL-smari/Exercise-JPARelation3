package com.example.exerciseschool.Service;

import com.example.exerciseschool.Api.ApiException;
import com.example.exerciseschool.Model.Address;
import com.example.exerciseschool.Model.Course;
import com.example.exerciseschool.Model.Teacher;
import com.example.exerciseschool.Repository.CourseRepository;
import com.example.exerciseschool.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;


    public List<Teacher> getTeachers(){

        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }


    public void updateTeacher(Integer id , Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiException("Teacher id not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }


    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher id not found");
        }
        teacherRepository.delete(teacher);
    }

    public Address allTeacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher id not found");
        }
        if(teacher.getAddress()==null){
            throw new ApiException("address not found");
        }

        return teacher.getAddress();
    }

    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){

        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);
        if(teacher==null){
            throw new ApiException("teacher id not found");
        }
        if(course==null){
            throw new ApiException("course id not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);

    }
}
