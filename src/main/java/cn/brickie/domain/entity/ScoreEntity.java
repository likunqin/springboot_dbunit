package cn.brickie.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 分数信息
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "score")
public class ScoreEntity {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 学生ID
     */
    @JSONField(serialize = false)
    @Column(name = "student_id")
    private Integer studentId;
    /**
     * 课程ID
     */
    @JSONField(serialize = false)
    @Column(name = "course_id")
    private Integer courseId;
    /**
     * 分数
     */
    @Column(name = "score")
    private Float score;
}
