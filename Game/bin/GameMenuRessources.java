import java.util.Random;

public class GameMenuRessources extends GameMenu {
    
    // CLASS VARIABLES /////////////////////////////////////////////////////////
    
    protected int gold;
    protected int cultist;
    protected int knowlege;
    protected int suspicion;
    protected int relic;
    protected boolean aRitualPlace;

    protected int goldEventThreshold;
    protected int cultistEventThreshold;
    protected int knowlegeEventThreshold;
    protected int suspicionEventThreshold;
    protected int relicEventThreshold;

    protected int goldEventThresholdInitial;
    protected int cultistEventThresholdInitial;
    protected int knowlegeEventThresholdInitial;
    protected int suspicionEventThresholdInitial;
    protected int relicEventThresholdInitial;
    
    
    // TODO : ajouter toutes les icones pour les ressources
    
    // TODO : ajouter les quetes des dieux, il faut qu'il y est un bp en attente de la quet des dieu et un quand la quete est la
    // peut etre ajouter aux event la punition des dieux, mais genre faut laisser un peu de temps, apres jsp si faut laisser longtem
    // je pense par dieux il faut avoir entre 3 et 5 quetes.
    
    // CONSTRUCTOR /////////////////////////////////////////////////////////////
    
    public GameMenuRessources(String _name, TheGame _game, 
                              int _gold, int _cultist, int _knowlege, 
                              int _suspicion, int _relic, int _goldEventThreshold,
                              int _cultistEventThreshold, int _knowlegeEventThreshold,
                              int _suspicionEventThreshold, int _relicEventThreshold) {   // TODO : dans le fichier data apres le type de menu mettre les ressources
        super(_name, _game);
        gold = _gold;
        cultist = _cultist;
        knowlege = _knowlege;
        suspicion = _suspicion;
        relic = _relic;
        aRitualPlace = false;

        goldEventThreshold = _goldEventThreshold;
        cultistEventThreshold = _cultistEventThreshold;
        knowlegeEventThreshold = _knowlegeEventThreshold;
        suspicionEventThreshold = _suspicionEventThreshold;
        relicEventThreshold = _relicEventThreshold;

        goldEventThresholdInitial = _goldEventThreshold;
        cultistEventThresholdInitial = _cultistEventThreshold;
        knowlegeEventThresholdInitial = _knowlegeEventThreshold;
        suspicionEventThresholdInitial = _suspicionEventThreshold;
        relicEventThresholdInitial = _relicEventThreshold;
    }
    
    
    // OVERRIDE ////////////////////////////////////////////////////////////////
    
    @Override
    public void OutputUpdate(){
        super.OutputUpdate();
        if(isActive){
            System.out.println("RESSOURCES : gold : "+ gold+" / culti : "+cultist+" / know : "+knowlege+" / sus : "+suspicion+" / relic : "+relic+" / a place : "+aRitualPlace);
        }
    }

    // PUBLIC FUNCTION ////////////////////////////////////////////////////////

    public void RessourceThresholdEvent() {
        int i = game.GetIndexEventArray();

        if((gold > goldEventThreshold) && (game.GetEvent("goldThresholdEvent") == null)) {
            // game.AddEventArray((GameMenu)(new GameMenuEvent("goldThresholdEvent",game)),i);
        }

        if((cultist > cultistEventThreshold) && (game.GetEvent("cultistThresholdEvent") == null)) {
            // game.AddEventArray((GameMenu)(new GameMenuEvent("cultistThresholdEvent",game)),i);
        }

        if((knowlege > knowlegeEventThreshold) && (game.GetEvent("knowlegeThresholdEvent") == null)) {
            // game.AddEventArray((GameMenu)(new GameMenuEvent("knowlegeThresholdEvent",game)),i);
        }

        if(suspicion > suspicionEventThreshold) {
            // game.AddEventArray((GameMenu)(new GameMenuEvent("suspicionThresholdEvent",game)),i);
            if((game.GetBuilding("gate") != null) && (game.GetEvent("gateEvent") == null)) {
                game.AddEventArray((GameMenu)(new GameMenuEvent("gateEvent",game)),i);
            }
            if((game.GetBuilding("prison") != null) && (game.GetEvent("prisonEvent") == null)) {
                game.AddEventArray((GameMenu)(new GameMenuEvent("prisonEvent",game)),i);
            }
            if((game.GetBuilding("inquisition") != null) && (game.GetEvent("inquisitionEvent") == null)) {
                Random rand = new Random();
                game.AddEventArray((GameMenu)(new GameMenuEvent("inquisitionEvent",game)),i);
                game.AddEventArray((GameMenu)(new GameMenuEvent("inquisitionEvent",game)),i+1);
                game.AddEventArray((GameMenu)(new GameMenuEvent("inquisitionEvent",game)),i+2);
            }
        }

        if((relic > relicEventThreshold)  && (game.GetEvent("relicThresholdEvent") == null)) {
            // game.AddEventArray((GameMenu)(new GameMenuEvent("relicThresholdEvent",game)),i);
        }
    }
    
