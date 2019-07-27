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

 Date: 27/07/2019 14:00:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ccc
-- ----------------------------
DROP TABLE IF EXISTS `ccc`;
CREATE TABLE `ccc`  (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  PRIMARY KEY (`test_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ccc
-- ----------------------------
INSERT INTO `ccc` VALUES (1, 'ccc');
INSERT INTO `ccc` VALUES (2, 'ccc0.8395597209476784');
INSERT INTO `ccc` VALUES (3, 'ccc0.8542198125285312');
INSERT INTO `ccc` VALUES (4, 'ccc0.533237973062582');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int(11) NOT NULL,
  `city_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `province_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, 'yant', 1);
INSERT INTO `city` VALUES (2, 'beijing', 2);
INSERT INTO `city` VALUES (3, 'xinj', 3);
INSERT INTO `city` VALUES (4, 'la', 4);
INSERT INTO `city` VALUES (5, 'r', 4);
INSERT INTO `city` VALUES (6, 'ca', 5);
INSERT INTO `city` VALUES (7, 'genr', 6);
INSERT INTO `city` VALUES (8, 'weif', 1);
INSERT INTO `city` VALUES (9, 'qingd', 1);
INSERT INTO `city` VALUES (10, 'maz', 5);

-- ----------------------------
-- Table structure for city_government
-- ----------------------------
DROP TABLE IF EXISTS `city_government`;
CREATE TABLE `city_government`  (
  `id` int(11) NOT NULL,
  `city_government_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `city_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_government
-- ----------------------------
INSERT INTO `city_government` VALUES (1, 'yant_governmen', 1);
INSERT INTO `city_government` VALUES (2, 'beijing_governmen', 2);
INSERT INTO `city_government` VALUES (3, 'xinj_governmen', 3);
INSERT INTO `city_government` VALUES (4, 'la_governmen', 4);
INSERT INTO `city_government` VALUES (5, 'r_governmen', 5);
INSERT INTO `city_government` VALUES (6, 'ca_governmen', 6);
INSERT INTO `city_government` VALUES (7, 'genr_governmen', 7);
INSERT INTO `city_government` VALUES (8, 'weif_governmen', 8);
INSERT INTO `city_government` VALUES (9, 'qingd_governmen', 9);
INSERT INTO `city_government` VALUES (10, 'maz_governmen', 10);

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `clazz_id` int(11) NOT NULL,
  `clazz_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`clazz_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1, '1班');
INSERT INTO `clazz` VALUES (2, '2班');

-- ----------------------------
-- Table structure for companys
-- ----------------------------
DROP TABLE IF EXISTS `companys`;
CREATE TABLE `companys`  (
  `id` int(11) NOT NULL,
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of companys
-- ----------------------------
INSERT INTO `companys` VALUES (1, 'alibaba');
INSERT INTO `companys` VALUES (2, 'tencen');
INSERT INTO `companys` VALUES (3, 'jd');

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `id` int(11) NOT NULL,
  `country_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, 'china');
INSERT INTO `country` VALUES (2, 'usa');
INSERT INTO `country` VALUES (3, 'uk');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1);
INSERT INTO `orders` VALUES (2, 1);
INSERT INTO `orders` VALUES (3, 2);
INSERT INTO `orders` VALUES (4, 3);

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

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `id` int(11) NOT NULL,
  `province_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `country_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES (7, 'uk_b', 3);
INSERT INTO `province` VALUES (6, 'uk_a', 3);
INSERT INTO `province` VALUES (5, 'usa_b', 2);
INSERT INTO `province` VALUES (4, 'usa_a', 2);
INSERT INTO `province` VALUES (3, 'xj', 1);
INSERT INTO `province` VALUES (2, 'bj', 1);
INSERT INTO `province` VALUES (1, 'sd', 1);

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

