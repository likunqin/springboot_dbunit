package cn.brickie.Service.Impl;

import cn.brickie.Service.StudentService;
import cn.brickie.domain.entity.StudentEntity;
import cn.brickie.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
}
