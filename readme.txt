Don't use latest tomcat for the old version struts

1��ϵͳ�ܹ�
   struts2.2.3 + spring3.1.0 + mybatis3.0.6
2��ʵ��Ŀ��
        ����spring  aop����ʵ��ҵ��������Զ���¼

3.���ݿ⽨�����

		/*
		MySQL Data Transfer
		Source Host: localhost
		Source Database: operationlog
		Target Host: localhost
		Target Database: operationlog
		Date: 2012/3/25 16:25:36
		*/
		Drop database if exists operationlog;
		create database operationlog  character set utf8;
		use operationlog;
		
		SET FOREIGN_KEY_CHECKS=0;
		-- ----------------------------
		-- Table structure for user
		-- ----------------------------
		CREATE TABLE `user` (
		  `id` int(4) NOT NULL auto_increment,
		  `username` varchar(64) collate utf8_bin default NULL,
		  `password` varchar(64) collate utf8_bin default NULL,
		  PRIMARY KEY  (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
		
		-- ----------------------------
		-- Records 
		-- ----------------------------
		INSERT INTO `user` VALUES ('2', 'admin', '1234');
