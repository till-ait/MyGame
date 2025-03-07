

enum InputType {
	PRESS, UNPRESS, SLIDE, TIMETICK;
}


public class GameInput {

	// CLASS VARIABLES /////////////////////////////////////////////////////////

	private InputType inputType;
	private int startPositionX;
	private int startPositionY;
	private int finishPositionX;
	private int finishPositionY;
	private boolean isNewInput;

	// CONSTRUCTEUR ////////////////////////////////////////////////////////////

	public GameInput() {
		inputType = InputType.PRESS;
		startPositionX = 0;
		startPositionY = 0;
		finishPositionX = 0;
		finishPositionY = 0;
		isNewInput = false;
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