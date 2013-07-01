package main.display;

public class TestDisplayer implements Displayer
{

  private StringBuffer displayedText = new StringBuffer();

  @Override
  public void display(String str)
  {
    displayedText.append(str);
    System.out.println(str);
  }

  public StringBuffer displayedText()
  {
    return displayedText;
  }

}
