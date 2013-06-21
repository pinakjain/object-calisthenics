package test;

import static org.junit.Assert.*;

import main.ATSJob;
import main.JReqJob;
import main.Jobs;
import main.Recruiter;
import main.RecruiterJob;

import org.junit.Before;
import org.junit.Test;

public class TestJobs
{

  private Jobs      jobs;
  private Recruiter recruiter;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpJobs();
    setUpRecruiter();
  }

  @Test
  public void testEmptyJobs()
  {
    assertEquals(0, jobs.size());
  }

  @Test(expected = Exception.class)
  public void addNullJob() throws NullPointerException
  {
    jobs.add(null);
  }

  @Test
  public void addATSJob() throws NullPointerException
  {
    RecruiterJob job = jobs.add(new RecruiterJob(recruiter, new ATSJob("Software")));
    jobs.display();
    assertTrue(jobs.contains(job));
  }

  @Test
  public void addJreqJob() throws NullPointerException
  {
    RecruiterJob job = jobs.add(new RecruiterJob(recruiter, new JReqJob("Software")));
    jobs.display();
    assertTrue(jobs.contains(job));
  }

  @Test
  public void addJobsWithSameTitle() throws NullPointerException
  {
    RecruiterJob job1 = jobs.add(new RecruiterJob(recruiter, new JReqJob("Software")));
    RecruiterJob job2 = jobs.add(new RecruiterJob(recruiter, new ATSJob("Software")));
    jobs.display();
    assertTrue(jobs.contains(job1));
    assertTrue(jobs.contains(job2));
  }

  public void setUpJobs()
  {
    jobs = new Jobs();
  }

  public void setUpRecruiter() throws NullPointerException
  {
    recruiter = new Recruiter("Ladders");
  }

}
