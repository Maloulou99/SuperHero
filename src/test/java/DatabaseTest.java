import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Superhero s1;
    Superhero s2;
    Database helte;


    @BeforeEach
    void setUp(){
        Database helte = new Database();
        s1 = new Superhero("Malou", "Super Malou", "Spiser meget", true, 1999, 193.943);
        s2 = new Superhero("Hund", "Super Hund", "Flyvende", false, 1756, 34.567);
        helte.getSuperheros().add(s1);
        helte.getSuperheros().add(s2);
    }
    @Test
    void testTilføj(){
    int præcisLængde = 3;
    helte.tilføjSuperhelt("Mango", "Super Mango", "Spisende", false, 1756, 34.567);
    assertEquals(præcisLængde,helte.getSuperheros().size());

    }
    @Test
    void testFindSuperHero(){
    String præcisAliasNavn = "Malou";
    String præcisSuperNavn = "Super Malou";
    assertEquals(præcisAliasNavn, s1.getAliasNavn());
    assertEquals(præcisSuperNavn, s1.getSuperNavn());
    }
    @Test //Vi laver en test som skal gå i fejl
    void testFejlFindeSuper(){
        String præcisAliasNavnFejl = "Mango";
        assertEquals(præcisAliasNavnFejl, s1.getAliasNavn());
    }
}