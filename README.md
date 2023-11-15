# Progetto Gestione Account

Questo progetto Java è un'applicazione di gestione account che include funzionalità di login, creazione di account, operazioni CRUD (Create, Read, Update, Delete) e una funzione aggiuntiva di cambio password. Il codice è strutturato in cinque parti, ciascuna corrispondente a una parte specifica del progetto.

## Contenuto

1. [Creazione Account](#creazione-account)
2. [Login](#login)
3. [CRUD di Dati Utente](#crud-di-dati-utente)
4. [Funzione Aggiuntiva - Cambio Password](#funzione-aggiuntiva---cambio-password)

## Creazione Account

### Obiettivo
Implementare una funzione per permettere agli utenti di creare un nuovo account.

### Dettagli
- Chiedere all'utente di inserire un username unico e una password.
- Validare che l'username non esista già.
- Salvare i dettagli dell'account in una struttura dati appropriata (es. HashMap).

ESEMPI UTILIZZO
GestioneAccount gestioneAccount = new GestioneAccount();
gestioneAccount.registraAccount();
# Account


### Login

Obiettivo
Creare una funzione di login che consenta agli utenti di accedere utilizzando le credenziali create.

Dettagli
Chiedere all'utente di inserire username e password.
Verificare che le credenziali corrispondano a quelle di un account esistente.
Se le credenziali sono corrette, consentire l'accesso; altrimenti, mostrare un errore.

ESEMPIO UTILIZZO
LoginManager.login();


### CRUD di Dati Utente

Obiettivo
Implementare le funzionalità CRUD per i dati dell'utente.

Dettagli
Create: Permettere agli utenti di aggiungere nuove informazioni dopo il login.
Read: Consentire agli utenti di visualizzare le loro informazioni.
Update: Permettere agli utenti di modificare le loro informazioni.
Delete: Consentire agli utenti di eliminare il loro account.

ESEMPIO UTLILIZZO

UserDataManager.createData();
UserDataManager.readData();
UserDataManager.updateData();
UserDataManager.deleteData();


### Funzione Aggiuntiva - Cambio Password

Obiettivo
Aggiungere una funzione che permetta agli utenti di cambiare la password.

Dettagli
Chiedere all'utente la vecchia password, poi la nuova password.
Verificare che la vecchia password sia corretta prima di permettere il cambio con la nuova.
Aggiornare la password nell'archivio dati.


ESEMPI UTILIZZO
PasswordManager.changePassword();









