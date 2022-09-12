public class Database {


    public Superhero[] superheroData = new Superhero[5];
    int n = 0;
    public void tilføjSuperhelte(String aliasNavn, String superNavn, String superkraft, boolean erMenneske, int oprindelsesÅr, double styrke){

        Superhero superhero = new Superhero(aliasNavn, superNavn, superkraft,erMenneske, oprindelsesÅr, styrke);


        superheroData[n] = superhero;
    n++;
    }
}
