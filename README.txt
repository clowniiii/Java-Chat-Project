----------------------------------------------------
Copyright 2019
----------------------------------------------------
Java Chat Projekt - Server und Client Programm
----------------------------------------------------


Inhalt
----------------------------------------------------

- Beschreibung des Programms

- Funktionen

- Nutzerhinweise
----------------------------------------------------



-- Beschreibung des Programms -- 

Es liegt ein Chat - Programm vor, welches dazu dient, Clients miteinander kommunizieren zu lassen.
Dazu werden die Nachrichten nicht P2P an die teilnehmenden Clients gesendet, sondern an einen Server,
welcher die Nachrichten wiederum verteilt, so dass jeder diese lesen kann. Dadurch entsteht ein großer
Chatraum, in welchem alle Messages gesammelt werden. Diese werden zentral auf dem Server gesichert, der
somit auch als zentrale Anlaufstelle dient.
Das Projekt enthält zudem eine Datenbank, um Daten zu speichern und ein Spiel, welches später beschrieben
wird.

-- Grundlegende Funktionen -- 

Das Client Programm dient als Sender von Nachrichten. Der Nutzer sieht eine GUI, in welche er seinen Namen
und eine Nachricht eingeben kann - anschließend sendet er diese an den Server. Dieser nimmt die eingehende
Verbindung des Clients, sowie den Inhalt der Nachricht an. Dazu bedienen wir uns dem Prinzip der Sockets,
welche vom Server verwaltet werden. Hat der Server die Verbindung angenommen und die Nachricht empfangen, so
sendet er diese an alle Clients, die momentan mit ihm verbunden sind. Auf den Oberflächen erscheinen so die
gesendeten Nachricht. Kommt ein neuer Client hinzu, kann er nur neu gesendete Nachrichten sehen.

Wie erwähnt, werden Sockets verwendet, um dafür zu sorgen, dass sich mehrere Clients in einem Netzwerk mitein-
ander unterhalten können. Demnach können nicht nur mehrere Clients auf einem PC, sondern auf mehreren gestartet
werden. Wichtig ist dabei nur die IP Adresse des Server - PCs und der entsprechende lauschende Port. 

-- Erweiterte Funktionen --

Die Nutzer finden auch ein Spiel vor - eine Version von Höher oder Niedriger - um sich die Zeit zu 
vertreiben.

-- -- Höher oder Niedriger -- --

Die Clients bzw. die Spieler sollen sich in einer Lobby sammeln können, um gegeneinander die gesuchte Zahl
zu erraten. Das Programm generiert eine zufällige Zahl zwischen 1 und 1000. Die Nutzer haben dann die Möglichkeit,
in dem dafür vorgesehenen Eingabefeld ihre gewünschte Zahl einzugeben. Ist die eingegebene Zahl größer oder kleiner
als die Gesuchte, bekommen die Spieler dies mitgeteilt - im unteren Bereich der GUI sind Felder, die dies deutlich
machen. Wurde in einer Runde die Zahl nicht gefunden, beginnt die nächste. Es wird gespielt, bis ein Spieler erfolgreich
war. Alle bekommen dies auf der GUI mitgeteilt. 

Die eingegebenen Zahlen werden an der Server gesendet, der diese verarbeitet (Prüfung, ob größer oder kleiner) und das Ergebnis
an alle angemeldeten Clients
verteilt. 

-- -- Datenbank -- -- 

Um Nutzerdaten und Nachrichten zu sichern, läuft im Hintergrund außerdem ein Datenbankserver mit entsprechender
Datenbank.

-- Nutzerhinweise --

Zunächst wird das Server Programm, geschrieben in Java, gestartet. Mehr ist nicht zu tun, da dazu keine GUI
entwickelt wurde.
Anschließend kann das Chat Client Programm gestartet werden (es sind allerdings auch mehrere Clients möglich).
Es erscheint die Chat Oberfläche, mit einem Eingabefeld für den Namen des Schreibenden und den Bereich für die
Nachricht. Wurde eine Nachricht eingegeben, kann mit der ENTER Taste oder mit einem Click auf den "Senden" Button
die Nachricht an den Server gesendet werden. Danach sollte die Nachricht im Dialog-Bereich zu sehen sein.

----------------------------------------------------