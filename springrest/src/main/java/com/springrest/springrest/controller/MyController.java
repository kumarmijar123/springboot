package com.springrest.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CoursesService;

@RestController
public class MyController {
    
	@Autowired
	private CoursesService coursesService;
	
	@GetMapping("/home")
	public String home() {
		
		return "Welcome to my courses application";
	}
	
	//get the courses
	
	@GetMapping("/courses")
	public List<Courses> getCourses() { 
		
		return this.coursesService.getCourses();
		
	}
	
	//Single course get
	@GetMapping("/courses/{coursesId}")
	public Courses getCourse(@PathVariable String coursesId)
	{
	   return this.coursesService.getCourse(Long.parseLong(coursesId));	
	}
	
	//course add
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) { 
		
		return this.coursesService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Courses putCourse(@RequestBody Courses course) {
		
		return this.coursesService.updateCourse(course);
	}
	
	//delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.coursesService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
