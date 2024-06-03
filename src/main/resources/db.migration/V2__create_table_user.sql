create table User(
    id bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into user values (1, 'yurastico','contato@yurastico.com')