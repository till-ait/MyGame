import java.util.ArrayList;

public class GameMenu {

	// CLASS VARIABLE //////////////////////////////////////////////////////////

	protected ArrayList<GameButton> buttonArray;

	protected String name;
	protected boolean isActive;

	protected int background;
	protected int openningSound;

	protected short positionX;
	protected short positionY;
	protected short lengthX;
	protected short lengthY;
	protected short margeX;
	protected short margeY;
	protected short nbButton;
	protected short buttonLengthX;
	protected short buttonLengthY;
	protected short buttonMargeX;
	protected short buttonMargeY;

	protected TheGame game;

	// STATIC VARIABLE /////////////////////////////////////////////////////////
	
	public static final int FILE_LINE_MENU_DATA = 0;    // les lignes suivante sont des boutton

	public static final int FILE_POSITION_POSITION_X = 0;
	public static final int FILE_POSITION_POSITION_Y = 1;
	public static final int FILE_POSITION_LENGTH_X = 2;
	public static final int FILE_POSITION_LENGTH_Y = 3;
	public static final int FILE_POSITION_MARGE_X = 4;
	public static final int FILE_POSITION_MARGE_Y = 5;
	public static final int FILE_POSITION_NBBUTTON = 6;
	public static final int FILE_POSITION_DEFAULT_ACTIV = 7;
	public static final int FILE_POSITION_BUTTON_MARGE_X = 8;
	public static final int FILE_POSITION_BUTTON_MARGE_Y = 9;
	
	public static final int FILE_POSITION_BUTTON_IS_TOGGLE = 0;
	public static final int FILE_POSITION_BUTTON_LENGTH_X = 1;
	public static final int FILE_POSITION_BUTTON_LENGTH_Y = 2;
	
	public static final int FILE_POSITION_BUTTON_INDEX_LEVEL = 3;	// pour le building c'est l'infiltration, pour les dieux c'est le niveau, et pour les events doit etre a 0

	public static final int FILE_POSITION_BUTTON_CHOICE_RES_0 = 4;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_1 = 5;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_2 = 6;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_3 = 7;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_4 = 8;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_5 = 9;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_6 = 10;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_7 = 11;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_8 = 12;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_9 = 13;
	public static final int FILE_POSITION_BUTTON_CHOICE_TIME_RELOAD = 14;   // ms


	// CONSTRUCTEUR ///////////////////////////////////////////////////////////
	
	public GameMenu() {
	    
	}

	public GameMenu(String _name, TheGame _game) {
		name = _name;
		game = _game;
		buttonArray = new ArrayList<>();

		InitFromeFile();
	}

