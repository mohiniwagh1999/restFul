package com.restful.service;

import java.util.List;

import com.restful.model.Course;

public interface CourseService {
	
	public String upsert(Course course);
	public Course getById(Integer id);
	public List<Course> getAllCourse();
	public String deleteById(Integer id);

}
