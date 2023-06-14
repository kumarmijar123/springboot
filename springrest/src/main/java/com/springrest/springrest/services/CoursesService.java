package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Courses;

public interface CoursesService {
        
	public List<Courses> getCourses();
	
	public Courses getCourse(long coursesId);
	
	public Courses addCourse(Courses course);
	
	public Courses updateCourse(Courses course);	
	
	public void deleteCourse(Long parseLong);
}
