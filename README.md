# L.10.3 ricorsione-su-filesystem

Si realizzi una classe **Cartella**, costruita con il percorso di una cartella reale.

La classe è dotata dei seguenti metodi statici:
- **cercaFile**: prende in input un oggetto File rappresentante una cartella e una stringa che contiene il nome di un file (compresa l'estensione) e cerca tale file all’interno della cartella; restituisce un booleano con l'esito della ricerca (`True` se il file è presente, `False` altrimenti).

    - ATTENZIONE: la ricerca deve essere eseguita *ricorsivamente* sulle eventuali sotto-cartelle contenute nella cartella principale


- **cercaEstensione**: prende in input prende in input un oggetto File rappresentante una cartella e una stringa contenente un'estensione di file (ad esempio `".txt"`) e restituisce un insieme contenente tutti i file con l’estensione specificata presenti nella cartella.
   
    - BONUS: realizzare una versione in overload di **cercaEstensione** che prende in input una cartella e una lista di estensioni di file e restituisce l'insieme dei file con tali estensioni presenti nella cartella


Inoltre, la classe ridefinisce il metodo **toString()** in modo che una cartella sia rappresentata dal suo nome seguito da una parentesi aperta,
dall’elenco di file e cartelle in essa contenuti separati da spazio e infine da una parentesi chiusa. 

Ad esempio, una cartella *src* organizzata nel modo seguente:

```
src
    it
        Prova.java
        Test.java
    org
        MyClass.java
    package-info.java
```

viene rappresentata dalla stringa:

```
"src[ it[ Prova.java Test.java ] org[ MyClass.java ] package-info.java ]"
```
