package cn.brickie.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 学生信息
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 学号
     */
    @Column(name = "sno")
    private String sno;
    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;
    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;
    /**
     * 性别(0:女,1:男)
     */
    @Column(name = "sex")
    private Integer sex;
}
