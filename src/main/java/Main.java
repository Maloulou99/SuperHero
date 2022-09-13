import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!");
        Database datebase = new Database();
        int brugerSvar = 0;

        do {
            System.out.println("""
                    Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!
                    1. Opret superhelt
                    2. Udskriv alle superhelte
                    3. Afslut    
                        """);

            //Denne metode opretter vi en scanner til at kunne få input fra brugeren
            Scanner input = new Scanner(System.in);
            brugerSvar = input.nextInt();
            input.nextLine();

            if (brugerSvar == 1) {
                System.out.println("Indtast din superhelts superhelte navn her: ");
                String aliasNavn = input.nextLine();
                System.out.println("Hvis din superhelt har et menneske navn så indtast her eller tryk ENTER for at gå videre: ");
                String superNavn = input.nextLine();
                System.out.println("Hvad er din superhelts superkraft?");
                String superkraft = input.nextLine();
                System.out.println("Hvornår blev din superhelt skabt?");
                int oprindelsesÅr = input.nextInt();
                System.out.println("Er din superhelt et menneske? Skriv 'Ja' eller 'Nej'");
                String svar;
                svar = input.nextLine();
                boolean menneske = false;
                if (svar.equalsIgnoreCase("ja")) {
                    menneske = true;
                } else if (svar.equalsIgnoreCase("nej")) {
                    menneske = false;
                }
                //Scannerbug
                //TODO Scannerbug
                input.nextLine();

                System.out.println("Hvor stærk er din superhelt? Skriv antallet her: ");
                double styrke = input.nextDouble();

               // datebase.tilføjSuperhelt(aliasNavn, superNavn, superkraft, menneske, oprindelsesÅr, styrke);

            } else if (brugerSvar == 2) {
                System.out.println("Her kan du se resultatet for din superhero: ");

               //TODO Jeg kan ikke kalde på denne forloop, da min metode ikke er omdøbt et navn, jeg vil gerne finde ud af om jeg kan printe listen  ud alligevel

                for (Superhero superheros : datebase.getSuperheros()) {
                    System.out.println(superheros);
                    // for (int = 0; i < datebase.getSuperheros().length;) {
                    System.out.println(datebase.getSuperheros());
                    //TODO TJEK Comparision Operators / == Resultat skal være null, != hvis det er null
                    if (superheros != null) {
                        System.out.println("Her kan du se resultatet for din superhero: ");
                        System.out.println(superheros);
                        System.out.println();
                    } else {
                        System.exit(0);

                    }

                }

            }
        } while (brugerSvar != 3) ;
    }
}





