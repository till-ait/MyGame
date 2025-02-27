import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TheGame {

	// CLASS VARIABLE //////////////////////////////////////////////////////////

	protected boolean isGameOn;
	protected ArrayList<GameMenu> menuArray;
	protected ArrayList<GameMenu> buildingArray;    // TODO : il faut que quand on fasse nouvelle partie ou jouer l'array soit remplie des batiments pour cette game
	protected long lastTimeUpdate;
	protected GameInput lastGameInput;

	protected long screenLengthX; // les distance sont proportionel a ces vairable
	protected long screenLengthY;
	
	protected boolean isInFrench;
	protected boolean isInEnglish;
	protected boolean soundOn;

	protected String theGameFilePathe;

	// STATIC VARIABLE /////////////////////////////////////////////////////////

	public static final int PERIOD_ONE_UPDATE = 33;
	public static final int FILE_FIRST_LINE = 0;
	public static final int FILE_POSITION_MENU_TYPE = 0;

	// CONSTRUCTEUR /////////////////////////////////////////////////////////////
	public TheGame() {
		isGameOn = true;
		menuArray = new ArrayList<>();
		buildingArray = new ArrayList<>();
		lastTimeUpdate = System.currentTimeMillis();
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
		
		for(String menuName : datasfirstLine) {
		    i++;
		    dataFile.ReadDataFromFile(datas, FILE_FIRST_LINE+i);
			
			if(datas.get(FILE_POSITION_MENU_TYPE).equals("regular")){
			    menuArray.add(new GameMenu(menuName, this));    // TODO : faire ne sorte que le fichier definisse si c'est un nomral ou un 
			}
			if(datas.get(FILE_POSITION_MENU_TYPE).equals("town")){
			    menuArray.add(new GameMenuTown(menuName, this));    // TODO : Le town ne connait pas ce qu'il y a en lui, il sait juste qu'il y a 8 button et chacun de ses button va taper dans 
			}
			if(datas.get(FILE_POSITION_MENU_TYPE).equals("ressources")){
			    menuArray.add(new GameMenuRessources(menuName, this,
			                                         Integer.parseInt(datas.get(1)),
			                                         Integer.parseInt(datas.get(2)),
			                                         Integer.parseInt(datas.get(3)),
			                                         Integer.parseInt(datas.get(4)),
			                                         Integer.parseInt(datas.get(5))));
			}
		}
	}

	// UPDATE //////////////////////////////////////////////////////////////////

	public void GameRun() {
		int i=0;
		long timeSinceLastUpdate = 0;

		while(isGameOn) {
			InputUpdate();
			OutputUpdate();

			lastTimeUpdate = System.currentTimeMillis();

			if(i==50) { // a supprimer
				isGameOn = false;
			}

            SimulateInput(i, 2, 11, 221, 0, 0);
            SimulateInput(i, 6, 101, 121, 0, 0);
            SimulateInput(i, 10, 101, 121, 0, 0);
            SimulateInput(i, 14, 101, 551, 0, 0);
            SimulateInput(i, 18, 101, 451, 0, 0);
            SimulateInput(i, 24, 101, 21, 0, 0);
            if(i==29){
                lastGameInput.tempNewInput(InputType.SLIDE, (short)10, (short)100, (short)20, (short)150);
            }
            SimulateInput(i, 32, 101, 351, 0, 0);
            SimulateInput(i, 36, 101, 551, 0, 0);
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
			lastGameInput.tempNewInput(InputType.PRESS, (short)x, (short)y, (short)fx, (short)fy);
		}
		
		if(i == (fi+2)) {
			lastGameInput.tempNewInput(InputType.UNPRESS, (short)x, (short)y, (short)fx, (short)fy);
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

			lastGameInput.SetIsNewInput(false); // l'update a ete faite donc plus new
		}
		
		// TODO : ajouter ici le
	}

	public void OutputUpdate() { // TODO : peut etre ajouter une verif si quelque chose a bouge pour ne pas refresh pour r, peut etre chiant pour faire des anim
		for(GameMenu menu : menuArray) {
			menu.OutputUpdate();
		}
		
		for(GameMenu building : buildingArray){
		    building.OutputUpdate();
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

	public void AddMenuArray(GameMenu _newMenu) {
		menuArray.add(_newMenu);
	}

	public long GetLastTimeUpdate() {
		return lastTimeUpdate;
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

	public void SetMenuIsActive(String _name, boolean _isActive) {
		for(GameMenu menu : menuArray) {
			if(menu.GetName().equals(_name)) {
				menu.SetIsActive(_isActive);
			}
		}
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
}






