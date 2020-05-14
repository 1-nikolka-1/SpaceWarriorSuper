package space.kur.spacewarriorsuper;

//import towe.def.GameView.GameThread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameViewLevel2 extends SurfaceView implements Runnable
{
    public static boolean endd(){
    return lose2;
}
    /**Объект класса GameLoopThread*/
    private GameThread mThread;
    public int shotX;
    public int shotY;

    private boolean backgra=true;
    /**Переменная запускающая поток рисования*/
    private boolean running = false;

    private static boolean lose2=false;
    private List<Bullet2> bullet = new ArrayList<Bullet2>();
    private List<BulletLeft> bulletleft = new ArrayList<BulletLeft>();
    private List<BulletRecht> bulletrecht = new ArrayList<BulletRecht>();
    private List<Backgraund> backgraund = new ArrayList<Backgraund>();
    Bitmap enemies;
    Bitmap backgraunddd;
    private Thread thred = new Thread(this);

    //-------------Start of GameThread--------------------------------------------------\\

    public class GameThread extends Thread
    {
        /**Объект класса*/
        private GameViewLevel2 view;

        /**Конструктор класса*/
        public GameThread(GameViewLevel2 view)
        {
            this.view = view;
        }

        /**Задание состояния потока*/
        public void setRunning(boolean run)
        {
            running = run;
        }

        /** Действия, выполняемые в потоке */
        public void run()
        {
            while (running)
            {
                Canvas canvas = null;
                try
                {
                    // подготовка Canvas-а
                    canvas = view.getHolder().lockCanvas();

                    synchronized (view.getHolder())
                    {
                        // собственно рисование
                        onDraww(canvas);

                    }
                }
                catch (Exception e) { }
                finally
                {
                    if (canvas != null)
                    {
                        view.getHolder().unlockCanvasAndPost(canvas);
                    }
                }
                testCollision();
            }
        }
    }

    //-------------End of GameThread--------------------------------------------------\\

    public GameViewLevel2(Context context, AttributeSet attributeSet)
    {

        super(context,attributeSet);
        lose2=false;
        Log.i("rerewqe","go");
        mThread = new GameThread(this);
        enemies = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        backgraunddd = BitmapFactory.decodeResource(getResources(), R.drawable.main_background_2);
        backgraund.add(new Backgraund(this,backgraunddd));
        runTimer();
        /*Рисуем все наши объекты и все все все*/
        getHolder().addCallback(new SurfaceHolder.Callback()
        {
            /*** Уничтожение области рисования */
            public void surfaceDestroyed(SurfaceHolder holder)
            {
                boolean retry = true;
                mThread.setRunning(false);
                while (retry)
                {
                    try
                    {
                        // ожидание завершение потока
                        mThread.join();
                        retry = false;
                    }
                    catch (InterruptedException e) { }
                }
            }

            /** Создание области рисования */
            public void surfaceCreated(SurfaceHolder holder)
            {
                mThread.setRunning(true);
                mThread.start();

            }

            /** Изменение области рисования */
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
            {
            }
        });
    }

    /**Функция рисующая все спрайты и фон*/
    protected void onDraww(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        Iterator<Bullet2> i = bullet.iterator();
        Iterator<BulletLeft> ii = bulletleft.iterator();
        Iterator<BulletRecht> iii = bulletrecht.iterator();
        Iterator<Backgraund> iiii = backgraund.iterator();
        if(backgra=true){
            Backgraund eeee = iiii.next();
            eeee.onDrawbackraund(canvas);
            backgra=false;}
        while(i.hasNext()) {
            Bullet2 e = i.next();
            BulletLeft ee = ii.next();
            BulletRecht eee = iii.next();
            if(e.y <= 10000 ) {//|| e.y <= 1000
                e.onDraw(canvas);

                ee.onDrawLeft(canvas);
                eee.onDrawRecht(canvas);
            } else {
                i.remove();
                ii.remove();
                iii.remove();
            }
        }
    }

    private void runTimer(){
        final Handler handler=new Handler();
        handler.post(new Runnable() {private GameViewLevel2 view;
            @Override
            public void run() {

                bullet.add(new Bullet2(view, enemies));
                bulletleft.add(new BulletLeft(view, enemies));
                bulletrecht.add(new BulletRecht(view, enemies));
                handler.postDelayed(this,GameLevels.xx);

            }
        });
    }
    public void run() {}
    private void testCollision(){
        ImageView mImageView = (ImageView) findViewById(R.id.imageView2);
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(180, 180);
        Iterator<Bullet2> i = bullet.iterator();
        Iterator<BulletLeft> ii = bulletleft.iterator();
        Iterator<BulletRecht> iii = bulletrecht.iterator();
        while (i.hasNext()){
            Bullet2 bullet=i.next();
            BulletLeft bulletleft=ii.next();
            BulletRecht bulletrecht=iii.next();
        if((Level2.xRock()+180>bullet.x+bullet.width&& Level2.xRock()<bullet.x+bullet.width&&
           Level2.yRock()+180>bullet.y+bullet.height&&Level2.yRock()-50<bullet.y+bullet.height)||
           (Level2.xRock()+180>bulletleft.x+bulletleft.width&& Level2.xRock()<bulletleft.x+bulletleft.width&&
           Level2.yRock()+180>bulletleft.y+bulletleft.height&&Level2.yRock()-50<bulletleft.y+bulletleft.height)||
           (Level2.xRock()+180>bulletrecht.x+bulletrecht.width&& Level2.xRock()<bulletrecht.x+bulletrecht.width&&
           Level2.yRock()+180>bulletrecht.y+bulletrecht.height&&Level2.yRock()-50<bulletrecht.y+bulletrecht.height)){
            i.remove();
            ii.remove();
            iii.remove();
            lose2=true;

        }
        }

    }

}