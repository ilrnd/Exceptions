import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    final private static String formatFile = ".txt";

    public FileReaderWriter() {
    }
    public void writeFile(String fileName, StringBuilder stringBuilder) {
        File file = new File(fileName + formatFile);
        FileWriter fileWriter = null;
        if(!file.exists() && !file.isDirectory()){
            System.out.println("File does not exist, create file...");
            try {
                fileWriter = new FileWriter(fileName + formatFile);
                fileWriter.write(stringBuilder.toString() + "\n");
                System.out.println("Data added to new file " + fileName + formatFile);
            } catch (IOException e) {
                System.out.println("Невозможно создать файл");
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Проблемы с закрытием файла");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("File exists, append data...");
            try {
                fileWriter = new FileWriter(fileName + formatFile,true);
                fileWriter.write(stringBuilder.toString() + "\n");
                System.out.println("Data added to exist file " + fileName + formatFile);
            } catch (IOException e) {
                System.out.println("Невозможно добавить данные");
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Проблемы с закрытием файла");
                    e.printStackTrace();
                }
            }
        }
    }
}
