/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : testname

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-25 01:06:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `algorithm`
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
-- Table structure for `backup`
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
-- Table structure for `birthrecord`
-- ----------------------------
DROP TABLE IF EXISTS `birthrecord`;
CREATE TABLE `birthrecord` (
  `birthRecordID` bigint(20) NOT NULL COMMENT '出生记录编号',
  `pigNo` varchar(32) NOT NULL,
  `birthTime` datetime NOT NULL COMMENT '出生时间',
  `babyCount` int(11) NOT NULL COMMENT '子猪数量',
  PRIMARY KEY (`birthRecordID`),
  KEY `birthrecord_fk_idx` (`pigNo`),
  CONSTRAINT `birthrecord_fk` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of birthrecord
-- ----------------------------

-- ----------------------------
-- Table structure for `combinatorialalgorithm`
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
-- Table structure for `diseasetreatment`
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
-- Table structure for `drugrecord`
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
-- Table structure for `drugtype`
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
-- Table structure for `eatrecord`
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
-- Table structure for `eliminate`
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
-- Table structure for `equipment`
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
-- Table structure for `equipmentdata`
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
-- Table structure for `equipmentrecord`
-- ----------------------------
DROP TABLE IF EXISTS `equipmentrecord`;
CREATE TABLE `equipmentrecord` (
  `equipmentRecordID` bigint(20) NOT NULL,
  `equipmentID` bigint(20) NOT NULL COMMENT '设备ID',
  `effectiveDate` datetime NOT NULL COMMENT '有效日期',
  `createDate` datetime NOT NULL COMMENT '生产日期',
  `date` datetime NOT NULL,
  `price` decimal(9,2) NOT NULL COMMENT '采购价格',
  `useState` int(11) DEFAULT NULL COMMENT '使用状态',
  PRIMARY KEY (`equipmentRecordID`),
  KEY `equipmentrecord_fk_01_idx` (`equipmentID`),
  CONSTRAINT `equipmentrecord_fk_01` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`equipmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipmentrecord
-- ----------------------------

-- ----------------------------
-- Table structure for `estrus`
-- ----------------------------
DROP TABLE IF EXISTS `estrus`;
CREATE TABLE `estrus` (
  `estrusID` bigint(20) NOT NULL COMMENT '发情记录',
  `pigNo` varchar(32) NOT NULL,
  `preBirthDate` datetime DEFAULT NULL COMMENT '预产期',
  `rtLove` int(11) DEFAULT NULL COMMENT '已返情却未怀孕',
  `measures` varchar(100) DEFAULT NULL COMMENT '采取措施',
  PRIMARY KEY (`estrusID`),
  KEY `estrus_fk_01_idx` (`pigNo`),
  CONSTRAINT `estrus_fk_01` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of estrus
-- ----------------------------

-- ----------------------------
-- Table structure for `exception`
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
-- Table structure for `feedrecord`
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
-- Table structure for `feedset`
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
-- Table structure for `fetalstructure`
-- ----------------------------
DROP TABLE IF EXISTS `fetalstructure`;
CREATE TABLE `fetalstructure` (
  `fetalStructureID` bigint(20) NOT NULL COMMENT '胎次结构ID,主键',
  `pigNo` varchar(32) NOT NULL COMMENT '母猪耳号',
  `totalNumber` int(11) NOT NULL COMMENT '母猪总产子数',
  `survivalNumber` int(11) NOT NULL COMMENT '存活数',
  `pregnancyRate` decimal(5,2) DEFAULT NULL COMMENT '30天受胎率',
  `deliveryRate` decimal(5,2) DEFAULT NULL COMMENT '分娩率',
  PRIMARY KEY (`fetalStructureID`),
  KEY `fetalstructure_fk_01_idx` (`pigNo`),
  CONSTRAINT `fetalstructure_fk_01` FOREIGN KEY (`pigNo`) REFERENCES `pig` (`pigNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fetalstructure
-- ----------------------------

-- ----------------------------
-- Table structure for `formula`
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
-- Table structure for `gathering`
-- ----------------------------
DROP TABLE IF EXISTS `gathering`;
CREATE TABLE `gathering` (
  `gatheringID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '收款单号',
  `gatheringType` varchar(255) DEFAULT NULL COMMENT '收款的类型',
  `gatherDate` datetime DEFAULT NULL COMMENT '收款时间',
  `money` double DEFAULT NULL COMMENT '金额',
  `serialNumber` varchar(225) DEFAULT NULL COMMENT '收款的流水号',
  `gatherReason` text COMMENT '收款原因',
  `orderNumber` varchar(225) DEFAULT NULL COMMENT '物品订单号',
  `payer` varchar(255) DEFAULT NULL COMMENT '付款人员',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收款人员',
  PRIMARY KEY (`gatheringID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gathering
-- ----------------------------

-- ----------------------------
-- Table structure for `growthstate`
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
-- Table structure for `hogcote`
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
-- Table structure for `hurdlecondition`
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
-- Table structure for `hurdlerecord`
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
-- Table structure for `inoculationrecord`
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
-- Table structure for `inoculationset`
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
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `logID` bigint(20) NOT NULL,
  `time` datetime NOT NULL COMMENT '操作时间',
  `userNo` varchar(32) DEFAULT NULL COMMENT '操作人',
  `powerID` int(11) DEFAULT NULL,
  `operationName` varchar(50) NOT NULL,
  `ipAddress` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`logID`),
  KEY `log_fk_01_idx` (`userNo`),
  KEY `log_fk_02_idx` (`powerID`),
  CONSTRAINT `log_fk_01` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `log_fk_02` FOREIGN KEY (`powerID`) REFERENCES `power` (`powerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for `payment`
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `paymentID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '付款单编号',
  `paymentType` varchar(255) DEFAULT NULL COMMENT '付款的类型',
  `paymentDate` datetime DEFAULT NULL COMMENT '付款时间',
  `orderNumber` int(11) DEFAULT NULL COMMENT '物品订单号',
  `money` double DEFAULT NULL COMMENT '金额',
  `serialNumber` varchar(50) DEFAULT NULL COMMENT '付款流水号',
  `paymentReason` text COMMENT '付款原因',
  `applicant` varchar(255) DEFAULT NULL COMMENT '订单申请人员',
  `manager` varchar(255) DEFAULT NULL COMMENT '处理人员',
  PRIMARY KEY (`paymentID`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', null, null, '0', '100', null, null, null, null);
INSERT INTO `payment` VALUES ('2', null, null, '0', '100', null, null, null, null);
INSERT INTO `payment` VALUES ('3', null, null, '0', '100', null, null, null, null);
INSERT INTO `payment` VALUES ('4', null, null, '0', '100', null, null, null, null);
INSERT INTO `payment` VALUES ('5', null, null, '0', '100', null, null, null, null);
INSERT INTO `payment` VALUES ('244', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `pig`
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
-- Table structure for `piggery`
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
-- Table structure for `pigstandard`
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
-- Table structure for `pigsty`
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
-- Table structure for `pigtype`
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

-- ----------------------------
-- Table structure for `power`
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
-- Table structure for `prehurdlerecord`
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
-- Table structure for `role`
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
-- Table structure for `role_power`
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
-- Table structure for `suspectedillness`
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
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userNo` varchar(32) NOT NULL COMMENT '工号,ID号,账号',
  `email` varchar(30) DEFAULT NULL,
  `phoneNumber` char(11) NOT NULL,
  `password` varchar(16) NOT NULL,
  `trueName` varchar(12) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `IDCard` char(18) NOT NULL DEFAULT '' COMMENT '身份证',
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
INSERT INTO `user` VALUES ('2', null, '12345677654', '222', null, '1', '234323333333333333', null, '2018-10-25 00:27:35', null, null, null, '', '0', null);
INSERT INTO `user` VALUES ('20162147', null, '12345677654', '123', null, '1', '234323333333333333', null, '2018-10-25 00:26:44', null, null, '1', '暗黄', '0', null);

-- ----------------------------
-- Table structure for `user_role`
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
-- Table structure for `willdestroy`
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
