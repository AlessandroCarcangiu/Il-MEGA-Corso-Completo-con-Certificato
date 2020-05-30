create database biblioteca;

create table biblioteca(
	id serial,
    nome varchar(256),
    indirizzo varchar(256),
    primary key (id)
);

create table bibliotecario(
	id serial,
    nome varchar(256),
    cognome varchar(256),
    indirizzo varchar(256),
    email varchar(256),
    biblioteca bigint unsigned,
    primary key (id),
    foreign key (biblioteca) references biblioteca(id) on delete cascade on update cascade
);

create table iscritto(
	id serial,
    nome varchar(256),
    cognome varchar(256),
    indirizzo varchar(256),
    email varchar(256),
    primary key (id)
);

create table iscrizione(
	biblioteca bigint unsigned,
    iscritto bigint unsigned,
    primary key (biblioteca, iscritto),
    foreign key (biblioteca) references biblioteca(id) on delete cascade on update cascade, 
    foreign key (iscritto) references iscritto(id) on delete cascade on update cascade
);

create table libro(
	id bigint unsigned,
    titolo varchar(256),
    autore varchar(256),
    casa_editrice varchar(256),
    primary key (id)
);

create table prestito(
	id bigint unsigned,
    libro bigint unsigned,
    iscritto bigint unsigned,
    bibliotecario bigint unsigned,
    foreign key (libro) references libro(id) on delete cascade on update cascade, 
    foreign key (iscritto) references iscritto(id) on delete cascade on update cascade,
    foreign key (bibliotecario) references bibliotecario(id) on delete cascade on update cascade
);
