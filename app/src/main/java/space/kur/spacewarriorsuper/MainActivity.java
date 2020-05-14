package space.kur.spacewarriorsuper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    public static boolean lang=true;//true=en

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("intent","main");
        startService(new Intent(this, MyService.class));
        Button buttonL = (Button) findViewById(R.id.buttonL);
        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        loadLang();
        if( MainActivity.lang==true){
            buttonL.setText(getString(R.string.en));
            buttonStart.setText(getString(R.string.start_en));
            lang=true;
        }
        else{
            buttonL.setText(getString(R.string.ru));
            buttonStart.setText(getString(R.string.start_ru));
            lang=false;
        }
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent=new Intent( MainActivity.this,GameLevels.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){}
            }
        });
        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    //системная назад начало
    @Override
    public void onBackPressed() {

        if(backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            //finish();
            //return;
            finishAffinity();
            System.exit(0);}
        else{
            backToast=Toast.makeText(getBaseContext(),"Нажмите ещё раз,чтобы выйти",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }
    //системная назад конец
    //смена языка начало
    public void onMyButtonClick(View view) {
        Button buttonL = (Button) findViewById(R.id.buttonL);
        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        if(MainActivity.lang==false){
            buttonL.setText(getString(R.string.en));
            buttonStart.setText(getString(R.string.start_en));
            lang=true;
            }
        else{
            buttonL.setText(getString(R.string.ru));
            buttonStart.setText(getString(R.string.start_ru));
            lang=false;
        }
    }
    //смена языка конец
    //сохранение языка начало
    void saveLang(){
        SharedPreferences savelang = getPreferences(MODE_PRIVATE);
        Editor ed = savelang.edit();
        ed.putBoolean("SAVED_LANG", lang);
        ed.commit();

    }
    void loadLang(){
        SharedPreferences savelang = getPreferences(MODE_PRIVATE);
        lang =savelang.getBoolean("SAVED_LANG",true);
    }
    protected void onPause(){
        saveLang();
        super.onPause();
        stopService(new Intent(this, MyService.class));
    }
    //сохранение языка конец
    protected void onResume() {
        super.onResume();
        startService(new Intent(this, MyService.class));
    }
}
