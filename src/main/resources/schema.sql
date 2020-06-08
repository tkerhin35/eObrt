create table if not exists users (
    id integer not null auto_increment,
    name varchar(70) not null ,
    password varchar(120) not null ,
    email varchar(20) not null unique ,
    enabled boolean not null ,
    primary key (id)
);
create table if not exists roles (
    id integer not null auto_increment ,
    name varchar(20) not null ,
    primary key (id)
);

create table if not exists users_roles(
    user_id integer not null ,
    role_id integer not null,
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

create table if not exists locations(
    id integer not null auto_increment,
    name varchar(70) not null ,
    city_name varchar(20) not null ,
    user_id integer not null ,
    primary key (id),
    foreign key (user_id) references users(id)
);

create table if not exists client(
    id integer not null auto_increment,
    name varchar(20) not null ,
    surname varchar(20) not null ,
    email varchar(40) ,
    contact_number varchar(20) ,
    came_at timestamp not null ,
    leave_at timestamp not null ,
    notified boolean not null ,
    primary key (id)
);

create table if not exists client_locations(
    client_id integer not null ,
    location_id integer not null ,
    foreign key (client_id) references client(id),
    foreign key (location_id) references locations(id)
);