import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics; 
import javax.swing.JComponent;

public class ChessViewer extends JComponent
{

	private ChessBoard chessBoard;

	public ChessViewer()
	{
		chessBoard = new ChessBoard();
		addMouseListener(new MouseClickListener());
	}

	public void paintComponent(Graphics h) 
	{
		chessBoard.paint(h);  
	}

	class MouseClickListener extends MouseAdapter 
	{
		boolean value;
		public void mouseClicked(MouseEvent event)
		{
			int x = event.getX();
			int y = event.getY();
			
			System.out.println(x/45 + " " + y/45);
			if(value == false)
			{
				chessBoard.setFrom(x, y);
				value = !value;
			}
			else
			{
				chessBoard.setTo(x, y);
				chessBoard.move();
				value = !value;
			}	
			repaint();
		}
	}
}