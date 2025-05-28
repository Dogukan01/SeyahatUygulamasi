package org.example.Seyahat_Planlama;

import java.util.Map;

public class YolVerileri {
    private static final int SEHIR_SAYISI = 82;
    private final Sehir[] sehirler;
    private final MesafeHesaplayici mesafeHesaplayici;


    public YolVerileri() {
        this.sehirler = new Sehir[SEHIR_SAYISI];
        this.mesafeHesaplayici = new MesafeHesaplayici(new JavaBridge());
    }

    public void sehirleriDoldur(){
        sehirler[1] = new Sehir("Adana");
        sehirler[2] = new Sehir("Adıyaman");
        sehirler[3] = new Sehir("Afyonkarahisar");
        sehirler[4] = new Sehir("Ağrı");
        sehirler[5] = new Sehir("Amasya");
        sehirler[6] = new Sehir("Ankara");
        sehirler[7] = new Sehir("Antalya");
        sehirler[8] = new Sehir("Artvin");
        sehirler[9] = new Sehir("Aydın");
        sehirler[10] = new Sehir("Balıkesir");
        sehirler[11] = new Sehir("Bilecik");
        sehirler[12] = new Sehir("Bingöl");
        sehirler[13] = new Sehir("Bitlis");
        sehirler[14] = new Sehir("Bolu");
        sehirler[15] = new Sehir("Burdur");
        sehirler[16] = new Sehir("Bursa");
        sehirler[17] = new Sehir("Çanakkale");
        sehirler[18] = new Sehir("Çankırı");
        sehirler[19] = new Sehir("Çorum");
        sehirler[20] = new Sehir("Denizli");
        sehirler[21] = new Sehir("Diyarbakır");
        sehirler[22] = new Sehir("Edirne");
        sehirler[23] = new Sehir("Elazığ");
        sehirler[24] = new Sehir("Erzincan");
        sehirler[25] = new Sehir("Erzurum");
        sehirler[26] = new Sehir("Eskişehir");
        sehirler[27] = new Sehir("Gaziantep");
        sehirler[28] = new Sehir("Giresun");
        sehirler[29] = new Sehir("Gümüşhane");
        sehirler[30] = new Sehir("Hakkari");
        sehirler[31] = new Sehir("Hatay");
        sehirler[32] = new Sehir("Isparta");
        sehirler[33] = new Sehir("Mersin");
        sehirler[34] = new Sehir("İstanbul");
        sehirler[35] = new Sehir("İzmir");
        sehirler[36] = new Sehir("Kars");
        sehirler[37] = new Sehir("Kastamonu");
        sehirler[38] = new Sehir("Kayseri");
        sehirler[39] = new Sehir("Kırklareli");
        sehirler[40] = new Sehir("Kırşehir");
        sehirler[41] = new Sehir("Kocaeli");
        sehirler[42] = new Sehir("Konya");
        sehirler[43] = new Sehir("Kütahya");
        sehirler[44] = new Sehir("Malatya");
        sehirler[45] = new Sehir("Manisa");
        sehirler[46] = new Sehir("Kahramanmaraş");
        sehirler[47] = new Sehir("Mardin");
        sehirler[48] = new Sehir("Muğla");
        sehirler[49] = new Sehir("Muş");
        sehirler[50] = new Sehir("Nevşehir");
        sehirler[51] = new Sehir("Niğde");
        sehirler[52] = new Sehir("Ordu");
        sehirler[53] = new Sehir("Rize");
        sehirler[54] = new Sehir("Sakarya");
        sehirler[55] = new Sehir("Samsun");
        sehirler[56] = new Sehir("Siirt");
        sehirler[57] = new Sehir("Sinop");
        sehirler[58] = new Sehir("Sivas");
        sehirler[59] = new Sehir("Tekirdağ");
        sehirler[60] = new Sehir("Tokat");
        sehirler[61] = new Sehir("Trabzon");
        sehirler[62] = new Sehir("Tunceli");
        sehirler[63] = new Sehir("Şanlıurfa");
        sehirler[64] = new Sehir("Uşak");
        sehirler[65] = new Sehir("Van");
        sehirler[66] = new Sehir("Yozgat");
        sehirler[67] = new Sehir("Zonguldak");
        sehirler[68] = new Sehir("Aksaray");
        sehirler[69] = new Sehir("Bayburt");
        sehirler[70] = new Sehir("Karaman");
        sehirler[71] = new Sehir("Kırıkkale");
        sehirler[72] = new Sehir("Batman");
        sehirler[73] = new Sehir("Şırnak");
        sehirler[74] = new Sehir("Bartın");
        sehirler[75] = new Sehir("Ardahan");
        sehirler[76] = new Sehir("Iğdır");
        sehirler[77] = new Sehir("Yalova");
        sehirler[78] = new Sehir("Karabük");
        sehirler[79] = new Sehir("Kilis");
        sehirler[80] = new Sehir("Osmaniye");
        sehirler[81] = new Sehir("Düzce");
    }

