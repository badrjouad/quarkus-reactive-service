Feature: Tarification dynamique

  Scenario: En tant qu’utilisateur, je veux rechercher un vol simple entre Paris et Rome pour une date donnée
    Given la ville de départ est "Paris"
    And la ville d'arrivée est "Rome"
    And la date de départ est "2025-07-10"
    When l'utilisateur effectue une recherche de vols
    Then une liste de vols disponibles est retournée
    And chaque vol contient un prix de base

  Scenario: En tant qu’utilisateur mobile, je veux voir des prix ajustés pour mobile
    Given la ville de départ est "Lyon"
    And la ville d'arrivée est "Madrid"
    And la date de départ est "2025-07-10"
    And l'utilisateur utilise un appareil "mobile"
    When l'utilisateur effectue une recherche de vols
    Then le prix retourné est ajusté selon le device

  Scenario: En tant que client Gold, je veux obtenir des offres personnalisées
    Given la ville de départ est "Nice"
    And la ville d'arrivée est "Berlin"
    And la date de départ est "2025-07-10"
    And le client a le statut "GOLD"
    When l'utilisateur effectue une recherche de vols
    Then le prix est ajusté selon le statut du client

  Scenario: En tant qu’utilisateur, je veux bénéficier de meilleurs prix en réservant tôt
    Given la ville de départ est "Paris"
    And la ville d'arrivée est "Londres"
    And la date de départ est "2025-07-10"
    And la recherche est faite à "08:00"
    When l'utilisateur effectue une recherche de vols
    Then le prix est inférieur à celui de l’après-midi

  Scenario: En tant que client régulier, je veux simuler mes prix personnalisés
    Given la ville de départ est "Marseille"
    And la ville d'arrivée est "Amsterdam"
    And la date de départ est "2025-07-10"
    And un utilisateur ayant un historique de 10 réservations
    When l'utilisateur effectue une recherche de vols
    Then il voit des offres priorisées avec des prix réduits
