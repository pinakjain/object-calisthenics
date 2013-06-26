package main.display;

public class ConsoleDisplayer implements Displayer
{

  @Override
  public void display(String str)
  {
    System.out.println(str);
  }

}
