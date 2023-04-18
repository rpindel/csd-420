/* Reference - Code Copied From:
 * GeeksforGeeks. (2022, November 2). String vs Stringbuilder vs Stringbuffer in 
 * Java. GeeksforGeeks. Retrieved April 18, 2023, from 
 * https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-java/
 */

public class DBPostCode {
    public static void concat1(String s1) {
        s1 = s1 + "addedtext";
    }
    
    public static void concat2(StringBuilder s2) {
        s2.append("addedtext");
    }

    public static void concat3(StringBuffer s3) {
        s3.append("addedtext");
    }

    public static void main(String[] args) {
        String s1 = "Stringplus";
        concat1(s1);
        System.out.println("");
        // String s1 is not changed by the concat(s1) method
        System.out.println("String = " + s1);

        StringBuilder s2 = new StringBuilder("StringBuilderplus");
        concat2(s2);
        // StringBuilder s2 changed by the concat(s2) method
        System.out.println("StringBuilder = " + s2);

        StringBuffer s3 = new StringBuffer("StringBufferplus");
        concat3(s3);
        // StringBuffer s3 changed by the concat(s3) method
        System.out.println("StringBuffer = " + s3);
        System.out.println("");
    }
}
