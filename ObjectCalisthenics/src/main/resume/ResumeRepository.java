package main.resume;

import java.util.HashMap;
import java.util.Map;

import main.jobseeker.Jobseeker;

public class ResumeRepository
{

  private final Map<Jobseeker, Resume> resumeRepo;

  public ResumeRepository()
  {
    this.resumeRepo = new HashMap<Jobseeker, Resume>();
  }

  public void add(Jobseeker jobseeker,
                  Resume resume) throws IllegalArgumentException
  {
    if (jobseeker == null)
      throw new IllegalArgumentException("Jobseeker cannot be null");
    if (resume == null)
      throw new IllegalArgumentException("Resume cannot be null");
    resumeRepo.put(jobseeker, resume);
  }

  public Resume getResume(Jobseeker jobseeker)
  {
    return resumeRepo.get(jobseeker);
  }

}
