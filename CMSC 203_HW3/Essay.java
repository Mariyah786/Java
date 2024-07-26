
/**
   The Essay class extends GradedActivity and calculates the total score
   based on grammar, spelling, correct length, and content.
*/
public class Essay extends GradedActivity {
   private double grammar;   // Grammar score
   private double spelling;  // Spelling score
   private double length;    // Correct length score
   private double content;   // Content score

   /**
      Constructor
      @param grammarScore The score for grammar.
      @param spellingScore The score for spelling.
      @param lengthScore The score for correct length.
      @param contentScore The score for content.
   */
   public Essay(double grammarScore, double spellingScore, double lengthScore, double contentScore) {
      grammar = grammarScore;
      spelling = spellingScore;
      length = lengthScore;
      content = contentScore;

      // Calculate the total score and set it
      double totalScore = grammar + spelling + length + content;
      setScore(totalScore);
   }

   // Getters for each score component
   public double getGrammar() {
      return grammar;
   }

   public double getSpelling() {
      return spelling;
   }

   public double getLength() {
      return length;
   }

   public double getContent() {
      return content;
   }
}
