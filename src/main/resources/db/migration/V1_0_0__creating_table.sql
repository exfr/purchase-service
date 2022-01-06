CREATE TABLE purchase
(
    purchase_id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    user_id     INTEGER   NOT NULL,
    create_at   TIMESTAMP NOT NULL
);
CREATE TABLE product
(
    product_db_id  INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    product_id     INTEGER     NOT NULL,
    name           VARCHAR(55) NOT NULL,
    shop_id        INTEGER     NOT NULL,
    price          DECIMAL     NOT NULL,
    count          INT(40) NOT NULL,
    purchase_id_fk INTEGER,
    FOREIGN KEY (purchase_id_fk) REFERENCES purchase (purchase_id)
);
INSERT INTO purchase (user_id, create_at)
VALUES (1, CURRENT_TIMESTAMP()),
       (2, CURRENT_TIMESTAMP());
INSERT INTO product (product_id, name, shop_id, price, count, purchase_id_fk)
VALUES (1, 'Shapka', 1, 500, 2, 1),
       (2, 'Kurtka', 1, 1500, 1, 1),
       (3, 'Koniky', 1, 500, 2, 2),
       (4, 'Luge', 1, 1500, 1, 2);

