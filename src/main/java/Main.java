import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!");
        Scanner sc = new Scanner(System.in);
        Superhero superhero1 = new Superhero();

        Database d = new Database();

        d.superheroData[0] = superhero1;
        d.superheroData[1] = superhero1;
        d.superheroData[2] = superhero1;

        System.out.println("Hvad hedder din superhelt?");
        String aliasNavn = sc.nextLine();
        superhero1.setAliasNavn(aliasNavn);
        System.out.println(superhero1.getAliasNavn());

        //Kan man lave en boolean til dette spørgsmål?
        System.out.println("Har din superhelt et andet navn, indtast her? Skriv nej hvis ikke");
        String superNavn = sc.nextLine();
        superhero1.setSuperNavn(superNavn);


        System.out.println("Hvad er din superhelts superkraft?");
        String superkraft = sc.nextLine();
        superhero1.setSuperkraft(superkraft);
        System.out.println(superhero1.getSuperNavn());

        System.out.println("Er din superhelt et menneske?");
        String svar;
        svar = sc.nextLine();
        boolean menneske;
        if (svar.equalsIgnoreCase("ja")) {
            menneske = true;
        } else if (svar.equalsIgnoreCase("nej")) {
            menneske = false;
        }

        System.out.println("Hvornår blev din superhelt skabt?");
        int oprindelsesÅr = sc.nextInt();
        superhero1.setOprindelsesÅr(oprindelsesÅr);
        System.out.println(superhero1.getOprindelsesÅr());

        System.out.println("Hvor stærk er din superhelt fra 0-100?");
        double styrke = sc.nextDouble();
        superhero1.setStyrke(styrke);
        System.out.println(superhero1.getStyrke());


        System.out.println(superhero1.toString());
        for (int i = 0; i < d.superheroData.length; i++) {
            System.out.println("Her printer jeg din liste ud = ");
            System.out.println(d.superheroData[i]);
        }

    }
}


