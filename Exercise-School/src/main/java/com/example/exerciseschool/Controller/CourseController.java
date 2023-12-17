package com.example.exerciseschool.Controller;

import com.example.exerciseschool.Model.Course;
import com.example.exerciseschool.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourse());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid@RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("course added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id ,@Valid@RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(HttpStatus.OK).body("course updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("course deleted");
    }

    @GetMapping("/getTeacherByCourse/{id}")
    public ResponseEntity getTeacherByCourse(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getTeacherByCourse(id));
    }
    @GetMapping("/getStudentsByCourse/{id}")
    public ResponseEntity getAllStudentByCourse(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllStudentByCourse(id));
    }
}
