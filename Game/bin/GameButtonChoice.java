

public class GameButtonChoice extends GameButton {
    
    // CLASS VARIABLES /////////////////////////////////////////////////////////
    
    protected int timeToReload;
    protected int initialTimeToReload;
    
    protected int goldCost;
    protected int cultistCost;
    protected int knowlegeCost;
    protected int suspicionCost;
    protected int relicCost;
    protected boolean ritualPlaceCost;
    
    protected int goldReward;
    protected int cultistReward;
    protected int knowlegeReward;
    protected int suspicionReward;
    protected int relicReward;
    protected boolean ritualPlaceReward;
    
    protected int initialGoldCost;
    protected int initialCultistCost;
    protected int initialKnowlegeCost;
    protected int initialSuspicionCost;
    protected int initialRelicCost;
    
    protected int initialGoldReward;
    protected int initialCultistReward;
    protected int initialKnowlegeReward;
    protected int initialSuspicionReward;
    protected int initialRelicReward;
    
    // TODO : ajouter les images des ressource et + et -
    
    // CONSTRUCTEUR ////////////////////////////////////////////////////////////
    
    public GameButtonChoice(String _name, TheGame _game, GameMenu _menu,
	                  int _lengthX, int _lengthY, int _positionInArray,
	                  int _goldCost, int _cultistCost, int _knowlegeCost,
	                  int _suspicionCost, int _relicCost, boolean _ritualPlaceCost, int _goldreward, 
	                  int _cultistReward, int _knowlegeReward, int _suspicionReward,
	                  int _relicReward, boolean _ritualPlaceReward, int timeToReload) {
        super(_name, _game, _menu, _lengthX, _lengthY, _positionInArray);
        
        goldCost = _goldCost;
        cultistCost = _cultistCost;
        knowlegeCost = _knowlegeCost;
        suspicionCost = _suspicionCost;
        relicCost = _relicCost;

        goldReward = _goldreward;
        cultistReward = _cultistReward;
        knowlegeReward = _knowlegeReward;
        suspicionReward = _suspicionReward;
        relicReward = _relicReward;
        
        initialGoldCost = goldCost;
        initialCultistCost = cultistCost;
        initialKnowlegeCost = knowlegeCost;
        initialSuspicionCost = suspicionCost;
        initialRelicCost = relicCost;
        
        initialGoldReward = goldReward;
        initialCultistReward = cultistReward;
        initialKnowlegeReward = knowlegeReward;
        initialSuspicionReward = suspicionReward;
        initialRelicReward = relicReward;
        
        initialTimeToReload = timeToReload;
    }
    
    // OVERRIDE ////////////////////////////////////////////////////////////////
    
    
    @Override
    public void OutputUpdate(){
        
        // TODO : Faire l'affichage, si cost et/ou reward 0 alors pas afficher la ressource
        
        super.OutputUpdate();
    
        if(goldCost != 0) {
            System.out.println("gold cost : " + goldCost);
        }
    
        if(goldReward != 0) {
            System.out.println("gold reward : " + goldReward);
        }
        
        if(cultistCost != 0) {
            System.out.println("cultist cost : " + cultistCost);
        }
    
        if(cultistReward != 0) {
            System.out.println("cultist reward : " + cultistReward);
        }
        
        if(knowlegeCost != 0) {
            System.out.println("knowlege cost : " + knowlegeCost);
        }
    
        if(knowlegeReward != 0) {
            System.out.println("knowlege reward : " + knowlegeReward);
        }
        
        if(suspicionCost != 0) {
            System.out.println("sus cost : " + suspicionCost);
        }
    
        if(suspicionReward != 0) {
            System.out.println("sus reward : " + suspicionReward);
        }
        
        if(relicCost != 0) {
            System.out.println("relic cost : " + relicCost);
        }
    
        if(relicReward != 0) {
            System.out.println("relic reward : " + relicReward);
        }
    }
    
    @Override
    public void OutputUpdate(int _positionX, int _positionY){
        
        super.OutputUpdate(_positionX, _positionY);
    
        if(goldCost != 0) {
            System.out.println("gold cost : " + goldCost);
        }
    
        if(goldReward != 0) {
            System.out.println("gold reward : " + goldReward);
        }
        
        if(cultistCost != 0) {
            System.out.println("cultist cost : " + cultistCost);
        }
    
        if(cultistReward != 0) {
            System.out.println("cultist reward : " + cultistReward);
        }
        
        if(knowlegeCost != 0) {
            System.out.println("knowlege cost : " + knowlegeCost);
        }
    
        if(knowlegeReward != 0) {
            System.out.println("knowlege reward : " + knowlegeReward);
        }
        
        if(suspicionCost != 0) {
            System.out.println("sus cost : " + suspicionCost);
        }
    
        if(suspicionReward != 0) {
            System.out.println("sus reward : " + suspicionReward);
        }
        
        if(relicCost != 0) {
            System.out.println("relic cost : " + relicCost);
        }
    
        if(relicReward != 0) {
            System.out.println("relic reward : " + relicReward);
        }
    }
    
    
    //  GETTER AND SETTER //////////////////////////////////////////////////////    
    
    public int GetGoldCost() {
        return goldCost;
    }
    
    public int GetGoldReward() {
        return goldReward;
    }
    
    public int GetCultistCost() {
        return cultistCost;
    }
    
    public int GetCultistReward() {
        return cultistReward;
    }
    
    public int GetKnowlegeCost() {
        return knowlegeCost;
    }
    
    public int GetKnowlegeReward() {
        return knowlegeReward;
    }
    
    public int GetSuspicionCost() {
        return suspicionCost;
    }
    
    public int GetSuspicionReward() {
        return suspicionReward;
    }
    
    public int GetRelicCost() {
        return relicCost;
    }
    
    public int GetRelicReward() {
        return relicReward;
    }

    public boolean GetRitualPlaceCost() {
        return ritualPlaceCost;
    }

    public boolean GetRitualPlaceReward() {
        return ritualPlaceReward;
    }
    
    public int GetTimeToReload() {
        return timeToReload;
    }
}










