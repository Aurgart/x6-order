CREATE TABLE x6_order.order
(
    order_id serial NOT NULL,
    order_date date NOT NULL default now(),
    user_id int NOT NULL,
    description varchar,
    PRIMARY KEY (order_id)
);

CREATE TABLE x6_order.order_products
(
   order_id int NOT NULL,
   product_id int not null,
   quantity int not null,
   comments varchar,
   update_date date,
   primary key(order_id, product_id)
);


ALTER TABLE x6_order.order_products
ADD CONSTRAINT fk_order_products FOREIGN KEY (order_id)
REFERENCES x6_order.order(order_id)
ON DELETE CASCADE
ON UPDATE NO ACTION;