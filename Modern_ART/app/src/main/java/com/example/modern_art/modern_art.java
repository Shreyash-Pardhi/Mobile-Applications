package com.example.modern_art;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.app.AlertDialog;
import android.widget.TextView;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class modern_art extends Activity {

    private SeekBar colorControl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modern_art);

        final LinearLayout yellowBox = (LinearLayout) findViewById(R.id.greenBox);
        final LinearLayout greenBox = (LinearLayout) findViewById(R.id.redBox);
        final LinearLayout orangeBox = (LinearLayout) findViewById(R.id.yellowBox);
        final LinearLayout indigoBox = (LinearLayout) findViewById(R.id.aquaBox);
        final LinearLayout indigoBoxEmbedded = (LinearLayout) findViewById(R.id.greyBox);
        final LinearLayout blueBox = (LinearLayout) findViewById(R.id.voiletBox);
        final LinearLayout redBox = (LinearLayout) findViewById(R.id.blueBox);
        final LinearLayout redBoxBottom = (LinearLayout) findViewById(R.id.limeBox);

        final int originalRed = ((ColorDrawable) redBox.getBackground()).getColor();
        final int originalOrange = ((ColorDrawable) orangeBox.getBackground()).getColor();
        final int originalBlue = ((ColorDrawable) blueBox.getBackground()).getColor();
        final int originalYellow = ((ColorDrawable) yellowBox.getBackground()).getColor();
        final int originalGreen = ((ColorDrawable) greenBox.getBackground()).getColor();
        final int originalIndigo = ((ColorDrawable) indigoBox.getBackground()).getColor();
        final int originalGrey = ((ColorDrawable) greenBox.getBackground()).getColor();

        colorControl = (SeekBar) findViewById(R.id.colorControl);
        colorControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                // Log.d("DEBUG", "Progress is " + progressChanged);
                setProgressBasedBackgroundColor(redBox, originalRed);
                setProgressBasedBackgroundColor(orangeBox, originalOrange);
                setProgressBasedBackgroundColor(blueBox, originalBlue);
                setProgressBasedBackgroundColor(yellowBox, originalYellow);
                setProgressBasedBackgroundColor(indigoBoxEmbedded, originalIndigo);
                setProgressBasedBackgroundColor(greenBox, originalGreen);
                setProgressBasedBackgroundColor(indigoBox, originalIndigo);
                setProgressBasedBackgroundColor(redBoxBottom, originalRed);
                setProgressBasedBackgroundColor(greenBox, originalGrey);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            private void setProgressBasedBackgroundColor(LinearLayout box, int OriginalBoxColor) {
                float[] hsvColor = new float[3];
                Color.colorToHSV(OriginalBoxColor, hsvColor);
                hsvColor[0] = hsvColor[0] + progressChanged;
                hsvColor[0] = hsvColor[0] % 360;
                box.setBackgroundColor(Color.HSVToColor(Color.alpha(OriginalBoxColor), hsvColor));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_modern_art, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_more_information) {
                View dialogView = this.getLayoutInflater().inflate(R.layout.moma_dialog, null);
                final AlertDialog dialog = new AlertDialog.Builder(this).setView(dialogView).create();

                TextView visitMoma = (TextView) dialogView.findViewById(R.id.visit_moma);
                visitMoma.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        dialog.dismiss();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("http://www.moma.org/m#home"));
                        startActivity(i);
                    }
                });

                TextView notNow = (TextView) dialogView.findViewById(R.id.not_now);
                notNow.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

        }

        return super.onOptionsItemSelected(item);
    }

}