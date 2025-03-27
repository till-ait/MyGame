package com.example.game;

public class GameMenuTown extends GameMenu {
    
    // CLASS VARIABLES /////////////////////////////////////////////////////////
    
    protected int initialPositionX;
    protected int initialPositionY;
    
    // CONSTRUCTOR /////////////////////////////////////////////////////////////
    
    public GameMenuTown(String _name, MainActivity _game){
        super(_name, _game);
        
        initialPositionX = positionX;
        initialPositionY = positionY;
    }
    
    // OVERRIDE ////////////////////////////////////////////////////////////////
    
    @Override
    public void InputUpdate(GameInput _lastGameInput) {
		if(isActive) {
    		if(_lastGameInput.GetInputType() == InputType.SLIDE) {
    		    // SetPositionY((int)(_lastGameInput.GetFinishPositionY()-_lastGameInput.GetStartPositionY()));
                SetPositionY((positionY + _lastGameInput.GetFinishPositionY()-_lastGameInput.GetStartPositionY()));
                System.out.println("New position : " + positionY + " deplacement de : " + (_lastGameInput.GetFinishPositionY()-_lastGameInput.GetStartPositionY()));
    		}
			super.InputUpdate(_lastGameInput);
		}
	}
	
	// TODO : Override Output, il faut afficher les button correspondant au batiments present dans buildingArray de the game
	
    @Override
    public void SetIsActive(boolean _isActive) {
        //positionX = initialPositionX;
        //positionY = initialPositionY;

        if(_isActive) {
            int i = 0;
            for (GameButton building : buttonArray) {
                building.SetImage(game.GetBuilding(i).GetName());
                i++;
            }
        }

        super.SetIsActive(_isActive);
    }
}