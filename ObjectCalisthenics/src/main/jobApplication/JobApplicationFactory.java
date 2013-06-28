package main.jobApplication;

import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.resume.ResumeRepository;
import main.utils.DateGenerator;

public class JobApplicationFactory
{

  private final ResumeRepository resumeRepository;
  private final DateGenerator    dateGenerator;

  public JobApplicationFactory(ResumeRepository resumeRepository,
                               DateGenerator    dateGenerator)
  {
    if (resumeRepository == null)
      throw new IllegalArgumentException("Resume repository cannot be null");
    if (dateGenerator == null)
      throw new IllegalArgumentException("Date Generator cannot be null");
    this.resumeRepository = resumeRepository;
    this.dateGenerator = dateGenerator;
  }

  public JobApplication createApplication(Jobseeker jobseeker,
                                          RecruiterJob job) throws IllegalArgumentException
  {
    if (job.isJReqJob())
    {
      return applicationUsingResume(jobseeker, job);
    }
    return applicationWithoutResume(jobseeker, job);
  }

  public JobApplication applicationUsingResume(Jobseeker jobseeker,
                                               RecruiterJob job) throws IllegalArgumentException
  {
    return new JobApplication(jobseeker, job, resumeRepository.getResume(jobseeker), dateGenerator.applicationDate());
  }

  public JobApplication applicationWithoutResume(Jobseeker jobseeker,
                                                 RecruiterJob job) throws IllegalArgumentException
  {
    return new JobApplication(jobseeker, job, null, dateGenerator.applicationDate());
  }

}
