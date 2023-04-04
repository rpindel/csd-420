import java.util.*;

public class DBPostCode {
    // Main method
    public static void main(String[] args) {
        // Create a LinkedHashMap to serve as a pokedex
        Map<String, String> pokedexInsertion = new LinkedHashMap<>();
        pokedexInsertion.put("001", "Bulbasaur");
        pokedexInsertion.put("002", "Ivysaur");
        pokedexInsertion.put("003", "Venusaur");
        System.out.println("LinkedHashMap pokedex in Insertion Order: ");
        System.out.println(pokedexInsertion + "\n");

        // Create a new LinkedHashMap to serve as a pokedex to show access ordering
        Map<String, String> pokedexAccess = new LinkedHashMap<>(6, 0.75f, true);
        pokedexAccess.put("001", "Bulbasaur");
        pokedexAccess.put("002", "Ivysaur");
        pokedexAccess.put("003", "Venusaur");
        System.out.println("LinkedHashMap pokedex in Access order before any entries accessed: ");
        System.out.println(pokedexAccess + "\n");
        System.out.println("003 = " + pokedexAccess.get("003"));
        System.out.println("002 = " + pokedexAccess.get("002"));
        System.out.println("001 = " + pokedexAccess.get("001"));
        System.out.println("LinkedHashMap pokedex in Access order after entries accessed: ");
        System.out.println(pokedexAccess + "\n");
    }
}
