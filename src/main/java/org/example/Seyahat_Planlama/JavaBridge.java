package org.example.Seyahat_Planlama;

public class JavaBridge {
    private final YolVerileri yolVerileri;
    private final Dijkstra dijkstra;
    private String baslangicSehri;
    private String bitisSehri;
    private double mesafe;
    private RotaCallback rotaCallback;

    // Callback interface tanımı
    public interface RotaCallback {
        void onRotaHesaplandi(Rota rota);
    }

    // Boş constructor
    public JavaBridge() {
        this.yolVerileri = null;
        this.dijkstra = null;
    }

    // Ana constructor
    public JavaBridge(YolVerileri yolVerileri, Dijkstra dijkstra) {
        this.yolVerileri = yolVerileri;
        this.dijkstra = dijkstra;
    }

    // Callback setter metodu
    public void setRotaCallback(RotaCallback callback) {
        this.rotaCallback = callback;
    }

    // JavaScript'ten çağrılacak metodlar
    public void citySelected(String type, String cityName, double lat, double lon) {
        if (type.equals("start")) {
            this.baslangicSehri = cityName;
            System.out.println("Başlangıç şehri seçildi: " + cityName + " (" + lat + ", " + lon + ")");
        } else if (type.equals("end")) {
            this.bitisSehri = cityName;
            System.out.println("Bitiş şehri seçildi: " + cityName + " (" + lat + ", " + lon + ")");
            if (rotaCallback != null && baslangicSehri != null) {
                // İki şehir de seçildiğinde rotayı hesapla ve callback'i çağır
                Sehir kaynak = yolVerileri.sehirBul(baslangicSehri);
                Sehir hedef = yolVerileri.sehirBul(bitisSehri);
                Rota rota = dijkstra.enKisaYolHesapla(kaynak, hedef);
                rotaCallback.onRotaHesaplandi(rota);
            }
        }
    }

    public void updateDistance(double distance) {
        this.mesafe = distance;
        System.out.println("Mesafe: " + distance + " km");
    }

    // Getter metodları
    public String getBaslangicSehri() {
        return baslangicSehri;
    }

    public String getBitisSehri() {
        return bitisSehri;
    }

    public double getMesafe() {
        return this.mesafe;
    }
}