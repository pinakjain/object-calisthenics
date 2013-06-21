package main;

import java.util.HashMap;
import java.util.Map;

public class ResumeRepository
{

  private final Map<Jobseeker, Resume> resumeRepo;

  public ResumeRepository()
  {
    this.resumeRepo = new HashMap<Jobseeker, Resume>();
  }

  public void add(Jobseeker jobseeker,
                  Resume resume) throws NullPointerException
  {
    if (jobseeker == null)
      throw new NullPointerException("Jobseeker cannot be null");
    if (resume == null)
      throw new NullPointerException("Resume cannot be null");
    resumeRepo.put(jobseeker, resume);
  }

  public Resume getResume(Jobseeker jobseeker)
  {
    return resumeRepo.get(jobseeker);
  }

}
