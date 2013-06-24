package main.jobs;

import java.util.HashMap;
import java.util.Map;

import main.jobseeker.Jobseeker;

public class SavedJobs
{

  private final Map<Jobseeker, Jobs> savedJobs;

  public SavedJobs()
  {
    this.savedJobs = new HashMap<Jobseeker, Jobs>();
  }

  public RecruiterJob add(Jobseeker jobseeker,
                          RecruiterJob recruiterJob) throws IllegalArgumentException
  {
    if (recruiterJob == null)
      throw new IllegalArgumentException("Job to be saved cannot be null");
    if (jobseeker == null)
      throw new IllegalArgumentException("Jobseeker cannot be null");
    savedJobs.put(jobseeker, addJobToTheSavedJobsForJobbseeker(jobseeker, recruiterJob));
    return recruiterJob;
  }

  public Jobs jobsSavedBy(Jobseeker jobseeker)
  {
    return savedJobs.get(jobseeker);
  }

  private Jobs addJobToTheSavedJobsForJobbseeker(Jobseeker jobseeker,
                                                RecruiterJob recruiterJob) throws IllegalArgumentException
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
