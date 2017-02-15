package com.trygve.oving12oppg1;

import java.time.LocalDate;

public class BasicMedlem extends BonusMedlem {

    public BasicMedlem(int medlNr, Personalia personalia, LocalDate innmeldtDato) {
        super(medlNr, personalia,innmeldtDato, 100, 0);
    }

    public void registrerPoeng(int poeng) {
        super.registrerPoeng(poeng);
    }
}
