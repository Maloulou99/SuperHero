import java.util.Scanner;

public class UserInterface {


    public void startProgram() {
        class UserInterFace {
            Scanner input;
            Database database;
            int brugerSvar = 0;

            public UserInterFace() {
                database = new Database();
                input = new Scanner(System.in);


                do {

                    System.out.println("""
                            Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!
                            1. Opret superhelt
                            2. Udskriv alle superhelte
                            3. Søg efter superhelt
                            4. Ret i din superhelt
                            9. Afslut    
                                """);
                    //Disse metoder opretter vi en scanner til at kunne få input fra brugeren
                    brugerSvar = input.nextInt();
                    brugerSvarMenu(brugerSvar);

                } while (brugerSvar != 9);
            }

            public void brugerSvarMenu(int brugerSvar) {
                if (brugerSvar == 1)
                    indtastSuperhelt();
                else if (brugerSvar == 2)
                    findSuperhelt();
                else if (brugerSvar == 3)
                    udskrivSuperhelt();
                /*else if (brugerSvar == 4)
                    retSuperhelt();*/
                else if (brugerSvar == 9) ;
                System.exit(9);
            }

            public void indtastSuperhelt() {
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
                database.tilføjSuperhelt(aliasNavn, superNavn, superkraft, menneske, oprindelsesÅr, styrke);
            }

            public void findSuperhelt() {
                if (brugerSvar == 2) {
                    System.out.println("Indtast navnet på din superhelt, som du søger efter her: ");
                    String søgHelt = input.nextLine();
                    Superhero værdi = database.søgSuperHero(søgHelt);
                    if (værdi == null)
                        System.out.println("Superhelten findes ikke i databasen");
                    else System.out.println(værdi);
                }
            }

            public void udskrivSuperhelt() {
                if (brugerSvar == 3) {
                    System.out.println("\nSuperheltens informationer: ");
                    for (Superhero superhelteListe : database.getSuperheros()) {
                        System.out.println(superhelteListe);
                    }
                }
                //public void retSuperhelt () {

            }

        }
    }
}
//TODO en anden metode at sige til bruger, værdi findes ikke
//boolean fundet = false;
// for(Superhero s : superheros)
//if (s.getnavn().contains(søgeNavn)){
//søgeResultat.add(s)
//System.out.println(Desværre findes ikke)
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


