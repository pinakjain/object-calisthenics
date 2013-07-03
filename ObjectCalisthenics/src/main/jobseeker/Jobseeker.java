package main.jobseeker;

import main.display.JobseekerDisplayer;
import main.jobApplication.JobApplication;
import main.jobApplication.JobApplicationManager;
import main.jobApplication.JobApplications;
import main.jobApplication.JobApplier;
import main.jobs.Jobs;
import main.jobs.RecruiterJob;
import main.jobs.SavedJobsManager;

public class Jobseeker
{

  private final JobseekerName name;
  private final JobseekerId   id;

  public Jobseeker(String name)
  {
    this.name = new JobseekerName(name);
    this.id = JobseekerId.createJobseekerId();
  }

  public RecruiterJob save(RecruiterJob recruiterJob,
                           SavedJobsManager savedJobsManager) throws IllegalArgumentException
  {
    return savedJobsManager.save(this, recruiterJob);
  }

  public Jobs viewSavedJobs(SavedJobsManager savedJobsManager)
  {
    return savedJobsManager.jobsSavedBy(this);
  }

  public JobApplication apply(RecruiterJob job,
                              JobApplier jobApplier) throws IllegalArgumentException
  {
    return jobApplier.apply(this, job);
  }

  public JobApplications viewAppliedJobs(JobApplicationManager applicationManager)
  {
    return applicationManager.appliedJobs(this);
  }

  public void display(JobseekerDisplayer displayer)
  {
    displayer.display(name);
  }

  @Override
  public int hashCode()
  {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (!(obj instanceof Jobseeker))
      return false;
    Jobseeker other = (Jobseeker) obj;
    return id.equals(other.id);
  }

  @Override
  public String toString()
  {
    return "Jobseeker :- " + name;
  }

}
