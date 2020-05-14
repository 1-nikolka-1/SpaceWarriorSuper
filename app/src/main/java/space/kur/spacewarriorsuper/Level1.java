package space.kur.spacewarriorsuper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Level1 extends AppCompatActivity implements View.OnTouchListener {
    //копировать
    public boolean winn1=false;
    public static int xRock;
    public static int yRock;
    private long backPressedTime;
    private Toast backToast;
    private ImageView mImageView;
    private ImageView enemy;
    private ImageView gun1_1;
    private ImageView gun1_2;
    private ImageView gun1_3;
    private ImageView gun1_4;
    private ImageView gun1_5;
    private ImageView gun1_6;
    private ProgressBar pb1;
    private ViewGroup mMoveLayout;
    private int _xDelta;
    private int _yDelta;
    private long secondall=0;
    private int second=0;
    private int second2=6;
    private int mX;
    private int mY;
    boolean enddddddd=true;
    public int width;
    public int height;
    private boolean running=true;
    private long time;
    long time1;
    boolean chek1=true;
    boolean chek2=true;
    long time2;
    boolean chek3=true;
    long time3;
    boolean chek4=true;
    long time4;
    boolean chek5=true;
    long time5;
    boolean chek6=true;
    long time6;
    int progr;
    int timeinfle1=0;
    int timeinfle2=0;
    int timeinfle3=0;
    int timeinfle4=0;
    int timeinfle5=0;
    int timeinfle6=0;
    float value6;
    Dialog dialog;
    void end(){dialog.dismiss();}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        winn1=false;
        GameViewLevel1.setRunningLevel1(true);
        GameViewLevel1.endd();
        setContentView(R.layout.universal);
        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        runTimer();
        GameViewLevel1 gm1 =findViewById(R.id.gameViewLevel1);
        gm1.setVisibility(View.VISIBLE);
        Display display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();  // deprecated
        height = display.getHeight();  // deprecated
        gun1_1=(ImageView)findViewById(R.id.gun1_1);
        gun1_2=(ImageView)findViewById(R.id.gun1_2);
        gun1_3=(ImageView)findViewById(R.id.gun1_3);
        gun1_4=(ImageView)findViewById(R.id.gun1_4);
        gun1_5=(ImageView)findViewById(R.id.gun1_5);
        gun1_6=(ImageView)findViewById(R.id.gun1_6);
        mImageView = (ImageView) findViewById(R.id.imageView2);
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(180, 180);
        layoutParams.leftMargin=width/2-90;
        layoutParams.topMargin=(int)((float)height/1.3);
        mImageView.setLayoutParams(layoutParams);
        mImageView.setOnTouchListener(this);
        pb1=findViewById(R.id.pb1);
        progr=pb1.getProgress();
        enemy = (ImageView) findViewById(R.id.enemy_classic);
        enemy.setVisibility(View.VISIBLE);
        final RelativeLayout.LayoutParams enemy_layoutParams = new RelativeLayout.LayoutParams(180, 180);
        final RelativeLayout.LayoutParams gun1_1_layoutparams = new RelativeLayout.LayoutParams(25, 65);
        final RelativeLayout.LayoutParams gun1_2_layoutparams = new RelativeLayout.LayoutParams(25, 65);
        final RelativeLayout.LayoutParams gun1_3_layoutparams = new RelativeLayout.LayoutParams(25, 65);
        final RelativeLayout.LayoutParams gun1_4_layoutparams = new RelativeLayout.LayoutParams(25, 65);
        final RelativeLayout.LayoutParams gun1_5_layoutparams = new RelativeLayout.LayoutParams(25, 65);
        final RelativeLayout.LayoutParams gun1_6_layoutparams = new RelativeLayout.LayoutParams(25, 65);
        enemy_layoutParams.leftMargin=width/2-90;
        enemy.setLayoutParams(enemy_layoutParams);
        gun1_1.setLayoutParams(gun1_1_layoutparams);
        xRock=layoutParams.leftMargin;
        yRock=layoutParams.topMargin;

        final Handler h = new Handler();
        final Handler ch = new Handler();
        //анимация пули начало
        h.post( new Runnable() {
            public void run() {
                switch (second){
                    case 1 :/*(/*second!=0&&*//*second==5*//*&&gun1_6.getVisibility()==View.INVISIBLE*//*)*/
                    gun1_2.setVisibility(View.VISIBLE);
                    gun1_2_layoutparams.leftMargin=layoutParams.leftMargin+90;
                    gun1_2_layoutparams.topMargin=layoutParams.topMargin;
                    time2=System.currentTimeMillis();
                    chek2=true;
                    timeinfle2=5000*gun1_2_layoutparams.topMargin/(int)(height*1.3-180);
                    gun1_2.setLayoutParams(gun1_2_layoutparams);
                    //анимация пули1 вверх начало
                    ValueAnimator valueAnimator_gun1_2 = ValueAnimator.ofFloat(0, -height);
                    valueAnimator_gun1_2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {

                            float value2 = (float) animation.getAnimatedValue();

                            gun1_2.setTranslationY(value2);

                        }
                    });
                    valueAnimator_gun1_2.setInterpolator(null);//new LinearInterpolator()
                    valueAnimator_gun1_2.setDuration(5000);//DEFAULT_ANIMATION_DURATION
                    valueAnimator_gun1_2.start();
                    //анимация пули вверх конец

                    case 3:
                    gun1_3.setVisibility(View.VISIBLE);
                    gun1_3_layoutparams.leftMargin=layoutParams.leftMargin+90;
                    gun1_3_layoutparams.topMargin=layoutParams.topMargin;
                    time3=System.currentTimeMillis();
                    chek3=true;
                    timeinfle3=5000*gun1_3_layoutparams.topMargin/(int)(height*1.3-180);
                    gun1_3.setLayoutParams(gun1_3_layoutparams);
                    //анимация пули1 вверх начало
                    ValueAnimator valueAnimator_gun1_3 = ValueAnimator.ofFloat(0, -height);
                    valueAnimator_gun1_3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {

                            float value3 = (float) animation.getAnimatedValue();

                            gun1_3.setTranslationY(value3);
                        }
                    });
                    valueAnimator_gun1_3.setInterpolator(null);//new LinearInterpolator()
                    valueAnimator_gun1_3.setDuration(5000);//DEFAULT_ANIMATION_DURATION
                    valueAnimator_gun1_3.start();
                    //анимация пули вверх конец
                    case 5:
                        gun1_4.setVisibility(View.VISIBLE);
                        gun1_4_layoutparams.leftMargin=layoutParams.leftMargin+90;
                        gun1_4_layoutparams.topMargin=layoutParams.topMargin;
                        time4=System.currentTimeMillis();
                        chek4=true;
                        timeinfle4=5000*gun1_4_layoutparams.topMargin/(int)(height*1.3-180);
                        gun1_4.setLayoutParams(gun1_4_layoutparams);
                        //анимация пули1 вверх начало
                        ValueAnimator valueAnimator_gun1_4 = ValueAnimator.ofFloat(0, -height);
                        valueAnimator_gun1_4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {

                                float value4 = (float) animation.getAnimatedValue();

                                gun1_4.setTranslationY(value4);
                            }
                        });
                        valueAnimator_gun1_4.setInterpolator(null);//new LinearInterpolator()
                        valueAnimator_gun1_4.setDuration(5000);//DEFAULT_ANIMATION_DURATION
                        valueAnimator_gun1_4.start();
                        //анимация пули вверх конец
                }
                h.postDelayed(this, 1000);
            }});
        h.post( new Runnable() {
            public void run() {
                switch (second2){
                    case 1 :/*(/*second!=0&&*//*second==5*//*&&gun1_6.getVisibility()==View.INVISIBLE*//*)*/
                        gun1_1.setVisibility(View.VISIBLE);
                        gun1_1_layoutparams.leftMargin=layoutParams.leftMargin+90;
                        gun1_1_layoutparams.topMargin=layoutParams.topMargin;
                        time1=System.currentTimeMillis();
                        chek1=true;
                        timeinfle1=5000*gun1_1_layoutparams.topMargin/(int)(height*1.3-180);
                        gun1_1.setLayoutParams(gun1_1_layoutparams);
                        //анимация пули1 вверх начало
                        ValueAnimator valueAnimator_gun1_1 = ValueAnimator.ofFloat(0, -height);
                        valueAnimator_gun1_1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {

                                float value1 = (float) animation.getAnimatedValue();

                                gun1_1.setTranslationY(value1);
                            }
                        });
                        valueAnimator_gun1_1.setInterpolator(null);//new LinearInterpolator()
                        valueAnimator_gun1_1.setDuration(5000);//DEFAULT_ANIMATION_DURATION
                        valueAnimator_gun1_1.start();
                        //анимация пули вверх конец

                    case 3:
                        gun1_5.setVisibility(View.VISIBLE);
                        gun1_5_layoutparams.leftMargin=layoutParams.leftMargin+90;
                        gun1_5_layoutparams.topMargin=layoutParams.topMargin;
                        time5=System.currentTimeMillis();
                        chek5=true;
                        timeinfle5=5000*gun1_5_layoutparams.topMargin/(int)(height*1.3-180);
                        gun1_5.setLayoutParams(gun1_5_layoutparams);
                        //анимация пули1 вверх начало
                        ValueAnimator valueAnimator_gun1_5 = ValueAnimator.ofFloat(0, -height);
                        valueAnimator_gun1_5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {

                                float value5 = (float) animation.getAnimatedValue();

                                gun1_5.setTranslationY(value5);
                            }
                        });
                        valueAnimator_gun1_5.setInterpolator(null);//new LinearInterpolator()
                        valueAnimator_gun1_5.setDuration(5000);//DEFAULT_ANIMATION_DURATION
                        valueAnimator_gun1_5.start();
                        //анимация пули вверх конец
                    case 5:
                        gun1_6.setVisibility(View.VISIBLE);
                        gun1_6_layoutparams.leftMargin=layoutParams.leftMargin+90;
                        gun1_6_layoutparams.topMargin=layoutParams.topMargin;
                        time6=System.currentTimeMillis();
                        chek6=true;
                        timeinfle6=5000*gun1_6_layoutparams.topMargin/(int)(height*1.3-180);
                        gun1_6.setLayoutParams(gun1_6_layoutparams);
                        //анимация пули1 вверх начало
                        ValueAnimator valueAnimator_gun1_6 = ValueAnimator.ofFloat(0, -height);
                        valueAnimator_gun1_6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {

                                value6 = (float) animation.getAnimatedValue();
//float
                                gun1_6.setTranslationY(value6);
                            }
                        });
                        valueAnimator_gun1_6.setInterpolator(null);//new LinearInterpolator()
                        valueAnimator_gun1_6.setDuration(5000);//DEFAULT_ANIMATION_DURATION
                        valueAnimator_gun1_6.start();
                        //анимация пули вверх конец
                }
                h.postDelayed(this, 1000);
            }});
        //анимация пули конец
        //попадание начало
        ch.post(new Runnable() {
            @Override
            public void run() {
                if(GameViewLevel1.endd()==true && winn1==false){
                    qwew();
                }

                time=System.currentTimeMillis();
                if ((gun1_1_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_1_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time1>timeinfle1&& chek1)||
                    (gun1_2_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_2_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time2>timeinfle2&& chek2)||
                    (gun1_3_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_3_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time3>timeinfle3&& chek3)||
                    (gun1_4_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_4_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time4>timeinfle4&& chek4)||
                    (gun1_5_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_5_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time5>timeinfle5&& chek5)||
                    (gun1_6_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_6_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time6>timeinfle6&& chek6)){
                    progr--;
                    pb1.setProgress(progr);
                    if (gun1_1_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_1_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time1>timeinfle1&& chek1){
                        gun1_1.setVisibility(View.INVISIBLE);
                    }
                    if((gun1_2_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_2_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time2>timeinfle2&& chek2)){
                        gun1_2.setVisibility(View.INVISIBLE);}
                    if((gun1_3_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_3_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time3>timeinfle3&& chek3)){
                        gun1_3.setVisibility(View.INVISIBLE);}
                    if((gun1_4_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_4_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time2>timeinfle4&& chek4)){
                        gun1_4.setVisibility(View.INVISIBLE);}
                    if((gun1_5_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_5_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time5>timeinfle5&& chek5)){
                        gun1_5.setVisibility(View.INVISIBLE);}
                    if((gun1_6_layoutparams.leftMargin>=enemy_layoutParams.leftMargin&& gun1_6_layoutparams.leftMargin<=enemy_layoutParams.leftMargin+180&& time-time6>timeinfle6&& chek6)){
                        gun1_6.setVisibility(View.INVISIBLE);}
                    if(pb1.getProgress()==0 && GameViewLevel1.endd()==false && winn1==false){
                        winn1=true;
                        try{
                            Intent intent=new Intent( Level1.this,EndGameWindow.class);
                            startActivity(intent);finish();//end();
                        }
                        catch (Exception e){
                            Log.i("rerewqe","erooooor");}

                        //переход в класс , где победа
                    }
                        /*GameViewLevel1 gm1 =findViewById(R.id.gameViewLevel1);
                        gm1.setVisibility(View.INVISIBLE);
                        gun1_1.setVisibility(View.INVISIBLE);
                        gun1_2.setVisibility(View.INVISIBLE);
                        gun1_3.setVisibility(View.INVISIBLE);
                        gun1_4.setVisibility(View.INVISIBLE);
                        gun1_5.setVisibility(View.INVISIBLE);
                        gun1_6.setVisibility(View.INVISIBLE);
                        final AlertDialog.Builder end_builder=new AlertDialog.Builder(Level1.this);
                        end_builder.setMessage("YOU WIN")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        try{
                                            Intent intent=new Intent( Level1.this,GameLevels.class);
                                            startActivity(intent);finish();//end();
                                        }
                                        catch (Exception e){}}
                                });
                        AlertDialog alert=end_builder.create();
                        alert.show();
                    }*/
                    if(chek1&& time-time1>timeinfle1){chek1=false;}
                    if(chek2&& time-time2>timeinfle2){chek2=false;}
                    if(chek3&& time-time3>timeinfle3){chek3=false;}
                    if(chek4&& time-time4>timeinfle4){chek4=false;}
                    if(chek5&& time-time5>timeinfle5){chek5=false;}
                    if(chek6&& time-time6>timeinfle6){chek6=false;}

                }ch.postDelayed(this,100);

            }
        });
        //попадание конец
    }
    //копировать
    //системная кнопка назад начало
    @Override
    public void onBackPressed() {

        if(backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            Intent intent=new Intent( Level1.this,GameLevels.class);
            startActivity(intent);finish();
            return;}
        else{
            backToast= Toast.makeText(getBaseContext(),"Нажмите ещё раз,чтобы выйти",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }
    //системная кнопка назад конец
    //перемещение по нажатию начало
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            //ACTION_DOWN срабатывает при прикосновении к экрану,
            //здесь определяется начальное стартовое положение объекта:
            case MotionEvent.ACTION_DOWN:
                mX = X - mImageView.getLeft();
                mY = Y - mImageView.getTop();
                break;


            //ACTION_MOVE обрабатывает случившиеся в процессе прикосновения изменения, здесь
            //содержится информация о последней точке, где находится объект после окончания действия прикосновения ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                if(X-mX>-20&&X-mX<width-130&&Y-mY>0&&Y-mY<height-170){
                layoutParams.leftMargin=X-mX;
                layoutParams.topMargin = Y - mY;
                xRock=layoutParams.leftMargin;
                yRock=layoutParams.topMargin;
                v.setLayoutParams(layoutParams);
                break;}
                else{}
        }
        return true;
    }
    //перемещение по нажатию конец
    //секундомер начало
    private void runTimer(){
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(second==12){second=0;}
                if(second2==12){second2=0;}
                if(running){second++; second2++;secondall++;}
                handler.postDelayed(this,1000);
            }
        });
    }
    //секундомер конец
    public static int xRock(){
        return xRock;
    }
    public static int yRock(){
        return yRock;
    }
    public void qwew(){
        if(enddddddd){
            enddddddd=false;
            winn1=true;
        try{
                    Intent intent=new Intent( Level1.this,EndGameWindow_Lose.class);
                    startActivity(intent);finish();//end();
                }
               catch (Exception e){
                   Log.i("rerewqe","erooooor");}

        //переход в класс , где победа
        }}

