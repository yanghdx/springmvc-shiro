/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : shirodemo

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2016-06-28 18:06:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `priority` int(5) NOT NULL,
  `parent_id` int(100) NOT NULL,
  `avilable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', '总部', '1', '0', '1');
INSERT INTO `sys_org` VALUES ('2', '北京分部', '2', '1', '1');
INSERT INTO `sys_org` VALUES ('3', '上海分部', '2', '1', '1');

-- ----------------------------
-- Table structure for sys_res
-- ----------------------------
DROP TABLE IF EXISTS `sys_res`;
CREATE TABLE `sys_res` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `priority` int(5) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `parent_ids` varchar(100) NOT NULL,
  `permission` varchar(100) NOT NULL,
  `avaliable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_res
-- ----------------------------
INSERT INTO `sys_res` VALUES ('1', '创建用户', 'button', '1', '0', '0', 'user:add', '1');
INSERT INTO `sys_res` VALUES ('2', '查看用户', 'button', '2', '0', '0', 'user:view', '1');
INSERT INTO `sys_res` VALUES ('3', '删除用户', 'button', '3', '0', '0', 'user:del', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `role` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `res_ids` varchar(100) NOT NULL,
  `avaliable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'sysAdmin', '系统管理员', '1,2,3', '1');
INSERT INTO `sys_role` VALUES ('2', 'commonUser', '普通用户', '2', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `salt` varchar(50) NOT NULL,
  `role_ids` varchar(100) NOT NULL,
  `locked` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '928bfd2577490322a6e19b793691467e', 'admin', '1', '0');
INSERT INTO `sys_user` VALUES ('2', 'user', 'b8c2d5b0a37cc51f91d5e8970347a3a3', 'user', '2', '0');
