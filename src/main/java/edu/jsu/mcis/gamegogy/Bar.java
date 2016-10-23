package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

class Bar extends JComponent{
    private Color barColor = Color.green;
    private Point[] barVertices;
    private float width = 100, height = 20, pointsPossible, score,
            x = 20, y = 0;
    
    public Bar(int totalPointsPossible, int score) {
        pointsPossible = totalPointsPossible;
        this.score = score;
        
        barVertices = new Point[4];
        for(int i = 0; i < barVertices.length; i++) { 
            barVertices[i] = new Point(); 
        }
        
    }
    
    public void calculateWidth(float pointsPossible, float points) {
        this.width = (points / pointsPossible) * 100;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(barColor);
        g2d.fillRect((int)x,(int)y,(int)this.width,(int)this.height);
        calculateWidth(pointsPossible, score);
        g2d.setColor(Color.BLACK);
        g2d.draw(new Rectangle2D.Double(x,y,this.width,this.height));
    }
}
