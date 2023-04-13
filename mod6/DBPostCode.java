public class DBPostCode {
    
    enum Effectiveness {
        RESISTED,
        NEUTRAL,
        SUPER_EFFECTIVE
    }
    public static void main(String[] args) {
        Effectiveness fireAgainstWaterAttack = Effectiveness.RESISTED;
        System.out.println("");
        System.out.println(fireAgainstWaterAttack);
        System.out.println("");
    }
}