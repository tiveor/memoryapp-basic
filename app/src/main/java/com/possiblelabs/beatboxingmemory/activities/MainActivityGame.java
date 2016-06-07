package com.possiblelabs.beatboxingmemory.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.possiblelabs.beatboxingmemory.R;

import ru.katso.livebutton.LiveButton;

/**
 * Created by Brian on 04/06/2016.
 */
public class MainActivityGame extends BaseActivity {

    TextView tittle;
    LiveButton buttonStart;
    LiveButton pianoButton;
    LiveButton exitButton;

    private View.OnClickListener buttonPianoClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivityGame.this, Activity_Piano.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener buttonStartClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivityGame.this, Activity_Game.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        loadReferences();
        Typeface TF = Typeface.createFromAsset(getAssets(),FONT_PATH);
        tittle.setTypeface(TF);
        buttonStart.setTypeface(TF);
        pianoButton.setTypeface(TF);
        exitButton.setTypeface(TF);
    }

    private void loadReferences() {
        tittle = (TextView) findViewById(R.id.textViewTitle);
        buttonStart = (LiveButton) findViewById(R.id.button_start);
        pianoButton = (LiveButton) findViewById(R.id.button_piano);
        exitButton = (LiveButton) findViewById(R.id.button_exit);
        pianoButton.setOnClickListener(buttonPianoClick);
        buttonStart.setOnClickListener(buttonStartClick);
        tittle.setText(Html.fromHtml(TITTLE_APP));
    }


}
