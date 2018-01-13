/*
* Displays a single image of a background
*/

import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class BackGround
{
	private BufferedImage image;
    private int x,y;

    public BackGround(String imageName, int x, int y)
    {
    	this.x = x;
		this.y = y;

		try 
		{
			image = ImageIO.read(new File(imageName));
		} 
		catch  (IOException e) {}
	}
	public void paint(Graphics2D g) 
	{
		g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);  
	} 
}