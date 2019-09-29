DROP DATABASE IF EXISTS `rainq`;
CREATE DATABASE `rainq`;
USE `rainq`;

DROP TABLE IF EXISTS `rainQuality`;

CREATE TABLE `rainQuality` (
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `districtName` VARCHAR(22) NOT NULL COMMENT '区域名称',
  `monitorTime` DATE NOT NULL COMMENT '监测时间',
  `rain` INT(4) NOT NULL COMMENT '雨量值',
  `monitoringStation` VARCHAR(200) NOT NULL COMMENT '监测站',
  `monitoringAddress` VARCHAR(200) NOT NULL COMMENT '站点地址',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `rainquality`(`id`,`districtName`,`monitorTime`,`rain`,`monitoringStation`,`monitoringAddress`)VALUE(DEFAULT,'丰台区','2014-5-12',5,'七里庄站','七里庄站');
INSERT INTO `rainquality`(`id`,`districtName`,`monitorTime`,`rain`,`monitoringStation`,`monitoringAddress`)VALUE(DEFAULT,'西城区','2015-6-22',2,'龙口胡同','展览路德宝楼');
INSERT INTO `rainquality`(`id`,`districtName`,`monitorTime`,`rain`,`monitoringStation`,`monitoringAddress`)VALUE(DEFAULT,'西城区','2011-3-16',4,'二龙路站','金融街二龙路');
INSERT INTO `rainquality`(`id`,`districtName`,`monitorTime`,`rain`,`monitoringStation`,`monitoringAddress`)VALUE(DEFAULT,'昌平区','2015-2-19',10,'龙锦苑站','回龙观东大街');
INSERT INTO `rainquality`(`id`,`districtName`,`monitorTime`,`rain`,`monitoringStation`,`monitoringAddress`)VALUE(DEFAULT,'东城区','2016-1-17',3,'东四站','东四街道');
INSERT INTO `rainquality`(`id`,`districtName`,`monitorTime`,`rain`,`monitoringStation`,`monitoringAddress`)VALUE(DEFAULT,'海淀区','2013-4-26',6,'西二旗站','上地三站');
INSERT INTO `rainquality`(`id`,`districtName`,`monitorTime`,`rain`,`monitoringStation`,`monitoringAddress`)VALUE(DEFAULT,'昌平区','2014-7-15',9,'五里牌站','西夏四站');
