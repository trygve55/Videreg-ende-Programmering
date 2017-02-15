package com.trygve.oving12oppg1;

import java.time.LocalDate;

/**
 * Created by Trygve on 14.02.2017.
 */
public class SoelvMedlem extends BonusMedlem {

    public SoelvMedlem(int medlNr, Personalia personalia, LocalDate innmeldtDato, int poeng) {
        super(medlNr, personalia,innmeldtDato, 120, poeng);
    }

    public void registrerPoeng(int poeng) {
        super.registrerPoeng(poeng);
    }
}
