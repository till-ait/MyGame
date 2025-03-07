

public class GameMenuTown extends GameMenu {
    
    // CLASS VARIABLES /////////////////////////////////////////////////////////
    
    protected int initialPositionX;
    protected int initialPositionY;
    
    // CONSTRUCTOR /////////////////////////////////////////////////////////////
    
    public GameMenuTown(String _name, TheGame _game){
        super(_name, _game);
        
        initialPositionX = positionX;
        initialPositionY = positionY;
    }
    
    // OVERRIDE ////////////////////////////////////////////////////////////////
    
    @Override
    public void InputUpdate(GameInput _lastGameInput) {
		// TODO : quand override de town ajouter les slides
		

		if(isActive) {
    		if(_lastGameInput.GetInputType() == InputType.SLIDE) {
    		    SetPositionY((int)(_lastGameInput.GetFinishPositionY()-_lastGameInput.GetStartPositionY()));
    		}
			super.InputUpdate(_lastGameInput);
		}
		
		// TODO : le bp ne feront que activer le menu de meme indice dans le building Array
	}
	
	// TODO : Override Output, il faut afficher les button correspondant au batiments present dans buildingArray de the game
	
    @Override
    public void SetIsActive(boolean _isActive) {
        positionX = initialPositionX;
        positionY = initialPositionY;
        
        super.SetIsActive(_isActive);
    }
}