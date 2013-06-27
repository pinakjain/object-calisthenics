package main.resume;

import java.util.HashMap;
import java.util.Map;

import main.jobseeker.Jobseeker;

public class ResumeRepository
{

  private final Map<Jobseeker, Resume> resumeRepo;

  public ResumeRepository()
  {
    this.resumeRepo = new HashMap<>();
  }

  public void add(Jobseeker jobseeker,
                  Resume resume)
  {
    if (jobseeker == null)
      throw new IllegalArgumentException("Jobseeker cannot be null");
    if (resume == null)
      throw new IllegalArgumentException("Resume cannot be null");
    resumeRepo.put(jobseeker, resume);
  }

  public Resume getResume(Jobseeker jobseeker)
  {
    if (resumeRepo.get(jobseeker) == null)
      //TODO Replace the null pointer exception with a Resume Not Found Exception
      throw new NullPointerException("No resume for this jobseeker");
    return resumeRepo.get(jobseeker);
  }

}
