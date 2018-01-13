import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Dummy extends Piece
{
	private String name;
	public Dummy(String name, int color, int x, int y)
	{
		this.name = name;
		this.column = x;
		this.row = y;
		this.type = 6;
		this.color = color;
	}

	public int getType() 
	{
		return this.type;
	}

	public int getColor() 
	{
		return this.color;
	}

	public String getName()
	{
		return name;
	}
	
	public void paint(Graphics2D g) 
	{
		//Do nothing 
	}      
}