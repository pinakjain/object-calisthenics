package test;

import static org.junit.Assert.*;

import main.recruiter.Recruiter;

import org.junit.Test;

public class TestRecruiter
{

  private Recruiter recruiter;

  @Test(expected = IllegalArgumentException.class)
  public void createRecruiterWithNullName()
  {
    recruiter = new Recruiter(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createRecruiterWithEmptyName() 
  {
    recruiter = new Recruiter("");
  }

  @Test
  public void createRecruiter()
  {
    recruiter = new Recruiter("Ladders");
    recruiter.display();
    assertEquals("Recruiter :- Ladders", recruiter.toString());
  }
}
