create table sys_user
(
    id                  bigserial
        primary key,
    name                varchar(32)               not null,
    username            varchar(20)               not null
        constraint sys_user_uk
            unique,
    phone               varchar(32),
    email               varchar(32),
    password            varchar                   not null,
    role_id             bigint                    not null,
    created_by_id       bigint,
    created_date        timestamptz default now() not null,
    last_modified_by_id bigint,
    last_modified_date  timestamptz default now() not null
);

comment on table sys_user is '用户';

comment on column sys_user.name is '名称';

comment on column sys_user.phone is '手机号';

comment on column sys_user.email is '邮箱';

comment on column sys_user.role_id is 'sys_role.id';

create table sys_role
(
    id                  bigserial
        primary key,
    name                varchar(32)               not null,
    remark              varchar,
    authority           varchar(32)               not null,
    created_by_id       bigint,
    created_date        timestamptz default now() not null,
    last_modified_by_id bigint,
    last_modified_date  timestamptz default now() not null
);

comment on table sys_role is '角色表';

insert into sys_role (name, remark, authority)
values ('管理员', '管理员', 'ADMIN');
insert into sys_role (name, remark, authority)
values ('普通用户', '普通用户', 'USER');

create table todo_task
(
    id                  bigserial
        primary key,
    name                varchar                   not null,
    note                text                      null,
    is_done             bool        default false not null,
    created_by_id       bigint,
    created_date        timestamptz default now() not null,
    last_modified_by_id bigint,
    last_modified_date  timestamptz default now() not null
);

comment on table todo_task is '代办任务';

create table cook_menu
(
    id                  bigserial
        primary key,
    title               varchar(20)               not null,
    subtitle            varchar(40)               null,
    description         varchar                   null,
    created_by_id       bigint,
    created_date        timestamptz default now() not null,
    last_modified_by_id bigint,
    last_modified_date  timestamptz default now() not null
);

create table cook_food
(
    id                  bigserial
        primary key,
    name                varchar                   not null,
    price               decimal                   not null,
    description         varchar                   null,
    image               text                      null,
    menu_id             bigint                    not null,
    created_by_id       bigint,
    created_date        timestamptz default now() not null,
    last_modified_by_id bigint,
    last_modified_date  timestamptz default now() not null
);

create table cook_cart
(
    id                  bigserial
        primary key,
    menu_id             bigint                    not null,
    food_id             bigint                    not null,
    num                 integer                   not null,
    created_by_id       bigint,
    created_date        timestamptz default now() not null,
    last_modified_by_id bigint,
    last_modified_date  timestamptz default now() not null
);

comment on table cook_cart is '购物车';


