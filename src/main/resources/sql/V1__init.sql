CREATE TABLE `course`
(
    `id`   int(10) unsigned                       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `student`
(
    `id`   int(10) unsigned                       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `sno`   varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
    `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
    `age`  tinyint(1)                             NOT NULL COMMENT '年龄',
    `sex`  tinyint(1)                             NOT NULL COMMENT '性别(0:女,1:男)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

CREATE TABLE `score`
(
    `id`         int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `student_id` int(11)          NOT NULL COMMENT '学生ID',
    `course_id`  int(11)          NOT NULL COMMENT '课程ID',
    `score`      smallint(6)      NOT NULL COMMENT '分数',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;