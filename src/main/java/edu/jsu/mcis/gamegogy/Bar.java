package edu.jsu.mcis.gamegogy;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

class Bar extends JComponent implements ComponentListener {
    private Color barColor = Color.green;
    private float width, height = 20,
            pointsPossible, score,
            x = 20, y = 0;
    
    public Bar(int totalPointsPossible, int score) {
        pointsPossible = totalPointsPossible;
        this.score = score;
        calculateWidth(pointsPossible, score);
        addComponentListener(this);
    }
    
    public void calculateWidth(float pointsPossible, float points) {
        this.width = (points / pointsPossible) * (this.getWidth() * .8f);
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
    
    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println(" --- Resized ");
        calculateWidth(pointsPossible, score);
    }
    @Override
    public void componentMoved(ComponentEvent e) {
    }
    @Override
    public void componentShown(ComponentEvent e) {
    }
    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
