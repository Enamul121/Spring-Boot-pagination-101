package com.app.repo;

import com.app.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends PagingAndSortingRepository<Course, Long> {
}
