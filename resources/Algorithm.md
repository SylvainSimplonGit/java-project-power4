graph TD;

    inputData-->choiceColor;
    choiceColor-->createTable;
    createTable-->randomPlayer;

    randomPlayer-->testPlayerWin;
    testPlayerWin-- yes -->showEnd;
    testPlayerWin-- no -->inputShoot;
    inputShoot-->testColumnFill;
    testColumnFill-- no -->updateData;
    testColumnFill-- yes -->showEnd;
    updateData-->showShoot;
    showShoot-->giveHand;
    giveHand-->testPlayerWin;

    subgraph initialiser les données du jeu
        inputData(saisir les noms<br/>des 2 joueurs)
        choiceColor(Affecter un signe à chaque joueur)
        createTable("créer un plateau<br/>de jeu vide")
        randomPlayer(tirer au hasard<br/>quel joueur commence)
    end

    subgraph Tant qu'aucun joueur n'a gagné
        testPlayerWin{Un joueur<br/>a gagné}
        inputShoot(demander au joueur<br/>qui a la main dans<br/>quelle colonne il place son jeton)
        subgraph Tant qu'il reste de la place dans la colonne
            testColumnFill{La colonne<br/>est pleine}
            subgraph réaliser le tir
                updateData(mettre à jour<br/>les données du jeu)
                showShoot(annoncer les<br/>conséquences du tir)
                giveHand(passer la main<br/>à l'autre joueur)
            end
        end
    end

    showEnd(Annoncer le résultat<br/>de la partie)

classDef center text-align: center;
classDef left text-align: left;

class inputData,choiceColor,createTable,randomPlayer,testPlayerWin,inputShoot,testColumnFill,updateData,showShoot,giveHand,showEnd center;