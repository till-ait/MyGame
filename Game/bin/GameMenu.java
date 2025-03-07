import java.util.ArrayList;

public class GameMenu {

	// CLASS VARIABLE //////////////////////////////////////////////////////////

	protected ArrayList<GameButton> buttonArray;

	protected String name;
	protected boolean isActive;

	protected int background;
	protected int openningSound;

	protected int positionX;
	protected int positionY;
	protected int lengthX;
	protected int lengthY;
	protected int margeX;
	protected int margeY;
	protected int nbButton;
	protected int buttonLengthX;
	protected int buttonLengthY;
	protected int buttonMargeX;
	protected int buttonMargeY;

	protected TheGame game;
	protected long lastTimeActivated;

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
	
	public static final int FILE_POSITION_BUTTON_TYPE = 0;		// TODO : peut etre mettre le text ici en postion 2, pas sur vu qu'on doit le mettre en francais ou en anglais, peut etre mieux de tout mettre dans un fichier avec le premier truc qui est le nom du bp, ensuite le text en francais puis le text en anglais
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
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_10 = 14;
	public static final int FILE_POSITION_BUTTON_CHOICE_RES_11 = 15;
	public static final int FILE_POSITION_BUTTON_CHOICE_TIME_RELOAD = 16;   // ms


	// CONSTRUCTEUR ///////////////////////////////////////////////////////////
	
	public GameMenu() {
	    
	}

	public GameMenu(String _name, TheGame _game) {
		name = _name;
		game = _game;
		buttonArray = new ArrayList<>();
		lastTimeActivated = System.currentTimeMillis();

		InitFromeFile();
	}