-- ----------------------------
-- Table structure for staffs
-- ----------------------------
DROP TABLE IF EXISTS `staffs`;
CREATE TABLE `staffs`  (
  `staff_id` int(11) NOT NULL,
  `company_id` int(11) NULL DEFAULT NULL,
  `staff_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`staff_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staffs
-- ----------------------------
INSERT INTO `staffs` VALUES (1, 1, 'bna');
INSERT INTO `staffs` VALUES (2, 3, 'agge');
INSERT INTO `staffs` VALUES (3, 1, 'hhhh');
INSERT INTO `staffs` VALUES (4, 2, 'gdfw1222');
INSERT INTO `staffs` VALUES (5, 2, '5');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  `student_age` int(255) NULL DEFAULT NULL,
  `claz_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'namc', 6, 1);
INSERT INTO `student` VALUES (2, 'zfzx', 7, 2);
INSERT INTO `student` VALUES (3, '4gd', 5, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'asdg');
INSERT INTO `user` VALUES (2, 'tg4');
INSERT INTO `user` VALUES (3, '43');

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

-- ----------------------------
-- Table structure for user_password
-- ----------------------------
DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password`  (
  `encrypt_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_password
-- ----------------------------
INSERT INTO `user_password` VALUES ('ICy5YqxZB1uWSwcVLSNLcA==', '91d3cd711a594c238478a2103683f4f8');
INSERT INTO `user_password` VALUES ('ICy5YqxZB1uWSwcVLSNLcA==', '87b41f4341614353b14ee2c97da908a4');
INSERT INTO `user_password` VALUES ('f5daVsdh22UG7KCzfObshw==', '0702d6211eb748d49a8829b3dc36d20d');
INSERT INTO `user_password` VALUES ('f5daVsdh22UG7KCzfObshw==', '7be8bb1f08d047b5bf5323946cda02d5');
INSERT INTO `user_password` VALUES ('f5daVsdh22UG7KCzfObshw==', '0c3660fb622e473b88776ca909aeddcc');
INSERT INTO `user_password` VALUES ('RWrJsNFai38ecQcyIQWYhg==', 'ac7d35a0fb8b4738a8aa510fc0377b75');
INSERT INTO `user_password` VALUES ('KkAh5jm7yW04Y0bFiYrpoA==', 'af2e50d9a7fc4a0da335bce9f13bf500');
INSERT INTO `user_password` VALUES ('ICy5YqxZB1uWSwcVLSNLcA==', '2c9c1c0a0ef74ee8802e42116fd31d88');
INSERT INTO `user_password` VALUES ('sVYaZgHz3jegGv0bD5oSWw==', '86062c158ba04120ae4ff1a49e1ab82c');
INSERT INTO `user_password` VALUES ('afZaLpHmBRojq+cpO/M4ag==', 'ec26f6d3ce74424ebf18df136b7c2116');

-- ----------------------------
-- Table structure for xxx
-- ----------------------------
DROP TABLE IF EXISTS `xxx`;
CREATE TABLE `xxx`  (
  `maa` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sadf` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `wrsa` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `sfds` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`maa`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xxx
-- ----------------------------
INSERT INTO `xxx` VALUES ('123', '345', '456', '997');
INSERT INTO `xxx` VALUES ('124', '345', '456', '985');
INSERT INTO `xxx` VALUES ('125', '345', '456', '917');
INSERT INTO `xxx` VALUES ('126', '345', '456', '987');
INSERT INTO `xxx` VALUES ('127', '345', '456', '47');
INSERT INTO `xxx` VALUES ('128', '345', '456', '977');
INSERT INTO `xxx` VALUES ('129', '345', '456', '937');
INSERT INTO `xxx` VALUES ('130', '345', '78', '76');

-- ----------------------------
-- Table structure for zzz
-- ----------------------------
DROP TABLE IF EXISTS `zzz`;
CREATE TABLE `zzz`  (
  `timsta` timestamp NULL DEFAULT NULL,
  `qwe` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `asd` int(255) NULL DEFAULT NULL,
  `zxc` date NULL DEFAULT NULL,
  `st` datetime NULL DEFAULT NULL,
  `fgh` double(255, 0) NULL DEFAULT NULL,
  `en` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`qwe`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zzz
-- ----------------------------
INSERT INTO `zzz` VALUES ('2019-05-13 18:21:24', '12', 2, '2019-05-08', '2019-05-22 00:00:00', 3, '2019-05-20 15:19:28');
INSERT INTO `zzz` VALUES ('2019-03-12 18:31:03', '23', 3, '2019-05-15', '2019-05-15 15:24:08', 23, '2019-05-31 15:24:08');
INSERT INTO `zzz` VALUES ('2019-05-10 18:30:57', '2353', 3, '1970-01-14', '1970-01-22 08:00:01', 23, '1970-05-01 08:00:02');
INSERT INTO `zzz` VALUES ('2019-04-28 18:30:54', '263', 12, '1970-01-08', '1970-01-14 08:00:01', 23, '1970-03-13 08:00:01');
INSERT INTO `zzz` VALUES ('2019-05-15 18:31:00', '223', 22, '1970-01-30', '1970-01-20 08:00:01', 23, '1970-03-05 08:00:01');
INSERT INTO `zzz` VALUES ('2019-05-06 18:30:51', '213', 32, '1970-02-04', '1970-02-04 08:00:02', 23, '1970-04-01 08:00:01');
INSERT INTO `zzz` VALUES ('2019-05-13 18:30:47', '2383', 322, '1970-01-13', '1970-01-08 08:00:02', 23, '1970-06-01 08:00:02');
INSERT INTO `zzz` VALUES ('1999-03-03 12:23:33', '2213', 2, '2019-05-15', '2019-05-15 18:27:10', 2, '2019-05-15 18:27:10');
INSERT INTO `zzz` VALUES ('1999-03-03 12:23:33', '21213', 12, '1999-03-03', '1999-03-03 12:23:33', 22, '1999-03-03 12:23:33');

SET FOREIGN_KEY_CHECKS = 1;
