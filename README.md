# SAE 2.03 équipe 10

Nous vérifions d'abords les paramètres de configuration actuels de git sur notre machine avec la commande :

$:> git config --list

ce qui affiche les informations suivante :

user.name=...
user.email=...
color.status=auto
color.branch=auto
color.interactive=auto
color.diff=auto
push.default=matching
merge.tool=...

On intégres ensuite dans les commits que nous commençons à créer les informations suivantes :

$:> git config --global user.name "Nom Prénom"
$:> git config --global user.email notreemail@gmail.com

On créer ensuite des dossiers comme ci dessous :

$:> tree courseGIT
courseGIT/
└── tp1

On initialise après notre répertoire local git :

$:> git init

2.1. La commande git status
La commande git status nous permet de vérifier les modifications apportées aux fichiers dans le répertoire local git (working directory).

$:> git status
On branch master

Initial commit

nothing to commit (create/copy files and use "git add" to track)

Nous créons le fichier README.md avec les informations de notre répertoire git :

$:> git status
On branch master

Initial commit

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	README.md
  
  On l'ajoute après au git pour qu'il soit mise à jour sur github au prochain push
  
  $:> git add README.md

  On vérifie que notre fichiers est bien ajouté.
  
$:> git status
On branch master
  
  On fais un premier commit avec le commentaire de ce que l'on change :
  
$:> git commit -m "Ajoute du fichier README.md"
[master (root-commit) 23782d5] Ajoute du fichier README.md
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 README.md
  
  devrait nous donner la sortie suivante :

$:> git status
On branch master
nothing to commit, working directory clean
  
  $:~/courseGIT/tp1> tree
.
├── README.md
└── src
    └── Cryptomonnaie.java
  
On édite le fichier java avec le code suivant :

public class Cryptomonnaie{
    private String nom;
    private double valeurDeJeton; // Imaginons en euros

    public Cryptomonnaie(String nom, double valeurDeJeton){
        this.nom = nom;
        this.valeurDeJeton = valeurDeJeton;
    }
}

  On compile notre fichier java :
  
  $:~/courseGIT/tp1/src> javac Cryptomonnaie.java

  et on répete le processus pour ajouter notre fichier au répertoire git : 
$:~/courseGIT/tp1/src> git status
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)

        Cryptomonnaie.class

nothing added to commit but untracked files present (use "git add" to track)

On créer ici le .gitignore :

$:~/courseGIT/tp1> touch .gitignore

$:~/courseGIT/tp1> git add .gitignore
	
$:~/courseGIT/tp1> git commit -m ".gitignore ajouté"

et on ajoute ce contenue dedans :

# Compiled class file
*.class

# Package Files 
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar
