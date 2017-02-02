INSERT INTO boretslag(boretslag_navn, boretslag_adresse, etableringsaar) values ('Boretslaget', 'Boretslagsvegen 2', 2008); 
INSERT INTO byggninger(byggning_nr, boretslag) values (1, 'Boretslaget');
INSERT INTO medlem(medlem_nr, fornavn, etternavn) values (1337, 'Geir', 'Geirsen');
INSERT INTO leiligheter(leilighet_nr, antall_rom, kvadrat, etasje, byggning, eier) values ('1A', 3, 40, 1, 1, null);
INSERT INTO leiligheter(leilighet_nr, antall_rom, kvadrat, etasje, byggning, eier) values ('1B', 3, 42, 1, 1, 1337);
/* virker legger inn data. */
INSERT INTO byggninger(byggning_nr, boretslag) values (1, 'Boretslaget2');
/* gir feil fordi 'Boretslaget2' ikke eksisterer. */
INSERT INTO leiligheter(leilighet_nr, antall_rom, kvadrat, etasje, byggning, eier) values ('1B', 3, 42, 1, 1, 'geir');
/* gir feil */
