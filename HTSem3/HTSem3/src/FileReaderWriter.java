import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    public FileReaderWriter(String fileName, StringBuilder stringBuilder) {
        File file = new File(fileName);
        FileWriter fileWriter = null;
        if(!file.exists() && !file.isDirectory()){
            System.out.println("File is not exist, create file...");
            try {
                fileWriter = new FileWriter(fileName);
                fileWriter.write(stringBuilder.toString() + "\n");
            } catch (IOException e) {
                System.out.println("Невозможно создать файл");
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Проблемы с закрытием файла");;
                }
            }
        }
    }
}
