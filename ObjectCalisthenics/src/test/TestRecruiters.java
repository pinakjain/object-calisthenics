package test;

import static org.junit.Assert.*;

import main.Recruiter;
import main.Recruiters;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiters
{

  private Recruiters recruiters;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpRecruiters();
  }

  @Test
  public void testEmptyRecruiters()
  {
    assertEquals(0, recruiters.size());
  }

  @Test(expected = Exception.class)
  public void addNullRecruiter() throws NullPointerException
  {
    recruiters.add(null);
  }

  @Test
  public void addRecruiter() throws NullPointerException
  {
    Recruiter recruiter = recruiters.add(setUpRecruiter());
    assertTrue(recruiters.contains(recruiter));
  }

  @Test
  public void addTwoRecruitersWithSameName() throws NullPointerException
  {
    Recruiter recruiter1 = recruiters.add(setUpRecruiter());
    Recruiter recruiter2 = recruiters.add(setUpRecruiter());
    recruiters.display();
    assertTrue(recruiters.contains(recruiter1));
    assertTrue(recruiters.contains(recruiter2));

  }

  public Recruiter setUpRecruiter()
  {
    return new Recruiter("Ladders");
  }

  public void setUpRecruiters()
  {
    recruiters = new Recruiters();
  }

}
