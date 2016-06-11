package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * 画面上にテキストを描画する際に使用するクラス。draw時に毎回setcolorを行っているので、他でsetcolorを行っても、その色のままになることを防いでいる
 * @author kitahara
 *
 */
public class Text extends JPanel {
	private int xpos, ypos;
	private String txt;
	private Font fn;
	private Color col;

	// 座標、文字列、フォント
	public Text(int x, int y, String t, Font f, Color c) {
		col = c;
		xpos = x;
		ypos = y;
		txt = t;
		fn = f;
	}

	// 文字列変更
	public void setText(String t) {
		txt = t;
	}

	// 描画
	public void draw(Graphics g) {
		g.setColor(col);
		g.setFont(fn);
		g.drawString(txt, xpos, ypos);
	}
}
