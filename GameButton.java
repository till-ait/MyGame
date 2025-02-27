import java.util.ArrayList;

public class GameButton {

	// CLASS VARIABLES /////////////////////////////////////////////////////////

	protected String name;
	protected TheGame game;   // game dans lequel est le bouton, normalement qu'un seul game
	protected GameMenu menu;   // menu dans lequel est le bouton

	protected boolean isActive;   // TODO : peut active sa methode, si inactif alors met une image differente
	protected boolean isPrint;    // doit etre afficher
	protected boolean isPressed;

	protected int imagePressed;
	protected int imageUnPressed;
	protected int imageUnActived;
	protected int text;
	protected int sound;

	protected short initialPositionX; // TODO : pas sur que j'en ai besoin si la position du bouton est calculer par rappor a la position du menu
	protected short initialPositionY;
	protected short positionX;
	protected short positionY;
	protected short lengthX;
	protected short lengthY;
	protected int positionInArray;

	// STATIC VARIABLES ////////////////////////////////////////////////////////
	
	public static final int FILE_FIRST_LINE = 0;

	public static final int FILE_POSITION_X = 0;
	public static final int FILE_POSITION_Y = 1;
	public static final int FILE_POSITION_LENGTH_X = 2;
	public static final int FILE_POSITION_LENGTH_Y = 3;

	// CONSTRUCTEUR ////////////////////////////////////////////////////////////

	public GameButton(String _name, TheGame _game, GameMenu _menu,
	                  short _lengthX, short _lengthY, int _positionInArray) {
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
	}

	public GameButton(String _name, TheGame _game, GameMenu _menu) {
		name = _name;
		game = _game;
		menu = _menu;

		isActive = false;   // le bouton peut etre non actif et print contrairement au menu; (cas derriere la port ou temps de recharge batiment)
		isPrint = false;
		isPressed = false;



		InitFromFile();     // TODO : recuperation des donnC)es depuis le fichier associer,
		// peut etre faire un seul fichier pour tous les bouton similaire,
		// genre bp bat, bp town et tous puisqu'ils sont similaire
		// pour eviter d'avoir plusieur fois les meme donner

		// TODO : recuperation des images a partir du name.

		System.out.println("creation bt : " + name);
	}

	public void InitFromFile() {
		ArrayList<String> datas = new ArrayList<>();
		FileReading dataFile = new FileReading("dataButton.txt");  // TODO : remplacer par name + ".txt"
		dataFile.ReadDataFromFile(datas, FILE_FIRST_LINE);

		SetLengthX(Short.parseShort(datas.get(FILE_POSITION_X)));
		SetLengthY(Short.parseShort(datas.get(FILE_POSITION_Y)));
		SetLengthX(Short.parseShort(datas.get(FILE_POSITION_LENGTH_X)));
		SetLengthY(Short.parseShort(datas.get(FILE_POSITION_LENGTH_Y)));
	}

	public void InitPositionFromMenu() {
		ArrayList<GameButton> buttonArray = menu.GetCopyButtonArray();
		int i=0;
		short offsetX = menu.GetMargeX();
		short offsetY = menu.GetMargeY();

		for(i=0; i<positionInArray; i++) {
			offsetY = (short) (offsetY + buttonArray.get(i).GetLengthY() + menu.GetButtonMargeY());
		}

		initialPositionX = offsetX;
		initialPositionY = offsetY;
	}

	// UPDATE //////////////////////////////////////////////////////////////////

	public void InputUpdate(GameInput _lastGameInput) { // TODO : peut etre faire une fonction similaire qui prend en parametre la position x et y, pour avoir des menus dynamique. (surtout pour les batiments).
    	if(_lastGameInput.GetIsNewInput()) {
    		switch(_lastGameInput.GetInputType()) {
    		case InputType.PRESS:
    			ManagePressInput(_lastGameInput);
    			break;
    		case InputType.UNPRESS:
    			ManageUnPressInput(_lastGameInput);
    			break;
    		case InputType.SLIDE:
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
	
	public void OutputUpdate(short _positionX, short _positionY) {  // TODO : pourquoi j'ai fait cette fonction ??? l'autre marche tres bien

		// TODO : si la position X et/ou Y du bouton est or de l'ecran ne pas l'afficher

		if(isActive && isPrint && isPressed) {
			System.out.println("Bouton " + name + " est afficher actif et pressed");    // TODO : a remplacer par l'affichage de l'image
		}
		if(isActive && isPrint && !isPressed) {
			System.out.println("Bouton " + name + " est afficher actif et unpressed, position : " + _positionX + " " + (_positionX + lengthX) +
			                   " " + _positionY + " " + (_positionY + lengthY));
		}
		if(!isActive && isPrint) {
			System.out.println("Bouton " + name + " est afficher unactif");
		}
	}

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

	public short GetInitialPositionX() {
		return initialPositionX;
	}

	public short GetInitialPositionY() {
		return initialPositionY;
	}

	public short GetPositionX() {
		return positionX;
	}

	public short GetPositionY() {
		return positionY;
	}

	public short GetLengthX() {
		return lengthX;
	}

	public short GetLengthY() {
		return lengthY;
	}

	public void SetIsActive(boolean _isActive) {
		isActive = _isActive;   // TODO : doit etre mis actif si pas blocque par porte ou recharge si nn juste print, en fait que pour les bouton de bat, donc a faire dans l'heritage
		SetIsPrint(_isActive);  // TODO : si le batiment n'est pas infiltrer il faut pas afficher certain bouton
		SetPositionX(initialPositionX);
		SetPositionY(initialPositionY);
	}

	public void SetIsPrint(boolean _isPrint) {
		isPrint = _isPrint;
	}

	public void SetIsPressed(boolean _isPressed) {
		isPressed = _isPressed;
	}

	public void SetInitialPositionX(short _initialPositionX) {
		initialPositionX = _initialPositionX;
	}

	public void SetInitialPositionY(short _initialPositionY) {
		initialPositionY = _initialPositionY;
	}

	public void SetPositionX(short _positionX) {
		positionX = _positionX;
	}

	public void TranslatePositionX(short _translationX) {
		positionX = (short) (positionX + _translationX);
	}

	public void SetPositionY(short _positionY) {
		positionY = _positionY;
	}

	public void TranslatePositionY(short _translationY) {
		positionY = (short)( positionY + _translationY);
	}

	public void SetLengthX(short _lengthX) {
		if(_lengthX >= 0) {
			lengthX = _lengthX;
		}
	}

	public void SetLengthY(short _lengthY) {
		if(_lengthY >= 0) {
			lengthY = _lengthY;
		}
	}
}