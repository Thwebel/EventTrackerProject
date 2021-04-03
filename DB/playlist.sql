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
  `date_created` DATETIME NULL,
  `last_updated` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `artist` ;

CREATE TABLE IF NOT EXISTS `artist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NULL,
  `formation_date` DATETIME NULL,
  `artwork` VARCHAR(500) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `album` ;

CREATE TABLE IF NOT EXISTS `album` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NULL,
  `track_count` INT NULL,
  `release_year` INT NULL,
  `artwork` VARCHAR(500) NULL,
  `artist_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_album_artist1_idx` (`artist_id` ASC),
  CONSTRAINT `fk_album_artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `artist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `track`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `track` ;

CREATE TABLE IF NOT EXISTS `track` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(300) NULL,
  `duration` TIME NULL,
  `genre` VARCHAR(100) NULL,
  `description` TEXT NULL,
  `youtube_link` VARCHAR(500) NULL,
  `track_number` INT NULL,
  `album_id` INT NULL,
  `artist_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_track_album1_idx` (`album_id` ASC),
  INDEX `fk_track_artist1_idx` (`artist_id` ASC),
  CONSTRAINT `fk_track_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `album` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_track_artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `artist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `playlist_has_track`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `playlist_has_track` ;

CREATE TABLE IF NOT EXISTS `playlist_has_track` (
  `playlist_id` INT NOT NULL,
  `track_id` INT NOT NULL,
  PRIMARY KEY (`playlist_id`, `track_id`),
  INDEX `fk_playlist_has_Track_Track1_idx` (`track_id` ASC),
  INDEX `fk_playlist_has_Track_playlist_idx` (`playlist_id` ASC),
  CONSTRAINT `fk_playlist_has_Track_playlist`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `playlist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_has_Track_Track1`
    FOREIGN KEY (`track_id`)
    REFERENCES `track` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
INSERT INTO `playlist` (`id`, `title`, `description`, `curator`, `date_created`, `last_updated`) VALUES (1, 'A', 'First playlist I created for Ash', 'Webel', '2018-02-14 10:30:30', '2018-02-14 10:30:30');

COMMIT;


-- -----------------------------------------------------
-- Data for table `artist`
-- -----------------------------------------------------
START TRANSACTION;
USE `playlistdb`;
INSERT INTO `artist` (`id`, `name`, `formation_date`, `artwork`, `description`) VALUES (1, 'Cyrille Aimée', NULL, NULL, NULL);
INSERT INTO `artist` (`id`, `name`, `formation_date`, `artwork`, `description`) VALUES (2, 'Artic Monkeys', NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `album`
-- -----------------------------------------------------
START TRANSACTION;
USE `playlistdb`;
INSERT INTO `album` (`id`, `name`, `track_count`, `release_year`, `artwork`, `artist_id`) VALUES (1, 'Let\'s Get Lost', 14, 2016, NULL, 1);
INSERT INTO `album` (`id`, `name`, `track_count`, `release_year`, `artwork`, `artist_id`) VALUES (2, 'Whatever People Sam I Am, That\'s What I\'m Not', 12, 206, NULL, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `track`
-- -----------------------------------------------------
START TRANSACTION;
USE `playlistdb`;
INSERT INTO `track` (`id`, `name`, `duration`, `genre`, `description`, `youtube_link`, `track_number`, `album_id`, `artist_id`) VALUES (1, 'Each Day (feat. Matt Simons)', '00:03:26', 'Vocal Jazz', NULL, 'https://www.youtube.com/watch?v=IBBqpYlHHpY&ab_channel=CyrilleAim%C3%A9e-Topic', 12, 1, 1);
INSERT INTO `track` (`id`, `name`, `duration`, `genre`, `description`, `youtube_link`, `track_number`, `album_id`, `artist_id`) VALUES (2, 'Mardy Bum', '00:02:57', 'Alternative', NULL, NULL, 9, 2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `playlist_has_track`
-- -----------------------------------------------------
START TRANSACTION;
USE `playlistdb`;
INSERT INTO `playlist_has_track` (`playlist_id`, `track_id`) VALUES (1, 1);
INSERT INTO `playlist_has_track` (`playlist_id`, `track_id`) VALUES (1, 2);

COMMIT;

