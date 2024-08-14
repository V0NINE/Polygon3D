import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;

public class ScenePanel extends JPanel{

    private Point[] pointsF1 = new Point[4];
    private Point[] pointsF2 = new Point[4];
    private Point[] pointsF3 = new Point[4];
    private Point[] pointsF4 = new Point[4];
    
    private int animationTick = 0;
    private int animationSpeed = 3;
    private boolean increment = true, firstRotation = true, secondRotation = false, thirdRotation = false, fourthRotation = false;
    private Polygon polygonF1, polygonF2, polygonF3, polygonF4;
    private int[] xPointsF1, yPointsF1, xPointsF2, yPointsF2, xPointsF3, yPointsF3, xPointsF4, yPointsF4;
    private Point point1F1, point2F1, point1F2, point2F2, point1F3, point2F3, point1F4, point2F4;

    private int x1 = 500, x2 = 500;
    private int xTop1 = 100, xTop2 = 500;
    
    public ScenePanel() {
        setPanelSize();
        initializePoints();
        refreshPolygonCoordenates();
    }

    public void setPanelSize() {
        Dimension dimension = new Dimension(1280,800);

        setMinimumSize(dimension);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();

        if(firstRotation || fourthRotation)
        {
            g.setColor(redSideColor());
            polygonF1 = new Polygon(xPointsF1, yPointsF1, xPointsF1.length);
            g.fillPolygon(polygonF1);
        }

        if(firstRotation || secondRotation)
        {
            g.setColor(yellowSideColor());
            polygonF2 = new Polygon(xPointsF2, yPointsF2, xPointsF2.length);
            g.fillPolygon(polygonF2);
        }

        if(secondRotation || thirdRotation)
        {
            g.setColor(greenSideColor());
            polygonF3 = new Polygon(xPointsF3, yPointsF3, xPointsF3.length);
            g.fillPolygon(polygonF3);
        }

        if(thirdRotation || fourthRotation)
        {
            g.setColor(blueSideColor());
            polygonF4 = new Polygon(xPointsF4, yPointsF4, xPointsF4.length);
            g.fillPolygon(polygonF4);
        }

        g.setColor(new Color(0,0,0));
        g.drawLine(x1, 100, x2, 500);
        g.drawLine(xTop1, 100, xTop2, 100);
        g.drawLine(xTop1, 500, xTop2, 500);
        g.drawLine(xTop1, 100, xTop1, 500);
        g.drawLine(xTop2, 100, xTop2, 500);
    }

    public void updateAnimationTick() {
        animationTick++;
        if(animationTick == animationSpeed)
        {
            animationTick = 0;
            updateCoordenates();
            refreshPolygonCoordenates();
        }
    }

    public Color redSideColor() {
        if(firstRotation && x1 <= 380)
        {
            if(x1 >= 330)
            {
                return new Color(230,103,103);
            }else if(x1 >= 295)
            {
                return new Color(219,98,98);
            }else if(x1 >= 240)
            {
                return new Color(207,92,92);
            }else if(x1 >= 180)
            {
                return new Color(196,87,87);
            }else if(x1 >= 120)
            {
                return new Color(186,83,83);
            }else
            {
                return new Color(179,80,80);
            }
        }

        return new Color(237,107,107);
    }
    public Color yellowSideColor() {
        if(secondRotation && x1 <= 380)
        {
            if(x1 >= 330)
            {
                return new Color(235,231,90);
            }else if(x1 >= 295)
            {
                return new Color(224,221,86);
            }else if(x1 >= 240)
            {
                return new Color(219,216,84);
            }else if(x1 >= 180)
            {
                return new Color(209,206,80);
            }else if(x1 >= 120)
            {
                return new Color(196,194,75);
            }else
            {
                return new Color(189,187,73);
            }
        }

        return new Color(242,237,92);
    }
    public Color greenSideColor() {
        if(thirdRotation && x1 <= 380)
        {
            if(x1 >= 330)
            {
                return new Color(123,230,84);
            }else if(x1 >= 295)
            {
                return new Color(119,222,81);
            }else if(x1 >= 240)
            {
                return new Color(113,212,77);
            }else if(x1 >= 180)
            {
                return new Color(109,201,73);
            }else if(x1 >= 120)
            {
                return new Color(105,194,71);
            }else
            {
                return new Color(96,179,65);
            }
        }

        return new Color(130,242,89);
    }
    public Color blueSideColor() {
        if(fourthRotation && x1 <= 380)
        {
            if(x1 >= 330)
            {
                return new Color(84,203,235);
            }else if(x1 >= 295)
            {
                return new Color(80,194,224);
            }else if(x1 >= 240)
            {
                return new Color(75,184,212);
            }else if(x1 >= 180)
            {
                return new Color(72,177,204);
            }else if(x1 >= 120)
            {
                return new Color(68,166,191);
            }else
            {
                return new Color(63,153,176);
            }
        }

        return new Color(87,209,242);
    }

