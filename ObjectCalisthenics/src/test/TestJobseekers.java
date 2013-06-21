package test;

import static org.junit.Assert.*;

import main.Jobseeker;
import main.Jobseekers;

import org.junit.Before;
import org.junit.Test;

public class TestJobseekers
{

  private Jobseekers jobseekers;
  private Jobseeker jobseeker;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpJobseekers();
    setUpJobseeker();
  }

  @Test
  public void testEmptyJobseekers()
  {
    assertEquals(0, jobseekers.size());
  }

  @Test(expected = Exception.class)
  public void addNullJobseeker() throws NullPointerException
  {
    jobseekers.add(null);
  }

  @Test
  public void addJobseeker() throws NullPointerException
  {
    Jobseeker jobseeker1 = jobseekers.add(jobseeker);
    assertTrue(jobseekers.contains(jobseeker1));
  }

  @Test
  public void addTwoJobseekerWithSameName() throws NullPointerException
  {
    Jobseeker jobseeker1 = jobseekers.add(jobseeker);
    Jobseeker jobseeker2 = jobseekers.add(new Jobseeker("Tom"));
    jobseekers.display();
    assertTrue(jobseekers.contains(jobseeker1));
    assertTrue(jobseekers.contains(jobseeker2));
  }

  public void setUpJobseekers()
  {
    jobseekers = new Jobseekers();
  }
  
  public void setUpJobseeker()
  {
    jobseeker = new Jobseeker("Tom");
  }

}
