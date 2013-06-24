package main.jobs;

import main.recruiter.Recruiter;

public class RecruiterJob
{

  private final Recruiter recruiter;
  private final Job       job;

  public RecruiterJob(Recruiter recruiter,
                      Job job) throws IllegalArgumentException
  {
    if (recruiter == null)
      throw new IllegalArgumentException("Recruiter cannot be null");
    if (job == null)
      throw new IllegalArgumentException("Job cannot be null");
    this.recruiter = recruiter;
    this.job = job;
  }

  public boolean isPostedBy(Recruiter recruiter)
  {
    if (this.recruiter.equals(recruiter))
    {
      return true;
    }
    return false;
  }

  public void display()
  {
    job.display();
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
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RecruiterJob other = (RecruiterJob) obj;
    return job.equals(other.job) && recruiter.equals(other.recruiter);
  }

  @Override
  public String toString()
  {
    return job + " posted by " + recruiter;
  }

}
