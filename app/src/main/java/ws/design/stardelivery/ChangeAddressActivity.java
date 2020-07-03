package ws.design.stardelivery;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import androidx.core.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ChangeAddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.addAddress_linear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),SavedAddressesActivity.class);
                startActivity(i);
            }
        });
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CollapsingToolbarLayout ctl = findViewById(R.id.collapsingToolbarLayout);
        ctl.setTitle("SAVED ADDRESSES");
        ctl.setCollapsedTitleTextColor(Color.parseColor("#000000"));
        ctl.setContentScrim(getDrawable(R.color.white));
        ctl.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        ctl.setExpandedTitleTextAppearance(R.style.expandedAppBar);
        ctl.setExpandedTitleColor(Color.parseColor("#000000"));
        ctl.setCollapsedTitleTextColor(Color.parseColor("#000000"));
        Typeface typeface = ResourcesCompat.getFont(this, R.font.roboto_medium);
        ctl.setCollapsedTitleTypeface(typeface);
        ctl.setExpandedTitleTypeface(typeface);
    }
}