DROP TABLE IF EXISTS t_card_management;
CREATE TABLE `t_card_management` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',

  `cardid` VARCHAR(50) NOT NULL COMMENT '卡号',


  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卡号管理表';