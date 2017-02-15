package com.trygve.oving14;

import com.intellij.ide.ui.AppearanceOptionsTopHitProvider;
import com.siyeh.ig.serialization.ReadObjectAndWriteObjectPrivateInspection;

import java.io.*;

public class FileIO {
    public void saveToFile(Tribune tribune) {
        FileOutputStream fOut = null;
        ObjectOutputStream oOut = null;

        try {
            fOut = new FileOutputStream("tribuner\\" + tribune.getTribuneNavn());
            oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(tribune);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fOut.close();
                oOut.close();
            } catch (Exception e) {

            }

        }
    }

    public Tribune loadFromFile(String filename) {

        Tribune tribune = null;
        FileInputStream fIn = null;
        ObjectInputStream oIn = null;

        try {
            fIn = new FileInputStream(filename);
            oIn = new ObjectInputStream(fIn);
            tribune = (Tribune) oIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fIn.close();
                oIn.close();
            } catch (Exception e) {

            }

        }
        return tribune;
    }

    public Tribune[] loadAllFromFile() {

        File dir = new File("tribuner");
        File[] files = dir.listFiles();

        Tribune[] tribuner = new Tribune[files.length];

        for (int i = 0; i < files.length;i++) tribuner[i] = loadFromFile(files[i].toString());
        return tribuner;
    }
}
