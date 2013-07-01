package test;

import static org.junit.Assert.*;

import main.display.TestDisplayer;
import main.jobs.ATSJob;
import main.jobs.JReqJob;
import main.jobs.Jobs;
import main.jobs.RecruiterJob;
import main.recruiter.Recruiter;

import org.junit.Before;
import org.junit.Test;

public class TestJobs
{

  private Jobs      jobs;
  private Recruiter recruiter;
  private TestDisplayer displayer;

  @Before
  public void setUp()
  {
    setUpJobs();
    setUpRecruiter();
    setUpDisplayer();
  }

  @Test
  public void testEmptyJobs()
  {
    assertEquals(0, jobs.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addNullJob()
  {
    jobs.add(null);
  }

  @Test
  public void addATSJob()
  {
    RecruiterJob job = jobs.add(setUpATSRecruiterJob());
    assertTrue(jobs.contains(job));
  }

  @Test
  public void addJreqJob()
  {
    RecruiterJob job = jobs.add(setUpJReqRecruiterJob());
    assertTrue(jobs.contains(job));
  }

  @Test
  public void addDifferentTypeJobsWithSameTitle()
  {
    RecruiterJob job1 = jobs.add(setUpJReqRecruiterJob());
    RecruiterJob job2 = jobs.add(setUpATSRecruiterJob());
    assertFalse(job1.equals(job2));
    assertTrue(jobs.contains(job1));
    assertTrue(jobs.contains(job2));
  }
  
  @Test
  public void addSameTypeJobsWithSameTitle()
  {
    RecruiterJob job1 = jobs.add(setUpATSRecruiterJob());
    RecruiterJob job2 = jobs.add(setUpATSRecruiterJob());
    assertFalse(job1.equals(job2));
    assertTrue(jobs.contains(job1));
    assertTrue(jobs.contains(job2));
  }

  @Test
  public void displayJobs() 
  {
    RecruiterJob job1 = setUpJReqRecruiterJob();
    RecruiterJob job2 = setUpATSRecruiterJob();
    jobs.add(job1);
    jobs.add(job2);
    StringBuffer sb = new StringBuffer();
    sb.append(job1);
    sb.append(job2);
    jobs.display(displayer);
    assertEquals(sb.toString(), displayer.displayedText().toString());
  }
  
  private RecruiterJob setUpATSRecruiterJob()
  {
    return new RecruiterJob(recruiter, setUpATSJob());
  }
  
  private RecruiterJob setUpJReqRecruiterJob()
  {
    return new RecruiterJob(recruiter, setUpJReqJob());
  }

  private void setUpJobs()
  {
    jobs = new Jobs();
  }

  private void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  private static ATSJob setUpATSJob()
  {
    return new ATSJob("Software");
  }

  private static JReqJob setUpJReqJob()
  {
    return new JReqJob("Software");
  }
  
  private void setUpDisplayer()
  {
    displayer = new TestDisplayer();
  }

}
