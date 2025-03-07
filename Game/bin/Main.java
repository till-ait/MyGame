
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World\n");
		TheGame game_1 = new TheGame();

		//game_1.AddMenuArray(new GameMenu("principale", game_1));
		// System.out.println(game_1.GetMenuArray(0));
		
		
		game_1.GameRun();
	}
}


/*

A faire :
- les TODO
- il faut voir comment afficher
- une class qui vas override SurfaceView et qui recuperera les input realisC)



    // TODO : passer en protected toutes les fonction qui ne doivent pas pouvoir
    // etre apper de l'exterieur des class


La ce que je doit faire c'est appliquer l'off set de bouton et qu'il sache
ou il sont

je pense que l'axe X et Y doivent etre en 1080 par 1920 // 1920 peu etre un peu petit peut etre plus genre 2400
a l'affichage il faut que ce soit respecter et centre
le rapport doit etre garder donc si ecran de meme rapport alors on zoom juste
si de rapport different on met des bande sur le cotC) et on recentre

    // TODO : ajouter la temporaliter pour permettre le rechargement des batiments ainsi que les envenements

    TOODOOOOOOOOOOOO : faire le rechargement du batiments apres utilisation
    Je crois qu'il va falloir que je commence la partie graphique bientot
    il ne reste plus grand chose a faire coter logique une fois que les evenement seront fait
    il faudra quand meme que je prevoit l'affichage des icones pour les choice button
    il y aurait peut etre des optimisation a faire sur le code.
    
    Ca pourrai etre cool de refaire l'uml avec le code fini pour avoir une bonne vision bien claire que qui fait quoi
    
    Pour le tutorial faire un bouton qui permet d'y acceder depuis le menu principale ou les option,
    Ce sera juste un menu avec un bouton croix, et le fond sera le tutorial, il y aura les differentes informations, qu'est ce que les ressources, faire une action dans un batiments ou comment inflitre, il y aura en fr et anglais.
    
    peut etre faire un mode vitess x2 ? genre un bouton et quand on appuie dessu la vitess est en x2, peut etre interessant pour les joueur qui save bien jouer donc il pourrait aller plus vite.
    
    
    // TODO : pour la sauvegarde des data faire une class qui sera l'interface avec le fichier data, elle recuperera les donnees au demarrage, a chaque fois qu'une donnée est changé ca active un flag, elle aura une fonction actualiser qui save si le data on ete changé
    // TODO : peut etre passer sur du JSON pour la save au lieu des txt
    
    peut etre faire une verion loaded et une version unloaded pour les batiment, comme ca le joueur sais si c'est dispo ou pas.

    pour la prochaine fois faire le god menu, il aura un fond et un seul bouton affiche a chaque fois un peu comme le bat men
    mais la aulieu que ce soit ceux < au seuil ce sera celui egale, comme ca un seul afficher, peut etre mettre deux bouton pour avoir
    deux choix a chaque fois, de toute facon on a qu'a faire un niveau d'avancement et les bouton de ce niveau seront afficher

    il faut faire les ivent aussi


    Au lancement du jeu mettre le traileur.






    chose a faire ajd : 
    - finir les fonction de methode bp / ajouter le menu victoire : main menu ou new run / ajouter le menu you lose / V
    - definir les gain et loss de chaque action et de chaque bat et evenement
    - cree les fichier des chaque batiments et chaque evenement
    - il faut finir la class goodsQuest V
    - faire le evenement
    - il serait cool de faire un truc qui permet de joue au jeu sur le terminal

    peut etre faire en sorte de pouvoir afficher des notification en au de l'ecran

    TODO : il faut ajouter une variable rituel organiser, et ajouter dans les ressources necessaire des bt choice le rituel, il sera necessaire pour realiser la dernier quetes
    TODO : ajouter un menu pour le chateau dans lequel on peut ajouter des specificiter, le chateau je pense je l'ajouterais plus tard une fois apres les testes,
    peut etre faire en sorte que le chateau puissent modifier les evenement aleatoire, genre on investie dans les egout du coup plus de maladie

    TODO : faire en sorte qu'il soit possible d'ajouter un evenement a la liste des evenement et qu'il arrive dans les 3 prochain et apres l'enlever, pour le rituel et les dscente de garde
    peut etre le faire dans le input update du menu ressources



    DEMAIN il faut que je finisse de faire le event, notemment les event conditionnel
    il y a aussi la verification que la porte est ouverte pour aller dans les bat de la haute ville
    il faut que je fasse les fichiers de parametre des event et des gods quest
    il faut aussi ajouter la composition aleatoire de la ville
    il faut commencer a penser au position x et y et au largeur des images

    peut etre mettre le text dans les fichier des menu
*/