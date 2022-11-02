create table categories
(
    id       bigserial primary key,
    title    varchar(255)
);

insert into categories (title)
values ('games'),
       ('products');

create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      int,
    category_id bigint REFERENCES categories (id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);


INSERT INTO products (title, price, category_id) VALUES
                                                     ('Dark Souls', 80, 1),
                                                     ('Dark Souls2', 80, 1),
                                                     ('Dark Souls3', 80, 1),
                                                     ('Bloodborne', 80, 1),
                                                     ('Sekiro', 80, 1),
                                                     ('Elden Ring', 80, 1),
                                                     ('StarCraft', 80, 1),
                                                     ('World of Warcraft ', 80, 1),
                                                     ('World of Warcraft: Wrath of the Lich King', 80, 1),
                                                     ('StarCraft II', 80, 1),
                                                     ('StarCraft II Wings of Liberty', 80, 1),
                                                     ('StarCraft II: Heart of the Swarm', 80, 1),
                                                     ('StarCraft II: Legacy of the Void', 80, 1),
                                                     ('Dota', 80, 1),
                                                     ('Dota 2', 80, 1),
                                                     ('World of Warcraft: Burning Crusade', 80, 1),
                                                     ('World of Warcraft: Cataclysm', 80, 1),
                                                     ('World of Warcraft: Mists of Pandaria', 80, 1),
                                                     ('World of Warcraft: Warlords of Draenor', 80, 1),
                                                     ('Milk', 100, 2),
                                                     ('Bread', 80, 2),
                                                     ('Cheese', 90, 2);



create table users
(
    id         bigserial primary key,
    username   varchar(36) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);



insert into users (username, password, email)
values ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
       ('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');


create table orders
(
    id          bigserial primary key,
    user_id     bigint not null references users (id),
    total_price int    not null,
    address     varchar(255),
    phone       varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into orders (user_id, total_price, address, phone)
values (1, 200, 'address', '12345');


create table order_items
(
    id                bigserial primary key,
    product_id        bigint not null references products (id),
    order_id          bigint not null references orders (id),
    quantity          int    not null,
    price_per_product int    not null,
    price             int    not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);

insert into order_items (product_id, order_id, quantity, price_per_product, price)
values (1, 1, 2, 100, 200);


create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);


insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

create table users_roles
(
    user_id    bigint not null references users (id),
    role_id    bigint not null references roles (id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    primary key (user_id, role_id)
);

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);















