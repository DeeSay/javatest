import java.util.*;
import java.io.*;
import java.util.Arrays;

public class task3 {
public static void main(String[] args) throws FileNotFoundException {
    Map<String, String> res = new HashMap<String, String>();
    //разбиение файла values.json по id в hashmap
    try(BufferedReader reader = new BufferedReader(new FileReader(args[1])))
    {
        String line = reader.readLine();
        String tmpKey, tmpValue;
        while (line != null) {
            if(line.contains("id")) {
                tmpKey = line.substring(line.indexOf('"'), line.indexOf(',') + 1);
                line = reader.readLine();
                tmpValue = line.substring(line.indexOf('"'));
                res.put(tmpKey, tmpValue);
            }
            line = reader.readLine();
        }
        reader.close();
    }
    catch(IOException ex){
        System.out.println(ex.getMessage());
    }

    try {
        File file = new File("report.json");
        try(BufferedReader readerTest = new BufferedReader(new FileReader(args[0]))) {
            try (BufferedWriter writerReport = new BufferedWriter(new FileWriter(file))) {
                String readTestsLine = readerTest.readLine();
                String tmpValue, tmpKey, l;
                int u = 0;
                while(readTestsLine != null) {
                    if(readTestsLine.contains("id") && res.containsKey(readTestsLine.substring(readTestsLine.indexOf('"'), readTestsLine.indexOf(',') + 1))) {
                        writerReport.write(readTestsLine + '\n');
                        tmpKey = readTestsLine.substring(readTestsLine.indexOf('"'), readTestsLine.indexOf(',')+1);
                        readTestsLine = readerTest.readLine();
                        writerReport.write(readTestsLine + '\n');
                        readTestsLine = readerTest.readLine();
                        if(readTestsLine.charAt(readTestsLine.length()-1) == ',') {
                            readTestsLine = readTestsLine.replace(readTestsLine, res.get(tmpKey) + ',');
                            writerReport.write(readTestsLine + '\n');
                            readTestsLine = readerTest.readLine();
                        } else {
                            readTestsLine = readTestsLine.replace(readTestsLine, res.get(tmpKey));
                            writerReport.write(readTestsLine + '\n');
                            readTestsLine = readerTest.readLine();
                        }
                    }
                    else {
                        writerReport.write(readTestsLine + '\n');
                        readTestsLine = readerTest.readLine();
                    }
                }
                writerReport.close();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            readerTest.close();
        }

        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    } catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    
    }
}

