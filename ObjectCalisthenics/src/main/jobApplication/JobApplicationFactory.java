package main.jobApplication;

import java.util.Date;

import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.resume.ResumeRepository;

public class JobApplicationFactory
{

  private final ResumeRepository resumeRepository;
  private final Date             date;

  public JobApplicationFactory(ResumeRepository resumeRepository,
                               Date date)
  {
    if (resumeRepository == null)
      throw new IllegalArgumentException("Resume repository cannot be null");
    if (date == null)
      throw new IllegalArgumentException("Date cannot be null");
    this.resumeRepository = resumeRepository;
    this.date = date;
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
    return new JobApplication(jobseeker, job, resumeRepository.getResume(jobseeker), date);
  }

  public JobApplication applicationWithoutResume(Jobseeker jobseeker,
                                                 RecruiterJob job) throws IllegalArgumentException
  {
    return new JobApplication(jobseeker, job, null, date);
  }

}
