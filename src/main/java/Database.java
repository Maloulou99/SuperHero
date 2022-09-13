public class Database {


    private Superhero[] superheros = new Superhero[5];
    private int n = 0;
    public void tilføjSuperhelt(String aliasNavn, String superNavn, String superkraft, boolean erMenneske, int oprindelsesÅr, double styrke){

        Superhero superhero = new Superhero(aliasNavn, superNavn, superkraft,erMenneske, oprindelsesÅr, styrke);


        superheros[n] = superhero;
    n++;
    }

    public Superhero[] getSuperheros(){
        return superheros;
    }

}
