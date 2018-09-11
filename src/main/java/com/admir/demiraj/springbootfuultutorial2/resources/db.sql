/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  root
 * Created: Sep 7, 2018
 */

CREATE TABLE `Hospitals` (
  `hospital_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 
CREATE TABLE `Variables` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hospital_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hospital_id` (`hospital_id`),
  CONSTRAINT `variables_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `Hospital` (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;