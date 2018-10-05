import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

public class SlopeCompomemt extends JComponent
{
	
	public SlopeCompomemt()
	{
		

		p1 = null;
		p2 = null;
		
		class MousePressListener extends MouseAdapter
		{
			
			int mouseClickTrack = 1;

			public void mouseClicked(MouseEvent event)
		    {
				p = new Point2D.Double(event.getX(), event.getY());
				
				if(mouseClickTrack%1==0)
				{
					mousePressedX1 = event.getX( );
					mousePressedY1 = event.getY( );
					p1 = new Point2D.Double(mousePressedX1, mousePressedY1);
					mouseClickTrack++;
					//repaint();
				}
		       
				if (mouseClickTrack%2==0)
				{
					mousePressedX2 = event.getX( );
					mousePressedY2 = event.getY( );
					p2 = new Point2D.Double(mousePressedX2, mousePressedY2);
					//mouseClickTrack++;
					//repaint();
				}
		       
		       repaint( );
		       
		    }
			
		}
		
		MouseListener listener = new MousePressListener();
		addMouseListener(listener);
		
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; //recovers Graphics2D
		
		Axes axes = new Axes(0, 400, 400, 0, 200, 200, 25, 25);
		axes.draw(g2);
		
		//plotPoints(g2);
		if(p!=null)
		{
			plotPoints(p, g2);
		}
		if(p1!=null && p2!=null)
		{
			plotPoints(p1, g2);
			plotPoints(p2, g2);

			
			g2.drawLine(mousePressedX1, mousePressedY1, mousePressedX2, mousePressedY2);
			
			//Display coordinates
			g2.drawString("("+ ((mousePressedX1 - 200)/25) +","+ (((mousePressedY1 - 200)*-1)/25) +")", mousePressedX1 + 5, mousePressedY1 + 5);
			g2.drawString("("+ ((mousePressedX2 - 200)/25) +","+ (((mousePressedY2 - 200)*-1)/25) +")", mousePressedX2 + 5, mousePressedY2 + 5);
			
			calcSlope(p1, p2, g2);
		}
		
	}
	
	
	public void calcSlope(Point2D.Double p1, Point2D.Double p2, Graphics2D g2)
	{
		
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		
		double slopeInt = (y2-y1)/(x2-x1);
		
		if(y2 == y1)
		{
			
			g2.drawString("no slope",  (int)(x1+x2)/2, (int)(y1+y2)/2);
			
		}
		
		{
			g2.drawString("slope = " + String.format("%1.1f", -1 * slopeInt), (int)(x1+x2)/2, (int)(y1+y2)/2);

		}
		
	
		
	}
	
	
	public void plotPoints(Point2D.Double p1, Graphics2D g2)
	{
		
		double x1 = p1.getX();
		double y1 = p1.getY();
		
		Ellipse2D.Double dot1 = new Ellipse2D.Double(x1 - 5, y1 - 5, 5, 5);
		g2.fill(dot1);
		
	}
	
	
	private int mousePressedX1;
	private int mousePressedY1;
	
	private int mousePressedX2;
	private int mousePressedY2;
	
	private Point2D.Double p2;
	
	private Point2D.Double p1;
	
	private Point2D.Double p;
	
}
