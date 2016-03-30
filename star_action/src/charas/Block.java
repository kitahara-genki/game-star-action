package charas;

//----------------------------------------------------
//ブロックです。子のクラスとしてアイテムブロックも作るか？
//----------------------------------------------------
import java.awt.*;

public class Block extends Chara {
	private static final long serialVersionUID = 1L;
	public boolean removable = true;

	public Block(int x, int y) {
		width = SIZE;
		height = SIZE;
		xPosition = x * SIZE + SIZE / 2;
		yPosition = y * SIZE + SIZE / 2;
		img = getToolkit().createImage("src/image/block.png");
	}
	public Block(int x, int y, int w, int h) {
		width = w;
		height = h;
		xPosition = x * SIZE + SIZE / 2;
		yPosition = y * SIZE + SIZE / 2;
	}

	public void sim() {
	}

	// 接触判定
	public boolean hit(Chara c) {
		return Math.abs(c.xPosition + c.xSpeed - xPosition) < c.width / 2 + width / 2
				&& Math.abs(c.yPosition + c.ySpeed - yPosition) < c.height / 2 + height / 2;
	}

	// 接触かつ直前にx方向に接触していない場合に位置、速度を調整
	public boolean hitx(Chara c) {
		boolean x = hit(c);
		if (x && Math.abs(c.xPosition - xPosition) >= c.width / 2 + width / 2 ) {
			c.xPosition = xPosition - (c.width / 2 + SIZE / 2) * Math.signum(c.xSpeed);
			if(c instanceof PlayerChara)
				c.xSpeed = 0;
			
		}
		return x;
	}

	public boolean hity(Chara c) {
		boolean x = hit(c);
		if (x && Math.abs(c.yPosition - yPosition) >= c.height / 2 + height / 2) {
			c.yPosition = yPosition - (c.height / 2 + SIZE / 2) * Math.signum(c.ySpeed);
			c.ySpeed = 0;
			// 上にいた場合接地on
			if (c.yPosition <= yPosition) {
				c.ground = true;
			}
		}
		return x;
	}

	// 描画
	public void draw(Graphics g) {
		g.drawImage(img, (int) (xPosition - width / 2), (int) (yPosition - height / 2),
				(int) width, (int) height, this);
	}

}