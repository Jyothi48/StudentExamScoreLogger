package task2;

import java.io.FileWriter;
import java.io.IOException;

public class Scorewriter {
	String filePath;

    public Scorewriter(String filePath) {
        this.filePath = filePath;
    }

   public synchronized void writeToFile(Students student) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(student.toString()+ "\n");
            System.out.println("Written: "+ student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
