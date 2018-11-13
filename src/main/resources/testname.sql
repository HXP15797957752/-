/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : testname

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-13 19:44:37
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `drugRecordID` bigint(20) NOT NULL,
  `drugTypeID` int(11) NOT NULL,
  `createTime` datetime NOT NULL COMMENT '生产日期',
  `effectiveTime` datetime NOT NULL COMMENT '有效期',
  `curNumber` int(11) NOT NULL COMMENT '当前库存量',
  `unit` varchar(5) NOT NULL,
  `isWarehousing` int(11) NOT NULL COMMENT '是否为入库操作,0:否  1:是',
  `time` datetime NOT NULL COMMENT '出入库时间',
  `number` int(11) NOT NULL COMMENT '出入库数量',
  `price` decimal(9,2) NOT NULL COMMENT '药价格',
  PRIMARY KEY (`drugRecordID`),
  KEY `drugrecord_fk_01_idx` (`drugTypeID`),
  CONSTRAINT `drugrecord_fk_01` FOREIGN KEY (`drugTypeID`) REFERENCES `drugtype` (`drugTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drugrecord
-- ----------------------------

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
  `pigstyNo` varchar(9) NOT NULL COMMENT '猪舍编号',
  `hogcoteNo` varchar(9) NOT NULL COMMENT '猪栏编号',
  `timeInterval` int(11) DEFAULT NULL COMMENT '传感器收集数据时间间隔,',
  `controlType` varchar(10) DEFAULT NULL COMMENT '环控设备类型,温度,湿度...',
  `controlThreshold` varchar(16) DEFAULT NULL COMMENT '环控设备阈值',
  PRIMARY KEY (`equipmentID`),
  KEY `equipment_fk_01_idx` (`pigstyNo`),
  KEY `equipment_fk_02_idx` (`hogcoteNo`),
  CONSTRAINT `equipment_fk_01` FOREIGN KEY (`pigstyNo`) REFERENCES `pigsty` (`pigstyNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `equipment_fk_02` FOREIGN KEY (`hogcoteNo`) REFERENCES `hogcote` (`hogcoteNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------

-- ----------------------------
-- Table structure for equipmentdata
-- ----------------------------
DROP TABLE IF EXISTS `equipmentdata`;
CREATE TABLE `equipmentdata` (
  `equipmentDataID` bigint(20) NOT NULL,
  `data` varchar(30) NOT NULL,
  `equipmentID` bigint(20) NOT NULL,
  `time` datetime NOT NULL COMMENT '数据接受时间',
  PRIMARY KEY (`equipmentDataID`),
  KEY `equipmentdate_fk_01_idx` (`equipmentID`),
  CONSTRAINT `equipmentdate_fk_01` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`equipmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipmentdata
-- ----------------------------

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
  `exceptionID` bigint(20) NOT NULL,
  `equipmentID` bigint(20) NOT NULL,
  `time` datetime NOT NULL,
  `processingMethod` varchar(20) NOT NULL,
  `processUserNo` varchar(32) NOT NULL,
  PRIMARY KEY (`exceptionID`),
  KEY `exception_fk_01_idx` (`equipmentID`),
  KEY `exception_fk_02_idx` (`processUserNo`),
  CONSTRAINT `exception_fk_01` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`equipmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `exception_fk_02` FOREIGN KEY (`processUserNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exception
-- ----------------------------

-- ----------------------------
-- Table structure for feedrecord
-- ----------------------------
DROP TABLE IF EXISTS `feedrecord`;
CREATE TABLE `feedrecord` (
  `feedRecordID` bigint(20) NOT NULL,
  `createTime` datetime NOT NULL,
  `effectiveTime` datetime NOT NULL,
  `curNumber` int(11) NOT NULL,
  `unit` varchar(5) NOT NULL,
  `isWarehousing` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `number` int(11) NOT NULL,
  `price` decimal(9,2) NOT NULL,
  PRIMARY KEY (`feedRecordID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedrecord
-- ----------------------------

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
  `name` varchar(32) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`growthStateID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of growthstate
-- ----------------------------

-- ----------------------------
-- Table structure for hogcote
-- ----------------------------
DROP TABLE IF EXISTS `hogcote`;
CREATE TABLE `hogcote` (
  `hogcoteNo` varchar(9) NOT NULL,
  `upperLimit` int(11) NOT NULL,
  `area` decimal(9,2) NOT NULL,
  `curPigNumber` int(11) NOT NULL,
  `pigstyNo` varchar(9) NOT NULL,
  PRIMARY KEY (`hogcoteNo`),
  KEY `hogcote_fk_01_idx` (`pigstyNo`),
  CONSTRAINT `hogcote_fk_01` FOREIGN KEY (`pigstyNo`) REFERENCES `pigsty` (`pigstyNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hogcote
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

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
  `serviceURL` varchar(7799) NOT NULL,
  PRIMARY KEY (`menuItemID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menuitem
-- ----------------------------
INSERT INTO `menuitem` VALUES ('1', '111111', '1', '设备运行控制', 'equiOperCont', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('2', '111111', '1', '传感器管理', 'sensMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('3', '111111', '1', '环控设备管理', 'deviExceInfoChec', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('4', '111111', '1', '设备异常信息查看', 'enviContEquiMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('5', '111111', '2', '生长情况标准设置', 'stanSett', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('6', '111111', '2', '生长情况统计', 'equiOperCont', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('7', '111111', '2', '疑似生病统计', 'suspIllnStat', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('8', '111111', '2', '猪只淘汰管理', 'pigElimMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('9', '111111', '2', '饲喂管理', 'feedMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('10', '111111', '2', '配方搭配', 'formColl', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('11', '111111', '2', '饲喂调控', 'feedRegu', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('12', '111111', '2', '饲喂统计', 'feedStat', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('13', '111111', '2', '猪只信息管理', 'pigInfoMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('14', '111111', '2', '猪只安全管理', 'pigSafeMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('15', '111111', '2', '疫苗接种设置', 'vaccSett', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('16', '111111', '2', '疫苗接种管理', 'vaccMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('17', '111111', '2', '疾病管理', 'diseMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('18', '111111', '2', '销毁管理', 'destMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('19', '111111', '2', '移栏管理', 'migrMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('20', '111111', '2', '入栏管理', 'entrMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('21', '111111', '2', '出栏管理', 'coluMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('22', '111111', '3', '设备记录', 'formColl1', 'dataList.html', '/IntelligentSystem/api/RXF1aXBtZW50UmVjb3JkU2VydmljZTpzZXRFcXVpcG1lbnRSZWNvcmQ=');
INSERT INTO `menuitem` VALUES ('23', '111111', '3', '饲料记录', 'formColl2', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('24', '111111', '3', '药品记录', 'formColl3', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('25', '111111', '4', '支付', 'consSett', 'echarts.html', '\r\nhttp://localhost:8080/IntelligentSystem/echarts');
INSERT INTO `menuitem` VALUES ('26', '111111', '5', '母猪配种管理', 'sowBree', 'dataList.html', '/IntelligentSystem/api/U293UGVpU2VydmljZTpzZXRTb3dQZWk=');
INSERT INTO `menuitem` VALUES ('27', '111111', '5', '母猪断奶管理', 'weanCont', 'dataList.html', '/IntelligentSystem/api/U293RHVhblNlcnZpY2U6c2V0U293RHVhbg==');
INSERT INTO `menuitem` VALUES ('28', '111111', '5', '母猪分娩管理', 'sowsDeli', 'dataList.html', '/IntelligentSystem/api/U293RmVuU2VydmljZTpzZXRTb3dGZW4=');
INSERT INTO `menuitem` VALUES ('29', '123456', '6', '算法管理', 'algoMana', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('30', '123456', '7', '用户审核', 'userAudiActiDiag', 'dataList.html', '/IntelligentSystem/api/VXNlclNlcnZpY2U6bG9hZFVzZXJzQXVkaXQ=');
INSERT INTO `menuitem` VALUES ('31', '123456', '7', '用户注销', 'userCanc', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('32', '123456', '8', '日志管理', 'rzgl', 'dataList.html', '/IntelligentSystem/api/TG9nTWFuYWdlOnF1ZXJ5TGlzdA==');
INSERT INTO `menuitem` VALUES ('33', '123456', '8', '权限管理', 'qxgl', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('34', '123456', '8', '数据库备份与恢复', 'sjk', 'dataList.html', 'resources/data/deviExceInfoChec.json');
INSERT INTO `menuitem` VALUES ('35', '111111', '4', 'echarts', 'consSett', 'echarts.html', '');

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
INSERT INTO `payment` VALUES ('13', '3', '2018-10-02 18:44:48', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('14', '7', '2018-10-12 18:45:16', null, '100', null, null, null, null);
INSERT INTO `payment` VALUES ('15', '4', '2018-08-08 19:19:13', null, '100', null, null, null, null);
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
  `sex` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `birthTime` datetime NOT NULL,
  `pigTypeID` int(11) NOT NULL,
  `growthStateID` int(11) NOT NULL,
  `state` int(11) NOT NULL,
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

-- ----------------------------
-- Table structure for piggery
-- ----------------------------
DROP TABLE IF EXISTS `piggery`;
CREATE TABLE `piggery` (
  `piggeryNo` varchar(9) NOT NULL COMMENT '猪场编号',
  `name` varchar(30) NOT NULL,
  `description` varchar(120) NOT NULL,
  PRIMARY KEY (`piggeryNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of piggery
-- ----------------------------

-- ----------------------------
-- Table structure for pigstandard
-- ----------------------------
DROP TABLE IF EXISTS `pigstandard`;
CREATE TABLE `pigstandard` (
  `pigStandardID` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `pigTypeID` int(11) NOT NULL,
  `growthStateID` int(11) NOT NULL,
  `addWeight` int(11) NOT NULL COMMENT '日增重',
  `upperLimit` int(11) NOT NULL,
  `lowerLimit` int(11) NOT NULL COMMENT '下限',
  `date` datetime NOT NULL,
  `timeInterval` int(11) NOT NULL COMMENT '时间间隔',
  PRIMARY KEY (`pigStandardID`),
  KEY `pigstandard_fk_01_idx` (`pigTypeID`),
  KEY `pigstandard_fk_02_idx` (`growthStateID`),
  CONSTRAINT `pigstandard_fk_01` FOREIGN KEY (`pigTypeID`) REFERENCES `pigtype` (`pigTypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pigstandard_fk_02` FOREIGN KEY (`growthStateID`) REFERENCES `growthstate` (`growthStateID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pigstandard
-- ----------------------------

-- ----------------------------
-- Table structure for pigsty
-- ----------------------------
DROP TABLE IF EXISTS `pigsty`;
CREATE TABLE `pigsty` (
  `pigstyNo` varchar(9) NOT NULL COMMENT '猪舍编号',
  `type` varchar(30) NOT NULL COMMENT '猪舍的类型,比如有公猪舍,...',
  `number` int(11) NOT NULL COMMENT '猪栏数量',
  `area` decimal(7,2) NOT NULL COMMENT '面积',
  `piggeryNo` varchar(9) NOT NULL COMMENT '当前猪舍所在猪场',
  `pigTypeID` int(11) NOT NULL,
  `growthStageID` int(11) NOT NULL,
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

-- ----------------------------
-- Table structure for pigtype
-- ----------------------------
DROP TABLE IF EXISTS `pigtype`;
CREATE TABLE `pigtype` (
  `pigTypeID` int(11) NOT NULL,
  `name` varchar(18) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pigTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pigtype
-- ----------------------------
INSERT INTO `pigtype` VALUES ('1', '母猪', 'verygood');

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
INSERT INTO `user` VALUES ('111111', null, '12345678999', '123', 'mmmm', '1', '242077129847987976', null, '2018-11-11 13:40:28', null, null, '您母亲的姓名', '23', '1', null);
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
