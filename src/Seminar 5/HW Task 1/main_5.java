// Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class main_5 {
    public static void main(String[] args) throws IOException {
        createBackup("C:\\Users\\proDream\\IdeaProjects\\GB_Java2\\src\\Seminar 4\\Task 2", "./backup/");
    }

    private static void createBackup(String path, String backupPath) throws IOException {
        File folder = new File(path);
        File backupFolder = new File(backupPath);
        if (!backupFolder.exists()) {
            Files.createDirectory(backupFolder.toPath());
        }
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile()) {
                Files.copy(file.toPath(), Paths.get(backupFolder.getPath() + "/" + file.getName()), REPLACE_EXISTING);
            }
        }
    }
}
