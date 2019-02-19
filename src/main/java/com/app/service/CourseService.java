package com.app.service;

import com.app.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Page<Course> findAllCoursePage(Pageable pageable);
}
