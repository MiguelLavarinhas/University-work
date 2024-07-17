/**
 * The statement class is an object which holds the term,sentence and confidence score of a statement in a knowledge base.
 *
 * @author Miguel Lavarinhas
 * @version 1.0
 * @since 25/02/2024
 */class Statement implements Comparable <Statement>
{
   /**
    * The term of the statement.
    */
   private String term;
   /**
    * The sentence of the statement.
    */
   private String sentence;
   /**
    * The confidence of the statement.
    */
   private double confidence;
   /**
    * Constructor for statement object.
    * @param term The term.
    * @param sentence   The sentence.
    * @param confidence The confidence.
    */
   public Statement(String term, String sentence, double confidence){
      this.term = term;
      this.sentence = sentence;
      this.confidence = confidence;
   }
   /**
    * Returns the term.
    * @return the term.
    */
   public String getTerm(){
      return term;
   }
   /**
    * Returns the sentence.
    * @return the sentence.
    */
   public String getSentence(){
      return sentence;
   }
   /**
    * Returns the confidence.
    * @return the confidence.
    */
   public double getConfidence(){
      return confidence;
   }
    /**
    * Edits the current sentence.
    * @param newSentence   the new sentence.
    */
   public void editSentence(String new1){
     sentence = new1;
   }
   /**
    * Edits the current confidence score.
    * @param newConfidence The new confidence score.
    */
   public void editConfidence(double new1){
      confidence = new1;
   }
   /**
    * Returns the term and sentence of the statement as a string.
    * @return The new string.
    */
   public String getBoth(){
      return term+sentence;
   }
   /**
    * Compares this statement to another statement.
    * @param other   The other statement.
    * @return A negative one,zero or positive one based on the string compare to method with the term.
    */
   public int compareTo(Statement other){
         return this.getTerm().compareTo(other.getTerm());
   }
   /**
    * Compares this statement to another statement based on both term and sentence.
    * @param term The other term.
    * @param statement  The other sentence.
    * @return A negative one,zero or positive one based on the string compare to method with the getBoth method.    
    */
    public int compareTo(String term, String statement){
   
      return this.getBoth().compareTo(term+statement);
   
   }
   
  }
