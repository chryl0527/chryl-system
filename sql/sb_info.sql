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

 Date: 27/07/2019 10:33:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sb_info
-- ----------------------------
DROP TABLE IF EXISTS `sb_info`;
CREATE TABLE `sb_info`  (
  `sb_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  `sb_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  `sb_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  `sb_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  `sb_protocol_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`sb_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sb_info
-- ----------------------------
INSERT INTO `sb_info` VALUES ('chr3066', '91d3cd711a594c238478a2103683f4f8', '测试设备1', '烟感设备', '无', 1);
INSERT INTO `sb_info` VALUES ('abc001', '87b41f4341614353b14ee2c97da908a4', '测试设备2', '光感设备', '无', 1);
INSERT INTO `sb_info` VALUES ('ak998', '0702d6211eb748d49a8829b3dc36d20d', '测试设备3', '电感设备', '无', 1);
INSERT INTO `sb_info` VALUES ('a-360', '7be8bb1f08d047b5bf5323946cda02d5', '新设备9527', '智能设备', '新设备-A', 1);
INSERT INTO `sb_info` VALUES ('m332', '86062c158ba04120ae4ff1a49e1ab82c', '测试设备x', '智能设备', '完善设备', 1);
INSERT INTO `sb_info` VALUES ('see-001', '91d3cd711a594c238478a2103683f4f8', '检测设备-001', '测试设备', '智能设备', 1);
INSERT INTO `sb_info` VALUES ('sb-010', '2c9c1c0a0ef74ee8802e42116fd31d88', '智能设备', '电感设备', '暂无描述', 1);
INSERT INTO `sb_info` VALUES ('012', '0702d6211eb748d49a8829b3dc36d20d', '智能设备', '测试设备', '暂无描述', 1);
INSERT INTO `sb_info` VALUES ('013', '0702d6211eb748d49a8829b3dc36d20d', '智能设备', '测试设备', '暂无描述2', 1);
INSERT INTO `sb_info` VALUES ('0161', '0702d6211eb748d49a8829b3dc36d20d', '智能设备7', '测试设备1', '暂无描述12', 1);
INSERT INTO `sb_info` VALUES ('053', '91d3cd711a594c238478a2103683f4f8', '智能设备3', '测试设备1', '暂无描述42', 1);

SET FOREIGN_KEY_CHECKS = 1;
