
CREATE TABLE IF NOT EXISTS `account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `login` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `activation_code`     VARCHAR(45),
  `activation_status`   BOOLEAN,
  PRIMARY KEY (`id`));

  CREATE TABLE IF NOT EXISTS `docs` (
    `code` VARCHAR(8) NOT NULL,
    `version` INT NOT NULL,
    `name` VARCHAR(200) NOT NULL,
    PRIMARY KEY (`code`));

  CREATE TABLE IF NOT EXISTS `countries` (
    `code` VARCHAR(50) NOT NULL,
    `version` INT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`code`));

CREATE TABLE IF NOT EXISTS `organization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `fullname` VARCHAR(128) NOT NULL,
  `inn` VARCHAR(15) NOT NULL,
  `kpp` VARCHAR(15) NOT NULL,
  `address` VARCHAR(128) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `isactive` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `office` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `orgid` INT,
  `name` VARCHAR(128) NOT NULL,
  `address` VARCHAR(128)NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `is_active` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_orgId`
    FOREIGN KEY (`orgId`)
    REFERENCES `organization` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
CREATE INDEX `fk_orgId_idx` ON `office` (`orgId` ASC);

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `officeid` INT,
  `firstname` VARCHAR(45) NOT NULL,
  `secondname` VARCHAR(45) NOT NULL,
  `middlename` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `doctype` INT NOT NULL,
  `docnumber` VARCHAR(45) NOT NULL,
  `docdate` DATE,
  `citizenshipcode` INT NOT NULL,
  `isidentified` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_officeId`
    FOREIGN KEY (`officeId`)
    REFERENCES `office` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_doctype`
    FOREIGN KEY (`doctype`)
    REFERENCES `docs` (`code`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_citizenship`
    FOREIGN KEY (`citizenshipCode`)
    REFERENCES `countries` (`code`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
CREATE INDEX `fk_officeId_idx` ON `user` (`officeId` ASC);
CREATE INDEX `fk_citizenship_idx` ON `user` (`citizenshipCode` ASC);



