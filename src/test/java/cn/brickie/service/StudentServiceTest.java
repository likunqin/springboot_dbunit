package cn.brickie.service;

import cn.brickie.Service.StudentService;
import cn.brickie.domain.entity.StudentEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    private StudentService studentService;

    @Before
    public void setUp() {
        studentService = mock(StudentService.class);
    }

    @Test
    public void findById() {
        Integer studentId = 1;

        when(studentService.findById(studentId))
                .thenReturn(StudentEntity.builder().id(studentId).name("小明").age(28).sno("s1").sex(1).build());

        assertEquals("小明", studentService.findById(studentId).getName());
    }
}
