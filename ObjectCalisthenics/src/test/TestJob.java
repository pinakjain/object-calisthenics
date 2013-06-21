package test;

import static org.junit.Assert.*;

import main.ATSJob;
import main.JReqJob;
import main.Job;

import org.junit.Before;
import org.junit.Test;

public class TestJob
{

  private Job job;

  @Before
  public void setUp() throws NullPointerException
  {}

  @Test(expected = Exception.class)
  public void createATSJobWithNullTitle() throws NullPointerException
  {
    job = new ATSJob(null);
  }

  @Test(expected = Exception.class)
  public void createATSJobWithEmptyTitle() throws NullPointerException
  {
    job = new ATSJob("");
  }

  @Test(expected = Exception.class)
  public void createJReqJobWithNullTitle() throws NullPointerException
  {
    job = new JReqJob(null);
  }

  @Test(expected = Exception.class)
  public void createJReqJobWithEmptyTitle() throws NullPointerException
  {
    job = new JReqJob("");
  }

  @Test
  public void createJReqJob() throws NullPointerException
  {
    job = new JReqJob("Software");
    assertEquals(new String("JReqJob :- Software"), job.toString());
  }

  @Test
  public void createATSJob() throws NullPointerException
  {
    job = new ATSJob("Software");
    assertEquals(new String("ATSJob :- Software"), job.toString());
  }
}
