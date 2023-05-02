# PROJET_X

Dans cette branche on trouve tout ce qui est lié au serveurs.

Dans le dossier "src", on trouve les fichiers ".java"
Dans le dossier "out/src" on trouve les fichires ".class"

On peut compiler avec "javac @compile compile.list"
On exécute les fichiers avec "./start.sh"

Pour le serveur, nous avons utilisé des threads d'où la présence de "ClientThread.java"

########################

FONCTIONNEMENT

Le serveur tourne en boucle et attend des clients. 
Lorsqu'il trouve un client, il établit une liaison avec lui et vérifie son flag (identification).

Si il est reconnu, le serveur ouvre un thread qui s'occupera de la liaison avec le serveur.
Après avoir défini un pseudo, vous pouvez chatter avec les autres !
