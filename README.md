# Free Games API

**English**

### Overview

An API that returns this week's free games from the [Epic Games Store](https://store.epicgames.com/).

You can try the API doing a GET request here: https://freegamesepic.onrender.com/api/games

The API updates weekly and returns a list of games, containing the name, a brief description of the game, and the offer type (base game or DLC).

**Endpoints**

* `/api/games`: Returns a list of all free games/DLCs.

**Response**

The response is a JSON object with de following properties:
* `title`: The title of the game.
* `description`: A brief description of the game.
* `offerType`: The type of offer (base game or DLC).

**Example** 
```json
  {
    "title": "My game",
    "description": "A great game",
    "offerType": "BASE_GAME"
  }
```

**Português**

### Overview

Uma API que retorna os jogos grátis da semana da [Epic Games Store](https://store.epicgames.com/).

Você pode testar API fazendo uma requisição do tipo GET aqui: https://freegamesepic.onrender.com/api/games

A API atualiza semanalmente e retorna uma lista de jogos, contendo o nome, uma breve descrição do jogo, e o tipo de oferta (jogo base ou DLC).

**Endpoints**

* `/api/games`: Retorna uma lista de todos os jogos/DLCs grátis.

**Resposta**

A resposta é objeto JSON com as seguintes propriedades:
* `title`: Título do jogo.
* `description`: Breve descrição do jogo.
* `offerType`: Tipo de oferta (jogo base ou DLC).

**Exemplo**
```json
  {
    "title": "Meu jogo",
    "description": "Um ótimo jogo",
    "offerType": "BASE_GAME"
  }
```