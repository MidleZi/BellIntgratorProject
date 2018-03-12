CREATE TABLE `bellintegrator`.`authUsers` (
  `login` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`));

CREATE TABLE `bellintegrator`.`organization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `fullName` VARCHAR(128) NOT NULL,
  `inn` VARCHAR(10) NOT NULL,
  `kpp` VARCHAR(9) NOT NULL,
  `adress` VARCHAR(128) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `isActive` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `bellintegrator`.`office` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orgId` INT NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `adress` VARCHAR(128) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `isAtive` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orgId_idx` (`orgId` ASC),
  CONSTRAINT `fk_orgId`
    FOREIGN KEY (`orgId`)
    REFERENCES `bellintegrator`.`organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `bellintegrator`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `officeId` INT NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `secondName` VARCHAR(45) NOT NULL,
  `middleName` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `userDoc` INT NOT NULL,
  `citizenshipCode` INT NOT NULL,
  `isIdentified` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_officeId_idx` (`officeId` ASC),
  CONSTRAINT `fk_officeId`
    FOREIGN KEY (`officeId`)
    REFERENCES `bellintegrator`.`office` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
  INDEX `fk_citizenship_idx` (`citizenshipCode` ASC);
  CONSTRAINT `fk_userDoc`
    FOREIGN KEY (`id`)
    REFERENCES `bellintegrator`.`userdocs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_citizenship`
    FOREIGN KEY (`citizenshipCode`)
    REFERENCES `bellintegrator`.`countries` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `bellintegrator`.`docs` (
  `code` INT NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`code`));
  
CREATE TABLE `bellintegrator`.`countries` (
  `code` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`code`));
  
CREATE TABLE `bellintegrator`.`userdocs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `docName` INT NOT NULL,
  `docNumber` VARCHAR(45) NOT NULL,
  `docDate` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_docs_idx` (`docName` ASC),
  CONSTRAINT `fk_docs`
    FOREIGN KEY (`docName`)
    REFERENCES `bellintegrator`.`docs` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  
