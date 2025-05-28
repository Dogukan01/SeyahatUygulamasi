package org.example.Seyahat_Planlama;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MesafeHesaplayici {
    private final Map<String, CityCoordinates> cityCoordinates = new HashMap<>();

    private static class CityCoordinates {
        double lat;
        double lon;

        CityCoordinates(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }
    }

    public static class City {
        public String name;
        public String latitude;
        public String longitude;
    }

    public MesafeHesaplayici(JavaBridge javaBridge) {
        loadCityCoordinates();
    }

    private void loadCityCoordinates() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/org/example/Seyahat_Planlama/cities.json");
            if (is == null) {
                throw new RuntimeException("cities.json dosyası bulunamadı!");
            }

            List<City> cities = mapper.readValue(is, new TypeReference<List<City>>() {});

            for (City city : cities) {
                double lat = Double.parseDouble(city.latitude);
                double lon = Double.parseDouble(city.longitude);
                cityCoordinates.put(city.name, new CityCoordinates(lat, lon));
            }

            System.out.println(cityCoordinates.size() + " şehir koordinatı yüklendi.");
        } catch (Exception e) {
            System.err.println("Şehir koordinatları yüklenirken hata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public double getMesafe(String sehir1, String sehir2) {
        CityCoordinates coord1 = cityCoordinates.get(sehir1);
        CityCoordinates coord2 = cityCoordinates.get(sehir2);

        if (coord1 == null || coord2 == null) {
            System.err.println("Şehir koordinatları bulunamadı: " + sehir1 + " veya " + sehir2);
            return -1;
        }

        return hesaplaKusUcusuMesafe(coord1.lat, coord1.lon, coord2.lat, coord2.lon);
    }

    private double hesaplaKusUcusuMesafe(double lat1, double lon1, double lat2, double lon2) {
        final int DUNYA_YARICAPI = 6371; // Dünya'nın yarıçapı (km)

        // Dereceleri radyana çevir
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formülü
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return DUNYA_YARICAPI * c;
    }
}