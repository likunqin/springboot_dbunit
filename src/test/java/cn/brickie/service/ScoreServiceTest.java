package cn.brickie.service;

import cn.brickie.Service.ScoreService;
import cn.brickie.domain.dto.ScoreDto;
import cn.brickie.domain.entity.CourseEntity;
import cn.brickie.domain.entity.StudentEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoreServiceTest {

    private ScoreService scoreService;

    @Before
    public void setUp() {
        scoreService = mock(ScoreService.class);
    }

    @Test
    public void findById() {
        ScoreDto scoreDto = new ScoreDto();
        scoreDto.setId(1);
        scoreDto.setScore(99.5F);
        scoreDto.setCourseId(1);
        scoreDto.setStudentId(1);
        scoreDto.setStudentEntity(StudentEntity.builder().id(1).name("小明").age(28).sno("s1").sex(1).build());
        scoreDto.setCourseEntity(CourseEntity.builder().id(1).name("语文").build());

        when(scoreService.all())
                .thenReturn(new ArrayList<ScoreDto>() {{
                    add(scoreDto);
                }});

        assertEquals("小明", scoreService.all().get(0).getStudentEntity().getName());
    }
}
