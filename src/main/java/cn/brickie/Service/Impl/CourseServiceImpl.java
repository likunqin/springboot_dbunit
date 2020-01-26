package cn.brickie.Service.Impl;

import cn.brickie.Service.CourseService;
import cn.brickie.domain.entity.CourseEntity;
import cn.brickie.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseEntity findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }
}
