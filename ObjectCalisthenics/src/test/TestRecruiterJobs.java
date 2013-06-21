package test;

import static org.junit.Assert.*;

import main.ATSJob;
import main.JReqJob;
import main.Job;
import main.Jobs;
import main.JobsManager;
import main.Recruiter;
import main.RecruiterJob;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiterJobs
{

  private JobsManager jobsManager;
  private Jobs        jobs;
  private Recruiter   recruiter;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpJobs();
    setUpJobsManager();
    setUpRecruiter();
  }

  @Test(expected = Exception.class)
  public void postNullJob() throws NullPointerException
  {
    Job job = null;
    recruiter.postJob(job, jobsManager);
  }

  @Test(expected = Exception.class)
  public void postJobHavingNoTitle() throws NullPointerException
  {
    Job job = new ATSJob("");
    recruiter.postJob(job, jobsManager);
  }

  @Test
  public void testPostingATSJob() throws NullPointerException
  {
    RecruiterJob job = postATSJob();
    jobs.display();
    assertFalse(job.requiresResume());
  }

  @Test
  public void testPostingJreqJob() throws NullPointerException
  {
    RecruiterJob job = postJreqJob();
    jobs.display();
    assertTrue(job.requiresResume());
  }

  @Test
  public void numberOfJobsPostedByRecruiter() throws NullPointerException
  {
    postATSJob();
    postJreqJob();
    Jobs jobs = recruiter.myJobs(jobsManager);
    jobs.display();
    assertEquals(2, jobs.size());
  }

  public void setUpJobsManager()
  {
    jobsManager = new JobsManager(jobs);
  }

  public void setUpJobs()
  {
    jobs = new Jobs();
  }

  public void setUpRecruiter() throws NullPointerException
  {
    recruiter = new Recruiter("Ladders");
  }

  public RecruiterJob postATSJob() throws NullPointerException
  {
    Job job1 = new ATSJob("Software");
    return recruiter.postJob(job1, jobsManager);
  }

  public RecruiterJob postJreqJob() throws NullPointerException
  {
    Job job2 = new JReqJob("Software");
    return recruiter.postJob(job2, jobsManager);
  }

}
