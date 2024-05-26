create table topic(
    id bigint not null,
    title varchar(50) not null,
    message varchar(300) not null,
    status varchar(20) not null,
    created_at datetime not null,
    course_id bigint not null,
    author_id bigint not null
    primary key(id),
    foreign key (course_id) references course(id),
    foreign key (author_id) references user(id)
);

insert into course values (1, 'kotlin','programming')