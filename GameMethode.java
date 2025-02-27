public class GameMethode {
    
    
    
	public static void Activate(String _methodeName, TheGame _game, GameMenu _menu, GameButton _button) {
		switch(_methodeName) {
		case "test1":
			test1();
			break;
		case "principaleBt0":
			PrincipaleBt0(_game);
			break;
		case "principaleBt1":
			PrincipaleBt1(_game);
			break;
		case "principaleBt2":
			PrincipaleBt2(_game);
			break;
		case "settingBt0":
			SettingBt0(_game);
			break;
		case "settingBt0Toggle":
			SettingBt0Toggle(_game);
			break;
		case "settingBt1":
			SettingBt1(_game);
			break;
		case "settingBt1Toggle":
			SettingBt1Toggle(_game);
			break;
		case "settingBt2":
			SettingBt2(_game);
			break;
		case "settingBt3":
			SettingBt3(_game);
			break;
		case "townBt0":
		    TownBt0(_game);
		    break;
		case "tripoBt0":
		    TripoBt0(_game);
		    break;
		case "tripoBt1":
		    TripoBt1(_game, _menu, _button);
		    break;
		default:
			break;
		}
	}

	public static void test1() {
		System.out.println("activate test 1");
	}

	public static void PrincipaleBt0(TheGame _game) { // peut etre mettre ici la generation de la composition de la ville
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
	
	public static void TownBt0(TheGame _game) {
		_game.SetAllMenuIsActive(false);
		_game.SetMenuIsActive("ressources", true);
		_game.SetBuildingMenuIsActive(0, true);
	}
	
	public static void TripoBt0(TheGame _game) {
	    _game.SetAllMenuIsActive(false);
		_game.SetMenuIsActive("town", true);
		_game.SetMenuIsActive("ressources", true);

        // _game.GetBuilding(0).SetInfiltrationLevel((short) 1);
	}
	
	public static void TripoBt1(TheGame _game, GameMenu _menu, GameButton _button) {
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
	    }
	}
	
	// PRIVATE /////////////////////////////////////////////////////////////////
	
	private static void initBuildings(TheGame _game){
	    _game.ResetBuildingArray();
	    _game.AddBuilding("tripo");
	    
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






















