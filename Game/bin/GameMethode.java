public class GameMethode {
    
	public static void Activate(String _methodeName, TheGame _game, GameMenu _menu, GameButton _button) {
		switch(_methodeName) {
		case "test1":
			test1();
			break;
		case "principaleBt0":	// New game
			PrincipaleBt0(_game);
			break;
		case "principaleBt1":	// Setting
			PrincipaleBt1(_game);
			break;
		case "principaleBt2":	// tuto
			// TODO : affiche le tutorial
			break;
		case "principaleBt3":	// credits
			PrincipaleBt2(_game);
			break;
		case "settingBt0":		// Sound off
			SettingBt0(_game);
			break;
		case "settingBt0Toggle":	// sond on
			SettingBt0Toggle(_game);
			break;
		case "settingBt1":		// french language
			SettingBt1(_game);
			break;
		case "settingBt1Toggle":	// english
			SettingBt1Toggle(_game);
			break;
		case "settingBt2":		// Reset progression
			SettingBt2(_game);
			break;
		case "settingBt3":		// Main menu
			SettingBt3(_game);
			break;
		case "ressourcesBt0":	// pause
			// TODO : active le menu pause
			break;
		case "ressourcesBt1":	// gods quest
			// TODO : active le menu gods quest
			break;
		case "pauseBt0":		// setting, TODO : attention peut etre faire deux menu stting parceque la on ne revien pas au menu principale mais au precedent
			// TODO : active le menu setting
			break;
		case "pauseBt1":		// tuto
			// TODO : affiche le tuto
			break;
		case "pauseBt2":		// abandon
			// TODO : active le menu principale, c'est l'abandon
			break;
		case "godsChoiceBt0":
			godsChoiceBt(_game, GameMenuGodChoice.GodsNames.Ifrak);		// TODO : set le dieux choisit et lance la game
			break;
		case "godsChoiceBt1":
			godsChoiceBt(_game, GameMenuGodChoice.GodsNames.Yikouch);
			break;
		case "godsChoiceBt2":
			godsChoiceBt(_game, GameMenuGodChoice.GodsNames.Anzir);
			break;
		case "godsChoiceBt3":
			godsChoiceBt(_game, GameMenuGodChoice.GodsNames.Gurzal);
			break;
		case "godsChoiceBt4":
			godsChoiceBt(_game, GameMenuGodChoice.GodsNames.Mehal);
			break;
		case "godsChoiceBt5":
			// TODO : ajout du dieux aleatoir ???
			break;
		case "townBt0":			// open Bat 0 in building array
		    TownBt(_game, 0);
		    break;
		case "townBt1":			// open Bat 1 in building array
		    TownBt(_game, 1);
		    break;
		case "townBt2":			// open Bat 2 in building array
		    TownBt(_game, 2);
		    break;
		case "townBt3":			// open Bat 3 in building array
		    TownBt(_game, 3);
		    break;
		case "townBt4":			// open Bat 4 in building array
		    TownBt(_game, 4);
		    break;
		case "townBt5":			// open Bat 5 in building array
		    TownBt(_game, 5);
		    break;
		case "townBt6":			// open Bat 6 in building array
		    TownBt(_game, 6);
		    break;
		case "townBt7":			// open Bat 7 in building array
		    TownBt(_game, 7);
		    break;
		case "housesBt0":		// go back town, il y a aussi tout les autres bouton qui permettent de revenir a la ville
		    GoBackTown(_game);
		    break;
		case "housesBt1":		// tripo choice 1, il y a aussi tous les autre choix de bouton qui implique juste un echange de ressources
		case "housesBt2":		// tripo choice 2
		case "housesBt4":		// tripo choice 3
		    BtChoice(_game, _menu, _button);
		    break;
		case "housesBt3":		// tripo inflitration, il y a aussi tous les autres choix de bouton qui permette d'augmenter l'index du menu
			BtIncresIndex(_game, _menu, _button);
			break;
		case "housesBt5":		// sacrify infiltrated, il y a aussi tous les autres choix de bouton qui permettent de diminuer l'index du menu
			BtDecreseIndex(_game, _menu, _button);
			break;
		default:
			break;
		}
	}

	public static void test1() {
		System.out.println("activate test 1");
	}

	public static void PrincipaleBt0(TheGame _game) {	// TODO : activer le choix de dieux puis lancement game, ca activera quel dieux est adore
	    initBuildings(_game);
		_game.SetAllMenuIsActive(false);
		_game.SetMenuIsActive("town", true);
		_game.SetMenuIsActive("ressources", true);
	}

	public static void PrincipaleBt1(TheGame _game) {
		_game.SetAllMenuIsActive(false);
		_game.SetMenuIsActive("setting", true);
	}

	public static void PrincipaleBt2(TheGame _game) {
		System.out.println("Affiche les credits");
	}

	public static void SettingBt0(TheGame _game) {
		System.out.println("sound off");
		_game.SetSoundOn(false);
	}
	
	public static void SettingBt0Toggle(TheGame _game) {
		System.out.println("sound on");
		_game.SetSoundOn(true);
	}

	public static void SettingBt1(TheGame _game) {
		System.out.println("langue anglaise");
		_game.SetIsInEnglish(true);
		_game.SetIsInFrench(false);
	}

	public static void SettingBt1Toggle(TheGame _game) {
		System.out.println("langue francaise");
		_game.SetIsInEnglish(false);
		_game.SetIsInFrench(true);
	}

	public static void SettingBt2(TheGame _game) {
		System.out.println("reset progression");
	}

	public static void SettingBt3(TheGame _game) {
		_game.SetAllMenuIsActive(false);
		_game.SetMenuIsActive("principale", true);
	}
	
	public static void TownBt(TheGame _game, int i) {
		_game.SetAllMenuIsActive(false);
		_game.SetMenuIsActive("ressources", true);
		_game.SetBuildingMenuIsActive(i, true);
	}
	
	public static void GoBackTown(TheGame _game) {
	    _game.SetAllMenuIsActive(false);
		_game.SetMenuIsActive("town", true);
		_game.SetMenuIsActive("ressources", true);

        // _game.GetBuilding(0).SetInfiltrationLevel((short) 1);	// TODO : passer par _menu, plus simple
	}
	
	public static void BtChoice(TheGame _game, GameMenu _menu, GameButton _button) {
	    if((_button instanceof GameButtonChoice) && (_menu instanceof GameMenuBuilding)){
	        GameButtonChoice choiceButton = (GameButtonChoice) _button;
	        GameMenuBuilding builduingMenu = (GameMenuBuilding) _menu;
	        
	        if(isRessourcesEnouth(_game, choiceButton)){
	            builduingMenu.SetTimeToReload(choiceButton.GetTimeToReload());
	            builduingMenu.SetLastTimeUsed(System.currentTimeMillis());
	            
	            applieCost(_game, choiceButton);
	            applieReward(_game, choiceButton);
        	    _game.SetAllMenuIsActive(false);
        		_game.SetMenuIsActive("town", true);
        		_game.SetMenuIsActive("ressources", true);
	        }
			// TODO : faire quelque chose pour que le joeur sache qu'il n'a pas assez de ressources
	    }
	}

	public static void BtIncresIndex(TheGame _game, GameMenu _menu, GameButton _button) {	// TODO : mettre une verification qu'on ai pas attein le level max d'infiltration
		if((_button instanceof GameButtonChoice) && (_menu instanceof GameMenuBuilding)){
	        GameButtonChoice choiceButton = (GameButtonChoice) _button;
	        GameMenuBuilding builduingMenu = (GameMenuBuilding) _menu;

	        if(isRessourcesEnouth(_game, choiceButton)){
	            builduingMenu.SetTimeToReload(choiceButton.GetTimeToReload());
	            builduingMenu.SetLastTimeUsed(System.currentTimeMillis());
	            
	            applieCost(_game, choiceButton);
	            applieReward(_game, choiceButton);
        	    _game.SetAllMenuIsActive(false);
        		_game.SetMenuIsActive("town", true);
        		_game.SetMenuIsActive("ressources", true);
				builduingMenu.SetIndexLevel((short)(builduingMenu.GetIndexLevel()+1));
	        }
			// TODO : faire quelque chose pour que le joeur sache qu'il n'a pas assez de ressources
	    }
	}
	
	public static void BtDecreseIndex(TheGame _game, GameMenu _menu, GameButton _button) {
		if((_button instanceof GameButtonChoice) && (_menu instanceof GameMenuBuilding)){
	        GameButtonChoice choiceButton = (GameButtonChoice) _button;
	        GameMenuBuilding builduingMenu = (GameMenuBuilding) _menu;

	        if(isRessourcesEnouth(_game, choiceButton)){
	            builduingMenu.SetTimeToReload(choiceButton.GetTimeToReload());
	            builduingMenu.SetLastTimeUsed(System.currentTimeMillis());
	            
	            applieCost(_game, choiceButton);
	            applieReward(_game, choiceButton);
        	    _game.SetAllMenuIsActive(false);
        		_game.SetMenuIsActive("town", true);
        		_game.SetMenuIsActive("ressources", true);
				builduingMenu.SetIndexLevel((short)(builduingMenu.GetIndexLevel()-1));	// TODO : ou mettre 0, je ne sais pas encore si on peut infiltrer plusieur fois, attention y a aussi les gods quest
	        }
			// TODO : faire quelque chose pour que le joeur sache qu'il n'a pas assez de ressources
	    }
	}

	// PRIVATE /////////////////////////////////////////////////////////////////
	
	private static void initBuildings(TheGame _game){
	    _game.ResetBuildingArray();
	    _game.AddBuilding("houses");
	    
	    // TODO : faire toute la partie init aleatoir a chaque partie
	}
	
	private static boolean isRessourcesEnouth(TheGame _game, GameButtonChoice button) {
	    boolean result = true;
	    GameMenuRessources ressources = (GameMenuRessources) _game.GetMenu("ressources");
	    
	    if(ressources.GetGold() < button.GetGoldCost()){
	        result = false;
	    }
	    
	    if(ressources.GetCultist() < button.GetCultistCost()){
	        result = false;
	    }
	    
	    if(ressources.GetKnowlege() < button.GetKnowlegeCost()){
	        result = false;
	    }
	    
	    if(ressources.GetSuspicion() < button.GetSuspicionCost()){
	        result = false;
	    }
	    
	    if(ressources.GetRelic() < button.GetRelicCost()){
	        result = false;
	    }
	    
	    return result;
	}
	
	private static void applieCost(TheGame _game, GameButtonChoice button) {
	    GameMenuRessources ressources = (GameMenuRessources) _game.GetMenu("ressources");
	    
	    ressources.SetGold(ressources.GetGold() - button.GetGoldCost());
	    ressources.SetCultist(ressources.GetCultist() - button.GetCultistCost());
	    ressources.SetKnowlege(ressources.GetKnowlege() - button.GetKnowlegeCost());
	    ressources.SetSuspicion(ressources.GetSuspicion() - button.GetSuspicionCost());
	    ressources.SetRelic(ressources.GetRelic() - button.GetRelicCost());
	}
	
	private static void applieReward(TheGame _game, GameButtonChoice button) {
	    GameMenuRessources ressources = (GameMenuRessources) _game.GetMenu("ressources");
	    
	    ressources.SetGold(ressources.GetGold() + button.GetGoldReward());
	    ressources.SetCultist(ressources.GetCultist() + button.GetCultistReward());
	    ressources.SetKnowlege(ressources.GetKnowlege() + button.GetKnowlegeReward());
	    ressources.SetSuspicion(ressources.GetSuspicion() + button.GetSuspicionReward());
	    ressources.SetRelic(ressources.GetRelic() + button.GetRelicReward());
	}
}