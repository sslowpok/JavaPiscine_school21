insert into chat.user (login, password) values ('Tom', 'password_tom');
insert into chat.user (login, password) values ('Mike', 'password_mike');
insert into chat.user (login, password) values ('John', 'password_john');

insert into chat.chatroom (name, owner) values ('room1', 1);
insert into chat.chatroom (name, owner) values ('room2', 2);
insert into chat.chatroom (name, owner) values ('room3', 3);

insert into chat.message (author, room, text, date) values (1, 1, 'hi from tom in room 1', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, room, text, date) values (2, 1, 'hi from mike in room 1', to_timestamp(1388534400+random()*63071999));
insert into chat.message (author, room, text, date) values (2, 2, 'hi from mike in room 2', to_timestamp(1388534400+random()*63071999));
