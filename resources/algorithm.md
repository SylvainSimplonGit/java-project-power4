%%```mermaid
graph TD;

    player1-->inputName
    inputName-->testNameUsed
    testNameUsed-- yes -->inputName
    testNameUsed-- no -->inputChar
    inputChar-->testCharUsed
    testCharUsed-- yes -->inputChar
    testCharUsed-- no -->testNumbePlayer
    testNumbePlayer-- no -->player2
    player2-->inputName
    testNumbePlayer-- yes -->createTable

    createTable-->randomPlayer;

    randomPlayer-->inputShoot;
    inputShoot-->testColumnFill;
    testColumnFill-- yes -->inputNewColumn;
    testColumnFill-- no -->updateTable;
    inputNewColumn-->inputShoot
    updateTable-->showShoot;
    showShoot-->test4Cases;

    test4Cases-- yes -->showEnd
    test4Cases-- no -->testBoardFill
    testBoardFill-- yes -->giveHand
    testBoardFill-- no -->showEnd

    giveHand-->inputShoot;

    subgraph initialiser les données du jeu
        subgraph Saisir le nom des 2 joueurs
            player1[n = 1]
            inputName(Saisir nom du joueur)
            testNameUsed{Le nom<br/>est-il déjà<br/>utilisé ?}
            inputChar(Choisir le caractère)
            testCharUsed{Le carctère<br/>est-il déjà<br/>utilisé ?}
            testNumbePlayer{n == 2}
            player2(n = n + 1)
        end
        %%choiceColor(Affecter un signe à chaque joueur)
        createTable("créer un plateau<br/>de jeu vide")
        randomPlayer(tirer au hasard<br/>quel joueur commence)
    end

    subgraph Tant qu'aucun joueur n'a gagné
        %%testPlayerWin{Un joueur<br/>a gagné}
        inputShoot(demander au joueur<br/>qui a la main dans<br/>quelle colonne il place son jeton)
        subgraph Tant qu'il reste de la place dans la colonne
            testColumnFill{La colonne<br/>est pleine}
            subgraph la colonne est pleine
                inputNewColumn(Afficher :<br/>La colonne est pleine,<br/>choisir une autre colonne<br/>Rappeler les colonnes libres)
            end
                subgraph mettre à jour les données du jeu
                    updateTable(mettre à jour<br/>la case choisie)
                    showShoot(Afficher la grille)
                    test4Cases{Vérifier <br/>si 4 cases sont<br/>alignées}
                    testBoardFill{Reste-t-il<br/>des cases vides ?}
                end
            giveHand(passer la main<br/>à l'autre joueur)
        end
    end

    showEnd(Annoncer le résultat<br/>de la partie)

classDef center text-align: center;
classDef left text-align: left;

class player1,inputName,testNumbePlayer,player2,inputChar,testCharUsed,testNameUsed center;

class choiceColor,createTable,randomPlayer center;

class testPlayerWin,inputShoot center;

class testColumnFill center;

class inputNewColumn center;

class updateData,giveHand center;

class updateTable,showShoot,test4Cases,testBoardFill center;

class showEnd center;