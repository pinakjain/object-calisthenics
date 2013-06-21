package main;

public class SavedJobsManager
{

  private final SavedJobs savedJobs;

  public SavedJobsManager(SavedJobs savedJobs)
  {
    this.savedJobs = savedJobs;
  }

  public RecruiterJob save(Jobseeker jobseeker,
                           RecruiterJob recruiterJob) throws NullPointerException
  {
    // TODO Auto-generated method stub
    return savedJobs.add(jobseeker, recruiterJob);
  }

  public Jobs jobsSavedBy(Jobseeker jobseeker)
  {
    return savedJobs.jobsSavedBy(jobseeker);
  }

}
