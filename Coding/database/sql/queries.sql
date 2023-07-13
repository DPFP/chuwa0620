-- create
CREATE TABLE oms_company_address (
  id INTEGER PRIMARY KEY,
  address_name varchar(200),
  send_status int(1),
  receive_status int(1),
  name varchar(64),
  phone varchar(64),
  province varchar(64),
  city varchar(64),
  region varchar(64),
  detail_address varchar(64)
);

-- insert
INSERT INTO oms_company_address VALUES (1,
                                      'myaddress',
                                      1,
                                      0,
                                      'Xilin', 
                                      '7349688779', 
                                      'Michigan', 
                                      'Ann Arbor', 
                                      null,
                                      '3030 whisperwood');

INSERT INTO oms_company_address VALUES (2,
                                      'myaddress2',
                                      1,
                                      1,
                                      'Jun Wang', 
                                      '7349688779', 
                                      'New York', 
                                      'New York City', 
                                      null,
                                      '214 Willow Run');
                                      
INSERT INTO oms_company_address VALUES (3,
                                      'myaddress3',
                                      0,
                                      0,
                                      'Takashi', 
                                      '7349688779', 
                                      'California', 
                                      'Goleta', 
                                      null,
                                      '204 Leslie');


INSERT INTO oms_company_address VALUES (4,
                                      'myaddress4',
                                      1,
                                      0,
                                      'Alie', 
                                      '7349688779', 
                                      'Florida', 
                                      'Miami', 
                                      null,
                                      '204 Leslie');
                                    
                                    
Select * from oms_company_address;

Select * from oms_company_address limit 3;

Update oms_company_address SET phone = '666-6666-888';

Select * from oms_company_address;

Delete from oms_company_address
Where id = 1;

Select * from oms_company_address;
