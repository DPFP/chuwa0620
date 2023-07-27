INSERT INTO customer(id, name, email) VALUES
                                          (1, 'Customer 1', 'customer1@example.com'),
                                          (2, 'Customer 2', 'customer2@example.com'),
                                          (3, 'Customer 3', 'customer3@example.com');

INSERT INTO transaction(id, customer_id, amount, create_date_time) VALUES
                                                                       (1, 1, 120, CONCAT(DATE_SUB(CURRENT_DATE, INTERVAL 4 MONTH), ' 00:00:00')),
                                                                       (2, 1, 75, CONCAT(DATE_SUB(CURRENT_DATE, INTERVAL 3 MONTH), ' 00:00:00')),
                                                                       (3, 1, 150, CONCAT(DATE_SUB(CURRENT_DATE, INTERVAL 2 MONTH), ' 00:00:00')),
                                                                       (4, 1, 100, CONCAT(DATE_SUB(CURRENT_DATE, INTERVAL 1 MONTH), ' 00:00:00')),
                                                                       (5, 2, 130, CONCAT(DATE_SUB(CURRENT_DATE, INTERVAL 2 MONTH), ' 00:00:00'));
