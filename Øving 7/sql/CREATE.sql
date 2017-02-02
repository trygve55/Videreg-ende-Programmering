DROP TABLE IF EXISTS leiligheter;
DROP TABLE IF EXISTS bygninger;
DROP TABLE IF EXISTS boretslag;
DROP TABLE IF EXISTS ansatt;
DROP TABLE IF EXISTS medlem;

CREATE TABLE ansatt(
  ansatt_nr INTEGER NOT NULL,
  fornavn VARCHAR(50) NOT NULL,
  etternavn VARCHAR(50) NOT NULL,
  kontor_telefon INTEGER NOT NULL,
  fodselsaar INTEGER NOT NULL,
  PRIMARY KEY(ansatt_nr));
  
CREATE TABLE medlem(
  medlem_nr INTEGER NOT NULL,
  fornavn VARCHAR(50) NOT NULL,
  etternavn VARCHAR(50) NOT NULL,
  PRIMARY KEY(medlem_nr));
  
CREATE TABLE boretslag(
  boretslag_navn VARCHAR(50) NOT NULL,
  boretslag_adresse VARCHAR(50) NOT NULL,
  etableringsaar INTEGER,
  PRIMARY KEY(boretslag_navn));
  
CREATE TABLE byggninger(
  byggning_nr INTEGER NOT NULL,
  boretslag VARCHAR(50) NOT NULL,
  PRIMARY KEY(byggning_nr),
  FOREIGN KEY (boretslag) REFERENCES boretslag(boretslag_navn)
  );
  
CREATE TABLE leiligheter(
  leilighet_nr VARCHAR(50) NOT NULL,
  antall_rom INTEGER NOT NULL,
  kvadrat INTEGER NOT NULL,
  etasje INTEGER NOT NULL,
  byggning INTEGER NOT NULL,
  eier INTEGER,
  PRIMARY KEY(leilighet_nr),
  FOREIGN KEY (byggning) REFERENCES byggninger(byggning_nr),
  FOREIGN KEY (eier) REFERENCES medlem(medlem_nr)
  );

INSERT INTO boretslag(boretslag_navn, boretslag_adresse, etableringsaar) values ('Boretslaget', 'Boretslagsvegen 2', 2008);
INSERT INTO byggninger(byggning_nr, boretslag) values (1, 'Boretslaget');
INSERT INTO medlem(medlem_nr, fornavn, etternavn) values (1337, 'Geir', 'Geirsen');
INSERT INTO leiligheter(leilighet_nr, antall_rom, kvadrat, etasje, byggning, eier) values ('1A', 3, 40, 1, 1, null);
INSERT INTO leiligheter(leilighet_nr, antall_rom, kvadrat, etasje, byggning, eier) values ('1B', 3, 42, 1, 1, 1337);