import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;


public class Coin implements Entity, ImageObserver {

	private int xCoord, yCoord;
	private int coinHeight, coinWidth;
	BufferedImage coin = null;

	public Coin()
	{
		try {
			coin = ImageIO.read(getClass().getResourceAsStream("Coin.png"));
		}
		catch (IOException ex)
		{
			System.out.println("IOException");
		}
		coinHeight = coin.getHeight();
		coinWidth = coin.getWidth();
		yCoord = -coinHeight;
	}
	public void dropAsteroid(){
		move(xCoord, yCoord+1);
	}
	@Override
	public int getX()
	{
		return xCoord;
	}
	@Override 
	public int getY()
	{
		return yCoord;
	}
	@Override
	public void move(int x, int y)
	{
		xCoord = x;
		yCoord = y;

	}
	@Override
	public int getEntityWidth() {
		return coinWidth;
	}


	@Override
	public int getEntityHeight() {
		return coinHeight;
	}
	@Override
	public boolean isInside(int x, int y) {
		int xCenter = xCoord+(coinWidth/2);
		int yCenter = yCoord+(coinHeight/2);
		double distance = (Math.sqrt(((x-xCenter)*(x-xCenter))+((y-yCenter)*(y-yCenter))));
		int radius = coinWidth / 2;
		return (distance < radius);
	}
	@Override
	public void draw(Graphics g, int x, int y) {
		x = xCoord;
		y = yCoord;
		g.drawImage(coin, x, y, this);
	}
	//unused
	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y,
			int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
