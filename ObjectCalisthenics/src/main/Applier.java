package main;

public class Applier
{

  private final ResumeRepository resumeRepository;

  public Applier(ResumeRepository resumeRepository)
  {
    this.resumeRepository = resumeRepository;
  }

  public JobApplication createApplication(Jobseeker jobseeker,
                                          RecruiterJob job) throws NullPointerException
  {
    if (job.requiresResume())
    {
      return applyUsingResume(jobseeker, job);
    }
    return applyWithoutResume(jobseeker, job);
  }

  public JobApplication applyUsingResume(Jobseeker jobseeker,
                                         RecruiterJob job) throws NullPointerException
  {
    return new JobApplication(jobseeker, job, resumeRepository.getResume(jobseeker));
  }

  public JobApplication applyWithoutResume(Jobseeker jobseeker,
                                           RecruiterJob job) throws NullPointerException
  {
    return new JobApplication(jobseeker, job, null);
  }

}
