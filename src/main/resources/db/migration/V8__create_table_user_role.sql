create table user_role(
    `id` BIGINT NOT NULL auto_increment,
    `user_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY(`user_id`) REFERENCES `user`(`id`),
    FOREIGN KEY(`role_id`) REFERENCES `role`(`id`)
);

insert into user_role (id, user_id,role_id) values (1,1,1);