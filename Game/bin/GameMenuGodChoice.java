

public class GameMenuGodChoice extends GameMenu {

    // TODO : une fois la save implementer il faudra que le menu n'affiche que les dieux deja fait et le prochain

    public static enum GodsNames {
        Ifrak, Yikouch, Anzir, Gurzal, Mehal
    }

    // VARIABLES ////////////////////////////////////////////

    protected int nbGodsAllReadyFinished;   // pour afficher seulement les dieux deja invoque, utilisation de l'index plutot

    // STATIC VAIABLES //////////////////////////////////////

    // CONSTRUCTOR //////////////////////////////////////////

    public GameMenuGodChoice(String _name, TheGame _game) {
        super(_name, _game);
    }

    // GETTER AND SETTER ////////////////////////////////////
}
