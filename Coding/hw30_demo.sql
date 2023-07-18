-- Task 1: Create test DB
CREATE DATABASE testDB;

-- Task 2: Create oms_company_address table
USE testDB;
CREATE TABLE oms_company_address (
  id INT AUTO_INCREMENT PRIMARY KEY,
  companyName VARCHAR(255),
  address VARCHAR(255)
);

-- Task 3: Insert few random entries to oms_company_address table
INSERT INTO oms_company_address (companyName, address) VALUES
  ('Company 1', 'Address 1'),
  ('Company 2', 'Address 2'),
  ('Company 3', 'Address 3');

-- Task 4: Read one entry from oms_company_address table
SELECT * FROM oms_company_address WHERE id = 1;

-- Task 5: Read all entries from oms_company_address table
SELECT * FROM oms_company_address;

-- Task 6: Update one entry in oms_company_address table
UPDATE oms_company_address SET address = 'New Address' WHERE id = 1;

-- Task 7: Remove one entry from oms_company_address table
DELETE FROM oms_company_address WHERE id = 1;
