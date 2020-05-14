package space.kur.spacewarriorsuper;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BulletRecht
{
    /**Х и У коорданаты*/
    public int x;
    public int y;
    /**Скорость*/
    public static int speedx;
    public static int speedy;
    /**Выосота и ширина спрайта*/
    public int width;
    public int height;

    public GameViewLevel1 gameView1;
    public GameViewLevel2 gameView2;
    public Bitmap bmp;

    /**Конструктор класса*/
    public BulletRecht(GameViewLevel1 gameView1, Bitmap bmp){
        this.gameView1= gameView1;
        this.bmp = bmp;
        this.x = 500;
        this.y = 0;
        this.speedy = 15;
        this.speedx = 5;
        this.width = 20;
        this.height = 20;
    }
    public BulletRecht(GameViewLevel2 gameView2, Bitmap bmp){
        this.gameView2= gameView2;
        this.bmp = bmp;
        this.x = 500;
        this.y = 0;
        this.speedy = 15;
        this.speedx = 5;
        this.width = 20;
        this.height = 20;
    }
    public void update(){
        y += speedy;
        x+=speedx;
    }
    public void onDrawRecht(Canvas c){
        update();
        c.drawBitmap(bmp, x, y, null);
    }

}