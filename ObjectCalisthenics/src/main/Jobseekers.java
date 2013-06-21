package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jobseekers implements Iterable<Jobseeker>
{

  private final List<Jobseeker> jobseekers;

  public Jobseekers()
  {
    this.jobseekers = new ArrayList<>();
  }

  public Jobseekers(List<Jobseeker> jobseekers)
  {
    // TODO Auto-generated constructor stub
    this.jobseekers = jobseekers;
  }

  public Jobseeker add(Jobseeker jobseeker) throws NullPointerException
  {
    if (jobseeker == null)
      throw new NullPointerException("Jobseeker needed to be added cannot be null");
    jobseekers.add(jobseeker);
    return jobseeker;
  }

  public void display()
  {
    for (Jobseeker jobseeker : jobseekers)
    {
      jobseeker.display();
    }
  }

  public int size()
  {
    return jobseekers.size();
  }

  public boolean contains(Jobseeker jobseeker)
  {
    return jobseekers.contains(jobseeker);
  }

  @Override
  public Iterator<Jobseeker> iterator()
  {
    // TODO Auto-generated method stub
    Iterator<Jobseeker> iter = jobseekers.iterator();
    return iter;
  }

}
