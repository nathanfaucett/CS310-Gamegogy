package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

class Bar extends JComponent{
    private Color barColor = Color.green;
    private float width, height = 20, pointsPossible, score,
            x = 20, y = 0;
    
    public Bar(int totalPointsPossible, int score) {
        pointsPossible = totalPointsPossible;
        this.score = score;
        calculateWidth(pointsPossible, width);
    }
    
    public void calculateWidth(float pointsPossible, float points) {
        this.width = (points / pointsPossible) * 100;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        calculateWidth(pointsPossible, score);
        g2d.setColor(barColor);
        g2d.fillRect((int)x,(int)y,(int)this.width,(int)this.height);
        g2d.setColor(Color.BLACK);
        g2d.draw(new Rectangle2D.Double(x,y,this.width,this.height));
    }
}
