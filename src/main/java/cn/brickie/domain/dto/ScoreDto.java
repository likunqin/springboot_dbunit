package cn.brickie.domain.dto;

import cn.brickie.domain.entity.CourseEntity;
import cn.brickie.domain.entity.ScoreEntity;
import cn.brickie.domain.entity.StudentEntity;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Access;

/**
 * 分数信息封装
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ScoreDto extends ScoreEntity {
    /**
     * 学生信息
     */
    @JSONField(name = "student")
    private StudentEntity studentEntity;
    /**
     * 课程信息
     */
    @JSONField(name = "course")
    private CourseEntity courseEntity;
}
