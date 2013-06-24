package main.recruiter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Recruiters implements Iterable<Recruiter>
{

  private final List<Recruiter> recruiters;

  public Recruiters()
  {
    this.recruiters = new ArrayList<>();
  }

  public Recruiter add(Recruiter recruiter) throws IllegalArgumentException
  {
    if (recruiter == null)
      throw new IllegalArgumentException("Recruiter cannot be null");
    recruiters.add(recruiter);
    return recruiter;
  }

  public void display()
  {
    for (Recruiter recruiter : recruiters)
    {
      recruiter.display();
    }
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
