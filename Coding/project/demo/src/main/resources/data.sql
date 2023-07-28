INSERT INTO customer (first_name, last_name) VALUES
    ('John', 'Doe'),
    ('Alice', 'Smith'),
    ('Michael', 'Johnson'),
    ('Emily', 'Williams'),
    ('Robert', 'Brown');

-- 添加订单数据
INSERT INTO customer_order (order_number, order_cost, order_date, customer_id) VALUES
    ('ORDER001', 102.50, '2022-01-10 12:00:00', 1),
    ('ORDER002', 175.25, '2022-02-15 14:30:00', 1),
    ('ORDER003', 82.80, '2022-03-20 10:15:00', 1),
    ('ORDER004', 150.00, '2022-04-05 08:45:00', 2),
    ('ORDER005', 80.50, '2022-05-12 16:20:00', 2),
    ('ORDER006', 200.75, '2022-06-18 09:30:00', 2),
    ('ORDER007', 120.60, '2022-07-25 11:00:00', 3),
    ('ORDER008', 60.90, '2022-08-30 15:45:00', 3),
    ('ORDER009', 45.25, '2022-09-08 18:00:00', 3),
    ('ORDER010', 89.40, '2022-10-15 20:30:00', 4),
    ('ORDER011', 120.20, '2022-11-20 10:45:00', 4),
    ('ORDER012', 180.30, '2022-12-28 13:15:00', 4),
    ('ORDER013', 95.70, '2023-01-05 09:30:00', 5),
    ('ORDER014', 130.10, '2023-02-10 11:45:00', 5),
    ('ORDER015', 155.80, '2023-03-15 14:00:00', 5);