public class UserInterface {
    //Scanner input;
    UI ui = new UI();
    Database database;
    int brugerSvar = 0;

    public UserInterface() {
        database = new Database();
    }

    public void startProgram() {


        while (brugerSvar != 9) {

            System.out.println("""
                    Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!
                    1. Opret superhelt
                    2. Udskriv alle superhelte
                    3. Søg efter superhelt
                    4. Ret i din superhelt
                    5. Slet superhelt
                    9. Afslut    
                        """);
            //Disse metoder opretter vi en scanner til at kunne få input fra brugeren
            brugerSvar = ui.getScanInt();
            brugerSvarMenu(brugerSvar);

        }
    }

    /*public void brugerSvarMenu(int brugerSvar) {
        if (brugerSvar == 1)
            indtastSuperhelt();
        else if (brugerSvar == 2)
            udskrivSuperhelt();
        else if (brugerSvar == 3)
            findSuperhelt();
        else if (brugerSvar == 4)
            retSuperhelt();
        else if (brugerSvar == 9)
            System.exit(9);
    }*/

    // switch menu
    public void brugerSvarMenu(int brugersvar) {
        switch (brugersvar) {
            case 1:
                indtastSuperhelt();
                break;
            case 2:
                udskrivSuperhelt();
                break;
            case 3:
                findSuperhelt();
                break;
            case 4:
                retSuperhelt();
                break;
            case 5:
                sletSuperHelt();
                break;
            case 9:
                System.out.println("Superhelte program lukker nu, vi ses snart igen!");
            default:
                System.out.println("Værdi ikke tilladt, prøv igen!");
        }
    }

    public void indtastSuperhelt() {
        System.out.print("Indtast din superhelts superhelte navn her: ");
        String aliasNavn = ui.getScanString();
        System.out.print("Hvis din superhelt har et menneske navn så indtast her eller tryk ENTER for at gå videre: ");
        String superNavn = ui.getScanString();
        System.out.print("Hvad er din superhelts superkraft? ");
        String superkraft = ui.getScanString();
        System.out.print("Er din superhelt et menneske? Skriv 'Ja' eller 'Nej' ");
        String svar;
        svar = ui.getScanString();
        boolean menneske = false;
        if (svar.equalsIgnoreCase("ja")) {
            menneske = true;
        } else if (svar.equalsIgnoreCase("nej")) {
            menneske = false;
        }
        System.out.print("Hvornår var din superhelt skabt? ");

        int oprindelsesÅr = ui.getScanInt();
        System.out.print("Hvor stærk er din superhelt? Skriv antallet her: ");
        double styrke = ui.getScanInt();
        boolean wrongInput = true;
        while (wrongInput)
            try {
                wrongInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Der skal indtastes et tal, prøv igen: ");
                styrke = ui.getScanInt();
            }

        // Kigger ind i min database "superheros", bruger min setmetode "tilfoejSuperhelt" med inputs
        database.tilføjSuperhelt(aliasNavn, superNavn, superkraft, menneske, oprindelsesÅr, styrke);
    }

    public void findSuperhelt() {

        System.out.println("Indtast navnet på din superhelt, som du søger efter her: ");
        String søgHelt = ui.getScanString();
        Superhero værdi = database.søgSuperHero(søgHelt);
        System.out.println("Din superhelt er fundet i databasen: ");
        if (værdi == null) {
            System.out.println("Superhelten findes ikke i databasen");
        }
    }


    public void udskrivSuperhelt() {

        System.out.println("\nSuperheltens informationer: ");
        if (!database.superheros.isEmpty())
            for (Superhero superhelteListe : database.getSuperheros()) {
                System.out.println(superhelteListe);
            }
        else
            System.out.println("Der findes ingen superhelte med indtastet information" + "\"" + database.superheros + "\"");
    }

