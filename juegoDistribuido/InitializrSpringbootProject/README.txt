# Juego del Ahorcado - API REST

Este proyecto implementa un juego del ahorcado mediante una API REST desarrollada en Java con el framework Spring Boot. Permite a los usuarios iniciar un nuevo juego, unirse como jugadores, obtener el turno actual y realizar jugadas para adivinar una palabra secreta.

## Endpoints

### 1. Iniciar Juego

**Endpoint:** `POST /empezar_juego`

Inicia un nuevo juego del ahorcado. Si ya se inició un juego, devuelve un error. La palabra secreta se establece automáticamente.

### 2. Ingreso de Jugador

**Endpoint:** `POST /ingreso`

Permite a un jugador unirse al juego proporcionando su nombre. Si el juego ya comenzó o el límite de 5 jugadores se alcanzó, devuelve un error. El jugador se agrega si hay espacio disponible.

### 3. Obtener Turno Actual

**Endpoint:** `GET /turno_actual`

Devuelve el número del turno actual en el juego.

### 4. Jugar

**Endpoint:** `POST /jugar`

Permite a un jugador realizar una jugada especificando su nombre y la letra con la que desea intentar adivinar la palabra secreta. Devuelve información sobre el progreso, los intentos restantes y si el jugador ha ganado. El juego se reinicia automáticamente si un jugador gana.

## Ejemplo de Uso

### Iniciar Juego

```bash
curl -X POST http://localhost:8080/empezar_juego

curl -X POST http://localhost:8080/ingreso?nombre=Jugador1

curl http://localhost:8080/turno_actual

curl -X POST http://localhost:8080/jugar?nombre=Jugador1\&letra=A

Notas
El juego permite un máximo de 5 jugadores.
Se utiliza un temporizador de 20 segundos para esperar nuevos jugadores antes de comenzar el juego automáticamente.