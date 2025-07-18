
CREATE DATABASE auctiondatabase;
USE auctiondatabase;


CREATE TABLE product_type (
  cid INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DOUBLE NOT NULL,
  status VARCHAR(50) NOT NULL,
  product_type_id INT,
  FOREIGN KEY (product_type_id) REFERENCES product_type(cid)
);
INSERT INTO product_type(name) VALUES
  ('Phone'),
  ('Refrigerator'),
  ('TV');


INSERT INTO product(name, price, status, product_type_id) VALUES
  ('iPhone 12', 110000, 'pending', 1),
  ('iPhone 12 Pro', 150000, 'pending', 1),
  ('Samsung Galaxy S21', 120000, 'pending', 1),
  ('Samsung Galaxy Note 20', 130000, 'pending', 1),
  ('Xiaomi Mi 11', 90000, 'pending', 1),
  ('LG Refrigerator X100', 200000, 'pending', 2),
  ('Samsung Refrigerator R500', 220000, 'pending', 2),
  ('Panasonic Fridge Z300', 210000, 'pending', 2),
  ('LG Tivi 55inch', 160000, 'pending', 3),
  ('Samsung Tivi 65inch', 180000, 'pending', 3),
  ('Sony Tivi 50inch', 140000, 'pending', 3),
  ('Xiaomi Tivi 43inch', 130000, 'pending', 3),
  ('Oppo A54', 80000, 'pending', 1),
  ('Huawei P40', 100000, 'pending', 1),
  ('Nokia 8.3', 95000, 'pending', 1),
  ('Sharp Refrigerator S300', 205000, 'pending', 2),
  ('Electrolux Fridge E200', 215000, 'pending', 2),
  ('TCL Tivi 32inch', 100000, 'pending', 3),
  ('Hisense Tivi 40inch', 120000, 'pending', 3),
  ('VSmart Active 3', 85000, 'pending', 1);
select * from product;
select * from product_type;
