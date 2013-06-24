package test;

import static org.junit.Assert.*;

import main.recruiter.Recruiter;
import main.recruiter.Recruiters;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiters
{

  private Recruiters recruiters;

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
    recruiters.display();
    assertFalse(recruiter1.equals(recruiter2));
    assertTrue(recruiters.contains(recruiter1));
    assertTrue(recruiters.contains(recruiter2));

  }

  private Recruiter setUpRecruiter()
  {
    return new Recruiter("Ladders");
  }

  @Before
  public void setUpRecruiters()
  {
    recruiters = new Recruiters();
  }

}
