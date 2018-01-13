import java.awt.Graphics2D; 
import java.awt.Graphics;

public class Board 
{

	private Piece[][] pieces;
	private BackGround[][] theBackground;
	private int ROW;
	private int COLUMN;
	private int xPos = 0;
	private int yPos = 0;
	final protected static String IMG_BG_BLACK = "image/black.PNG";
	final protected static String IMG_BG_WHITE = "image/white.PNG";
	int from_row, from_column, to_row, to_column;

	public Board(int row, int column) 
	{
		ROW = row;
		COLUMN = column;
		pieces = new Piece[ROW][COLUMN];
		theBackground = new BackGround[ROW][COLUMN];

		for(int i = 0; i < ROW; i++) 
		{
			for(int j = 0; j < COLUMN; j++) 
			{
				if(i % 2 == 0)
				{
					if(j % 2 == 0)
					{
						theBackground[i][j] = new BackGround(IMG_BG_BLACK, xPos, yPos);
					}
					else 
						theBackground[i][j] = new BackGround(IMG_BG_WHITE, xPos, yPos);
				}
				if(i % 2 == 1)
				{
					if(j % 2 == 1)
					{
						theBackground[i][j] = new BackGround(IMG_BG_BLACK, xPos, yPos);
					}
					else 
						theBackground[i][j] = new BackGround(IMG_BG_WHITE, xPos, yPos);
				}
				xPos += 45; 
			}
		xPos = 0;
		yPos += 45; 
		} 
	}
	
	public void start()
	{
		int i, j;
		
		//Dummy pieces
		for(i = 0; i < 8; i++)
		{
			for(j = 0; j < pieces.length; j++)
			{
					pieces[i][j] = new Dummy("Dummy", 3, j, i);
			} 	
		}
		
		//Kings
		pieces[0][4] = new King("King",Definitions.IMG_KING_BLACK, 1, 4, 0); 
		pieces[7][4] = new King("King",Definitions.IMG_KING_WHITE, 0, 4, 7);
				
		//Queens
		pieces[0][3] = new Queen("Queen", Definitions.IMG_QUEEN_BLACK, 1, 3, 0);
		pieces[7][3] = new Queen("Queen", Definitions.IMG_QUEEN_WHITE, 0, 3, 7);
        
		//Bishops
		pieces[0][2] = new Bishop("Bishop", Definitions.IMG_BISHOP_BLACK, 1, 2, 0);
		pieces[0][5] = new Bishop("Bishop", Definitions.IMG_BISHOP_BLACK, 1, 5, 0);
		pieces[7][2] = new Bishop("Bishop", Definitions.IMG_BISHOP_WHITE, 0, 2, 7);
        pieces[7][5] = new Bishop("Bishop", Definitions.IMG_BISHOP_WHITE, 0, 5, 7);     
        
        // Knights
	    pieces[0][1] = new Knight("Knight", Definitions.IMG_KNIGHT_BLACK, 1, 1, 0);
	    pieces[0][6] = new Knight("Knight", Definitions.IMG_KNIGHT_BLACK, 1, 6, 0);
	    pieces[7][1] = new Knight("Knight", Definitions.IMG_KNIGHT_WHITE, 0, 1, 7);
	    pieces[7][6] = new Knight("Knight", Definitions.IMG_KNIGHT_WHITE, 0, 6, 7);
 
	    // Rooks
	    pieces[0][0] = new Rook("Rook", Definitions.IMG_ROOK_BLACK, 1, 0, 0);
	    pieces[7][0] = new Rook("Rook", Definitions.IMG_ROOK_WHITE, 1, 0, 7);
	    pieces[0][7] = new Rook("Rook", Definitions.IMG_ROOK_BLACK, 0, 7, 0);
	    pieces[7][7] = new Rook("Rook",	Definitions.IMG_ROOK_WHITE, 0, 7, 7);
	    
	    //Pawns
	    for(i = 0; i < 8; i++)
	    {
	    	pieces[1][i] = new Pawn("Pb", Definitions.IMG_PAWN_BLACK, 1, i, 1);
	    	pieces[6][i] = new Pawn("Pb", Definitions.IMG_PAWN_WHITE, 0, i, 6);
	    }            
	}
	
	/**
	* Sets the coordinates for from_column and from_row
	*/
	public void setFrom(int fc, int fr)
	{
		from_column = fc/45;
		from_row = fr/45;
	}
	
	/**
	* Sets the coordinates for to_column and to_row
	*/
	public void setTo(int tc, int tr)
	{
		to_column = tc/45;
		to_row = tr/45;
	}

	public void move()
	{
		int i, j;
		Piece temp;
		for(i = 0; i < pieces.length; i++)
		{
			for(j = 0; j < pieces[0].length; j++)
			{
				if(pieces[i][j].getColumn() == from_column && pieces[i][j].getRow() == from_row)
				{
					if(pieces[to_row][to_column].getName().equals("Dummy"))
					{
						temp = pieces[i][j];
						pieces[i][j] = pieces[to_row][to_column];
						pieces[i][j].setPos(from_column, from_row);
						pieces[to_row][to_column] = temp;
						pieces[to_row][to_column].setPos(to_column, to_row);
					}
				}	
			}
		}
	}
	
	// Ask each background to print itself
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		for(int i = 0; i < ROW; i++)
		{
			for(int j = 0; j < COLUMN; j++) 
			{
				theBackground[i][j].paint(g2);
				pieces[i][j].paint(g2);
			}
		}
	}
}