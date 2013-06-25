package test;

import static org.junit.Assert.*;

import main.jobs.ATSJob;
import main.jobApplication.JobApplicationFactory;
import main.jobs.JReqJob;
import main.jobApplication.JobApplication;
import main.jobApplication.JobApplicationManager;
import main.jobApplication.JobApplications;
import main.jobseeker.Jobseeker;
import main.recruiter.Recruiter;
import main.jobs.RecruiterJob;
import main.resume.Resume;
import main.resume.ResumeRepository;

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
  public void setUp()
  {
    setUpJobseeker();
    setUpResumeRepo();
    setUpJobApplications();
    setUpJobApplicationManager();
    setUpRecruiter();

  }

  @Test(expected = IllegalArgumentException.class)
  public void applyToANullJob()
  {
    jobseeker.apply(null, jobApplicationManager);
  }

  @Test
  public void applyATSJob()
  {
    JobApplication application = applyATSJOb();
    assertTrue(jobApplications.contains(application));
  }

  @Test
  public void applyJreqJobUsingResume()
  {
    JobApplication application = applyJReqJob();
    assertTrue(jobApplications.contains(application));
  }

  @Test(expected = IllegalArgumentException.class)
  public void applyJreqJobWithoutUsingResume()
  {
    RecruiterJob recruiterJob = new RecruiterJob(recruiter, new JReqJob("Software"));
    jobseeker.apply(recruiterJob, jobApplicationManager);
  }

  @Test
  public void applyToMultipleJobs()
  {
    applyATSJOb();
    applyJReqJob();
    JobApplications applications = jobseeker.viewAppliedJobs(jobApplicationManager);
    applications.display();
    assertTrue(jobApplications.containsAll(applications));
  }

  private void setUpResumeRepo()
  {
    resumeRepository = new ResumeRepository();
  }

  private void setUpJobApplications()
  {
    jobApplications = new JobApplications();
  }

  private void setUpJobApplicationManager()
  {
    jobApplicationManager = new JobApplicationManager(jobApplications, new JobApplicationFactory(resumeRepository));
  }

  private void setUpJobseeker()
  {
    jobseeker = new Jobseeker("Tom");
  }

  private void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  private JobApplication applyATSJOb()
  {
    RecruiterJob recruiterJob = new RecruiterJob(recruiter, new ATSJob("Software"));
    return jobseeker.apply(recruiterJob, jobApplicationManager);
  }

  private JobApplication applyJReqJob()
  {
    RecruiterJob recruiterJob = new RecruiterJob(recruiter, new JReqJob("Software"));
    resumeRepository.add(jobseeker, new Resume("My Resume"));
    return jobseeker.apply(recruiterJob, jobApplicationManager);
  }
}
