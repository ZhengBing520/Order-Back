DROP TABLE IF EXISTS t_detail;
CREATE TABLE `t_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `business_id` int(10) NOT NULL COMMENT '商家ID',
	`date_detail` date NOT NULL COMMENT '日期',
  `bill_total` int(10) NOT NULL COMMENT '总单(商家任务表行数统计)',
	`receivable` decimal(10,2) NOT NULL COMMENT '应收(商家任务表中件数*（总价+佣金）)',
	`put` decimal(10,2) NOT NULL COMMENT '放(商家任务表中件数*（总价+成本佣金）)',
	`receipt` decimal(10,2) NOT NULL COMMENT '实收',
	`residue` decimal(10,2) NOT NULL COMMENT '余(应收-放)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',

  PRIMARY KEY (`id`),
  KEY `idx_date_detail` (`date_detail`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='每日明细表';