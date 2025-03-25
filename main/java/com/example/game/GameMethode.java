package com.example.game;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class GameMethode {
    
	public static void Activate(String _methodeName, MainActivity _game, GameMenu _menu, GameButton _button) {
		switch(_methodeName) {
		case "principaleBt0":
		case "winBt0":
		case "winEventBt0":
		case "loseBt0":
			NewRun(_game);
			break;
		case "principaleBt1":	// Setting
			// GoSettingMenu(_game);
			GoMenu("setting", _game);
			break;
		case "principaleBt2":	// tuto
			// GoToTutorial(_game);
			GoMenu("tuto", _game);
			break;
		case "principaleBt3":	// credits
			// PrincipaleBt2(_game);
			GoMenu("credit", _game);
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
		case "winBt1":
		case "winEventBt1":
		case "loseBt1":
		case "tutoBt0":
		case "creditBt0":
			// GoMainMenu(_game);
			GoMenu("principale", _game);
			break;
		case "ressourcesBt0":	// pause
			// GoPauseMenu(_game);
			GoMenu("pause", _game);
			break;
		case "ressourcesBt1":
			GoMenuWithRessources("godsQuest", _game);
			break;
		case "pauseBt1":		// setting, TODO : attention peut etre faire deux menu stting parceque la on ne revien pas au menu principale mais au precedent
			// TODO : active le menu setting
			break;
		case "pauseBt2":
		case "gateEventBt2":
		case "prisonEventBt2":
			GoMenu("lose", _game);
			break;
		case "godsChoiceBt0":
			godsChoiceBt(_game, GameMenuGodChoice.GodsNames.Ifrak);
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
			// TODO : ajout du dieux aleatoir ??? est ce qu'il ne serai pas infinie, genre tu peux ne pas t'arreter un peut comme balatrot
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
			TownBt(_game, 5);	// TODO : faire en sorte qu'il y es un message qui apparai si on peut pas l'ouvrire
		    break;
		case "townBt6":			// open Bat 6 in building array
			TownBt(_game, 6);
		    break;
		case "townBt7":			// open Bat 7 in building array
			TownBt(_game, 7);
		    break;
		case "pauseBt0":		// go back town, il y a aussi tout les autres bouton qui permettent de revenir a la ville
		case "housesBt0":
		case "factoryBt0":
		case "marketBt0":
		case "theatreBt0":
		case "templeBt0":
		case "libraryBt0":
		case "constructionSiteBt0":
		case "catacombsBt0":
		case "rivalCultBt0":
		case "alchemistBt0":
		case "prisonBt0":
		case "inquisitionBt0":
		case "gateBt0":
		case "roadBt0":
		case "docksBt0":
		case "castleBt0":
		case "godsQuestBt0":
		    GoMenuWithRessources("town",_game);
		    break;
		case "housesBt1":		// houses choice 1, il y a aussi tous les autre choix de bouton qui implique juste un echange de ressources
		case "housesBt2":		// houses choice 2
		case "housesBt4":		// houses choice 3
		case "factoryBt1":
		case "factoryBt3":
		case "factoryBt4":
		case "marketBt1":
		case "marketBt2":
		case "marketBt4":
		case "marketBt5":
		case "theatreBt1":
		case "theatreBt2":
		case "theatreBt4":
		case "theatreBt5":
		case "templeBt1":
		case "templeBt2":
		case "templeBt4":
		case "libraryBt1":
		case "libraryBt2":
		case "libraryBt4":
		case "libraryBt5":
		case "constructionSiteBt1":
		case "catacombsBt1":
		case "catacombsBt3":
		case "catacombsBt4":
		case "rivalCultBt1":
		case "rivalCultBt2":
		case "rivalCultBt6":
		case "alchemistBt1":
		case "alchemistBt3":
		case "alchemistBt5":
		case "prisonBt2":
		case "prisonBt4":
		case "inquisitionBt2":
		case "inquisitionBt4":
		case "gateBt4":
		case "gateBt7":
		case "docksBt1":
		case "docksBt2":
		case "docksBt3":
		case "gateEventBt0":
		case "gateEventBt1":
		case "prisonEventBt0":
		case "prisonEventBt1":
		case "plagEventBt0":
		case "plagEventBt1":
		case "fireEventBt0":
		case "fireEventBt1":
		case "newMembersEventBt0":
		case "newMembersEventBt1":
		case "visionsEventBt0":
		case "visionsEventBt1":
		case "helpPoorsEventBt0":
		case "helpPoorsEventBt1":
		case "godsWrathEventBt0":
		case "godsWrathEventBt1":
		case "godsBlessEventBt0":
		case "godsBlessEventBt1":
		case "rumorsEventBt0":
		case "rumorsEventBt1":
		    BtChoice(_game, _menu, _button);
		    break;
		case "housesBt3":		// inflitration, il y a aussi tous les autres choix de bouton qui permette d'augmenter l'index du menu
		case "factoryBt2":
		case "marketBt3":
		case "theatreBt3":
		case "templeBt3":
		case "libraryBt3":
		case "constructionSiteBt2":
		case "constructionSiteBt3":
		case "catacombsBt2":
		case "rivalCultBt3":
		case "rivalCultBt4":
		case "alchemistBt2":
		case "alchemistBt4":
		case "prisonBt1":
		case "prisonBt3":
		case "inquisitionBt1":
		case "inquisitionBt3":
		case "gateBt3":
		case "gateBt6":
		case "godsQuestBt1":	// all gods quest bt are called Bt1 exepte the 0.
			BtIncresIndex(_game, _menu, _button);
			break;
		case "housesBt5":		// sacrify infiltrated, il y a aussi tous les autres choix de bouton qui permettent de diminuer l'index du menu
		case "factoryBt5":
		case "marketBt6":
		case "theatreBt6":
		case "templeBt5":
		case "libraryBt6":
		case "rivalCultBt5":
			BtIndexe0(_game, _menu, _button);
			break;
		case "prisonBt5":
			Btsus0(_game, _menu, _button);
			break;
		case "inquisitionBt5":
			BtStopInquisition(_game, _menu, _button);
			break;
		case "gateBt1":
		case "gateBt2":
		case "gateBt5":
		case "gateBt8":
			BtOpenGate(_game, _menu, _button);
			break;
		case "roadBt1":
			BtAleatoryRessource(_game, _menu, _button);
			break;
		default:
			System.out.println("Undefine bp");
			break;
		}
	}

	public static void NewRun(MainActivity _game) {
	    initBuildings(_game);
		_game.SetLastTimeEvent(System.currentTimeMillis());
		_game.SetAllMenuIsActive(false);
		GoMenu("godsChoice", _game);
	}

	public static void SettingBt0(MainActivity _game) {
		System.out.println("sound off");
		_game.SetSoundOn(false);
	}
	
	public static void SettingBt0Toggle(MainActivity _game) {
		System.out.println("sound on");
		_game.SetSoundOn(true);
	}

	public static void SettingBt1(MainActivity _game) {
		System.out.println("langue anglaise");
		_game.SetIsInEnglish(true);
		_game.SetIsInFrench(false);
	}

	public static void SettingBt1Toggle(MainActivity _game) {
		System.out.println("langue francaise");
		_game.SetIsInEnglish(false);
		_game.SetIsInFrench(true);
	}

	public static void SettingBt2(MainActivity _game) {
		System.out.println("reset progression");
	}

	public static void TownBt(MainActivity _game, int i) {
		if((_game.GetBuilding("gate")==null) || (_game.GetIsGateOpened()) || (i<5)){ // si la gate n'est pas en ville ou qu'elle est ouverte alors on peut ouvrir le bate, ou que c'est un bat avant la porte
			_game.SetAllMenuIsActive(false);
			_game.SetMenuIsActive("ressources", true);
			_game.SetBuildingMenuIsActive(i, true);
		}
	}

	public static void GoMenu(String _menuName, MainActivity _game) {
		_game.SetAllMenuIsActive(false);
		_game.SetMenuIsActive(_menuName, true);
	}

	public static void GoMenuWithRessources(String _menuName, MainActivity _game) {
		GoMenu(_menuName, _game);
		_game.SetMenuIsActive("ressources", true);
	}
	
	public static void BtChoice(MainActivity _game, GameMenu _menu, GameButton _button) {
	    if((_button instanceof GameButtonChoice)){
	        GameButtonChoice choiceButton = (GameButtonChoice) _button;
	        
	        if(isRessourcesEnouth(_game, choiceButton)){
	        	if(_menu instanceof GameMenuBuilding) {
					GameMenuBuilding builduingMenu = (GameMenuBuilding) _menu;
					builduingMenu.SetTimeToReload(choiceButton.GetTimeToReload());
					builduingMenu.SetLastTimeUsed(System.currentTimeMillis());
				}
	            
	            applieCost(_game, choiceButton);
	            applieReward(_game, choiceButton);
        	    GoMenuWithRessources("town", _game);
	        }
			else {
				System.out.println("Pas assez de ressources");
			}
			// TODO : faire quelque chose pour que le joeur sache qu'il n'a pas assez de ressources
	    }
	}

	public static void BtIncresIndex(MainActivity _game, GameMenu _menu, GameButton _button) {	// TODO : mettre une verification qu'on ai pas attein le level max d'infiltration
		if((_button instanceof GameButtonChoice)){
	        GameButtonChoice choiceButton = (GameButtonChoice) _button;
	        
	        if(isRessourcesEnouth(_game, choiceButton)){
	        	if(_menu instanceof GameMenuBuilding) {
					GameMenuBuilding builduingMenu = (GameMenuBuilding) _menu;
					builduingMenu.SetTimeToReload(choiceButton.GetTimeToReload());
					builduingMenu.SetLastTimeUsed(System.currentTimeMillis());
				}
	            applieCost(_game, choiceButton);
	            applieReward(_game, choiceButton);
        	    GoMenuWithRessources("town", _game);
				_menu.SetIndexLevel((int)(_menu.GetIndexLevel()+1));	// keep it last, if not creat a bug in godsQuest, it doesn't unactive the bp
	        }
			// TODO : faire quelque chose pour que le joeur sache qu'il n'a pas assez de ressources
	    }
	}
	
	public static void BtIndexe0(MainActivity _game, GameMenu _menu, GameButton _button) {
		if((_button instanceof GameButtonChoice)){
	        GameButtonChoice choiceButton = (GameButtonChoice) _button;
	        
	        if(isRessourcesEnouth(_game, choiceButton)){
	        	if(_menu instanceof GameMenuBuilding) {
					GameMenuBuilding builduingMenu = (GameMenuBuilding) _menu;
					builduingMenu.SetTimeToReload(choiceButton.GetTimeToReload());
					builduingMenu.SetLastTimeUsed(System.currentTimeMillis());
				}
	            applieCost(_game, choiceButton);
	            applieReward(_game, choiceButton);
        	    GoMenuWithRessources("town", _game);
				_menu.SetIndexLevel((int)(0));	// TODO : ou mettre 0, je ne sais pas encore si on peut infiltrer plusieur fois, attention y a aussi les gods quest
	        }

			// TODO : faire quelque chose pour que le joeur sache qu'il n'a pas assez de ressources
	    }
	}
	
	public static void BtDecreseIndex(MainActivity _game, GameMenu _menu, GameButton _button) {
		if((_button instanceof GameButtonChoice)){
	        GameButtonChoice choiceButton = (GameButtonChoice) _button;
	        
	        if(isRessourcesEnouth(_game, choiceButton)){
	        	if(_menu instanceof GameMenuBuilding) {
					GameMenuBuilding builduingMenu = (GameMenuBuilding) _menu;
					builduingMenu.SetTimeToReload(choiceButton.GetTimeToReload());
					builduingMenu.SetLastTimeUsed(System.currentTimeMillis());
				}
	            applieCost(_game, choiceButton);
	            applieReward(_game, choiceButton);
        	    GoMenuWithRessources("town", _game);
				_menu.SetIndexLevel((int)(_menu.GetIndexLevel()-1));	// TODO : ou mettre 0, je ne sais pas encore si on peut infiltrer plusieur fois, attention y a aussi les gods quest
	        }
			// TODO : faire quelque chose pour que le joeur sache qu'il n'a pas assez de ressources
	    }
	}

	public static void godsChoiceBt(MainActivity _game, GameMenuGodChoice.GodsNames _god) {
		_game.SetWorshipedGod(_god);
		GoMenuWithRessources("town",_game);
	}

	public static void BtAleatoryRessource(MainActivity _game, GameMenu _menu, GameButton _button) {
		if((_button instanceof GameButtonChoice)){
	        GameButtonChoice choiceButton = (GameButtonChoice) _button;
	        
	        if(isRessourcesEnouth(_game, choiceButton)){
	        	if(_menu instanceof GameMenuBuilding) {
					GameMenuBuilding builduingMenu = (GameMenuBuilding) _menu;
					builduingMenu.SetTimeToReload(choiceButton.GetTimeToReload());
					builduingMenu.SetLastTimeUsed(System.currentTimeMillis());
				}
	            
	            applieCost(_game, choiceButton);
	            applieAleatoryReward(_game);
        	    GoMenuWithRessources("town", _game);
	        }
			else {
				System.out.println("Pas assez de ressources");
			}
			// TODO : faire quelque chose pour que le joeur sache qu'il n'a pas assez de ressources
	    }
	}

	public static void Btsus0(MainActivity _game, GameMenu _menu, GameButton _button) {
		GameMenuRessources ressources = (GameMenuRessources) _game.GetMenu("ressources");

		BtIndexe0(_game, _menu, _button);
		ressources.SetSuspicion(0);
	}

	public static void BtStopInquisition(MainActivity _game, GameMenu _menu, GameButton _button) {
		int i = 0;
		
		BtIndexe0(_game, _menu, _button);

		_game.SetIsInquisitionActive(false);

		while(i<_game.GetEventArraySize()) {
			GameMenuEvent event = (GameMenuEvent) _game.GetEvent(i);

			if(event.GetName().equals("inquisitionEvent")) {
				_game.RemoveEventArray(i);
				i--;
			}
			
			i++;
		}
		Btsus0(_game, _menu, _button);
	}

	public static void BtOpenGate(MainActivity _game, GameMenu _menu, GameButton _button) {
		GameButtonChoice choiceButton = (GameButtonChoice) _button;
		
		if(isRessourcesEnouth(_game, choiceButton)) {
			// addEvent(_game, "gateClosedEvent", _game.GetIndexEventArray()+1); // TODO : peut etre faire un event custom par facon d'ouvrire la porte
			BtChoice(_game, _menu, _button);
			_game.SetLastTimeGateOpen(System.currentTimeMillis());
		}
	}

	// public static void addEvent(MainActivity _game, String _name, int _i) {
	// 	// TODO : cree l'evenement et le met dans l'array de game, i est l'offset d'event avant celui ci
	// }

	// PRIVATE /////////////////////////////////////////////////////////////////
	
	private static void initBuildings(MainActivity _game){
	    _game.ResetBuildingArray();
	    
		List<String> ressourcesBuildings = Arrays.asList("houses", "factory", "library", "market", "temple", "theatre");
		List<String> interactionBuildings = Arrays.asList("alchemist", "catacombs", "constructionSite", "rivalCult");
		List<String> exchangeBuildings = Arrays.asList("road", "docks");
		List<String> militaryBuildings = Arrays.asList("gate", "prison", "inquisition");
		ArrayList<String> shuffledBuildings = new ArrayList<>();

		Collections.shuffle(ressourcesBuildings);
		Collections.shuffle(interactionBuildings);

		shuffledBuildings.add(ressourcesBuildings.get(0));
		shuffledBuildings.add(ressourcesBuildings.get(1));
		shuffledBuildings.add(ressourcesBuildings.get(2));
		shuffledBuildings.add(ressourcesBuildings.get(3));	// TODO : a enlever si on ajoute le caslte, car on avait dit 3 bat de ressource et j'en ai ajouter un la en attendant le castle
		shuffledBuildings.add(interactionBuildings.get(0));
		shuffledBuildings.add(interactionBuildings.get(1));
		
		Collections.shuffle(exchangeBuildings);
		Collections.shuffle(militaryBuildings);
		Collections.shuffle(shuffledBuildings);

		System.out.println("Batiment ajouter a la ville : " + exchangeBuildings.get(0));
	    _game.AddBuilding(exchangeBuildings.get(0));
		System.out.println("Batiment ajouter a la ville : " + shuffledBuildings.get(0));
	    _game.AddBuilding(shuffledBuildings.get(0));
		System.out.println("Batiment ajouter a la ville : " + shuffledBuildings.get(1));
	    _game.AddBuilding(shuffledBuildings.get(1));
		System.out.println("Batiment ajouter a la ville : " + shuffledBuildings.get(2));
	    _game.AddBuilding(shuffledBuildings.get(2));
		System.out.println("Batiment ajouter a la ville : " + militaryBuildings.get(0));
	    _game.AddBuilding(militaryBuildings.get(0));
		System.out.println("Batiment ajouter a la ville : " + shuffledBuildings.get(3));
	    _game.AddBuilding(shuffledBuildings.get(3));
		System.out.println("Batiment ajouter a la ville : " + shuffledBuildings.get(4));
	    _game.AddBuilding(shuffledBuildings.get(4));
		System.out.println("Batiment ajouter a la ville : " + shuffledBuildings.get(5));
	    _game.AddBuilding(shuffledBuildings.get(5));	// TODO : mettre le castle a la place


	    // TODO : faire toute la partie init aleatoir a chaque partie
		// TODO : il faut aussi modifier les image associer au bt de town en fonction des batiments
	}
	
	private static boolean isRessourcesEnouth(MainActivity _game, GameButtonChoice button) {
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

		if((!ressources.GetARitualPlace())&&(button.GetRitualPlaceCost())) {
			result = false;
		}
	    
	    return result;
	}
	
	private static void applieCost(MainActivity _game, GameButtonChoice button) {
	    GameMenuRessources ressources = (GameMenuRessources) _game.GetMenu("ressources");
	    
	    ressources.SetGold(ressources.GetGold() - button.GetGoldCost());
	    ressources.SetCultist(ressources.GetCultist() - button.GetCultistCost());
	    ressources.SetKnowlege(ressources.GetKnowlege() - button.GetKnowlegeCost());
	    ressources.SetSuspicion(ressources.GetSuspicion() - button.GetSuspicionCost());
	    ressources.SetRelic(ressources.GetRelic() - button.GetRelicCost());
		if(button.GetRitualPlaceCost()) {
			ressources.SetARitualPlace(false);
		}
	}
	
	private static void applieReward(MainActivity _game, GameButtonChoice button) {
	    GameMenuRessources ressources = (GameMenuRessources) _game.GetMenu("ressources");
	    
	    ressources.SetGold(ressources.GetGold() + button.GetGoldReward());
	    ressources.SetCultist(ressources.GetCultist() + button.GetCultistReward());
	    ressources.SetKnowlege(ressources.GetKnowlege() + button.GetKnowlegeReward());
	    ressources.SetSuspicion(ressources.GetSuspicion() + button.GetSuspicionReward());
	    ressources.SetRelic(ressources.GetRelic() + button.GetRelicReward());
		if(button.GetRitualPlaceReward()) {
			ressources.SetARitualPlace(true);
		}
	}

	private static void applieAleatoryReward(MainActivity _game) {
		GameMenuRessources ressources = (GameMenuRessources) _game.GetMenu("ressources");
	    Random rand = new Random();

		switch(rand.nextInt(4)) {
		case 0:	
			ressources.SetGold((int)(ressources.GetGold() + 1));
			break;
		case 1:
			ressources.SetCultist((int)(ressources.GetCultist() + 1));
			break;
		case 2:
			ressources.SetKnowlege((int)(ressources.GetKnowlege() + 1));
			break;
		case 3:
			ressources.SetSuspicion((int)(ressources.GetSuspicion() + 1));
			break;
		default:
			break;
		}
	}
}