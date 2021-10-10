/*
 Navicat Premium Data Transfer

 Source Server         : MySQL01
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : imooc_oa

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 10/10/2021 10:28:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adm_department
-- ----------------------------
DROP TABLE IF EXISTS `adm_department`;
CREATE TABLE `adm_department`  (
  `department_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adm_department
-- ----------------------------
INSERT INTO `adm_department` VALUES (1, '总裁办');
INSERT INTO `adm_department` VALUES (2, '研发部');
INSERT INTO `adm_department` VALUES (3, '市场部');

-- ----------------------------
-- Table structure for adm_employee
-- ----------------------------
DROP TABLE IF EXISTS `adm_employee`;
CREATE TABLE `adm_employee`  (
  `employee_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `department_id` bigint(0) NOT NULL,
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `level` int(0) NOT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adm_employee
-- ----------------------------
INSERT INTO `adm_employee` VALUES (1, '张晓涛', 1, '总经理', 8);
INSERT INTO `adm_employee` VALUES (2, '齐紫陌', 2, '部门经理', 7);
INSERT INTO `adm_employee` VALUES (3, '王美美', 2, '高级研发工程师', 6);
INSERT INTO `adm_employee` VALUES (4, '宋彩妮', 2, '研发工程师', 5);
INSERT INTO `adm_employee` VALUES (5, '欧阳峰', 2, '初级研发工程师', 4);
INSERT INTO `adm_employee` VALUES (6, '张世豪', 3, '部门经理', 7);
INSERT INTO `adm_employee` VALUES (7, '王子豪', 3, '大客户经理', 6);
INSERT INTO `adm_employee` VALUES (8, '段峰', 3, '客户经理', 5);
INSERT INTO `adm_employee` VALUES (9, '章雪峰', 3, '客户经理', 4);
INSERT INTO `adm_employee` VALUES (10, '李莉', 3, '见习客户经理', 3);

-- ----------------------------
-- Table structure for adm_leave_form
-- ----------------------------
DROP TABLE IF EXISTS `adm_leave_form`;
CREATE TABLE `adm_leave_form`  (
  `form_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '请假单编号',
  `employee_id` bigint(0) NOT NULL COMMENT '员工编号',
  `form_type` int(0) NOT NULL COMMENT '请假类型 1-事假 2-病假 3-工伤假 4-婚假 5-产假 6-丧假',
  `start_time` datetime(0) NOT NULL COMMENT '请假起始时间',
  `end_time` datetime(0) NOT NULL COMMENT '请假结束时间',
  `reason` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请假事由',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `state` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'processing-正在审批 approved-审批已通过 refused-审批被驳回',
  PRIMARY KEY (`form_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adm_leave_form
-- ----------------------------
INSERT INTO `adm_leave_form` VALUES (109, 3, 1, '2020-03-26 00:00:00', '2020-04-01 10:00:00', '研发部员工王美美请假单(72小时以上)', '2021-10-09 10:13:40', 'processing');
INSERT INTO `adm_leave_form` VALUES (110, 3, 1, '2020-03-26 00:00:00', '2020-04-01 10:00:00', '研发部员工王美美请假单(72小时以上)', '2021-10-09 12:41:57', 'processing');
INSERT INTO `adm_leave_form` VALUES (111, 3, 1, '2020-03-26 00:00:00', '2020-04-01 10:00:00', '研发部员工王美美请假单(72小时以上)', '2021-10-09 12:57:31', 'processing');
INSERT INTO `adm_leave_form` VALUES (112, 3, 1, '2020-03-26 00:00:00', '2020-03-27 10:00:00', '研发部员工王美美请假单(72小时以内)', '2021-10-09 12:59:50', 'approved');
INSERT INTO `adm_leave_form` VALUES (113, 3, 1, '2020-03-26 00:00:00', '2020-04-01 10:00:00', '研发部员工王美美请假单(72小时以上)', '2021-10-09 12:59:59', 'refused');
INSERT INTO `adm_leave_form` VALUES (114, 3, 1, '2020-03-26 00:00:00', '2020-04-01 10:00:00', '研发部员工王美美请假单(72小时以上)', '2021-10-09 13:00:05', 'approved');
INSERT INTO `adm_leave_form` VALUES (115, 3, 1, '2020-03-26 00:00:00', '2020-04-01 10:00:00', '研发部员工王美美请假单(72小时以上)', '2021-10-09 13:20:53', 'approved');
INSERT INTO `adm_leave_form` VALUES (116, 3, 2, '2021-09-30 16:00:00', '2021-10-02 16:00:00', '生病', '2021-10-02 16:00:00', 'approved');
INSERT INTO `adm_leave_form` VALUES (117, 3, 3, '2021-09-30 16:00:00', '2021-10-02 16:00:00', '摔伤', '2021-10-02 16:00:00', 'approved');
INSERT INTO `adm_leave_form` VALUES (126, 3, 1, '2020-03-26 00:00:00', '2020-04-01 10:00:00', '研发部员工王美美请假单(72小时以上)', '2021-10-10 02:08:02', 'approved');
INSERT INTO `adm_leave_form` VALUES (127, 3, 1, '2020-03-26 00:00:00', '2020-04-01 10:00:00', '研发部员工王美美请假单(72小时以上)', '2021-10-10 02:08:20', 'refused');
INSERT INTO `adm_leave_form` VALUES (128, 3, 1, '2020-03-26 00:00:00', '2020-03-27 10:00:00', '研发部员工王美美请假单(72小时以内)', '2021-10-10 02:08:26', 'approved');
INSERT INTO `adm_leave_form` VALUES (129, 3, 1, '2021-09-30 16:00:00', '2021-10-02 16:00:00', '奔丧', '2021-10-02 16:00:00', 'approved');

-- ----------------------------
-- Table structure for adm_process_flow
-- ----------------------------
DROP TABLE IF EXISTS `adm_process_flow`;
CREATE TABLE `adm_process_flow`  (
  `process_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '处理任务编号',
  `form_id` bigint(0) NOT NULL COMMENT '表单编号',
  `operator_id` bigint(0) NOT NULL COMMENT '经办人编号',
  `action` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'apply-申请  audit-审批',
  `result` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'approved-同意 refused-驳回',
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审批意见',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `audit_time` datetime(0) NULL DEFAULT NULL COMMENT '审批时间',
  `order_no` int(0) NOT NULL COMMENT '任务序号',
  `state` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'ready-准备 process-正在处理 complete-处理完成 cancel-取消',
  `is_last` int(0) NOT NULL COMMENT '是否最后节点,0-否 1-是',
  PRIMARY KEY (`process_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 228 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adm_process_flow
-- ----------------------------
INSERT INTO `adm_process_flow` VALUES (228, 109, 3, 'apply', NULL, NULL, '2021-10-09 10:13:41', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (229, 109, 2, 'audit', NULL, NULL, '2021-10-09 10:13:41', NULL, 2, 'process', 1);
INSERT INTO `adm_process_flow` VALUES (230, 110, 3, 'apply', NULL, NULL, '2021-10-09 12:41:58', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (231, 110, 2, 'audit', NULL, NULL, '2021-10-09 12:41:58', NULL, 2, 'process', 1);
INSERT INTO `adm_process_flow` VALUES (232, 111, 3, 'apply', NULL, NULL, '2021-10-09 12:57:32', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (233, 111, 2, 'audit', NULL, NULL, '2021-10-09 12:57:32', NULL, 2, 'process', 1);
INSERT INTO `adm_process_flow` VALUES (234, 112, 3, 'apply', NULL, NULL, '2021-10-09 12:59:51', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (235, 112, 2, 'audit', 'approved', '部门经理同意', '2021-10-09 12:59:51', '2021-10-09 12:59:51', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (236, 113, 3, 'apply', NULL, NULL, '2021-10-09 13:00:00', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (237, 113, 2, 'audit', 'refused', '部门经理拒绝', '2021-10-09 13:00:00', '2021-10-09 13:00:00', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (238, 114, 3, 'apply', NULL, NULL, '2021-10-09 13:00:06', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (239, 114, 2, 'audit', 'approved', '部门经理同意', '2021-10-09 13:00:06', '2021-10-09 13:00:06', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (240, 115, 3, 'apply', NULL, NULL, '2021-10-09 13:20:54', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (241, 115, 2, 'audit', 'approved', '部门经理同意', '2021-10-09 13:20:54', '2021-10-09 13:20:54', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (242, 116, 3, 'apply', NULL, NULL, '2021-10-09 13:26:00', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (243, 116, 2, 'audit', 'approved', '注意身体', '2021-10-09 13:26:00', '2021-10-09 13:27:27', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (244, 117, 3, 'apply', NULL, NULL, '2021-10-09 13:51:56', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (245, 117, 2, 'audit', 'approved', '好好休息', '2021-10-09 13:51:56', '2021-10-09 13:52:18', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (248, 119, 3, 'apply', NULL, NULL, '2021-10-10 02:06:25', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (249, 119, 2, 'audit', 'approved', '部门经理同意', '2021-10-10 02:06:25', '2021-10-10 02:06:25', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (250, 120, 3, 'apply', NULL, NULL, '2021-10-10 02:06:25', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (251, 120, 2, 'audit', 'refused', '部门经理拒绝', '2021-10-10 02:06:25', '2021-10-10 02:06:25', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (252, 121, 3, 'apply', NULL, NULL, '2021-10-10 02:06:25', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (253, 121, 2, 'audit', 'approved', '部门经理同意', '2021-10-10 02:06:25', '2021-10-10 02:06:25', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (254, 122, 8, 'apply', NULL, NULL, '2021-10-10 02:06:25', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (255, 122, 6, 'audit', NULL, NULL, '2021-10-10 02:06:25', NULL, 2, 'process', 1);
INSERT INTO `adm_process_flow` VALUES (256, 123, 8, 'apply', NULL, NULL, '2021-10-10 02:06:25', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (257, 123, 6, 'audit', NULL, NULL, '2021-10-10 02:06:25', NULL, 2, 'process', 1);
INSERT INTO `adm_process_flow` VALUES (258, 124, 2, 'apply', NULL, NULL, '2021-10-10 02:06:25', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (259, 124, 1, 'audit', NULL, NULL, '2021-10-10 02:06:25', NULL, 2, 'process', 1);
INSERT INTO `adm_process_flow` VALUES (260, 125, 3, 'apply', NULL, NULL, '2021-10-10 02:06:41', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (261, 125, 2, 'audit', 'approved', '部门经理同意', '2021-10-10 02:06:41', '2021-10-10 02:06:41', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (262, 126, 3, 'apply', NULL, NULL, '2021-10-10 02:08:03', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (263, 126, 2, 'audit', 'approved', '部门经理同意', '2021-10-10 02:08:03', '2021-10-10 02:08:03', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (264, 127, 3, 'apply', NULL, NULL, '2021-10-10 02:08:21', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (265, 127, 2, 'audit', 'refused', '部门经理拒绝', '2021-10-10 02:08:21', '2021-10-10 02:08:21', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (266, 128, 3, 'apply', NULL, NULL, '2021-10-10 02:08:27', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (267, 128, 2, 'audit', 'approved', '部门经理同意', '2021-10-10 02:08:27', '2021-10-10 02:08:27', 2, 'complete', 1);
INSERT INTO `adm_process_flow` VALUES (268, 129, 3, 'apply', NULL, NULL, '2021-10-10 02:26:58', NULL, 1, 'complete', 0);
INSERT INTO `adm_process_flow` VALUES (269, 129, 2, 'audit', 'approved', '快去快回', '2021-10-10 02:26:58', '2021-10-10 02:27:43', 2, 'complete', 1);

-- ----------------------------
-- Table structure for sys_node
-- ----------------------------
DROP TABLE IF EXISTS `sys_node`;
CREATE TABLE `sys_node`  (
  `node_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '节点编号',
  `node_type` int(0) NOT NULL COMMENT '节点类型 1-模块 2-功能',
  `node_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '节点名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能地址',
  `node_code` int(0) NOT NULL COMMENT '节点编码,用于排序',
  `parent_id` bigint(0) NULL DEFAULT NULL COMMENT '上级节点编号',
  PRIMARY KEY (`node_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_node
-- ----------------------------
INSERT INTO `sys_node` VALUES (1, 1, '行政审批', NULL, 1000000, NULL);
INSERT INTO `sys_node` VALUES (2, 2, '通知公告', '/notice.html', 1000001, 1);
INSERT INTO `sys_node` VALUES (3, 2, '请假申请', '/leave_form.html', 1000002, 1);
INSERT INTO `sys_node` VALUES (4, 2, '请假审批', '/audit.html', 1000003, 1);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `receiver_id` bigint(0) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (52, 3, '您的请假申请[2020-03-26-08时-2020-04-01-18时]已经提交，请等待上级审批', '2021-10-10 02:08:03');
INSERT INTO `sys_notice` VALUES (53, 2, '高级研发工程师-王美美提起请假申请[2020-03-26-08时-2020-04-01-18时]已经提交，请尽快审批', '2021-10-10 02:08:03');
INSERT INTO `sys_notice` VALUES (54, 3, '您的请假申请[2020-03-26-08时-2020-04-01-18时]部门经理齐紫陌已批准,审批意见：部门经理同意,审批流程已经结束', '2021-10-10 02:08:03');
INSERT INTO `sys_notice` VALUES (55, 2, '您的请假申请[2020-03-26-08时-2020-04-01-18时]高级研发工程师王美美已批准,审批意见：部门经理同意,审批流程已经结束', '2021-10-10 02:08:03');
INSERT INTO `sys_notice` VALUES (56, 3, '您的请假申请[2020-03-26-08时-2020-04-01-18时]已经提交，请等待上级审批', '2021-10-10 02:08:21');
INSERT INTO `sys_notice` VALUES (57, 2, '高级研发工程师-王美美提起请假申请[2020-03-26-08时-2020-04-01-18时]已经提交，请尽快审批', '2021-10-10 02:08:21');
INSERT INTO `sys_notice` VALUES (58, 3, '您的请假申请[2020-03-26-08时-2020-04-01-18时]部门经理齐紫陌已驳回,审批意见：部门经理拒绝,审批流程已经结束', '2021-10-10 02:08:21');
INSERT INTO `sys_notice` VALUES (59, 2, '您的请假申请[2020-03-26-08时-2020-04-01-18时]高级研发工程师王美美已驳回,审批意见：部门经理拒绝,审批流程已经结束', '2021-10-10 02:08:21');
INSERT INTO `sys_notice` VALUES (60, 3, '您的请假申请[2020-03-26-08时-2020-03-27-18时]已经提交，请等待上级审批', '2021-10-10 02:08:27');
INSERT INTO `sys_notice` VALUES (61, 2, '高级研发工程师-王美美提起请假申请[2020-03-26-08时-2020-03-27-18时]已经提交，请尽快审批', '2021-10-10 02:08:27');
INSERT INTO `sys_notice` VALUES (62, 3, '您的请假申请[2020-03-26-08时-2020-03-27-18时]部门经理齐紫陌已批准,审批意见：部门经理同意,审批流程已经结束', '2021-10-10 02:08:27');
INSERT INTO `sys_notice` VALUES (63, 2, '您的请假申请[2020-03-26-08时-2020-03-27-18时]高级研发工程师王美美已批准,审批意见：部门经理同意,审批流程已经结束', '2021-10-10 02:08:27');
INSERT INTO `sys_notice` VALUES (64, 3, '您的请假申请[2021-10-01-00时-2021-10-03-00时]已经提交，请等待上级审批', '2021-10-10 02:26:58');
INSERT INTO `sys_notice` VALUES (65, 2, '高级研发工程师-王美美提起请假申请[2021-10-01-00时-2021-10-03-00时]已经提交，请尽快审批', '2021-10-10 02:26:58');
INSERT INTO `sys_notice` VALUES (66, 3, '您的请假申请[2021-10-01-00时-2021-10-03-00时]部门经理齐紫陌已批准,审批意见：快去快回,审批流程已经结束', '2021-10-10 02:27:43');
INSERT INTO `sys_notice` VALUES (67, 2, '您的请假申请[2021-10-01-00时-2021-10-03-00时]高级研发工程师王美美已批准,审批意见：快去快回,审批流程已经结束', '2021-10-10 02:27:43');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_description` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '业务岗角色');
INSERT INTO `sys_role` VALUES (2, '管理岗角色');

-- ----------------------------
-- Table structure for sys_role_node
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_node`;
CREATE TABLE `sys_role_node`  (
  `rn_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) NOT NULL,
  `node_id` bigint(0) NOT NULL,
  PRIMARY KEY (`rn_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_node
-- ----------------------------
INSERT INTO `sys_role_node` VALUES (1, 1, 1);
INSERT INTO `sys_role_node` VALUES (2, 1, 2);
INSERT INTO `sys_role_node` VALUES (3, 1, 3);
INSERT INTO `sys_role_node` VALUES (4, 2, 1);
INSERT INTO `sys_role_node` VALUES (5, 2, 2);
INSERT INTO `sys_role_node` VALUES (6, 2, 3);
INSERT INTO `sys_role_node` VALUES (7, 2, 4);

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `ru_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) NOT NULL,
  `user_id` int(0) NOT NULL,
  PRIMARY KEY (`ru_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES (1, 2, 1);
INSERT INTO `sys_role_user` VALUES (2, 2, 2);
INSERT INTO `sys_role_user` VALUES (3, 1, 3);
INSERT INTO `sys_role_user` VALUES (4, 1, 4);
INSERT INTO `sys_role_user` VALUES (5, 1, 5);
INSERT INTO `sys_role_user` VALUES (6, 2, 6);
INSERT INTO `sys_role_user` VALUES (7, 1, 7);
INSERT INTO `sys_role_user` VALUES (8, 1, 8);
INSERT INTO `sys_role_user` VALUES (9, 1, 9);
INSERT INTO `sys_role_user` VALUES (10, 1, 10);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `employee_id` bigint(0) NOT NULL COMMENT '员工编号',
  `salt` int(0) NOT NULL COMMENT '盐值',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'm8', 'f57e762e3fb7e1e3ec8ec4db6a1248e1', 1, 188);
INSERT INTO `sys_user` VALUES (2, 't7', 'dcfa022748271dccf5532c834e98ad08', 2, 189);
INSERT INTO `sys_user` VALUES (3, 't6', '76ce11f8b004e8bdc8b0976b177c620d', 3, 190);
INSERT INTO `sys_user` VALUES (4, 't5', '11f04f04054772bc1a8fdc41e70c7977', 4, 191);
INSERT INTO `sys_user` VALUES (5, 't4', '8d7713848189a8d5c224f94f65d18b06', 5, 192);
INSERT INTO `sys_user` VALUES (6, 's7', '044214e86e07d96c97de79a2222188cd', 6, 193);
INSERT INTO `sys_user` VALUES (7, 's6', 'ecbd2f592ee65838328236d06ce35252', 7, 194);
INSERT INTO `sys_user` VALUES (8, 's5', '846ecc83bba8fe420adc38b39f897201', 8, 195);
INSERT INTO `sys_user` VALUES (9, 's4', 'c1e523cd2daa02f6cf4b98b2f26585fd', 9, 196);
INSERT INTO `sys_user` VALUES (10, 's3', '89e89f369e07634fbb2286efffb9492b', 10, 197);

SET FOREIGN_KEY_CHECKS = 1;
