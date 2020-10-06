SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` double(20,2) DEFAULT NULL,
  `in_time` DATE DEFAULT NULL,
  `out_time` DATE DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `hotel_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY 'FK_hotel_user_id' ('id'),
  CONSTRAINT 'FK_hotel_user_id' FOREIGN KEY ('hotel_user_id') REFERENCES 'user'('id') ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
