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
      return applyUsingResume(jobseeker, job);
    }
    return applyWithoutResume(jobseeker, job);
  }

  public JobApplication applyUsingResume(Jobseeker jobseeker,
                                         RecruiterJob job) throws IllegalArgumentException
  {
    return new JobApplication(jobseeker, job, resumeRepository.getResume(jobseeker));
  }

  public JobApplication applyWithoutResume(Jobseeker jobseeker,
                                           RecruiterJob job) throws IllegalArgumentException
  {
    return new JobApplication(jobseeker, job, null);
  }

}
