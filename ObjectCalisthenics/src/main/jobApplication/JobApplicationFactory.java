package main.jobApplication;

import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.resume.ResumeRepository;

public class JobApplicationFactory
{

  private final ResumeRepository resumeRepository;

  public JobApplicationFactory(ResumeRepository resumeRepository)
  {
    if (resumeRepository == null)
      throw new IllegalArgumentException("Resume repository cannot be null");
    this.resumeRepository = resumeRepository;
  }

  public JobApplication createApplication(Jobseeker jobseeker,
                                          RecruiterJob job) throws IllegalArgumentException
  {
    if (job.requiresResume())
    {
      return applicationUsingResume(jobseeker, job);
    }
    return applicationWithoutResume(jobseeker, job);
  }

  public JobApplication applicationUsingResume(Jobseeker jobseeker,
                                         RecruiterJob job) throws IllegalArgumentException
  {
    return new JobApplication(jobseeker, job, resumeRepository.getResume(jobseeker));
  }

  public JobApplication applicationWithoutResume(Jobseeker jobseeker,
                                           RecruiterJob job) throws IllegalArgumentException
  {
    return new JobApplication(jobseeker, job, null);
  }

}
