package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;

@Service
public class CoursesServiceImpl implements CoursesService{
	
	@Autowired
	private CourseDao courseDao;
    
//	List<Courses> list;
	
     public CoursesServiceImpl() {
	               
//    	 list = new ArrayList<>();
//    	 list.add(new Courses(145,"Java Core Course","This course contains basic content of core java"));
//    	 list.add(new Courses(445,"Spring boot","Creating rest Api using spring boot"));
	}
     
	@Override
	public List<Courses> getCourses() {
		
		return courseDao.findAll();
	}
	
	
	@Override
	public Courses getCourse(long coursesId) {
//			Courses c = null;
//			for(Courses courses:list)
//			{
//				if(courses.getId()==coursesId)
//				{
//					c=courses;
//	                break;		
//				}
//			}
		return courseDao.getOne(coursesId);
	}
	
	@Override
	public Courses addCourse(Courses course) {
//		 list.add(course);
		courseDao.save(course);
		return course;
	}
	
	
	@Override
	public Courses updateCourse(Courses course) {
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//			
//		});
		
		courseDao.save(course);
		return course;
	}
	
	
	@Override
	public void deleteCourse(Long parseLong) {
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Courses entity = courseDao.getOne(parseLong);
		courseDao.delete(entity); 
	}

}
