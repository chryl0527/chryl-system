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

 Date: 27/07/2019 10:33:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('91d3cd711a594c238478a2103683f4f8', 'nancy', '10000000000');
INSERT INTO `user_info` VALUES ('87b41f4341614353b14ee2c97da908a4', 'Chryl', '1023232323');
INSERT INTO `user_info` VALUES ('0702d6211eb748d49a8829b3dc36d20d', 'see', '11111111111');
INSERT INTO `user_info` VALUES ('7be8bb1f08d047b5bf5323946cda02d5', 'home', '11232323232');
INSERT INTO `user_info` VALUES ('0c3660fb622e473b88776ca909aeddcc', 'abc', '18987878232');
INSERT INTO `user_info` VALUES ('ac7d35a0fb8b4738a8aa510fc0377b75', 'boom', '18965987412');
INSERT INTO `user_info` VALUES ('af2e50d9a7fc4a0da335bce9f13bf500', 'ccm24', '10265498526');
INSERT INTO `user_info` VALUES ('2c9c1c0a0ef74ee8802e42116fd31d88', 'kob', '10101010101');
INSERT INTO `user_info` VALUES ('86062c158ba04120ae4ff1a49e1ab82c', 'chyl', '78941253690');
INSERT INTO `user_info` VALUES ('ec26f6d3ce74424ebf18df136b7c2116', 'nay', '13369356874');

SET FOREIGN_KEY_CHECKS = 1;
