package com.restful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.model.Course;
import com.restful.repo.CourseRepo;

@Service
public class CourseServiceImpl  implements CourseService{

	@Autowired
	private  CourseRepo courseRepo;
	
	
	@Override
	public String upsert(Course course) {
		// TODO Auto-generated method stub
		 courseRepo.save(course); //upsert=if pk available its update or pk is not available its insert
		return "sucess";
	}

	@Override
	public Course getById(Integer id) {
		// TODO Auto-generated method stub
		
		 Optional<Course> findById=courseRepo.findById(id);
		 if(findById.isPresent())
		 {
			 return findById.get();
		 }
		 
		return null;
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		if(courseRepo.existsById(id))
		{
			courseRepo.deleteById(id);
			return "delete success";
		}
		else
		{
			return "no record found";
		}
		
		//return null;
	}

}
