[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/zcerwHOQ)
# Hausaufgabe Nr. 5

In dieser Hausaufgabe geht es um Framework-Benutzung und Ereignisbehandlung.

## Abgabe

Nehmen Sie das Assignment auf Github Classroom an und wählen Sie Ihren Namen aus der Liste aus.
Dadurch wird ein (dieses) Repository für Sie erstellt. 
Klonen Sie das Repo und pushen Sie Ihre Lösungen in mehreren sinnvoll zusammengefassten Commits (z.B. einer pro Teilaufgabe, es können aber auch gerne mehr sein).
Sie müssen Ihre Lösung bis zum 22. Dezember um 23:59 Uhr gepusht haben, alle Tests müssen grün sein (und zwar auch auf GitHub!), und Sie müssen spätestens in der darauf folgenden von Ihnen belegten Übungsgruppe Ihre Lösung kurz demonstrieren.

## Aufgabenstellung

Lesen Sie als Vorbereitung die Dokumentation zu Spring Shell. Für die ersten Schritte reicht die ReadMe auf der offiziellen GitHub-Seite: https://github.com/spring-projects/spring-shell. Für die späteren Teilaufgaben sollten Sie die folgende Dokumentation im Tutorial-Stil betrachten, die es leider nur noch für eine ältere Version von Spring-Shell gibt: https://docs.spring.io/spring-shell/docs/2.0.0.RELEASE/reference/htmlsingle/. Für Details der aktuellen Spring-Shell-Version greifen Sie gerne auf die aktuelle API-Dokumentation zurück: https://docs.spring.io/spring-shell/docs/3.2.0-RC1/api/.

1.	Fügen Sie in der Datei `build.gradle` die Implementierungs-Abhängigkeit `spring-shell-starter` hinzu (so wie bei [Maven Central](https://central.sonatype.com/artifact/org.springframework.shell/spring-shell-starter/overview) als "Gradle (short)" dargestellt). Die Version müssen Sie jedoch nicht angeben, da ich Ihnen bereits die aktuelle Release-Candidate-Version `3.2.0-RC1` voreingestellt habe. Lassen Sie `gradle build` laufen und führen Sie dann `java -jar app/build/libs/app-0.0.1-SNAPSHOT.jar` aus. Nutzen Sie das `help` Kommando, um zu sehen, welche Befehle es gibt.
2.	Fügen Sie in der Klasse `PizzaBotCommands` die Annotations `@ShellComponent`, `@ShellMethod` und `@ShellOption` hinzu. Fügen Sie außerdem die `@Service`-Annotation an die zwei Parser- und Builder-Klassen an, die Sie der Klasse `PizzaBotCommands` als Abhängigkeiten zur Verfügung stellen möchten und testen Sie wieder mit `gradle build` und `java -jar ...`, ob neue Befehle hinzugekommen sind.
3.	Implementieren Sie die Methode `order()` entsprechend dem weiter unten spezifizierten Verhalten, sodass die entsprechenden Tests grün werden. Nutzen Sie dafür Code aus der `CommandLineUI` Klasse aus den vorherigen Hausaufgaben. Implementieren Sie dann die Methode `confirm()` ebenfalls und probieren Sie die Befehle im Shell-Programm aus.
4.	Erstellen Sie eine neue Klasse `PizzaBotPromptProvider` (in etwa wie hier beschrieben: https://docs.spring.io/spring-shell/docs/2.0.0.RELEASE/reference/htmlsingle/#_promptprovider, Achtung: importieren Sie `AttributedString` etc. aus dem Paket `org.jline.utils`) und nutzen Sie dann die Klassen `InputEvent` und `InputEventPublisher` um aus der `order()`-Methode Nachrichten an den `PizzaBotPromptProvider` zu senden, sodass der Prompt rot wird, wenn der Pizza-Bot etwas nicht verstanden hat und wieder grün, wenn doch.
    Demonstrieren Sie in der Übung, wie der Prompt je nach Eingabe die Farbe ändert. (Achtung: In manchen Kommandozeilen werden keine Farben angezeigt)


5.  Implementieren Sie nun eine Kommunikation zwischen `PizzaBotCommands` und `PizzaBotPromptProvider` nach dem Observer-Entwurfsmuster, sodass der Prompt immer die Anzahl der Pizzas in der laufenden Bestellung anzeigt, also z.B. `PIZZA-BOT(2):>` nach der zweiten erstellten Pizza. 
    Lassen Sie dazu zuerst diese beiden Klassen das `Observable` bzw. das `Observer` Interface aus dem gleichen Package implementieren und rufen Sie `notifyObservers` auf, sobald sich die Anzahl der erstellten Pizzas ändert. 
    Nutzen Sie im `PizzaBotPromptProvider` die Annotationen `@Autowired` und `@PostConstruct` um sich erst eine Instanz von `PizzaBotCommands` zu holen und sich dann als Observer bei dieser zu registrieren. 
    In der `update`-Methode können Sie nun einfach auf das nicht-private Attribut `orderedPizzas` von `PizzaBotCommands` (bzw. auf dessen Grösse) zugreifen.
    

# Anleitung
...zur Benutzung des Pizza-Bot Shell-Programms (erwartetes Verhalten).

Nach dem Start der Anwendung kann eine Bestellung wie folgt aufgegeben werden:

```bash
PIZZA-BOT:>order --text 'Ich hätte gerne eine Italian-style Pizza mit Champignons, Basilikum, Seitan-Chicken und Olivenöl'
In Ordnung. Deine 1. Pizza mit Basilikum, Champignons, Italian-style, Olivenöl, Seitan-Chicken] kostet 2.80 EUR.
Gib <confirm> ein, um die Bestellung abzuschliessen oder bestelle eine weitere Pizza mit <order -t '...'>
PIZZA-BOT:>order -t 'Ich hätte gerne eine weitere Italian-style Pizza mit Champignons, Basilikum und Olivenöl'
In Ordnung. Deine 2. Pizza mit Basilikum, Champignons, Italian-style, Olivenöl] kostet 1.90 EUR.
Gib <confirm> ein, um die Bestellung abzuschliessen oder bestelle eine weitere Pizza mit <order -t '...'>
PIZZA-BOT:>order 'Ich hätte gerne noch eine Italian-style Pizza mit Champignons, Basilikum und Olivenöl. Yummy'
In Ordnung. Deine 3. Pizza mit Basilikum, Champignons, Italian-style, Olivenöl] kostet 1.90 EUR.
Gib <confirm> ein, um die Bestellung abzuschliessen oder bestelle eine weitere Pizza mit <order -t '...'>
PIZZA-BOT:>
```

Zum Abschluss der Bestellung ist das Kommando `confirm` zu verwenden:

```bash
PIZZA-BOT:>confirm
Vielen Dank für deine Bestellung. Du hast 3 Pizzas bestellt. Die Gesamtsumme beträgt 6.60 EUR.
```

Das Programm kann mit `exit` beendet werden:

```bash
PIZZA-BOT:>exit
```
