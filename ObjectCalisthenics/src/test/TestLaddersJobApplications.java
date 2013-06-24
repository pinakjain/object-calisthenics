package test;

import static org.junit.Assert.*;

import main.jobApplication.JobApplicationFactory;
import main.jobApplication.JobApplicationManager;
import main.jobApplication.JobApplications;
import main.jobs.ATSJob;
import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.recruiter.Recruiter;
import main.resume.Resume;
import main.resume.ResumeRepository;

import org.junit.Before;
import org.junit.Test;

public class TestLaddersJobApplications
{
  private Recruiter             recruiter;
  private JobApplications       jobApplications;
  private JobApplicationManager jobApplicationManager;
  private ResumeRepository      resumeRepository;
  private RecruiterJob          recruiterJob;
  private Jobseeker             jobseeker1;
  private Jobseeker             jobseeker2;
  private JobApplicationFactory               applier;

  @Before
  public void setUp()
  {
    setUpRecruiter();
    setUpJobseeker();
    setUpResumeRepo();
    setUpATSJob();
    setUpApplier();
    setUpJobApplications();
    setUpJobApplicationManager();
  }

  private void setUpApplier()
  {
    applier = new JobApplicationFactory(resumeRepository);
  }

  @Test
  public void numberOfApplicationsForRecruiterJob()
  {
    assertEquals(2, jobApplicationManager.numberOfApplicationForJob(recruiterJob));
  }

  @Test
  public void numberOfApplicationsForRecruiter()
  {
    assertEquals(2, jobApplicationManager.numberOfApplicationForRecruiter(recruiter));
  }

  private void setUpJobApplications()
  {
    jobApplications = new JobApplications();
    jobApplications.add(applier.createApplication(jobseeker1, recruiterJob));
    jobApplications.add(applier.createApplication(jobseeker2, recruiterJob));
  }

  private void setUpJobseeker()
  {
    jobseeker1 = new Jobseeker("Tom 1");
    jobseeker2 = new Jobseeker("Tom 2");
  }

  private void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  private void setUpResumeRepo()
  {
    resumeRepository = new ResumeRepository();
    resumeRepository.add(jobseeker1, new Resume("Resume 1"));
    resumeRepository.add(jobseeker2, new Resume("Resume 2"));
  }

  private void setUpJobApplicationManager()
  {
    jobApplicationManager = new JobApplicationManager(jobApplications, new JobApplicationFactory(resumeRepository));
  }

  private void setUpATSJob()
  {
    recruiterJob = new RecruiterJob(recruiter, new ATSJob("Software"));
  }

}