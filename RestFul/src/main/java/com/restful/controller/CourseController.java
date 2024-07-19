package com.restful.controller;

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

import com.restful.model.Course;
import com.restful.service.CourseService;

@RestController

public class CourseController {
	@Autowired
	private CourseService courseService;
	
	//insert data into database
	@PostMapping("/course")
	public ResponseEntity<String> createCourse( @RequestBody Course course )
	{
		String status =courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
		
	}
	
	//getting course by id
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer id)
	{
		Course course =courseService.getById(id);
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
	
	
	//get all course from database
	@GetMapping("/course")
	public ResponseEntity <List<Course>> getAllCourse()
	{
		List<Course> allCourses=courseService.getAllCourse();
		return new ResponseEntity<>(allCourses,HttpStatus.OK);
	}
	//update the existing records
	@PutMapping("course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course)
	{
		String status=courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	//delete course from database
	@DeleteMapping("/course/{id}")
	
	public ResponseEntity<String> deleteCourse(@PathVariable Integer id)
	{
	String course =courseService.deleteById(id);
	return new ResponseEntity<>(course,HttpStatus.OK);
	}
	

}
