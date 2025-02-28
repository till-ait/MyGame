import java.util.ArrayList;

public class GameMenuEvent extends GameMenu {

	// CLASS VARIABLES /////////////////////////////////////////////////////////

    protected int goldCondition;    // bien mettre dans les condition le minimu requi
    protected int cultistCondition;
    protected int knowlegeCondition;
    protected int suspicionCondition;
    protected int relicCondition;

	// STATIC VARIABLES ////////////////////////////////////////////////////////
    
    public static final int FILE_POSITION_CONDITION_GOLD = 10;
    public static final int FILE_POSITION_CONDITION_CULTIST = 11;
    public static final int FILE_POSITION_CONDITION_KNOWLEGE = 12;
    public static final int FILE_POSITION_CONDITION_SUSPICION = 13;
    public static final int FILE_POSITION_CONDITION_RELIC = 14;

	// CONSTRUCTOR /////////////////////////////////////////////////////////////

	public GameMenuEvent(String _name, TheGame _game) { // TODO : faire la composition aleatoir de la ville
// 		super(_name, _game); // Bas nn du coup faut le remplir de game
        super();
        name = _name;
		game = _game;
		buttonArray = new ArrayList<>();
		
		InitFromeFile();
		
		// TODO : SetBackgroudFromFile(_name);
		// TODO : SetSoundFromFile(_name);
	}

	// OVERRIDE ////////////////////////////////////////////////////////////////
    

    //////////////////////////////// RIEN EST FAIT POUR L'INSATANT JUST RECUP LE CODE DE BUILDING


    @Override
    public void InitFromeFile() {
		super.InitFromeFile();
        
        int i=0;
        ArrayList<String> datas = new ArrayList<>();
		FileReading dataFile = new FileReading(name + ".txt");
		
		dataFile.ReadDataFromFile(datas, FILE_LINE_MENU_DATA);

        goldCondition = Integer.parseInt(datas.get(FILE_POSITION_CONDITION_GOLD));
        cultistCondition = Integer.parseInt(datas.get(FILE_POSITION_CONDITION_CULTIST));
        knowlegeCondition = Integer.parseInt(datas.get(FILE_POSITION_CONDITION_KNOWLEGE));
        suspicionCondition = Integer.parseInt(datas.get(FILE_POSITION_CONDITION_SUSPICION));
        relicCondition = Integer.parseInt(datas.get(FILE_POSITION_CONDITION_RELIC));
		
		// TODO : SetBackgroudFromFile(_name);
		// TODO : SetSoundFromFile(_name);
	}

    // GETTER AND SETTER ///////////////////////////////////////////////////////

    public int GetGoldCondition(){
        return goldCondition;
    }

    public int GetCultistCondition(){
        return cultistCondition;
    }

    public int GetKnowlegeCondition(){
        return knowlegeCondition;
    }

    public int GetSuspicionCondition(){
        return suspicionCondition;
    }

    public int GetRelicCondition(){
        return relicCondition;
    }
}