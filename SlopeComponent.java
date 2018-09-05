import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

public class SlopeCompomemt extends JComponent
{
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; //recovers Graphics2D
		
		Axes axes = new Axes(0, 400, 400, 0, 200, 200, 25, 25);
		axes.draw(g2);
		
	}
	
	public void plotPoints(Graphics g2)
	{
		
		double x1 = p1.getX();
		double y1 = p1.getY();
		
		double x2 = p2.getX();
		double y2 = p2.getY();
		
		Ellipse2D.Double dot1 = new Ellipse2D.Double(x1, y1, 5, 5);
		Ellipse2D.Double dot2 = new Ellipse2D.Double(x2, y2, 5, 5);
		
	}
	
	
	private Point2D.Double p2;
	
	private Point2D.Double p1;
	
}
