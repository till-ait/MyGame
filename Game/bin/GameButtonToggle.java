

public class GameButtonToggle extends GameButton {
    
    // CLASS VARIABLES /////////////////////////////////////////////////////////
    
    protected boolean isToggled;   // true alors ne print plus l'image de base mais celle la
    
    protected int imageToggle;     // l'image 1 est celle de base du bouton
    protected int textToggle;
    
    
    // CONSTRUCTOR ////////////////////////////////////////////////////////////
    
    public GameButtonToggle(String _name, TheGame _game, GameMenu _menu,
	                  int _lengthX, int _lengthY, int _positionInArray){
        super(_name, _game, _menu, _lengthX, _lengthY, _positionInArray);
        
        isToggled = false;
        
        // TODO : Recuperer les image et texte toggle
    }
    
    public GameButtonToggle(String _name, TheGame _game, GameMenu _menu){
        super(_name, _game, _menu);
        
        isToggled = false;
        
        // TODO : Recuperer les image et texte toggle
    }
    
    
    // OVERRIDE ////////////////////////////////////////////////////////////////
    
    // TODO :: Override les fonction input et output update 
    
    @Override
    public void ManageUnPressInput(GameInput _lastGameInput) {
		if((_lastGameInput.GetStartPositionX()>=positionX) &&
		        (_lastGameInput.GetStartPositionY()>=positionY) &&
		        (_lastGameInput.GetStartPositionX()<=(positionX+lengthX)) &&
		        (_lastGameInput.GetStartPositionY()<=(positionY+lengthY)) &&
		        (isPressed))
		{
			isPressed = false;
			
			if(!isToggled) {
			    GameMethode.Activate(name, game, menu, this);
			    isToggled = true;
			}
			else {
			    GameMethode.Activate(name+"Toggle", game, menu, this);
			    isToggled = false;
			}
		}
	}
	
	@Override
	public void OutputUpdate() {

		// TODO : si la position X et/ou Y du bouton est or de l'ecran ne pas l'afficher
        
        if(!isToggled){
    		if(isActive && isPrint && isPressed) {
    			System.out.println("Bouton " + name + " est afficher actif et pressed");    // TODO : a remplacer par l'affichage de l'image
    		}
    		if(isActive && isPrint && !isPressed) {
    			System.out.println("Bouton " + name + " est afficher actif et unpressed, position : " + positionX + " " + (positionX + lengthX) +
    			                   " " + positionY + " " + (positionY + lengthY));
    		}
    		if(!isActive && isPrint) {
    			System.out.println("Bouton " + name + " est afficher unactif");
    		}
        }
        else {
            if(isActive && isPrint && isPressed) {
    			System.out.println("Bouton " + name + " est afficher actif, toggled, et pressed");    // TODO : a remplacer par l'affichage de l'image
    		}
    		if(isActive && isPrint && !isPressed) {
    			System.out.println("Bouton " + name + " est afficher actif, toggled et unpressed, position : " + positionX + " " + (positionX + lengthX) +
    			                   " " + positionY + " " + (positionY + lengthY));
    		}
    		if(!isActive && isPrint) {
    			System.out.println("Bouton " + name + " est afficher unactif");
    		}
        }
	}
}