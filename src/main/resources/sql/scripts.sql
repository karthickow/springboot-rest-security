CREATE TABLE `sql12670169`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT(1) NOT NULL,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  PRIMARY KEY (`id`));
  
ALTER TABLE `sql12670169`.`users` 
CHARACTER SET = utf8mb4 , COLLATE = utf8mb4_unicode_ci ;

CREATE TABLE `sql12670169`.`authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

INSERT INTO `sql12670169`.`users` VALUES (NULL,'karthick', '12345', '1');
INSERT INTO `sql12670169`.`authorities` VALUES (NULL,'karthick', 'write');


CREATE TABLE `sql12670169`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


INSERT INTO `sql12670169`.`customer` (`email`, `pwd`, `role`)
 VALUES ('karthick@example.com', '54321', 'admin');
