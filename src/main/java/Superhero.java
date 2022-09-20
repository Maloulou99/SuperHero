public class Superhero {

    private String aliasNavn;
    private String superNavn;
    private String superkraft;
    private boolean erMenneske;
    private int oprindelsesÅr;
    private double styrke;

    public Superhero(String aliasNavn, String superNavn, String superkraft, boolean erMenneske, int oprindelsesÅr, double styrke) {
        this.aliasNavn = aliasNavn;
        this.superNavn = superNavn;
        this.superkraft = superkraft;
        this.erMenneske = erMenneske;
        this.oprindelsesÅr = oprindelsesÅr;
        this.styrke = styrke;
    }
    public Superhero(){

    }

    public String getAliasNavn() {
    return aliasNavn;
    }
    public void setAliasNavn(String aliasNavn){
        this.aliasNavn = aliasNavn;
    }
    public String getSuperNavn(){
        return superNavn;
    }
    public void setSuperNavn(String superNavn){
        this.superNavn = superNavn;
    }
    public String getSuperkraft(){
        return superkraft;
    }
    public  void setSuperkraft(String superkraft){
        this.superkraft = superkraft;
    }
    public int getOprindelsesÅr(){
        return oprindelsesÅr;
    }
    public void setOprindelsesÅr(int oprindelsesÅr){
        this.oprindelsesÅr = oprindelsesÅr;
    }
    public double getStyrke(){
        return styrke;
    }
    public void setStyrke(double styrke){
        this.styrke = styrke;
    }
    public boolean getErMenneske(){
        return erMenneske;
    }
    public void setErMenneske(boolean menneske){
        this.erMenneske = menneske;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "aliasNavn =" + aliasNavn + '\'' +
                ", superNavn =" + superNavn + '\'' +
                ", superkraft ='" + superkraft + '\'' +
                ", erMenneske =" + erMenneske +
                ", oprindelsesÅr =" + oprindelsesÅr +
                ", styrke=" + styrke +
                '}';
    }
}
