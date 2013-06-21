package main;

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

  public Recruiter add(Recruiter recruiter) throws NullPointerException
  {
    if (recruiter == null)
      throw new NullPointerException("Recruiter cannot be null");
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
    // TODO Auto-generated method stub
    Iterator<Recruiter> iter = recruiters.iterator();
    return iter;
  }

}
