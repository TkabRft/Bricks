//package bricks;

import java.awt.Image;
import java.util.Enumeration;
import java.util.Vector;

/* Хранилище спрайтов */

class PuckSupply extends SpriteVector {
	/*
	 * @_puck - массив шайб
	 * @_count - кол-во оставшихся шайб
	 */
	 
	private Vector <Puck> _pucks=new Vector<Puck>();
	private Enumeration<Puck>  _count=_pucks.elements();

	public static int left;
	public PuckSupply(int N, PlayField pf, Image pic) {
		left=N;
		for (int i = 0; i < N; i++)
		{
			_pucks.add(new Puck(pf, this, pic));
		}
	}
	public int size() {
		return _pucks.size();
	}
	
	/* Взять следующую шайбу из хранилища */
	public Puck get()
	{
		if (_count.hasMoreElements())
		{

			System.out.print("_pucks.size before get ");
			System.out.println(_pucks.size());
			Puck P=_count.nextElement();
			System.out.print("_pucks.size after get ");
			System.out.println(_pucks.size());
			return P;
		}
		else
			return null;
	}

	public void removePuck(){
		System.out.print("_pucks.size before removePuck ");
		System.out.println(_pucks.size());

		_pucks.remove(_pucks.lastElement());
		System.out.print("_pucks.size after removePuck ");
		System.out.println(_pucks.size());
	}
}

