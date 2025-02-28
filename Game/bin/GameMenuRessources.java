

public class GameMenuRessources extends GameMenu {
    
    // CLASS VARIABLES /////////////////////////////////////////////////////////
    
    protected int gold;
    protected int cultist;
    protected int knowlege;
    protected int suspicion;
    protected int relic;
    
    // TODO : ajouter toutes les icones pour les ressources
    
    // TODO : ajouter les quetes des dieux, il faut qu'il y est un bp en attente de la quet des dieu et un quand la quete est la
    // peut etre ajouter aux event la punition des dieux, mais genre faut laisser un peu de temps, apres jsp si faut laisser longtem
    // je pense par dieux il faut avoir entre 3 et 5 quetes.
    
    // CONSTRUCTOR /////////////////////////////////////////////////////////////
    
    public GameMenuRessources(String _name, TheGame _game, 
                              int _gold, int _cultist, int _knowlege, 
                              int _suspicion, int _relic) {   // TODO : dans le fichier data apres le type de menu mettre les ressources
        super(_name, _game);
        gold = _gold;
        cultist = _cultist;
        knowlege = _knowlege;
        suspicion = _suspicion;
        relic = _relic;
    }
    
    
    // OVERRIDE ////////////////////////////////////////////////////////////////
    
    @Override
    public void OutputUpdate(){
        super.OutputUpdate();
        if(isActive){
            System.out.println("RESSOURCES : gold : "+ gold+" / culti : "+cultist+" / know : "+knowlege+" / sus : "+suspicion+" / relic : "+relic);
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
}