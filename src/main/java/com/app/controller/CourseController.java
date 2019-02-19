package com.app.controller;


import com.app.model.Course;
import com.app.model.Pager;
import com.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CourseController {


    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 3;
    private static final int[] PAGE_SIZES = {3, 5, 10, 20};

    @Autowired
    CourseService service;

    @GetMapping("/")
    public ModelAndView showCourseListPage(@RequestParam("pageSize")Optional<Integer> pageSize,
                                           @RequestParam("PageSerial") Optional<Integer> PageSerial){

        ModelAndView model = new ModelAndView("courseList");

        int entityRecordPerPage = pageSize.orElse(INITIAL_PAGE_SIZE);
        int pageSL = (PageSerial.orElse(0)<1)?INITIAL_PAGE:PageSerial.get()-1;


        Page<Course> courses = service.findAllCoursePage(PageRequest.of(pageSL,entityRecordPerPage));
        Pager pager = new Pager(courses.getTotalPages(), courses.getNumber(),BUTTONS_TO_SHOW);

        model.addObject("courses", courses);
        model.addObject("pageSizeList",PAGE_SIZES);
        model.addObject("recordPerPage", entityRecordPerPage);
        model.addObject("pager",pager);

        return model;
    }



      }
