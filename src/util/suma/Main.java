/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.suma;
import java.io.*;
import java.util.*;
/**
 *
 * @author JH
 */
public class Main {
    private static File input;
    private static String fname = "/home/pepik/Plocha/input.txt";
    private static int count = 15;
    private static int[] nums = new int[count];
    private static TreeSet<Integer> prices = new TreeSet();
    private static int suma1 = 3345492;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        loadInputFile();
        find();
    }
    
    protected static void loadInputFile() throws IOException{
        input = new File(fname);
        FileReader fr = new FileReader(input);
        BufferedReader br = new BufferedReader(fr);
        
        String inputLine;
        int i = 0;
        while ((inputLine = br.readLine()) != null) {
            nums[i] = Integer.parseInt(inputLine);
            i++;
            }
        br.close();
        fr.close();
    }
    
    protected static void init() {
        prices = new TreeSet();
        //for(int i = 0; i < nums.length ; i++)
        //    prices.add(nums[i]);
    }
    
    private static void find() {
        Iterator it = new Iterator(count);
        int suma = 0;
        boolean[] indexes;
        int[] sumy = new int[32768];
        int j = 0;
        while(it.next()) {
            indexes = it.getArray();
            for(int i = 0; i < count ; i++) {
                if(indexes[i]) suma += nums[i];
            }
            System.out.print(j + " * " + suma + ", ");
            for(int u : it.getNumbers())
                System.out.print(u + " ");
            System.out.println();
            sumy[j] = suma;
            j++;
            suma = 0;
        }
        System.out.println("*===========================================*");
        for(int k = 0; k < sumy.length ; k++) {
            if(sumy[k] == suma1) System.out.println(suma1 + " 1 => " + k);
            //if(sumy[k] == suma2) System.out.println(suma2 + " 2 => " + k);
        }
        for(int s:sumy) {
            prices.add(s);
        }
        /*int i1 = prices.size();
        for(int ij = 0; ij <= i1 ; ij++) {
            System.out.println(ij + " * " + prices.pollFirst());
        }*/
        int ij = prices.size();
        int i2;
        for(int i1 = 0 ; i1 < ij ; i1++) {
            i2 = prices.pollFirst();
            System.out.println(i1 + " * " + i2 + " - " + (suma1 - i2)/* + " _ " + (suma2 - i2)*/);
        }
    }
}
