

enum InputType {
	PRESS, UNPRESS, SLIDE, TIMETICK;
}


public class GameInput {

	// CLASS VARIABLES /////////////////////////////////////////////////////////

	private InputType inputType;
	private short startPositionX;
	private short startPositionY;
	private short finishPositionX;
	private short finishPositionY;
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
	                         short _startPositionX, short _startPositionY,
	                         short _finishPositionX, short _finishPositionY) {
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

	public short GetStartPositionX() {
		return startPositionX;
	}

	public short GetStartPositionY() {
		return startPositionY;
	}

	public short GetFinishPositionX() {
		return finishPositionX;
	}

	public short GetFinishPositionY() {
		return finishPositionY;
	}
}