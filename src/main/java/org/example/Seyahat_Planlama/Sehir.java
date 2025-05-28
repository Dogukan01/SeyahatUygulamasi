package org.example.Seyahat_Planlama;

import java.util.HashMap;
import java.util.Map;

public class Sehir {
    private String sehirAdi;
    private Map<Sehir, Double> komsuluklar;

    public Sehir(String sehirAdi) {
        this.sehirAdi = sehirAdi;
        this.komsuluklar = new HashMap<>();
    }

    public void komsulukEkle(Sehir komsuluk, double mesafe){
        komsuluklar.put(komsuluk, mesafe);
    }

    public Map<Sehir, Double> getKomsuluklar() {
        return komsuluklar;
    }

    public String getSehirAdi() {
        return sehirAdi;
    }
}
