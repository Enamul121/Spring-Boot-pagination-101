package com.app.service;


import com.app.model.Course;
import com.app.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {


    @Autowired
    CourseRepo courseRepo;


    @Override
    public Page<Course> findAllCoursePage(Pageable pageable) {
        return courseRepo.findAll(pageable);
    }
}
