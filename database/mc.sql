/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2020-05-27 18:17:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for game_tbl
-- ----------------------------
DROP TABLE IF EXISTS `game_tbl`;
CREATE TABLE `game_tbl` (
  `GAMEID` int(10) NOT NULL AUTO_INCREMENT COMMENT '游戏',
  `GAMENAME` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '游戏名称',
  `VAL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '游戏值',
  `USERNAME` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作用户',
  `VERSION` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT '0',
  `CREATEDATE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `UPDATEDATE` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`GAMEID`)
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for game_value_tbl
-- ----------------------------
DROP TABLE IF EXISTS `game_value_tbl`;
CREATE TABLE `game_value_tbl` (
  `GAMEVALID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `GAMENAME` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '游戏名称',
  `VAL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '游戏值',
  PRIMARY KEY (`GAMEVALID`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for user_tbl
-- ----------------------------
DROP TABLE IF EXISTS `user_tbl`;
CREATE TABLE `user_tbl` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `NICKNAME` varchar(255) DEFAULT '',
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for words_response_tbl
-- ----------------------------
DROP TABLE IF EXISTS `words_response_tbl`;
CREATE TABLE `words_response_tbl` (
  `WORDS_R_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `WORDSID` int(10) NOT NULL,
  `WORDS_R` varchar(2000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `USERNAME_BEFORE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `USERNAME_NEW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `LOOK` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0',
  `CREATEDATE` datetime DEFAULT NULL,
  `UPDATEDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`WORDS_R_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for words_tbl
-- ----------------------------
DROP TABLE IF EXISTS `words_tbl`;
CREATE TABLE `words_tbl` (
  `WORDSID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `WORDS` varchar(2000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `USERNAME` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `LOOK` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0',
  `IS_RESPONSE` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '是否是回复',
  `CREATEDATE` datetime DEFAULT NULL,
  `UPDATEDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`WORDSID`)
) ENGINE=InnoDB AUTO_INCREMENT=623 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
