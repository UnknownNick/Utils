/** 
 * totally free
 */
package util.prime;

import java.io.*;

public class PrimeNumbers {
static File f;
static PrintWriter pw;
static FileOutputStream fw;

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        boolean useMax = false;
        boolean useAm = false;
        int x = 0;
        
        if(args.length != 2){
            System.err.println("Usage: java PrimalNumbers [-max | -am] <value>");
            System.exit(1);
        }
        
        useMax = (args[0].equals("-max"));
        useAm = (args[0].equals("-am"));
        x = Integer.valueOf(args[1]);
        
        if(useMax==false & useAm==false){
            System.err.println("Usage: java PrimalNumbers [-max | -am] <value>");
            System.exit(1);
        }
        
        try {
            if(useMax)
                f = new File("Primal numbers lower than " + x + ".txt");
            if(useAm) f = new File(x + " of the lowest Primal numbers.txt");
            try {
                f.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                fw = new FileOutputStream(f);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            pw = new PrintWriter(fw);
            
            int[] p = null;
            if(useMax) p = getPrimals(x);
            else p = getnOfPrimals(x);
            
            String sep = System.lineSeparator();
            for(int j : p){
                if(j!=0) pw.print(j + sep);
            }
            pw.flush();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("Done.");
    }
    
    public static int[] getPrimals(int max){
        int[] p = new int[max];
        p[0] = 1;
        p[1] = 2;
        p[2] = 3;
        
        for(int i = 5; i <= max ; i = i + 2 ){
            for(int u = 1; /*p[u] != 0*/ ; u++ ){
                
                if(p[u]==0){
                p[u] = i;
                break;
                }
                
                if(i != p[u] & i % p[u] == 0){
                    break;
                }
                
            }
        }
        
    return p;}
    
    public static int[] getnOfPrimals(int amount){
        if(amount<10) amount = 10;
        int[] p = new int[amount];
        p[0] = 1;
        p[1] = 2;
        p[2] = 3;
        
        for(int i = 5; p[amount-1]==0 ; i = i + 2 ){
            for(int u = 1; u <= amount ; u++ ){
                
                if(p[u]==0){
                p[u] = i;
                break;
                }
                
                if(i != p[u] & i % p[u] == 0){
                    break;
                }
                
            }
        }
    return p;}
}
