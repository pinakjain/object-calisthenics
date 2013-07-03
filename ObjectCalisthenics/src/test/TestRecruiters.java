package test;

import static org.junit.Assert.*;

import main.display.RecruiterDisplayer;
import main.recruiter.Recruiter;
import main.recruiter.Recruiters;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiters
{

  private Recruiters recruiters;
  private RecruiterDisplayer displayer;

  @Test
  public void testEmptyRecruiters()
  {
    assertEquals(0, recruiters.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addNullRecruiter()
  {
    recruiters.add(null);
  }

  @Test
  public void addRecruiter()
  {
    Recruiter recruiter = recruiters.add(setUpRecruiter());
    assertTrue(recruiters.contains(recruiter));
  }

  @Test
  public void addTwoRecruitersWithSameName()
  {
    Recruiter recruiter1 = recruiters.add(setUpRecruiter());
    Recruiter recruiter2 = recruiters.add(setUpRecruiter());
    assertFalse(recruiter1.equals(recruiter2));
    assertTrue(recruiters.contains(recruiter1));
    assertTrue(recruiters.contains(recruiter2));
  }
  
  @Test
  public void displayRecruiters()
  {
    Recruiter recruiter1 = setUpRecruiter();
    Recruiter recruiter2 = setUpRecruiter();
    recruiters.add(recruiter1);
    recruiters.add(recruiter2);
    recruiters.display(displayer);
  }

  private static Recruiter setUpRecruiter()
  {
    return new Recruiter("Ladders");
  }

  @Before
  public void setUpRecruiters()
  {
    recruiters = new Recruiters();
    displayer = new RecruiterDisplayer();
  }

}
