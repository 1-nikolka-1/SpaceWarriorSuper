package space.kur.spacewarriorsuper;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Backgraund
{
    /**Х и У коорданаты*/
    public int x;
    public int y;
    /**Скорость*/
    public static int speed;
    /**Выосота и ширина спрайта*/
    public int width;
    public int height;

    public GameViewLevel1 gameView1;
    public GameViewLevel2 gameView2;
    public Bitmap bmp;

    /**Конструктор класса*/
    public Backgraund(GameViewLevel1 gameView1, Bitmap bmp){
        this.gameView1 = gameView1;
        this.bmp = bmp;
    }
    public Backgraund(GameViewLevel2 gameView2, Bitmap bmp){
        this.gameView2 = gameView2;
        this.bmp = bmp;
    }
    public void onDrawbackraund(Canvas c){
        c.drawBitmap(bmp, 0, 0, null);
    }

}