create table user(
    id bigint not null,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into user values (1, 'yurastico','contato@yurastico.com')