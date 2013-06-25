package main.jobseeker;

import main.utils.IdGenerator;
import main.jobApplication.JobApplication;
import main.jobApplication.JobApplicationManager;
import main.jobApplication.JobApplications;
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
    this.id = new JobseekerId(IdGenerator.createId());
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
                              JobApplicationManager applicationManager) throws IllegalArgumentException
  {
    return applicationManager.apply(this, job);
  }

  public JobApplications viewAppliedJobs(JobApplicationManager applicationManager)
  {
    return applicationManager.appliedJobs(this);
  }

  public void display()
  {
    System.out.println("Jobseeker :- " + name + " (ID = " + id + ")");
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
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
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
