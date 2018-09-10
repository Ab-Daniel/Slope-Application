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
		
		if(p1!=null && p2!=null)
		{
			plotPoints(g2);
			
			
			g2.drawLine(mousePressedX1, mousePressedY1, mousePressedX2, mousePressedY2);
			
			//Display coordinates
			g2.drawString("("+ ((mousePressedX1 - 200)/25) +","+ (((mousePressedY1 - 200)*-1)/25) +")", mousePressedX1 + 5, mousePressedY1 + 5);
			g2.drawString("("+ ((mousePressedX2 - 200)/25) +","+ (((mousePressedY2 - 200)*-1)/25) +")", mousePressedX2 + 5, mousePressedY2 + 5);
			
			//Display the slope
			g2.drawString("Slope = ", ((mousePressedX1+mousePressedX2)/2), ((mousePressedY1/mousePressedY2)/2));
			
		}
		
	}
	
	public void calcSlope()
	{
		
		int x;
		String xString;
		
		if((mousePressedY2>mousePressedY1) && (mousePressedX2>mousePressedX1))
		{
			x = mousePressedY2/mousePressedY1;
			//xString = 
		}
		
		String slope;
		
		//return slope;
		
	}
	
	public void plotPoints(Graphics2D g2)
	{
		
		double x1 = p1.getX();
		double y1 = p1.getY();
		
		double x2 = p2.getX();
		double y2 = p2.getY();
		
		Ellipse2D.Double dot1 = new Ellipse2D.Double(x1, y1, 5, 5);
		g2.fill(dot1);
		Ellipse2D.Double dot2 = new Ellipse2D.Double(x2, y2, 5, 5);
		g2.fill(dot2);
		
	}
	
	
	private int mousePressedX1;
	private int mousePressedY1;
	
	private int mousePressedX2;
	private int mousePressedY2;
	
	private Point2D.Double p2;
	
	private Point2D.Double p1;
	
}
