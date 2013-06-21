package main;

public class RecruiterJob
{

  private final Recruiter recruiter;
  private final Job       job;

  public RecruiterJob(Recruiter recruiter,
                      Job job) throws NullPointerException
  {
    if (recruiter == null)
      throw new NullPointerException("Recruiter cannot be null");
    if (job == null)
      throw new NullPointerException("Job cannot be null");
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
    // TODO Auto-generated method stub
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
