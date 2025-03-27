
package com.example.game;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

enum InputType {
	PRESS, UNPRESS, SLIDE, TIMETICK;
}


public class GameInput {

	// CLASS VARIABLES /////////////////////////////////////////////////////////

	private InputType inputType;
	private MainActivity game;
	private int startPositionX;
	private int startPositionY;

	private int lastPositionX;
	private int lastPositionY;
	private int finishPositionX;
	private int finishPositionY;
	private float f_startPositionX;
	private float f_startPositionY;
	private float f_finishPositionX;
	private float f_finishPositionY;
	private boolean isNewInput;

	// STATIC VARIABLES ////////////////////////////////////////////////////////

	public static final int MINIMUM_PIXEL_TO_SLIDE = 50;

	// CONSTRUCTEUR ////////////////////////////////////////////////////////////

	public GameInput(MainActivity _game) {
		inputType = InputType.PRESS;
		game = _game;
		startPositionX = 0;
		startPositionY = 0;
		lastPositionX = 0;
		lastPositionY = 0;
		finishPositionX = 0;
		finishPositionY = 0;
		isNewInput = false;

		View rootView = game.findViewById(android.R.id.content);
		rootView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float x = event.getX();
				float y = event.getY();

				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						Log.d("TouchTest", "Écran - ACTION_DOWN | X: " + x + ", Y: " + y);
						NewInput(InputType.PRESS, x, y, 0, 0);
						lastPositionX = (int) x;
						lastPositionY = (int) y;
						return true;

					case MotionEvent.ACTION_MOVE:
						Log.d("TouchTest", "Écran - ACTION_MOVE | X: " + x + ", Y: " + y);
						Log.d("TouchTest", "init : " + startPositionY + " curretn " + y);

						if((Math.abs(x - f_startPositionX)>MINIMUM_PIXEL_TO_SLIDE)
								|| (Math.abs(y - f_startPositionY)>MINIMUM_PIXEL_TO_SLIDE)) {
							NewInput(InputType.SLIDE, startPositionX, startPositionY, x, y);
							startPositionX = lastPositionX;
							startPositionY = lastPositionY;
							lastPositionX = (int) x;
							lastPositionY = (int) y;
						}

						return true;

					case MotionEvent.ACTION_UP:
						Log.d("TouchTest", "Écran - ACTION_UP | X: " + x + ", Y: " + y);

						NewInput(InputType.UNPRESS, x, y, 0, 0);
						return true;
				}
				return false;
			}
		});
	}

	// OVERRIDE ////////////////////////////////////////////////////////////////

	// TODO : il faut override la fonction d'adroid studio qui recup InputType

	public void tempNewInput(InputType _inputType,
	                         int _startPositionX, int _startPositionY,
	                         int _finishPositionX, int _finishPositionY) {
		if(!isNewInput) {
			inputType = _inputType;
			startPositionX = _startPositionX;
			startPositionY = _startPositionY;
			finishPositionX = _finishPositionX;
			finishPositionY = _finishPositionY;
			isNewInput = true;
		}
	}

	public void NewInput(InputType _inputType,
						 float _startPositionX, float _startPositionY,
						 float _finishPositionX, float _finishPositionY) {
		if(!isNewInput) {
			inputType = _inputType;
			startPositionX = (int)_startPositionX;
			startPositionY = (int)_startPositionY;
			finishPositionX = (int)_finishPositionX;
			finishPositionY = (int)_finishPositionY;
			isNewInput = true;
		}
	}

	// GETTER AND SETTER ///////////////////////////////////////////////////////

	public boolean GetIsNewInput() {
		return isNewInput;
	}

	public void SetIsNewInput(boolean _isNewInput) {
		isNewInput = _isNewInput;
	}

	public InputType GetInputType() {
		return inputType;
	}

	public int GetStartPositionX() {
		return startPositionX;
	}

	public int GetStartPositionY() {
		return startPositionY;
	}

	public int GetFinishPositionX() {
		return finishPositionX;
	}

	public int GetFinishPositionY() {
		return finishPositionY;
	}
}