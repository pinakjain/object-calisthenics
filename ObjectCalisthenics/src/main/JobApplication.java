package main;

import java.util.Date;

public class JobApplication
{

  private final Jobseeker    jobseeker;
  private final RecruiterJob job;
  private final Resume       resume;
  private final Date         date;

  public JobApplication(Jobseeker jobseeker,
                        RecruiterJob job,
                        Resume resume) throws NullPointerException
  {
    if (jobseeker == null)
      throw new NullPointerException("Jobseeker cannot be null");
    if (job == null)
      throw new NullPointerException("Job cannot be null");
    if (job.requiresResume() && resume == null)
      throw new NullPointerException("Resume required for this job");
    this.jobseeker = jobseeker;
    this.job = job;
    this.resume = resume;
    this.date = ApplicationDate.createDate();
  }

  public boolean isAppliedBy(Jobseeker jobseeker)
  {
    if (this.jobseeker == jobseeker)
    {
      return true;
    }
    return false;
  }

  public boolean isAppliedFor(RecruiterJob job)
  {
    if (this.job == job)
    {
      return true;
    }
    return false;
  }

  public boolean isPostedBy(Recruiter recruiter)
  {
    return job.isPostedBy(recruiter);
  }

  public boolean isAppliedOn(Date date)
  {
    return ApplicationDate.compareDate(this.date, date);
  }

  public Jobseeker applier()
  {
    return this.jobseeker;
  }

  public void display()
  {
    System.out.println(jobseeker + " applied to job " + job + " on " + date);
  }

  public boolean hasResume()
  {
    if (this.resume == null)
    {
      return false;
    }
    return true;
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
    JobApplication other = (JobApplication) obj;
    return job.equals(other.job) && jobseeker.equals(other.jobseeker) && date.equals(other.date);
  }
}