//Button button_end_1=findViewById(R.id.button_end_1);
//        button_end_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try{
//                    Intent intent=new Intent( Level1.this,GameLevels.class);
//                    startActivity(intent);finish();
//                }
//                catch (Exception e){
//                    Log.i("rerewqe","erooooor");}
//            }
//        });



     //   gun1_1.setVisibility(View.INVISIBLE);
     //   gun1_2.setVisibility(View.INVISIBLE);
    //    gun1_3.setVisibility(View.INVISIBLE);
    //    gun1_4.setVisibility(View.INVISIBLE);
     //   gun1_5.setVisibility(View.INVISIBLE);
     //   gun1_6.setVisibility(View.INVISIBLE);
     //   running=false;
     //   GameViewLevel1.setRunningLevel1(false);
    //    GameViewLevel1 gm1 =findViewById(R.id.gameViewLevel1);
        //gm1.setVisibility(View.INVISIBLE);
    //final AlertDialog.Builder end_builder=new AlertDialog.Builder(Level1.this);
   //     end_builder.setMessage("YOU LOSE")
   //             .setCancelable(false)
   //             .setPositiveButton("OK", new DialogInterface.OnClickListener() {
     //               @Override
     //               public void onClick(DialogInterface dialogInterface, int i) {
    //                    try{
   //                         GameViewLevel1 gm1 =findViewById(R.id.gameViewLevel1);
   //                         gm1.setVisibility(View.INVISIBLE);
    //                        Intent intent=new Intent( Level1.this,GameLevels.class);
    //                        startActivity(intent);//finish();end();
    //                    }
     //                   catch (Exception e){}}
     //           });
     //   AlertDialog alert=end_builder.create();
     //   alert.show();

}
