package test;

import static org.junit.Assert.*;

import main.jobs.ATSJob;
import main.jobs.JReqJob;
import main.jobs.Jobs;
import main.jobs.JobsManager;
import main.recruiter.Recruiter;
import main.jobs.RecruiterJob;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiterJobs
{

  private JobsManager jobsManager;
  private Jobs        jobs;
  private Recruiter   recruiter;

  @Before
  public void setUp()
  {
    setUpJobs();
    setUpJobsManager();
    setUpRecruiter();
  }

  @Test(expected = IllegalArgumentException.class)
  public void postNullJob()
  {
    recruiter.postJob(null, jobsManager);
  }

  @Test
  public void testPostingATSJob()
  {
    RecruiterJob job = postATSJob();
    jobs.display();
    assertTrue(jobs.contains(job));
  }

  @Test
  public void testPostingJreqJob()
  {
    RecruiterJob job = postJreqJob();
    jobs.display();
    assertTrue(jobs.contains(job));
  }

  @Test
  public void jobsPostedByRecruiter()
  {
    RecruiterJob job1 = postATSJob();
    RecruiterJob job2 = postJreqJob();
    Jobs recruiterJobs = recruiter.myJobs(jobsManager);
    assertEquals(2, recruiterJobs.size());
    assertTrue(jobs.contains(job1));
    assertTrue(jobs.contains(job2));
    jobs.display();
  }

  private void setUpJobsManager()
  {
    jobsManager = new JobsManager(jobs);
  }

  private void setUpJobs()
  {
    jobs = new Jobs();
  }

  private void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  private RecruiterJob postATSJob()
  {
    return recruiter.postJob(new ATSJob("Software"), jobsManager);
  }

  private RecruiterJob postJreqJob()
  {
    return recruiter.postJob(new JReqJob("Software"), jobsManager);
  }

}
