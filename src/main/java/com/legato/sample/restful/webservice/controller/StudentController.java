package com.legato.sample.restful.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legato.sample.restful.webservice.model.Course;
import com.legato.sample.restful.webservice.model.Student;
import com.legato.sample.restful.webservice.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/students")
	public List<Student> retrieveStudents() {
		return studentService.retrieveStudent();
	}
	
	@GetMapping("/students/{studentId}/")
	public Student retrieveStudent(@PathVariable String studentId) {
		return studentService.retrieveStudent(studentId);
	}
	
	@GetMapping("/students/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
		return studentService.retrieveCourses(studentId);
	}
}