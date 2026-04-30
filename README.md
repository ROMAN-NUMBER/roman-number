# roman-number

////////////////////////////////////////////////////////////////////
 // LAURA GRANESE 2145592
 // SOFIA BORTOLOTTO 2147989
//////////////////////////////////////////////////////////////////// 

[![CI Pipeline](https://github.com/ROMAN-NUMBER/roman-number/actions/workflows/ci.yml/badge.svg)](https://github.com/ROMAN-NUMBER/roman-number/actions/workflows/ci.yml)

[![Coverage Status](https://coveralls.io/repos/github/ROMAN-NUMBER/roman-number/badge.svg?branch=main)](https://coveralls.io/github/ROMAN-NUMBER/roman-number?branch=main)


Il progetto prevede la realizzazione di un sistema in grado di convertire numeri arabi (compresi tra 1 e 1000) nei corrispondenti numeri romani, con una rappresentazione finale in formato ASCII art. L’obiettivo principale è stato quello di applicare pratiche discusse durante il corso di Metodi e Tecnologie dello Sviluppo Software, integrando analisi statica e Continuous Integration.

In particolare, sono stati applicati i seguenti strumenti e pratiche:
-  utilizzo del modello di branching Git Flow per la gestione strutturata dello sviluppo.
-  inizializzazione del progetto tramite Maven usando l’archetipo maven-archetype-quickstart
-  verifica della qualità del codice attraverso Analisi statica configurata con Checkstyle.
-  realizzazione di test unitari mediante JUnit, applicando i principi A-TRIP e Right-BICEP, assicurando una copertura del codice superiore all’85% e adottando il       pattern AAA (Arrange, Act, Assert)
-  automazione della build e del processo di integrazione continua attraverso pipeline di CI implementate con GitHub Actions

Test: Copertura del codice (Code Coverage) superiore all'85% (attuale: 89%).

Analisi Statica:
Il progetto utilizza Checkstyle per garantire il rispetto dei vincoli di qualità e manutenibilità del codice. La build fallisce automaticamente in presenza di violazioni, garantendo il rispetto degli standard.

Le attività sono state organizzate tramite una Project Board su GitHub e distribuite tra i membri del gruppo utilizzando il sistema di Issue Tracking. Lo sviluppo ha seguito il modello Git Flow, prevedendo l’apertura di una Pull Request per ciascuna nuova funzionalità implementata.

