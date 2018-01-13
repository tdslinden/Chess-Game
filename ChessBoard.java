import java.awt.Graphics;
import java.awt.Graphics2D;

public class ChessBoard extends Board 
{
	public ChessBoard() 
	{
		super(8, 8);
		super.start();
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		super.paint(g2);
	}
}