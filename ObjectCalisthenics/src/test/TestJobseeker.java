package test;

import static org.junit.Assert.*;

import main.Jobseeker;

import org.junit.Before;
import org.junit.Test;

public class TestJobseeker
{

  private Jobseeker jobseeker;

  @Before
  public void setUp() throws NullPointerException
  {}

  @Test(expected = Exception.class)
  public void createJobseekerWithNullName() throws NullPointerException
  {
    jobseeker = new Jobseeker(null);
  }

  @Test(expected = Exception.class)
  public void createJobseekerWithEmptyName() throws NullPointerException
  {
    jobseeker = new Jobseeker("");
  }

  @Test
  public void createJobseeker() throws NullPointerException
  {
    jobseeker = new Jobseeker("Tom");
    assertEquals(new String("Jobseeker :- Tom"), jobseeker.toString());
  }

}
