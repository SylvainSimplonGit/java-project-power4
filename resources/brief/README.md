# Projet JAVA Puissance 4 Brief

- [Rappels](#rappels)
  - [Contexte](#contexte)
  - [MVP](#minimum-vailable-product)
  - [Installation](#installation)
  - [Execution](#execution)
  
## Rappels

### Contexte

Créer un jeu de plateau en java, de type puissance 4.

### Minimum Vailable Product

L’adresse d’un repo git contenant :

1. le fichier java
1. un fichier readme.md qui comprend trois parties :
   - description du jeu
   - description de l’implémentation technique du jeu (algorithmes principaux, modélisation)
   - la notice d’utilisation un exemple d’utilisation.

### Détails du projet

#### Un jeu de plateau

Vous trouverez en bas de ce document un énoncé pour programmer un jeu de puissance 4. Vous pouvez cependant proposer 
un autre jeu, à condition :

- d’utiliser un ou des tableaux (et de préférence des algorithmes intéressants de parcours de tableaux);
- que votre jeu fonctionne en mode console;
- que l’on valide votre choix du jeu.

Avant de commencer à programmer, vous devez réfléchir sur papier et traitement de texte :

- à l’algorithme principal de votre jeu que vous pourrez rédiger en pseudo code ou bien de manière plus informelle 
comme dans l’exemple ci-dessous :
  
  Par exemple, pour une bataille navale (la bataille navale est assez difficile à implémenter), l’algorithme principal
  peut être :

<p align="center">
 <img width="60%" src="algorithm-example.png">
</p>

- à la façon dont vous allez représenter les données du jeu dans les variables de votre programme ; Par exemple, on pourra représenter un plateau de bataille navale par un tableau à deux dimensions… mais un tableau de quel type ? avec quel codage des informations ?
- à certaines méthodes que vous allez développer ; Par exemple pour la bataille navale on pourra penser à développer une méthode qui permet à un joueur de saisir les emplacements de ses bateaux, une autre méthode qui positionne aléatoirement les bateaux à la place du joueur, une méthode qui en fonction des coordonnées de tir calcule les conséquence et met à jour les données, etc.

Lorsque des méthodes sont difficile d’un point de vue algorithmique, vous réfléchirez aussi sur papier et traitement de texte aux algorithmiques. Par exemple la méthode qui positionne aléatoirement les bateaux d’un joueur doit être écrite en pseudo-code avant d’être programmée en Java. Lorsque vous programmerez, vous validerez soigneusement chacune de vos méthodes. Au minimum, après avoir programmé une méthode, exécutez-là avec plusieurs données en entrée (bien choisies…) pour vérifier quelle fonctionne correctement dans tous les cas.

Soyez attentifs à valider soigneusement votre programme dans son ensemble.

Réfléchissez à un jeu de tests de validation, c’est à dire à des scénarios qui mettent en jeu tous les cas d’utilisation de votre programme.

Par exemple, pour la bataille navale, un scénario peut consister à imposer les positions des bateaux et une suite de tirs menant à la victoire d’un joueur. Exécuter ce scénario consiste à poser les bateaux à l’endroit prévu, puis réaliser les tirs prévus dans l’ordre prévu pour vérifier que tout se passe comme prévu… Pensez à plusieurs scénarios couvrant au mieux les cas qui peuvent se présenter pendant le déroulement du jeu. Décrivez sur traitement de texte vos tests de validation (dans le document d’analyse et conception que vous déposerez aussi sur le drive). La plupart des jeux permettent des extensions que vous pourrez réaliser en option si vous en avez le temps (par exemple, beaucoup de jeux à deux joueurs se prêtent à la réalisation d’une version où on joue contre l’ordinateur).

#### Quelques exemples de jeux
- jeu de pendu
- othello
- tic-tac-toe

#### Jeu de puissance 4

Ce jeu se joue à deux joueurs sur une grille de hauteur 6 et de largeur 7 (voir par exemple https://fr.wikipedia.org/wiki/Puissance₄). Les joueurs laissent tomber chacun leur tour un jeton dans une colonne. Lorsqu’un joueur aligne 4 jetons de sa couleur (en ligne ou en diagonale), il a gagné. Il peut arriver qu’aucun joueur ne parvienne à aligner 4 jetons, donnant lieu à un match nul.

La grille de jeu pourra être modélisée par un tableau de 6 lignes par 7 colonnes. Chaque case du tableau pouvant contenir l’information : case vide, case occupée par un jeton d’un joueur, case occupée par un jeton de l’autre joueur. Il faut choisir un type pour les éléments du tableau (char, int, String, …) et un codage permettant de représenter ces informations (comment représenter une case vide par exemple?).

##### Quelques idées d’extensions optionnelles pour puissance 4 :

- A la fin de la partie le programme demande « Voulez-vous jouer une autre partie ? ». Si oui, une nouvelle partie commence avec les même noms de joueurs.
- Jouer contre l’ordinateur stratégie naïve (l’ordinateur tire au hasard la colonne dans laquelle il place son jeton).
- Jouer contre l’ordinateur stratégie plus évoluée (à vous de trouver une stratégie…).

## Installation

### Pré requis

Logiciels necessaires :

- Git **v2.21.0** ou supérieure
  - ([Installation](https://git-scm.com/downloads))
- JDK Java **v11** ou supérieure
  - ([Installation sur Linux](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8))
  - ([Installation sur Windows](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA))
  - ([Installation sur MacOs](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE))

Dans un répertoire vide dénommé dans la suite **\<repertoire\>**, executer la commande suivante :

```git
git clone https://github.com/SylvainSimplonGit/java-project-power4.git
```

Cette commande fera une copie de ce repository sur votre poste local.

## Execution

### Via IntelliJ

#### Execution du programme principal

- Sélectionnez dans le menu d'IntelliJ, ***Run*** puis le sous menu ***Edit Configurations...***

- Dans ***Main Class*** choisir *Main*

- Ensuite parcourez les menus pour afficher ce que vous souhaitez !

## Etapes

 - [ ] 

 ### Améliorations à prévoir
 
 - [ ] 