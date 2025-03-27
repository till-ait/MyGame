package com.example.game;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.AssetManager;

import java.util.ArrayList;

public class GameButton {

	// CLASS VARIABLES /////////////////////////////////////////////////////////

	protected String name;
	protected MainActivity game;   // game dans lequel est le bouton, normalement qu'un seul game
	protected GameMenu menu;   // menu dans lequel est le bouton

	protected boolean isActive;   // TODO : peut active sa methode, si inactif alors met une image differente
	protected boolean isPrint;    // doit etre afficher
	protected boolean isPressed;

	protected int imagePressed;
	protected int imageUnPressed;
	protected int imageUnActived;
	protected int text;
	protected int sound;

	protected int initialPositionX; // TODO : pas sur que j'en ai besoin si la position du bouton est calculer par rappor a la position du menu
	protected int initialPositionY;
	protected int positionX;
	protected int positionY;
	protected int lengthX;
	protected int lengthY;
	protected int positionInArray;

	protected ImageView image;
	protected TextView textBt;

	protected FrameLayout.LayoutParams imageParams;
	protected FrameLayout.LayoutParams textParams;

	// STATIC VARIABLES ////////////////////////////////////////////////////////
	
	public static final int FILE_FIRST_LINE = 0;

	public static final int FILE_POSITION_X = 0;
	public static final int FILE_POSITION_Y = 1;
	public static final int FILE_POSITION_LENGTH_X = 2;
	public static final int FILE_POSITION_LENGTH_Y = 3;

	// CONSTRUCTEUR ////////////////////////////////////////////////////////////

	public GameButton(String _name, MainActivity _game, GameMenu _menu,
	                  int _lengthX, int _lengthY, int _positionInArray) {
		name = _name;
		game = _game;
		menu = _menu;
		positionInArray = _positionInArray;

		isActive = false;
		isPrint = false;
		isPressed = false;

		SetLengthX(_lengthX);
		SetLengthY(_lengthY);

		InitPositionFromMenu();
		InitImage();
		InitText();
	}

	public GameButton(String _name, MainActivity _game, GameMenu _menu) {
		name = _name;
		game = _game;
		menu = _menu;

		isActive = false;   // le bouton peut etre non actif et print contrairement au menu; (cas derriere la port ou temps de recharge batiment)
		isPrint = false;
		isPressed = false;



		InitFromFile();
		InitImage();

		// TODO : recuperation des images a partir du name.

		System.out.println("creation bt : " + name);
	}

	public void InitFromFile() {
		ArrayList<String> datas = new ArrayList<>();
		FileReading dataFile = new FileReading(game.GetContext(), name+"Data.txt");
		dataFile.ReadDataFromFile(datas, FILE_FIRST_LINE);

		SetLengthX(Integer.parseInt(datas.get(FILE_POSITION_X)));
		SetLengthY(Integer.parseInt(datas.get(FILE_POSITION_Y)));
		SetLengthX(Integer.parseInt(datas.get(FILE_POSITION_LENGTH_X)));
		SetLengthY(Integer.parseInt(datas.get(FILE_POSITION_LENGTH_Y)));
	}

	public void InitPositionFromMenu() {
		ArrayList<GameButton> buttonArray = menu.GetCopyButtonArray();
		int i=0;
		int offsetX = menu.GetMargeX();
		int offsetY = menu.GetMargeY();

		/*for(i=0; i<positionInArray; i++) {
			offsetX = (int) (offsetX + buttonArray.get(i).GetLengthX() + menu.GetButtonMargeX());
		}*/

		for(i=0; i<positionInArray; i++) {
			offsetY = (int) (offsetY + buttonArray.get(i).GetLengthY() + menu.GetButtonMargeY());
		}

		initialPositionX = offsetX;
		initialPositionY = offsetY;

		positionX = initialPositionX;
		positionY = initialPositionY;
	}

	public void InitImage() {
		image = new ImageView(game.GetContext());
		String imageName = "menu_bt";/*name.toLowerCase();*/ // Nom de l’image sans extension et mettre en minuscul
		int imageResource = game.GetContext().getResources().getIdentifier(imageName, "drawable", game.GetContext().getPackageName());
		if (imageResource != 0) {
			image.setImageResource(imageResource);
		} else {
			Log.e("ImageError", "L'image '" + imageName + "' n'existe pas !");
		}
		image.setAdjustViewBounds(true);

		imageParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT
		);


