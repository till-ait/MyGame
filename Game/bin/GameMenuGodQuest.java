import java.util.ArrayList;

public class GameMenuGodQuest extends GameMenu {
    // TODO EST LE MENU DU DIEU IL Y AURA LES QUEST A ACCOMPLIR
    
    // VARIABLES ////////////////////////////////////////////

    // indiex i = l'avancement dans la quete, seul la quet d'indice correspondant est affiche.

    protected int questProgress;
    protected int timeToDoQuest;     // TODO : en ms, si il rest 10% du temps mettre le bouton pour voir la quete en rouge, Si le temps est fini declancher un evenement de colere des dieux, soit perdre un questProgress, soit perdre des ressource ou relic

    protected GameMenuGodChoice.GodsNames god;

    // STATIC VAIABLES //////////////////////////////////////

    protected static final int INIT_VALUE_QUESTPROGRESS = 1;        // 1 parceque le bp 0 c'est celui de retour
    protected static final int INIT_VALUE_TIMETODOQUEST = 60000;    // correspond a une minute.

    // CONSTRUCTOR //////////////////////////////////////////

    public GameMenuGodQuest(String _name, TheGame _game) {  // TODO name = nom du dieu
        super(_name, _game);

        questProgress = INIT_VALUE_QUESTPROGRESS;
        timeToDoQuest = INIT_VALUE_TIMETODOQUEST;
    }

    public void initGodsQuest() {
        int i=nbButton,godIndex=0;
        ArrayList<String> datas = new ArrayList<>();
        String[] splitQuestData;
        FileReading dataFile = new FileReading("dataGodsQuest.txt");
        dataFile.ReadDataFromFile(datas);

        godIndex = getGodPosition();

        splitQuestData = datas.get(godIndex+1).split("::");

        for(String questData : splitQuestData) {
            CreatChoiceButton(questData,i);
            // i++; // On ne veut pas incrementer la valeur de i si nn les bouton seron a des place differente, or nous on veut pas
        }
    }

    public int getGodPosition() {
        int result=0;

        switch(god) {
        case GameMenuGodChoice.GodsNames.Ifrak:
            result = 0;
            break;
        case GameMenuGodChoice.GodsNames.Yikouch:
            result = 2;
            break;
        case GameMenuGodChoice.GodsNames.Anzir:
            result = 4;
            break;
        case GameMenuGodChoice.GodsNames.Gurzal:
            result = 5;
            break;
        case GameMenuGodChoice.GodsNames.Mehal:
            result = 7;
            break;
        default :
            break;
        }

        return result;
    }

    protected void CreatChoiceButton(String _data, int _i) {
        String[] splitData = _data.split(",");
        int i=0;
        int lengthX=0, lengthY=0, goldCost=0, cultistCost=0, knowlegeCost=0, suspicionCost=0, relicCost=0,
        goldReward=0, cultistReward=0, knowlegeReward=0, suspicionReward=0, relicReward=0;
        boolean ritualPlaceCost = false, ritualPlaceReward=false;

        while (i < splitData.length) {
            switch(splitData[i]){
            case "lengthX":
                lengthX = Integer.parseInt(splitData[i+1]);
                break;
            case "lengthY":
                lengthY = Integer.parseInt(splitData[i+1]);
                break;
            case "goldCost":
                goldCost = Integer.parseInt(splitData[i+1]);
                break;
            case "cultistCost":
                cultistCost = Integer.parseInt(splitData[i+1]);
                break;
            case "knowlegeCost":
                knowlegeCost = Integer.parseInt(splitData[i+1]);
                break;
            case "suspicionCost":
                suspicionCost = Integer.parseInt(splitData[i+1]);
                break;
            case "relicCost":
                relicCost = Integer.parseInt(splitData[i+1]);
                break;
            case "goldReward":
                goldReward = Integer.parseInt(splitData[i+1]);
                break;
            case "cultistReward":
                cultistReward = Integer.parseInt(splitData[i+1]);
                break;
            case "knowlegeReward":
                knowlegeReward = Integer.parseInt(splitData[i+1]);
                break;
            case "suspicionReward":
                suspicionReward = Integer.parseInt(splitData[i+1]);
                break;
            case "relicReward":
                relicReward = Integer.parseInt(splitData[i+1]);
                break;
            case "ritualPlaceCost":
                ritualPlaceCost = Boolean.parseBoolean(splitData[i+1]);
                break;
            case "ritualPlaceReward":
                ritualPlaceReward = Boolean.parseBoolean(splitData[i+1]);
                break;
            default:
                break;
            }
            i = i + 2;
        }

        nbButton++;
        CreatChoiceButton(lengthX, lengthY, _i, goldCost,cultistCost,knowlegeCost,suspicionCost,relicCost,ritualPlaceCost,
                        goldReward,cultistReward,knowlegeReward,suspicionReward,relicReward,ritualPlaceReward,0);
    }

    // OVERRIDE ///////////////////////////////////////////////



    // GETTER AND SETTER ////////////////////////////////////

    @Override
    public int GetIndexLevel() {
        return questProgress;
    }

    @Override
    public void SetIndexLevel(int _indexLevel) {
        questProgress = _indexLevel;
    }

    @Override
    public void SetIsActive(boolean _isActive) {
        int i=0;
		isActive = _isActive;

        if(god != game.GetWorshipedGod()) {
            god = game.GetWorshipedGod();
            initGodsQuest();
        }

        buttonArray.get(0).SetIsActive(_isActive);  // le premier bt doit toujours etre actif pour permettre de quitter le menu
		for(GameButton button : buttonArray) {
		    if(i == questProgress){
			    button.SetIsActive(_isActive);
		    }

			i++;
		}
    }
}