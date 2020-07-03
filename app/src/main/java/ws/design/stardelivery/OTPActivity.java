package ws.design.stardelivery;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class OTPActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4;
    private EditText[] editTexts;
    TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),HomePageNavigationActivity.class);
                startActivity(i);
            }
        });
        btn = findViewById(R.id.btn);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);

        editTexts = new EditText[]{et1, et2, et3, et4};

        et1.addTextChangedListener(new PinTextWatcher(0));
        et2.addTextChangedListener(new PinTextWatcher(1));
        et3.addTextChangedListener(new PinTextWatcher(2));
        et4.addTextChangedListener(new PinTextWatcher(3));


        et1.setOnKeyListener(new PinOnKeyListener(0));
        et2.setOnKeyListener(new PinOnKeyListener(1));
        et3.setOnKeyListener(new PinOnKeyListener(2));
        et4.setOnKeyListener(new PinOnKeyListener(3));
    }

    public class PinTextWatcher implements TextWatcher {

        private int currentIndex;
        private boolean isFirst = false, isLast = false;
        private String newTypedString = "";

        PinTextWatcher(int currentIndex) {
            this.currentIndex = currentIndex;

            if (currentIndex == 0)
                this.isFirst = true;
            else if (currentIndex == editTexts.length - 1)
                this.isLast = true;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            newTypedString = s.subSequence(start, start + count).toString().trim();

        }

        @Override
        public void afterTextChanged(Editable s) {

            String text = newTypedString;

            if (!s.toString().isEmpty()) {
                checkABC();
            } else {
                //grey
                btn.setBackgroundColor(getResources().getColor(R.color.silver));
                btn.setText("ENTER OTP");
            }

            /* Detect paste event and set first char */
            if (text.length() > 1)
                text = String.valueOf(text.charAt(0)); // TODO: We can fill out other EditTexts

            editTexts[currentIndex].removeTextChangedListener(this);
            editTexts[currentIndex].setText(text);
            editTexts[currentIndex].setSelection(text.length());
            editTexts[currentIndex].addTextChangedListener(this);

            if (text.length() == 1) {
                moveToNext();
            } else if (text.length() == 0)
                moveToPrevious();
        }

        private void moveToNext() {
            if (!isLast)
                editTexts[currentIndex + 1].requestFocus();

            if (isAllEditTextsFilled() && isLast) { // isLast is optional
                editTexts[currentIndex].clearFocus();
                hideKeyboard();
            }
        }

        private void moveToPrevious() {
            if (!isFirst)
                editTexts[currentIndex - 1].requestFocus();
        }

        private boolean isAllEditTextsFilled() {
            for (EditText editText : editTexts)
                if (editText.getText().toString().trim().length() == 0)
                    return false;
            btn.setBackgroundResource(R.drawable.rect_green);
            btn.setText("VERIFY");

            return true;
        }

        private void hideKeyboard() {
            if (getCurrentFocus() != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }

    }

    private void checkABC() {
        if (et1.getText().toString().isEmpty()) {
            //grey
            btn.setBackgroundColor(Color.parseColor("#C7CACF"));
        } else {
            if (et2.getText().toString().isEmpty()) {
                //grey
                btn.setBackgroundColor(Color.parseColor("#C7CACF"));
            } else {
                if (et3.getText().toString().isEmpty()) {
                    //grey
                    btn.setBackgroundColor(Color.parseColor("#C7CACF"));
                } else {
                    if (et4.getText().toString().isEmpty()) {
                        //grey
                        btn.setBackgroundColor(Color.parseColor("#C7CACF"));
                    } else {
                        //green
                        btn.setBackgroundColor(Color.parseColor("#349d13"));
                        et1.setCursorVisible(false);
                    }
                }
            }
        }
    }

    public class PinOnKeyListener implements View.OnKeyListener {

        private int currentIndex;

        PinOnKeyListener(int currentIndex) {
            this.currentIndex = currentIndex;
        }

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                if (editTexts[currentIndex].getText().toString().isEmpty() && currentIndex != 0)
                    editTexts[currentIndex - 1].requestFocus();
            }
            return false;
        }
    }
}