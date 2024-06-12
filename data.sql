/*
MySQL Data
*/

SET FOREIGN_KEY_CHECKS=0;

-- -------------------------------
-- Table structure for login_info
-- -------------------------------

DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `PINCODE` int(11) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for splitfiles
-- ----------------------------
DROP TABLE IF EXISTS `splitfiles`;
CREATE TABLE `splitfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_post_id` bigint(20) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PATH` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for patient_master
-- ----------------------------

DROP TABLE IF EXISTS `patient_master`;

CREATE TABLE `patient_master` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `PINCODE` varchar(10) DEFAULT NULL,
  `CONTACT_NO` varchar(15) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `AGE` int(10) DEFAULT NULL,
  `WEIGHT` decimal(5,2) DEFAULT NULL,
  `HEIGHT` decimal(5,2) DEFAULT NULL,
  `BLOOD_GROUP` varchar(5) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for patient_history
-- ----------------------------
DROP TABLE IF EXISTS `patient_history`;

CREATE TABLE `patient_history` (
  `patient_id` bigint(20) NOT NULL,
  `symptoms` varchar(255) DEFAULT NULL,
  `prescription` varchar(255) DEFAULT NULL,
  `prescribed_by_doctor` varchar(255) DEFAULT NULL,
  `prescribed_by_name` varchar(255) DEFAULT NULL,
  `prescribed_date` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
