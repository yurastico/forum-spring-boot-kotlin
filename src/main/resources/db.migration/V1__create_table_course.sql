create table course(
    id bigint not null,
    name varchar(50) not null,
    category varchar(50) not null,
    primary key(id)
);

insert into course values (1, 'kotlin','programming')