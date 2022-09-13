import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!");
        Scanner sc = new Scanner(System.in);

        Database datebase = new Database();
        //Tilføj superheros til hvert spørgsmål


        for (int i = 0; i < datebase.getSuperheros().length; i++) {


            //Kan man lave en boolean til dette spørgsmål?
            System.out.println("Har din superhelts et aliasnavn? indtast her: Skriv nej hvis ikke");
            String aliasNavn = sc.nextLine();



            System.out.println("Har din superhelt et  superhelte navn? indtast her: Skriv nej hvis ikke");
            String superNavn = sc.nextLine();



            System.out.println("Hvad er din superhelts superkraft?");
            String superkraft = sc.nextLine();



            System.out.println("Er din superhelt et menneske?");
            String svar;
            svar = sc.nextLine();
            boolean menneske = false;
            if (svar.equalsIgnoreCase("ja")) {
                menneske = true;
            } else if (svar.equalsIgnoreCase("nej")) {
                menneske = false;
            }

            System.out.println("Hvornår blev din superhelt skabt?");
            int oprindelsesÅr = sc.nextInt();

            System.out.println("Hvor stærk er din superhelt fra 0-100?");
            double styrke = sc.nextDouble();
            //Scannerbug
            //TODO Scannerbug
            sc.nextLine();

            datebase.tilføjSuperhelt(aliasNavn, superNavn,superkraft, menneske, oprindelsesÅr, styrke );


            /*for (int  = 0; i < datebase.getSuperheros().length; i++) {
                System.out.println("Her kan du se resultatet for din superhero: ");
                System.out.println(datebase.getSuperheros()[i]);
            }*/
            for(Superhero superhero : datebase.getSuperheros()){
                //TODO TJEK Comparision Operators / == Resultat skal være null, != hvis det er null
                if(superhero != null){
                    System.out.println("Her kan du se resultatet for din superhero: ");
                    System.out.println(superhero);
                    System.out.println();
                }

            }
        }
    }
}


