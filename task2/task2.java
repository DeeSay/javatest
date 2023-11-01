import java.io.*;

public class task2 {
    public static void main(String[] args) {
        float cx = 0.0f, cy = 0.0f, cr = 0.0f, px = 0.0f, py = 0.0f;
        //чтение файла1 с координатами окружности и радиусом
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0])))
        {
            String line = reader.readLine();
            String[] split = line.split(" ");
            cx = Float.parseFloat(split[0]);
            cy = Float.parseFloat(split[1]);

            line = reader.readLine();
            split = line.split(" ");
            cr = Float.parseFloat((split[0]));
            reader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        //чтение файла2 с координатами точек и решение задачи
        try(BufferedReader reader = new BufferedReader(new FileReader(args[1])))
        {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(" ");
                px = Float.parseFloat(split[0]);
                py = Float.parseFloat(split[1]);

                if(Math.pow((px - cx), 2) + Math.pow((py - cy), 2) < Math.pow(cr, 2)) {
                    System.out.println(1);
                } else if(Math.pow((px - cx), 2) + Math.pow((py - cy), 2) == Math.pow(cr, 2)) {
                    System.out.println(0);
                } else {
                    System.out.println(2);
                }
             
                line = reader.readLine();
            }
            reader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}





