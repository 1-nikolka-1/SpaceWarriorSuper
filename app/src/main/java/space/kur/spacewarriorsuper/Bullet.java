package space.kur.spacewarriorsuper;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bullet
{
    /**Х и У коорданаты*/
    public int x;
    public int y;
    /**Скорость*/
    public static int speed;
    /**Выосота и ширина спрайта*/
    public int width;
    public int height;

    public GameViewLevel1 gameView;
    public Bitmap bmp;

    /**Конструктор класса*/
    public Bullet(GameViewLevel1 gameView, Bitmap bmp){
        this.gameView = gameView;
        this.bmp = bmp;
        this.x = 500;
        this.y = 0;
        this.speed = 15;

        this.width = 20;
        this.height = 20;
    }

    public void update(){
        y += speed;
    }
    public void onDraw(Canvas c){
        update();
        c.drawBitmap(bmp, x, y, null);
    }

}