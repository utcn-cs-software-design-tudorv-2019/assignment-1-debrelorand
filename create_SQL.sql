DROP DATABASE `ComputerScience`;
CREATE DATABASE IF NOT EXISTS `ComputerScience`;
USE `ComputerScience`;

CREATE TABLE IF NOT EXISTS `ComputerScience`.`Administrator` (
  `idAdministrator` INT NOT NULL AUTO_INCREMENT=120,
  `nume` VARCHAR(45) NULL,
  `prenume` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(70) NULL,
  `cnp` VARCHAR(13) NULL,
  `adresa` VARCHAR(120) NULL,
  `email` VARCHAR(120) NULL,
  `catedra` VARCHAR(45) NULL,
  PRIMARY KEY (`idAdministrator`));

CREATE TABLE IF NOT EXISTS `ComputerScience`.`Student` (
  `idStudent` INT NOT NULL AUTO_INCREMENT=27100,
  `nume` VARCHAR(45) NULL,
  `prenume` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(70) NULL,
  `cnp` VARCHAR(13) NULL,
  `adresa` VARCHAR(120) NULL,
  `email` VARCHAR(100) NULL,
  `grupa` VARCHAR(45) NULL,
  PRIMARY KEY (`idStudent`));

CREATE TABLE IF NOT EXISTS `ComputerScience`.`Course` (
  `idCourse` INT NOT NULL AUTO_INCREMENT,
  `idAdministrator` INT NOT NULL,
  `nume` VARCHAR(45) NULL,
  `credit` INT NULL,
  PRIMARY KEY (`idCourse`),
  CONSTRAINT `key1`
    FOREIGN KEY (`idAdministrator`)
    REFERENCES `ComputerScience`.`Administrator` (`idAdministrator`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `ComputerScience`.`Enrollment` (
  `idEnrollment` INT NOT NULL AUTO_INCREMENT,
  `idStudent` INT NOT NULL,
  `idCourse` INT NOT NULL,
  `startDate` DATE NULL,
  `finishDate` DATE NULL,
  `nota` INT NULL,
  PRIMARY KEY (`idEnrollment`),
  CONSTRAINT `key2`
    FOREIGN KEY (`idStudent`)
    REFERENCES `ComputerScience`.`Student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `key3`
    FOREIGN KEY (`idCourse`)
    REFERENCES `ComputerScience`.`Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);