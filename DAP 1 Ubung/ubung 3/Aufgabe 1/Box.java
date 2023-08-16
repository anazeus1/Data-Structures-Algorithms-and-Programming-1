public class Box
{

	private double width;
	private double height;
	private double depth;

	public Box(double w, double h, double d)
	{
		if (w >= 0 && h >= 0 && d > 0)
		{
			width = w;
			height = h;
			depth = d;
		}
		else
		{
			width = 0;
			height = 0;
			depth = 0;
		}
	}

	public double getWidth()
	{
		return width;
	}

	public double getHeight()
	{
		return height;
	}

	public double getDepth()
	{
		return depth;
	}

	public double getVolumeSize()
	{
		return width * height * depth;
	}

	public double getAreaSize()
	{
		return 2 * (width * height + width * depth + height * depth);
	}

	public double getEdgesLength()
	{
		return 4 * (width + height + depth);
	}

	public boolean isCube()
	{
		return (width == height) && (width == depth);
	}

	public int compareTo(Box f)
	{
		double v1 = getVolumeSize();
		double v2 = f.getVolumeSize();
		if (v1 > v2)
		{
			return 1;
		}
		else if (v1 == v2)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}

	public boolean encloses(Box f)
	{
		// teste alle moeglichen Kombinationen
		return (width >= f.width  && height >= f.height && depth >= f.depth)
			|| (width >= f.width  && height >= f.depth  && depth >= f.height)
			|| (width >= f.height && height >= f.width  && depth >= f.depth)
			|| (width >= f.height && height >= f.depth  && depth >= f.width)
			|| (width >= f.depth  && height >= f.width  && depth >= f.height)
			|| (width >= f.depth  && height >= f.height && depth >= f.width);
	}
	
}
