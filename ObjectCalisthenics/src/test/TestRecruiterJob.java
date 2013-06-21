package test;

import static org.junit.Assert.*;

import main.ATSJob;
import main.Recruiter;
import main.RecruiterJob;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiterJob
{

  private RecruiterJob recruiterJob;
  private Recruiter    recruiter;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpRecruiter();
  }

  @Test(expected = Exception.class)
  public void createRecruiterJobWithNullArguments() throws NullPointerException
  {
    recruiterJob = new RecruiterJob(null, null);
  }

  @Test(expected = Exception.class)
  public void createRecruiterJobWithNullRecruiter() throws NullPointerException
  {
    recruiterJob = new RecruiterJob(null, createATSJob());
  }

  @Test(expected = Exception.class)
  public void createRecruiterJobWithNullJob() throws NullPointerException
  {
    recruiterJob = new RecruiterJob(recruiter, null);
  }

  @Test
  public void createRecruiterJob() throws NullPointerException
  {
    recruiterJob = new RecruiterJob(recruiter, createATSJob());
    assertEquals(new String("ATSJob :- Software posted by Recruiter :- Ladders"), recruiterJob.toString());
  }

  public void setUpRecruiter() throws NullPointerException
  {
    recruiter = new Recruiter("Ladders");
  }

  public ATSJob createATSJob() throws NullPointerException
  {
    return new ATSJob("Software");
  }

}
