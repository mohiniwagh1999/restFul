package com.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.model.Course;

public interface CourseRepo extends JpaRepository<Course , Integer> {

}
