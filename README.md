# OpenWeather

## Autori
* Carlo Gissi: 50%
* Andrea Iasenzaniro: 50%

## Panoramica generale
L'applicativo da noi sviluppato è un RESTful web, cioè un sistema che, mediante il protocollo HTTP, è in grado di rispondere a delle richieste di un Client, quale Postman o un sito web, ed interagire con utenti mediante delle funzioni e/o rotte prestabilite. 
Il nostro Progetto viene implementato servendoci delle funzionalità di SpringBoot, un progetto Spring che ha lo scopo di facilitare lo sviluppo e l'esecuzione di applicazioni Spring, e l'utilizzo di API OpenWeather, delle quali due tipi: Current e Forecast.

## Premessa
Per permettere l'utilizzo didattico del nostro applicativo è stato necessario salvare in locale chiamate "filtrate" alle API sopra citate.
Il nostro archivio è stato popolato dal 24-12-2020 fino al 00-00-0000 e si compone di due file.txt che sono rispettivamente: currentWeather.txt che salva chiamate orarie alle Current Api, forecastWeather.txt che salva chiamate settimanali alle Forecast Api.
</p>
Per questioni pratiche le chiamate Forecast sono state preventivamente filtrate in modo tale da richiamare solo dati riferiti alle situazioni giornaliere.
