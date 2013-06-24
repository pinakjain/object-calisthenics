package main.jobs;

import main.jobseeker.Jobseeker;

public class SavedJobsManager
{

  private final SavedJobs savedJobs;

  public SavedJobsManager(SavedJobs savedJobs)
  {
    if(savedJobs == null) throw new IllegalArgumentException("Saved jobs cannot be null");
    this.savedJobs = savedJobs;
  }

  public RecruiterJob save(Jobseeker jobseeker,
                           RecruiterJob recruiterJob) throws IllegalArgumentException
  {
    return savedJobs.add(jobseeker, recruiterJob);
  }

  public Jobs jobsSavedBy(Jobseeker jobseeker)
  {
    return savedJobs.jobsSavedBy(jobseeker);
  }

}
