package com.example.exerciseschool.Controller;

import com.example.exerciseschool.Model.Student;
import com.example.exerciseschool.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("student added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id , @Valid@RequestBody Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(HttpStatus.OK).body("student updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("student deleted");
    }
    @PutMapping("/{student_id}/assign/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(HttpStatus.OK).body("assigned");
    }
    @PutMapping("/changeMajor/{id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id,@PathVariable String major){
        studentService.changeMajor(id, major);
        return ResponseEntity.status(HttpStatus.OK).body("major changed");
    }
}