    public Sehir sehirBul(String sehirAdi) {
        for (Sehir sehir : sehirler) {
            if (sehir != null && sehir.getSehirAdi().equalsIgnoreCase(sehirAdi)) {
                return sehir;
            }
        }
        return null;
    }

    public void komsulukEkle(String sehir1Adi, String sehir2Adi) {
        Sehir sehir1 = sehirBul(sehir1Adi);
        Sehir sehir2 = sehirBul(sehir2Adi);
        double mesafe = mesafeHesaplayici.getMesafe(sehir1Adi, sehir2Adi);
        if (sehir1 != null && sehir2 != null) {
            // Çift yönlü komşuluk ilişkisi kuruyoruz
            sehir1.komsulukEkle(sehir2, mesafe);
            sehir2.komsulukEkle(sehir1, mesafe);
        }
    }

    public void komsuluklariDoldur() {
        // 01-Adana için
        komsulukEkle("Adana", "Osmaniye"); //80
        komsulukEkle("Adana", "Hatay"); //31
        komsulukEkle("Adana", "Kahramanmaraş"); //46
        komsulukEkle("Adana", "Niğde"); //51
        komsulukEkle("Adana", "Kayseri"); //38
        komsulukEkle("Adana", "Mersin"); //33
        // 02-Adıyaman için
        komsulukEkle("Adıyaman", "Kahramanmaraş"); //46
        komsulukEkle("Adıyaman", "Malatya"); //44
        komsulukEkle("Adıyaman", "Diyarbakır"); //21
        komsulukEkle("Adıyaman", "Şanlıurfa"); //63
        komsulukEkle("Adıyaman", "Gaziantep"); //27
        //03-Afyon için
        komsulukEkle("Afyonkarahisar", "Eskişehir"); //26
        komsulukEkle("Afyonkarahisar", "Konya"); //42
        komsulukEkle("Afyonkarahisar", "Isparta"); //32
        komsulukEkle("Afyonkarahisar", "Denizli"); //20
        komsulukEkle("Afyonkarahisar", "Uşak"); //64
        komsulukEkle("Afyonkarahisar", "Kütahya"); //43
        komsulukEkle("Afyonkarahisar", "Burdur"); //15
        //04-Ağrı için
        komsulukEkle("Ağrı", "Kars"); //36
        komsulukEkle("Ağrı", "Iğdır"); //76
        komsulukEkle("Ağrı", "Van"); //65
        komsulukEkle("Ağrı", "Muş"); //49
        komsulukEkle("Ağrı", "Erzurum"); //25
        komsulukEkle("Ağrı", "Bitlis"); //13
        //05-Amasya için
        komsulukEkle("Amasya", "Çorum"); //19
        komsulukEkle("Amasya", "Yozgat"); //66
        komsulukEkle("Amasya", "Tokat"); //60
        komsulukEkle("Amasya", "Samsun"); //55
        // 06-Ankara için
        komsulukEkle("Ankara", "Bolu"); // 14
        komsulukEkle("Ankara", "Çankırı"); // 18
        komsulukEkle("Ankara", "Eskişehir"); // 26
        komsulukEkle("Ankara", "Kırıkkale"); // 71
        komsulukEkle("Ankara", "Konya"); // 42
        komsulukEkle("Ankara", "Aksaray"); // 68
        komsulukEkle("Ankara", "Kırşehir"); //40
        // 07-Antalya için
        komsulukEkle("Antalya", "Burdur"); // 15
        komsulukEkle("Antalya", "Isparta"); // 32
        komsulukEkle("Antalya", "Karaman"); // 70
        komsulukEkle("Antalya", "Konya"); // 42
        komsulukEkle("Antalya", "Muğla"); // 48
        komsulukEkle("Antalya", "Mersin"); //33
        // 08-Artvin için
        komsulukEkle("Artvin", "Ardahan"); // 75
        komsulukEkle("Artvin", "Erzurum"); // 25
        komsulukEkle("Artvin", "Rize"); // 53
        // 09-Aydın için
        komsulukEkle("Aydın", "Denizli"); // 20
        komsulukEkle("Aydın", "İzmir"); // 35
        komsulukEkle("Aydın", "Manisa"); // 45
        komsulukEkle("Aydın", "Muğla"); // 48
        // 10-Balıkesir için
        komsulukEkle("Balıkesir", "Bursa"); // 16
        komsulukEkle("Balıkesir", "Çanakkale"); // 17
        komsulukEkle("Balıkesir", "İzmir"); // 35
        komsulukEkle("Balıkesir", "Kütahya"); // 43
        komsulukEkle("Balıkesir", "Manisa"); // 45
        // 11-Bilecik için
        //komsulukEkle("Bilecik", "Bolu"); // 14
        komsulukEkle("Bilecik", "Bursa"); // 16
        komsulukEkle("Bilecik", "Eskişehir"); // 26
        komsulukEkle("Bilecik", "Kütahya"); // 43
        komsulukEkle("Bilecik", "Sakarya"); // 54
        // 12-Bingöl için
        komsulukEkle("Bingöl", "Diyarbakır"); // 21
        komsulukEkle("Bingöl", "Elazığ"); // 23
        komsulukEkle("Bingöl", "Erzincan"); // 24
        komsulukEkle("Bingöl", "Erzurum"); // 25
        komsulukEkle("Bingöl", "Muş"); // 49
        komsulukEkle("Bingöl", "Tunceli"); // 62
        // 13-Bitlis için
        komsulukEkle("Bitlis", "Muş"); // 49
        komsulukEkle("Bitlis", "Siirt"); // 56
        komsulukEkle("Bitlis", "Van"); // 65
        komsulukEkle("Bitlis", "Batman"); //72
        // 14-Bolu için
        komsulukEkle("Bolu", "Düzce"); // 81
        komsulukEkle("Bolu", "Eskişehir"); // 26
        komsulukEkle("Bolu", "Karabük"); // 78
        //komsulukEkle("Bolu", "Sakarya"); // 54
        komsulukEkle("Bolu", "Zonguldak"); // 67
        // 15-Burdur için
        komsulukEkle("Burdur", "Denizli"); // 20
        komsulukEkle("Burdur", "Isparta"); // 32
        komsulukEkle("Burdur", "Muğla"); // 48
        // 16-Bursa için
        komsulukEkle("Bursa", "Kütahya"); // 43
        komsulukEkle("Bursa", "Sakarya"); // 54
        komsulukEkle("Bursa", "Yalova"); // 77
        komsulukEkle("Bursa", "Kocaeli"); //41
        // 17-Çanakkale için
        komsulukEkle("Çanakkale", "Edirne"); // 22
        komsulukEkle("Çanakkale", "Tekirdağ"); // 59
        // 18-Çankırı için
        komsulukEkle("Çankırı", "Kastamonu"); // 37
        komsulukEkle("Çankırı", "Kırıkkale"); // 71
        komsulukEkle("Çankırı", "Karabük"); // 78
        komsulukEkle("Çankırı", "Çorum"); // 19
        // 19-Çorum için
        komsulukEkle("Çorum", "Kastamonu"); // 37
        komsulukEkle("Çorum", "Kırıkkale"); // 71
        komsulukEkle("Çorum", "Samsun"); // 55
        komsulukEkle("Çorum", "Sinop"); // 57
        komsulukEkle("Çorum", "Yozgat"); // 66
        // 20-Denizli için
        komsulukEkle("Denizli", "Manisa"); // 45
        komsulukEkle("Denizli", "Muğla"); // 48
        komsulukEkle("Denizli", "Uşak"); // 64
        // 21-Diyarbakır için
        komsulukEkle("Diyarbakır", "Batman"); // 72
        komsulukEkle("Diyarbakır", "Elazığ"); // 23
        komsulukEkle("Diyarbakır", "Mardin"); // 47
        komsulukEkle("Diyarbakır", "Muş"); // 49
        komsulukEkle("Diyarbakır", "Şanlıurfa"); // 63
        // 22-Edirne için
        komsulukEkle("Edirne", "Kırklareli"); // 39
        komsulukEkle("Edirne", "Tekirdağ"); // 59
        // 23-Elazığ için
        komsulukEkle("Elazığ", "Malatya"); // 44
        komsulukEkle("Elazığ", "Tunceli"); // 62
        // 24-Erzincan için
        komsulukEkle("Erzincan", "Erzurum"); // 25
        komsulukEkle("Erzincan", "Gümüşhane"); // 29
        komsulukEkle("Erzincan", "Giresun"); // 28
        komsulukEkle("Erzincan", "Sivas"); // 58
        komsulukEkle("Erzincan", "Tunceli"); // 62
        komsulukEkle("Erzincan", "Malatya"); // 44
        komsulukEkle("Erzincan", "Bayburt"); //69
        // 25-Erzurum için
        komsulukEkle("Erzurum", "Ardahan"); // 75
        komsulukEkle("Erzurum", "Bayburt"); // 69
        komsulukEkle("Erzurum", "Kars"); // 36
        komsulukEkle("Erzurum", "Muş"); // 49
        komsulukEkle("Erzurum", "Rize"); // 53
        // 26-Eskişehir için
        //komsulukEkle("Eskişehir", "Konya"); // 42
        komsulukEkle("Eskişehir", "Kütahya"); // 43
        // 27-Gaziantep için
        komsulukEkle("Gaziantep", "Hatay"); // 31
        komsulukEkle("Gaziantep", "Kahramanmaraş"); // 46
        komsulukEkle("Gaziantep", "Kilis"); // 79
        komsulukEkle("Gaziantep", "Osmaniye"); // 80
        komsulukEkle("Gaziantep", "Şanlıurfa"); // 63
        // 28-Giresun için
        komsulukEkle("Giresun", "Gümüşhane"); // 29
        komsulukEkle("Giresun", "Ordu"); // 52
        komsulukEkle("Giresun", "Sivas"); // 58
        komsulukEkle("Giresun", "Trabzon"); // 61
        // 29-Gümüşhane için
        komsulukEkle("Gümüşhane", "Bayburt"); // 69
        komsulukEkle("Gümüşhane", "Trabzon"); // 61
        // 30-Hakkari için
        komsulukEkle("Hakkari", "Şırnak"); // 73
        komsulukEkle("Hakkari", "Van"); // 65
        // 31-Hatay için
        komsulukEkle("Hatay", "Osmaniye"); // 80
        // 32-Isparta için
        komsulukEkle("Isparta", "Konya"); // 42
        // 33-Mersin için
        komsulukEkle("Mersin", "Karaman"); // 70
        komsulukEkle("Mersin", "Konya"); // 42
        komsulukEkle("Mersin", "Niğde"); // 51
        // 34-İstanbul için
        komsulukEkle("İstanbul", "Kocaeli"); // 41
        komsulukEkle("İstanbul", "Tekirdağ"); // 59
        // 35-İzmir için
        komsulukEkle("İzmir", "Manisa"); // 45
        // 36-Kars için
        komsulukEkle("Kars", "Ardahan"); // 75
        komsulukEkle("Kars", "Iğdır"); //76
        // 37-Kastamonu için
        komsulukEkle("Kastamonu", "Sinop"); // 57
        komsulukEkle("Kastamonu", "Karabük"); // 78
        komsulukEkle("Kastamonu", "Bartın"); //74
        // 38-Kayseri için
        komsulukEkle("Kayseri", "Kahramanmaraş"); // 46
        komsulukEkle("Kayseri", "Nevşehir"); // 50
        komsulukEkle("Kayseri", "Niğde"); //51
        komsulukEkle("Kayseri", "Sivas"); // 58
        komsulukEkle("Kayseri", "Yozgat"); //66
        // 39-Kırklareli için
        komsulukEkle("Kırklareli", "Tekirdağ"); // 59
        // 40-Kırşehir için
        komsulukEkle("Kırşehir", "Nevşehir"); // 50
        komsulukEkle("Kırşehir", "Yozgat"); // 66
        komsulukEkle("Kırşehir", "Aksaray"); //68
        komsulukEkle("Kırşehir", "Kırıkkale"); //71
        // 41-Kocaeli için
        komsulukEkle("Kocaeli", "Sakarya"); // 54
        komsulukEkle("Kocaeli", "Yalova"); // 77
        // 42-Konya için
        komsulukEkle("Konya", "Karaman"); // 70
        komsulukEkle("Konya", "Niğde"); // 51
        komsulukEkle("Konya", "Aksaray"); //68
        // 43-Kütahya için
        komsulukEkle("Kütahya", "Uşak"); // 64
        komsulukEkle("Kütahya", "Manisa"); //45
        // 44-Malatya için
        komsulukEkle("Malatya", "Kahramanmaraş"); // 46
        komsulukEkle("Malatya", "Sivas"); // 58
        // 45-Manisa için
        komsulukEkle("Manisa", "Uşak"); // 64
        // 46-Kahramanmaraş için
        komsulukEkle("Kahramanmaraş", "Osmaniye"); // 80
        komsulukEkle("Kahramanmaraş", "Sivas"); // 58
        // 47-Mardin için
        komsulukEkle("Mardin", "Şanlıurfa"); // 63
        komsulukEkle("Mardin", "Şırnak"); // 73
        komsulukEkle("Mardin", "Batman"); // 72
        // 48-Muğla için hepsi eklendi
        // 49-Muş için hepsi eklendi
        // 50-Nevşehir için
        komsulukEkle("Nevşehir", "Yozgat"); // 66
        komsulukEkle("Nevşehir", "Niğde"); //51
        komsulukEkle("Nevşehir", "Aksaray"); //68
        // 51-Niğde için
        komsulukEkle("Niğde", "Aksaray"); // 68
        // 52-Ordu için
        komsulukEkle("Ordu", "Sivas"); // 58
        komsulukEkle("Ordu", "Tokat"); // 60
        komsulukEkle("Ordu", "Samsun"); //55
        // 53-Rize için
        komsulukEkle("Rize", "Trabzon"); // 61
        komsulukEkle("Rize", "Bayburt"); // 69
        // 54-Sakarya
        komsulukEkle("Sakarya", "Düzce"); //81
        // 55-Samsun için
        komsulukEkle("Samsun", "Sinop"); // 57
        // 56-Siirt için
        komsulukEkle("Siirt", "Şırnak"); // 73
        komsulukEkle("Siirt", "Van"); // 65
        komsulukEkle("Siirt", "Batman"); //72
        // 57-Sinop için hepsi eklendi
        // 58-Sivas için
        komsulukEkle("Sivas", "Tokat"); // 60
        komsulukEkle("Sivas", "Yozgat"); // 66
        // 59-Tekirdağ için hepsi eklendi
        // 60-Tokat için
        komsulukEkle("Tokat", "Yozgat"); // 66
        // 61-Trabzon için hepsi eklendi
        // 62-Tunceli için hepsi eklendi
        // 63-Şanlıurfa için hepsi eklendi
        // 64-Uşak için hepsi eklendi
        // 65-Van için hepsi eklendi
        // 66-Yozgat için hepsi eklendi
        komsulukEkle("Yozgat", "Kırıkkale");
        // 67-Zonguldak için
        komsulukEkle("Zonguldak", "Düzce"); //81
        komsulukEkle("Zonguldak", "Bartın"); //74
        komsulukEkle("Zonguldak", "Karabük"); //78
        // 68-Aksaray için hepsi eklendi
        // 69-Bayburt için hepsi eklendi
        // 70-Karaman için hepsi eklendi
        // 71-Kırıkkale için hepsi eklendi
        // 72-Batman için hepsi eklendi
        // 73-Şırnak için hepsi eklendi
        // 74-Bartın için
        komsulukEkle("Bartın", "Karabük"); //78
        // 75-Ardahan için hepsi eklendi
        // 76-Iğdır için hepsi eklendi
        // 77-Yalova için hepsi eklendi
        // 78-Karabük için hepsi eklendi
        // 79-Kilis için hepsi eklendi
        // 80-Osmaniye için hepsi eklendi
        // 81-Düzce için hepsi eklendi
    }



    public void komsuluklariKontrolEt() {
        for (Sehir sehir : sehirler) {
            if (sehir != null) {
                System.out.println(sehir.getSehirAdi() + " komşuları:");
                for (Map.Entry<Sehir, Double> komsu : sehir.getKomsuluklar().entrySet()) {
                    System.out.println("  - " + komsu.getKey().getSehirAdi() + " (" + komsu.getValue() + " km)");
                }
            }
        }
    }

}