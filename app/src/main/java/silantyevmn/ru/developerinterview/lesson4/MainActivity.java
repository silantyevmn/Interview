package silantyevmn.ru.developerinterview.lesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import silantyevmn.ru.developerinterview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment myFrag = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, myFrag).commit();
    }
}
