public class Kochbuch {
    private String name;
    private Rezept[] rezepteListe;

    public Kochbuch(String name, int anzahlRezepte) {
        this.name = name;

        if (anzahlRezepte < 1) {
            anzahlRezepte = 1;
        }

        rezepteListe = new Rezept[anzahlRezepte];
        // Füge leere Rezepte hinzu, um die gewünschte Anzahl zu erreichen
        
    }

    public void rezeptHinzufuegen(Rezept rezept) {
       
        // Finde eine leere Stelle im Kochbuch und füge das Rezept hinzu
        for (int i = 0; i < rezepteListe.length; i++) {
            if (rezepteListe[i] == null) {
                rezepteListe[i] = rezept;
                break;
            }
        }
    }

    public void rezeptEntfernen(String name) {
        for (int i = 0; i < rezepteListe.length; i++) {
            if (rezepteListe[i].getName().equals(name)){
                rezepteListe[i] = null;
                break;
            }
        }
    }

    public void findeSchnelleRezepte() {
        for (Rezept rezept : rezepteListe) {
            if (rezept != null && rezept.gettime() <= 30) {
                System.out.println(rezept.toString());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Kochbuch kochbuch = new Kochbuch("Kochen für Programmierer*innen", 15);

        Rezept rezept1 = new Rezept("Pasta Carbonara", "Mittel", 30);
        Rezept rezept2 = new Rezept("Tomato Soup", "Leicht", 20);
        Rezept rezept3 = new Rezept("Chicken Curry", "Schwer", 45);
        Rezept rezept4 = new Rezept("Salad Bowl", "Leicht", 15);

        kochbuch.rezeptHinzufuegen(rezept1);
        kochbuch.rezeptHinzufuegen(rezept2);
        kochbuch.rezeptHinzufuegen(rezept3);
        kochbuch.rezeptHinzufuegen(rezept4);

        kochbuch.findeSchnelleRezepte();
    }
}
