package cn.brickie.Service.Impl;

import cn.brickie.Service.CourseService;
import cn.brickie.Service.ScoreService;
import cn.brickie.Service.StudentService;
import cn.brickie.domain.dto.ScoreDto;
import cn.brickie.domain.entity.CourseEntity;
import cn.brickie.domain.entity.ScoreEntity;
import cn.brickie.domain.entity.StudentEntity;
import cn.brickie.repository.ScoreRepository;
import cn.brickie.utils.MapperUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Exception.class)
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public ScoreServiceImpl(ScoreRepository scoreRepository, CourseService courseService, StudentService studentService) {
        this.scoreRepository = scoreRepository;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    public List<ScoreDto> all() {
        return scoreRepository.findAll().stream().map(scoreEntity -> {
            StudentEntity studentEntity = studentService.findById(scoreEntity.getStudentId());
            CourseEntity courseEntity = courseService.findById(scoreEntity.getCourseId());
            ScoreDto scoreDto = MapperUtil.map(scoreEntity, ScoreDto.class);
            scoreDto.setCourseEntity(courseEntity);
            scoreDto.setStudentEntity(studentEntity);
            return scoreDto;
        }).collect(Collectors.toList());
    }
}
