## Synopsis

Ce TP a pour but de créer un backend en Java (TP JPA + JaxRS + Servlet) et un frontend en Angular 1 ou 2. Nous avons choisi d'utiliser Angular 2 pour mener à bien notre mission.

Ce tp a été réalisé par deux binômes:

- Antoine Ravet
- Alexis Renault
- Pierre Louis Ollivier
- Godis Bodie

## Mise en oeuvre 

Etape 1 : Lancer la classe JPATest pour peupler la base de données. Celle-ci est composée des tables suivantes : Person, Home, ElectronicDevice, Heater, Pers_home. (Vérifier le fichier persistence.xml en mode "create")

Etape 2 : Lancer Maven avec l'instruction "tomcat7run" , qui va se charger de lancer le serveur Tomcat

Etape 3 : Effectuer la commande "npm install" pour installer les dépendances. (mettre le fichier persistence.xml en mode "update")

Etape 4 : Effectuer la commande "npm start" pour lancer le web service

Etape 5 : Se rendre sur localhost:4200 pour accéder à l'application

## Partie JPA

Cette partie se trouve dans le package "domain" qui contient 5 classes liées au diagramme UML fourni dans le TP. Nous avons choisi de rajouter une classe SmartPeripheric pour créer une situation d'héritage.

## Partie JaxRS

Cette partie se trouve dans le package "rest" qui contient 4 classes relatives au Web Service de l'application. Dans ces classes, sont définies : les routes et les fonctions qui leurs sont liées, le type de requête HTTP. 

## Partie Servlet

Cette partie se trouve dans le package "servlet". Il contient une classe PersonServlet qui contient une méthode POST et une méthode GET. Elles permettent respectivement de créer une personne en renseignant ses attributs et de récupérer l'ensemble des personnes présentes en base de données.

## Partie Client

La partie client se compose de 5 modules : electronicdevice, heater, home, menu et person. Chaque module est composé d'un component en angularJS, d'une page HTML et d'une page CSS liées au component. 
Pour accéder à ces modules, nous avons définis une page app.route.ts et nous les avons importés dans l'application via la page app.module.ts.
- Les modules electronicdevice, heater, home et person contiennent 3 fonctions qui permettent soit de récupérer la liste des objets relatifs au module appelé, soit de récupérer un objet précis ou alors d'ajouter un objet en renseignant un formulaire. On peut lier des persons, des heaters et des electronicdevices à une home.
- Le module menu, quant à lui, charge une navbar bootstrap qui contient les différents liens permettant d'accéder aux modules de l'application


