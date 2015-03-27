INSERT INTO `ActionDef` (`actionDefId`, `actionName`, `lastUpdated`, `lastUpdatedBy`) VALUES
(1,	'Check status',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `TaskActionMap` (`taskActionMapId`, `taskDefId`, `actionDefId`, `taskActionOrder`, `lastUpdated`, `lastUpdatedBy`) VALUES
(1,	1,	1,	1,	'2015-01-01 00:00:00',	'initial');

INSERT INTO `TaskDef` (`taskDefId`, `taskName`, `lastUpdated`, `lastUpdatedBy`) VALUES
(1,	'Http monitor',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `Monitor` (`monitorId`, `monitorName`, `lastUpdated`, `lastUpdatedBy`) VALUES
(1,	'http',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `Website` (`websiteId`, `address`, `monitorId`, `lastUpdated`, `lastUpdatedBy`) VALUES
(1,	'google.com',	'1',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `Website` (`websiteId`, `address`, `monitorId`, `lastUpdated`, `lastUpdatedBy`) VALUES
(2,	'facebook.com',	'1',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `Website` (`websiteId`, `address`, `monitorId`, `lastUpdated`, `lastUpdatedBy`) VALUES
(3,	'linkedin.com',	'1',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `Website` (`websiteId`, `address`, `monitorId`, `lastUpdated`, `lastUpdatedBy`) VALUES
(4,	'imdb.com',	'1',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `Website` (`websiteId`, `address`, `monitorId`, `lastUpdated`, `lastUpdatedBy`) VALUES
(5,	'stackoverflow.com',	'1',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `Website` (`websiteId`, `address`, `monitorId`, `lastUpdated`, `lastUpdatedBy`) VALUES
(6,	'twitter.com',	'1',	'2015-01-01 00:00:00',	'initial');

INSERT INTO `Website` (`websiteId`, `address`, `monitorId`, `lastUpdated`, `lastUpdatedBy`) VALUES
(7,	'github.com',	'1',	'2015-01-01 00:00:00',	'initial');