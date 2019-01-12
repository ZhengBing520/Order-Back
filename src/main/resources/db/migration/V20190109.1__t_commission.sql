DROP TABLE IF EXISTS t_commission;
CREATE TABLE `t_commission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `business_id` int(10) NOT NULL COMMENT '商家ID',
  `price_min` int(10) NOT NULL COMMENT '价格区间中的最小值',
  `price_max` int(10) NOT NULL COMMENT '价格区间中的最大值',
  `commission` decimal(10,2) NOT NULL COMMENT '佣金',
  `commission_cost` decimal(10,2) NOT NULL COMMENT '成本佣金',


  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',

  PRIMARY KEY (`id`),
  KEY `idx_business_id` (`business_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='佣金表';

INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '1', '99', '15.00', '15.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '100', '299', '18.00', '18.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '300', '499', '20.00', '20.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '500', '999', '22.00', '22.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '1000', '1490', '24.00', '24.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '1500', '1999', '26.00', '26.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '2000', '2499', '30.00', '30.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '2500', '2999', '35.00', '35.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '3000', '3499', '40.00', '40.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '3500', '3999', '50.00', '50.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '4000', '4499', '60.00', '60.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '4500', '4999', '70.00', '70.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '5000', '5499', '80.00', '80.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '5500', '5999', '100.00', '100.00', now(), now());
INSERT INTO  `t_commission` (`business_id`, `price_min`, `price_max`, `commission`, `commission_cost`, `create_time`, `update_time`) VALUES ('0', '6000', '100000', '800.00', '800.00', now(), now());
