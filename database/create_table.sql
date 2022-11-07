CREATE TABLE `heroku_32a669853cca0e4`.`about` (
  `id` BIGINT(25) NOT NULL,
  `name` VARCHAR(255) NULL,
  `description` VARCHAR(2000) NULL,
  `detail` VARCHAR(1000) NULL,
  `status` INT NULL,
  `image` VARCHAR(255) NULL,
  `createddate` TIMESTAMP(6) NULL,
  `createdby` VARCHAR(255) NULL,
  `modifieddate` TIMESTAMP(6) NULL,
  `modifiedby` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`banner` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `image` VARCHAR(255) NULL,
  `info` VARCHAR(255) NULL,
  `createddate` TIMESTAMP(6) NULL,
  `createdby` VARCHAR(255) NULL,
  `modifieddate` TIMESTAMP(6) NULL,
  `modifiedby` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`category` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `code` VARCHAR(255) NULL,
  `status` INT NULL,
  `sort` INT NULL,
  `parrentid` VARCHAR(255) NULL,
  `metakeywords` VARCHAR(255) NULL,
  `metadescriptions` VARCHAR(255) NULL,
  `createddate` TIMESTAMP(6) NULL,
  `createdby` VARCHAR(255) NULL,
  `modifieddate` TIMESTAMP(6) NULL,
  `modifiedby` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`color` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `code` VARCHAR(255) NULL,
  `style` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `detail` VARCHAR(255) NULL,
  `status` INT NULL,
  `address` VARCHAR(255) NULL,
  `phone` BIGINT(25) NULL,
  `email` VARCHAR(255) NULL,
  `createddate` TIMESTAMP(6) NULL,
  `createdby` VARCHAR(255) NULL,
  `modifieddate` TIMESTAMP(6) NULL,
  `modifiedby` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`feedback` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `phone` BIGINT(25) NULL,
  `address` VARCHAR(255) NULL,
  `detail` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`notification` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `userid` BIGINT(25) NULL,
  `content` VARCHAR(1000) NULL,
  `status` INT NULL,
  `createddate` TIMESTAMP(6) NULL,
  `statusorders` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`orderdetail` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `ordersid` BIGINT(25) NULL,
  `productid` BIGINT(25) NULL,
  `productname` VARCHAR(255) NULL,
  `price` BIGINT(25) NULL,
  `quantity` BIGINT(25) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`orders` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `status` INT NULL,
  `delivered` INT NULL,
  `userid` BIGINT(25) NULL,
  `discount` BIGINT(25) NULL,
  `address` VARCHAR(255) NULL,
  `phone` BIGINT(25) NULL,
  `orderdate` TIMESTAMP(6) NULL,
  `deliverydate` TIMESTAMP(6) NULL,
  `total` BIGINT(25) NULL,
  `confirm` INT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`product` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `code` VARCHAR(255) NULL,
  `status` INT NULL,
  `image` VARCHAR(255) NULL,
  `listimage` VARCHAR(255) NULL,
  `thumbnail1` VARCHAR(255) NULL,
  `thumbnail2` VARCHAR(255) NULL,
  `thumbnail3` VARCHAR(255) NULL,
  `price` BIGINT(25) NULL,
  `discount` BIGINT(25) NULL,
  `quantity` BIGINT(25) NULL,
  `description` VARCHAR(255) NULL,
  `detail` VARCHAR(255) NULL,
  `view` BIGINT(25) NULL,
  `hot` INT NULL,
  `colorid` BIGINT(25) NULL,
  `sizeid` BIGINT(25) NULL,
  `brandid` BIGINT(25) NULL,
  `supplierid` BIGINT(25) NULL,
  `categoryid` BIGINT(25) NULL,
  `metakeywords` VARCHAR(255) NULL,
  `metadescriptions` VARCHAR(255) NULL,
  `createdby` VARCHAR(255) NULL,
  `modifiedby` VARCHAR(255) NULL,
  `size` VARCHAR(255) NULL,
  `createddate` TIMESTAMP(6) NULL,
  `modifieddate` TIMESTAMP(6) NULL,
  `popularity` BIGINT(25) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`role` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `code` VARCHAR(255) NULL,
  `createddate` TIMESTAMP(6) NULL,
  `createdby` VARCHAR(255) NULL,
  `modifieddate` TIMESTAMP(6) NULL,
  `modifiedby` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`size` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `code` VARCHAR(255) NULL,
  `productid` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`slide` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `image` VARCHAR(255) NULL,
  `sort` INT NULL,
  `link` VARCHAR(255) NULL,
  `status` INT NULL,
  `info` VARCHAR(255) NULL,
  `createddate` TIMESTAMP(6) NULL,
  `modifieddate` TIMESTAMP(6) NULL,
  `createdby` VARCHAR(255) NULL,
  `modifiedby` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `heroku_32a669853cca0e4`.`users` (
  `id` BIGINT(25) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `roleid` BIGINT(25) NULL,
  `fullname` VARCHAR(255) NULL,
  `status` BIGINT(25) NULL,
  `email` VARCHAR(255) NULL,
  `phone` BIGINT(25) NULL,
  `address` VARCHAR(255) NULL,
  `avatar` VARCHAR(255) NULL,
  `createddate` TIMESTAMP(6) NULL,
  `createdby` VARCHAR(255) NULL,
  `modifieddate` TIMESTAMP(6) NULL,
  `modifiedby` VARCHAR(255) NULL,
  `totalorders` BIGINT(25) NULL,
  `totalprice` BIGINT(25) NULL,
  PRIMARY KEY (`id`));
  
  
  