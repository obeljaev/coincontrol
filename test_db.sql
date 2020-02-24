CREATE SCHEMA coin2
  --AUTHORIZATION postgres;

CREATE TABLE coin2.user(
        user_id SERIAL PRIMARY KEY,
        user_name VARCHAR(15),
        user_password VARCHAR(15)
);

CREATE TABLE coin2.category(
        category_id SERIAL PRIMARY KEY,
        category_name VARCHAR(15)
);

CREATE TABLE coin2.sub_category(
        sub_category_id SERIAL PRIMARY KEY,
        category_id SERIAL,
        sub_category_name VARCHAR(15),
        FOREIGN KEY (category_id) REFERENCES coin2.category(category_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

CREATE TABLE coin2.operation(
        operation_id SERIAL PRIMARY KEY,
        sub_category_id INT,
        original_message TEXT,
        FOREIGN KEY (sub_category_id) REFERENCES  coin2.sub_category(sub_category_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);
