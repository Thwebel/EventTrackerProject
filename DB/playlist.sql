-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema playlistdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `playlistdb` ;

-- -----------------------------------------------------
-- Schema playlistdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `playlistdb` DEFAULT CHARACTER SET utf8 ;
USE `playlistdb` ;

-- -----------------------------------------------------
-- Table `playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `playlist` ;

CREATE TABLE IF NOT EXISTS `playlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NULL,
  `description` TEXT NULL,
  `curator` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS musicuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'musicuser'@'localhost' IDENTIFIED BY 'musicuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'musicuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `playlist`
-- -----------------------------------------------------
START TRANSACTION;
USE `playlistdb`;
INSERT INTO `playlist` (`id`, `title`, `description`, `curator`) VALUES (1, 'Tommy\'s Playlist', 'Really good', 'Asha');

COMMIT;

