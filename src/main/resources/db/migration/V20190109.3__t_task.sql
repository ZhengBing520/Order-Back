DROP TABLE IF EXISTS t_task;
CREATE TABLE `t_task` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `business_id` int(10) NOT NULL COMMENT '商家ID',
  `date_task` date NOT NULL COMMENT '任务日期',
	`name_task` VARCHAR(200) DEFAULT NULL COMMENT '任务名称',
	`keywords` VARCHAR(50) DEFAULT NULL COMMENT '关键词',
	`spec` VARCHAR(50) DEFAULT NULL COMMENT '规格',
	`require` VARCHAR(200) DEFAULT NULL COMMENT '附加要求',
  `time_doing` int(10) DEFAULT NULL COMMENT '做单时间',
  `buy_num` int(10) NOT NULL COMMENT '拍下件数',
  `price` decimal(10,2) NOT NULL COMMENT '单价',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',

  PRIMARY KEY (`id`),
  KEY `idx_date_task` (`date_task`) USING BTREE,
  KEY `idx_business_id` (`business_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家任务表';