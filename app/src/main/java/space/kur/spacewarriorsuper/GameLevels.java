package space.kur.spacewarriorsuper;

import android.content.Intent;
import android.os.Bundle;
//import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
//import android.widget.Chronometer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {
    public static int xx=1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);
        Log.i("intent","game levels");


        Button button_back = (Button) findViewById(R.id.button_back);
        if( MainActivity.lang){
           // buttonL.setText(getString(R.string.en));
            button_back.setText(getString(R.string.back_en));
        }

        else{
            //buttonL.setText(getString(R.string.ru));
            button_back.setText(getString(R.string.back_ru));
        }


        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Button button_back=(Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent=new Intent( GameLevels.this,MainActivity.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){}
            }
        });
        TextView textViewbegin =(TextView)findViewById(R.id.textViewbegin);
        if( MainActivity.lang){
            // buttonL.setText(getString(R.string.en));
            textViewbegin.setText("begin");
        }

        else{
            //buttonL.setText(getString(R.string.ru));
            textViewbegin.setText("начало");
        }
        //переход на begin лвл начало

        textViewbegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent=new Intent(GameLevels.this,LevelBegin.class);
                    startActivity(intent);finish();
                }
                catch(Exception e){}
            }
        });
        //переход на begin лвл конец
        //переход на 1 лвл начало
        TextView textView1 =(TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent1=new Intent(GameLevels.this,Level1.class);
                    startActivity(intent1);finish();
                }
                catch(Exception e){}
            }
        });
        //переход на 1 лвл конец
        //переход на 2 лвл начало
        TextView textView2 =(TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent=new Intent(GameLevels.this,Level2.class);
                    startActivity(intent);finish();
                }
                catch(Exception e){}
            }
        });
        //переход на 2 лвл конец

        //переход на 3 лвл начало
        TextView textView3 =(TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    xx=600;
                    Intent intent=new Intent(GameLevels.this,Level2.class);
                    startActivity(intent);finish();
                }
                catch(Exception e){}
            }
        });
        //переход на 3 лвл конец
    }
    //системная кнопка назад начало
    @Override
    public void onBackPressed(){try{
        Intent intent=new Intent( GameLevels.this,MainActivity.class);
        startActivity(intent);finish();
    }
    catch (Exception e){}}
    //системная кнопка назад конец
}
