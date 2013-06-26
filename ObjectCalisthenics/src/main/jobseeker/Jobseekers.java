package main.jobseeker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.display.Displayer;

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

  public StringBuffer display(Displayer displayer)
  {
    StringBuffer sb = new StringBuffer();
    for (Jobseeker jobseeker : jobseekers)
    {
      displayer.display(jobseeker.toString());
      sb.append(jobseeker.toString());
    }
    return sb;
  }

  public int size()
  {
    return jobseekers.size();
  }

  public boolean contains(Jobseeker jobseeker)
  {
    return jobseekers.contains(jobseeker);
  }
  
  public boolean containsAll(Jobseekers seekrs)
  {
    for(Jobseeker jobseeker : seekrs){
      if(! jobseekers.contains(jobseeker))
        return false;
    }
    return true;
  }

  @Override
  public Iterator<Jobseeker> iterator()
  {
    Iterator<Jobseeker> iter = jobseekers.iterator();
    return iter;
  }
  
  
  @Override
  public int hashCode()
  {
    int hashcode = 0;
    for(Jobseeker jobseeker : jobseekers){
      hashcode += jobseeker.hashCode();
    }
    return hashcode;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (!(obj instanceof Jobseekers))
      return false;
    Jobseekers other = (Jobseekers) obj;
    if(this.size() != other.size())
      return false;
    return this.containsAll(other);
  }
}
