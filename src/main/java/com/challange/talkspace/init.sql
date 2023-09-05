
create table person
(
    id             bigserial
        primary key
        unique,
    role_id        bigint default 2
        constraint
            references role,
    password       varchar(255),
    user_name      varchar(255) not null
        unique,
    "chatGroup_id" integer
);

create table role
(
    id         bigserial
        primary key
        unique,
    "roleName" varchar(255) not null
        constraint role_role_name_key
            unique
        constraint role_role_name_check
            check (("roleName")::text = ANY ((ARRAY ['ADMIN'::character varying, 'USER'::character varying])::text[]))
);
create table message
(
    chat_group_id bigint
        constraint fk9cncym3nmvlewt5dx6jjoaurc
            references chat_group,
    id            bigserial
        primary key
        unique,
    sender_id     bigint
        constraint fk6p9dy39ram5rqdl84nciff92j
            references person,
    timestamp     timestamp(6),
    content       varchar(255)
);

create table "chatType"
(
    id             serial
        primary key
        unique,
    "chatTypeName" varchar(30) not null
);

create table "chatGroup"
(
    id              serial
        primary key
        unique,
    "chatGroupName" varchar(30) not null,
    description     varchar(50) not null
);

create table "chatThread"
(
    id               integer     not null,
    "chatThreadName" varchar(60) not null
);

