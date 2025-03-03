

public class GameMenuGodQuest extends GameMenu {
    // TODO EST LE MENU DU DIEU IL Y AURA LES QUEST A ACCOMPLIR
    
    // VARIABLES ////////////////////////////////////////////

    // indiex i = l'avancement dans la quete, seul la quet d'indice correspondant est affiche.

    protected short questProgress;
    protected int timeToDoQuest;     // TODO : en ms, si il rest 10% du temps mettre le bouton pour voir la quete en rouge, Si le temps est fini declancher un evenement de colere des dieux, soit perdre un questProgress, soit perdre des ressource ou relic


    // STATIC VAIABLES //////////////////////////////////////

    protected static final int INIT_VALUE_TIMETODOQUEST = 60000;    // correspond a une minute.

    // CONSTRUCTOR //////////////////////////////////////////

    public GameMenuGodQuest(String _name, TheGame _game) {  // TODO name = nom du dieu
        super(_name, _game);

        questProgress = 0;
        timeToDoQuest = 60000;
    }

    // UPDATE ///////////////////////////////////////////////



    // GETTER AND SETTER ////////////////////////////////////

    @Override
    public short GetIndexLevel() {
        return questProgress;
    }

    @Override
    public void SetIndexLevel(short _indexLevel) {
        questProgress = _indexLevel;
    }

    @Override
    public void SetIsActive(boolean _isActive) {
        int i=0;
		isActive = _isActive;

		for(GameButton button : buttonArray) {
		    if(i == questProgress){
			    button.SetIsActive(_isActive);
		    }
			i++;
		}
    }
}