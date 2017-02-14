-- oppg b

-- Fremmednøkkel kan være null. Eks: Kandidat på et oppdrag før det har blitt funnet en kan være null.

-- oppg d 1.

SELECT DISTINCT bedrift_navn, bedrift_telefon, bedrift_epost FROM bedrifter

-- 2.

SELECT DISTINCT oppdrag_nr, bedrift_navn, bedrift_telefon, bedrift_epost FROM bedrifter NATURAL JOIN oppdrag

-- 3.

SELECT DISTINCT kandidat_nr, fornavn, etternavn, kvalifikasjon_id, kvalifikasjon_navn FROM kandidater NATURAL JOIN kandidat_kvalifikasjoner NATURAL JOIN kvalifikasjoner

-- 4.

-- ikke bruk det mosteret her, bruk LEFT JOIN istedet!
SELECT DISTINCT kandidat_nr, fornavn, etternavn, kvalifikasjon_id, kvalifikasjon_navn FROM kandidater NATURAL JOIN kandidat_kvalifikasjoner NATURAL JOIN kvalifikasjoner
UNION
SELECT DISTINCT kandidat_nr, fornavn, etternavn, null, null FROM kandidater 
WHERE kandidat_nr NOT IN (
SELECT DISTINCT kandidat_nr FROM kandidat_kvalifikasjoner
);

-- 5.

SELECT DISTINCT kandidat_nr, fornavn, etternavn, virkelig_start_dato, virkelig_slutt_dato, antall_timer, oppdrag_nr, bedrift_navn FROM oppdrag NATURAL JOIN kandidater NATURAL JOIN bedrifter WHERE kandidat_nr=12