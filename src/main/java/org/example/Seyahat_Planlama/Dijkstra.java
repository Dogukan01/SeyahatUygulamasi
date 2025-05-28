package org.example.Seyahat_Planlama;

import java.util.*;

public class Dijkstra {
    public Rota enKisaYolHesapla(Sehir kaynak, Sehir hedef) {
        Map<Sehir, Double> mesafeler = new HashMap<>();
        Map<Sehir, Sehir> oncekiSehirler = new HashMap<>();
        PriorityQueue<Sehir> pQueue = new PriorityQueue<>(Comparator.comparingDouble(mesafeler::get));
        Set<Sehir> ziyaretEdildi = new HashSet<>();

        mesafeler.put(kaynak, 0.0);
        pQueue.add(kaynak);

        while (!pQueue.isEmpty()) {
            Sehir currentsehir = pQueue.poll();
            if (currentsehir.equals(hedef)) {
                break;
            }
            if (ziyaretEdildi.contains(currentsehir)) {
                continue;
            }
            ziyaretEdildi.add(currentsehir);
            for (Map.Entry<Sehir, Double> komsu : currentsehir.getKomsuluklar().entrySet()) {
                Sehir nextSehir = komsu.getKey();
                Double yeniMesafe = mesafeler.get(currentsehir) + komsu.getValue();
                if (!mesafeler.containsKey(nextSehir) || yeniMesafe < mesafeler.get(nextSehir)) {
                    mesafeler.put(nextSehir, yeniMesafe);
                    oncekiSehirler.put(nextSehir, currentsehir);
                    pQueue.add(nextSehir);
                }

            }
        }

        return RotaHesapla(kaynak, hedef, oncekiSehirler, mesafeler);
    }

        private Rota RotaHesapla(Sehir kaynak, Sehir hedef,
                                Map<Sehir, Sehir> oncekiSehirler,
                                Map<Sehir, Double> mesafeler){
            Rota rota = new Rota();
            Sehir currentsehir = hedef;
            Sehir oncekiSehir = null;

            while (currentsehir != null){
                if(mesafeler.get(currentsehir) == null) break; //*********************************************
                if(oncekiSehir == null){
                    rota.sehirEkle(currentsehir, 0.0);
                }
                else{
                    Double mesafe = mesafeler.get(currentsehir) - mesafeler.get(oncekiSehir);
                    rota.sehirEkle(currentsehir,  Math.abs(mesafe));
                }
                oncekiSehir = currentsehir;
                currentsehir = oncekiSehirler.get(currentsehir);
                if(currentsehir == null){
                    break;
                }
            }
            return rota;
        }
    }
