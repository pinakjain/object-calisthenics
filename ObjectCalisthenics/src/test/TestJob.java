package test;

import static org.junit.Assert.*;

import main.jobs.ATSJob;
import main.jobs.JReqJob;
import main.jobs.Job;

import org.junit.Test;

public class TestJob
{

  private Job job;

  @Test(expected = IllegalArgumentException.class)
  public void createATSJobWithNullTitle()
  {
    job = new ATSJob(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createATSJobWithEmptyTitle()
  {
    job = new ATSJob("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void createJReqJobWithNullTitle()
  {
    job = new JReqJob(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createJReqJobWithEmptyTitle()
  {
    job = new JReqJob("");
  }

  @Test
  public void createJReqJob()
  {
    job = new JReqJob("Software");
    assertEquals("JReqJob :- Software", job.toString());
  }

  @Test
  public void createATSJob()
  {
    job = new ATSJob("Software");
    assertEquals("ATSJob :- Software", job.toString());
  }
}
