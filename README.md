# SimpLanPlus
In questo progetto viene sviluppato un compilatore in grado di eseguire SimpLanPlus, un
linguaggio imperativo che estende SimpLan, le sue caratteristiche sono elencate come segue:
1. I tipi ammessi sono: interi, booleani o void.
2. Le dichiarazioni di variabili sono della forma type ID e non ammettono inizializzazione in
fase di dichiarazione.
3. Il corpo di una funzione può contenere dichiarazioni e statement, e facoltativamente,
possono restituire il valore ottenuto da un’espressione. La dichiarazioni di variabli con
lo stesso id è possibile Nel corpo di una funzione è possibile accedere a variabili globali
e chiamare altre funzioni, se precedentemente dichiarate. Inoltre, è possibile dichiarare
una funzione all’interno del corpo di una funzione (se questa non hanno lo stesso id) ed
è possibile avere funzioni ricorsive, ma non mutuamente ricorsive.

Durante lo sviluppo del progetto devono essere soddisfatte le seguenti regole:
1. L'analizzatore lessicale deve ritornare la lista degli errori lessicali in un file
   di output.
2. Sviluppare la tabella dei simboli del programma.
   Il codice sviluppato deve controllare

   * identificatori/funzioni non dichiarati
   * identificatori/funzioni dichiarate piu` volte nello stesso ambiente

3. Sviluppare un'analisi semantica che verifica

   * la correttezza dei tipi (in particolare numero e tipo dei parametri attuali
     se conformi al numero e tipo dei parametri formali)

   * uso di variabili non inizializzate

4. Estendendo l'interprete di SimpLan, implementare l'interprete di SimpLanPlus.