    public void updateCoordenates() {
        if(firstRotation)
        {
            if(increment)
            {
                pointsF1[0].setLocation(pointsF1[0].getX()-1, pointsF1[0].getY());
                pointsF1[3].setLocation(pointsF1[3].getX()-1,pointsF1[3].getY());
                xTop1 -= 1;
    
                point1F1.setLocation(point1F1.getX()-4, point1F1.getY());
                point2F1.setLocation(point2F1.getX()-4, point2F1.getY());
                x1 -= 4;
                x2 -= 4;
    
                pointsF2[1].setLocation(pointsF2[1].getX()+1, pointsF2[1].getY());
                pointsF2[2].setLocation(pointsF2[2].getX()+1, pointsF2[2].getY());
                xTop2 += 1;
    
                if(pointsF2[0].getX() <= 300)
                    increment = false;
            }else if(pointsF2[0].getX() >= 100)
            {
                pointsF1[0].setLocation(pointsF1[0].getX()+1, pointsF1[0].getY());
                pointsF1[3].setLocation(pointsF1[3].getX()+1,pointsF1[3].getY());
                xTop1 += 1;
    
                point1F1.setLocation(point1F1.getX()-4, point1F1.getY());
                point2F1.setLocation(point2F1.getX()-4, point2F1.getY());
                x1 -= 4;
                x2 -= 4;
    
                pointsF2[1].setLocation(pointsF2[1].getX()-1, pointsF2[1].getY());
                pointsF2[2].setLocation(pointsF2[2].getX()-1, pointsF2[2].getY());
                xTop2 -= 1;
    
                if(pointsF2[0].getX() <= 100)
                {
                    x1 = 500;
                    x2 = 500;
                    point1F3.setLocation(500,100);
                    point2F3.setLocation(500,500);

                    firstRotation = false;
                    secondRotation = true;
                    increment = true;
                }
            }
        }

        if(secondRotation) 
        {
            if(increment)
            {
                pointsF2[0].setLocation(pointsF2[0].getX()-1, pointsF2[0].getY());
                pointsF2[3].setLocation(pointsF2[3].getX()-1,pointsF2[3].getY());
                xTop1 -= 1;
    
                point1F2.setLocation(point1F2.getX()-4, point1F2.getY());
                point2F2.setLocation(point2F2.getX()-4, point2F2.getY());
                x1 -= 4;
                x2 -= 4;
    
                pointsF3[1].setLocation(pointsF3[1].getX()+1, pointsF3[1].getY());
                pointsF3[2].setLocation(pointsF3[2].getX()+1, pointsF3[2].getY());
                xTop2 += 1;
    
                if(pointsF3[0].getX() <= 300)
                    increment = false;
            }else if(pointsF3[0].getX() >= 100)
            {
                pointsF2[0].setLocation(pointsF2[0].getX()+1, pointsF2[0].getY());
                pointsF2[3].setLocation(pointsF2[3].getX()+1,pointsF2[3].getY());
                xTop1 += 1;
    
                point1F2.setLocation(point1F2.getX()-4, point1F2.getY());
                point2F2.setLocation(point2F2.getX()-4, point2F2.getY());
                x1 -= 4;
                x2 -= 4;
    
                pointsF3[1].setLocation(pointsF3[1].getX()-1, pointsF3[1].getY());
                pointsF3[2].setLocation(pointsF3[2].getX()-1, pointsF3[2].getY());
                xTop2 -= 1;
    
                if(pointsF3[0].getX() <= 100)
                {
                    x1 = 500;
                    x2 = 500;

                    point1F4.setLocation(500,100);
                    point2F4.setLocation(500,500);

                    secondRotation = false;
                    thirdRotation = true;
                    increment = true;
                }
            }
        }

        if(thirdRotation) 
        {
            if(increment)
            {
                pointsF3[0].setLocation(pointsF3[0].getX()-1, pointsF3[0].getY());
                pointsF3[3].setLocation(pointsF3[3].getX()-1,pointsF3[3].getY());
                xTop1 -= 1;
    
                point1F3.setLocation(point1F3.getX()-4, point1F3.getY());
                point2F3.setLocation(point2F3.getX()-4, point2F3.getY());
                x1 -= 4;
                x2 -= 4;
    
                pointsF4[1].setLocation(pointsF4[1].getX()+1, pointsF4[1].getY());
                pointsF4[2].setLocation(pointsF4[2].getX()+1, pointsF4[2].getY());
                xTop2 += 1;
    
                if(pointsF4[0].getX() <= 300)
                    increment = false;
            }else if(pointsF4[0].getX() >= 100)
            {
                pointsF3[0].setLocation(pointsF3[0].getX()+1, pointsF3[0].getY());
                pointsF3[3].setLocation(pointsF3[3].getX()+1,pointsF3[3].getY());
                xTop1 += 1;
    
                point1F3.setLocation(point1F3.getX()-4, point1F3.getY());
                point2F3.setLocation(point2F3.getX()-4, point2F3.getY());
                x1 -= 4;
                x2 -= 4;
    
                pointsF4[1].setLocation(pointsF4[1].getX()-1, pointsF4[1].getY());
                pointsF4[2].setLocation(pointsF4[2].getX()-1, pointsF4[2].getY());
                xTop2 -= 1;
    
                if(pointsF4[0].getX() <= 100)
                {
                    x1 = 500;
                    x2 = 500;

                    point1F1.setLocation(500,100);
                    point2F1.setLocation(500,500);

                    pointsF1[0] = point1F4;
                    pointsF1[3] = point2F4;
                    
                    thirdRotation = false;
                    fourthRotation = true;
                    increment = true;
                }
            }
        }

        if(fourthRotation) 
        {
            if(increment)
            {
                pointsF4[0].setLocation(pointsF4[0].getX()-1, pointsF4[0].getY());
                pointsF4[3].setLocation(pointsF4[3].getX()-1,pointsF4[3].getY());
                xTop1 -= 1;
    
                point1F4.setLocation(point1F4.getX()-4, point1F4.getY());
                point2F4.setLocation(point2F4.getX()-4, point2F4.getY());
                x1 -= 4;
                x2 -= 4;
    
                pointsF1[1].setLocation(pointsF1[1].getX()+1, pointsF1[1].getY());
                pointsF1[2].setLocation(pointsF1[2].getX()+1, pointsF1[2].getY());
                xTop2 += 1;
    
                if(pointsF1[0].getX() <= 300)
                    increment = false;
            }else if(pointsF1[0].getX() >= 100)
            {
                pointsF4[0].setLocation(pointsF4[0].getX()+1, pointsF4[0].getY());
                pointsF4[3].setLocation(pointsF4[3].getX()+1,pointsF4[3].getY());
                xTop1 += 1;
    
                point1F4.setLocation(point1F4.getX()-4, point1F4.getY());
                point2F4.setLocation(point2F4.getX()-4, point2F4.getY());
                x1 -= 4;
                x2 -= 4;
    
                pointsF1[1].setLocation(pointsF1[1].getX()-1, pointsF1[1].getY());
                pointsF1[2].setLocation(pointsF1[2].getX()-1, pointsF1[2].getY());
                xTop2 -= 1;
    
                if(pointsF1[0].getX() <= 100)
                {
                    x1 = 500;
                    x2 = 500;
                    
                    point1F2.setLocation(500,100);
                    point2F2.setLocation(500,500);

                    fourthRotation = false;
                    firstRotation = true;
                    increment = true;
                }
            }
        }
    }

