# PROJET_X

# PROJET_X

Dans cette branche, on trouve tout se qui se rapporte au dockerfile.

On peux construire le docker avec "dockerrun.sh".

Notre dockerfile se construit à partir du dernier OS debian, auquel on rajoute les paquets super-utilisateurs "sudo".

On installe le nécessaire java et github en plus d'outilis réseaux afin de récupérer le contenu du github avec un gitclone du répertoire puis l'exécuter.

Il y a aussi des logs créés à chaque entrée dans la console du docker.
