package org.example.Seyahat_Planlama;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloController {
    @FXML
    private WebView webView;
    private WebEngine webEngine;
    private JavaBridge javaBridge;
    private YolVerileri yolVerileri;
    private Dijkstra dijkstra;

    @FXML
    public void initialize() {
        webEngine = webView.getEngine();
        yolVerileri = new YolVerileri();
        yolVerileri.sehirleriDoldur();
        yolVerileri.komsuluklariDoldur();
        dijkstra = new Dijkstra();
        javaBridge = new JavaBridge(yolVerileri, dijkstra);

        javaBridge.setRotaCallback(rota -> {
            Platform.runLater(() -> {
                StringBuilder rotaMetni = new StringBuilder();
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                rotaMetni.append("🗺️ ROTA BİLGİLERİ\n");
                rotaMetni.append("══════════════════════════\n\n");
                rotaMetni.append("📅 Tarih: ").append(now.format(formatter)).append("\n\n");
                rotaMetni.append("🚗 Güzergah Detayı:\n");
                rotaMetni.append("──────────────────\n");

                java.util.List<Sehir> sehirler = rota.getSehirler();
                int toplamDurak = sehirler.size();

                for (int i = sehirler.size() - 1; i >= 0; i--) {
                    String sehirAdi = sehirler.get(i).getSehirAdi();
                    if (i == sehirler.size() - 1) {
                        rotaMetni.append("🏁 Başlangıç: ").append(sehirAdi).append("\n");
                    } else if (i == 0) {
                        rotaMetni.append("🎯 Varış: ").append(sehirAdi).append("\n");
                    } else {
                        rotaMetni.append("📍 Durak ").append(toplamDurak - i -1).append(": ").append(sehirAdi).append("\n");
                    }
                }

                rotaMetni.append("\n Rota İstatistikleri:\n");
                rotaMetni.append("──────────────────\n");
                rotaMetni.append(" Toplam Durak Sayısı: ").append(toplamDurak).append("\n");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(" Rota Planlaması");
                alert.setHeaderText("En Kısa Rota Detayları");

                TextArea textArea = new TextArea(rotaMetni.toString());
                textArea.setEditable(false);
                textArea.setWrapText(true);
                textArea.setPrefRowCount(20);
                textArea.setPrefColumnCount(50);

                GridPane gridPane = new GridPane();
                gridPane.setMaxWidth(Double.MAX_VALUE);
                gridPane.add(textArea, 0, 0);
                GridPane.setVgrow(textArea, Priority.ALWAYS);
                GridPane.setHgrow(textArea, Priority.ALWAYS);

                alert.getDialogPane().setContent(gridPane);
                alert.getDialogPane().setPrefWidth(500);

                alert.show();
            });
        });

        webEngine.getLoadWorker().stateProperty().addListener((obs, old, newState) -> {
            if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
                JSObject window = (JSObject) webEngine.executeScript("window");
                window.setMember("javafx", javaBridge);
            }
        });
    }
}