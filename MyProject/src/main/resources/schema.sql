
CREATE TABLE IF NOT EXISTS `authUsers` (
  `login` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`));

  CREATE TABLE IF NOT EXISTS `docs` (
    `code` INT NOT NULL,
    `name` VARCHAR(200) NOT NULL,
    PRIMARY KEY (`code`));

  CREATE TABLE IF NOT EXISTS `countries` (
    `code` INT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`code`));

  CREATE TABLE IF NOT EXISTS `userdocs` (
    `id` VARCHAR(45) NOT NULL AUTO_INCREMENT,
    `docName` VARCHAR(45) NOT NULL,
    `docNumber` VARCHAR(45) NOT NULL,
    `docDate` DATE NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_docs`
      FOREIGN KEY (`docName`)
      REFERENCES `docs` (`code`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);
  CREATE INDEX `fk_docs_idx` ON `userdocs` (`docName` ASC);

CREATE TABLE IF NOT EXISTS `organization` (
  `id` VARCHAR(45) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `fullName` VARCHAR(128) NOT NULL,
  `inn` VARCHAR(10) NOT NULL,
  `kpp` VARCHAR(9) NOT NULL,
  `adress` VARCHAR(128) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `isActive` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE IF NOT EXISTS `office` (
  `id` VARCHAR(45) NOT NULL AUTO_INCREMENT,
  `orgId` VARCHAR(45) NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `adress` VARCHAR(128) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `isAtive` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_orgId`
    FOREIGN KEY (`orgId`)
    REFERENCES `organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE INDEX `fk_orgId_idx` ON `office` (`orgId` ASC);

CREATE TABLE IF NOT EXISTS `users` (
  `id` VARCHAR(45) NOT NULL AUTO_INCREMENT,
  `officeId` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `secondName` VARCHAR(45) NOT NULL,
  `middleName` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `userDoc` INT NOT NULL,
  `citizenshipCode` INT NOT NULL,
  `isIdentified` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_officeId`
    FOREIGN KEY (`officeId`)
    REFERENCES `office` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 /* CONSTRAINT `fk_userDoc`
    FOREIGN KEY (`id`)
    REFERENCES `userdocs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,*/
  CONSTRAINT `fk_citizenship`
    FOREIGN KEY (`citizenshipCode`)
    REFERENCES `countries` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE INDEX `fk_officeId_idx` ON `users` (`officeId` ASC);
CREATE INDEX `fk_citizenship_idx` ON `users` (`citizenshipCode` ASC);
  
