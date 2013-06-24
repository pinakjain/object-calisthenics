package test;

import static org.junit.Assert.*;

import main.jobseeker.Jobseeker;

import org.junit.Test;

public class TestJobseeker
{

  private Jobseeker jobseeker; 

  @Test(expected = IllegalArgumentException.class)
  public void createJobseekerWithNullName()
  {
    jobseeker = new Jobseeker(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createJobseekerWithEmptyName() 
  {
    jobseeker = new Jobseeker("");
  }

  @Test
  public void createJobseeker()
  {
    jobseeker = new Jobseeker("Tom");
    assertEquals("Jobseeker :- Tom", jobseeker.toString());
  }

}
