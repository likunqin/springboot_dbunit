package cn.brickie.service;

import cn.brickie.Service.CourseService;
import cn.brickie.domain.entity.CourseEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CourseServiceTest {

    private CourseService courseService;

    @Before
    public void setUp() {
        courseService = mock(CourseService.class);
    }

    @Test
    public void findById() {
        Integer courseId = 1;

        when(courseService.findById(courseId))
                .thenReturn(CourseEntity.builder().id(1).name("语文").build());

        assertEquals("语文", courseService.findById(courseId).getName());
    }
}
