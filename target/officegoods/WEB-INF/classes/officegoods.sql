/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : officegoods

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-07-19 16:49:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(100) NOT NULL COMMENT '办公用品名称',
  `goods_desc` varchar(250) NOT NULL COMMENT '商品规格',
  `goods_total` int(11) NOT NULL COMMENT '总共的用品数量',
  `goods_num` int(11) NOT NULL COMMENT '可用商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='办公用品表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '联想台式机(屏幕+主机 鼠标键盘整套)', '天逸510S ', '100', '100');
INSERT INTO `goods` VALUES ('2', '戴尔台式机(屏幕+主机 鼠标键盘套装)', 'xxxx', '80', '80');
INSERT INTO `goods` VALUES ('3', '地雷', 'QQ', '12', '12');
INSERT INTO `goods` VALUES ('4', '航海母舰', '001', '10', '10');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_name` varchar(30) NOT NULL COMMENT '领用人姓名',
  `record_num` int(11) NOT NULL COMMENT '领用办公用品数量',
  `record_status` tinyint(4) DEFAULT NULL COMMENT '领用状态 0--归还 ,1--领用中',
  `record_date` date DEFAULT NULL COMMENT '领用时间',
  `goods_id` int(11) NOT NULL COMMENT '领用商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='领用记录';

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '杨爽', '1', '1', '2018-07-18', '1');
INSERT INTO `record` VALUES ('2', '李兆', '1', '1', '2018-07-19', '1');
INSERT INTO `record` VALUES ('3', '郑伟', '1', '1', '2018-07-09', '3');
INSERT INTO `record` VALUES ('4', '杨爽', '1', '1', '2018-07-19', '3');
