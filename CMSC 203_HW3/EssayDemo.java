/**
   The EssayDemo class demonstrates the Essay class.
*/
public class EssayDemo {
   public static void main(String[] args) {
      // Example scores
      double grammarScore = 15.0;   // Out of 30
      double spellingScore = 11.0;  // Out of 20
      double lengthScore = 19.0;    // Out of 20
      double contentScore = 24.0;   // Out of 30

      // Create an Essay object
      Essay essay = new Essay(grammarScore, spellingScore, lengthScore, contentScore);

      // Display the scores and the final grade
      System.out.println("Grammar: " + essay.getGrammar());
      System.out.println("Spelling: " + essay.getSpelling());
      System.out.println("Length: " + essay.getLength());
      System.out.println("Content: " + essay.getContent());
      System.out.println("Total Score: " + essay.getScore());
      System.out.println("Grade: " + essay.getGrade());
   }
}
