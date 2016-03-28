/*
 * freeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee!
 */
package util.obrazec;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author JH
 */
public class Kolecka extends Frame{
    PlatnoSit p;
    static Kolecka k = new Kolecka();
    
    public Kolecka(){
        super("obrazec");
        this.setLayout(new GridLayout());
        this.setSize(1000, 1000);
        
        this.add((p = new PlatnoSit(this)));
        p.setSize(this.getSize());
        
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ev){
                System.exit(0);
            }
        });
        
        new Vel(p).setVisible(true);
    }
    
    public static void main(String[] args) {
        k.setVisible(true);
    }
}

class PlatnoKruhy extends Canvas{
    int size;
    Kolecka owner;
    public PlatnoKruhy(int size, Kolecka owner){
        super();
        this.owner = owner;
        
        this.size = size;
        //this.setBackground(Color.red);
        
    }
    
    @Override
    public void paint(Graphics g){
        this.setSize(owner.getSize());
        for(int i = 1; i<=50 ;i++){
            g.drawOval( ((i<12)?(103*i):(200*(i-12)))+i,(i<12)?(60):(220) , 10*(i), 10*(i));
        }
    }
}

class PlatnoSit extends Canvas{
    int size = 20;
    Kolecka owner;
    public PlatnoSit(Kolecka owner){
        super();
        this.owner = owner;
        
    }
    public void setSpace(int value){
        this.size = value;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        this.setSize(owner.getSize());
        int x = owner.getWidth();
        int y = owner.getHeight();
        for(int i = 1; i<=1000 ;i++){
            g.drawLine(0, size*i, x, size*i);
        }
        for(int u = 1 ; u <= 1000 ; u++){
            g.drawLine(size*u,0,size*u,y);
        }
    }
}


class Vel extends Frame{
    TextField t,cBlue,cGreen,cRed;
    Panel p;
    public Vel(final PlatnoSit obj){
        super("Mezera sítě");
        this.setSize(220, 80);
        this.setLayout(new BorderLayout());
        
        t = new TextField();
        this.add(t,BorderLayout.NORTH);
        
        p = new Panel();
        p.setLayout(new GridLayout(1,3));
        
        cBlue = new TextField("0");
        cGreen = new TextField("0");
        cRed = new TextField("0");
        cBlue.setBackground(Color.blue);
        cGreen.setBackground(Color.green);
        cRed.setBackground(Color.red);
        p.add(cRed);
        p.add(cGreen);
        p.add(cBlue);
        
        this.add(p, BorderLayout.SOUTH);
        
        this.setResizable(false);
        
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                try{ i = Integer.valueOf(t.getText());
                }   catch(java.lang.NumberFormatException ex){
                    t.setText(null);
                }
                if(i>0)obj.setSpace(i);
            }
        });
        
        cBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                Color c = Kolecka.k.p.getBackground();
                try{
                    i = Integer.valueOf(cBlue.getText());
                } catch(java.lang.NumberFormatException ex){ cBlue.setText(null); }
                if(i>=0 && i<256){
                    Color x = new Color(c.getRed(),c.getGreen(),i);
                    Kolecka.k.p.setBackground(x);
                System.out.println("Color changed to: " + x.toString());
                } else cBlue.setText(null);
            }
        });
        
        cGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                Color c = Kolecka.k.p.getBackground();
                try{
                    i = Integer.valueOf(cGreen.getText());
                } catch(java.lang.NumberFormatException ex){ cGreen.setText(null); }
                if(i>=0 && i<256){
                    Color x = new Color(c.getRed(),i,c.getBlue());
                    Kolecka.k.p.setBackground(x);
                System.out.println("Color changed to: " + x.toString());
                } else cGreen.setText(null);
            }
        });
        
        cRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                Color c = Kolecka.k.p.getBackground();
                try{
                    i = Integer.valueOf(cRed.getText());
                } catch(java.lang.NumberFormatException ex){ cRed.setText(null); }
                if(i>=0 && i<256){
                    Color x = new Color(i,c.getGreen(),c.getBlue());
                    Kolecka.k.p.setBackground(x);
                System.out.println("Color changed to: " + x.toString());
                } else cRed.setText(null);
            }
        });
    }
}