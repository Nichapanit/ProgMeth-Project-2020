package gamePart;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import model.CHARACTER;

import view.GameController;
public class Player1 {
	private int offsetX;
	private int offsetY;

	private int translateX;
	private int translateY;
	private static final int WIDTH = 64;
	private static final int HEIGHT = 64;

	public static final int FRONT = 0;
	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int BACK = 3;
	// private ImageView playerImageView;
	private WritableImage img;
	private Image image;


	public Player1(CHARACTER playerUrl) {
		this.offsetX = 0;
		this.offsetY = 0;
		image = new Image(playerUrl.getCharacterUrl());
		// playerImageView = new ImageView(image);
		// setPlayerImageViewPort();
		img = new WritableImage(image.getPixelReader(), offsetX, offsetY, 64, 64);

		setTranslateX(0);
		setTranslateY(0);

	}

//	public void setPlayerImageViewPort() {
//		playerImageView.setViewport(new Rectangle2D(offsetX,offsetY,WIDTH,HEIGHT));
//	}

	public void setOffsetX(int x) {
		this.offsetX = x;
	}

	public void setoffsetY(int y) {
		this.offsetY = y;
	}

	public WritableImage getWritableImage(int index) {
		return new WritableImage(image.getPixelReader(), offsetX, index*64, 64, 64);
	}

	public int getTranslateX() {
		return translateX;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public void setTranslateX(int translateX) {
		this.translateX = translateX;
	}

	public int getTranslateY() {
		return translateY;
	}

	public void setTranslateY(int translateY) {
		this.translateY = translateY;
	}

//	public void drawSprite(GraphicsContext gc,int x,int y) {
//		int index;
//		setTranslateX(x);
//		setTranslateY(y);
//		WritableImage img = new WritableImage(image.getPixelReader(),index*64,0,64,64);
//		gc.drawImage(img, translateX, translateY);
//	}


//	@Override
//	public int getSprite() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
