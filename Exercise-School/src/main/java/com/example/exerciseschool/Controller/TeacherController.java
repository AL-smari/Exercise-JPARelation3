package com.example.exerciseschool.Controller;

import com.example.exerciseschool.Model.Teacher;
import com.example.exerciseschool.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("teacher added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id ,@Valid@RequestBody Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher delete");

    }
    @GetMapping("/getDetails/{id}")
    public ResponseEntity allTeacherDetails(@PathVariable Integer id){
      return ResponseEntity.status(HttpStatus.OK).body(teacherService.allTeacherDetails(id));
    }

    @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        teacherService.assignTeacherToCourse(teacher_id, course_id);
        return ResponseEntity.status(HttpStatus.OK).body("teacher assign to course");
    }
}
