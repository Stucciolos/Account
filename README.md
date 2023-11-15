# Progetto Gestione Account

Questo progetto Java è un'applicazione di gestione account che include funzionalità di login, creazione di account, operazioni CRUD (Create, Read, Update, Delete) e una funzione aggiuntiva di cambio password. Il codice è strutturato in cinque parti, ciascuna corrispondente a una parte specifica del progetto.

## Contenuto

1. [Creazione Account](#creazione-account)
2. [Login](#login)
3. [CRUD di Dati Utente](#crud-di-dati-utente)
4. [Funzione Aggiuntiva - Cambio Password](#funzione-aggiuntiva---cambio-password)
5. [Versionamento con Git](#versionamento-con-git)

## Creazione Account

### Obiettivo
Implementare una funzione per permettere agli utenti di creare un nuovo account.

### Dettagli
- Chiedere all'utente di inserire un username unico e una password.
- Validare che l'username non esista già.
- Salvare i dettagli dell'account in una struttura dati appropriata (es. HashMap).

### Esempio di Utilizzo
```java
GestioneAccount gestioneAccount = new GestioneAccount();
gestioneAccount.registraAccount();
# Account
