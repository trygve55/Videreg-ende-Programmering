--oppg 1a
SELECT * FROM bok WHERE utgitt_aar<1990
SELECT DISTINCT utgitt_aar, tittel FROM bok
--oppg 1b
SELECT * FROM forlag, bok

Hvert forlag har gitt ut hver eneste bok

--oppg 1c
SELECT * FROM bok JOIN forlag
SELECT * FROM bok NATURAL JOIN forlag

NATURAL JOIN git bare de tilbake der forlag stemmer med boka, JOIN gir at hvert forlag har gitt ut hver eneste bok.

--oppg 1d
SELECT DISTINCT utgitt_aar FROM bok
UNION
SELECT DISTINCT fode_aar FROM forfatter

alle årstall vises.

--oppg 2a

SELECT DISTINCT forlag_navn FROM forlag

--oppg 2b

SELECT DISTINCT forlag_id from forlag
WHERE forlag_id NOT IN (
SELECT DISTINCT forlag_id from bok
);

--oppg 2c

SELECT * FROM forfatter WHERE fode_aar=1948

--oppg 2d

SELECT DISTINCT forlag_navn, adresse FROM forlag 
WHERE forlag_id IN (
SELECT DISTINCT forlag_id from bok WHERE tittel='Generation X'
);

--oppg 2e

SELECT DISTINCT tittel FROM bok 
WHERE bok_id in (
SELECT DISTINCT bok_id FROM bok_forfatter
WHERE forfatter_id IN (
SELECT DISTINCT forfatter_id FROM forfatter WHERE etternavn='Hamsun'
));

--oppg 2f

SELECT DISTINCT tittel, utgitt_aar, forlag_navn, adresse, telefon FROM bok NATURAL JOIN forlag
UNION
SELECT DISTINCT forlag_navn, forlag_navn,forlag_navn, adresse, telefon from forlag
WHERE forlag_id NOT IN (
SELECT DISTINCT forlag_id from bok
);