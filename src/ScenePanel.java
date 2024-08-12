import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;

public class ScenePanel extends JPanel{

    private Point[] points = new Point[4];
    private Color color = new Color(200,20,0);
    private int animationTick = 0;
    private int animationSpeed = 6;
    private boolean increment = true;
    private Polygon polygon;
    private int[] xPoints, yPoints;
    
    public ScenePanel() {
        setPanelSize();
        initializePoints();
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

        for(int i = 0; i < 3; i++) {
            g.drawLine((int)points[i].getX(), (int)points[i].getY(), (int)points[i+1].getX(), (int)points[i+1].getY());
        }

        g.setColor(color);
        g.drawLine((int)points[3].getX(), (int)points[3].getY(), (int)points[0].getX(), (int)points[0].getY());

        g.setColor(color = new Color(237,107,107));
        polygon = new Polygon(xPoints, yPoints, xPoints.length);
        g.fillPolygon(polygon);
    }

    public void updateAnimationTick() {
        animationTick++;
        if(animationTick == animationSpeed)
        {
            animationTick = 0;
            updateCoordenates();
        }
    }

    public void updateCoordenates() {
        if(increment) 
        {
            points[0].setLocation(points[0].getX()+5, points[0].getY());
            points[3].setLocation(points[3].getX()+5, points[3].getY());

            points[1].setLocation(points[1].getX()-5, points[1].getY());
            points[2].setLocation(points[2].getX()-5, points[2].getY());

            if(points[0].getX() >= 500)
                increment = false;
        }else
        {
            points[0].setLocation(points[0].getX()-5, points[0].getY());
            points[3].setLocation(points[3].getX()-5, points[3].getY());

            points[1].setLocation(points[1].getX()+5, points[1].getY());
            points[2].setLocation(points[2].getX()+5, points[2].getY());

            if(points[0].getX() <= 100)
                increment = true;
        }
    }

    public void initializePoints() {
        this.points[0] = new Point(100,100);
        this.points[1] = new Point(500,100);
        this.points[2] = new Point(500,500);
        this.points[3] = new Point(100,500);

        xPoints = new int[points.length];
        yPoints = new int[points.length];

        for (int i = 0; i < points.length; i++)
        {
            xPoints[i] = (int)points[i].getX();
            yPoints[i] = (int)points[i].getY();
        }
    }
}