	public void InitFromeFile() {

		int i=0;
		ArrayList<String> datasFirstLine = new ArrayList<>();
		ArrayList<String> datas = new ArrayList<>();
		FileReading dataFile = new FileReading(name + ".txt");
		
		dataFile.ReadDataFromFile(datasFirstLine, FILE_LINE_MENU_DATA);

		SetPositionX(Integer.parseInt(datasFirstLine.get(FILE_POSITION_POSITION_X)));    // TODO : creer une fonction pour racourcir la ligne, pour plus de clareter
		SetPositionY(Integer.parseInt(datasFirstLine.get(FILE_POSITION_POSITION_Y)));
		SetLengthX(Integer.parseInt(datasFirstLine.get(FILE_POSITION_LENGTH_X)));
		SetLengthY(Integer.parseInt(datasFirstLine.get(FILE_POSITION_LENGTH_Y)));
		SetMargeX(Integer.parseInt(datasFirstLine.get(FILE_POSITION_MARGE_X)));
		SetMargeY(Integer.parseInt(datasFirstLine.get(FILE_POSITION_MARGE_Y)));
		SetNbButton(Integer.parseInt(datasFirstLine.get(FILE_POSITION_NBBUTTON)));
		SetButtonMargeX(Integer.parseInt(datasFirstLine.get(FILE_POSITION_BUTTON_MARGE_X)));
		SetButtonMargeY(Integer.parseInt(datasFirstLine.get(FILE_POSITION_BUTTON_MARGE_Y)));

		for(i=0; i<GetNbButton(); i++) {
		    dataFile.ReadDataFromFile(datas, FILE_LINE_MENU_DATA+i+1);
		    
		    if(datas.get(FILE_POSITION_BUTTON_TYPE).equals("regular")) {
		        CreatRegularButton(Integer.parseInt(datas.get(FILE_POSITION_BUTTON_LENGTH_X)),
		                           Integer.parseInt(datas.get(FILE_POSITION_BUTTON_LENGTH_Y)),
		                           i);
		    }
		    else if(datas.get(FILE_POSITION_BUTTON_TYPE).equals("toggle")) {
		        CreatToggleButton(Integer.parseInt(datas.get(FILE_POSITION_BUTTON_LENGTH_X)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_LENGTH_Y)),
		                          i);
		    }
		    else if(datas.get(FILE_POSITION_BUTTON_TYPE).equals("choice")) {
		        CreatChoiceButton(Integer.parseInt(datas.get(FILE_POSITION_BUTTON_LENGTH_X)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_LENGTH_Y)),
		                          i,
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_0)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_1)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_2)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_3)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_4)),
		                          Boolean.parseBoolean(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_5)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_6)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_7)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_8)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_9)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_10)),
		                          Boolean.parseBoolean(datas.get(FILE_POSITION_BUTTON_CHOICE_RES_11)),
		                          Integer.parseInt(datas.get(FILE_POSITION_BUTTON_CHOICE_TIME_RELOAD)));
		    }
		}
        
        // SetIsActive(GetIsActive());
		SetIsActive(Boolean.parseBoolean(datasFirstLine.get(FILE_POSITION_DEFAULT_ACTIV)));
		
		// TODO : SetBackgroudFromFile(_name);
		// TODO : SetSoundFromFile(_name);
	}
	
	protected void CreatRegularButton(int _lengthX, int _lengthY, int i) {
	    if((_lengthX != 0) && (_lengthY != 0)) {
	        buttonArray.add(new GameButton(name+"Bt"+i, game, this,
				                           _lengthX, _lengthY, i));
	    }
	    else {
	        buttonArray.add(new GameButton(name+"Bt"+i, game, this));
	    }
	}
	
	protected void CreatToggleButton(int _lengthX, int _lengthY, int i){
	    if((_lengthX != 0) && (_lengthY != 0)) {
	        buttonArray.add(new GameButtonToggle(name+"Bt"+i, game, this,
				                           _lengthX, _lengthY, i));
	    }
	    else {
	        buttonArray.add(new GameButtonToggle(name+"Bt"+i, game, this));
	    }
	}
	
	protected void CreatChoiceButton(int _lengthX, int _lengthY, int i,
	                  int _goldCost, int _cultistCost, int _knowlegeCost,
	                  int _suspicionCost, int _relicCost, boolean _ritualPlaceCost, int _goldreward, 
	                  int _cultistReward, int _knowlegeReward, int _suspicionReward,
	                  int _relicReward, boolean _ritualPlaceReward, int _timeToReload) {
	    buttonArray.add(new GameButtonChoice(name+"Bt"+i, game, this,
	                   _lengthX, _lengthY, i, _goldCost, _cultistCost, _knowlegeCost,
	                  _suspicionCost, _relicCost, _ritualPlaceCost, _goldreward, 
	                  _cultistReward, _knowlegeReward, _suspicionReward,
	                  _relicReward, _ritualPlaceReward, _timeToReload));
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
	    int buttonPositionX = (int) (positionX + margeX);
	    int buttonPositionY = (int) (positionY + margeY);
	    
		if(isActive) {
			System.out.println(name + " menu afficher, " + positionY);
			
			for(GameButton button : buttonArray) {
			    if(button.GetIsPrint()) {
			        button.OutputUpdate();
				    // button.OutputUpdate(buttonPositionX, buttonPositionY);
				    // // buttonPositionX += button.GetLengthX();
				    // buttonPositionY = (int) (buttonPositionY + button.GetLengthY() + buttonMargeY);
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

	public int GetPositionX() {
		return positionX;
	}

	public int GetPositionY() {
		return positionY;
	}

	public int GetLengthX() {
		return lengthX;
	}

	public int GetLengthY() {
		return lengthY;
	}

	public int GetMargeX() {
		return margeX;
	}

	public int GetMargeY() {
		return margeY;
	}

	public int GetNbButton() {
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

	public int GetButtonLengthX() {
		return buttonLengthX;
	}

	public int GetButtonLengthY() {
		return buttonLengthY;
	}

	public int GetButtonMargeX() {
		return buttonMargeX;
	}

	public int GetButtonMargeY() {
		return buttonMargeY;
	}

	public int GetIndexLevel() {
	    // necessaire pour le polymorphisme
		return 0;
    }

	public long GetLastTimeActivated() {
		return lastTimeActivated;
	}

	public void SetIsActive(boolean _isActive) {
		isActive = _isActive;
		lastTimeActivated = System.currentTimeMillis();

		for(GameButton button : buttonArray) {
			button.SetIsActive(_isActive);
		}
	}

	public void SetPositionX(int _positionX) {
	    for(GameButton button : buttonArray) {
	        button.TranslatePositionX((int)(_positionX - positionX));
	    }
		positionX = _positionX;
	}

	public void SetPositionY(int _positionY) {
	    for(GameButton button : buttonArray) {
	        button.TranslatePositionY((int)(_positionY - positionY));
	    }
		positionY = _positionY;
	}

	public void SetLengthX(int _lengthX) {
		if(_lengthX >= 0) {
			lengthX = _lengthX;
		}
	}

	public void SetLengthY(int _lengthY) {
		if(_lengthY >= 0) {
			lengthY = _lengthY;
		}
	}

	public void SetMargeX(int _margeX) {
		if(_margeX >= 0) {
			margeX = _margeX;
		}
	}

	public void SetMargeY(int _margeY) {
		if(_margeY >= 0) {
			margeY = _margeY;
		}
	}

	public void SetNbButton(int _nbButton) {
		if(_nbButton >= 0) {
			nbButton = _nbButton;
		}
	}

	public void SetButtonLengthX(int _buttonLengthX) {
		if(_buttonLengthX >= 0) {
			buttonLengthX = _buttonLengthX;
		}
	}

	public void SetButtonLengthY(int _buttonLengthY) {
		if(_buttonLengthY >= 0) {
			buttonLengthY = _buttonLengthY;
		}
	}

	public void SetButtonMargeX(int _buttonMargeX) {
		if(_buttonMargeX >= 0) {
			buttonMargeX = _buttonMargeX;
		}
	}

	public void SetButtonMargeY(int _buttonMargeY) {
		if(_buttonMargeY >= 0) {
			buttonMargeY = _buttonMargeY;
		}
	}
	
	public void SetIndexLevel(int _indexLevel) {
	    // necessaire pour le polymorphisme
    }
}