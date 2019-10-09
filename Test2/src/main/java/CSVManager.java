import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {

    File file;

    public CSVManager(String path) {
       file = prepareFile(path);
    }

    public File prepareFile(String path) {
        File file;
        if (path.contains(".csv")) {
            file = new File(path);
        } else {
            file = new File(path + "X.csv");
        }
        return file;
    }

    public boolean createFile() throws IOException {
        return file.createNewFile();
    }

    public boolean createFile(String path) throws IOException {
        file = prepareFile(path);
        return createFile();
    }

    public boolean removeFile() {
        if (file.exists())
            return file.delete();
        else
            return true;
    }

    public ArrayList<String[]> readFile() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        ArrayList<String[]> result = new ArrayList<String[]>();
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split("; ");
            result.add(data);
        }
        csvReader.close();
        return result;
    }

    public boolean writeLines(List<List<String>> rows) throws IOException {
        FileWriter csvWriter = new FileWriter(file.getAbsoluteFile());
        csvWriter.append("x");
        csvWriter.append("; ");
        csvWriter.append("result");
        csvWriter.append("\n");

        for (List<String> rowData : rows) {
            csvWriter.append(String.join("; ", rowData));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

        return true;
    }

}
