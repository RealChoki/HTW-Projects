public class Rezept {
    private final String name;
    private final String difficulty;
    private final int time;

    public Rezept(String name, String difficulty, int time) {
        this.name = name;
        this.difficulty = difficulty;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getdifficulty() {
        return difficulty;
    }

    public int gettime() {
        return time;
    }

    @Override
    public String toString() {
        return "Rezept: " + name + "\ndifficulty: " + difficulty
                + "\nKochzeit in Minuten: " + time;
    }

    public static void main(String[] args) {
        Rezept rezept = new Rezept("Pasta Carbonara", "Mittel", 30);
        System.out.println(rezept.toString());
    }
}
