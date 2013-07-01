package test;

import static org.junit.Assert.*;

import main.display.TestDisplayer;
import main.jobseeker.Jobseeker;
import main.jobseeker.Jobseekers;

import org.junit.Before;
import org.junit.Test;

public class TestJobseekers
{

  private Jobseekers jobseekers;
  private TestDisplayer displayer;

  @Before
  public void setUp() 
  {
    setUpJobseekers();
    setUpJobseeker();
    setUpDisplayer();
  }

  private void setUpDisplayer()
  {
    displayer = new TestDisplayer();
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
    assertFalse(jobseeker1.equals(jobseeker2));
    assertTrue(jobseekers.contains(jobseeker1));
    assertTrue(jobseekers.contains(jobseeker2));
  }
  
  @Test
  public void displayJobseekers() 
  {
    Jobseeker jobseeker1 = setUpJobseeker();
    Jobseeker jobseeker2 = setUpJobseeker();
    jobseekers.add(jobseeker1);
    jobseekers.add(jobseeker2);
    StringBuffer sb = new StringBuffer();
    sb.append(jobseeker1);
    sb.append(jobseeker2);
    jobseekers.display(displayer);
    assertEquals(sb.toString(), displayer.displayedText().toString());
  }
  
  @Test
  public void testEquals() 
  {
    Jobseeker jobseeker1 = setUpJobseeker();
    Jobseeker jobseeker2 = setUpJobseeker();
    jobseekers.add(jobseeker1);
    jobseekers.add(jobseeker2);
    Jobseekers jobseekersCopy = new Jobseekers();
    jobseekersCopy.add(jobseeker1);
    jobseekersCopy.add(jobseeker2);
    assertEquals(jobseekers, jobseekersCopy);
  }
  
  @Test
  public void testNotEquals() 
  {
    Jobseeker jobseeker1 = setUpJobseeker();
    Jobseeker jobseeker2 = setUpJobseeker();
    jobseekers.add(jobseeker1);
    jobseekers.add(jobseeker2);
    Jobseekers jobseekersCopy = new Jobseekers();
    jobseekersCopy.add(jobseeker1);
    assertNotSame(jobseekers, jobseekersCopy);
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
