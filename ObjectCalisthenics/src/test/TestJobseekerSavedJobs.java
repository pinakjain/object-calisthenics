package test;

import static org.junit.Assert.*;

import main.jobs.ATSJob;
import main.jobs.JReqJob;
import main.jobseeker.Jobseeker;
import main.recruiter.Recruiter;
import main.jobs.RecruiterJob;
import main.jobs.SavedJobs;
import main.jobs.SavedJobsManager;

import org.junit.Before;
import org.junit.Test;

public class TestJobseekerSavedJobs
{

  private SavedJobs        savedJobs;
  private SavedJobsManager savedJobsManager;
  private Jobseeker        jobseeker;
  private Recruiter        recruiter;

  @Before
  public void setUp()
  {
    setUpSavedJobs();
    setUpSavedJobsManager();
    setUpRecruiter();
    setUpJobseeker();
  }

  @Test(expected = IllegalArgumentException.class)
  public void saveNullJob()
  {
    jobseeker.save(null, savedJobsManager);
  }

  @Test
  public void saveATSjob()
  {
    RecruiterJob job = saveATSJob();
    assertTrue(savedJobs.containsJobSavedByJobseeker(jobseeker, job));
  }

  @Test
  public void saveJReqjob()
  {
    RecruiterJob job = saveJReqJob();
    assertTrue(savedJobs.containsJobSavedByJobseeker(jobseeker, job));
  }

  @Test
  public void testJobsSavedByJobseeker()
  {
    RecruiterJob job1 = saveATSJob();
    RecruiterJob job2 = saveJReqJob();
    assertTrue(savedJobs.containsJobSavedByJobseeker(jobseeker, job1));
    assertTrue(savedJobs.containsJobSavedByJobseeker(jobseeker, job2));
  }

  private void setUpSavedJobs()
  {
    savedJobs = new SavedJobs();
  }

  private void setUpSavedJobsManager()
  {
    savedJobsManager = new SavedJobsManager(savedJobs);
  }

  private void setUpJobseeker()
  {
    jobseeker = new Jobseeker("Tom");
  }

  private void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  private RecruiterJob saveATSJob()
  {
    RecruiterJob recruiterJob = new RecruiterJob(recruiter, new ATSJob("Software"));
    return jobseeker.save(recruiterJob, savedJobsManager);
  }

  private RecruiterJob saveJReqJob()
  {
    RecruiterJob recruiterJob = new RecruiterJob(recruiter, new JReqJob("Software"));
    return jobseeker.save(recruiterJob, savedJobsManager);
  }

}
