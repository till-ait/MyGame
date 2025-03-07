import java.util.ArrayList;

public class GameMenuBuilding extends GameMenu {

	// CLASS VARIABLES /////////////////////////////////////////////////////////

	protected boolean isLoaded;
	protected BuildingState buildingState;
	protected int infiltrationLevel;
	protected boolean isDoorBlocked;    // TODO : a la creation parcourir les bat et voir si la porte y es et est ce qu'elle est blocante, ou alors mieu a chaque fois que c'est mis a actif
	protected long lastTimeUsed;    // heure a la darniere utilisation, comparaison si la nouvelle heure est plus grande en plus time reload
	protected ArrayList<Integer> infiltationLevelRequireArray;
	protected int timeToReload;

	// STATIC VARIABLES ////////////////////////////////////////////////////////

	public static final int TIME_TO_RELOAD = 100; // en ms, ne plus mettre static si plus le meme pour tous le monde
	
	public static final int INITIAL_INFILTRATION_LEVEL = 0;
	public static final boolean INITIAL_IS_LOADED_VALUE = true;

	// ENUM ////////////////////////////////////////////////////////////////////

	public static enum BuildingState {	// Represente les etats particulier dans le quel un batiment pourrait etre
        None, DoorOpenend, DoorClosed, InquisitionActivate, Allie, Enemies
    }

	// CONSTRUCTOR /////////////////////////////////////////////////////////////

	public GameMenuBuilding(String _name, TheGame _game) { // TODO : faire la composition aleatoir de la ville
// 		super(_name, _game); // Bas nn du coup faut le remplir de game
        super();
        name = _name;
		game = _game;
		buttonArray = new ArrayList<>();
		
		isLoaded = INITIAL_IS_LOADED_VALUE;
		buildingState = BuildingState.None;
        infiltrationLevel = INITIAL_INFILTRATION_LEVEL;
        infiltationLevelRequireArray = new ArrayList<>();
		timeToReload = 0;

		InitFromeFile();
		
		// TODO : SetBackgroudFromFile(_name);
		// TODO : SetSoundFromFile(_name);
		
		// TODO : Pas oublier de mettre un bouton croix, pour quitter le menu, ou on slide pour l'enlever ?
		// TODO : peut etre l'appuie sur l'un des bouton permet de retrouner au menu town si ca marche		
	}

	// OVERRIDE ////////////////////////////////////////////////////////////////
    
    @Override
    public void InitFromeFile() {	// TODO : maintenant que l'init se passe que a la fin dans GameMenu peut etre plus besoin de se faire chier a tous reecrire
		int i=0;
		ArrayList<String> datas = new ArrayList<>();
		FileReading dataFile = new FileReading(name + ".txt");
		
		dataFile.ReadDataFromFile(datas, FILE_LINE_MENU_DATA);

		SetPositionX(Integer.parseInt(datas.get(FILE_POSITION_POSITION_X)));
		SetPositionY(Integer.parseInt(datas.get(FILE_POSITION_POSITION_Y)));
		SetLengthX(Integer.parseInt(datas.get(FILE_POSITION_LENGTH_X)));
		SetLengthY(Integer.parseInt(datas.get(FILE_POSITION_LENGTH_Y)));
		SetMargeX(Integer.parseInt(datas.get(FILE_POSITION_MARGE_X)));
		SetMargeY(Integer.parseInt(datas.get(FILE_POSITION_MARGE_Y)));
		SetNbButton(Integer.parseInt(datas.get(FILE_POSITION_NBBUTTON)));
		SetIsActive(Boolean.parseBoolean(datas.get(FILE_POSITION_DEFAULT_ACTIV)));
		SetButtonMargeX(Integer.parseInt(datas.get(FILE_POSITION_BUTTON_MARGE_X)));
		SetButtonMargeY(Integer.parseInt(datas.get(FILE_POSITION_BUTTON_MARGE_Y)));
		
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
		  
		  infiltationLevelRequireArray.add(Integer.parseInt(datas.get(FILE_POSITION_BUTTON_INDEX_LEVEL)));
		}
        
        SetIsActive(GetIsActive());
		
		// TODO : SetBackgroudFromFile(_name);
		// TODO : SetSoundFromFile(_name);
	}
	
	
	@Override
	public void InputUpdate(GameInput _lastGameInput) {
		if(isActive) {
		    if(System.currentTimeMillis() > (lastTimeUsed + timeToReload)) {    // TODO : peut etre mettre un timer ou autre, fin quelque chose pour informer le joueur que c'est en court d'utilisation
		        isLoaded = true;
		    }
		    else {
		        isLoaded = false;
		    }
		    
		    if(isLoaded) {
    			for(GameButton button : buttonArray) {
    				//button.ActivateMethode();
    				button.InputUpdate(_lastGameInput);
    			}
		    }
		}
	}
    
    // GETTER AND SETTER ///////////////////////////////////////////////////////
    
    public boolean GetIsLoaded(){
        return isLoaded;
    }
    
    public int GetIndexLevel(){
        return infiltrationLevel;
    }
    
    public boolean GetIsDoorBlocked(){
        return isDoorBlocked;
    }
    
    public long GetLastTimeUsed(){
        return lastTimeUsed;
    }
    
    public long GetTimeToReload() {
        return timeToReload;
    }
    
    @Override
    public void SetIsActive(boolean _isActive){ // TODO : Ne pas mettre les boutton a actif quand en rechargement, mais bien les print (normalement si print et innactif met une image differente)
        int i=0;
		isActive = _isActive;

		for(GameButton button : buttonArray) {
		    if(infiltationLevelRequireArray.get(i) <= infiltrationLevel){
			    button.SetIsActive(_isActive);
		    }
			i++;
		}
    }
    
    public void SetIsLoaded(boolean _isLoaded){
        isLoaded = _isLoaded;
    }
    
	@Override
    public void SetIndexLevel(int _indexLevel){
        int i=0;

		if(_indexLevel > 0) {
			infiltrationLevel = _indexLevel;
			
			for(int requireLevel : infiltationLevelRequireArray){
				if(requireLevel <= infiltrationLevel) {
					buttonArray.get(i).SetIsActive(true);
				} 
				else {
					buttonArray.get(i).SetIsActive(false);
				} 
				i++;
			}
		}
    }
    
    public void SetIsDoorBlocked(boolean _isDoorBlocked){
        isDoorBlocked = _isDoorBlocked;
    }
    
    public void SetLastTimeUsed(long _lastTimeUsed){
        lastTimeUsed = _lastTimeUsed;
    }
    
    public void SetTimeToReload(int _timeToReload) {
        timeToReload = _timeToReload;
    }
}






















