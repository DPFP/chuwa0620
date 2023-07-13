-- 1. Create table oms_company_address
CREATE TABLE `chuwa_hw6`.`oms_company_address` (
  `id` BIGINT(8) ZEROFILL NOT NULL,
  `address_name` VARCHAR(200) NULL,
  `send_status` INT(1) NULL,
  `receive_status` INT(1) NULL,
  `name` VARCHAR(64) NULL,
  `phone` VARCHAR(64) NULL,
  `province` VARCHAR(64) NULL,
  `city` VARCHAR(64) NULL,
  `region` VARCHAR(64) NULL,
  `detail_address` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));

-- 2. Insert few random entries to  oms_company_address  collection
INSERT INTO `chuwa_hw6`.`oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`) VALUES ('1', 'Apple', '1', '0', 'Apple', '12345', 'A_Province', 'A_City', 'A_Region', 'aaaaaaa');
INSERT INTO `chuwa_hw6`.`oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`) VALUES ('2', 'Google', '1', '0', 'Google', '56789', 'B_Province', 'B_City', 'B_Region', 'bbbbbbb');
INSERT INTO `chuwa_hw6`.`oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`) VALUES ('3', 'Microsoft', '0', '0', 'Microsoft', '00000', 'C_Province', 'C_City', 'C_Region', 'cccccccc');

-- 3. Read one entry from  oms_company_address  collection
SELECT * FROM `oms_company_address` LIMIT 1;

-- 4. Read all entries from  oms_company_address  collection
SELECT * FROM `oms_company_address`;

-- 5. Update one entry from  oms_company_address collection
UPDATE `chuwa_hw6`.`oms_company_address` SET `phone` = '01234', `detail_address` = 'mmmmm' WHERE (`id` = '00000003');

-- 6. Remove one entry from  oms_company_address collection
DELETE FROM `chuwa_hw6`.`oms_company_address` WHERE (`id` = '00000003');