	public void InitFromeFile() {

		int i=0;
		ArrayList<String> datas = new ArrayList<>();
		FileReading dataFile = new FileReading(name + ".txt");
		
		dataFile.ReadDataFromFile(datas, FILE_LINE_MENU_DATA);

		SetPositionX(Short.parseShort(datas.get(FILE_POSITION_POSITION_X)));    // TODO : creer une fonction pour racourcir la ligne, pour plus de clareter
		SetPositionY(Short.parseShort(datas.get(FILE_POSITION_POSITION_Y)));
		SetLengthX(Short.parseShort(datas.get(FILE_POSITION_LENGTH_X)));
		SetLengthY(Short.parseShort(datas.get(FILE_POSITION_LENGTH_Y)));
		SetMargeX(Short.parseShort(datas.get(FILE_POSITION_MARGE_X)));
		SetMargeY(Short.parseShort(datas.get(FILE_POSITION_MARGE_Y)));
		SetNbButton(Short.parseShort(datas.get(FILE_POSITION_NBBUTTON)));
		SetIsActive(Boolean.parseBoolean(datas.get(FILE_POSITION_DEFAULT_ACTIV)));
		SetButtonMargeX(Short.parseShort(datas.get(FILE_POSITION_BUTTON_MARGE_X)));
		SetButtonMargeY(Short.parseShort(datas.get(FILE_POSITION_BUTTON_MARGE_Y)));

		for(i=0; i<GetNbButton(); i++) {
		    dataFile.ReadDataFromFile(datas, FILE_LINE_MENU_DATA+i+1);
		    
		    if(datas.get(FILE_POSITION_BUTTON_IS_TOGGLE).equals("regular")) {
		        CreatRegularButton(Short.parseShort(datas.get(FILE_POSITION_BUTTON_LENGTH_X)),
		                           Short.parseShort(datas.get(FILE_POSITION_BUTTON_LENGTH_Y)),
		                           i);
		    }
		    else if(datas.get(FILE_POSITION_BUTTON_IS_TOGGLE).equals("toggle")) {
		        CreatToggleButton(Short.parseShort(datas.get(FILE_POSITION_BUTTON_LENGTH_X)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_LENGTH_Y)),
		                          i);
		    }
		    else if(datas.get(FILE_POSITION_BUTTON_IS_TOGGLE).equals("choice")) {
		        CreatChoiceButton(Short.parseShort(datas.get(FILE_POSITION_BUTTON_LENGTH_X)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_LENGTH_Y)),
		                          i,
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_0)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_1)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_2)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_3)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_4)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_5)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_6)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_7)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_8)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_9)),
		                          Short.parseShort(datas.get(FILE_POSITION_BUTTON_CHOICE_TIME_RELOAD)));
		    }
		}
        
        SetIsActive(GetIsActive());
		
		// TODO : SetBackgroudFromFile(_name);
		// TODO : SetSoundFromFile(_name);
	}
	
	protected void CreatRegularButton(short _lengthX, short _lengthY, int i) {
	    if((_lengthX != 0) && (_lengthY != 0)) {
	        buttonArray.add(new GameButton(name+"Bt"+i, game, this,
				                           _lengthX, _lengthY, i));
	    }
	    else {
	        buttonArray.add(new GameButton(name+"Bt"+i, game, this));
	    }
	}
	
	protected void CreatToggleButton(short _lengthX, short _lengthY, int i){
	    if((_lengthX != 0) && (_lengthY != 0)) {
	        buttonArray.add(new GameButtonToggle(name+"Bt"+i, game, this,
				                           _lengthX, _lengthY, i));
	    }
	    else {
	        buttonArray.add(new GameButtonToggle(name+"Bt"+i, game, this));
	    }
	}
	
	protected void CreatChoiceButton(short _lengthX, short _lengthY, int i,
	                  int _goldCost, int _cultistCost, int _knowlegeCost,
	                  int _suspicionCost, int _relicCost, int _goldreward, 
	                  int _cultistReward, int _knowlegeReward, int _suspicionReward,
	                  int _relicReward, int _timeToReload) {
	    buttonArray.add(new GameButtonChoice(name+"Bt"+i, game, this,
	                   _lengthX, _lengthY, i, _goldCost, _cultistCost, _knowlegeCost,
	                  _suspicionCost, _relicCost, _goldreward, 
	                  _cultistReward, _knowlegeReward, _suspicionReward,
	                  _relicReward, _timeToReload));
	}

	// UPDATE //////////////////////////////////////////////////////////////////

	public void InputUpdate(GameInput _lastGameInput) {

		// TODO : quand override de town ajouter les slides

		if(isActive) {
			for(GameButton button : buttonArray) {
				//button.ActivateMethode();
				button.InputUpdate(_lastGameInput);
			}
		}
	}

