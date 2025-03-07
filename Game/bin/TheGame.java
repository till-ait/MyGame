import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class TheGame {

	// CLASS VARIABLE //////////////////////////////////////////////////////////

	protected boolean isGameOn;
	protected ArrayList<GameMenu> menuArray;
	protected ArrayList<GameMenu> buildingArray;    // TODO : il faut que quand on fasse nouvelle partie ou jouer l'array soit remplie des batiments pour cette game
	protected ArrayList<GameMenu> eventArray;	// TODO : il faut remplire l'array aleatoirement d'event, une fois que l'array est entrement parcouru on la remelange et on l'a refait
	protected int indexEventArray;
	protected GameMenuGodChoice.GodsNames worshipedGod;
	protected long lastTimeUpdate;
	protected long lastTimeEvent;
	protected GameInput lastGameInput;

	protected long screenLengthX; // les distance sont proportionel a ces vairable
	protected long screenLengthY;
	
	protected boolean isInFrench;
	protected boolean isInEnglish;
	protected boolean soundOn;

	protected String theGameFilePathe;
	
	protected boolean isGateClosed;		// TODO : mettre a true si la porte est dans la game
	protected boolean isInquisitionActive;

	// STATIC VARIABLE /////////////////////////////////////////////////////////

	public static final int PERIOD_ONE_UPDATE = 33;
	public static final int FILE_FIRST_LINE = 0;
	public static final int FILE_EVENT_NAME_LINE = 1;
	public static final int FILE_MENU_PARAMETERS_FIRST_LINE = 2;
	public static final int FILE_POSITION_MENU_TYPE = 0;
	public static final int TIME_BITWEEN_EVENT = 6000;		// 1 minute
	public static final int TIME_OFFSET_TO_ACTIVATE_EVENT = 1000;	// time to let the player see the town

	public static final int FILE_POSITION_INIT_GOLD = 1;
	public static final int FILE_POSITION_INIT_CULTIST = 2;
	public static final int FILE_POSITION_INIT_KNOWLEGE = 3;
	public static final int FILE_POSITION_INIT_SUSPICION = 4;
	public static final int FILE_POSITION_INIT_RELIC = 5;
	public static final int FILE_POSITION_EVENT_THRESHOLD_GOLD = 6;
	public static final int FILE_POSITION_EVENT_THRESHOLD_CULTIST = 7;
	public static final int FILE_POSITION_EVENT_THRESHOLD_KNOWLEGE = 8;
	public static final int FILE_POSITION_EVENT_THRESHOLD_SUSPICION = 9;
	public static final int FILE_POSITION_EVENT_THRESHOLD_RELIC = 10;

	// CONSTRUCTEUR /////////////////////////////////////////////////////////////
	public TheGame() {
		isGameOn = true;
		menuArray = new ArrayList<>();
		buildingArray = new ArrayList<>();
		eventArray = new ArrayList<>();		// la remplir ici ou quand appuie sur nouvelle partie
		indexEventArray = 0;
		isGateClosed = false;
		isInquisitionActive = false;
		lastTimeUpdate = System.currentTimeMillis();
		lastTimeEvent = lastTimeUpdate;
		lastGameInput = new GameInput();

		screenLengthX = 1080;
		screenLengthY = 2400;
		
		isInFrench = true;
		isInEnglish = false;    // TODO : peut etre faire une sauvegarde pour la langue choisie si nn chiant a faire a chaque fois
		soundOn = true;     // TODO : faire une save de si le son est allumer

		InitMenuArrayFromeFile();
	}

	public void InitMenuArrayFromeFile() {  // TODO : peut etre ajouter ici le remplissage du town menu, et seul les menus de batiment concerne seront cree, nan peut etre le mettre a l'appuie de play
	    int i=0;
		FileReading dataFile = new FileReading("dataTheGame.txt");
		ArrayList<String> datas = new ArrayList<>();
		
		dataFile.ReadDataFromFile(datas, FILE_FIRST_LINE);
		ArrayList<String> datasfirstLine = new ArrayList<>(datas);
		dataFile.ReadDataFromFile(datas, FILE_EVENT_NAME_LINE);
		ArrayList<String> datasEventLine = new ArrayList<>(datas);

		for(String eventName : datasEventLine) {
			eventArray.add(new GameMenuEvent(eventName, this));
			System.out.println("Event " + eventName + " cree");
		}
		Collections.shuffle(eventArray);

		i = FILE_MENU_PARAMETERS_FIRST_LINE;
		for(String menuName : datasfirstLine) {
		    
		    dataFile.ReadDataFromFile(datas, i);
			
			if(datas.get(FILE_POSITION_MENU_TYPE).equals("regular")){
			    menuArray.add(new GameMenu(menuName, this));    // TODO : faire ne sorte que le fichier definisse si c'est un nomral ou un 
			}
			if(datas.get(FILE_POSITION_MENU_TYPE).equals("town")){
			    menuArray.add(new GameMenuTown(menuName, this));    // TODO : Le town ne connait pas ce qu'il y a en lui, il sait juste qu'il y a 8 button et chacun de ses button va taper dans 
			}

			if(datas.get(FILE_POSITION_MENU_TYPE).equals("ressources")){
			    menuArray.add(new GameMenuRessources(menuName, this,
			                                         Integer.parseInt(datas.get(FILE_POSITION_INIT_GOLD)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_INIT_CULTIST)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_INIT_KNOWLEGE)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_INIT_SUSPICION)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_INIT_RELIC)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_EVENT_THRESHOLD_GOLD)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_EVENT_THRESHOLD_CULTIST)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_EVENT_THRESHOLD_KNOWLEGE)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_EVENT_THRESHOLD_SUSPICION)),
			                                         Integer.parseInt(datas.get(FILE_POSITION_EVENT_THRESHOLD_RELIC))));
			}

			if(datas.get(FILE_POSITION_MENU_TYPE).equals("godsChoice")) {
				menuArray.add(new GameMenuGodChoice(menuName, this));
			}

			if(datas.get(FILE_POSITION_MENU_TYPE).equals("godsQuest")) {
				menuArray.add(new GameMenuGodQuest(menuName, this));
			}
			
			i++;
		}

		// TODO : mettre dans des fonction la c'est le bordel
	}

	// UPDATE //////////////////////////////////////////////////////////////////

	public void GameRun() {
		int i=0;
		long timeSinceLastUpdate = 0;

		while(isGameOn) {
			InputUpdate();
			OutputUpdate();

			lastTimeUpdate = System.currentTimeMillis();

			if(i==250) { // a supprimer
				isGameOn = false;
			}

            SimulateInput(i, 2, 11, 221, 0, 0);
            SimulateInput(i, 6, 101, 121, 0, 0);
            SimulateInput(i, 10, 101, 121, 0, 0);
            SimulateInput(i, 14, 101, 551, 0, 0);
            // SimulateInput(i, 18, 101, 451, 0, 0);
            SimulateInput(i, 18, 101, 21, 0, 0);
            SimulateInput(i, 22, 101, 21, 0, 0);
            SimulateInput(i, 26, 101, 201, 0, 0);
            SimulateInput(i, 30, 101, 251, 0, 0);
            SimulateInput(i, 34, 101, 201, 0, 0);
            SimulateInput(i, 38, 101, 251, 0, 0);
            // SimulateInput(i, 26, 101, 301, 0, 0);
            // if(i==29){
            //     lastGameInput.tempNewInput(InputType.SLIDE, (int)10, (int)100, (int)20, (int)150);
            // }
            // SimulateInput(i, 32, 101, 351, 0, 0);
            // SimulateInput(i, 36, 101, 551, 0, 0);
            // SimulateInput(i, 26, 101, 21, 0, 0);

			try {
				TimeUnit.MILLISECONDS.sleep(PERIOD_ONE_UPDATE-timeSinceLastUpdate); // TODO : est ce vraiment necessaire, apres ca peut permettre aux autre thread d'avancer
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			timeSinceLastUpdate =  System.currentTimeMillis() - lastTimeUpdate;
			i++;
		}
	}
	
	public void SimulateInput(int i, int fi, int x, int y, int fx, int fy) {
	    if(i == fi) {
			lastGameInput.tempNewInput(InputType.PRESS, x, y, fx, fy);
		}
		
		if(i == (fi+2)) {
			lastGameInput.tempNewInput(InputType.UNPRESS, x, y, fx, fy);
		}
	}

	public void InputUpdate() {
		if(lastGameInput.GetIsNewInput()) {
			for(GameMenu menu : menuArray) {
				menu.InputUpdate(lastGameInput);
			}
			
			for(GameMenu building : buildingArray){
			    building.InputUpdate(lastGameInput);
			}

			lastGameInput.SetIsNewInput(false);
		}

		if((GetMenu("town").GetIsActive()) && (timeToActiveAnEvent())) {	// TDO : akouter peut etre un delay pour pas avoir le cas ou le joueur est dans un bat et ca va a l'event sans passer par town
			((GameMenuRessources)GetMenu("ressources")).RessourceThresholdEvent();
			activateEvent();
		}
		
		// TODO : On incremante le temps si le temps est bon alors on met l'un des evenelent a actif et quand le menu town sera activer alors
		// l'event apparait a l'ecran et le joueur doit faire un choix, ca met inactif le menu town et ca le remet actif apres, si il y a trop de
		// ressource alors declanche un event de limitation

		// TODO : Aussi mettre ici l'incrementation du GOD menu
	}

	public void OutputUpdate() { // TODO : peut etre ajouter une verif si quelque chose a bouge pour ne pas refresh pour r, peut etre chiant pour faire des anim
		for(GameMenu building : buildingArray){
		    building.OutputUpdate();
		}

		for(GameMenu event : eventArray) {
			event.OutputUpdate();
		}

		for(GameMenu menu : menuArray) {
			menu.OutputUpdate();
		}
		
	}

	// PRIVATE FUNCTION ////////////////////////////////////////////////////////

	private boolean timeToActiveAnEvent() {
		if(((lastTimeEvent+TIME_BITWEEN_EVENT) < System.currentTimeMillis()) &&
			(GetMenu("town").GetLastTimeActivated() < System.currentTimeMillis())) {
			return true;
		}
		else {
			return false;
		}
	}

	private void deletOneShotEvent() {
		int i=0;

		while (i<eventArray.size()) {
			GameMenuEvent event = (GameMenuEvent) eventArray.get(i);
			
			if(event.GetOneShot()){
				eventArray.remove(i);
				i--;
			}

			i++;
		}
	}

	private void activateEvent() {
		GameMenuEvent event = (GameMenuEvent) eventArray.get(indexEventArray);

		if(event.isConditionOk()) {		// TODO : verifier les evenement a condition limite
			lastTimeEvent = System.currentTimeMillis();
			SetAllMenuIsActive(false);
			SetMenuIsActive("ressources", true);
			SetEventIsActive(indexEventArray, true);
		}

		indexEventArray++;

		if(indexEventArray == eventArray.size()) {
			indexEventArray = 0;
			deletOneShotEvent();
			Collections.shuffle(eventArray);
		}
	}


	// GETTER AND SETTER ///////////////////////////////////////////////////////

	public void SetIsGameOn(boolean _isGameOn) {
		isGameOn = _isGameOn;
	}

	public boolean GetIsGameOn() {
		return isGameOn;
	}
	
	public boolean GetIsInFrench() {
	    return isInFrench;
	}
	
	public boolean GetIsInEnglish() {
	    return isInEnglish;
	}
	
	public boolean GetSoundOn() {
	    return soundOn;
	}

	public GameMenu GetMenuArray(int _i) {
		return menuArray.get(_i);
	}

	public int GetEventArraySize() {
		return eventArray.size();
	}

	public void AddMenuArray(GameMenu _newMenu) {
		menuArray.add(_newMenu);
	}

	public void AddEventArray(GameMenu _event, int _i) {
		eventArray.add(_i, _event);
	}

	public void RemoveEventArray(int _i) {
		eventArray.remove(_i);
	}

	public long GetLastTimeUpdate() {
		return lastTimeUpdate;
	}

	public long GetLastTimeEvent() {
		return lastTimeEvent;
	}

	public String GetTheGameFilePath() {
		return theGameFilePathe;
	}

	public GameInput GetLastGameInput() {
		return lastGameInput;
	}
	
	public GameMenu GetMenu(String _name) {
		GameMenu returnMenu = null;
		
		for(GameMenu menu : menuArray) {
		    if(menu.GetName().equals(_name)) {
		        returnMenu = menu;
		    }
		}
		
		return returnMenu;
	}
	
	public GameMenu GetBuilding(String _name) {
		GameMenu returnBuilding = null;
		
		for(GameMenu building : buildingArray) {
		    if(building.GetName().equals(_name)) {
		        returnBuilding = building;
		    }
		}
		
		return returnBuilding;
	}
	
	public GameMenu GetBuilding(int _i) {
		if(_i < buildingArray.size()) {
	        return buildingArray.get(_i);
		}
		
		return null;
	}
	
	public GameMenu GetEvent(String _name) {
		GameMenu returnEvent = null;
		
		for(GameMenu event : eventArray) {
		    if(event.GetName().equals(_name)) {
		        returnEvent = event;
		    }
		}
		
		return returnEvent;
	}
	
	public GameMenu GetEvent(int _i) {
		if(_i < eventArray.size()) {
	        return eventArray.get(_i);
		}
		
		return null;
	}

	public int GetIndexEventArray() {
		return indexEventArray;
	}

	public GameMenuGodChoice.GodsNames GetWorshipedGod() {
		return worshipedGod;
	}

	public void SetMenuIsActive(String _name, boolean _isActive) {
		for(GameMenu menu : menuArray) {
			if(menu.GetName().equals(_name)) {
				menu.SetIsActive(_isActive);
			}
		}
	}

	public void SetEventIsActive(String _name, boolean _isActive) {
		for(GameMenu event : eventArray) {
			if(event.GetName().equals(_name)) {
				event.SetIsActive(_isActive);
			}
		}
	}
	
	public void SetEventIsActive(int _i, boolean _isActive) {
		eventArray.get(_i).SetIsActive(_isActive);
	}
	
	public void SetBuildingMenuIsActive(int _i, boolean _isActive) {
		buildingArray.get(_i).SetIsActive(_isActive);
	}

	public void SetAllMenuIsActive(boolean _isActive) {
		for(GameMenu menu : menuArray) {
			menu.SetIsActive(_isActive);
		}
		
		for(GameMenu menu : buildingArray){
		    menu.SetIsActive(_isActive);
		}
	}
	
	public void ResetBuildingArray(){
	    buildingArray = new ArrayList<>();
	}
	
	public void AddBuilding(String _name){
	    buildingArray.add(new GameMenuBuilding(_name, this));
	}
	
	public void SetIsInFrench(boolean _isInFrench) {
	    isInFrench = _isInFrench;
	}
	
	public void SetIsInEnglish(boolean _isInEnglish) {
	    isInEnglish = _isInEnglish;
	}
	
	public void SetSoundOn(boolean _soundOn) {
	    soundOn = _soundOn;
	}

	public void SetWorshipedGod(GameMenuGodChoice.GodsNames _worshipedGod) {
		worshipedGod = _worshipedGod;
	}

	public void SetLastTimeEvent(long _lastTimeEvent) {
		lastTimeEvent = _lastTimeEvent;
	}

	public void SetIsInquisitionActive(boolean _isInquisitionActive) {
		isInquisitionActive = _isInquisitionActive;
	}

	public void SetIndexEventArray(int _indexEventArray) {
		if(_indexEventArray > 0) {
			indexEventArray = _indexEventArray;
		}
		else {
			indexEventArray = 0;
		}
	}
}