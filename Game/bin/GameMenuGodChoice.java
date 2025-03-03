

public class GameMenuGodChoice extends GameMenu {
    // TODO : ce menu sera le premier accessible et permettra de choisir le dieux que l'ont veut suivre
    // une fois choisit ce sera le GameMenuGodQuest qui sera apperle
    // peut etre faire une roue circulaire, avec des petit boutons

    // TODO : une fois la save implementer il faudra que le menu n'affiche que les dieux deja fait et le prochain

    public static enum GodsNames {
        Ifrak, Yikouch, Anzir, Gurzal, Mehal
    }

    // VARIABLES ////////////////////////////////////////////

    protected int nbGodsAllReadyFinished;   // pour afficher seulement les dieux deja invoque, utilisation de l'index plutot

    // STATIC VAIABLES //////////////////////////////////////

    // CONSTRUCTOR //////////////////////////////////////////

    public GameMenuGodChoice(String _name, TheGame _game) {     // TODO : les boutons ne vont que mettre a la valeur
        super(_name, _game);
    }

    // GETTER AND SETTER ////////////////////////////////////
}
