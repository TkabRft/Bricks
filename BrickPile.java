//package bricks;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class BrickPile extends SpriteVector {
	//private static int _rows = 4;
	//private final int _cols = 10;
	private PlayField _pf;
	//private ArrayList ;

	private Vector <Brick> _bricks=new Vector<Brick>();
	private Enumeration<Brick>  _count=_bricks.elements();

	public BrickPile(PlayField pf, Image img) {
		_pf = pf;
		//_bricks = new ArrayList();
		int startx = 80; 
		int x = startx, y = 10;
	/*
		for (int r = 0; r < _rows; r++) {
			for (int c = 0; c < _cols; c++) {
				Rectangle pos = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
				
				Brick b = new Brick(_pf, this, img, pos);
				pf.addSprite(b);
				_bricks.add(b);
        
				x += img.getWidth(null);
			}
			
			y += img.getHeight(null) + 2;
			x = startx;
		}
	 */
	int i=0;
	int localcount=0;
		while (_bricks.size()<40) {
			while (i<10)
			{
				Rectangle pos = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
				_bricks.add(new Brick(_pf, this, img, pos));
				pf.addSprite(_bricks.get(localcount));
				x += img.getWidth(null);
				i++;
				localcount++;
			}
			i=0;
			y += img.getHeight(null) + 2;
			x = startx;
		}

	}

	public int unbrokenCount() {
		int result = 0;
		
		for (int i = 0; i < _bricks.size(); i++) {
			if ( !((Brick) _bricks.get(i)).isDead() )
				result++; 	
		}
		
		return result;
	}

	public int brokenCount() {
		return _bricks.size() - unbrokenCount();	
	}
}
