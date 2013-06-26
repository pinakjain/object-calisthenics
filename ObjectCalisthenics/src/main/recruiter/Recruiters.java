package main.recruiter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.display.Displayer;

public class Recruiters implements Iterable<Recruiter>
{

  private final List<Recruiter> recruiters;

  public Recruiters()
  {
    this.recruiters = new ArrayList<>();
  }

  public Recruiter add(Recruiter recruiter)
  {
    if (recruiter == null)
      throw new IllegalArgumentException("Recruiter cannot be null");
    recruiters.add(recruiter);
    return recruiter;
  }

  public StringBuffer display(Displayer displayer)
  {
    StringBuffer sb = new StringBuffer();
    for (Recruiter recruiter : recruiters)
    {
      displayer.display(recruiter.toString());
      sb.append(recruiter.toString());
    }
    return sb;
  }

  public int size()
  {
    return recruiters.size();
  }

  public boolean contains(Recruiter recruiter)
  {
    return recruiters.contains(recruiter);
  }

  @Override
  public Iterator<Recruiter> iterator()
  {
    Iterator<Recruiter> iter = recruiters.iterator();
    return iter;
  }

}
