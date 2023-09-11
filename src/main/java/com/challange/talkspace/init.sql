
create table person
(
    id         serial
        primary key,
    "userName" varchar(30)       not null,
    login      varchar           not null,
    password   varchar(30)       not null,
    role       integer default 2 not null
);

create table role
(
    id         integer not null
        primary key,
    "roleName" varchar default USER
);
create table message
(
    id            serial
        primary key,
    "chatId"      varchar   not null,
    sender        varchar   not null,
    recipient     varchar   not null,
    "MessageType" varchar   not null,
    content       text,
    timestamp     timestamp not null,
    status        varchar   not null
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

create table "chatRoom"
(
    id            serial
        primary key,
    "chatId"      varchar not null,
    "senderId"    integer not null,
    "recepientId" integer not null
);

