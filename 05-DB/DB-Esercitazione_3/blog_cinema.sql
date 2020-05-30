CREATE DATABASE blog_cinema;

CREATE TABLE tipoUtente(
	id SERIAL,
    nome VARCHAR(256) unique,
    primary key (id)
);

CREATE TABLE utente(
	id SERIAL,
    nome VARCHAR(256),
    cognome VARCHAR(256),
    email VARCHAR(256),
    username VARCHAR(256),
    password VARCHAR(256),
    tipoutente BIGINT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (tipoutente) REFERENCES tipoUtente(id) on delete cascade on update cascade
);

CREATE TABLE genere(
	id SERIAL,
    nome VARCHAR(256),
    descrizione VARCHAR(256),
    img VARCHAR(256),
    primary key (id)
);

CREATE TABLE film(
	id SERIAL,
    nome VARCHAR(256),
    trama TEXT,
    img VARCHAR(256),
    genere BIGINT UNSIGNED,
    primary key (id),
    foreign key (genere) references genere(id) on delete cascade on update cascade
);

CREATE TABLE recensione(
	id SERIAL,
    contenuto_recensione TEXT,
    voto tinyint unsigned,
    film bigint unsigned,
    autore bigint unsigned,
    primary key (id),
    foreign key (film) references film(id) on delete cascade on update cascade,
    foreign key (autore) references utente(id) on delete cascade on update cascade
);

INSERT INTO tipoutente(nome)
VALUES ("admin"),
("lettore");

INSERT INTO utente(nome,cognome,email,username,password,tipoutente)
VALUES ("admin","admin", "amdin@mail.com", "admin", "psw1234", 1),
("lettore","lettore","lettore@mail.com","lettore","psw1234", 2);

INSERT INTO genere(nome,descrizione,img)
VALUES ("Fantascienza", "descrizione Fantascienza", "img/generi/fantascienza.png"),
("Dramma", "descrizione Dramma", "img/generi/dramma.png");

INSERT INTO film(nome,trama,img,genere)
VALUES ("Star Wars Episodio IV", "trama Star Wars Episodio IV", "img/film/star_wars_iv.png", 1),
("Schindler's List", "trama Schindler's List", "img/film/schindler_list.png", 2);

INSERT INTO recensione(contenuto_recensione,voto,film,autore)
VALUES ("Recensione Star Wars Episodio IV", 9, 1, 1),
("Recensione Schindler's List", 9, 2, 1);