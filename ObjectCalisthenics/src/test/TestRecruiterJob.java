package test;

import static org.junit.Assert.*;

import main.jobs.ATSJob;
import main.recruiter.Recruiter;
import main.jobs.RecruiterJob;

import org.junit.Test;

public class TestRecruiterJob
{

  private RecruiterJob recruiterJob;

  @Test(expected = IllegalArgumentException.class)
  public void createRecruiterJobWithNullArguments()
  {
    recruiterJob = new RecruiterJob(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createRecruiterJobWithNullRecruiter()
  {
    recruiterJob = new RecruiterJob(null, createATSJob());
  }

  @Test(expected = IllegalArgumentException.class)
  public void createRecruiterJobWithNullJob()
  {
    recruiterJob = new RecruiterJob(setUpRecruiter(), null);
  }

  @Test
  public void createRecruiterJob()
  {
    recruiterJob = new RecruiterJob(setUpRecruiter(), createATSJob());
    assertEquals("ATSJob :- Software posted by Recruiter :- Ladders", recruiterJob.toString());
  }

  
  private static Recruiter setUpRecruiter()
  {
    return new Recruiter("Ladders");
  }

  private static ATSJob createATSJob()
  {
    return new ATSJob("Software");
  }

}
