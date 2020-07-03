package ws.design.stardelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginScreenActivity extends AppCompatActivity {

    EditText password_et;
    ImageView password_show, password_hide;
    FrameLayout frame_eye;
    private int passwordNotVisible = 1;
    Button btn;
    TextView skip;
    LinearLayout create_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),HomePageNavigationActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),HomePageNavigationActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.create_txt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),SignUp2Activity.class);
                startActivity(i);
            }
        });
        password_et = (EditText) findViewById(R.id.password_et);

        password_show = (ImageView) findViewById(R.id.password_show);
        password_hide = (ImageView) findViewById(R.id.password_hide);

        frame_eye = (FrameLayout) findViewById(R.id.frame_eye);

        frame_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordNotVisible == 1) {
                    password_show.setVisibility(View.VISIBLE);
                    password_hide.setVisibility(View.GONE);
                    password_et.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible = 0;

                } else {
                    password_show.setVisibility(View.GONE);
                    password_hide.setVisibility(View.VISIBLE);
                    password_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 1;

                }
                password_et.setSelection(password_et.length());
            }
        });
    }
}