// 	public void OutputUpdate() {
// 		if(isActive) {
// 			System.out.println(name + " menu afficher, " + positionY);
// 			for(GameButton button : buttonArray) {
// 				button.OutputUpdate();
// 			}
// 		}
// 	}
	
	public void OutputUpdate() {
	    short buttonPositionX = (short) (positionX + margeX);
	    short buttonPositionY = (short) (positionY + margeY);
	    
		if(isActive) {
			System.out.println(name + " menu afficher, " + positionY);
			
			for(GameButton button : buttonArray) {
			    if(button.GetIsPrint()) {
			        button.OutputUpdate();
				    // button.OutputUpdate(buttonPositionX, buttonPositionY);
				    // // buttonPositionX += button.GetLengthX();
				    // buttonPositionY = (short) (buttonPositionY + button.GetLengthY() + buttonMargeY);
			    }
			}
		}
	}

	// GETTER AND SETTER ///////////////////////////////////////////////////////

	public String GetName() {
		return name;
	}

	public boolean GetIsActive() {
		return isActive;
	}

	public int GetBackground() {
		return background;
	}

	public int GetOpenningSound() {
		return openningSound;
	}

	public short GetPositionX() {
		return positionX;
	}

	public short GetPositionY() {
		return positionY;
	}

	public short GetLengthX() {
		return lengthX;
	}

	public short GetLengthY() {
		return lengthY;
	}

	public short GetMargeX() {
		return margeX;
	}

	public short GetMargeY() {
		return margeY;
	}

	public short GetNbButton() {
		return nbButton;
	}

	public ArrayList<GameButton> GetCopyButtonArray() {
		ArrayList<GameButton> copy = new ArrayList<GameButton>(buttonArray);
		return copy;
	}

	public int GetButtonArrayPosition(String _name) {
		int i=0;

		for(GameButton button : buttonArray) {
			if(button.GetName().equals(_name)) {
				return i;
			}
			else {
				i++;
			}
		}
		return -1;
	}

	public boolean IsButtonInButtonArray(String _name) {
		for(GameButton button : buttonArray) {
			if(button.GetName().equals(_name)) {
				return true;
			}
		}
		return false;
	}

	public short GetButtonLengthX() {
		return buttonLengthX;
	}

	public short GetButtonLengthY() {
		return buttonLengthY;
	}

	public short GetButtonMargeX() {
		return buttonMargeX;
	}

	public short GetButtonMargeY() {
		return buttonMargeY;
	}

	public void SetIsActive(boolean _isActive) {
		isActive = _isActive;

		for(GameButton button : buttonArray) {
			button.SetIsActive(_isActive);
		}
	}

	public void SetPositionX(short _positionX) {
	    for(GameButton button : buttonArray) {
	        button.TranslatePositionX((short)(_positionX - positionX));
	    }
		positionX = _positionX;
	}

	public void SetPositionY(short _positionY) {
	    for(GameButton button : buttonArray) {
	        button.TranslatePositionY((short)(_positionY - positionY));
	    }
		positionY = _positionY;
	}

	public void SetLengthX(short _lengthX) {
		if(_lengthX >= 0) {
			lengthX = _lengthX;
		}
	}

	public void SetLengthY(short _lengthY) {
		if(_lengthY >= 0) {
			lengthY = _lengthY;
		}
	}

	public void SetMargeX(short _margeX) {
		if(_margeX >= 0) {
			margeX = _margeX;
		}
	}

	public void SetMargeY(short _margeY) {
		if(_margeY >= 0) {
			margeY = _margeY;
		}
	}

	public void SetNbButton(short _nbButton) {
		if(_nbButton >= 0) {
			nbButton = _nbButton;
		}
	}

	public void SetButtonLengthX(short _buttonLengthX) {
		if(_buttonLengthX >= 0) {
			buttonLengthX = _buttonLengthX;
		}
	}

	public void SetButtonLengthY(short _buttonLengthY) {
		if(_buttonLengthY >= 0) {
			buttonLengthY = _buttonLengthY;
		}
	}

	public void SetButtonMargeX(short _buttonMargeX) {
		if(_buttonMargeX >= 0) {
			buttonMargeX = _buttonMargeX;
		}
	}

	public void SetButtonMargeY(short _buttonMargeY) {
		if(_buttonMargeY >= 0) {
			buttonMargeY = _buttonMargeY;
		}
	}
	
	public void SetIndexLevel(short _indexLevel) {
	    // necessaire pour le polymorphisme
    }
}