package main.jobApplication;

import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;

public class JobApplier
{
  private final JobApplicationFactory applicationFactory;
  private final JobApplications       jobApplications;

  public JobApplier(JobApplications jobApplications,
                    JobApplicationFactory applicationFactory)
  {
    if (jobApplications == null)
      throw new IllegalArgumentException("Job applications cannot be null");
    if (applicationFactory == null)
      throw new IllegalArgumentException("Application factory cannot be null");
    this.jobApplications = jobApplications;
    this.applicationFactory = applicationFactory;
  }

  public JobApplication apply(Jobseeker jobseeker,
                              RecruiterJob job)
  {
    if (job == null)
      throw new IllegalArgumentException("Job applied to cannot be null");
    if (jobseeker == null)
      throw new IllegalArgumentException("Jobseeker cannot be null");
    return submitJobApplication(applicationFactory.createApplication(jobseeker, job));
  }

  private JobApplication submitJobApplication(JobApplication jobApplication)
  {
    return jobApplications.add(jobApplication);
  }
}
