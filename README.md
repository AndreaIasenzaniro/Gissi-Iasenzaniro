# OpenWeather

![OpenWeather Logo](https://openweathermap.org/themes/openweathermap/assets/img/logo_white_cropped.png)

> **Progetto sviluppato per l'appello del 25 Gennaio 2021 di Programmazione ad Oggetti.**

**Autori:**
- **Carlo Gissi**: 50%
- **Andrea Iasenzaniro**: 50%

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.4.0-green)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-11-orange)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

---

## Generalità

OpenWeather è un Web Service RESTful sviluppato utilizzando **SpringBoot** per facilitare la creazione e l'esecuzione di applicazioni Spring. Il servizio sfrutta i dati forniti dalle [API di OpenWeather](https://openweathermap.org/price#weather) per rispondere alle richieste HTTP da parte di client come Postman o siti web.

## Introduzione a Spring e Spring Boot

**Spring** è un framework open source per lo sviluppo di applicazioni Java EE. Fornisce supporto completo per lo sviluppo di applicazioni aziendali robuste e scalabili. Spring semplifica lo sviluppo tramite un'architettura modulare e l'inversione del controllo (IoC), che promuove una maggiore testabilità e manutenzione del codice.

**Spring Boot** è un progetto della famiglia Spring che facilita la creazione di applicazioni stand-alone, production-ready, con il minimo sforzo di configurazione. Fornisce una serie di caratteristiche chiave:

- **Configurazione Automatica**: Spring Boot può automaticamente configurare la tua applicazione in base alle dipendenze specificate.
- **Dipendenze Starter**: Gestisce le dipendenze per te, permettendoti di includere facilmente le librerie necessarie per la tua applicazione.
- **Server Embedded**: Viene fornito con Tomcat, Jetty o Undertow, eliminando la necessità di un container web esterno.
- **Actuator**: Fornisce funzioni pronte all'uso per monitorare e gestire la tua applicazione.

## Sviluppo

Per garantire l'uso didattico del nostro applicativo, abbiamo salvato in locale chiamate "pre-filtrate" alle API di OpenWeather. Nello specifico, il nostro archivio è stato popolato dal 2 gennaio 2021 al 10 gennaio 2021 tramite:

- **Chiamate Forecast**: eseguite a cadenza settimanale, filtrate per ottenere solo dati giornalieri.
- **Chiamate Current**: eseguite a cadenza oraria, ogni nuova ora del giorno.

## Utilizzo

### Diagramma dei Casi d'Uso

![Use Case Diagram](//www.plantuml.com/plantuml/png/XPAzJWCn48HxFyKgVOhyInGeKMWe42cWGXGhUo4hsRvWhn7YQUXv1BhmOgnEZYwv8AMuasRckz6DvMKMJ5A2DsYbIV1G4gjLrIe4ZgeJgY9ZIYQBcM1mBy8K2Uv8qA7W0333uthK4Uicvk85mHC8XHrfHqa4Zg54THkBdkNt2m8crhPmw1Z_qv45XREmtLAb9XsrskqyMuGNzfAuvjEZFDajltC3DoY7UDR56qoPusiDvaVVsRV2cJ-vqQ4walK5gyrj9HV6rCE2uV2w7N-gnpqzCVh0yCbXtf9xRhqfNC7-cpw4ejl_63LwmAm5E5fV7BN4h4VCpuXvZrYS4QEB7UCB_s5EhqQTk31B7LA2_mC0)

Il nostro applicativo permette di interrogare il DataSet locale tramite metodi GET e POST per ottenere:

- Informazioni sui **metadata** dei dati ricevuti.
- **Previsioni attuali** per una città specifica.
- **Statistiche** (media, varianza, temperature massima e minima) per una città in un periodo di tempo definito dall'utente.
- Numero di **previsioni azzeccate** rispetto a un margine di errore fornito dall'utente.
- **Filtraggio del DataSet** storico locale.

### Rotte Disponibili

| TIPO | ROTTA | DESCRIZIONE |
|------|-------|-------------|
| GET  | `/metadata` | Restituisce l'elenco degli attributi dei dati input e output. |
| GET  | `/current` | Interroga le API fornendo il nome della città per ottenere previsioni attuali. |
| POST | `/currentstats` | Restituisce statistiche sulle temperature basate sui filtri del body della richiesta. |
| POST | `/currentfilter` | Restituisce le previsioni orarie di una città filtrate secondo il body della richiesta. |
| POST | `/index` | Restituisce l'accuratezza della previsione effettuata in base all'errore passato nel body della richiesta. |

### Filtri Applicabili

| ROTTA | OPERATORE | DESCRIZIONE | ESEMPIO |
|-------|-----------|-------------|---------|
| `/currentstats` | cityName, inInstant, finInstant | Nome della città e intervallo temporale di ricerca. | `{"cityName":"Ancona","inInstant": "03/01/2021 10:00:00","finInstant":"06/01/2021 10:00:00"}` |
| `/currentfilter` | cityName, inInstant, finInstant | Nome della città e intervallo temporale di ricerca. | `{"cityName":"Ancona","inInstant": "02/01/2021 10:00:00","finInstant":"04/01/2021 21:00:00"}` |
| `/index` | cityName, inInstant, finInstant, errorMarg | Nome della città, intervallo temporale e margine di errore della previsione. | `{"cityName": "Ancona","inInstant": "02/01/2021 10:00:00","finInstant": "10/01/2021 00:00:00","errorMarg": 5}` |

> **NOTA**: La rotta `/currentfilter`, in assenza di intervallo temporale fornito, restituisce l'intero DataSet locale.

## Struttura Interna

### Diagramma delle Classi

![Class Diagram](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/ClassDiagram.JPG?raw=true)

## Funzionamento Interno

### Diagramma delle Sequenze

- **GET /metadata**
  ![GET /metadata](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/GET%20:metadata.png?raw=true)

- **GET /current**?city=cityName
  ![GET /current](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/GET%20:current.png?raw=true)

- **POST /currentstats**
  ![POST /currentstats](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/POST%20:currentstats.png?raw=true)

- **POST /currentfilter**
  ![POST /currentfilter](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/POST%20:currentfilter.png?raw=true)

- **POST /index**
  ![POST /index](https://github.com/CarloGissi/Gissi-Iasenzaniro/blob/main/UML/POST%20:index.png?raw=true)

---

## Licenza

Questo progetto è sotto licenza MIT. Vedi il file [LICENSE](LICENSE) per maggiori dettagli.

---

_**OpenWeather**: Portare il clima nelle tue mani._

---

## 👥 Autori 

|Nome | GitHub |
|-----------|--------|
| 👨 `Iasenzaniro Andrea` | [Click here](https://github.com/AndreaIasenzaniro) |
| 👩 `Gissi Carlo` | [Click here](https://github.com/CarloGissi) |
