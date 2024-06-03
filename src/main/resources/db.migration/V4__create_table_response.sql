create table Responses(
    id bigint not null auto_increment,
    message varchar(300) not null,
    created_at datetime not null,
    category varchar(50) not null,
    topic_id bigint not null,
    author_id bigint not null,
    resolved int(1) not null,
    foreign key (topic_id) references course(id),
    foreign key (author_id) references user(id)
    primary key(id)
);

insert into course values (1, 'kotlin','programming')