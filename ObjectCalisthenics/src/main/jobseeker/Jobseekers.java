package main.jobseeker;

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
    if(jobseekers == null) throw new IllegalArgumentException("Jobseekers cannot be null");
    this.jobseekers = jobseekers;
  }

  public Jobseeker add(Jobseeker jobseeker) throws IllegalArgumentException
  {
    if (jobseeker == null)
      throw new IllegalArgumentException("Jobseeker needed to be added cannot be null");
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
    Iterator<Jobseeker> iter = jobseekers.iterator();
    return iter;
  }

}