    public void initializePoints() {
        point1F1 = new Point(500,100);
        point2F1 = new Point(500,500);
        point1F2 = new Point(500,100);
        point2F2 = new Point(500,500);
        point1F3 = new Point(500,100);
        point2F3 = new Point(500,500);
        point1F4 = new Point(100,100);
        point2F4 = new Point(100,500);

        this.pointsF1[0] = point1F4;
        this.pointsF1[1] = point1F1;
        this.pointsF1[2] = point2F1;
        this.pointsF1[3] = point2F4;

        this.pointsF2[0] = point1F1;
        this.pointsF2[1] = point1F2;
        this.pointsF2[2] = point2F2;
        this.pointsF2[3] = point2F1;

        this.pointsF3[0] = point1F2;
        this.pointsF3[1] = point1F3;
        this.pointsF3[2] = point2F3;
        this.pointsF3[3] = point2F2;

        this.pointsF4[0] = point1F3;
        this.pointsF4[1] = point1F4;
        this.pointsF4[2] = point2F4;
        this.pointsF4[3] = point2F3;

        xPointsF1 = new int[pointsF1.length];
        yPointsF1 = new int[pointsF1.length];
        xPointsF2 = new int[pointsF2.length];
        yPointsF2 = new int[pointsF2.length];
        xPointsF3 = new int[pointsF3.length];
        yPointsF3 = new int[pointsF3.length];
        xPointsF4 = new int[pointsF4.length];
        yPointsF4 = new int[pointsF4.length];
    }

    public void refreshPolygonCoordenates() {
        for (int i = 0; i < pointsF1.length; i++)
        {
            xPointsF1[i] = (int)pointsF1[i].getX();
            yPointsF1[i] = (int)pointsF1[i].getY();
        }

        for (int i = 0; i < pointsF2.length; i++)
        {
            xPointsF2[i] = (int)pointsF2[i].getX();
            yPointsF2[i] = (int)pointsF2[i].getY();
        }

        for (int i = 0; i < pointsF3.length; i++)
        {
            xPointsF3[i] = (int)pointsF3[i].getX();
            yPointsF3[i] = (int)pointsF3[i].getY();
        }

        for (int i = 0; i < pointsF4.length; i++)
        {
            xPointsF4[i] = (int)pointsF4[i].getX();
            yPointsF4[i] = (int)pointsF4[i].getY();
        }
    }
}
