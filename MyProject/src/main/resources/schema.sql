
CREATE TABLE IF NOT EXISTS `authUsers` (
  `login` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`));

  CREATE TABLE IF NOT EXISTS `docs` (
    `code` VARCHAR(8) NOT NULL,
    `name` VARCHAR(200) NOT NULL,
    PRIMARY KEY (`code`));

  CREATE TABLE IF NOT EXISTS `countries` (
    `code` INT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`code`));



CREATE TABLE IF NOT EXISTS `organization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `fullname` VARCHAR(128) NOT NULL,
  `inn` VARCHAR(10) NOT NULL,
  `kpp` VARCHAR(9) NOT NULL,
  `address` VARCHAR(128) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `isactive` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `office` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orgid` INT,
  `name` VARCHAR(128) NOT NULL,
  `address` VARCHAR(128)NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `isactive` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_orgId`
    FOREIGN KEY (`orgId`)
    REFERENCES `organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE INDEX `fk_orgId_idx` ON `office` (`orgId` ASC);

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `officeid` INT NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `secondname` VARCHAR(45) NOT NULL,
  `middlename` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `userdoc`  INT NOT NULL,
  `citizenshipcode` INT NOT NULL,
  `isidentified` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_officeId`
    FOREIGN KEY (`officeId`)
    REFERENCES `office` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_citizenship`
    FOREIGN KEY (`citizenshipCode`)
    REFERENCES `countries` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE INDEX `fk_officeId_idx` ON `users` (`officeId` ASC);
CREATE INDEX `fk_citizenship_idx` ON `users` (`citizenshipCode` ASC);

  CREATE TABLE IF NOT EXISTS `userdocs` (
    `id` INT NOT NULL,
    `docname` VARCHAR(45) NOT NULL,
    `docnumber` VARCHAR(45) NOT NULL,
    `docdate` DATE NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_docs`
      FOREIGN KEY (`docname`)
      REFERENCES `docs` (`code`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT `fk_userId`
      FOREIGN KEY (`id`)
      REFERENCES `users` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);
  CREATE INDEX `fk_docs_idx` ON `userdocs` (`docName` ASC);
  CREATE INDEX `fk_userId_idx` ON `userdocs` (`id` ASC);

  
