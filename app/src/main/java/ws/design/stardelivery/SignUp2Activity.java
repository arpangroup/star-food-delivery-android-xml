package ws.design.stardelivery;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp2Activity extends AppCompatActivity {

    LinearLayout checkbox_linear;
    ImageView tick;
    boolean isSelected = true;

    EditText mobile_no, name_et, email_et, password_et;
    ImageView password_show, password_hide;
    FrameLayout frame_eye;
    TextView btn;
    private int passwordNotVisible = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        checkbox_linear = findViewById(R.id.checkbox_linear);
        tick = findViewById(R.id.tick);

        checkbox_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isSelected == true) {
                    tick.setVisibility(View.VISIBLE);
                    isSelected = false;
                } else if (isSelected == false) {
                    tick.setVisibility(View.GONE);
                    isSelected = true;
                }
            }
        });

        mobile_no = findViewById(R.id.mobile_no);
        name_et = findViewById(R.id.name_et);
        email_et = findViewById(R.id.email_et);
        password_et = findViewById(R.id.password_et);
        frame_eye = (FrameLayout) findViewById(R.id.frame_eye);
        password_show = (ImageView) findViewById(R.id.password_show);
        password_hide = (ImageView) findViewById(R.id.password_hide);
        btn = (TextView) findViewById(R.id.btn);

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


        mobile_no.addTextChangedListener(change);
        name_et.addTextChangedListener(change);
        email_et.addTextChangedListener(change);
        password_et.addTextChangedListener(change);
    }

    TextWatcher change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String mobile = mobile_no.getText().toString().trim();
            String name = name_et.getText().toString().trim();
            String email = email_et.getText().toString().trim();
            String pass = password_et.getText().toString().trim();
            if (!mobile.isEmpty() && !name.isEmpty() && !email.isEmpty() && !pass.isEmpty()) {
                btn.setEnabled(true);
                btn.setBackgroundColor(Color.parseColor("#60b243"));
                findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getBaseContext(), OTPActivity.class);
                        startActivity(i);
                    }
                });

            } else {
                btn.setEnabled(true);
                btn.setBackgroundColor(Color.parseColor("#bdc0c6"));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}