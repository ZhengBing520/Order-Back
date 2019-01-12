DROP TABLE IF EXISTS t_referrer;
CREATE TABLE `t_referrer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',

  `name_referrer` VARCHAR(50) NOT NULL COMMENT '介绍人姓名',
  `push_money` decimal(10,2) NOT NULL COMMENT '提成（每拍一件）',

  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='介绍人表';
