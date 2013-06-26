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
                 Resume resume,
                 Date date)
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
    this.date = date;
  }

  public boolean wasSubmittedBy(Jobseeker seeker)
  {
    return jobseeker.equals(seeker);
  }

  public boolean wasAppliedFor(RecruiterJob recruiterJob)
  {
    return job.equals(recruiterJob);
  }

  public boolean forJobPostedBy(Recruiter recruiter)
  {
    return job.isPostedBy(recruiter);
  }

  public boolean wasAppliedOn(Date applicationDate)
  {
    return DateUtils.areSameDay(date, applicationDate);
  }

  public Jobseeker applicant()
  {
    return jobseeker;
  }

  public void display()
  {
    System.out.println(jobseeker + " applied to job " + job + " on " + date);
  }

  public boolean hasResume()
  {
    return resume != null;
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
    if (!(obj instanceof JobApplication))
      return false;
    JobApplication other = (JobApplication) obj;
    return job.equals(other.job) && jobseeker.equals(other.jobseeker) && date.equals(other.date);
  }

}
