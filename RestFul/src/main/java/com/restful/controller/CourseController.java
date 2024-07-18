package com.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.restful.service.CourseService;

@RestController

public class CourseController {
	@Autowired
	private CourseService courseService;
	
	

}
