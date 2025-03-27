package com.example.game;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class GameButtonToggle extends GameButton {
    
    // CLASS VARIABLES /////////////////////////////////////////////////////////
    
    protected boolean isToggled;   // true alors ne print plus l'image de base mais celle la
    
    protected int imageToggle;     // l'image 1 est celle de base du bouton
    protected int textToggle;

	protected ImageView imageToggled;
	protected TextView textBtToggled;
    
    // CONSTRUCTOR ////////////////////////////////////////////////////////////
    
    public GameButtonToggle(String _name, MainActivity _game, GameMenu _menu,
	                  int _lengthX, int _lengthY, int _positionInArray){
        super(_name, _game, _menu, _lengthX, _lengthY, _positionInArray);
        
        isToggled = false;
        
        // TODO : Recuperer les image et texte toggle
    }
    
    public GameButtonToggle(String _name, MainActivity _game, GameMenu _menu){
        super(_name, _game, _menu);
        
        isToggled = false;
        
        // TODO : Recuperer les image et texte toggle
    }
    
    
    // OVERRIDE ////////////////////////////////////////////////////////////////

	@Override
	public void InitImage() {
		super.InitImage();

		imageToggled = new ImageView(game.GetContext());
		String imageName = "menu_bt_toggle";/*name.toLowerCase();*/ // Nom de l’image sans extension et mettre en minuscul
		int imageResource = game.GetContext().getResources().getIdentifier(imageName, "drawable", game.GetContext().getPackageName());
		if (imageResource != 0) {
			imageToggled.setImageResource(imageResource);
		} else {
			Log.e("ImageError", "L'image '" + imageName + "' n'existe pas !");
		}
		imageToggled.setAdjustViewBounds(true);

		imageParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT
		);


		//image.setScaleType(ImageView.ScaleType.FIT_XY);

		imageParams.leftMargin = initialPositionX; // Décalage à droite
		imageParams.rightMargin = initialPositionX;
		imageParams.topMargin = initialPositionY; // Décalage vers le bas

		imageToggled.setLayoutParams(imageParams);
	}

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
				game.GetFrameLayout().addView(image);
				game.GetFrameLayout().addView(textBt);

				lengthX = image.getWidth();
				lengthY = image.getHeight();
			}
    		if(isActive && isPrint && !isPressed) {
    			System.out.println("Bouton " + name + " est afficher actif et unpressed, position : " + positionX + " " + (positionX + lengthX) + " " + positionY + " " + (positionY + lengthY));
				game.GetFrameLayout().addView(image);
				game.GetFrameLayout().addView(textBt);

				lengthX = image.getWidth();
				lengthY = image.getHeight();
			}
    		if(!isActive && isPrint) {
				System.out.println("Bouton " + name + " est afficher unactif");
    		}
        }
        else {
            if(isActive && isPrint && isPressed) {
				System.out.println("Bouton " + name + " est afficher actif, toggled, et pressed");    // TODO : a remplacer par l'affichage de l'image
				game.GetFrameLayout().addView(image);
				game.GetFrameLayout().addView(textBt);	// TODO : faire text toggle

				lengthX = image.getWidth();
				lengthY = image.getHeight();
			}
    		if(isActive && isPrint && !isPressed) {
				System.out.println("Bouton " + name + " est afficher actif, toggled et unpressed, position : " + positionX + " " + (positionX + lengthX) +" " + positionY + " " + (positionY + lengthY));
				game.GetFrameLayout().addView(image);
				game.GetFrameLayout().addView(textBt);	// TODO : faire text toggle

				lengthX = image.getWidth();
				lengthY = image.getHeight();
			}
    		if(!isActive && isPrint) {
				System.out.println("Bouton " + name + " est afficher unactif");
    		}
        }
	}
}