package wordle;

import java.util.ArrayList;

public class wordleLogic
{
  static int sizeOfWord;
  static ArrayList <String> answer = new ArrayList<>();
  wordleLogic() {
      word();
  }

  void word()
  {
      answer.add("w");
      answer.add("a");
      answer.add("t");
      answer.add("e");
      answer.add("r");
      sizeOfWord = answer.size();
  }
  static boolean matchLetter(int i)
    {
        if(answer.contains(wordleDesign.textFields.get(i).getText()))
        {
            return true;
        }
     return false;
    }

  static boolean matchExactLetter(int i)
  {
      if(wordleDesign.textFields.get(i).getText().equals(answer.get(i)))
      {
          return true;
      }
      return false;
  }
}
