create table if not exists products (
    id          bigserial primary key,
    title       varchar(255),
    price       int
);

INSERT INTO products (title, price) VALUES
                                        ('Dark Souls', 80),
                                        ('Dark Souls2', 80),
                                        ('Dark Souls3', 80),
                                        ('Bloodborne', 80),
                                        ('Sekiro', 80),
                                        ('Elden Ring', 80),
                                        ('StarCraft', 80),
                                        ('World of Warcraft ', 80),
                                        ('World of Warcraft: Wrath of the Lich King', 80),
                                        ('StarCraft II', 80),
                                        ('StarCraft II Wings of Liberty', 80),
                                        ('StarCraft II: Heart of the Swarm', 80),
                                        ('StarCraft II: Legacy of the Void', 80),
                                        ('Dota', 80),
                                        ('Dota 2', 80),
                                        ('World of Warcraft: Burning Crusade', 80),
                                        ('World of Warcraft: Cataclysm', 80),
                                        ('World of Warcraft: Mists of Pandaria', 80),
                                        ('World of Warcraft: Warlords of Draenor', 80);

create table users (
    id         bigserial primary key,
    username   varchar(36) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles (
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles (
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('bob', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
       ('john', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);