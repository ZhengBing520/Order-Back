DROP TABLE IF EXISTS t_summary;
CREATE TABLE `t_summary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`date_summary` date NOT NULL COMMENT '日期',
  `bill_sum` int(10) NOT NULL COMMENT '总单',
	`receivable_sum` decimal(10,2) NOT NULL COMMENT '总收（每个店铺每日应收款统计）',
	`put_sum` decimal(10,2) NOT NULL COMMENT '总放（每个店铺每日成本统计）',
	`residue` decimal(10,2) NOT NULL COMMENT '余（每个店铺每日利润统计）',
  `residue_last` decimal(10,2) NOT NULL COMMENT '剩余（实际最终到手利润，余-其他人提成）',
	`receipt` decimal(10,2) NOT NULL COMMENT '实际收款（每个店铺每日实收统计）',
	`balance` decimal(10,2) NOT NULL COMMENT '差额（总收-实际收款）',
	`note` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',

  PRIMARY KEY (`id`),
  KEY `idx_date_summary` (`date_summary`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='每日汇总表';