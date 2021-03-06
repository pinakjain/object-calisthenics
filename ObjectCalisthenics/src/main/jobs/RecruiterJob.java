package main.jobs;

import main.display.JobDisplayer;
import main.recruiter.Recruiter;

public class RecruiterJob
{

  private final Recruiter recruiter;
  private final Job       job;

  public RecruiterJob(Recruiter recruiter,
                      Job job)
  {
    if (recruiter == null)
      throw new IllegalArgumentException("Recruiter cannot be null");
    if (job == null)
      throw new IllegalArgumentException("Job cannot be null");
    this.recruiter = recruiter;
    this.job = job;
  }

  public boolean isPostedBy(Recruiter rec)
  {
    return recruiter.equals(rec);
  }

  public void display(JobDisplayer displayer)
  {
    job.display(displayer);
  }

  public boolean requiresResume()
  {
    return job.requiresResume();
  }
  
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (!(obj instanceof RecruiterJob))
      return false;
    RecruiterJob other = (RecruiterJob) obj;
    return job.equals(other.job) && recruiter.equals(other.recruiter);
  }

  @Override
  public String toString()
  {
    return job + " posted by " + recruiter;
  }

  @Override
  public int hashCode()
  {
    return job.hashCode() + recruiter.hashCode();
  }

}
