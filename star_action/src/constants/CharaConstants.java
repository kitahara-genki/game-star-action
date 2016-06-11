package constants;
/**
 * キャラクターやブロックに関する定数を定義
 * @author kitahara
 *
 */
public class CharaConstants {

	// ブロック
	public static final int BLOCK_NOMAL			=	1;
	public static final int BLOCK_HARD			=	2;
	public static final int BLOCK_CLEAR			=	3;
	public static final int BLOCK_FAKE_HARD		=	4;
	public static final int GOAL				=	5;
	public static final int BLOCK_FAKE_NOMAL	=	6;


	// トゲ
	public static final int NEEDLE_RIGHT		=	20;
	public static final int NEEDLE_LEFT			=	21;
	public static final int NEEDLE_UP			=	22;
	public static final int NEEDLE_DOWN			=	23;
	public static final int NEEDLE_BLOCK_RIGHT	=	24;
	public static final int NEEDLE_BLOCK_LEFT	=	25;
	public static final int NEEDLE_BLOCK_UP		=	26;
	public static final int NEEDLE_BLOCK_DOWN	=	27;


	// 敵
	public static final int ENEMY_SLIME			=	100;
	public static final int ENEMY_GHOST			=	101;
	public static final int ENEMY_SHOT			=	102;
	public static final int ENEMY_WALK			=	103;
	public static final int ENEMY_JUMP			=	104;
	public static final int ENEMY_MOVE			=	105;
	public static final int ENEMY_KING1			=	106;
	public static final int ENEMY_KING2			=	107;

	// 看板
	public static final int SIGNBOARD_1			=	200;
	public static final int SIGNBOARD_2			=	201;
	public static final int SIGNBOARD_3			=	202;
	public static final int SIGNBOARD_4			=	203;
	public static final int SIGNBOARD_5			=	204;
	public static final int SIGNBOARD_6			=	205;

	// ボス1の状態
	public static final int BOSS1_STATE_1		=	1;
	public static final int BOSS1_STATE_2		=	2;
	public static final int BOSS1_STATE_3		=	3;

	// ボス2の状態
	public static final int BOSS2_STATE_1		=	1;
	public static final int BOSS2_STATE_2		=	2;
	public static final int BOSS2_STATE_3		=	3;
	public static final int BOSS2_STATE_4		=	4;
	public static final int BOSS2_STATE_5		=	5;


	// 左クリックによる設置を行うときのオブジェクト
	public static final int PLACEMENT_BLOCK		=	0;
	public static final int PLACEMENT_SLIME		=	1;
	public static final int PLACEMENT_GHOST		=	2;


	// マップ上に配置できる各オブジェクトの上限
	public static final int PLACE_BLOCK_MAX		= 	200;
	public static final int PLACE_ENEMY_MAX		= 	50;
	public static final int PLACE_NEEDLE_MAX	= 	100;
	public static final int PLACE_SHOT_MAX		= 	100;
	
	private CharaConstants(){
	}
}
