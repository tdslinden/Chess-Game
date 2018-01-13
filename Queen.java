import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Queen extends Piece
{
	private String name;
	public Queen(String name, String imageName, int color, int x, int y)
	{
		this.name = name;
		this.column = x;
		this.row = y;
		this.type = 1;
		this.color = color;
		
		try 
		{
			this.image = ImageIO.read(new File(imageName));
		} 
		catch  (IOException e) {}
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
		g.drawImage(image, this.column*45, this.row*45, image.getWidth(), image.getHeight(), null);  
	}      
}