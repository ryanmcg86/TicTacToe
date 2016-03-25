package com.example.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener{
    private Button[] btns;
    private Button reset;
    private int clickCount = 0;
    private int victoryCount = 0;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btns = new Button[9];
        int id = R.id.btn1;
        for(int i = 0; i < btns.length; i++){
        	btns[i] = (Button)findViewById(id);
        	btns[i].setOnClickListener(this);
        	id++;
        }
        reset = (Button)findViewById(R.id.Reset);
        reset.setOnClickListener(this);
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View v) {
		Context context = getApplicationContext();
		CharSequence exes = "X's win!";
		CharSequence os = "O's win!";
		CharSequence tie = "The game is a draw.";
		
		int duration = Toast.LENGTH_SHORT;
		
		
		if(v.getId() == reset.getId()){
			for(int i = 0; i < btns.length; i++){
				btns[i].setText("");
				btns[i].setEnabled(true);
			}
			clickCount = 0;
			victoryCount = 0;
		}
		else{
			if(clickCount == 0 || clickCount%2 == 0){
				((Button)v).setText("X");
				clickCount++;
				((Button)v).setEnabled(false);
			}	
			else{
				((Button)v).setText("O");
				clickCount++;
				((Button)v).setEnabled(false);
			}
		}
		//
		if(clickCount > 4){
			if((btns[0].getText() == "X" && btns[1].getText() == "X" && btns[2].getText() == "X") ||
			   (btns[3].getText() == "X" && btns[4].getText() == "X" && btns[5].getText() == "X") ||
			   (btns[6].getText() == "X" && btns[7].getText() == "X" && btns[8].getText() == "X") ||
			   (btns[0].getText() == "X" && btns[3].getText() == "X" && btns[6].getText() == "X") ||
			   (btns[1].getText() == "X" && btns[4].getText() == "X" && btns[7].getText() == "X") ||
			   (btns[2].getText() == "X" && btns[5].getText() == "X" && btns[8].getText() == "X") ||
			   (btns[0].getText() == "X" && btns[4].getText() == "X" && btns[8].getText() == "X") ||
			   (btns[2].getText() == "X" && btns[4].getText() == "X" && btns[6].getText() == "X")){
				Toast toast = Toast.makeText(context, exes, duration);
				toast.show();
				victoryCount++;
				for(int i = 0; i < 9; i++){
					btns[i].setEnabled(false);
				}
			}
			if((btns[0].getText() == "O" && btns[1].getText() == "O" && btns[2].getText() == "O") ||
			   (btns[3].getText() == "O" && btns[4].getText() == "O" && btns[5].getText() == "O") ||
			   (btns[6].getText() == "O" && btns[7].getText() == "O" && btns[8].getText() == "O") ||
			   (btns[0].getText() == "O" && btns[3].getText() == "O" && btns[6].getText() == "O") ||
			   (btns[1].getText() == "O" && btns[4].getText() == "O" && btns[7].getText() == "O") ||
			   (btns[2].getText() == "O" && btns[5].getText() == "O" && btns[8].getText() == "O") ||
			   (btns[0].getText() == "O" && btns[4].getText() == "O" && btns[8].getText() == "O") ||
			   (btns[2].getText() == "O" && btns[4].getText() == "O" && btns[6].getText() == "O")){
				Toast toast = Toast.makeText(context, os, duration);
				toast.show();
				victoryCount++;
				for(int i = 0; i < 9; i++)
					btns[i].setEnabled(false);
				
			}
		}
		if(clickCount == 9 && victoryCount == 0){
			Toast toast = Toast.makeText(context, tie, duration);
			toast.show();
			for(int i = 0; i < 9; i++){
				btns[i].setEnabled(false);
			}
		}
	}
}
