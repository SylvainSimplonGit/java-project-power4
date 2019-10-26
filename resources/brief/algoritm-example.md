graph TD
    inputData-->createTable
    createTable-->randomPlayer
    randomPlayer-->placeBoat
    placeBoat-->testPlayerWin
    testPlayerWin-- No -->inputShoot
    inputShoot-->updateData
    updateData-->showShoot
    showShoot-->giveHand
    giveHand-->testPlayerWin
    testPlayerWin-- Yes -->showEnd

    subgraph initialiser les données du jeu
        inputData(saisir les noms<br/>des joueurs)
        createTable("créer un/des plateau(x)<br/>de jeu(x) vide(s)")
        randomPlayer(tirer au hasard<br/>quel joueur commence)
        placeBoat(placer les bateaux)
    end

    subgraph Tant qu'aucun joueur n'a gagné
        testPlayerWin{Un joueur<br/>a gagné}
        inputShoot(demander au joueur<br/>qui a la main où il tire)
        subgraph réaliser le tir
            updateData(mettre à jour<br/>les données du jeu)
            showShoot(annoncer les<br/>conséquences du tir)
            giveHand(passer la main<br/>à l'autre joueur)
        end
    end

    showEnd(Annoncer le résultat<br/>de la partie)

classDef center text-align: center;
classDef left text-align: left;

class inputData,createTable,randomPlayer,placeBoat,inputShoot,updateData,showShoot,giveHand,showEnd,testPlayerWin center;