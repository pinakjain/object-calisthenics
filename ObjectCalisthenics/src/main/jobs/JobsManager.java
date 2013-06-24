package main.jobs;

import main.recruiter.Recruiter;

public class JobsManager
{

  private final Jobs jobs;

  public JobsManager(Jobs jobs)
  {
    if(jobs == null) throw new IllegalArgumentException("Jobs cannot be null");
    this.jobs = jobs;
  }

  public RecruiterJob postjob(RecruiterJob job) throws IllegalArgumentException
  {
    return jobs.add(job);
  }

  public Jobs jobsPostedBy(Recruiter recruiter)
  {
    return jobs.jobPostingsBy(recruiter);
  }

}
