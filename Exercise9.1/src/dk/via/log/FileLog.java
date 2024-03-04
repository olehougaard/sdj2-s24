package dk.via.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class FileLog {
    private final CurrentTime currentTime;
    private final File logFile;

    public FileLog(File logFile) {
        this.logFile = logFile;
        currentTime = new CurrentTime();
    }

    private File getLogFile() {
        return logFile;
    }

    public void log(String message) throws IOException {
        try (FileWriter fileWriter = new FileWriter(getLogFile(), true);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            String logLine = currentTime.getFormattedTime() + " - " + message;
            writer.println(logLine);
        }
    }
}
