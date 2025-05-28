package org.example.Seyahat_Planlama;

import java.util.ArrayList;
import java.util.List;

public class Rota {
    private List<Sehir> sehirler;
    private int toplamMesafe;

    public Rota(){
        this.sehirler = new ArrayList<>();
        this.toplamMesafe = 0;
    }

    public void sehirEkle(Sehir sehir, Double mesafe){
        sehirler.add(sehir);
        toplamMesafe += mesafe;
    }

    public List<Sehir> getSehirler() {
        return sehirler;
    }

    public int getToplamMesafe() {
        return toplamMesafe;
    }
}
