# language: es

Característica: Reservar Vuelo en la Agencia
Dado que voy a viajar en avion
Como cliente de la agencia de viajes
Quiero poder comprar los vuelos de ida y regreso a mi destino


  Escenario: Carlos quiere viajar de Medellin-Colombia a Lima-Peru y quiere ver los vuelos disponibles
  Carlos prefiere escoger en que clase prefiere viajar.
  Consulta solo vuelos de ida y regreso para su destino.

    Dado que Carlos ha decidido reservar vuelos
    Cuando elige los vuelos de ida y regreso desde Medellin-Colombia para Lima-Peru en las fechas: 2019-01-01 a 2019-02-01
    Entonces el deberia poder confirmar su reservacion