    //TODO Skal tastes ENTER to gange for at gå videre, det skal rettes?!
    //TODO Kommer kun den første indtastede superhelt frem
    //TODO Programmet afslutter efter alle rettelser er lavet
    public void retSuperhelt() {

        System.out.println("Søg efter superhelt som du vil rette: ");

        for (int i = 0; i < database.getSuperheros().size(); i++) {
            //database.getSuperheros().get(i).setAliasNavn(nytAliasNavn);
            System.out.println(i + 1 + ":" + database.superheros.get(i));

            System.out.println("Indtast nr på den superhelt du ønsker redigeres: ");
            int nr = ui.getScanInt();

            Superhero redigerSuperHero = database.superheros.get(nr - 1);
            System.out.println("Rediger superhero: " + redigerSuperHero);

            System.out.println("Rediger data og tryk ENTER, hvis du ikke ønsker at redigere, så tryk ENTER: ");
            System.out.println("AliasNavn: " + redigerSuperHero.getAliasNavn());
            String nytAliasNavn = ui.getScanString();
            if (!ui.getScanString().isEmpty())
                redigerSuperHero.setAliasNavn(nytAliasNavn);

            System.out.println("Supernavn: " + redigerSuperHero.getSuperNavn());
            String nytSuperNavn = ui.getScanString();
            if (!ui.getScanString().isEmpty()) ;
            redigerSuperHero.setSuperNavn(nytSuperNavn);

            System.out.println("Superkraft: " + redigerSuperHero.getSuperkraft());
            String nySuperkraft = ui.getScanString();
            if (!ui.getScanString().isEmpty()) ;
            redigerSuperHero.setSuperkraft(nySuperkraft);

            System.out.println("Menneske eller ej: " + redigerSuperHero.getErMenneske());
            String nyErMenneske = ui.getScanString();
            if (!ui.getScanString().isEmpty()) ;
            redigerSuperHero.setErMenneske(Boolean.parseBoolean(nyErMenneske));

            System.out.println("Oprindelsesår: ");
            String nyOprindelsesår = ui.getScanString();
            if (!ui.getScanString().isEmpty()) ;
            redigerSuperHero.setOprindelsesÅr(Integer.parseInt(nyOprindelsesår));

            System.out.println("Styrke: " + redigerSuperHero.getStyrke());
            String nyStyrke = ui.getScanString();
            if (!ui.getScanString().isEmpty()) ;
            redigerSuperHero.setStyrke(Double.parseDouble(nyStyrke));
        }
    }

    //TODO Superhelt bliver printet ud, men programmet stopper efter indtastet ja/nej?
    //Vi skal slette en superhelt, så vi skal bruge hele arraylisten igen
    public void sletSuperHelt() {
        System.out.println("\tSøge efter superhelt du vil SLETTE: ");
        String søgeNavn = ui.getScanString();

        for (int i = 0; i < database.superheros.size(); i++) {
            System.out.println(i + 1 + ":\n" + database.getSuperheros().get(i) + "\n");
        }

        if (søgeNavn != null) {
            System.out.println("\t Vi har fundet din superhelt: \n"
                    + søgeNavn);
        } else if (søgeNavn == null) {
            System.out.println("\tKunne ikke finde superhelten. \n");
        }

        System.out.println("\tVil du slette denne superhero? Indtast ja / nej.");
        String svar = ui.getScanString();

        //Vi spørger brugeren om vi vil slette den indtastede superhelt
        if (svar.equalsIgnoreCase("ja")) {
            int n;
            n = database.getSuperheros().indexOf(søgeNavn);

            database.getSuperheros().remove(n);

        } else if (svar.equalsIgnoreCase("nej")) {

        }
    }
}


        /*for (int i = 0; i < database.superheros.size(); i++) {
            System.out.println(i + 1 + ":\n" + database.getSuperheros().get(i) + "\n");
        }
        int nr;

        do {
            System.out.println();
            System.out.print("Indtast nr. og tryk ENTER for at slette: ");


            nr = brugerSvar;
            ui.getScanString();

            if (nr <= database.getSuperheros().size()) { // Metode finder index som passer i arraylisten og sletter
                database.getSuperheros().remove(nr - 1);
                System.out.println("\nDen valgte Superhelt er nu slettet!");

            } else {
                System.out.println("Indtastet værdi kan ikke genkendes, prøv igen!"); // else = servicebesked
            }

        } while (nr > database.getSuperheros().size());

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
        System.out.println();


        //TODO Intergre.parse (scannernavnet) = Gøre int til en streng
        boolean wrongUserInput = true;
         While(WrongUserInput){
        int variabel
         try{
            input = sccanner.nextLine();
        variabelnavn = Integer.parseInt(Input);
         WrongUserInput = false;
        } catch (NumberFormatExepation variabelnavn)
        System.out.println(variabelnavn.message....);
          variabelnavn = Integer.parseInt(Input);
           }
         }
         variabelnavn.printStackTrace(); = fejl i input , men kører videre i programmet.

         //TODO Tjek at tal matcher menupunktmuligheder (Field)
            checkInteger(userchoice)


            public void chck integer (int userChoice){
            if (userchoice>9){
            throw new IllegalArgumentException("Kun tal mindre end 9");
            try{
            checkInteger(userChoice);
            }
                if (brugerSvar == 1)
                            indtastSuperhelt();
                        else if (brugerSvar == 2)
                            findSuperhelt();
                        else if (brugerSvar == 3)
                            udskrivSuperhelt();
                        /*else if (brugerSvar == 4)
                            retSuperhelt();
                        else if (brugerSvar == 9) ;
                                System.exit(9);
                                }
                                 }*/


