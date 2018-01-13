import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public abstract class Piece 
{
	private String name;
	protected int color;
	protected int type;
	protected int row;
	protected int column;
	protected BufferedImage image;

	abstract public void paint(Graphics2D g2);
	abstract public int getType();
	abstract public int getColor();

	/*
   	This piece returns its current row
    @return int the pieces current row
	 */
	public int getRow() 
	{
		return this.row;
	}

	/*
    This piece returns its current column
    @return int, pieces current column
	 */
	public int getColumn() 
	{
		return this.column;
	}

	public String getName()
	{
		return name;
	}
	/*
    Sets a new position for this piece
    @param x new column for this piece
    @param y new row for this piece
	 */
	public void setPos(int x, int y) 
	{
		row = y;
		column = x;
	}
}