--Oppg 1.

SELECT DISTINCT bolag_navn, etabl_aar FROM borettslag WHERE etabl_aar <= 1985 AND etabl_aar >= 1975;

--Oppg 2.

SELECT CONCAT(fornavn, ' ', etternavn, ', ansiennitet: ', ansiennitet, ' år')
 AS "Andelseiere"
FROM andelseier
ORDER BY ansiennitet DESC;

--Oppg 3.

SELECT DISTINCT bolag_navn FROM borettslag
ORDER BY etabl_aar
LIMIT 1;

--Oppg 4.

SELECT DISTINCT bygn_adr FROM bygning NATURAL JOIN leilighet WHERE ant_rom >= 3;

--Oppg 5.

SELECT COUNT(bygn_adr) FROM bygning NATURAL JOIN leilighet WHERE bolag_navn = 'Tertitten';

--Oppg 6.

SELECT borettslag.bolag_navn, COUNT(bygning.bolag_navn) AS 'Antall bygninger' 
FROM borettslag LEFT JOIN bygning ON bygning.bolag_navn=borettslag.bolag_navn 
GROUP BY bygning.bolag_navn
ORDER BY borettslag.bolag_navn;

--Oppg 7. 

SELECT COUNT(*) AS 'Bygninger i Tertitten' FROM bygning WHERE bolag_navn='Tertitten';

--Oppg 8.

SELECT MAX(ant_etasjer) AS 'Høyeste etasje' FROM bygning WHERE bolag_navn='Tertitten';

--Oppg 9.

SELECT fornavn, etternavn, and_eier_nr FROM andelseier 
WHERE and_eier_nr NOT IN (
SELECT and_eier_nr FROM leilighet);

--Oppg 10.

SELECT borettslag.bolag_navn, COUNT(andelseier.and_eier_nr) AS 'Antall andelseiere' 
FROM borettslag LEFT JOIN andelseier ON borettslag.bolag_navn=andelseier.bolag_navn
GROUP BY borettslag.bolag_navn
ORDER BY COUNT(andelseier.and_eier_nr) DESC;

--Oppg 11.

SELECT andelseier.fornavn, andelseier.etternavn, leilighet.leil_nr
FROM andelseier LEFT JOIN leilighet ON leilighet.and_eier_nr=andelseier.and_eier_nr;

--Oppg 12.

SELECT borettslag.bolag_navn FROM borettslag 
LEFT JOIN bygning ON bygning.bolag_navn=borettslag.bolag_navn
LEFT JOIN leilighet ON leilighet.bygn_id=bygning.bygn_id
WHERE leilighet.ant_rom=4;

--Oppg 13.

SELECT poststed.postnr, poststed.poststed, COUNT(leilighet.and_eier_nr) AS 'Andelseiere' FROM poststed
LEFT JOIN bygning ON bygning.postnr=poststed.postnr
LEFT JOIN leilighet ON leilighet.bygn_id=bygning.bygn_id
LEFT JOIN andelseier ON andelseier.and_eier_nr=leilighet.and_eier_nr
GROUP BY poststed.postnr;