		//image.setScaleType(ImageView.ScaleType.FIT_XY);

		imageParams.leftMargin = positionX; // Décalage à droite
		imageParams.rightMargin = positionX;
		imageParams.topMargin = positionY; // Décalage vers le bas
		imageParams.bottomMargin = -1000;

		image.setLayoutParams(imageParams);
	}

	public void InitText() {
		textBt = new TextView(game.GetContext());
		Typeface typeface = Typeface.createFromAsset(game.GetContext().getAssets(), "fonts/goth1.ttf");
		typeface = Typeface.create(typeface, Typeface.BOLD);


		textBt.setText(name);	// TODO : faire que ca recuper le text dans un fichier text
		textBt.setTypeface(typeface);
		textBt.setTextSize(35);

		textParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT
		);
		// TODO : enlever ces magic number et mettre des vraie marge pour les texte a l'interieur
		textParams.leftMargin = positionX + 250; // Décalage à droite
		textParams.rightMargin = positionX;
		textParams.topMargin = positionY + 40; // Décalage vers le bas

		textBt.setLayoutParams(textParams);
	}

	// UPDATE //////////////////////////////////////////////////////////////////

	public void InputUpdate(GameInput _lastGameInput) { // TODO : peut etre faire une fonction similaire qui prend en parametre la position x et y, pour avoir des menus dynamique. (surtout pour les batiments).
    	if((_lastGameInput.GetIsNewInput()) && (isActive)) {
    		switch(_lastGameInput.GetInputType()) {
    		case PRESS:
    			ManagePressInput(_lastGameInput);
    			break;
    		case UNPRESS:
    			ManageUnPressInput(_lastGameInput);
    			break;
    		case SLIDE:
    			ManageSlideInput(_lastGameInput);
    			break;
    		default:
    			break;
    		}
	    }
	}

	public void ManagePressInput(GameInput _lastGameInput) {
		if((_lastGameInput.GetStartPositionX()>=positionX) &&
		        (_lastGameInput.GetStartPositionY()>=positionY) &&
		        (_lastGameInput.GetStartPositionX()<=(positionX+lengthX)) &&
		        (_lastGameInput.GetStartPositionY()<=(positionY+lengthY)))
		{
			isPressed = true;
			_lastGameInput.SetIsNewInput(false);
		}
	}

	public void ManageUnPressInput(GameInput _lastGameInput) {
		if((_lastGameInput.GetStartPositionX()>=positionX) &&
		        (_lastGameInput.GetStartPositionY()>=positionY) &&
		        (_lastGameInput.GetStartPositionX()<=(positionX+lengthX)) &&
		        (_lastGameInput.GetStartPositionY()<=(positionY+lengthY)) &&
		        (isPressed))
		{
			isPressed = false;
			GameMethode.Activate(name, game, menu, this);
			_lastGameInput.SetIsNewInput(false);
		}
	}

	public void ManageSlideInput(GameInput _lastGameInput) {
		isPressed = false;  // on ne veut pas activer les boutons quand on slide
	}

	public void OutputUpdate() {

		// TODO : si la position X et/ou Y du bouton est or de l'ecran ne pas l'afficher

		if((positionX != initialPositionX) || (positionY!= initialPositionY)) {
			imageParams.leftMargin = positionX; // Décalage à droite
			imageParams.rightMargin = positionX;
			imageParams.topMargin = positionY; // Décalage vers le bas
			imageParams.bottomMargin = -1000;
		}

		if(isActive && isPrint && isPressed) {
			System.out.println("Bouton " + name + " est afficher actif et pressed");    // TODO : a remplacer par l'affichage de l'image
			game.GetFrameLayout().addView(image);
			game.GetFrameLayout().addView(textBt);

			lengthX = image.getWidth();
			lengthY = image.getHeight();
		}
		if(isActive && isPrint && !isPressed) {
			// System.out.println("Bouton " + name + " est afficher actif et unpressed, position : " + positionX + " " + (positionX + lengthX) +" " + positionY + " " + (positionY + lengthY));
			game.GetFrameLayout().addView(image);
			game.GetFrameLayout().addView(textBt);

			lengthX = image.getWidth();
			lengthY = image.getHeight();
		}
		if(!isActive && isPrint) {
			//System.out.println("Bouton " + name + " est afficher unactif");
			game.GetFrameLayout().addView(image);
		}
	}
	
	// public void OutputUpdate(int _positionX, int _positionY) {  // TODO : pourquoi j'ai fait cette fonction ??? l'autre marche tres bien

	// 	// TODO : si la position X et/ou Y du bouton est or de l'ecran ne pas l'afficher

	// 	if(isActive && isPrint && isPressed) {
	// 		System.out.println("Bouton " + name + " est afficher actif et pressed");    // TODO : a remplacer par l'affichage de l'image
	// 	}
	// 	if(isActive && isPrint && !isPressed) {
	// 		System.out.println("Bouton " + name + " est afficher actif et unpressed, position : " + _positionX + " " + (_positionX + lengthX) +
	// 		                   " " + _positionY + " " + (_positionY + lengthY));
	// 	}
	// 	if(!isActive && isPrint) {
	// 		System.out.println("Bouton " + name + " est afficher unactif");
	// 	}
	// }

	// GETTER AND SETTER ///////////////////////////////////////////////////////

	public String GetName() {
		return name;
	}

	public boolean GetIsActive() {
		return isActive;
	}

	public boolean GetIsPrint() {
		return isPrint;
	}

	public boolean GetIsPressed() {
		return isPressed;
	}

	public int GetImagePressed() {
		return imagePressed;
	}

	public int GetImageUnPressed() {
		return imageUnPressed;
	}

	public int GetImageUnActived() {
		return imageUnActived;
	}

	public int GetText() {
		return text;
	}

	public int GetSound() {
		return sound;
	}

	public int GetInitialPositionX() {
		return initialPositionX;
	}

	public int GetInitialPositionY() {
		return initialPositionY;
	}

	public int GetPositionX() {
		return positionX;
	}

	public int GetPositionY() {
		return positionY;
	}

	public int GetLengthX() {
		return lengthX;
	}

	public int GetLengthY() {
		return lengthY;
	}

	public void SetIsActive(boolean _isActive) {
		isActive = _isActive;
		SetIsPrint(_isActive);
		SetPositionX(initialPositionX);
		SetPositionY(initialPositionY);
	}

	public void SetIsPrint(boolean _isPrint) {
		isPrint = _isPrint;
	}

	public void SetIsPressed(boolean _isPressed) {
		isPressed = _isPressed;
	}

	public void SetInitialPositionX(int _initialPositionX) {
		initialPositionX = _initialPositionX;
	}

	public void SetInitialPositionY(int _initialPositionY) {
		initialPositionY = _initialPositionY;
	}

	public void SetPositionX(int _positionX) {
		positionX = _positionX;
	}

	public void TranslatePositionX(int _translationX) {
		positionX = (int) (positionX + _translationX);
	}

	public void SetPositionY(int _positionY) {
		positionY = _positionY;
	}

	public void TranslatePositionY(int _translationY) {
		positionY = (int)( positionY + _translationY);
	}

	public void SetLengthX(int _lengthX) {
		if(_lengthX >= 0) {
			lengthX = _lengthX;
		}
	}

	public void SetLengthY(int _lengthY) {
		if(_lengthY >= 0) {
			lengthY = _lengthY;
		}
	}

	public void SetImage(String _imageName) {
		image = new ImageView(game.GetContext());
		String imageName = _imageName.toLowerCase(); // Nom de l’image sans extension et mettre en minuscul
		int imageResource = game.GetContext().getResources().getIdentifier(imageName, "drawable", game.GetContext().getPackageName());
		if (imageResource != 0) {
			image.setImageResource(imageResource);
		} else {
			Log.e("ImageError", "L'image '" + imageName + "' n'existe pas !");
		}
		image.setAdjustViewBounds(true);

		imageParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.WRAP_CONTENT
		);


		//image.setScaleType(ImageView.ScaleType.FIT_XY);

		imageParams.leftMargin = initialPositionX; // Décalage à droite
		imageParams.rightMargin = initialPositionX;
		imageParams.topMargin = initialPositionY; // Décalage vers le bas

		image.setLayoutParams(imageParams);
	}
}