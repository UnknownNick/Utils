/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.obrazec;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author JH
 */
class JmenaTvaru {
  final static String[] jmena = {
                    "Line", "Rect", "RoundRect", "3DRect",
                    "Oval", "Arc", "Polygon", "Polyline" };
  final static int LINE = 0, RECT = 1, ROUNDRECT = 2, D3DRECT = 3,
                    OVAL = 4, ARC = 5, POLYGON = 6, POLYLINE = 7;
}

class Platno extends Canvas {
  private boolean vypln = false;
  private int typTvaru = JmenaTvaru.LINE;
  private int x1, x2, xMax;
  private int y1, y2, yMax;
  private int sirka, vyska;
  private int[] x, y;
  private final static int OKRAJ = 10;

  private void nastavRozmery() {
    x1 = OKRAJ;
    y1 = OKRAJ;
    xMax = getWidth() - 1;
    yMax = getHeight() - 1;
    x2 = xMax - OKRAJ;
    y2 = yMax - OKRAJ;
    sirka = x2 - x1;
    vyska = y2 - y1;
    int[] xp = {x1, x2, x2, x1};
    x = xp;
    int[] yp = {y1, y2, y1, y2};
    y = yp;
  }

  void setVypln(boolean b) {
    vypln = b;
    repaint();
  }

  void setTypTvaru(int typ) {
    typTvaru = typ;
    repaint();
  }

  void kresliLine(Graphics g) {
    g.drawLine(x1, y1, x2, y2);
  }

  void kresliRect(Graphics g) {
    if (vypln == true)
      g.fillRect(x1, y1, sirka, vyska);
    else
      g.drawRect(x1, y1, sirka, vyska);
  }

  void kresliRoundRect(Graphics g) {
    if (vypln == true)
      g.fillRoundRect(x1, y1, sirka, vyska, OKRAJ * 2, OKRAJ * 4);
    else
      g.drawRoundRect(x1, y1, sirka, vyska, OKRAJ * 2, OKRAJ * 4);
  }

  void kresli3DRect(Graphics g) {
    g.setColor(Color.gray);

    if (vypln == true)
      g.fill3DRect(x1, y1, sirka, vyska, false);
    else
      g.draw3DRect(x1, y1, sirka, vyska, false);
  }

  void kresliOval(Graphics g) {
    if (vypln == true)
      g.fillOval(x1, y1, sirka, vyska);
    else
      g.drawOval(x1, y1, sirka, vyska);
  }

  void kresliArc(Graphics g) {
    if (vypln == true)
      g.fillArc(x1, y1, sirka, vyska, 100, 60);
    else
      g.drawArc(x1, y1, sirka, vyska, 100, 60);
  }

  void kresliPolygon(Graphics g) {
    if (vypln == true)
      g.fillPolygon(x, y, 4);
    else
      g.drawPolygon(x, y, 4);
  }

  void kresliPolyline(Graphics g) {
    g.drawPolyline(x, y, 4);
  }

  public void paint(Graphics g) {
    nastavRozmery();
    switch (typTvaru) {
      case JmenaTvaru.LINE :
        kresliLine(g); break;
      case JmenaTvaru.RECT :
        kresliRect(g); break;
      case JmenaTvaru.ROUNDRECT :
        kresliRoundRect(g); break;
      case JmenaTvaru.D3DRECT :
        kresli3DRect(g); break;
      case JmenaTvaru.OVAL :
        kresliOval(g); break;
      case JmenaTvaru.ARC :
        kresliArc(g); break;
      case JmenaTvaru.POLYGON :
        kresliPolygon(g); break;
      case JmenaTvaru.POLYLINE :
        kresliPolyline(g); break;
    }
  }
}

public class Primitiva extends Frame {
  Choice tvarCH;
  Checkbox vyplnCHB;
  Platno pl;

  Primitiva() {
    super.setTitle(getClass().getName());
    pl = new Platno();
    this.add(pl, BorderLayout.CENTER);

    tvarCH = new Choice();
    for (int i = 0;  i < JmenaTvaru.jmena.length;  i++)
      tvarCH.add(JmenaTvaru.jmena[i]);
    tvarCH.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        pl.setTypTvaru(tvarCH.getSelectedIndex() );
      }
    } );

    vyplnCHB = new Checkbox("Vypln", false);
    vyplnCHB.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        pl.setVypln(vyplnCHB.getState());
      }
    } );


    Panel dolniP = new Panel();
    dolniP.add(tvarCH);
    dolniP.add(vyplnCHB);
    this.add(dolniP, BorderLayout.SOUTH);

    this.setSize(180, 150);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  public static void main(String[] args) {
    new Primitiva().setVisible(true);
  }
}

