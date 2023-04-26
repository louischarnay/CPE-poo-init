# CPE-2223-3ICS-POO_FilRouge

Ce dépôt contient le projet de départ pour les ateliers du module :

"Programation Orientée Objet (POO) / Conception Orientée Objet (COO)"

Environnement de travail : **Java 11**.

Mode opératoire : 
- `git clone`
- ouvrir le projet avec l'IDE de votre choix
  - valider "utiliser la configuration Maven",  
    (ou toute question du même type que vous poserait votre IDE)

# tldr;

## Environnement

Pour faciliter sa reconnaissance par un maximum d'IDE, l'arborescence du projet suit les conventions Maven [[?](https://maven.apache.org/)].  

Maven assure également la gestion des dépendances du projet (i.e. ici JavaFx, principalement)

Il n'est cependant pas nécessaire d'employer `mvn` pour compiler ou lancer le projet : vous devriez pouvoir employer les outils habituels de votre IDE.

    TODO : à confirmer pour ce qui concerne les test unitaires (et leur dépendance à JUnit)
     -- mais leur présence dans le projet n'est de toute manière qu'expérimentale.

La configuration de Maven (`pom.xml`) cible un environneent Java 11 (LTS), 
mais il doit parfaitement être possible de cibler Java 1.8 (LTS)  
(dans ce scénario, supprimer si besoin le fichier `src/main/java/module-info.java`).
