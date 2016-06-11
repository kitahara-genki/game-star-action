package resource;

import static constants.ImageConstants.*;
import static constants.SoundCnstants.*;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import star_action.ViewPanel;
/**
 * 画像データ、サウンドデータを読み込むクラスです
 *
 * @author kitahara
 *
 */
public class ReferenceItems extends Thread{
	// 画像データ用変数
	private Image[] enemyImage;
	private Image[] blockImage;
	private Image needleImage;
	private Image playerCharaImage;
	private Image[] textImage;
	private Image openingImage;
	private Image endingImage;
	private Image[] signboardImage;
	private Image gameoverImage;
	private Image clickBoxImage;

	// 効果音データ用変数
	private URL[] soundSe;
	private Clip[] clip;
	private AudioInputStream[] audioInputStream;
	private AudioFormat[] audioFormat;
	private DataLine.Info[] info;
	private MediaTracker tracker = new MediaTracker(ViewPanel.getViewPanel());

	// シングルトン用
	private static ReferenceItems referenceItems = null;

	private ReferenceItems(){}

	public void run(){
		try {
			Load();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void Load() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		int count = 0;
		enemyImage = new Image[IMAGE_ENEMY_MAX];
		blockImage = new Image[IMAGE_BLOCK_MAX];
		textImage = new Image[IMAGE_TEXT_MAX];
		signboardImage = new Image[IMAGE_SIGNBOARD_MAX];
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		enemyImage[IMAGE_ENEMY_SLIME] = toolkit.createImage(getImageProducer("res/image/enemySlime.png"));
		enemyImage[IMAGE_ENEMY_GHOST] = toolkit.createImage(getImageProducer("res/image/enemyGhost.png"));
		enemyImage[IMAGE_ENEMY_KING] = toolkit.createImage(getImageProducer("res/image/boss.png"));
		enemyImage[IMAGE_ENEMY_WALK] = toolkit.createImage(getImageProducer("res/image/enemyWalk.png"));
		enemyImage[IMAGE_ENEMY_SHOT] = toolkit.createImage(getImageProducer("res/image/enemyShot.png"));
		enemyImage[IMAGE_ENEMY_MOVE] = toolkit.createImage(getImageProducer("res/image/enemyJump.png"));
		enemyImage[IMAGE_ENEMY_BULLET] = toolkit.createImage(getImageProducer("res/image/bullet0.png"));

		blockImage[IMAGE_BLOCK_HARD] = toolkit.createImage(getImageProducer("res/image/hardBlock.png"));
		blockImage[IMAGE_BLOCK_NOMAL] = toolkit.createImage(getImageProducer("res/image/block.png"));
		blockImage[IMAGE_BLOCK_GOAL] = toolkit.createImage(getImageProducer("res/image/goal.png"));
		blockImage[IMAGE_BLOCK_FLOORCLEAR] = toolkit.createImage(getImageProducer("res/image/worldClearBlock.png"));

		textImage[IMAGE_TEXT_WORLD1] = toolkit.createImage(getImageProducer("res/image/textWorld1.png"));
		textImage[IMAGE_TEXT_CLEAR] = toolkit.createImage(getImageProducer("res/image/textClear.png"));

		signboardImage[IMAGE_SIGNBOARD_1] = toolkit.createImage(getImageProducer("res/image/signboard1.png"));
		signboardImage[IMAGE_SIGNBOARD_2] = toolkit.createImage(getImageProducer("res/image/signboard2.png"));
		signboardImage[IMAGE_SIGNBOARD_3] = toolkit.createImage(getImageProducer("res/image/signboard3.png"));
		signboardImage[IMAGE_SIGNBOARD_4] = toolkit.createImage(getImageProducer("res/image/signboard4.png"));
		signboardImage[IMAGE_SIGNBOARD_5] = toolkit.createImage(getImageProducer("res/image/signboard5.png"));

		needleImage = toolkit.createImage(getImageProducer("res/image/needle.png"));
		playerCharaImage = toolkit.createImage(getImageProducer("res/image/playerChara.png"));

		openingImage = toolkit.createImage(getImageProducer("res/image/title.png"));
		endingImage = toolkit.createImage(getImageProducer("res/image/ending.png"));
		gameoverImage = toolkit.createImage(getImageProducer("res/image/gameover.png"));

		clickBoxImage = toolkit.createImage(getImageProducer("res/image/clickBox.png"));

		soundSe = new URL[SOUND_SE_MAX];
		clip = new Clip[SOUND_SE_MAX];
		audioInputStream = new AudioInputStream[SOUND_SE_MAX];
		audioFormat = new AudioFormat[SOUND_SE_MAX];
		info = new DataLine.Info[SOUND_SE_MAX];

		soundSe[SOUND_SE_SHOT] = getFileURL("res/sound/shoot.wav");
		soundSe[SOUND_SE_SURPRISE] = getFileURL("res/sound/surprise.wav");
		soundSe[SOUND_SE_TREAD] = getFileURL("res/sound/tread.wav");
		for (int i = 0; i < SOUND_SE_MAX; i++) {

			audioInputStream[i] = AudioSystem.getAudioInputStream(soundSe[i]);
			audioFormat[i] = audioInputStream[i].getFormat();
			info[i] = new DataLine.Info(Clip.class, audioFormat[i]);
			clip[i] = (Clip) AudioSystem.getLine(info[i]);
			clip[i].open(audioInputStream[i]);
		}
		// メディアトラッカーに追加
		for(Image image : enemyImage){
			tracker.addImage(image, count);
			count++;
		}
		for(Image image : blockImage){
			tracker.addImage(image, count);
			count++;
		}
		for(Image image : signboardImage){
			tracker.addImage(image, count);
			count++;
		}
		for(Image image : enemyImage){
			tracker.addImage(image, count);
			count++;
		}
		tracker.addImage(needleImage, count++);
		tracker.addImage(playerCharaImage, count++);
		tracker.addImage(openingImage, count++);
		tracker.addImage(endingImage, count++);
		tracker.addImage(gameoverImage, count++);
		tracker.addImage(clickBoxImage, count++);
		try {
			  tracker.waitForAll();
			} catch (InterruptedException e) {
			}
	}

	public Image getEnemyImage(int i) {
		return enemyImage[i];
	}

	public Image getBlockImage(int i) {
		return blockImage[i];
	}

	public Image getNeedleImage() {
		return needleImage;
	}

	public Image getPlayerCharaImage() {
		return playerCharaImage;
	}

	public Image getTexteImage(int i) {
		return textImage[i];
	}

	public Image getOpeningImage() {
		return openingImage;
	}

	public Image getEndingImage() {
		return endingImage;
	}

	public Image getGameoverImage() {
		return gameoverImage;
	}

	public Image getSignboardImage(int i) {
		return signboardImage[i];
	}

	public Image getClickBoxImage() {
		return clickBoxImage;
	}

	public URL getSoundSe(int i) {
		return soundSe[i];
	}

	public Clip getClip(int i) {
		return clip[i];
	}

	public static ReferenceItems getReferenceItems(){
		if(referenceItems == null){
			referenceItems = new ReferenceItems();
		}
		return referenceItems;
	}

	public ImageProducer getImageProducer(String pass){
		//star_action/bin フォルダを起点として探す
		ClassLoader classLoader = getClass().getClassLoader();

		try {
			URL url = classLoader.getResource(pass);
			return ((ImageProducer)url.getContent());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public AudioFormat getInputStreamProducer(String pass){
		//star_action/bin フォルダを起点として探す
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			URL url = classLoader.getResource(pass);
			return (AudioFormat) (url.getContent());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public URL getFileURL(String pass){
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(pass);
		return url;

	}

}
