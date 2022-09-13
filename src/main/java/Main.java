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
                    9. Afslut    
                        """);

            //Denne metode opretter vi en scanner til at instensiere inputtene
            Scanner input = new Scanner(System.in);
            brugerSvar = input.nextInt();
            input.nextLine();

            if (brugerSvar == 1) {
                System.out.println("Indtast Super-helte navnet på din superhelt");
                String navn = input.nextLine();
                System.out.println("Hvis din superhelt har et menneske navn så indtast det her, ellers skriv ingen");
                String superNavn = input.nextLine();
                System.out.println("Er din helt et menneske? Svar Ja/nej");
                boolean erMenneske = false;
                String svar = input.next();
                if (svar.equalsIgnoreCase("Ja")) {
                    erMenneske = true;
                } else if (svar.equalsIgnoreCase("Nej")) {
                    erMenneske = false;
                }
                //for (int i = 0; i < datebase.superheros().length; i++) {
                System.out.println("Har din superhelts et aliasnavn? indtast her: Skriv nej hvis ikke");
                String aliasNavn = input.nextLine();
                System.out.println("Har din superhelt et  superhelte navn? indtast her: Skriv nej hvis ikke");
                String superNavn = input.nextLine();
                System.out.println("Hvad er din superhelts superkraft?");
                String superkraft = input.nextLine();
                System.out.println("Er din superhelt et menneske?");
                String svar;
                svar = input.nextLine();
                boolean menneske = false;
                if (svar.equalsIgnoreCase("ja")) {
                    menneske = true;
                } else if (svar.equalsIgnoreCase("nej")) {
                    menneske = false;
                }
                System.out.println("Hvornår blev din superhelt skabt?");
                int oprindelsesÅr = input.nextInt();
                System.out.println("Hvor stærk er din superhelt? Skriv antallet her: ");
                double styrke = input.nextDouble();
                //Scannerbug
                //TODO Scannerbug
                input.nextLine();

                datebase.tilføjSuperhelt(aliasNavn, superNavn, superkraft, menneske, oprindelsesÅr, styrke);


                //for (int  = 0; i < datebase.getSuperheros().length;) {


                for (Superhero superhero : datebase.getSuperheros()) {
                    System.out.println("Her kan du se resultatet for din superhero: ");
                    System.out.println(datebase.getSuperheros());
                    //TODO TJEK Comparision Operators / == Resultat skal være null, != hvis det er null
                    if (superhero != null) {
                        System.out.println("Her kan du se resultatet for din superhero: ");
                        System.out.println(superhero);
                        System.out.println();

                    } else if (brugerSvar == 1) {
                        for (Superhero superheroListe : datebase.getSuperheros()) {
                            System.out.println(superheroListe);
                        }
                    }else{
                        System.exit(0);

                    }
                }
            }
        }while (brugerSvar != 9) ;
    }
}



