package test;

import static org.junit.Assert.*;

import main.ATSJob;
import main.Applier;
import main.JReqJob;
import main.JobApplication;
import main.JobApplicationManager;
import main.JobApplications;
import main.Jobseeker;
import main.Recruiter;
import main.RecruiterJob;
import main.Resume;
import main.ResumeRepository;

import org.junit.Before;
import org.junit.Test;

public class TestJobseekerJobs
{

  private ResumeRepository      resumeRepository;
  private JobApplications       jobApplications;
  private JobApplicationManager jobApplicationManager;
  private Jobseeker             jobseeker;
  private Recruiter             recruiter;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpJobseeker();
    setUpResumeRepo();
    setUpJobApplications();
    setUpJobApplicationManager();
    setUpRecruiter();

  }

  @Test(expected = Exception.class)
  public void applyToANullJob() throws Exception
  {
    jobseeker.apply(null, jobApplicationManager);
  }

  @Test
  public void applyATSJob() throws NullPointerException
  {
    JobApplication application = applyATSJOb();
    assertTrue(jobApplications.contains(application));
  }

  @Test
  public void applyJreqJobUsingResume() throws NullPointerException
  {
    JobApplication application = applyJReqJob();
    assertTrue(jobApplications.contains(application));
  }

  @Test(expected = Exception.class)
  public void applyJreqJobWithoutUsingResume() throws NullPointerException
  {
    RecruiterJob recruiterJob = new RecruiterJob(recruiter, new JReqJob("Software"));
    jobseeker.apply(recruiterJob, jobApplicationManager);
  }

  @Test
  public void multipleJobsAppliedByJobseeker() throws NullPointerException
  {
    applyATSJOb();
    applyJReqJob();
    JobApplications applications = jobseeker.viewAppliedJobs(jobApplicationManager);
    applications.display();
    assertTrue(jobApplications.containsAll(applications));
  }

  public void setUpResumeRepo()
  {
    resumeRepository = new ResumeRepository();
  }

  public void setUpJobApplications()
  {
    jobApplications = new JobApplications();
  }

  public void setUpJobApplicationManager()
  {
    jobApplicationManager = new JobApplicationManager(jobApplications, new Applier(resumeRepository));
  }

  public void setUpJobseeker() throws NullPointerException
  {
    jobseeker = new Jobseeker("Tom");
  }

  public void setUpRecruiter() throws NullPointerException
  {
    recruiter = new Recruiter("Ladders");
  }

  public JobApplication applyATSJOb() throws NullPointerException
  {
    RecruiterJob recruiterJob = new RecruiterJob(recruiter, new ATSJob("Software"));
    return jobseeker.apply(recruiterJob, jobApplicationManager);
  }

  public JobApplication applyJReqJob() throws NullPointerException
  {
    RecruiterJob recruiterJob = new RecruiterJob(recruiter, new JReqJob("Software"));
    resumeRepository.add(jobseeker, new Resume("My Resume"));
    return jobseeker.apply(recruiterJob, jobApplicationManager);
  }
}
