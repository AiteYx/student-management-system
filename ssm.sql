/*
 Navicat Premium Data Transfer

 Source Server         : 本机Mysql8.0数据库
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 18/03/2019 23:11:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(10) NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (12345678, '123456');

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply`  (
  `project_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` bigint(10) NOT NULL COMMENT '鐢宠瀛︾敓',
  `class_id` bigint(10) NOT NULL COMMENT '鐢宠鐝骇',
  `file_url` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `result` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` date NOT NULL,
  INDEX `class_id`(`class_id`) USING BTREE,
  INDEX `date`(`date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('国家助学金', 201700001, 12017001, 'file/apply/studentFile/2017000011552575549084.doc', '正在审核', '2019-03-14');
INSERT INTO `apply` VALUES ('国家励志奖学金', 201700001, 12017001, 'file/apply/studentFile/2017000011552575719263.doc', '正在审核', '2019-03-14');

-- ----------------------------
-- Table structure for class_and_grade
-- ----------------------------
DROP TABLE IF EXISTS `class_and_grade`;
CREATE TABLE `class_and_grade`  (
  `id` bigint(10) NOT NULL,
  `teacher_id` bigint(10) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fee` bigint(10) NULL DEFAULT NULL,
  `department_id` bigint(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_and_grade
-- ----------------------------
INSERT INTO `class_and_grade` VALUES (12017001, 100001, '17计算机大类三班', 600, 1);
INSERT INTO `class_and_grade` VALUES (22017002, 200002, '17素描', 1500, 2);

-- ----------------------------
-- Table structure for class_checking_in
-- ----------------------------
DROP TABLE IF EXISTS `class_checking_in`;
CREATE TABLE `class_checking_in`  (
  `student_id` bigint(10) NOT NULL,
  `class_id` bigint(10) NOT NULL,
  `term` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `week_times` bigint(10) NOT NULL COMMENT '鍛ㄦ',
  `week` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鏄熸湡',
  `course_time` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '閻犲洤澧介埢濂稿籍閸洘锛熼柨娑樼暜m1,am2,pm1,pm2',
  `absenteeism` bigint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '旷课',
  `late` bigint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '迟到',
  `ask_for_leave` bigint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '请假',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_checking_in
-- ----------------------------
INSERT INTO `class_checking_in` VALUES (201700001, 12017001, '大一上', 3, '3', 'am2', 0, 1, 0, 1);
INSERT INTO `class_checking_in` VALUES (201700001, 12017001, '大一下', 3, '5', 'am1', 0, 1, 0, 2);
INSERT INTO `class_checking_in` VALUES (201700002, 12017001, '大二上', 3, '1', 'pm1', 0, 0, 1, 3);
INSERT INTO `class_checking_in` VALUES (201700001, 12017001, '大二下', 11, '1', 'am1', 0, 0, 1, 4);
INSERT INTO `class_checking_in` VALUES (201700002, 12017001, '大二下', 14, '1', 'am1', 0, 1, 0, 5);

-- ----------------------------
-- Table structure for class_expenditure
-- ----------------------------
DROP TABLE IF EXISTS `class_expenditure`;
CREATE TABLE `class_expenditure`  (
  `class_id` bigint(10) NOT NULL,
  `updated` date NOT NULL,
  `amount` bigint(10) NOT NULL,
  `location` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reson` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `week_times` bigint(10) NOT NULL,
  INDEX `class_id`(`class_id`) USING BTREE,
  INDEX `updated`(`updated`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_expenditure
-- ----------------------------
INSERT INTO `class_expenditure` VALUES (12017001, '2017-09-08', 20, '学校超市', '购买了班级必需品，粉笔等等', 1);
INSERT INTO `class_expenditure` VALUES (12017001, '2017-09-15', 40, '市区时代广场', '购买元旦彩灯', 2);
INSERT INTO `class_expenditure` VALUES (12017001, '2017-09-22', 50, '蛋糕店', '给辅导员的小礼品', 3);
INSERT INTO `class_expenditure` VALUES (12017001, '2017-09-06', 50, '食堂', '班委吃饭', 1);

-- ----------------------------
-- Table structure for class_message
-- ----------------------------
DROP TABLE IF EXISTS `class_message`;
CREATE TABLE `class_message`  (
  `class_id` bigint(10) NOT NULL,
  `updated` date NULL DEFAULT NULL,
  `content` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `class_id`(`class_id`) USING BTREE,
  INDEX `updated`(`updated`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_message
-- ----------------------------
INSERT INTO `class_message` VALUES (12017001, '2017-09-10', '欢迎各位同学来到大学生活', '');
INSERT INTO `class_message` VALUES (12017001, '2017-09-22', '交班费', '教师A302');
INSERT INTO `class_message` VALUES (12017001, '2016-06-30', '快来上课！', '408');
INSERT INTO `class_message` VALUES (12017001, '1999-05-31', '我喜欢发消息。', '909');
INSERT INTO `class_message` VALUES (12017001, '1998-12-31', '学校成立了。', '607');

-- ----------------------------
-- Table structure for class_schedule
-- ----------------------------
DROP TABLE IF EXISTS `class_schedule`;
CREATE TABLE `class_schedule`  (
  `class_id` bigint(10) NOT NULL,
  `week` bigint(10) NOT NULL,
  `am1` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `am2` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm1` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pm2` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `week_times` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  INDEX `class_id`(`class_id`) USING BTREE,
  INDEX `week`(`week`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_schedule
-- ----------------------------
INSERT INTO `class_schedule` VALUES (12017001, 1, '高数', '', '英语', '体育', '双周');
INSERT INTO `class_schedule` VALUES (12017001, 2, '离散', '', '物理', '', '单周');
INSERT INTO `class_schedule` VALUES (12017001, 3, '高数', '', '', '', '单周');
INSERT INTO `class_schedule` VALUES (12017001, 4, '英语', '', '', '大学语文', '单周');
INSERT INTO `class_schedule` VALUES (12017001, 5, '数字逻辑', '', '', '英语', '单周');
INSERT INTO `class_schedule` VALUES (22017002, 1, '', '高数', '英语', '体育', '单周');
INSERT INTO `class_schedule` VALUES (22017002, 2, '', '离散', '物理', '', '单周');
INSERT INTO `class_schedule` VALUES (22017002, 3, '', '', '高数', '', '单周');
INSERT INTO `class_schedule` VALUES (22017002, 4, '英语', '体育', '', '大学语文', '单周');
INSERT INTO `class_schedule` VALUES (22017002, 5, '数字逻辑', '', '', '英语', '单周');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(10) NOT NULL COMMENT '绯籭d',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '绯诲悕绉?',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '计算机科学与技术学院');
INSERT INTO `department` VALUES (2, '美术学院');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `student_id` bigint(10) NOT NULL,
  `course` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `courseId` bigint(10) NOT NULL COMMENT '璇剧▼id',
  `score` bigint(10) NOT NULL COMMENT '鍒嗘暟',
  `semester` bigint(10) NOT NULL,
  `class_id` bigint(10) NOT NULL,
  `term` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (201700002, '高等数学（一）', 1, 95, 1, 12017001, '大一上');
INSERT INTO `score` VALUES (201700002, '大学物理', 2, 80, 1, 12017001, '大一上');
INSERT INTO `score` VALUES (201700002, '大学英语（一）', 3, 70, 1, 12017001, '大一上');
INSERT INTO `score` VALUES (201700001, '高等数学（一）', 1, 68, 0, 12017001, '大一上');
INSERT INTO `score` VALUES (201700001, '大学物理', 2, 77, 0, 12017001, '大一上');
INSERT INTO `score` VALUES (201700001, '大学英语（一）', 3, 74, 0, 12017001, '大一上');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(10) NOT NULL COMMENT '瀛﹀彿',
  `class_id` bigint(10) NOT NULL COMMENT '鐝骇id',
  `teacher_id` bigint(10) NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '瀵嗙爜',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '濮撳悕',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鎬у埆',
  `major` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '涓撲笟',
  `id_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '韬唤璇?',
  `nation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鍚嶆棌',
  `politics_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鏀挎不闈㈣矊',
  `enrollment` date NOT NULL COMMENT '鍏ュ鏃ユ湡',
  `bank_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '鐪佷唤',
  `home_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '閭',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '鐢佃瘽',
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '鍥剧墖鍦板潃',
  `class_leader` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '鐝骇骞?',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (201700001, 12017001, 100001, '123456', '王一', '男', '计算机科学与技术', '340866199405070039', '汉', '团员', '2017-09-01', '6228213179024673572', '安徽', '安徽省安庆市宜秀区大龙山镇10号楼609', '2495515269@qq.com', '13655974628', 'img/userHeadPortrait/201700001.jpg', '班长');
INSERT INTO `student` VALUES (201700002, 12017001, 100001, '123456', '王二', '女', '计算机科学与技术', '350866199405170099', '汉', '党员', '2017-09-01', '6228213179024673572', '安徽', '安徽省安庆市宜秀区大龙山镇10号楼609', '2495515269@qq.com', '13655974628', 'img/userHeadPortrait/201700002.jpg', '');
INSERT INTO `student` VALUES (201700006, 22017002, 200002, '123456', '王六', '女', '计算机科学与技术', '346966199409060037', '汉', '团员', '2017-09-01', '6228213179024673572', '安徽', '安徽省安庆市宜秀区大龙山镇10号楼609', '2495515269@qq.com', '13655974628', 'img/userHeadPortrait/201700006.jpg', '团支书');
INSERT INTO `student` VALUES (201700007, 22017002, 200002, '123456', '王七', '男', '计算机科学与技术', '442666199408300038', '汉', '群众', '2017-09-01', '6228213179024673572', '安徽', '安徽省安庆市宜秀区大龙山镇10号楼609', '2495515269@qq.com', '13655974628', 'img/userHeadPortrait/201700007.jpg', '');

-- ----------------------------
-- Table structure for student_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `student_evaluation`;
CREATE TABLE `student_evaluation`  (
  `class_id` bigint(10) NOT NULL,
  `student_id` bigint(10) NOT NULL,
  `A1` bigint(10) NULL DEFAULT NULL,
  `A2` bigint(10) NULL DEFAULT NULL,
  `A3` bigint(10) NULL DEFAULT NULL,
  `A4` bigint(10) NULL DEFAULT NULL,
  `A5` bigint(10) NULL DEFAULT NULL,
  `A6` bigint(10) NULL DEFAULT NULL,
  `R1` bigint(10) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_evaluation
-- ----------------------------
INSERT INTO `student_evaluation` VALUES (12017001, 201700002, 24, 24, 24, 24, 36, 36, 150);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(10) NOT NULL COMMENT '鑱屽伐鍙?',
  `department_id` bigint(10) NOT NULL COMMENT '閹碘偓閸︺劎閮?',
  `class_id` bigint(10) NOT NULL COMMENT '閻濐厾楠噄d',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '瀵嗙爜',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '濮撳悕',
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鎬у埆',
  `id_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '韬唤璇?',
  `nation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鍚嶆棌',
  `politics_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鏀挎不闈㈣矊',
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '鐪佷唤',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '閭',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '鐢佃瘽',
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '鍥剧墖鍦板潃',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (100001, 1, 12017001, '123456', '赵倩', '女', '301699752630142268', '汉', '党员', '安徽', '365447815@qq.com', '1687541269', 'img/avatar-6.jpg');
INSERT INTO `teacher` VALUES (200002, 2, 22017001, '123456', '余诗学', '男', '301699752630142268', '汉', '党员', '安徽', '365447815@qq.com', '1687541269', 'img/avatar-7.jpg');

SET FOREIGN_KEY_CHECKS = 1;
