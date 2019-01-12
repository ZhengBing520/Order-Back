DROP TABLE IF EXISTS t_business;
CREATE TABLE `t_business` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
 
  `name` VARCHAR(50) NOT NULL COMMENT '商家名称',
  `card_id` int(10) DEFAULT '0' COMMENT '卡号ID',
  `referrer_id` int(10) DEFAULT '0' COMMENT '介绍人ID',

  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家表';