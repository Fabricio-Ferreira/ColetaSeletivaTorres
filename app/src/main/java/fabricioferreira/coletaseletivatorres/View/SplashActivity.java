package fabricioferreira.coletaseletivatorres.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import fabricioferreira.coletaseletivatorres.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    chamaMain();
                }
            }
        };

        timer.start();
    }
    void chamaMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

