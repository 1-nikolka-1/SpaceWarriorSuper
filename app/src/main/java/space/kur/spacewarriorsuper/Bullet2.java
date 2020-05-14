package space.kur.spacewarriorsuper;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bullet2
{
    /**Х и У коорданаты*/
    public int x;
    public int y;
    /**Скорость*/
    public static int speed;
    /**Выосота и ширина спрайта*/
    public int width;
    public int height;

    public GameViewLevel2 gameView;
    public Bitmap bmp2;

    /**Конструктор класса*/
    public Bullet2(GameViewLevel2 gameView, Bitmap bmp2){
        this.gameView = gameView;
        this.bmp2 = bmp2;
        this.x = 500;
        this.y = 0;
        this.speed = 45;

        this.width = 20;
        this.height = 20;
    }
    public void update(){
        y += speed;
    }
    public void onDraw(Canvas c){
        update();
        c.drawBitmap(bmp2, x, y, null);
    }

}