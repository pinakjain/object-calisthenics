package main;

public class JobsManager
{

  private final Jobs jobs;

  public JobsManager(Jobs jobs)
  {
    this.jobs = jobs;
  }

  public RecruiterJob postjob(RecruiterJob job) throws NullPointerException
  {
    return jobs.add(job);
  }

  public Jobs jobsPostedBy(Recruiter recruiter)
  {
    return jobs.jobPostingsBy(recruiter);
  }

}
