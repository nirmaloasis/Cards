CREATE TABLE `statistics` (
  `id`          INT                 NOT NULL  AUTO_INCREMENT,
  `version`     INT                 NOT NULL  DEFAULT 0,
  `result`      ENUM('WON', 'LOST') NOT NULL,
  `bet_amount`  INT      NOT NULL,
  `user_id`     INT                 NOT NULL,
  `created`     TIMESTAMP           NOT NULL  DEFAULT NOW(),
  `modified`    TIMESTAMP           NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);