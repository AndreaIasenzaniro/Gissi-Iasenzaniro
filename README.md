# OpenWeather
Il progetto sviluppato è relativo all'appello del 25 Gennaio 2021 di Programmazione ad Oggetti e gli autori sono:
* Carlo Gissi: 50%
* Andrea Iasenzaniro: 50%

## Generalità
Il Web Service da noi implementato è un RESTful web, cioè un sistema che, mediante il protocollo HTTP, è in grado di rispondere alle richieste di un Client, quale Postman o un sito web, ed interagire con gli utenti attraverso delle funzioni e/o rotte prestabilite. 
Il Progetto si serve delle funzionalità di SpringBoot: un progetto Spring che ha lo scopo di facilitare lo sviluppo e l'esecuzione di applicazioni Spring, e dei dati ricavati da [API OpenWeather](https://openweathermap.org/price#weather).

## Sviluppo
Per permettere l'utilizzo a scopo didattico del nostro applicativo è stato necessario salvare in locale chiamate "pre-filtrate" alle API sopra citate; nello specifico il nostro archivio è stato popolato dal 02-01-2021 fino al 10-01-2021 effettuando:
* chiamate **Forecast** a cadenza *settimanale* preventivamente filtrate in modo tale da richiamare solo dati riferiti alle situazioni giornaliere e non orarie;
* chiamate **Current**  a cadenza *oraria* allo scattare di ogni nuova ora del giorno.

## Utilizzo 
Partendo da questo diagramma ci si può rendere conto di come l'utente possa interagire con il Web Service

**Use Case Diagram**

![Alt text](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/UsecaseDiagram.JPG?raw=true)

In particolare in nostro applicativo permette di interrogare il DataSet locale mediante metodi GET e POST in modo tale da poter ricavare:
* Informazioni sui ***metadata*** relativi ai dati ricevuti come risposta dal programma;
* ***Previsioni attuali*** filtrate relative ad una città;
* ***Statistiche*** (media, varianza, temperatura massima e minima) relative ad una città, in arco di tempo scelto dall'utente;
* Quantità di ***previsioni azzeccate***, relative ad un dato margine di errore fornito dall'utente, in un arco di tempo variabile;
* ***Filtraggio DataSet*** storico locale;

Tali rotte sono così definite:

| TIPO | ROTTA |  DESCRIZIONE|
|-|-|-|
| GET | /metadata | restituisce l'elenco degli attributi (per nome, descrizione e tipo) dati in input dall'utente e/o forniti come risposta dal programma |
| GET | /current | permette di interrogare direttamente le api fornendo il nome della città di cui ottenere previsioni attuali  |
| POST | /currentstats | restituisce statistiche sulle temperature, reali e percepite, basandosi sui filtri inseriti nel body della richiesta |
| POST | /currentfilter | restituisce le previsioni orarie di una città filtrate in base al body della richiesta |
| POST | /index| restituisce l'accuratenzza della previsione effettuata, in base all'errore passato nel body della richiesta |

I possibili **filtri** da applicare sulle rotte sono:

| ROTTA | OPERATORE | DESCRIZIONE | ESEMPIO | 
|--|--|--|--|
| /currentstats | cityName, inInstanf, finInstant | nome della città ed estremi dell'intervallo temporale di ricerca | {"cityName":"Ancona","inInstant": "03/01/2021 10:00:00","finInstant":"06/01/2021 10:00:00"} |
|/currentfilter|cityName, inInstanf, finInstant| nome della città ed estremi dell'intervallo temporale di ricerca|{"cityName":"Ancona","inInstant": "02/01/2021 10:00:00","finInstant":"04/01/2021 21:00:00"}|
|/index|cityName, inInstant, finInstant, errorMarg| nome della città, estremi dell'intervallo temporale di ricerca e margine di errore della previsione effettuata|{"cityName": "Ancona","inInstant": "02/01/2021 10:00:00","finInstant": "10/01/2021 00:00:00","errorMarg": 5}|

**NOTA**

La rotta `/currentfilter` in assenza dell'intervallo di tempo fornito dall'utente restituisce l'intero DataSet locale.

## Struttura interna
Il seguente diagramma mostra come il programma è strutturato internamente.

**Class Diagram**

![Alt text](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/ClassDiagram.JPG?raw=true)

## Funzionamento interno
Di seguito viene illustrato il **Diagramma delle Sequenze** che mostra cosa avviene nel programma quando l'utente effettua una richiesta.
* **GET /metadata**
![Alt text](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/GET%20:metadata.png?raw=true)
* **GET /current**?city=cityName
![Alt text](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/GET%20:current.png?raw=true)
* **POST /currentstats**
![Alt text](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/POST%20:currentstats.png?raw=true)
* **POST /currentfilter**
![Alt text](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/POST%20:currentfilter.png?raw=true)
* **POST /index**
![Alt text](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/POST%20:index.png?raw=true)
