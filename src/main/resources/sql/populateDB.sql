DELETE FROM dishes;
DELETE FROM users;
DELETE FROM restaurants;
DELETE FROM votes;

INSERT INTO users (id, email, password) VALUES
  (1, 'user@gmail.com', '12345'),
  (2, 'admin@gmail.com', '12345');

INSERT INTO user_role (user_id, role) VALUES
  (1, 'USER'),
  (2, 'ADMIN');

INSERT INTO restaurants (id, name) VALUES
  (100, 'Restaurant0'),
  (101, 'Restaurant1'),
  (102, 'Restaurant2'),
  (103, 'Restaurant3'),
  (104, 'Restaurant4');

INSERT INTO dishes (id, name, price, restaurant_id) VALUES
  (200, 'Dish0', 1.23, 100),
  (201, 'Dish1', 1.23, 100),
  (202, 'Dish2', 1.23, 101),
  (203, 'Dish3', 1.23, 101),
  (204, 'Dish4', 1.23, 102),
  (205, 'Dish5', 1.23, 102),
  (206, 'Dish6', 1.23, 103),
  (207, 'Dish7', 1.23, 103),
  (208, 'Dish8', 1.23, 104),
  (209, 'Dish9', 1.23, 104);