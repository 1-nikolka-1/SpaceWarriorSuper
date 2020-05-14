package space.kur.spacewarriorsuper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGameWindow_Lose extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game_window_lose);
        Log.i("intent","end game window_lose");
        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button button_end_1=findViewById(R.id.button_end_1);
        button_end_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent=new Intent( EndGameWindow_Lose.this,GameLevels.class);
                    startActivity(intent);finish();
                }
                catch (Exception e){
                    Log.i("rerewqe","erooooor");}
            }
        });}
}

