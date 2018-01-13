import javax.swing.JFrame;
public class ChessRunner 
{

	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ChessViewer component = new ChessViewer();
		frame.add(component);

		frame.setVisible(true);  
	}

}