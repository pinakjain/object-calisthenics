package test;

import static org.junit.Assert.*;

import main.ATSJob;
import main.JReqJob;
import main.Jobs;
import main.Jobseeker;
import main.Recruiter;
import main.RecruiterJob;
import main.SavedJobs;
import main.SavedJobsManager;

import org.junit.Before;
import org.junit.Test;

public class TestJobseekerSavedJobs
{

  private SavedJobs        savedJobs;
  private SavedJobsManager savedJobsManager;
  private Jobseeker        jobseeker;
  private Recruiter        recruiter;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpSavedJobs();
    setUpSavedJobsManager();
    setUpRecruiter();
    setUpJobseeker();
  }

  @Test(expected = Exception.class)
  public void saveNullJob() throws NullPointerException
  {
    jobseeker.save(null, savedJobsManager);
  }

  @Test
  public void saveATSjob() throws NullPointerException
  {
    RecruiterJob job = saveATSJob();
    assertTrue(savedJobs.containsJobSavedByRecruiter(jobseeker, job));
  }

  @Test
  public void saveJReqjob() throws NullPointerException
  {
    RecruiterJob job = saveJReqJob();
    assertTrue(savedJobs.containsJobSavedByRecruiter(jobseeker, job));
  }

  @Test
  public void numberOfJobsSavedByJobseeker() throws NullPointerException
  {
    RecruiterJob job1 = saveATSJob();
    RecruiterJob job2 = saveJReqJob();
    jobseeker.viewSavedJobs(savedJobsManager).display();
    assertTrue(savedJobs.containsJobSavedByRecruiter(jobseeker, job1));
    assertTrue(savedJobs.containsJobSavedByRecruiter(jobseeker, job2));
  }

  public void setUpSavedJobs()
  {
    savedJobs = new SavedJobs();
  }

  public void setUpSavedJobsManager()
  {
    savedJobsManager = new SavedJobsManager(savedJobs);
  }

  public void setUpJobseeker() throws NullPointerException
  {
    jobseeker = new Jobseeker("Tom");
  }

  public void setUpRecruiter() throws NullPointerException
  {
    recruiter = new Recruiter("Ladders");
  }

  public RecruiterJob saveATSJob() throws NullPointerException
  {
    RecruiterJob recruiterJob2 = new RecruiterJob(recruiter, new ATSJob("Software"));
    return jobseeker.save(recruiterJob2, savedJobsManager);
  }

  public RecruiterJob saveJReqJob() throws NullPointerException
  {
    RecruiterJob recruiterJob1 = new RecruiterJob(recruiter, new JReqJob("Software"));
    return jobseeker.save(recruiterJob1, savedJobsManager);
  }

}
