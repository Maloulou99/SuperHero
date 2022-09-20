public class UserInterface {
    //Scanner input;
    UI ui = new UI();
    Database database;


    public UserInterface() {
        database = new Database();
    }

    public void startProgram() {
        int brugerSvar = 0;

        while (brugerSvar != 9) {

            System.out.println("""
                    Velkommen til Superhelte database! Her har du mulighed for at indtaste DIN superhelt!
                    1. Opret superhelt
                    2. Udskriv alle superhelte
                    3. Søg efter superhelt
                    4. Ret i din superhelt
                    9. Afslut    
                        """);
            //Disse metoder opretter vi en scanner til at kunne få input fra brugeren
            brugerSvar = ui.getScanInt();
            brugerSvarMenu(brugerSvar);

        }
    }

    public void brugerSvarMenu(int brugerSvar) {
        if (brugerSvar == 1)
            indtastSuperhelt();
        else if (brugerSvar == 2)
            findSuperhelt();
        else if (brugerSvar == 3)
            udskrivSuperhelt();
        else if (brugerSvar == 4)
                    retSuperhelt();
        else if (brugerSvar == 9)
            System.exit(9);
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
        if (værdi == null)
            System.out.println("Superhelten findes ikke i databasen");
        else System.out.println(værdi);
    }

    public void udskrivSuperhelt() {

        System.out.println("\nSuperheltens informationer: ");
        if(!database.superheros.isEmpty())
        for (Superhero superhelteListe : database.getSuperheros()) {
            System.out.println(superhelteListe);
        }else
            System.out.println("Der findes ingen superhelte med indtastet information" + "\"" + database.superheros + "\"" );
    }
    public void retSuperhelt() {

        System.out.println("Søg efter superhelt som du vil rette: ");

        for (int i = 0; i < database.getSuperheros().size(); i++) {
            //database.getSuperheros().get(i).setAliasNavn(nytAliasNavn);
            System.out.println(i+1 +":" + database.superheros.get(i));
        }
        System.out.println("Indtast nr på den superhelt du ønsker redigeres: ");
        int nr = ui.getScanInt();
        ui.getScanInt();

        Superhero redigerSuperHero = database.superheros.get(nr-1);
        System.out.println("Rediger superhero: " +redigerSuperHero);

        System.out.println("Rediger data og tryk ENTER, hvis du ikke ønsker at redigere, så tryk ENTER: ");
        System.out.println("AliasNavn: " + redigerSuperHero.getAliasNavn());
        String nytAliasNavn = ui.getScanString();
        if (!ui.getScanString().isEmpty())
            redigerSuperHero.setAliasNavn(nytAliasNavn);

        System.out.println("Supernavn: " + redigerSuperHero.getSuperNavn());
        String nytSuperNavn = ui.getScanString();
        if (!ui.getScanString().isEmpty());
        redigerSuperHero.setSuperNavn(nytSuperNavn);

        System.out.println("Superkraft: " + redigerSuperHero.getSuperkraft());
        String nySuperkraft = ui.getScanString();
        if (!ui.getScanString().isEmpty());
        redigerSuperHero.setSuperkraft(nySuperkraft);

        System.out.println("Menneske eller ej: " + redigerSuperHero.getErMenneske());
        String nyErMenneske = ui.getScanString();
        if (!ui.getScanString().isEmpty());
        redigerSuperHero.setErMenneske(Boolean.parseBoolean(nyErMenneske));

        System.out.println("Oprindelsesår: ");
        String nyOprindelsesår = ui.getScanString();
        if (!ui.getScanString().isEmpty());
        redigerSuperHero.setOprindelsesÅr(Integer.parseInt(nyOprindelsesår));

        System.out.println("Styrke: " + redigerSuperHero.getStyrke());
        String nyStyrke = ui.getScanString();
        if (!ui.getScanString().isEmpty());
        redigerSuperHero.setStyrke(Double.parseDouble(nyStyrke));
        }
    }


    /*public int tal() {
        while (!ui.getScanInt()) {
            String SH = ui.getScanString();
            System.out.println("Er ikke en gyldig værdi " + SH + "det skal være et tal, indtast venligst igen: ");
        }
        int result = ui.getScanInt();
        return result;
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


