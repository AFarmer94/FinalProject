DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS dresses;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
	customer_id INT unsigned NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(45) NOT NULL, 
	last_name VARCHAR(45) NOT NULL,
	budget VARCHAR(20),
	reservation_id INT unsigned NOT NULL,
	PRIMARY KEY (customer_id)
);

CREATE TABLE dresses (
	dress_id INT unsigned NOT NULL AUTO_INCREMENT,
	designer enum('STELLA YORK', 'BELLA LUX', 'DISCOUNT DAVE') NOT NULL,
	color VARCHAR(60) NOT NULL,
	reservation BOOLEAN NOT NULL,
	price INT,
	PRIMARY KEY(dress_id)
);

CREATE TABLE reservations (
	customer_id INT unsigned NOT NULL,
	dress_id INT unsigned NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE,
	FOREIGN KEY (dress_id) REFERENCES dresses (dress_id) ON DELETE CASCADE,
	UNIQUE KEY (customer_id, dress_id)
);