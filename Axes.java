import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Axes
{
	public Axes(double xmin, double xmax, double ymin, double ymax,
			double xzero, double yzero, double xunit,double yunit)
	{
		xMin = xmin;
		xMax = xmax;
		yMin = ymin;
		yMax = ymax;
		xZero = xzero;
		yZero = yzero;
		xUnit = xunit;
		yUnit = yunit;
	}
	public void draw(Graphics2D g2)
	{
		Line2D.Double line = new Line2D.Double(xMin, yZero, xMax,yZero);
		g2.draw(line);         // x-axis
		line = new Line2D.Double(xZero, yMin, xZero, yMax);
		g2.draw(line);         // y-axis

		for (double i = xZero + xUnit; i <= xMax;  i = i + xUnit)
		{
			if (i >= xMin)
			{
				double halfTick = 0.1 * yUnit;
				line = new Line2D.Double(i, yZero -halfTick, i, yZero + halfTick);
				g2.draw(line);         // tick marks
				//right of origin
			}
		}

		for (double i = xZero - xUnit; i >= xMin;  i = i - xUnit)
		{
			double halfTick = 0.1 * yUnit;
			if (i <= xMax)
			{
				line = new Line2D.Double(i, yZero -
						halfTick, i, yZero + halfTick);
				g2.draw(line);         // tick marks
				//left of origin
			}
		}
		for (double i = yZero - yUnit; i >= yMax;  i = i - yUnit)
		{
			if (i <= yMin)
			{
				double halfTick = 0.1 * xUnit;
				line = new Line2D.Double(xZero -halfTick, i, xZero + halfTick, i);
				g2.draw(line);         // tick marks
				//above origin
			}
		}
		for (double i = yZero + yUnit; i <= yMin;  i = i + yUnit)
		{
			if (i >= yMax)
			{
				double halfTick = 0.1 * xUnit;
				line = new Line2D.Double(xZero -halfTick, i, xZero + halfTick, i);
				g2.draw(line);         // tick marks
				//below origin
			}
		}
	}
	
private double xUnit;
private double yUnit;
private double xZero;
private double yZero;
private double xMin;
private double xMax;
private double yMin;
private double yMax;

}
