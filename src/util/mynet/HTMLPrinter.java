package util.mynet;

import java.io.*;
import java.net.*;

public class HTMLPrinter {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://docs.oracle.com/javase/tutorial/networking/sockets/index.html");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }  
}