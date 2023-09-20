Insert Into "chatType" ("chatTypeName")
VALUES ('PRIVATE'),
       ('GROUP');


Insert Into "user" ("userName", login, password, role)
VALUES ('Nataly', 'Nat', 111,2),
       ('Mykola', 'Mykola', 111, 1);

Insert Into "chatGroup" ("chatGroupName", description)
VALUES ('Developpers', 'Group of Developpers'),
       ('Designers', 'Group of Designers'),
       ('QA', 'Group of QA Testers'),
       ('All users', 'Group for All in TalkSpace');

