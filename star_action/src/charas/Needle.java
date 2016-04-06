package charas;

import java.awt.Graphics;
//----------------------------------------------------
//当たると死ぬ針です
//----------------------------------------------------



public class Needle extends AbstractChara {
	private static final long serialVersionUID = 1L;
	int tate = 1,
		yoko = 4,
		imgkind;
    public static int SIZE = 50;

	 public Needle(int x, int y, int i) {
		 super(x,y,50,50,"image/needle.png");
		 imgkind = i;
	}

	public void death() {
	//	Mario.iterator.remove();
	}


	// 接触判定
	public boolean hit(AbstractChara c) {
		if (c instanceof PlayerChara
				&& (Math.sqrt((xPosition-c.xPosition)*(xPosition-c.xPosition)+
					(yPosition-c.yPosition)*(yPosition-c.yPosition))<=33)
			){
			
			return true;
		}
		return false;
	}
	// 移動定義
	public void sim() {
	}

	public void draw(Graphics g){
		double sx, sy;
		int pwidth = image.getWidth(null)/yoko;
		int pheight = image.getHeight(null)/tate;
        sx = (imgkind % yoko) * pwidth;
        sy = (imgkind / yoko) * pheight;

		g.drawImage(image,(int)(xPosition- width / 2),(int)(yPosition- height / 2),
				(int)(xPosition+width/2),(int)(yPosition+height/2),
				(int)(sx),(int)(sy), (int)(sx+pwidth), (int)(sy+pheight),this);
	}

	@Override
	public void changeXSpeed() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void changeYSpeed() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}