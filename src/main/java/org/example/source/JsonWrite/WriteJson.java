package org.example.source.JsonWrite;
import org.example.model.FullModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import static org.example.Main.logger;
import static org.example.source.JsonWrite.JsonUtils.*;

public class WriteJson {

    private WriteJson(){};
    static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");

    public static void createJson(FullModel fullModel) {
        try {
            Files.createDirectory(Paths.get("jsonDir"));
            logger.log(Level.INFO, "jsonDir SUCCESS");
        } catch (IOException e) {
            logger.log(Level.FINE, "jsonDir ERROR", e);
        }
        studentsJsonWrite(fullModel);
        universitiesJsonWrite(fullModel);
        statisticsJsonWrite(fullModel);
        logger.log(Level.INFO, "SUCCESS");
    }

    private static void studentsJsonWrite(FullModel fullModel) {
        String studentsJson = jsonFromList(fullModel.getStudentList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonDir/students" + df.format(fullModel.getDate().getTime()) + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.WARNING, "students.json ERROR", e);
        }
    }

    private static void universitiesJsonWrite(FullModel fullModel) {
        String universitiesJson = jsonFromList(fullModel.getUniversityList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonDir/universities" + df.format(fullModel.getDate().getTime()) + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.WARNING, "universities.json ERROR", e);
        }
    }

    private static void statisticsJsonWrite(FullModel fullModel) {
        String statisticsJson = jsonFromList(fullModel.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonDir/statistics" + df.format(fullModel.getDate().getTime()) + ".json");
            outputStream.write(statisticsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.WARNING, "statistics.json ERROR", e);
        }
    }
}

