create database relational_database_demo;

use relational_database_demo;
CREATE TABLE `oms_company_address` (
    `id` BIGINT,
    `address_name` VARCHAR(200),
    `send_status` INT,
    `receive_status` INT,
    `name` VARCHAR(64),
    `phone` VARCHAR(64),
    `province` VARCHAR(64),
    `city` VARCHAR(64),
    `region` VARCHAR(64),
    `detail_address` VARCHAR(200),
    PRIMARY KEY (`id`)
);

INSERT INTO `oms_company_address` (`id`, `address_name`, `send_status`, `receive_status`, `name`, `phone`, `province`, `city`, `region`, `detail_address`)
VALUES
    (1, 'Address 1', 1, 0, 'John Doe', '1234567890', 'Province 1', 'City 1', 'Region 1', 'Detail Address 1'),
    (2, 'Address 2', 0, 1, 'Jane Smith', '9876543210', 'Province 2', 'City 2', 'Region 2', 'Detail Address 2'),
    (3, 'Address 3', 1, 1, 'Bob Johnson', '5555555555', 'Province 3', 'City 3', 'Region 3', 'Detail Address 3');

use relational_database_demo;
select * from oms_company_address;

SELECT *
FROM `oms_company_address`
ORDER BY `id`
LIMIT 3;

UPDATE `oms_company_address`
SET `phone` = '666-6666-8888';

DELETE FROM `oms_company_address`
WHERE `id` = 1;