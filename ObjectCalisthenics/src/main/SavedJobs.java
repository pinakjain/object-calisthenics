package main;

import java.util.HashMap;
import java.util.Map;

public class SavedJobs
{

  private final Map<Jobseeker, Jobs> savedJobs;

  public SavedJobs()
  {
    this.savedJobs = new HashMap<Jobseeker, Jobs>();
  }

  public RecruiterJob add(Jobseeker jobseeker,
                          RecruiterJob recruiterJob) throws NullPointerException
  {
    // TODO Auto-generated method stub
    if (recruiterJob == null)
      throw new NullPointerException("Job to be saved cannot be null");
    if (jobseeker == null)
      throw new NullPointerException("Jobseeker cannot be null");
    savedJobs.put(jobseeker, addJobToTheSavedJobsForJobbseeker(jobseeker, recruiterJob));
    return recruiterJob;
  }

  public Jobs jobsSavedBy(Jobseeker jobseeker)
  {
    return savedJobs.get(jobseeker);
  }

  public Jobs addJobToTheSavedJobsForJobbseeker(Jobseeker jobseeker,
                                                RecruiterJob recruiterJob) throws NullPointerException
  {
    Jobs jobs = new Jobs();
    if (savedJobs.get(jobseeker) != null)
    {
      jobs = savedJobs.get(jobseeker);
    }
    jobs.add(recruiterJob);
    return jobs;
  }

  public boolean containsJobSavedByRecruiter(Jobseeker jobseeker,
                                             RecruiterJob recruiterJob)
  {
    return jobsSavedBy(jobseeker).contains(recruiterJob);
  }
}
