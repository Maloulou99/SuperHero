import java.io.SyncFailedException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Main {


    public static void main(String[] args) {

        //System.out.println("Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!");
        Database datebase = new Database();
        int brugerSvar;
        do {


            System.out.println("""
                    Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!
                    1. Opret superhelt
                    2. Udskriv alle superhelte
                    3. Søg efter superhelt
                    9. Afslut    
                        """);
                //Denne metode opretter vi en scanner til at kunne få input fra brugeren
                     Scanner input = new Scanner(System.in);
                     brugerSvar = input.nextInt();
                     String søgHelt;
                     boolean fundet = false;


            if (brugerSvar == 1) {

                System.out.println("Indtast din superhelts superhelte navn her: ");
                String aliasNavn = input.nextLine();
                System.out.println("Hvis din superhelt har et menneske navn så indtast her eller tryk ENTER for at gå videre: ");
                String superNavn = input.nextLine();
                System.out.println("Hvad er din superhelts superkraft?");
                String superkraft = input.nextLine();
                System.out.println("Er din superhelt et menneske? Skriv 'Ja' eller 'Nej'");
                String svar;
                svar = input.nextLine();
                boolean menneske = false;
                if (svar.equalsIgnoreCase("ja")) {
                    menneske = true;
                } else if (svar.equalsIgnoreCase("nej")) {
                    menneske = false;
                }
                System.out.println("Hvornår var din superhelt skabt? ");
                int oprindelsesÅr = input.nextInt();
                System.out.println("Hvor stærk er din superhelt? Skriv antallet her: ");
                double styrke = input.nextDouble();

                // Kigger ind i min database "superheros", bruger min setmetode "tilfoejSuperhelt" med inputs
                datebase.tilføjSuperhelt(aliasNavn, superNavn, superkraft, menneske, oprindelsesÅr, styrke);

                // TAST 2 - printer alle oprettede superhelte
            } else if (brugerSvar == 2) {

                for (Superhero superhelteListe : datebase.getSuperheros()) {
                    System.out.println(superhelteListe);
                }
            }
            // TAST 3 - Søger efter superhelt
            else if (brugerSvar == 3) {
                System.out.println("Indtast navn du søger efter");
                søgHelt = input.next();
                Superhero værdi = datebase.søgSuperHero(søgHelt);
                if (værdi == null)
                    System.out.println("Superhelten findes ikke i databasen");
                else System.out.println(værdi);

            } else {
                System.exit(0);
            }

        } while (brugerSvar != 9);
    }

}


/*TODO Jeg kan ikke kalde på denne forloop, da min metode ikke er omdøbt et navn, jeg vil gerne finde ud af om jeg kan printe listen  ud alligevel

        for (Superhero superheros : datebase.getSuperheros()) {
        System.out.println(superheros);
        // for (int = 0; i < datebase.getSuperheros().length;) {
        System.out.println(datebase.getSuperheros());
        //TODO TJEK Comparision Operators / == Resultat skal være null, != hvis det er null
        if (superheros != null) {
        System.out.println("Her kan du se resultatet for din superhero: ");
        System.out.println(superheros);
        System.out.println();*/


