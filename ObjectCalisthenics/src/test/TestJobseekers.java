package test;

import static org.junit.Assert.*;

import main.jobseeker.Jobseeker;
import main.jobseeker.Jobseekers;

import org.junit.Before;
import org.junit.Test;

public class TestJobseekers
{

  private Jobseekers jobseekers;

  @Before
  public void setUp() 
  {
    setUpJobseekers();
    setUpJobseeker();
  }

  @Test
  public void testEmptyJobseekers()
  {
    assertEquals(0, jobseekers.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addNullJobseeker() 
  {
    jobseekers.add(null);
  }

  @Test
  public void addJobseeker() 
  {
    Jobseeker jobseeker = jobseekers.add(setUpJobseeker());
    assertTrue(jobseekers.contains(jobseeker));
  }

  @Test
  public void addTwoJobseekerWithSameName() 
  {
    Jobseeker jobseeker1 = jobseekers.add(setUpJobseeker());
    Jobseeker jobseeker2 = jobseekers.add(setUpJobseeker());
    jobseekers.display();
    assertFalse(jobseeker1.equals(jobseeker2));
    assertTrue(jobseekers.contains(jobseeker1));
    assertTrue(jobseekers.contains(jobseeker2));
  }

  private void setUpJobseekers()
  {
    jobseekers = new Jobseekers();
  }
  
  private static Jobseeker setUpJobseeker()
  {
   return new Jobseeker("Tom");
  }

}
