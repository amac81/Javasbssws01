USE `javasbssws01_bd`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` varchar(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--

INSERT INTO `members` 
VALUES 
('john','{bcrypt}$2a$10$c/jCzeZmbcxZBSlWJfhPj.8UR2aTqoMXX.9VeKD9aFOT8sVMRkxxK',1),
('mary','{bcrypt}$2a$10$c/jCzeZmbcxZBSlWJfhPj.8UR2aTqoMXX.9VeKD9aFOT8sVMRkxxK',1),
('susan','{bcrypt}$2a$10$c/jCzeZmbcxZBSlWJfhPj.8UR2aTqoMXX.9VeKD9aFOT8sVMRkxxK',1);

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `roles_idx_1` (`user_id`,`role`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');
