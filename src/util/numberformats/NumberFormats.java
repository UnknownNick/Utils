/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.numberformats;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author JH
 */
public class NumberFormats extends Frame {
Panel pDec, pBin, pOct, pHex;
Label lDec, lHex, lOct, lBin;
TextField tDec, tHex, tOct, tBin;
    public NumberFormats(){
        super("Number formats");
        this.setLayout(new GridLayout(4,1));
        
        pDec = new Panel();
        pHex = new Panel();
        pOct = new Panel();
        pBin = new Panel();
        
        lDec = new Label("dec: ");
        lHex = new Label("hex: ");
        lOct = new Label("oct: ");
        lBin = new Label("bin: ");
        
        tDec = new TextField();
        tOct = new TextField();
        tHex = new TextField();
        tBin = new TextField();
        
        tDec.setColumns(20);
        tOct.setColumns(20);
        tHex.setColumns(20);
        tBin.setColumns(20);
        
        pDec.setLayout(new BorderLayout());
        pOct.setLayout(new BorderLayout());
        pHex.setLayout(new BorderLayout());
        pBin.setLayout(new BorderLayout());
        
        pDec.add(lDec, BorderLayout.WEST);
        pDec.add(tDec, BorderLayout.CENTER);
        pOct.add(lOct, BorderLayout.WEST);
        pOct.add(tOct, BorderLayout.CENTER);
        pHex.add(lHex, BorderLayout.WEST);
        pHex.add(tHex, BorderLayout.CENTER);
        pBin.add(lBin, BorderLayout.WEST);
        pBin.add(tBin, BorderLayout.CENTER);
        
        this.add(pDec);
        this.add(pOct);
        this.add(pHex);
        this.add(pBin);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        this.pack();
        
        tDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = 0;
                try {
                num = Integer.parseInt(tDec.getText(),10);
                } catch (NumberFormatException ex) { tDec.setText(null);}
                tOct.setText(Integer.toOctalString(num));
                tHex.setText(Integer.toHexString(num));
                tBin.setText(Integer.toBinaryString(num));
            }
        });
        
        tOct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int num = 0;
                try {
                num = Integer.parseInt(tOct.getText(),8);
                } catch (NumberFormatException ex) { tOct.setText(null);}
                tDec.setText(Integer.toString(num));
                tHex.setText(Integer.toHexString(num));
                tBin.setText(Integer.toBinaryString(num));
            }
        });
        
        tHex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = 0;
                try {
                num = Integer.parseInt(tHex.getText(),16);
                } catch (NumberFormatException ex) { tHex.setText(null);}
                tDec.setText(Integer.toString(num));
                tOct.setText(Integer.toOctalString(num));
                tBin.setText(Integer.toBinaryString(num));
            }
        });
        
        tBin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = 0;
                try {
                num = Integer.parseInt(tBin.getText(),2);
                } catch (NumberFormatException ex) { tBin.setText(null);}
                tDec.setText(Integer.toString(num));
                tOct.setText(Integer.toOctalString(num));
                tHex.setText(Integer.toHexString(num));
            }
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new NumberFormats().setVisible(true);
    }
    
}
