import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    ArrayList<Superhero> superheros = new ArrayList<>();
    public void tilføjSuperhelt(String aliasNavn, String superNavn, String superkraft, boolean erMenneske, int oprindelsesÅr, double styrke) {
        Superhero superheros = new Superhero(aliasNavn, superNavn, superkraft, erMenneske, oprindelsesÅr, styrke);
    }
    public ArrayList<Superhero> getSuperheros() {
        return superheros;
    }

    /* Superhero[] superheros = new Superhero[5];

    private int n = 0;

    public void tilføjSuperhelt(String aliasNavn, String superNavn, String superkraft, boolean erMenneske, int oprindelsesÅr, double styrke){

        Superhero superhero = new Superhero(aliasNavn, superNavn, superkraft,erMenneske, oprindelsesÅr, styrke);


        superheros[n] = superhero;
    n++;
    }
 ArrayList<Superhero> superheros = new ArrayList<>();
    Superhero spiderman = new Superhero("Peter Parker", "Spiderman", "Evnen til at hænge fast til næsten alle overflader", true, 1962, 13.567);
    Superhero ninjaTurtles = new Superhero("Michelangelo", "Nej", "Agilitet, hurtighed og styrke på olympisk niveau", false, 1984, 69.477);

    private ArrayList<Superhero> getSuperheroes() {
        superheros.addAll(Arrays.asList(spiderman, ninjaTurtles));
        superheros.add(spiderman);
        superheros.add(ninjaTurtles);

    return superheros;
    }*/

}


