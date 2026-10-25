/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.systemliquorstore.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
/**
 *
 * @author Enrique Ayala, LogicLords,@ESPE
 */

public class Jsonstorage {
 
    private final Path filePath;
    private final Gson gson;
 
    public Jsonstorage(String filePath) {
        this.filePath = Paths.get(filePath).toAbsolutePath();
        this.gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    }
 
    public boolean exists() {
        return Files.exists(filePath);
    }
 
    public String getFilePath() {
        return filePath.toString();
    }
 
    public void save(Storedata data) throws IOException {
        Files.createDirectories(filePath.getParent());
        Path temporary = Paths.get(filePath.toString() + ".tmp");
        Files.write(temporary, gson.toJson(data).getBytes(StandardCharsets.UTF_8));
        Files.move(temporary, filePath, StandardCopyOption.REPLACE_EXISTING);
    }
 
    public Storedata load() throws IOException {
        String json = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
        try {
            Storedata data = gson.fromJson(json, Storedata.class);
            if (data == null || !data.isValid()) {
                throw new IOException("El archivo está vacío o contiene registros no válidos.");
            }
            return data;
        } catch (RuntimeException exception) {
            throw new IOException("El archivo no tiene un formato JSON válido.", exception);
        }
    }
 
    public String backupDamagedFile() throws IOException {
        Path backup = Paths.get(filePath.toString() + ".bak");
        Files.move(filePath, backup, StandardCopyOption.REPLACE_EXISTING);
        return backup.toString();
    }
 
}
 