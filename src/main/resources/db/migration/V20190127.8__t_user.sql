DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户类型，0：普通用户，1：管理员',
  `real_name` varchar(50) NOT NULL COMMENT '姓名',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `mobile` varchar(11) NOT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `udx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户基本信息表';

INSERT INTO `t_user` (`username`, `password`, `type`, `real_name`, `nick_name`, `mobile`, `create_time`, `update_time`) VALUES ('root', 'FF9830C42660C1DD1942844F8069B74A', '1', 'root', '超级管理员', '', now(), now());
