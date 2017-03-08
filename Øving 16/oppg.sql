-- Oppg 1. a)

SELECT * FROM levinfo NATURAL JOIN ordrehode NATURAL JOIN ordredetalj WHERE levnr = 44;

-- Oppg 1. b)

SELECT navn, levby, MIN(pris) FROM delinfo NATURAL JOIN prisinfo NATURAL JOIN levinfo WHERE delnr = 1;

-- Oppg 1. c)

SELECT levnr, navn, pris FROM delinfo NATURAL JOIN prisinfo NATURAL JOIN levinfo WHERE (pris) IN (SELECT MIN(pris) FROM prisinfo WHERE delnr = 201);

-- Oppg 1. d)

SELECT ordrenr, dato, delnr, beskrivelse, kvantum, pris, (pris*kvantum) FROM ordrehode NATURAL JOIN ordredetalj NATURAL JOIN prisinfo NATURAL JOIN delinfo WHERE ordrenr = 16;

-- Oppg 1. e)

SELECT delnr, levnr FROM prisinfo WHERE pris > (SELECT pris FROM prisinfo WHERE katalognr = 'X7770');

-- Oppg 1. f) i)

CREATE TABLE fylkeby(
levby   VARCHAR(20) NOT NULL,
fylke   VARCHAR(20) NOT NULL,
CONSTRAINT fylkeby_pk PRIMARY KEY(levby));

CREATE TABLE levinfo( 
levnr   INTEGER, 
navn    VARCHAR(20) NOT NULL, 
adresse VARCHAR(20) NOT NULL, 
levby   VARCHAR(20) NOT NULL,  
postnr  INTEGER NOT NULL,
FOREIGN KEY (levby) REFERENCES fylkeby(levby),
CONSTRAINT levinfo_pk PRIMARY KEY(levnr));

-- Oppg 1. f) ii)

CREATE VIEW [levinfo2] AS 
SELECT levnr, navn, adresse, levby, fylke, postnr 
FROM levinfo NATURAL JOIN fylkeby;

-- Oppg 1. g)

SELECT DISTINCT levby FROM levinfo WHERE levby NOT IN (SELECT levby FROM prisinfo NATURAL JOIN levinfo);

-- Oppg 1. h)

SELECT levnr, SUM(totalpris_del) as total_pris 
FROM (SELECT delnr, levnr, kvantum*pris AS totalpris_del FROM ordredetalj NATURAL JOIN prisinfo WHERE ordrenr = 18) AS total 
WHERE levnr IN (SELECT levnr FROM 
(SELECT levnr, count(levnr) AS kan_levere FROM prisinfo WHERE delnr IN 
(SELECT delnr FROM ordredetalj WHERE ordrenr = 18) GROUP BY levnr) as har_deler
WHERE kan_levere = (SELECT COUNT(delnr) FROM ordredetalj WHERE ordrenr = 18))
GROUP BY levnr
ORDER BY total_pris ASC LIMIT 1;

-- Oppg 2. a)

SELECT forlag_navn , telefon  FROM forlag
WHERE SUBSTR(telefon, 1, 1) = 2
UNION
SELECT forlag_navn , telefon  FROM forlag
WHERE SUBSTR(telefon, 1, 1) != 2
UNION
SELECT forlag_navn , telefon  FROM forlag
WHERE telefon IS null;

-- Oppg 2. b)

SELECT AVG(alder) FROM (
SELECT (YEAR(CURRENT_DATE) - fode_aar) AS alder FROM forfatter
WHERE fode_aar IS NOT NULL AND dod_aar IS NULL AND fode_aar > 1900
UNION
SELECT (dod_aar - fode_aar) AS alder FROM forfatter
WHERE fode_aar IS NOT NULL AND dod_aar IS NOT NULL) AS alder;

-- Oppg 2. c) 

SELECT COUNT(alder)/(SELECT COUNT(forfatter_id) FROM forfatter)*100 AS prosent_i_beregning FROM (
SELECT (YEAR(CURRENT_DATE) - fode_aar) AS alder FROM forfatter
WHERE fode_aar IS NOT NULL AND dod_aar IS NULL AND fode_aar > 1900
UNION
SELECT (dod_aar - fode_aar) AS alder FROM forfatter
WHERE fode_aar IS NOT NULL AND dod_aar IS NOT NULL) AS alder;

SELECT COUNT(forfatter_id) FROM forfatter;