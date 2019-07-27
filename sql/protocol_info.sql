/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3307
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3307
 Source Schema         : testchr

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 27/07/2019 10:33:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for protocol_info
-- ----------------------------
DROP TABLE IF EXISTS `protocol_info`;
CREATE TABLE `protocol_info`  (
  `protocol_id` int(11) NOT NULL DEFAULT 0,
  `protocol_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  PRIMARY KEY (`protocol_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of protocol_info
-- ----------------------------
INSERT INTO `protocol_info` VALUES (1, 'tcp');

SET FOREIGN_KEY_CHECKS = 1;