    // GETTER AND SETTER ///////////////////////////////////////////////////////
    
    public int GetGold(){
        return gold;
    }
    
    public int GetCultist(){
        return cultist;
    }
    
    public int GetKnowlege(){
        return knowlege;
    }
    
    public int GetSuspicion(){
        return suspicion;
    }
    
    public int GetRelic(){
        return relic;
    }
    
    public int GetGoldEventThreshold(){
        return goldEventThreshold;
    }
    
    public int GetCultistEventThreshold(){
        return cultistEventThreshold;
    }
    
    public int GetKnowlegeEventThreshold(){
        return knowlegeEventThreshold;
    }
    
    public int GetSuspicionEventThreshold(){
        return suspicionEventThreshold;
    }
    
    public int GetRelicEventThreshold(){
        return relicEventThreshold;
    }

    public boolean GetARitualPlace() {
        return aRitualPlace;
    }
    
    public void SetGold(int _gold){
        if(_gold > 0){
            gold = _gold;
        }
        else {
            gold = 0;
        }
    }
    
    public void SetCultist(int _cultist){
        if(_cultist > 0){
            cultist = _cultist;
        }
        else {
            cultist = 0;
        }
    }
    
    public void SetKnowlege(int _knowlege){
        if(_knowlege > 0){
            knowlege = _knowlege;
        }
        else {
            knowlege = 0;
        }
    }
    
    public void SetSuspicion(int _suspicion){
        if(_suspicion > 0){
            suspicion = _suspicion;
        }
        else {
            suspicion = 0;
        }
    }
    
    public void SetRelic(int _relic){
        if(_relic > 0){
            relic = _relic;
        }
        else {
            relic = 0;
        }
    }
    
    public void SetGoldEventThreshold(int _goldEventThreshold){
        if(_goldEventThreshold > 0){
            goldEventThreshold = _goldEventThreshold;
        }
        else {
            goldEventThreshold = 0;
        }
    }
    
    public void SetCultistEventThreshold(int _cultistEventThreshold){
        if(_cultistEventThreshold > 0){
            cultistEventThreshold = _cultistEventThreshold;
        }
        else {
            cultistEventThreshold = 0;
        }
    }
    
    public void SetKnowlegeEventThreshold(int _knowlegeEventThreshold){
        if(_knowlegeEventThreshold > 0){
            knowlegeEventThreshold = _knowlegeEventThreshold;
        }
        else {
            knowlegeEventThreshold = 0;
        }
    }
    
    public void SetSuspicionEventThreshold(int _suspicionEventThreshold){
        if(_suspicionEventThreshold > 0){
            suspicionEventThreshold = _suspicionEventThreshold;
        }
        else {
            suspicionEventThreshold = 0;
        }
    }
    
    public void SetRelicEventThreshold(int _relicEventThreshold){
        if(_relicEventThreshold > 0){
            relicEventThreshold = _relicEventThreshold;
        }
        else {
            relicEventThreshold = 0;
        }
    }
    
    public void SetGoldEventThresholdInitial(){
        goldEventThreshold = goldEventThresholdInitial;
    }
    
    public void SetCultistEventThresholdInitial(){
        cultistEventThreshold = cultistEventThresholdInitial;
    }
    
    public void SetKnowlegeEventThresholdInitial(){
        knowlegeEventThreshold = knowlegeEventThresholdInitial;
    }
    
    public void SetSuspicionEventThresholdInitial(){
        suspicionEventThreshold = suspicionEventThresholdInitial;
    }
    
    public void SetRelicEventThresholdInitial(){
        relicEventThreshold = relicEventThresholdInitial;
    }

    public void SetARitualPlace(boolean _aRitualPlace) {
        aRitualPlace = _aRitualPlace;
    }
}