/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : testname

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-21 16:11:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addweight
-- ----------------------------
DROP TABLE IF EXISTS `addweight`;
CREATE TABLE `addweight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pig_No` varchar(60) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `date` varchar(57) DEFAULT NULL,
  `isException` int(11) DEFAULT NULL,
  `pigtypeId` int(11) DEFAULT NULL,
  `growthStateID` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addweight
-- ----------------------------
INSERT INTO `addweight` VALUES ('1', '1', '4', '2016-10-12 12:45:32', '0', '1', '1', '0');
INSERT INTO `addweight` VALUES ('2', '1', '5', '2016-10-13 12:45:33', '1', '1', '1', '0');
INSERT INTO `addweight` VALUES ('3', '1', '3', '2016-10-14 12:45:34', '1', '1', '1', '0');
INSERT INTO `addweight` VALUES ('4', '1', '3', '2016-10-15 12:45:35', '1', '1', '1', '0');
INSERT INTO `addweight` VALUES ('5', '1', '1.5', '2016-10-16 12:45:36', '0', '1', '1', '0');

-- ----------------------------
-- Table structure for algorithm
-- ----------------------------
DROP TABLE IF EXISTS `algorithm`;
CREATE TABLE `algorithm` (
  `algorithmID` int(11) NOT NULL COMMENT '算法主键，自增',
  `name` varchar(30) NOT NULL COMMENT '算法名称',
  `type` int(11) NOT NULL COMMENT '0:预处理算法  1:分析算法',
  `description` varchar(120) NOT NULL COMMENT '系统管理员对此算法的描述',
  `uploadTime` datetime NOT NULL COMMENT '上传时间,以****-**-** **:**:** 此种格式为标准存入，精确到秒',
  `state` int(11) NOT NULL,
  `savePath` varchar(120) NOT NULL DEFAULT '' COMMENT '算法存储路径',
  `uploadUserNo` varchar(32) NOT NULL COMMENT '上传算法的用户',
  `downloadCount` bigint(20) NOT NULL COMMENT '用户下载次数',
  PRIMARY KEY (`algorithmID`),
  KEY `algorithm_fk_01_idx` (`uploadUserNo`),
  CONSTRAINT `algorithm_fk_01` FOREIGN KEY (`uploadUserNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of algorithm
-- ----------------------------

-- ----------------------------
-- Table structure for backup
-- ----------------------------
DROP TABLE IF EXISTS `backup`;
CREATE TABLE `backup` (
  `backupID` bigint(20) NOT NULL COMMENT '备份表主键，自增',
  `backupFileName` varchar(30) NOT NULL COMMENT '备份文件名称',
  `createTime` datetime NOT NULL COMMENT '备份文件创建日期',
  `savePath` varchar(150) NOT NULL COMMENT '备份文件存储的路径',
  `description` varchar(100) NOT NULL COMMENT '描述备份文件的信息',
  PRIMARY KEY (`backupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backup
-- ----------------------------

-- ----------------------------
-- Table structure for combinatorialalgorithm
-- ----------------------------
DROP TABLE IF EXISTS `combinatorialalgorithm`;
CREATE TABLE `combinatorialalgorithm` (
  `combinatorialAlgorithmID` int(11) NOT NULL COMMENT '主键，自增',
  `name` varchar(32) NOT NULL COMMENT '组合算法名称',
  `combinatorialUserNo` varchar(32) NOT NULL,
  `function` varchar(120) NOT NULL COMMENT '该组合算法的功能',
  `preAlgoID` int(11) NOT NULL,
  `analysisAlgoID` int(11) NOT NULL,
  `createTime` datetime NOT NULL COMMENT '组合算法创建时间,例如2016-12-12 22:22:22',
  `state` int(11) NOT NULL COMMENT '是否公开',
  PRIMARY KEY (`combinatorialAlgorithmID`),
  KEY `combinatorialalgorithm_fk_01_idx` (`combinatorialUserNo`),
  KEY `combinatorialalgorithm_fk_02_idx` (`preAlgoID`),
  KEY `combinatorialalgorithm_fk_03_idx` (`analysisAlgoID`),
  CONSTRAINT `combinatorialalgorithm_fk_01` FOREIGN KEY (`combinatorialUserNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `combinatorialalgorithm_fk_02` FOREIGN KEY (`preAlgoID`) REFERENCES `algorithm` (`algorithmID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `combinatorialalgorithm_fk_03` FOREIGN KEY (`analysisAlgoID`) REFERENCES `algorithm` (`algorithmID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of combinatorialalgorithm
-- ----------------------------

-- ----------------------------
-- Table structure for diseasetreatment
-- ----------------------------
DROP TABLE IF EXISTS `diseasetreatment`;
CREATE TABLE `diseasetreatment` (
  `diseaseTreatmentID` bigint(20) NOT NULL COMMENT '疾病治疗ID',
  `pigNo` varchar(32) NOT NULL COMMENT '猪耳号',
  `drugTypeID` int(11) NOT NULL,
  `eatTime` date NOT NULL COMMENT '服药时间',
  `useCount` int(11) NOT NULL COMMENT '用药总用量',
  `illTime` datetime NOT NULL COMMENT '生病时间',
  `illDescription` varchar(120) DEFAULT NULL COMMENT '病情描述',
  PRIMARY KEY (`diseaseTreatmentID`),
  KEY `diseasetreatment_fk_01_idx` (`pigNo`),
  KEY `diseasetreatment_fk_02_idx` (`drugTypeID`),
  CONSTRAINT `diseasetreatment_fk_01` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `diseasetreatment_fk_02` FOREIGN KEY (`drugTypeID`) REFERENCES `drugtype` (`drugTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diseasetreatment
-- ----------------------------

-- ----------------------------
-- Table structure for drugrecord
-- ----------------------------
DROP TABLE IF EXISTS `drugrecord`;
CREATE TABLE `drugrecord` (
  `drugRecordID` int(20) DEFAULT NULL,
  `drugTypeID` int(11) DEFAULT NULL,
  `createTime` varchar(222) DEFAULT NULL COMMENT '生产日期',
  `effectiveTime` varchar(222) DEFAULT NULL COMMENT '有效期',
  `curNumber` int(11) DEFAULT NULL COMMENT '当前库存量',
  `unit` varchar(5) DEFAULT NULL,
  `price` double(9,2) DEFAULT NULL COMMENT '药价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drugrecord
-- ----------------------------
INSERT INTO `drugrecord` VALUES ('1', '766', '2018-7-12', '4到5个月', '21', '斤', '323.00');
INSERT INTO `drugrecord` VALUES ('2', '766', '2018-7-12', '4到5个月', '21', '斤', '323.00');
INSERT INTO `drugrecord` VALUES ('3', '766', '2018-7-12', '4到5个月', '21', '斤', '323.00');
INSERT INTO `drugrecord` VALUES ('4', '766', '2018-7-12', '4到5个月', '21', '斤', '323.00');
INSERT INTO `drugrecord` VALUES ('5', '766', '2018-7-12', '4到5个月', '21', '斤', '323.00');
INSERT INTO `drugrecord` VALUES ('6', '766', '2018-7-12', '4到5个月', '21', '斤', '323.00');
INSERT INTO `drugrecord` VALUES ('7', '766', '2018-7-12', '4到5个月', '21', '斤', '323.00');

-- ----------------------------
-- Table structure for drugtype
-- ----------------------------
DROP TABLE IF EXISTS `drugtype`;
CREATE TABLE `drugtype` (
  `drugTypeID` int(11) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '药类型名称',
  PRIMARY KEY (`drugTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drugtype
-- ----------------------------

-- ----------------------------
-- Table structure for eatrecord
-- ----------------------------
DROP TABLE IF EXISTS `eatrecord`;
CREATE TABLE `eatrecord` (
  `eatRecordID` bigint(20) NOT NULL,
  `pigNo` varchar(32) NOT NULL,
  `growthStateID` int(11) NOT NULL COMMENT '生长阶段',
  `surplus` int(11) NOT NULL COMMENT '平均剩余量',
  `eatCount` int(11) NOT NULL COMMENT '平均食用量',
  PRIMARY KEY (`eatRecordID`),
  KEY `eatrecord_fk_01_idx` (`pigNo`),
  KEY `eatrecord_fk_02_idx` (`growthStateID`),
  CONSTRAINT `eatrecord_fk_01` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `eatrecord_fk_02` FOREIGN KEY (`growthStateID`) REFERENCES `growthstate` (`growthStateID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eatrecord
-- ----------------------------

-- ----------------------------
-- Table structure for eliminate
-- ----------------------------
DROP TABLE IF EXISTS `eliminate`;
CREATE TABLE `eliminate` (
  `eliminateID` bigint(20) NOT NULL,
  `pigNo` varchar(32) NOT NULL,
  `reason` varchar(120) NOT NULL COMMENT '淘汰理由',
  `date` datetime NOT NULL COMMENT '日期，精确到天',
  PRIMARY KEY (`eliminateID`),
  KEY `eliminate_fk_01_idx` (`pigNo`),
  CONSTRAINT `eliminate_fk_01` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eliminate
-- ----------------------------

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `equipmentID` bigint(20) NOT NULL,
  `ename` varchar(32) NOT NULL,
  `etype` varchar(6) NOT NULL,
  `workState` int(11) NOT NULL,
  `pigstyID` int(11) NOT NULL COMMENT '猪舍编号',
  `hogcoteID` int(11) NOT NULL COMMENT '猪栏编号',
  `timeInterval` int(11) DEFAULT NULL COMMENT '传感器收集数据时间间隔,',
  `controlType` varchar(10) DEFAULT NULL COMMENT '环控设备类型,温度,湿度...',
  `isAutoControl` int(11) DEFAULT NULL COMMENT '环控设备阈值',
  `isAutoHandle` int(11) DEFAULT NULL,
  PRIMARY KEY (`equipmentID`),
  KEY `equipment_fk_01_idx` (`pigstyID`),
  KEY `equipment_fk_02_idx` (`hogcoteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '温度传感器', '传感器', '1', '1', '1', '5', 'null', '1', '0');
INSERT INTO `equipment` VALUES ('2', '湿度传感器', '传感器', '1', '1', '1', '5', 'null', '0', '0');
INSERT INTO `equipment` VALUES ('3', '风机', '环控设备', '1', '1', '2', '5', '温度', '1', '0');
INSERT INTO `equipment` VALUES ('4', '温度传感器', '传感器', '1', '2', '1', '8', 'null', '0', '1');
INSERT INTO `equipment` VALUES ('5', '温度传感器', '传感器', '1', '3', '1', '8', 'null', '1', '1');
INSERT INTO `equipment` VALUES ('6', '氨气传感器', '传感器', '1', '2', '1', '5', null, '0', '0');

-- ----------------------------
-- Table structure for equipmentdata
-- ----------------------------
DROP TABLE IF EXISTS `equipmentdata`;
CREATE TABLE `equipmentdata` (
  `equipmentDataID` int(11) NOT NULL,
  `data` double(30,0) NOT NULL,
  `equipmentID` int(11) NOT NULL,
  `time` datetime NOT NULL COMMENT '数据接受时间',
  PRIMARY KEY (`equipmentDataID`),
  KEY `equipmentdate_fk_01_idx` (`equipmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipmentdata
-- ----------------------------
INSERT INTO `equipmentdata` VALUES ('1', '17', '1', '2018-10-30 08:00:00');
INSERT INTO `equipmentdata` VALUES ('2', '21', '1', '2018-10-30 12:00:00');
INSERT INTO `equipmentdata` VALUES ('3', '18', '1', '2018-10-30 16:00:00');
INSERT INTO `equipmentdata` VALUES ('4', '19', '4', '2018-10-30 10:00:00');
INSERT INTO `equipmentdata` VALUES ('5', '21', '4', '2018-10-30 12:00:00');
INSERT INTO `equipmentdata` VALUES ('6', '20', '4', '2018-10-30 14:00:00');
INSERT INTO `equipmentdata` VALUES ('7', '15', '5', '2018-10-30 06:00:00');
INSERT INTO `equipmentdata` VALUES ('8', '20', '5', '2018-10-30 12:00:00');
INSERT INTO `equipmentdata` VALUES ('9', '16', '5', '2018-10-30 18:00:00');
INSERT INTO `equipmentdata` VALUES ('10', '75', '2', '2018-11-01 06:00:00');
INSERT INTO `equipmentdata` VALUES ('11', '72', '2', '2018-11-01 09:00:00');
INSERT INTO `equipmentdata` VALUES ('12', '25', '6', '2018-11-11 09:00:00');
INSERT INTO `equipmentdata` VALUES ('13', '22', '6', '2018-11-11 12:00:00');

-- ----------------------------
-- Table structure for equipmentrecord
-- ----------------------------
DROP TABLE IF EXISTS `equipmentrecord`;
CREATE TABLE `equipmentrecord` (
  `equipmentRecordID` int(11) NOT NULL AUTO_INCREMENT,
  `equipmentID` varchar(255) DEFAULT NULL,
  `effectiveDate` varchar(255) DEFAULT NULL,
  `createDate` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `useState` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`equipmentRecordID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipmentrecord
-- ----------------------------
INSERT INTO `equipmentrecord` VALUES ('1', 'yy-mm', '2018-11-13', '2018-11-13', '463.60', '以损坏');
INSERT INTO `equipmentrecord` VALUES ('2', 'yy-arb', '2018-11-13', '2018-11-13', '324.00', '完好');
INSERT INTO `equipmentrecord` VALUES ('3', 'yy-arb', '2018-11-13', '2018-11-13', '432.00', '以损坏');
INSERT INTO `equipmentrecord` VALUES ('4', 'yy-arb', '2018-11-13', '2018-11-13', '657.00', '以损坏');
INSERT INTO `equipmentrecord` VALUES ('5', 'yy-arb', '2018-11-13', '2018-11-13', '456.64', '以损坏');
INSERT INTO `equipmentrecord` VALUES ('6', 'yy-arb', '2018-11-13', '2018-11-13', '456.00', '以损坏');
INSERT INTO `equipmentrecord` VALUES ('7', 'yy-arb', '2018-11-13', '2018-11-13', '345.00', '完好');
INSERT INTO `equipmentrecord` VALUES ('8', 'yy-arb', '2018-11-13', '2018-11-13', '235.00', '完好');
INSERT INTO `equipmentrecord` VALUES ('9', 'yy-arb', '2018-11-13', '2018-11-13', '463.00', '完好');

-- ----------------------------
-- Table structure for exception
-- ----------------------------
DROP TABLE IF EXISTS `exception`;
CREATE TABLE `exception` (
  `exceptionID` int(11) NOT NULL,
  `equipmentID` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `processingMethod` varchar(20) NOT NULL,
  `processUserNo` varchar(32) NOT NULL,
  PRIMARY KEY (`exceptionID`),
  KEY `exception_fk_01_idx` (`equipmentID`),
  KEY `exception_fk_02_idx` (`processUserNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exception
-- ----------------------------
INSERT INTO `exception` VALUES ('1', '1', '2018-11-13 21:36:47', '重启', 'admin');
INSERT INTO `exception` VALUES ('2', '2', '2018-11-15 21:38:32', '关闭', 'wangxin');

-- ----------------------------
-- Table structure for feedrecord
-- ----------------------------
DROP TABLE IF EXISTS `feedrecord`;
CREATE TABLE `feedrecord` (
  `feedRecordID` int(20) DEFAULT NULL,
  `createTime` varchar(225) DEFAULT NULL,
  `effectiveTime` varchar(225) DEFAULT NULL,
  `curNumber` int(11) DEFAULT NULL,
  `unit` varchar(5) DEFAULT NULL,
  `price` double(9,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedrecord
-- ----------------------------
INSERT INTO `feedrecord` VALUES ('1', '2018-11-14', '3到5个月', '500', '斤', '2000.00');
INSERT INTO `feedrecord` VALUES ('2', '2018-11-14', '3到5个月', '500', '斤', '2000.00');
INSERT INTO `feedrecord` VALUES ('3', '2018-11-14', '3到5个月', '500', null, '2000.00');
INSERT INTO `feedrecord` VALUES ('4', '2018-11-14', '3到5个月', '500', null, '2000.00');
INSERT INTO `feedrecord` VALUES ('5', '2018-11-14', '3到5个月', '500', null, '2000.00');
INSERT INTO `feedrecord` VALUES ('6', '2018-11-14', '3到5个月', '500', null, '2000.00');

-- ----------------------------
-- Table structure for feedset
-- ----------------------------
DROP TABLE IF EXISTS `feedset`;
CREATE TABLE `feedset` (
  `feedSetID` int(11) NOT NULL COMMENT '饲喂设定',
  `pigTypeID` int(11) NOT NULL,
  `growthStateID` int(11) NOT NULL,
  `formulaID` int(11) NOT NULL,
  `putNumber` int(11) NOT NULL COMMENT '投放量',
  `putTime` datetime NOT NULL,
  `timeInterval` int(11) NOT NULL COMMENT '时间间隔',
  PRIMARY KEY (`feedSetID`),
  KEY `feedset_fk_01_idx` (`pigTypeID`),
  KEY `feedset_fk_02_idx` (`growthStateID`),
  KEY `feedset_fk_03_idx` (`formulaID`),
  CONSTRAINT `feedset_fk_01` FOREIGN KEY (`pigTypeID`) REFERENCES `pigtype` (`pigTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `feedset_fk_02` FOREIGN KEY (`growthStateID`) REFERENCES `growthstate` (`growthStateID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `feedset_fk_03` FOREIGN KEY (`formulaID`) REFERENCES `formula` (`formulaID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedset
-- ----------------------------

-- ----------------------------
-- Table structure for formula
-- ----------------------------
DROP TABLE IF EXISTS `formula`;
CREATE TABLE `formula` (
  `formulaID` int(11) NOT NULL COMMENT '配方',
  `name` varchar(32) NOT NULL,
  `waterProportion` int(11) NOT NULL COMMENT '水比例',
  `drugProportion` int(11) NOT NULL,
  `feedProportion` int(11) NOT NULL,
  `drugTypeID` int(11) NOT NULL,
  `season` char(1) NOT NULL COMMENT '季节',
  `createTime` datetime NOT NULL,
  `createUserNo` varchar(32) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`formulaID`),
  KEY `formula_fk_01_idx` (`drugTypeID`),
  KEY `formula_fk_02_idx` (`createUserNo`),
  CONSTRAINT `formula_fk_01` FOREIGN KEY (`drugTypeID`) REFERENCES `drugtype` (`drugTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `formula_fk_02` FOREIGN KEY (`createUserNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of formula
-- ----------------------------

-- ----------------------------
-- Table structure for gathering
-- ----------------------------
DROP TABLE IF EXISTS `gathering`;
CREATE TABLE `gathering` (
  `gatheringID` int(10) NOT NULL AUTO_INCREMENT COMMENT '收款单号',
  `gatheringType` int(11) DEFAULT NULL COMMENT '收款的类型',
  `gatherDate` datetime DEFAULT NULL COMMENT '收款时间',
  `money` double DEFAULT NULL COMMENT '金额',
  `serialNumber` varchar(225) DEFAULT NULL COMMENT '收款的流水号',
  `gatherReason` text COMMENT '收款原因',
  `orderNumber` varchar(225) DEFAULT NULL COMMENT '物品订单号',
  `payer` varchar(255) DEFAULT NULL COMMENT '付款人员',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收款人员',
  PRIMARY KEY (`gatheringID`)
) ENGINE=InnoDB AUTO_INCREMENT=517 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gathering
-- ----------------------------
INSERT INTO `gathering` VALUES ('1', '1', '2018-10-11 18:50:04', '100', '12312312', null, null, null, null);
INSERT INTO `gathering` VALUES ('3', '2', '2018-10-10 18:50:07', '100', '1231232', null, null, null, null);
INSERT INTO `gathering` VALUES ('4', '3', '2018-10-05 18:50:12', '100', '3123213', null, null, null, null);
INSERT INTO `gathering` VALUES ('5', '4', '2018-10-26 18:50:17', '100', '212222', null, null, null, null);
INSERT INTO `gathering` VALUES ('6', '1', '2018-10-28 18:50:22', '100', '2222222', null, null, null, null);
INSERT INTO `gathering` VALUES ('7', '2', '2018-10-01 18:50:27', '100', '2112312', null, null, null, null);
INSERT INTO `gathering` VALUES ('8', '3', '2018-10-09 18:50:32', '1000', '21312312', null, null, null, null);
INSERT INTO `gathering` VALUES ('9', '4', '2018-10-25 18:50:36', '1000', '11123232', null, null, null, null);
INSERT INTO `gathering` VALUES ('10', '1', '2018-10-16 18:50:41', '100', '31231211', null, null, null, null);
INSERT INTO `gathering` VALUES ('360', '2', '2018-01-19 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('361', '1', '2018-01-26 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('362', '4', '2018-01-11 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('363', '1', '2018-01-18 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('364', '4', '2018-01-15 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('365', '2', '2018-01-04 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('366', '1', '2018-01-03 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('367', '4', '2018-01-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('368', '2', '2018-01-12 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('369', '2', '2018-01-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('370', '2', '2018-02-18 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('371', '2', '2018-02-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('372', '4', '2018-02-06 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('373', '2', '2018-02-11 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('374', '2', '2018-02-27 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('375', '3', '2018-02-23 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('376', '3', '2018-02-11 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('377', '4', '2018-02-12 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('378', '1', '2018-02-16 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('379', '1', '2018-02-21 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('380', '1', '2018-03-16 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('381', '2', '2018-03-19 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('382', '3', '2018-03-17 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('383', '1', '2018-03-06 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('384', '2', '2018-03-25 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('385', '1', '2018-03-13 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('386', '1', '2018-03-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('387', '1', '2018-03-25 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('388', '3', '2018-03-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('389', '2', '2018-04-01 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('390', '1', '2018-04-03 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('391', '4', '2018-04-27 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('392', '4', '2018-04-25 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('393', '2', '2018-04-13 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('394', '1', '2018-04-08 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('395', '2', '2018-04-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('396', '4', '2018-04-08 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('397', '2', '2018-04-04 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('398', '1', '2018-04-26 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('399', '2', '2018-05-27 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('400', '1', '2018-05-21 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('401', '4', '2018-05-26 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('402', '3', '2018-05-22 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('403', '1', '2018-05-14 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('404', '3', '2018-05-11 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('405', '3', '2018-05-20 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('406', '3', '2018-05-21 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('407', '3', '2018-05-24 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('408', '4', '2018-05-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('409', '1', '2018-06-13 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('410', '1', '2018-06-08 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('411', '1', '2018-06-17 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('412', '1', '2018-06-09 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('413', '2', '2018-06-06 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('414', '1', '2018-06-15 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('415', '2', '2018-06-16 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('416', '2', '2018-06-23 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('417', '1', '2018-06-06 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('418', '3', '2018-06-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('419', '4', '2018-07-19 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('420', '1', '2018-07-10 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('421', '1', '2018-07-07 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('422', '2', '2018-07-08 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('423', '4', '2018-07-19 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('424', '4', '2018-07-08 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('425', '4', '2018-07-14 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('426', '2', '2018-07-19 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('427', '3', '2018-07-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('428', '1', '2018-07-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('429', '4', '2018-08-12 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('430', '2', '2018-08-04 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('431', '3', '2018-08-03 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('432', '4', '2018-08-18 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('433', '2', '2018-08-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('434', '4', '2018-08-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('435', '2', '2018-08-06 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('436', '2', '2018-08-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('437', '2', '2018-08-17 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('438', '1', '2018-09-04 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('439', '2', '2018-09-15 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('440', '2', '2018-09-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('441', '1', '2018-09-20 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('442', '3', '2018-09-01 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('443', '2', '2018-09-25 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('444', '3', '2018-09-10 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('445', '1', '2018-09-20 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('446', '3', '2018-09-09 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('447', '4', '2018-09-11 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('448', '1', '2018-10-09 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('449', '2', '2018-10-00 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('450', '2', '2018-10-13 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('451', '1', '2018-10-24 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('452', '1', '2018-10-24 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('453', '1', '2018-10-10 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('454', '4', '2018-10-27 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('455', '4', '2018-10-09 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('456', '3', '2018-10-14 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('457', '3', '2018-10-21 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('458', '4', '2018-11-26 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('459', '3', '2018-11-23 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('460', '2', '2018-11-03 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('461', '4', '2018-11-18 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('462', '2', '2018-11-09 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('463', '3', '2018-11-22 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('464', '2', '2018-11-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('465', '2', '2018-11-09 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('466', '4', '2018-11-23 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('467', '1', '2018-11-24 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('468', '2', '2018-12-03 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('469', '4', '2018-12-17 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('470', '4', '2018-12-15 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('471', '2', '2018-12-18 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('472', '4', '2018-12-10 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('473', '2', '2018-12-20 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('474', '4', '2018-12-24 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('475', '1', '2018-12-16 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('476', '1', '2018-12-14 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('477', '3', '2018-12-27 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('478', '2', '2018-01-19 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('479', '1', '2018-01-26 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('480', '4', '2018-01-11 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('481', '1', '2018-01-18 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('482', '4', '2018-01-15 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('483', '2', '2018-01-04 00:00:00', '500', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('484', '1', '2018-01-03 00:00:00', '1000', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('485', '4', '2018-01-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('486', '2', '2018-01-12 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('487', '2', '2018-01-05 00:00:00', '300', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('488', '4', '2018-07-19 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('489', '1', '2018-07-10 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('490', '1', '2018-07-07 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('491', '2', '2018-07-08 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('492', '4', '2018-07-19 00:00:00', '500', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('493', '4', '2018-07-08 00:00:00', '600', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('494', '4', '2018-07-14 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('495', '2', '2018-07-19 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('496', '3', '2018-07-02 00:00:00', '1000', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('497', '1', '2018-07-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('498', '4', '2018-08-12 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('499', '2', '2018-08-04 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('500', '3', '2018-08-03 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('501', '4', '2018-08-18 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('502', '2', '2018-08-05 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('503', '4', '2018-08-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('504', '2', '2018-08-06 00:00:00', '800', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('505', '2', '2018-08-05 00:00:00', '600', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('506', '2', '2018-08-17 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('507', '1', '2018-09-04 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('508', '2', '2018-09-15 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('509', '2', '2018-09-02 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('510', '1', '2018-09-20 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('511', '3', '2018-09-01 00:00:00', '300', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('512', '2', '2018-09-25 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('513', '3', '2018-09-10 00:00:00', '200', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('514', '1', '2018-09-20 00:00:00', '500', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('515', '3', '2018-09-09 00:00:00', '600', null, null, null, null, null);
INSERT INTO `gathering` VALUES ('516', '4', '2018-09-11 00:00:00', '200', null, null, null, null, null);

-- ----------------------------
-- Table structure for growthstate
-- ----------------------------
DROP TABLE IF EXISTS `growthstate`;
CREATE TABLE `growthstate` (
  `growthStateID` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`growthStateID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of growthstate
-- ----------------------------
INSERT INTO `growthstate` VALUES ('1', '幼年期', '猪只幼年的时候');
INSERT INTO `growthstate` VALUES ('2', '育肥期', '猪只育肥的时候');

-- ----------------------------
-- Table structure for hogcote
-- ----------------------------
DROP TABLE IF EXISTS `hogcote`;
CREATE TABLE `hogcote` (
  `hogcoteNo` varchar(9) NOT NULL,
  `upperLimit` int(11) DEFAULT NULL,
  `area` decimal(9,2) DEFAULT NULL,
  `curPigNumber` int(11) DEFAULT NULL,
  `pigstyNo` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`hogcoteNo`),
  KEY `hogcote_fk_01_idx` (`pigstyNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hogcote
-- ----------------------------
INSERT INTO `hogcote` VALUES ('1', '10', '12.00', '8', '1');
INSERT INTO `hogcote` VALUES ('2', '10', '12.00', '7', '1');

-- ----------------------------
-- Table structure for hurdlecondition
-- ----------------------------
DROP TABLE IF EXISTS `hurdlecondition`;
CREATE TABLE `hurdlecondition` (
  `hurdleConditionID` int(11) NOT NULL,
  `growthStateID` int(11) NOT NULL,
  `days` int(11) NOT NULL COMMENT '天数',
  PRIMARY KEY (`hurdleConditionID`),
  KEY `hurdlecondition_fk_01_idx` (`growthStateID`),
  CONSTRAINT `hurdlecondition_fk_01` FOREIGN KEY (`growthStateID`) REFERENCES `growthstate` (`growthStateID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hurdlecondition
-- ----------------------------

-- ----------------------------
-- Table structure for hurdlerecord
-- ----------------------------
DROP TABLE IF EXISTS `hurdlerecord`;
CREATE TABLE `hurdlerecord` (
  `hurdleRecordID` bigint(20) NOT NULL,
  `time` datetime NOT NULL COMMENT '转栏时间',
  `pigNo` varchar(32) NOT NULL,
  `growthStateID` int(11) NOT NULL,
  `inHogcoteNo` varchar(9) DEFAULT NULL,
  `outHogcoteNo` varchar(9) DEFAULT NULL,
  `userNo` varchar(32) NOT NULL COMMENT '操作人',
  `description` varchar(100) DEFAULT NULL COMMENT '注释',
  `outPrice` decimal(9,2) DEFAULT NULL COMMENT '如果是出栏出售,此处为出栏价格',
  `outPlace` varchar(30) DEFAULT NULL COMMENT '如果是出栏出售,此处记录出售地',
  PRIMARY KEY (`hurdleRecordID`),
  KEY `hurdlerecord_idx` (`pigNo`),
  KEY `hurdlerecord_fk_01_idx` (`growthStateID`),
  KEY `hurdlerecord_fk_03_idx` (`inHogcoteNo`,`outHogcoteNo`),
  KEY `hurdlerecord_fk_05_idx` (`userNo`),
  KEY `hurdlerecord_fk_02_idx` (`outHogcoteNo`),
  CONSTRAINT `hurdlerecord_fk_01` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hurdlerecord_fk_02` FOREIGN KEY (`outHogcoteNo`) REFERENCES `hogcote` (`hogcoteNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hurdlerecord_fk_03` FOREIGN KEY (`inHogcoteNo`) REFERENCES `hogcote` (`hogcoteNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hurdlerecord_fk_04` FOREIGN KEY (`growthStateID`) REFERENCES `growthstate` (`growthStateID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `hurdlerecord_fk_05` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hurdlerecord
-- ----------------------------

-- ----------------------------
-- Table structure for inoculationrecord
-- ----------------------------
DROP TABLE IF EXISTS `inoculationrecord`;
CREATE TABLE `inoculationrecord` (
  `inoculationRecordID` bigint(20) NOT NULL COMMENT '接种记录',
  `inoculationSetID` bigint(20) NOT NULL COMMENT '接种设定ID',
  `pigNo` varchar(32) NOT NULL,
  `time` datetime NOT NULL,
  `isInoculate` int(11) NOT NULL COMMENT '是否已经接种',
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`inoculationRecordID`),
  KEY `inoculationrecord_fk_01_idx` (`inoculationSetID`),
  KEY `inoculationrecord_fk_02_idx` (`pigNo`),
  CONSTRAINT `inoculationrecord_fk_01` FOREIGN KEY (`inoculationSetID`) REFERENCES `inoculationset` (`inoculationSetID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `inoculationrecord_fk_02` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inoculationrecord
-- ----------------------------

-- ----------------------------
-- Table structure for inoculationset
-- ----------------------------
DROP TABLE IF EXISTS `inoculationset`;
CREATE TABLE `inoculationset` (
  `inoculationSetID` bigint(20) NOT NULL,
  `drugTypeID` int(11) NOT NULL COMMENT '药种类',
  `inoculationTime` datetime NOT NULL COMMENT '接种时间',
  `unit` varchar(5) NOT NULL COMMENT '单位',
  `useCount` int(11) NOT NULL COMMENT '用量',
  `inoculationUserNo` varchar(32) NOT NULL COMMENT '接种人ID',
  `pigstyNo` varchar(9) NOT NULL COMMENT '猪舍编号',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`inoculationSetID`),
  KEY `inoculationset_fk_01_idx` (`drugTypeID`),
  KEY `inoculationset_fk_02_idx` (`inoculationUserNo`),
  KEY `inoculationset_fk_03_idx` (`pigstyNo`),
  CONSTRAINT `inoculationset_fk_01` FOREIGN KEY (`drugTypeID`) REFERENCES `drugtype` (`drugTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `inoculationset_fk_02` FOREIGN KEY (`inoculationUserNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `inoculationset_fk_03` FOREIGN KEY (`pigstyNo`) REFERENCES `pigsty` (`pigstyNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inoculationset
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `logID` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `trueName` varchar(32) NOT NULL,
  `operationName` varchar(50) NOT NULL,
  `ipAddress` varchar(20) NOT NULL,
  PRIMARY KEY (`logID`)
) ENGINE=InnoDB AUTO_INCREMENT=371 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '2018-10-25 13:41:35', 'hxp', '操作一', '12345');
INSERT INTO `log` VALUES ('2', '2018-10-29 19:20:41', 'abc', 'abc', '1234679');
INSERT INTO `log` VALUES ('17', '2018-10-30 15:12:48', 'hxp', 'loadUsersAudit', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('18', '2018-10-30 15:16:34', '小明', 'loadUsersAudit', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('19', '2018-10-30 15:17:49', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('20', '2018-10-30 15:17:49', '小明', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('21', '2018-10-30 15:31:21', '小明', 'loadUsersAudit', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('22', '2018-11-01 15:18:42', 'hxp', 'loadUsersAudit', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('23', '2018-11-01 15:41:29', 'hxp', 'loadUsersAudit', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('24', '2018-11-01 16:22:48', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('25', '2018-11-01 16:22:49', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('26', '2018-11-01 16:22:49', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('27', '2018-11-01 16:22:49', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('28', '2018-11-01 16:22:49', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('29', '2018-11-01 16:22:49', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('30', '2018-11-01 16:22:50', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('31', '2018-11-01 16:22:50', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('32', '2018-11-01 16:22:50', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('33', '2018-11-01 16:24:56', 'hxp', 'loadUsersAudit', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('34', '2018-11-01 18:34:54', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('35', '2018-11-01 18:34:55', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('36', '2018-11-01 18:34:55', 'hxp', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('37', '2018-11-11 12:42:47', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('38', '2018-11-11 12:42:55', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('39', '2018-11-11 12:51:03', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('40', '2018-11-11 12:51:07', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('41', '2018-11-11 12:53:15', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('42', '2018-11-11 12:53:34', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('43', '2018-11-13 17:06:06', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('44', '2018-11-13 17:06:17', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('45', '2018-11-13 17:06:31', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('46', '2018-11-13 17:12:09', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('47', '2018-11-13 17:12:11', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('48', '2018-11-13 17:12:13', 'mmmm', 'sowFen', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('49', '2018-11-13 17:29:47', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('50', '2018-11-13 17:31:11', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('51', '2018-11-13 18:30:14', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('52', '2018-11-13 18:31:35', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('53', '2018-11-13 18:35:01', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('54', '2018-11-13 18:35:11', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('55', '2018-11-13 18:38:56', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('56', '2018-11-13 18:38:59', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('57', '2018-11-13 18:46:22', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('58', '2018-11-13 19:04:36', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('59', '2018-11-13 19:06:00', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('60', '2018-11-13 19:08:16', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('61', '2018-11-13 19:09:05', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('62', '2018-11-13 19:09:52', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('63', '2018-11-13 19:10:28', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('64', '2018-11-13 19:11:02', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('65', '2018-11-13 19:11:50', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('66', '2018-11-13 19:21:47', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('67', '2018-11-13 19:23:26', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('68', '2018-11-13 19:38:24', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('69', '2018-11-13 19:38:45', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('70', '2018-11-13 20:25:59', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('71', '2018-11-13 20:26:36', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('72', '2018-11-13 20:27:19', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('73', '2018-11-13 20:27:19', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('74', '2018-11-13 20:38:48', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('75', '2018-11-13 20:38:51', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('76', '2018-11-13 20:44:12', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('77', '2018-11-13 20:45:13', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('78', '2018-11-13 20:45:32', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('79', '2018-11-13 20:46:11', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('80', '2018-11-13 20:46:15', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('81', '2018-11-13 20:46:15', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('82', '2018-11-13 20:46:16', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('83', '2018-11-13 20:47:14', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('84', '2018-11-13 20:47:17', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('85', '2018-11-13 20:47:18', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('86', '2018-11-13 20:47:39', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('87', '2018-11-13 20:48:19', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('88', '2018-11-13 20:50:09', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('89', '2018-11-13 20:50:13', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('90', '2018-11-13 20:50:29', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('91', '2018-11-13 20:51:05', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('92', '2018-11-13 20:51:55', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('93', '2018-11-13 20:51:56', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('94', '2018-11-13 20:52:02', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('95', '2018-11-13 20:52:48', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('96', '2018-11-13 20:57:56', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('97', '2018-11-13 20:59:22', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('98', '2018-11-13 21:04:31', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('99', '2018-11-13 21:05:45', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('100', '2018-11-13 21:05:52', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('101', '2018-11-13 21:05:53', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('102', '2018-11-13 21:07:07', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('103', '2018-11-13 21:07:08', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('104', '2018-11-13 21:08:21', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('105', '2018-11-13 21:08:30', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('106', '2018-11-13 21:08:32', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('107', '2018-11-13 21:08:56', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('108', '2018-11-13 21:09:19', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('109', '2018-11-13 21:09:43', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('110', '2018-11-13 21:09:43', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('111', '2018-11-13 21:09:43', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('112', '2018-11-13 21:09:53', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('113', '2018-11-13 21:10:55', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('114', '2018-11-13 21:21:31', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('115', '2018-11-13 21:21:44', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('116', '2018-11-13 21:22:06', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('117', '2018-11-13 21:22:26', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('118', '2018-11-13 21:22:45', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('119', '2018-11-13 21:23:07', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('120', '2018-11-13 21:24:28', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('121', '2018-11-13 21:24:30', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('122', '2018-11-13 21:25:03', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('123', '2018-11-13 21:25:42', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('124', '2018-11-13 21:25:44', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('125', '2018-11-13 21:25:51', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('126', '2018-11-13 21:26:13', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('127', '2018-11-13 21:26:13', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('128', '2018-11-13 21:27:03', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('129', '2018-11-13 21:27:25', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('130', '2018-11-14 18:00:45', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('131', '2018-11-14 18:00:58', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('132', '2018-11-14 18:00:59', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('133', '2018-11-14 18:01:14', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('134', '2018-11-14 18:01:15', 'mmmm', 'sowFen', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('135', '2018-11-14 18:01:16', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('136', '2018-11-14 18:01:16', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('137', '2018-11-14 18:01:16', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('138', '2018-11-14 18:01:17', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('139', '2018-11-14 18:01:17', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('140', '2018-11-14 18:01:17', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('141', '2018-11-14 18:01:17', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('142', '2018-11-14 18:01:48', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('143', '2018-11-14 18:03:10', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('144', '2018-11-14 18:08:51', 'mmmm', 'sowFen', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('145', '2018-11-14 18:09:11', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('146', '2018-11-14 18:10:02', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('147', '2018-11-14 18:10:03', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('148', '2018-11-14 18:10:22', 'mmmm', 'sowDuan', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('149', '2018-11-14 18:10:25', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('150', '2018-11-14 18:10:25', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('151', '2018-11-14 18:10:25', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('152', '2018-11-14 18:10:25', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('153', '2018-11-14 18:10:25', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('154', '2018-11-14 18:10:33', 'mmmm', 'sowFen', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('155', '2018-11-14 18:10:35', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('156', '2018-11-14 18:11:19', 'mmmm', 'equipmentRecord', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('157', '2018-11-14 18:11:58', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('158', '2018-11-14 18:11:58', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('159', '2018-11-14 18:11:58', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('160', '2018-11-15 21:00:57', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('161', '2018-11-15 21:00:57', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('162', '2018-11-15 21:01:06', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('163', '2018-11-15 21:01:06', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('164', '2018-11-15 21:02:04', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('165', '2018-11-15 21:02:04', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('166', '2018-11-15 21:02:37', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('167', '2018-11-15 21:02:37', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('168', '2018-11-15 21:03:25', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('169', '2018-11-15 21:03:25', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('170', '2018-11-15 21:03:27', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('171', '2018-11-15 21:03:27', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('172', '2018-11-15 21:03:44', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('173', '2018-11-15 21:03:44', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('174', '2018-11-15 21:05:11', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('175', '2018-11-15 21:05:11', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('176', '2018-11-15 21:08:30', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('177', '2018-11-15 21:08:30', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('178', '2018-11-15 21:10:53', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('179', '2018-11-15 21:10:53', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('180', '2018-11-15 21:12:28', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('181', '2018-11-15 21:17:44', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('182', '2018-11-15 21:17:44', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('183', '2018-11-15 21:20:59', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('184', '2018-11-15 21:20:59', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('185', '2018-11-15 21:22:37', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('186', '2018-11-15 21:24:12', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('187', '2018-11-15 21:24:12', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('188', '2018-11-15 21:24:26', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('189', '2018-11-15 21:34:52', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('190', '2018-11-15 21:34:52', 'mmmm', 'queryEquipmentState', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('191', '2018-11-15 21:34:52', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('192', '2018-11-15 21:35:39', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('193', '2018-11-15 21:35:39', 'mmmm', 'queryThreshold', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('194', '2018-11-15 21:35:44', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('195', '2018-11-15 21:35:44', 'mmmm', 'queryException', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('196', '2018-11-15 21:35:47', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('197', '2018-11-15 21:35:47', 'mmmm', 'querySensorData', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('198', '2018-11-15 21:35:49', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('199', '2018-11-15 21:35:49', 'mmmm', 'queryThreshold', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('200', '2018-11-15 21:35:51', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('201', '2018-11-15 21:35:51', 'mmmm', 'queryException', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('202', '2018-11-15 21:37:14', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('203', '2018-11-15 21:37:15', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('204', '2018-11-15 21:37:15', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('205', '2018-11-15 21:37:15', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('206', '2018-11-15 21:37:15', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('207', '2018-11-15 21:39:21', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('208', '2018-11-15 21:39:22', 'mmmm', 'querySensorData', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('209', '2018-11-15 21:39:24', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('210', '2018-11-15 21:39:24', 'mmmm', 'queryException', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('211', '2018-11-20 16:47:07', 'mmmm', 'comment', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('212', '2018-11-20 16:48:01', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('213', '2018-11-20 17:00:57', 'mmmm', 'sowPei', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('214', '2018-11-20 17:01:10', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('215', '2018-11-20 17:55:42', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('216', '2018-11-20 17:55:42', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('217', '2018-11-20 17:56:32', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('218', '2018-11-20 17:57:50', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('219', '2018-11-20 17:57:50', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('220', '2018-11-20 17:58:29', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('221', '2018-11-20 17:58:29', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('222', '2018-11-20 17:58:31', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('223', '2018-11-20 17:58:31', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('224', '2018-11-20 17:59:43', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('225', '2018-11-20 17:59:43', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('226', '2018-11-20 18:01:55', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('227', '2018-11-20 18:01:55', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('228', '2018-11-20 18:02:42', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('229', '2018-11-20 18:03:32', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('230', '2018-11-20 18:03:32', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('231', '2018-11-20 18:03:34', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('232', '2018-11-20 18:03:57', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('233', '2018-11-20 18:03:57', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('234', '2018-11-20 18:04:26', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('235', '2018-11-20 18:06:38', 'mmmm', 'searchGetInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('236', '2018-11-20 18:06:52', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('237', '2018-11-20 18:09:39', 'mmmm', 'searchGetInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('238', '2018-11-20 18:09:40', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('239', '2018-11-20 18:09:40', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('240', '2018-11-20 18:10:10', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('241', '2018-11-20 18:10:10', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('242', '2018-11-20 18:10:52', 'mmmm', 'searchGetInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('243', '2018-11-20 18:11:12', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('244', '2018-11-20 18:14:25', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('245', '2018-11-20 18:14:25', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('246', '2018-11-20 18:14:41', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('247', '2018-11-20 18:16:16', 'mmmm', 'searchGetInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('248', '2018-11-20 18:16:36', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('249', '2018-11-20 18:16:38', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('250', '2018-11-20 18:16:38', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('251', '2018-11-20 18:16:40', 'mmmm', 'searchGetInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('252', '2018-11-20 18:16:47', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('253', '2018-11-20 18:16:47', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('254', '2018-11-20 18:17:54', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('255', '2018-11-20 18:17:54', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('256', '2018-11-20 18:17:55', 'mmmm', 'searchGetInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('257', '2018-11-20 18:17:59', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('258', '2018-11-20 18:18:00', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('259', '2018-11-20 18:18:12', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('260', '2018-11-20 18:18:12', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('261', '2018-11-20 18:18:13', 'mmmm', 'searchGetInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('262', '2018-11-20 18:18:21', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('263', '2018-11-20 18:18:21', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('264', '2018-11-20 18:18:22', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('265', '2018-11-20 18:18:22', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('266', '2018-11-20 18:18:31', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('267', '2018-11-20 18:18:37', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('268', '2018-11-20 18:18:37', 'mmmm', 'paymentInsert', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('269', '2018-11-20 18:18:37', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('270', '2018-11-20 18:18:52', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('271', '2018-11-20 18:19:04', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('272', '2018-11-20 18:19:04', 'mmmm', 'paymentInsert', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('273', '2018-11-20 18:19:04', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('274', '2018-11-20 18:19:23', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('275', '2018-11-20 18:21:56', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('276', '2018-11-20 18:21:56', 'mmmm', 'paymentInsert', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('277', '2018-11-20 18:21:56', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('278', '2018-11-20 18:21:59', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('279', '2018-11-20 18:25:06', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('280', '2018-11-20 18:25:35', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('281', '2018-11-20 18:25:35', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('282', '2018-11-20 18:25:42', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('283', '2018-11-20 18:25:55', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('284', '2018-11-20 18:25:55', 'mmmm', 'paymentInsert', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('285', '2018-11-20 18:25:55', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('286', '2018-11-20 18:26:14', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('287', '2018-11-20 18:29:44', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('288', '2018-11-20 18:29:44', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('289', '2018-11-20 18:30:13', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('290', '2018-11-20 18:32:09', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('291', '2018-11-20 18:32:09', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('292', '2018-11-20 18:32:29', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('293', '2018-11-20 18:32:43', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('294', '2018-11-20 18:32:43', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('295', '2018-11-20 18:32:50', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('296', '2018-11-20 18:32:58', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('297', '2018-11-20 18:32:58', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('298', '2018-11-20 18:33:05', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('299', '2018-11-20 18:33:05', 'mmmm', 'paymentDownloadExcel', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('300', '2018-11-20 18:33:11', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('301', '2018-11-20 18:33:11', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('302', '2018-11-20 18:33:50', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('303', '2018-11-20 18:33:50', 'mmmm', 'paymentDownloadPDF', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('304', '2018-11-20 18:34:03', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('305', '2018-11-20 18:35:27', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('306', '2018-11-20 18:35:27', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('307', '2018-11-20 18:35:30', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('308', '2018-11-20 18:35:30', 'mmmm', 'paymentDownloadPDF', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('309', '2018-11-20 18:35:38', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('310', '2018-11-20 18:35:38', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('311', '2018-11-20 18:35:48', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('312', '2018-11-20 18:35:49', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('313', '2018-11-20 18:35:51', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('314', '2018-11-20 18:35:51', 'mmmm', 'paymentDownloadPDF', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('315', '2018-11-20 18:35:59', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('316', '2018-11-20 18:35:59', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('317', '2018-11-20 18:37:04', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('318', '2018-11-20 18:37:04', 'mmmm', 'paymentUpdate', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('319', '2018-11-20 18:37:04', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('320', '2018-11-20 18:37:13', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('321', '2018-11-20 18:37:29', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('322', '2018-11-20 18:37:29', 'mmmm', 'paymentSelect', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('323', '2018-11-20 18:37:29', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('324', '2018-11-20 18:37:29', 'mmmm', 'query', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('325', '2018-11-20 18:37:45', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('326', '2018-11-20 18:40:49', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('327', '2018-11-20 18:40:49', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('328', '2018-11-20 18:41:05', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('329', '2018-11-20 18:47:34', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('330', '2018-11-20 18:47:34', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('331', '2018-11-20 18:47:51', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('332', '2018-11-20 18:47:51', 'mmmm', 'paymentSelect', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('333', '2018-11-20 18:47:51', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('334', '2018-11-20 18:47:51', 'mmmm', 'query', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('335', '2018-11-20 18:47:53', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('336', '2018-11-20 18:47:53', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('337', '2018-11-20 18:48:40', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('338', '2018-11-20 18:48:40', 'mmmm', 'paymentSelect', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('339', '2018-11-20 18:48:40', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('340', '2018-11-20 18:48:40', 'mmmm', 'query', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('341', '2018-11-20 18:48:56', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('342', '2018-11-20 18:49:03', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('343', '2018-11-20 18:49:03', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('344', '2018-11-20 18:49:37', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('345', '2018-11-20 18:49:58', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('346', '2018-11-20 18:49:58', 'mmmm', 'searchPayInformation', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('347', '2018-11-20 18:50:04', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('348', '2018-11-20 18:50:04', 'mmmm', 'paymentSelect', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('349', '2018-11-20 18:50:04', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('350', '2018-11-20 18:50:04', 'mmmm', 'query', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('351', '2018-11-20 18:50:09', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('352', '2018-11-20 18:50:09', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('353', '2018-11-20 18:51:32', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('354', '2018-11-20 18:51:32', 'mmmm', 'paymentSelect', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('355', '2018-11-20 18:51:32', 'mmmm', 'getMap', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('356', '2018-11-20 18:51:32', 'mmmm', 'query', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('357', '2018-11-20 18:51:53', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('358', '2018-11-21 15:57:34', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('359', '2018-11-21 15:57:35', 'mmmm', 'comment', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('360', '2018-11-21 15:57:40', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('361', '2018-11-21 15:58:09', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('362', '2018-11-21 15:58:09', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('363', '2018-11-21 15:59:19', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('364', '2018-11-21 15:59:19', 'mmmm', 'comment', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('365', '2018-11-21 15:59:20', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('366', '2018-11-21 15:59:32', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('367', '2018-11-21 15:59:32', 'mmmm', 'finalize', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('368', '2018-11-21 16:01:09', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('369', '2018-11-21 16:01:09', 'mmmm', 'comment', '0:0:0:0:0:0:0:1');
INSERT INTO `log` VALUES ('370', '2018-11-21 16:01:11', 'mmmm', 'setReq_rep', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuID` int(20) NOT NULL AUTO_INCREMENT,
  `userNo` varchar(32) NOT NULL,
  `menuName` varchar(50) NOT NULL,
  `label` varchar(30) NOT NULL,
  PRIMARY KEY (`menuID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '111111', '设备管理', 'zmdi zmdi-accounts-list');
INSERT INTO `menu` VALUES ('2', '111111', '猪只管理', 'zmdi zmdi-accounts');
INSERT INTO `menu` VALUES ('3', '111111', '库存管理', 'zmdi zmdi-more');
INSERT INTO `menu` VALUES ('4', '111111', '养护结算', 'fa fa-hand-lizard-o');
INSERT INTO `menu` VALUES ('5', '111111', '母猪管理', 'fa fa-child');
INSERT INTO `menu` VALUES ('6', '123456', '算法管理', 'glyphicon glyphicon-book');
INSERT INTO `menu` VALUES ('7', '123456', '用户管理', 'glyphicon glyphicon-user');
INSERT INTO `menu` VALUES ('8', '123456', '维护与安全管理', 'zmdi zmdi-lock-outline');

-- ----------------------------
-- Table structure for menuitem
-- ----------------------------
DROP TABLE IF EXISTS `menuitem`;
CREATE TABLE `menuitem` (
  `menuItemID` int(20) NOT NULL AUTO_INCREMENT,
  `userNo` varchar(32) NOT NULL,
  `menuID` int(20) NOT NULL,
  `itemName` varchar(50) NOT NULL,
  `labelId` varchar(20) NOT NULL,
  `targetPage` varchar(30) NOT NULL,
  `serviceURL` varchar(900) NOT NULL,
  PRIMARY KEY (`menuItemID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menuitem
-- ----------------------------
INSERT INTO `menuitem` VALUES ('1', '111111', '1', '设备运行控制', 'equiOperCont', 'dataList.html', '/IntelligentSystem/api/RXF1aXBtZW50TWFuYWdlU2VydmljZTpxdWVyeUVxdWlwbWVudFN0YXRl?start=0&num=10');
INSERT INTO `menuitem` VALUES ('2', '111111', '1', '传感器管理', 'sensMana', 'dataList.html', '/IntelligentSystem/api/RXF1aXBtZW50TWFuYWdlU2VydmljZTpxdWVyeVNlbnNvckRhdGE=?start=0&num=10');
INSERT INTO `menuitem` VALUES ('3', '111111', '1', '环控设备管理', 'deviExceInfoChec', 'dataList.html', '/IntelligentSystem/api/RXF1aXBtZW50TWFuYWdlU2VydmljZTpxdWVyeVRocmVzaG9sZA==?start=0&num=10');
INSERT INTO `menuitem` VALUES ('4', '111111', '1', '设备异常信息查看', 'enviContEquiMana', 'dataList.html', '/IntelligentSystem/api/RXF1aXBtZW50TWFuYWdlU2VydmljZTpxdWVyeUV4Y2VwdGlvbg==?start=0&num=10');
INSERT INTO `menuitem` VALUES ('5', '111111', '2', '生长情况标准设置', 'stanSett', 'dataList.html', '/IntelligentSystem/api/UGlnR3Jvd3RoU2VydmljZTpzZXRHcm93dGhTdGFuZGFyZA');
INSERT INTO `menuitem` VALUES ('6', '111111', '2', '生长情况统计', 'equiOperCont', 'dataList.html', '/IntelligentSystem/api/R3Jvd3RoU3RhdGlzdGljc1NlcnZpY2U6Z3Jvd3RoU3RhdGlzdHVjcw');
INSERT INTO `menuitem` VALUES ('7', '111111', '2', '疑似生病统计', 'suspIllnStat', 'dataList.html', '/IntelligentSystem/api/UGlnRG91YnRmdWxJbGw6ZG91YnRmdWxJbGw');
INSERT INTO `menuitem` VALUES ('9', '111111', '2', '饲喂管理', 'feedMana', 'dataList.html', '/IntelligentSystem/api/UGlnRmVlZFNldFNlcnZpY2U6c2V0RmVlZGluZw');
INSERT INTO `menuitem` VALUES ('10', '111111', '2', '配方搭配', 'formColl', 'dataList.html', '/IntelligentSystem/api/UGlnRmVlZEZvcm11bGFTZXJ2aWNlOnNldEZvcm11bGE');
INSERT INTO `menuitem` VALUES ('13', '111111', '2', '猪只信息管理', 'pigInfoMana', 'dataList.html', '/IntelligentSystem/api/UGlnSW5mb3JtYXRpb246cGlnSW5mb3JtYXRpb24');
INSERT INTO `menuitem` VALUES ('14', '111111', '4', '付款', 'payment', 'dataList.html', '/IntelligentSystem/api/UGF5bWVudFNlcnZpY2U6c2VhcmNoUGF5SW5mb3JtYXRpb24');
INSERT INTO `menuitem` VALUES ('15', '111111', '2', '疫苗接种设置', 'vaccSett', 'dataList.html', '/IntelligentSystem/api/UGlnU2FmZU1hbmFnZVNlcnZpY2U6aW5vY3VsYXRpb25TZXQ');
INSERT INTO `menuitem` VALUES ('16', '111111', '2', '饲喂统计', 'feedsum', 'dataList.html', '/IntelligentSystem/api/UGlnSW5mb3JtYXRpb246aW5pdFBpZ0luZm9ybWF0aW9u');
INSERT INTO `menuitem` VALUES ('17', '111111', '2', '疾病管理', 'diseMana', 'dataList.html', '/IntelligentSystem/api/RGlzZWFzZVRyZWF0bWVudFNlcnZpY2U6ZGlzZWFzZVRyZWF0bWVudA');
INSERT INTO `menuitem` VALUES ('18', '111111', '2', '销毁管理', 'destMana', 'dataList.html', '/IntelligentSystem/api/RGVzdHJveVNlcnZpY2U6d2lsbERlc3Ryb3k');
INSERT INTO `menuitem` VALUES ('19', '111111', '2', '移栏管理', 'migrMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('20', '111111', '2', '入栏管理', 'entrMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('21', '111111', '2', '出栏管理', 'coluMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('22', '111111', '3', '设备记录', 'formColl1', 'dataList.html', '/IntelligentSystem/api/RXF1aXBtZW50UmVjb3JkU2VydmljZTpzZXRFcXVpcG1lbnRSZWNvcmQ=');
INSERT INTO `menuitem` VALUES ('23', '111111', '3', '饲料记录', 'formColl2', 'dataList.html', '/IntelligentSystem/api/RmVlZFJlY29yZFNlcnZpY2U6c2V0RmVlZFJlY29yZA==');
INSERT INTO `menuitem` VALUES ('24', '111111', '3', '药品记录', 'formColl3', 'dataList.html', '/IntelligentSystem/api/RHJ1Z1JlY29yZFNlcnZpY2U6c2V0RHJ1Z1JlY29yZA==');
INSERT INTO `menuitem` VALUES ('26', '111111', '5', '母猪配种管理', 'sowBree', 'dataList.html', '/IntelligentSystem/api/U293UGVpU2VydmljZTpzZXRTb3dQZWk=');
INSERT INTO `menuitem` VALUES ('27', '111111', '5', '母猪断奶管理', 'weanCont', 'dataList.html', '/IntelligentSystem/api/U293RHVhblNlcnZpY2U6c2V0U293RHVhbg==');
INSERT INTO `menuitem` VALUES ('28', '111111', '5', '母猪分娩管理', 'sowsDeli', 'dataList.html', '/IntelligentSystem/api/U293RmVuU2VydmljZTpzZXRTb3dGZW4=');
INSERT INTO `menuitem` VALUES ('29', '123456', '6', '算法管理', 'algoMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('30', '123456', '7', '用户审核', 'userAudiActiDiag', 'dataList.html', '/IntelligentSystem/api/VXNlclNlcnZpY2U6bG9hZFVzZXJzQXVkaXQ=');
INSERT INTO `menuitem` VALUES ('31', '123456', '7', '用户注销', 'userCanc', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('32', '123456', '8', '日志管理', 'rzgl', 'dataList.html', '/IntelligentSystem/api/TG9nTWFuYWdlOnF1ZXJ5TGlzdA==');
INSERT INTO `menuitem` VALUES ('33', '123456', '8', '权限管理', 'qxgl', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('34', '123456', '8', '数据库备份与恢复', 'sjk', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('36', '111111', '4', '收款', 'consSett2', 'dataList.html', '/IntelligentSystem/api/R2V0U2VydmljZTpzZWFyY2hHZXRJbmZvcm1hdGlvbg==');
INSERT INTO `menuitem` VALUES ('37', '111111', '4', '利润', 'consSett', 'echarts.html', '');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `paymentID` int(11) NOT NULL AUTO_INCREMENT COMMENT '付款单编号',
  `paymentType` int(11) DEFAULT NULL COMMENT '付款的类型',
  `paymentDate` datetime DEFAULT NULL COMMENT '付款时间',
  `orderNumber` int(11) DEFAULT NULL COMMENT '物品订单号',
  `money` double DEFAULT NULL COMMENT '金额',
  `serialNumber` varchar(50) DEFAULT NULL COMMENT '付款流水号',
  `paymentReason` text COMMENT '付款原因',
  `applicant` varchar(255) DEFAULT NULL COMMENT '订单申请人员',
  `manager` varchar(255) DEFAULT NULL COMMENT '处理人员',
  PRIMARY KEY (`paymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=6667 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', '1', '2018-07-12 00:00:00', '1', '1', '1', '1', '1', '1');
INSERT INTO `payment` VALUES ('5', '1', '2018-03-05 00:00:00', '1', '1', '1', '1', '1', '1');
INSERT INTO `payment` VALUES ('13', '3', '2018-10-02 18:44:48', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('14', '7', '2018-10-12 18:45:16', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('15', '4', '2018-08-08 19:19:13', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('23', '23', '2017-01-03 00:00:00', '23', '23', '23', '23', '23', '23');
INSERT INTO `payment` VALUES ('1006', '6', '2018-01-24 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1007', '2', '2018-01-27 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1008', '4', '2018-01-13 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1009', '2', '2018-01-20 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1010', '4', '2018-01-22 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1011', '2', '2018-01-24 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1012', '1', '2018-02-02 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1013', '7', '2018-02-03 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1014', '5', '2018-02-21 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1015', '4', '2018-02-19 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1016', '6', '2018-02-25 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1017', '7', '2018-03-23 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1018', '3', '2018-03-11 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1019', '1', '2018-03-11 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1020', '1', '2018-03-22 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1021', '2', '2018-03-16 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1022', '5', '2018-03-12 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1023', '2', '2018-04-17 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1024', '1', '2018-04-07 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1025', '2', '2018-04-04 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1026', '1', '2018-04-04 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1027', '6', '2018-04-03 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1028', '6', '2018-04-05 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1029', '1', '2018-05-23 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1030', '2', '2018-05-13 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1031', '4', '2018-05-09 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1032', '7', '2018-05-08 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1033', '5', '2018-05-12 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1034', '5', '2018-05-14 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1035', '2', '2018-06-01 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1036', '4', '2018-06-16 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1037', '5', '2018-06-09 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1038', '7', '2018-06-17 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1039', '1', '2018-06-27 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1040', '1', '2018-06-13 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1041', '2', '2018-07-25 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1042', '1', '2018-07-01 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1043', '5', '2018-07-18 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1044', '5', '2018-07-16 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1045', '3', '2018-07-08 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1046', '6', '2018-07-11 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1047', '1', '2018-08-18 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1048', '3', '2018-08-15 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1049', '1', '2018-08-02 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1050', '4', '2018-08-21 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1051', '1', '2018-08-23 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1052', '7', '2018-08-26 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1053', '5', '2018-09-27 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1054', '3', '2018-09-07 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1055', '3', '2018-09-15 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1056', '1', '2018-09-05 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1057', '3', '2018-09-23 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1058', '4', '2018-09-15 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1059', '5', '2018-10-09 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1060', '2', '2018-10-02 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1061', '5', '2018-10-10 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1062', '2', '2018-10-09 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1063', '2', '2018-10-21 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1064', '7', '2018-10-09 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1065', '4', '2018-11-07 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1066', '2', '2018-11-14 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1067', '5', '2018-11-06 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1068', '3', '2018-11-02 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1069', '1', '2018-11-00 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1070', '5', '2018-11-15 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1071', '1', '2018-12-08 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1072', '1', '2018-12-11 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1073', '7', '2018-12-04 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1074', '6', '2018-12-24 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1075', '1', '2018-12-09 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('1076', '6', '2018-12-17 00:00:00', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('4444', '4', '2018-09-19 00:00:00', '4', '4', '4', '4', '4', '4');
INSERT INTO `payment` VALUES ('6666', '1', '2017-02-02 00:00:00', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for pig
-- ----------------------------
DROP TABLE IF EXISTS `pig`;
CREATE TABLE `pig` (
  `pigNo` varchar(32) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthTime` datetime DEFAULT NULL,
  `pigTypeID` int(11) DEFAULT NULL,
  `growthStateID` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `fatherNo` varchar(32) DEFAULT NULL,
  `motherNo` varchar(32) DEFAULT NULL,
  `orignPlace` varchar(50) DEFAULT NULL COMMENT '产地',
  `hogcoteNo` varchar(9) DEFAULT NULL COMMENT '当前所在猪栏',
  PRIMARY KEY (`pigNo`),
  KEY `pig_fk_01_idx` (`pigTypeID`),
  KEY `pig_fk_02_idx` (`growthStateID`),
  KEY `pig_fk_03_idx` (`fatherNo`),
  KEY `pig_fk_04_idx` (`motherNo`),
  KEY `pig_fk_05_idx` (`hogcoteNo`),
  CONSTRAINT `pig_fk_01` FOREIGN KEY (`pigTypeID`) REFERENCES `pigtype` (`pigTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pig_fk_02` FOREIGN KEY (`growthStateID`) REFERENCES `growthstate` (`growthStateID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pig_fk_03` FOREIGN KEY (`fatherNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pig_fk_04` FOREIGN KEY (`motherNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pig_fk_05` FOREIGN KEY (`hogcoteNo`) REFERENCES `hogcote` (`hogcoteNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pig
-- ----------------------------
INSERT INTO `pig` VALUES ('1', '0', '0', null, '1', '1', '1', null, null, null, '1');
INSERT INTO `pig` VALUES ('2', '0', '0', null, '1', '1', '1', null, null, null, '1');

-- ----------------------------
-- Table structure for piggery
-- ----------------------------
DROP TABLE IF EXISTS `piggery`;
CREATE TABLE `piggery` (
  `piggeryNo` varchar(9) NOT NULL COMMENT '猪场编号',
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`piggeryNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of piggery
-- ----------------------------
INSERT INTO `piggery` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for pigstandard
-- ----------------------------
DROP TABLE IF EXISTS `pigstandard`;
CREATE TABLE `pigstandard` (
  `pigStandardID` int(11) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `pigTypeID` int(11) DEFAULT NULL,
  `growthStateID` int(11) DEFAULT NULL,
  `addWeight` int(11) DEFAULT NULL COMMENT '日增重',
  `upperLimit` int(11) DEFAULT NULL,
  `lowerLimit` int(11) DEFAULT NULL COMMENT '下限',
  `date` datetime DEFAULT NULL,
  `timeInterval` int(11) DEFAULT NULL COMMENT '时间间隔',
  PRIMARY KEY (`pigStandardID`),
  KEY `pigstandard_fk_01_idx` (`pigTypeID`),
  KEY `pigstandard_fk_02_idx` (`growthStateID`),
  CONSTRAINT `pigstandard_fk_01` FOREIGN KEY (`pigTypeID`) REFERENCES `pigtype` (`pigTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pigstandard_fk_02` FOREIGN KEY (`growthStateID`) REFERENCES `growthstate` (`growthStateID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pigstandard
-- ----------------------------
INSERT INTO `pigstandard` VALUES ('1', '1', '1', '1', '5', '1', '1', '2016-12-11 11:12:23', '3');
INSERT INTO `pigstandard` VALUES ('2', '0', '1', '1', '1', '1', '1', null, '1');
INSERT INTO `pigstandard` VALUES ('3', '1', '1', '2', '1', '1', '1', null, '2');

-- ----------------------------
-- Table structure for pigsty
-- ----------------------------
DROP TABLE IF EXISTS `pigsty`;
CREATE TABLE `pigsty` (
  `pigstyNo` varchar(9) NOT NULL COMMENT '猪舍编号',
  `type` varchar(30) DEFAULT NULL COMMENT '猪舍的类型,比如有公猪舍,...',
  `number` int(11) DEFAULT NULL COMMENT '猪栏数量',
  `area` decimal(7,2) DEFAULT NULL COMMENT '面积',
  `piggeryNo` varchar(9) DEFAULT NULL COMMENT '当前猪舍所在猪场',
  `pigTypeID` int(11) DEFAULT NULL,
  `growthStageID` int(11) DEFAULT NULL,
  PRIMARY KEY (`pigstyNo`),
  KEY `pigsty_fk_01_idx` (`piggeryNo`),
  KEY `pigsty_fk_02_idx` (`growthStageID`),
  KEY `pigsty_fk_03_idx` (`pigTypeID`),
  CONSTRAINT `pigsty_fk_01` FOREIGN KEY (`piggeryNo`) REFERENCES `piggery` (`piggeryNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pigsty_fk_02` FOREIGN KEY (`growthStageID`) REFERENCES `growthstate` (`growthStateID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pigsty_fk_03` FOREIGN KEY (`pigTypeID`) REFERENCES `pigtype` (`pigTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pigsty
-- ----------------------------
INSERT INTO `pigsty` VALUES ('1', '1', null, null, '1', '1', '1');

-- ----------------------------
-- Table structure for pigtype
-- ----------------------------
DROP TABLE IF EXISTS `pigtype`;
CREATE TABLE `pigtype` (
  `pigTypeID` int(11) NOT NULL,
  `name` varchar(18) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pigTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pigtype
-- ----------------------------
INSERT INTO `pigtype` VALUES ('1', '黑猪', null);
INSERT INTO `pigtype` VALUES ('2', '白猪', null);

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `powerID` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `powerType` varchar(10) NOT NULL COMMENT '权限类型',
  PRIMARY KEY (`powerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------

-- ----------------------------
-- Table structure for prehurdlerecord
-- ----------------------------
DROP TABLE IF EXISTS `prehurdlerecord`;
CREATE TABLE `prehurdlerecord` (
  `preHurdleRecordID` bigint(20) NOT NULL COMMENT '转栏ID，主键，自增',
  `pigNo` varchar(32) NOT NULL,
  `time` datetime NOT NULL COMMENT '转栏时间',
  `startPigstyNo` varchar(9) NOT NULL,
  `startHogcoteNo` varchar(9) NOT NULL,
  `endPigstyNo` varchar(9) NOT NULL,
  `endHogcoteNo` varchar(9) NOT NULL,
  `operatorUserNo` varchar(32) NOT NULL COMMENT '操作人No',
  PRIMARY KEY (`preHurdleRecordID`),
  KEY `prehurdlerecord_fk_01_idx` (`pigNo`),
  KEY `prehurdlerecord_fk_02_idx` (`startPigstyNo`),
  KEY `prehurdlerecord_fk_03_idx` (`endPigstyNo`),
  KEY `prehurdlerecord_fk_06_idx` (`operatorUserNo`),
  KEY `prehurdlerecord_fk_04_idx` (`startHogcoteNo`,`endHogcoteNo`),
  KEY `prehurdlerecord_fk_08_idx` (`endHogcoteNo`),
  CONSTRAINT `prehurdlerecord_fk_01` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `prehurdlerecord_fk_02` FOREIGN KEY (`startPigstyNo`) REFERENCES `pigsty` (`pigstyNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `prehurdlerecord_fk_03` FOREIGN KEY (`endPigstyNo`) REFERENCES `pigsty` (`pigstyNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `prehurdlerecord_fk_06` FOREIGN KEY (`operatorUserNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `prehurdlerecord_fk_07` FOREIGN KEY (`startHogcoteNo`) REFERENCES `hogcote` (`hogcoteNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `prehurdlerecord_fk_08` FOREIGN KEY (`endHogcoteNo`) REFERENCES `hogcote` (`hogcoteNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prehurdlerecord
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleID` int(11) NOT NULL,
  `roleName` varchar(12) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_power
-- ----------------------------
DROP TABLE IF EXISTS `role_power`;
CREATE TABLE `role_power` (
  `ID` int(11) NOT NULL,
  `roleID` int(11) NOT NULL,
  `powerID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_power
-- ----------------------------

-- ----------------------------
-- Table structure for sowduan
-- ----------------------------
DROP TABLE IF EXISTS `sowduan`;
CREATE TABLE `sowduan` (
  `sowNo` varchar(225) DEFAULT NULL,
  `duanDate` varchar(255) DEFAULT NULL,
  `duanWeight` varchar(255) DEFAULT NULL,
  `pigstyNo` varchar(255) DEFAULT NULL,
  `hogcoteNo` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sowduan
-- ----------------------------
INSERT INTO `sowduan` VALUES ('YY37-3', '2018-10-28', '200公斤', '1号猪舍', '4号猪栏', '母猪不正常');
INSERT INTO `sowduan` VALUES ('YY37-4', '2018-10-28', '333公斤', '2号猪舍', '5号猪栏', '母猪正常');
INSERT INTO `sowduan` VALUES ('YY37-8', '2018-10-28', '356公斤', '2号猪舍', '2号猪栏', '母猪正常');
INSERT INTO `sowduan` VALUES ('YY37-45', '2018-10-28', '367公斤', '1号猪舍', '3号猪栏', '母猪正常');
INSERT INTO `sowduan` VALUES ('YY37-12', '2018-10-28', '324公斤', '1号猪舍', '2号猪栏', '母猪正常');
INSERT INTO `sowduan` VALUES ('YY37-32', '2018-10-28', '346公斤', '4号猪舍', '7号猪栏', '母猪正常');
INSERT INTO `sowduan` VALUES ('YY37-34', '2018-10-28', '353公斤', '1号猪舍', '2号猪栏', '母猪正常');
INSERT INTO `sowduan` VALUES ('YY37-25', '2018-10-28', '353公斤', '1号猪舍', '9号猪栏', '母猪正常');
INSERT INTO `sowduan` VALUES ('YY37-2', '2018-10-28', '300公斤', '1号猪舍', '2号猪栏', '母猪正常');

-- ----------------------------
-- Table structure for sowfen
-- ----------------------------
DROP TABLE IF EXISTS `sowfen`;
CREATE TABLE `sowfen` (
  `sowNo` varchar(255) DEFAULT NULL,
  `fenDate` varchar(255) DEFAULT NULL,
  `pigstyNo` varchar(255) DEFAULT NULL,
  `hogcoteNo` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `fentime` varchar(255) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `healthpig` varchar(255) DEFAULT NULL,
  `nhealthpig` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sowfen
-- ----------------------------
INSERT INTO `sowfen` VALUES ('YY37-23', '2018-10-28', '1号猪舍', '5号猪栏', '难产', '3.5小时', '18', '12', '6');
INSERT INTO `sowfen` VALUES ('YY37-4', '2018-10-28', '1号猪舍', '6号猪栏', '顺产', '3.5小时', '19', '16', '3');
INSERT INTO `sowfen` VALUES ('YY37-76', '2018-10-28', '1号猪舍', '12号猪栏', '难产', '3.5小时', '16', '12', '4');
INSERT INTO `sowfen` VALUES ('YY37-13', '2018-10-28', '1号猪舍', '6号猪栏', '顺产', '3.5小时', '17', '13', '4');
INSERT INTO `sowfen` VALUES ('YY37-67', '2018-10-28', '1号猪舍', '8号猪栏', '难产', '3.5小时', '20', '16', '4');
INSERT INTO `sowfen` VALUES ('YY37-25', '2018-10-28', '1号猪舍', '9号猪栏', '顺产', '3.5小时', '16', '12', '4');
INSERT INTO `sowfen` VALUES ('YY37-2', '2018-10-28', '1号猪舍', '6号猪栏', '顺产', '3.5小时', '16', '12', '4');

-- ----------------------------
-- Table structure for sowpei
-- ----------------------------
DROP TABLE IF EXISTS `sowpei`;
CREATE TABLE `sowpei` (
  `sowNo` varchar(22) DEFAULT NULL,
  `semenDate` varchar(19) DEFAULT NULL,
  `pigstyNo` varchar(255) DEFAULT NULL,
  `hogcoteNo` varchar(255) DEFAULT NULL,
  `boarNo` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sowpei
-- ----------------------------
INSERT INTO `sowpei` VALUES ('YY37-2', '2018-10-28', '1号猪舍', '6号猪栏', 'MM32-47', '原精');
INSERT INTO `sowpei` VALUES ('YY37-3', '2018-10-28', '1号猪舍', '3号猪栏', 'MM32-23', '人工授精');
INSERT INTO `sowpei` VALUES ('YY37-5', '2018-10-28', '1号猪舍', '2号猪栏', 'MM32-64', '冻精');
INSERT INTO `sowpei` VALUES ('YY37-7', '2018-10-28', '1号猪舍', '2号猪栏', 'MM32-23', '人工授精');
INSERT INTO `sowpei` VALUES ('YY37-8', '2018-10-28', '1号猪舍', '15号猪栏', 'MM32-47', '原精');
INSERT INTO `sowpei` VALUES ('YY37-1', '2018-10-28', '1号猪舍', '8号猪栏', 'MM32-98', '人工授精');
INSERT INTO `sowpei` VALUES ('YY37-56', '2018-10-28', '1号猪舍', '12号猪栏', 'MM32-34', '原精');
INSERT INTO `sowpei` VALUES ('YY37-1', '2018-10-28', '1号猪舍', '2号猪栏', 'MM32-34', '人工授精');
INSERT INTO `sowpei` VALUES ('YY37-23', '2018-10-28', '1号猪舍', '2号猪栏', 'MM32-23', '人工授精');
INSERT INTO `sowpei` VALUES ('YY37-1', '2018-10-28', '1号猪舍', '2号猪栏', 'MM32-23', '人工授精');
INSERT INTO `sowpei` VALUES ('YY37-1', '2018-10-28', '1号猪舍', '2号猪栏', 'MM32-23', '人工授精');
INSERT INTO `sowpei` VALUES ('YY37-1', '2018-10-28', '1号猪舍', '2号猪栏', 'MM32-23', '人工授精');

-- ----------------------------
-- Table structure for suspectedillness
-- ----------------------------
DROP TABLE IF EXISTS `suspectedillness`;
CREATE TABLE `suspectedillness` (
  `ID` bigint(20) NOT NULL,
  `pigNo` varchar(32) NOT NULL COMMENT '可疑生病ID,主键,自增',
  `date` datetime NOT NULL,
  `temperature` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `suspectedillness_fk_01_idx` (`pigNo`),
  CONSTRAINT `suspectedillness_fk_01` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of suspectedillness
-- ----------------------------

-- ----------------------------
-- Table structure for threshold
-- ----------------------------
DROP TABLE IF EXISTS `threshold`;
CREATE TABLE `threshold` (
  `thresholdID` int(11) NOT NULL AUTO_INCREMENT,
  `piggeryNo` varchar(20) DEFAULT NULL,
  `controlType` varchar(255) DEFAULT NULL,
  `minThreshold` double(16,0) NOT NULL DEFAULT '0' COMMENT '阈值的最小值',
  `maxThreshold` double(16,0) DEFAULT '0' COMMENT '阈值的最大值',
  PRIMARY KEY (`thresholdID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of threshold
-- ----------------------------
INSERT INTO `threshold` VALUES ('1', '1', '温度', '16', '28');
INSERT INTO `threshold` VALUES ('2', '2', '湿度', '60', '85');
INSERT INTO `threshold` VALUES ('3', '1', 'SO2', '0', '6');
INSERT INTO `threshold` VALUES ('4', '3', '氨气', '20', '26');
INSERT INTO `threshold` VALUES ('5', '3', 'CO2', '0', '20');
INSERT INTO `threshold` VALUES ('6', '1', '噪声', '0', '70');
INSERT INTO `threshold` VALUES ('12', '1', '光照强度', '0', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userNo` varchar(32) NOT NULL COMMENT '工号,ID号,账号',
  `email` varchar(30) DEFAULT NULL,
  `phoneNumber` char(11) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `trueName` varchar(12) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `IDCard` char(18) DEFAULT '' COMMENT '身份证',
  `headPortraitUrl` varchar(120) DEFAULT NULL COMMENT '头像url',
  `createDate` datetime DEFAULT NULL COMMENT '注册日期',
  `effectiveDate` datetime DEFAULT NULL COMMENT '生效日期',
  `personalProfile` varchar(130) DEFAULT NULL COMMENT '个人简介',
  `question` varchar(100) DEFAULT NULL COMMENT '密保问题',
  `answer` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '审核状态',
  `reviewAnnotation` varchar(100) DEFAULT NULL COMMENT '审核批注',
  PRIMARY KEY (`userNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111111', '', '12345678999', '123', 'mmmm', '0', '242077129847987976', null, '2018-11-11 13:40:28', null, '', '您母亲的姓名', '23', '1', null);
INSERT INTO `user` VALUES ('zhangg', null, '12345678999', '123', 'mmmm', '0', '242077129847987976', null, '2018-11-11 13:40:28', null, null, '您母亲的姓名', '45s', '1', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `ID` int(11) NOT NULL,
  `userNo` varchar(32) NOT NULL,
  `roleID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for willdestroy
-- ----------------------------
DROP TABLE IF EXISTS `willdestroy`;
CREATE TABLE `willdestroy` (
  `willDestroyID` bigint(20) NOT NULL COMMENT '销毁ID,主键，自增',
  `pigNo` varchar(32) NOT NULL,
  `commitTime` datetime NOT NULL COMMENT '申请销毁提交时间',
  `reason` varchar(100) NOT NULL,
  `checkUserNo` varchar(32) DEFAULT NULL COMMENT '审核人',
  `isAgree` int(11) DEFAULT NULL COMMENT '是否同意',
  PRIMARY KEY (`willDestroyID`),
  KEY `willdestroy_fk_01_idx` (`pigNo`),
  KEY `willdestroy_fk_02_idx` (`checkUserNo`),
  CONSTRAINT `willdestroy_fk_01` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `willdestroy_fk_02` FOREIGN KEY (`checkUserNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of willdestroy
-- ----------------------------
