-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema liftdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `liftdb` ;

-- -----------------------------------------------------
-- Schema liftdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `liftdb` DEFAULT CHARACTER SET utf8 ;
USE `liftdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(150) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `created_on` DATETIME NULL,
  `updated_on` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lift`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lift` ;

CREATE TABLE IF NOT EXISTS `lift` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `weight` INT NULL,
  `total_sets` INT NULL,
  `total_reps` INT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lift_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_lift_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_lifts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_lifts` ;

CREATE TABLE IF NOT EXISTS `favorite_lifts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `lift_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_favorite_lifts_user1_idx` (`user_id` ASC),
  INDEX `fk_favorite_lifts_lift1_idx` (`lift_id` ASC),
  CONSTRAINT `fk_favorite_lifts_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_favorite_lifts_lift1`
    FOREIGN KEY (`lift_id`)
    REFERENCES `lift` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lift_rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lift_rating` ;

CREATE TABLE IF NOT EXISTS `lift_rating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` INT NOT NULL,
  `user_id` INT NOT NULL,
  `lift_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lift_rating_user1_idx` (`user_id` ASC),
  INDEX `fk_lift_rating_lift1_idx` (`lift_id` ASC),
  CONSTRAINT `fk_lift_rating_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lift_rating_lift1`
    FOREIGN KEY (`lift_id`)
    REFERENCES `lift` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS liftuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'liftuser'@'localhost' IDENTIFIED BY 'liftuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'liftuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `liftdb`;
INSERT INTO `user` (`id`, `username`, `password`, `email`, `created_on`, `updated_on`) VALUES (1, 'Kyle', 'pw', 'pw@gmail.com', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `lift`
-- -----------------------------------------------------
START TRANSACTION;
USE `liftdb`;
INSERT INTO `lift` (`id`, `name`, `weight`, `total_sets`, `total_reps`, `user_id`) VALUES (1, 'Deadlift', 365, 2, 2, 1);
INSERT INTO `lift` (`id`, `name`, `weight`, `total_sets`, `total_reps`, `user_id`) VALUES (2, 'Squat', 285, 3, 5, 1);
INSERT INTO `lift` (`id`, `name`, `weight`, `total_sets`, `total_reps`, `user_id`) VALUES (3, 'Overhead Press', 165, 3, 5, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `favorite_lifts`
-- -----------------------------------------------------
START TRANSACTION;
USE `liftdb`;
INSERT INTO `favorite_lifts` (`id`, `user_id`, `lift_id`) VALUES (1, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `lift_rating`
-- -----------------------------------------------------
START TRANSACTION;
USE `liftdb`;
INSERT INTO `lift_rating` (`id`, `rating`, `user_id`, `lift_id`) VALUES (1, 5, 1, 1);

COMMIT;

