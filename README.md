SAE 2.03 équipe 10
Nous vérifions d'abord les paramètres de configuration actuelle de git sur notre machine avec la commande :

$:> git config --list

ce qui affiche les informations suivantes :

user.name=... user.email=... color.status=auto color.branch=auto color.interactive=auto color.diff=auto push.default=matching merge.tool=...

On intégre ensuite dans les commits que nous commençons à créer les informations suivantes :

$:> git config --global user.name "Nom Prénom" $:> git config --global user.email notreemail@gmail.com

On crée ensuite des dossiers comme ci-dessous :

$:> tree courseGIT courseGIT/ └── tp1

On initialise après notre répertoire local git :

$:> git init

2.1. La commande "git status" : La commande "git status" nous permet de vérifier les modifications apportées aux fichiers dans le répertoire local git (working directory).

$:> git status On branch master

Initial commit

nothing to commit (create/copy files and use "git add" to track)

Nous créons le fichier README.md avec les informations de notre répertoire git :

$:> git status On branch master

Initial commit

Untracked files: (use "git add ..." to include in what will be committed)

README.md
On l'ajoute après au git pour qu'il soit mis à jour sur github au prochain push

$:> git add README.md

On vérifie que notre fichier est bien ajouté.

$:> git status On branch master

On fait un premier commit avec le commentaire de ce que l'on change :

$:> git commit -m "Ajoute du fichier README.md" [master (root-commit) 23782d5] Ajoute du fichier README.md 1 file changed, 0 insertions(+), 0 deletions(-) create mode 100644 README.md

Cela devrait nous donner la sortie suivante :

$:> git status On branch master nothing to commit, working directory clean

$:~/courseGIT/tp1> tree . ├── README.md └── src └── Cryptomonnaie.java

On édite le fichier java avec le code suivant :

public class Cryptomonnaie{ private String nom; private double valeurDeJeton; // Imaginons en euros

public Cryptomonnaie(String nom, double valeurDeJeton){
    this.nom = nom;
    this.valeurDeJeton = valeurDeJeton;
}
}

On compile notre fichier java :

$:~/courseGIT/tp1/src> javac Cryptomonnaie.java

et on répète le processus pour ajouter notre fichier au répertoire git : $:~/courseGIT/tp1/src> git status On branch master Untracked files: (use "git add ..." to include in what will be committed)

    Cryptomonnaie.class
nothing added to commit but untracked files present (use "git add" to track)

On crée ici le .gitignore :

$:~/courseGIT/tp1> touch .gitignore

$:~/courseGIT/tp1> git add .gitignore

$:~/courseGIT/tp1> git commit -m ".gitignore ajouté"

et on ajoute ce contenu dedans :

Compiled class file
*.class

Package Files
*.jar *.war *.nar *.ear *.zip *.tar.gz *.rar

Nous avons ensuite vu comment se connecter à notre compte github. Il faut commencer par générer une clé ssh avec la commande :

ssh-keygen

puis lire la clé avec :

cat ~/.ssh/id_rsa.pub

Ensuite on crée un répertoire en ligne sur github. Et l'on ajoute a notre repertoire local de quoi s'y connecter :

git remote add origin git@github.com:<votre_utilisateur>/tp1.git

On peut ici regarder les différentes branches du projet : git branch

Ajouter nos modifications sur une branche précise : git push -u origin master

Récupérer le contenu du projet : git pull

Et de quoi regarder les modifications et différent commits : git log git status


//////////////
//////////////
AJOUT SEB TP 3
//////////////
//////////////


Nous avons aussi vu le point principal de github, travailler en équipe.

La première chose à faire fut d'avoir un dépot github à partager, puis d'y inviter des "collaborateurs".

Pour se faire il suffit d'aller dans la rubrique "Access" de l'onglet "Settings" de son dépot. On y trouve le bouton "Add people".
	PS : On peut inviter un collaborateur avec son adresse email ou son pseudo github

Chaque collaborateur peut aller cloner le répertoire et travailler dessus
       (commande -> git clone git@github.com:<utilisateur_de_athos>/tp3.git)

Chaque collaborateur peut aller modifier des fichiers et les envoyer au dépot github avec la commande "git push".
	Pour synchroniser votre répertoire avec celui du dépôt github, la commande "git pull" est nécessaire.

Pour l'exemple, il était demandé à Athos de compléter le code du fichier "CryptoMarché.java" et à Porthos celui de "Portefeuille.java".
	Après que Athos et Porthos ait terminé et envoyé leur code avec "git push", puis s'être synchronisé avec "git pull", la compilation de "TestCryptoMarche.java" devait renvoyer "OK" à tous les tests

Ensuite, nous avons abordés le concept de "branches" :
	
	-Comment les lister    : git branch
	-Comment les créer     : git checkout -b <nom_de_la_branche>
	-Comment les fusionner : git merge <nom_de_branche_existante>

Nous avons aussi vu fait appel à la commande "git log" pour consulter les modifications apportées

Pour les exercices, Athos et Porthos devaient chacun créer leur devise (un fichier java héritant de Cryptomonnaie).
Il a ensuite fallu merge les deux branches créées et cela donne un dépôt github contenant les deux différentes devises.
