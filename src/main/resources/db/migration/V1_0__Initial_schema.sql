CREATE TABLE `TaskDef` (
  `taskDefId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `taskName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `lastUpdated` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`taskDefId`)
);

CREATE TABLE `ActionDef` (
  `actionDefId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `actionName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `lastUpdated` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`actionDefId`)
);

CREATE TABLE `TaskActionMap` (
  `taskActionMapId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `taskDefId` int(11) unsigned NOT NULL,
  `actionDefId` int(11) unsigned NOT NULL,
  `taskActionOrder` int(11) NOT NULL,
  `lastUpdated` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`taskActionMapId`),
  UNIQUE KEY `taskDefId_actionDefId` (`taskDefId`,`actionDefId`)
);

CREATE TABLE `Monitor` (
  `monitorId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `monitorName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `taskDefId` int(11) unsigned NOT NULL,
  `lastUpdated` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`monitorId`)
);

CREATE TABLE `Website` (
  `websiteId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `monitorId` int(11) unsigned NOT NULL,
  `lastUpdated` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`websiteId`),
  KEY `monitorId` (`monitorId`)
);

CREATE TABLE `Task` (
  `taskId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `taskDefId` int(11) unsigned NOT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `metadata` text COLLATE utf8_bin DEFAULT NULL,
  `lastUpdated` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`taskId`)
);

CREATE TABLE `Action` (
  `actionId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `actionDefId` int(11) unsigned,
  `taskId` int(11) unsigned NOT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `metadata` text COLLATE utf8_bin DEFAULT NULL,
  `lastUpdated` datetime NOT NULL,
  `lastUpdatedBy` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`actionId`)
);