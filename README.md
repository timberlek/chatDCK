# PROJET_X

Dans cette branche se trouvent tout ce qui se rapportent au client.

Dans le dossier "src" se trouvent les ".java" 
Dans le dossier "out" se trouvent les ".class"

il y a 3 façons de compiler avec le compile.sh / .bat / .list

      -"javac @compile compile.list"
      -"./compile.sh"
      -"./compile.bat"

 Ici on définit le client ainsi que son interface graphique.
 
Le client envoie une bannière, une façon de l'identifier au serveur.
Si la bannière correspond, la connexion est acceptée et on vous demande votre pseudo.
En cas d'échec, vous serez prévenus par le serveur "flag non reconnu".
