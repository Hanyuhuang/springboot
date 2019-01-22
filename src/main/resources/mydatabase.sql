/*
MySQL Backup
Database: mydatabase
Backup Time: 2019-01-22 20:07:11
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `mydatabase`.`employee`;
DROP TABLE IF EXISTS `mydatabase`.`item`;
DROP TABLE IF EXISTS `mydatabase`.`orderdetail`;
DROP TABLE IF EXISTS `mydatabase`.`orders`;
DROP TABLE IF EXISTS `mydatabase`.`user`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `sex` enum('男','女') NOT NULL DEFAULT '男',
  `salary` decimal(10,2) NOT NULL,
  `hiredate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `order_id` (`order_id`) USING BTREE,
  KEY `item_id` (`item_id`) USING BTREE,
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `createtime` datetime NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(16) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
BEGIN;
LOCK TABLES `mydatabase`.`employee` WRITE;
DELETE FROM `mydatabase`.`employee`;
INSERT INTO `mydatabase`.`employee` (`id`,`name`,`sex`,`salary`,`hiredate`) VALUES (1, 'admin', '男', 9999.00, '2018-09-30'),(2, '张三', '男', 4900.00, '2018-09-06'),(3, '李四', '男', 5600.00, '2018-05-24'),(4, '王五', '男', 6100.00, '2014-09-30'),(5, '测试', '女', 3500.00, '2018-09-30'),(6, '测试2', '女', 3500.00, '2018-09-30'),(7, '测试3', '男', 3500.00, '2018-09-01'),(9, '测试3', '男', 3700.00, '2018-10-10');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `mydatabase`.`item` WRITE;
DELETE FROM `mydatabase`.`item`;
INSERT INTO `mydatabase`.`item` (`id`,`name`,`price`,`pic`,`detail`) VALUES (1, '农夫山泉', 2.00, '52f94c44-7c87-4dbc-a47b-3b2909db80d1.jpg', '真便宜！'),(2, '方便面', 6.00, '5153a92f-a8f9-4245-b0c0-c7d2ab8a9a26.jpg', '真香！'),(4, '电脑', 6800.00, '61357f2d-f189-4559-8ab5-fd97d3e0c2e8.jpg', ''),(5, 'iphoneX', 8888.00, '7b781547-af70-4132-b18a-c93e0642bee4.jpg', '真好！'),(9, 'iPhone X', 8888.00, '1122e6c3-4eff-461c-9856-e9c28b1b7c3a.jpg', '真好！'),(10, 'iPhone X', 8888.00, '523a23f1-f67f-4d15-b28b-f99aae4b557e.jpg', '真好！'),(11, 'iPhone X', 8888.00, 'bbb68256-0a54-4a59-9592-e0e39be01aec.jpg', '真好！');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `mydatabase`.`orderdetail` WRITE;
DELETE FROM `mydatabase`.`orderdetail`;
INSERT INTO `mydatabase`.`orderdetail` (`id`,`order_id`,`item_id`,`number`) VALUES (1, 1, 1, 2),(2, 2, 2, 3);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `mydatabase`.`orders` WRITE;
DELETE FROM `mydatabase`.`orders`;
INSERT INTO `mydatabase`.`orders` (`id`,`user_id`,`createtime`,`note`) VALUES (1, 2, '2018-09-11 21:20:47', NULL),(2, 2, '2018-09-12 21:34:58', NULL);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `mydatabase`.`user` WRITE;
DELETE FROM `mydatabase`.`user`;
INSERT INTO `mydatabase`.`user` (`id`,`name`,`password`,`sex`,`birthday`,`address`) VALUES (1, 'admin', '123456', '男', '1998-07-09', '上海'),(2, '张三', '123456', '男', '1999-09-09', '北京'),(6, '李四', '123456', '男', '2000-00-00', '南京'),(12, '测试', '123456', '男', '2018-09-10', '北京'),(13, '测试', '123456', '男', '2018-09-10', '北京'),(14, '测试', '123456', '男', '2018-09-10', '北京');
UNLOCK TABLES;
COMMIT;
