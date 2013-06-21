package test;

import static org.junit.Assert.*;

import main.Recruiter;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiter
{

  private Recruiter recruiter;

  @Before
  public void setUp() throws NullPointerException
  {}

  @Test(expected = Exception.class)
  public void createRecruiterWithNullName() throws NullPointerException
  {
    recruiter = new Recruiter(null);
  }

  @Test(expected = Exception.class)
  public void createRecruiterWithEmptyName() throws NullPointerException
  {
    recruiter = new Recruiter("");
  }

  @Test
  public void createRecruiter() throws NullPointerException
  {
    recruiter = new Recruiter("Ladders");
    assertEquals(new String("Recruiter :- Ladders"), recruiter.toString());
  }
}
