package test;

import static org.junit.Assert.*;

import main.ATSJob;
import main.JReqJob;
import main.JobApplication;
import main.JobApplications;
import main.Jobseeker;
import main.Recruiter;
import main.RecruiterJob;
import main.Resume;

import org.junit.Before;
import org.junit.Test;

public class TestJobApplications
{

  private JobApplications       jobApplications;
  private Jobseeker             jobseeker;
  private Recruiter             recruiter;
  private Resume                resume;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpRecruiter();
    setUpJobseeker();
    setUpResume();
    setUpJobApplications();
  }

  @Test
  public void testEmptyJobApplications()
  {
    assertEquals(0, jobApplications.size());
  }

  @Test
  public void addJobApplication()
  {
    JobApplication jobApplication = new JobApplication(jobseeker, setUpATSJob(), resume);
    jobApplications.add(jobApplication);
    assertTrue(jobApplications.contains(jobApplication));
  }

  @Test
  public void addOneMoreJobApplication()
  {
    JobApplication jobApplication = new JobApplication(jobseeker, setUpJReqJob(), resume);
    jobApplications.add(jobApplication);
    assertTrue(jobApplications.contains(jobApplication));
  }

  @Test
  public void addTwoJobApplications()
  {
    JobApplication jobApplication1 = new JobApplication(jobseeker, setUpATSJob(), resume);
    JobApplication jobApplication2 = new JobApplication(jobseeker, setUpJReqJob(), resume);
    jobApplications.add(jobApplication1);
    jobApplications.add(jobApplication2);
    assertTrue(jobApplications.contains(jobApplication1));
    assertTrue(jobApplications.contains(jobApplication2));
  }

  public void setUpJobApplications()
  {
    jobApplications = new JobApplications();
  }

  public void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  public void setUpJobseeker()
  {
    jobseeker = new Jobseeker("Tom");
  }

  public void setUpResume()
  {
    resume = new Resume("Resume");
  }

  public RecruiterJob setUpATSJob()
  {
    return new RecruiterJob(recruiter, new ATSJob("Software"));
  }

  public RecruiterJob setUpJReqJob()
  {
    return new RecruiterJob(recruiter, new JReqJob("Software"));
  }
}
