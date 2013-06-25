package main.jobApplication;

import java.util.Date;

import main.utils.DateUtils;
import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.recruiter.Recruiter;
import main.resume.Resume;

public class JobApplication
{

  private final Jobseeker    jobseeker;
  private final RecruiterJob job;
  private final Resume       resume;
  private final Date         date;

  JobApplication(Jobseeker jobseeker,
                 RecruiterJob job,
                 Resume resume)
  {
    if (jobseeker == null)
      throw new IllegalArgumentException("Jobseeker cannot be null");
    if (job == null)
      throw new IllegalArgumentException("Job cannot be null");
    if (job.requiresResume() && resume == null)
      throw new IllegalArgumentException("Resume required for this job");
    this.jobseeker = jobseeker;
    this.job = job;
    this.resume = resume;
    this.date = DateUtils.createDate();
  }

  public boolean wasSubmittedBy(Jobseeker jobseeker)
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
    return DateUtils.areSameDay(this.date, date);
  }

  public Jobseeker applicant()
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
  public int hashCode()
  {
    return job.hashCode() + jobseeker.hashCode() + date.hashCode();
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
