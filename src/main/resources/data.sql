DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS bookings;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL
);

CREATE TABLE bookings (
  id INT AUTO_INCREMENT PRIMARY KEY,
  court INT NOT NULL,
  date VARCHAR(10) NOT NULL,
  hour INT NOT NULL,
  username VARCHAR(250) NOT NULL
);

INSERT INTO users (id, username, email, password)
VALUES (1, 'user', 'user@domain.com', 'password');
INSERT INTO users (id, username, email, password)
VALUES (2, 'user2', 'user2@domain.com', 'password2');

INSERT INTO bookings (id, court, date, hour, username)
VALUES (1, 1, '2020-06-11', 10, 'user');
INSERT INTO bookings (id, court, date, hour, username)
VALUES (2, 2, '2020-06-11', 10, 'user2');
INSERT INTO bookings (id, court, date, hour, username)
VALUES (3, 1, '2020-06-11', 11, 'user');
