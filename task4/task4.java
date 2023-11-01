import java.util.*;
import java.io.*;
import java.util.Arrays;

public class task4 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line = reader.readLine();
            while(line != null) {
                arr.add(Integer.parseInt(line));
                line = reader.readLine();;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        Integer[] nums = new Integer[arr.size()]; //из ArrayList -> Array для сортировки
        nums = arr.toArray(nums);

        int counter = 0;
        Arrays.sort(nums);
        int med, s = 0, m;
        med = nums.length / 2;
        m = nums[med];
        for(int q : nums) {
            s += Math.abs(q - m);
        }

        System.out.println(s);
    }
}

