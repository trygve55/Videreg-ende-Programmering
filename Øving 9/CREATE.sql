DROP TABLE IF EXISTS oppdrag;
DROP TABLE IF EXISTS bedrifter;
DROP TABLE IF EXISTS kandidat_kvalifikasjoner;
DROP TABLE IF EXISTS kvalifikasjoner;
DROP TABLE IF EXISTS kandidater;

CREATE TABLE kandidater (
  kandidat_nr INTEGER NOT NULL,
  fornavn VARCHAR(30) NOT NULL,
  etternavn VARCHAR(30) NOT NULL,
  telefon VARCHAR(15) NOT NULL,
  epost VARCHAR(50) NOT NULL,
  PRIMARY KEY(kandidat_nr)
);

CREATE TABLE bedrifter (
  org_nr INTEGER NOT NULL,
  bedrift_navn VARCHAR(30) NOT NULL,
  bedrift_telefon VARCHAR(15) NOT NULL,
  bedrift_epost VARCHAR(50) NOT NULL,
  PRIMARY KEY(org_nr)
);

CREATE TABLE kvalifikasjoner (
  kvalifikasjon_id INTEGER NOT NULL,
  kvalifikasjon_navn VARCHAR(20) NOT NULL,
  PRIMARY KEY(kvalifikasjon_id)
);

CREATE TABLE kandidat_kvalifikasjoner (
  kandidat_nr INTEGER NOT NULL,
  kvalifikasjon_id INTEGER NOT NULL,
  PRIMARY KEY (kandidat_nr, kvalifikasjon_id),
  FOREIGN KEY (kandidat_nr) REFERENCES kandidater(kandidat_nr),
  FOREIGN KEY (kvalifikasjon_id) REFERENCES kvalifikasjoner(kvalifikasjon_id)
);

CREATE TABLE oppdrag (
  oppdrag_nr INTEGER NOT NULL AUTO_INCREMENT,
  org_nr INTEGER NOT NULL,
  kvalifikasjon_id_krav INTEGER,
  start_dato DATE NOT NULL,
  slutt_dato DATE NOT NULL,
  kandidat_nr INTEGER,
  
  virkelig_start_dato DATE,
  virkelig_slutt_dato DATE,
  PRIMARY KEY (oppdrag_nr),
  FOREIGN KEY (org_nr) REFERENCES bedrifter(org_nr),
  FOREIGN KEY (kvalifikasjon_id_krav) REFERENCES kvalifikasjoner(kvalifikasjon_id)
);

INSERT INTO kandidater VALUES(12, 'Geir', 'Geirsen', '21233424', 'geir@geir.geir');
INSERT INTO kandidater VALUES(8, 'Ola', 'Normann', '21223424', 'ola@norge.no');
INSERT INTO kandidater VALUES(2, 'Per', 'Persen', '62432354', 'per@norge.no');
INSERT INTO kandidater VALUES(3, 'Lars', 'Pedersen', '24352354', 'lars@norge.no');

INSERT INTO kvalifikasjoner VALUES(0, 'data');
INSERT INTO kvalifikasjoner VALUES(1, 'lese');
INSERT INTO kvalifikasjoner VALUES(2, 'grave');
INSERT INTO kvalifikasjoner VALUES(3, 'førerkort');

INSERT INTO kandidat_kvalifikasjoner VALUES(12, 3);
INSERT INTO kandidat_kvalifikasjoner VALUES(12, 1);
INSERT INTO kandidat_kvalifikasjoner VALUES(12, 0);
INSERT INTO kandidat_kvalifikasjoner VALUES(8, 1);
INSERT INTO kandidat_kvalifikasjoner VALUES(2, 2);

INSERT INTO bedrifter VALUES(123, 'Byggern', '13371337', 'byggern@byggern.no');
INSERT INTO bedrifter VALUES(145, 'Elkjop', '11242133', 'elkjop@elkjop.no');

INSERT INTO oppdrag VALUES(DEFAULT, 123, 3, DATE('2017-02-05'), DATE('2017-02-08'), null, null, null);
INSERT INTO oppdrag VALUES(DEFAULT, 123, 3, DATE('2017-01-05'), DATE('2017-01-08'), 12, DATE('2017-01-05'), DATE('2017-01-08'));
INSERT INTO oppdrag VALUES(DEFAULT, 145, 3, DATE('2017-01-08'), DATE('2017-01-09'), 12, DATE('2017-01-09'), DATE('2017-01-10'));

