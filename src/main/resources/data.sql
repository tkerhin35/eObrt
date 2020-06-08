insert into roles(name) values ('ROLE_USER');
insert into roles(name) values ('ROLE_ADMIN');
insert into roles(name) values ('ROLES_SUPERADMIN');

insert into users(name, password, email, enabled) values ('Frizerski salon Irena', '$2y$12$SOGy5BV961fjLgtIr1Ks7.53t/vFFPpENkLvjQhfy35QGGbYgxGka',
    'ikerhin@gmail.com', false );
insert into users(name, password, email, enabled) values ('Kozmetički salon Piljek', '$2y$12$SOGy5BV961fjLgtIr1Ks7.53t/vFFPpENkLvjQhfy35QGGbYgxGka',
    'ipiljek@gmail.com', false );
insert into users(name, password, email, enabled) values ('Brijač Potepuh', '$2y$12$SOGy5BV961fjLgtIr1Ks7.53t/vFFPpENkLvjQhfy35QGGbYgxGka',
    'potepuh@gmail.com', false );
insert into users(name, password, email, enabled) values ('Administrator', '$2y$12$SOGy5BV961fjLgtIr1Ks7.53t/vFFPpENkLvjQhfy35QGGbYgxGka',
    'admin@gmail.com', false );


insert into users_roles(user_id, role_id) values (1,1);
insert into users_roles(user_id, role_id) values (2,1);
insert into users_roles(user_id, role_id) values (3,1);
insert into users_roles(user_id, role_id) values (4,2);


insert into locations(name, city_name, user_id) values ('Stenjevec', 'Zagreb', 1);
insert into locations(name, city_name, user_id) values ('Dubrava', 'Zagreb', 1);
insert into locations(name, city_name, user_id) values ('Mertojak', 'Split', 2);
insert into locations(name, city_name, user_id) values ('Korzo', 'Rijeka', 1);

insert into client(name, surname, email, contact_number, came_at, leave_at, notified)
    values ('Tomislav', 'Kerhin', null , '0981234567', '2020-04-20T15:00:32', '2020-04-20T15:30:11',false );
insert into client(name, surname, email, contact_number, came_at, leave_at, notified)
    values ('Kristijan', 'Kerhin', 'kkerhin@gmail.com' , '0981234567', '2020-04-22T15:00:32', '2020-04-22T15:30:11',false );
insert into client(name, surname, email, contact_number, came_at, leave_at, notified)
    values ('Ivan', 'Perić', null , '0981234567', '2020-04-22T15:42:32', '2020-04-22T16:09:11',false );
insert into client(name, surname, email, contact_number, came_at, leave_at, notified)
    values ('Maja', 'Šutić', 'msutic@gmail.com' , '0981234567', '2020-04-29T12:00:32', '2020-04-29T13:00:11', false );
insert into client(name, surname, email, contact_number, came_at, leave_at, notified)
    values ('Iva', 'Lacković', null , '0981234567', '2020-04-29T15:00:32', '2020-04-20T15:30:11', false );
insert into client(name, surname, email, contact_number, came_at, leave_at, notified)
    values ('Marta', 'Lisac', 'mlisac@gmail.com' , '0981234567', '2020-04-23T15:00:32', '2020-04-23T15:30:11', false );


insert into client_locations(client_id, location_id) values (1,1);
insert into client_locations(client_id, location_id) values (2,1);
insert into client_locations(client_id, location_id) values (3,1);
insert into client_locations(client_id, location_id) values (4,1);
insert into client_locations(client_id, location_id) values (5,1);
insert into client_locations(client_id, location_id) values (6,2);