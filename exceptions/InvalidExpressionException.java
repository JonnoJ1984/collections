//Used for PostFixCalculator project
package collections.exceptions;

public class InvalidExpressionException extends RuntimeException
{
   public InvalidExpressionException()
   {
      super();
   }
   public InvalidExpressionException(String message)
   {
      super(message);
   }
}