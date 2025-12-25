Titre du projet :
TravelHub SQL – Services Web SOAP pour la réservation de vols et d’hôtels

--------------------------------
1. Description du projet
--------------------------------
Ce projet consiste à développer une application orientée services (SOA) pour une agence de voyage nommée TravelHub.
L’application repose sur deux services Web SOAP indépendants :
- FlightService : gestion et réservation des vols
- HotelService : gestion et réservation des hôtels

Les services accèdent aux bases de données SQL via JDBC et PreparedStatement.
Un client SOA découplé consomme les services à partir des WSDL générés, sans accès direct aux bases de données.

--------------------------------
2. Architecture
--------------------------------
- Base de données :
  * air_db (vols)
  * hotel_db (chambres)

- Services SOAP :
  * FlightService (AIR_DB)
  * HotelService (HOTEL_DB)

- Client :
  * client-agency (Java, SOAP)
  * Consommation des services via wsimport

--------------------------------
3. Technologies utilisées
--------------------------------
- Java
- Maven
- SOAP / JAX-WS
- JDBC
- phpMyAdmin
- IntelliJ IDEA

--------------------------------
4. Contenu du projet
--------------------------------
- flight-service/ : service SOAP pour les vols
- hotel-service/ : service SOAP pour les hôtels
- client-agency/ : client SOA (sans JDBC)
- sql/ : scripts SQL de création des bases et des tables
- wsdl/ : fichiers WSDL générés
- captures/ : captures d’écran avant et après réservation

--------------------------------
5. Fonctionnalités
--------------------------------
- Recherche de vols par destination
- Recherche d’hôtels par ville
- Réservation d’un vol (mise à jour du stock)
- Réservation d’une chambre (changement de disponibilité)
- Mise à jour transactionnelle des données

--------------------------------
6. Exécution du projet
--------------------------------
1. Exécuter les scripts SQL dans phpMyAdmin
2. Lancer FlightPublisher (port 8081)
3. Lancer HotelPublisher (port 8082)
4. Lancer AgencyClient
5. Effectuer une réservation via la console

--------------------------------
7. Remarques
--------------------------------
- Le client SOA ne contient aucun accès JDBC.
- Les transactions sont gérées côté services.
- Les WSDL sont valides et conformes aux standards SOAP.

--------------------------------
Fin du document
--------------------------------
