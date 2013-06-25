package test;

import static org.junit.Assert.*;

import main.jobApplication.JobApplicationFactory;
import main.jobApplication.JobApplication;
import main.jobApplication.JobApplications;
import main.jobs.ATSJob;
import main.jobs.JReqJob;
import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.recruiter.Recruiter;
import main.resume.Resume;
import main.resume.ResumeRepository;

import org.junit.Before;
import org.junit.Test;

public class TestJobApplications
{

  private JobApplications  jobApplications;
  private Jobseeker        jobseeker;
  private Recruiter        recruiter;
  private Resume           resume;
  private JobApplicationFactory          factory;
  private ResumeRepository resumeRepository;

  @Before
  public void setUp()
  {
    setUpRecruiter();
    setUpJobseeker();
    setUpResume();
    setUpResumeRepo();
    setUpFactory();
    setUpJobApplications();
  }

  @Test
  public void testEmptyJobApplications()
  {
    assertEquals(0, jobApplications.size());
  }

  @Test
  public void addATSJobApplication()
  {
    JobApplication jobApplication = factory.createApplication(jobseeker, setUpATSJob());
    jobApplications.add(jobApplication);
    assertTrue(jobApplications.contains(jobApplication));
  }

  @Test
  public void addJReqJobApplication()
  {
    JobApplication jobApplication = factory.createApplication(jobseeker, setUpJReqJob());
    jobApplications.add(jobApplication);
    assertTrue(jobApplications.contains(jobApplication));
  }

  @Test
  public void addTwoJobApplications()
  {
    JobApplication jobApplication1 = factory.createApplication(jobseeker, setUpATSJob());
    JobApplication jobApplication2 = factory.createApplication(jobseeker, setUpJReqJob());
    jobApplications.add(jobApplication1);
    jobApplications.add(jobApplication2);
    jobApplications.display();
    assertTrue(jobApplications.contains(jobApplication1));
    assertTrue(jobApplications.contains(jobApplication2));
  }

  private void setUpJobApplications()
  {
    jobApplications = new JobApplications();
  }

  private void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  private void setUpJobseeker()
  {
    jobseeker = new Jobseeker("Tom");
  }

  private void setUpResume()
  {
    resume = new Resume("Resume");
  }

  private void setUpFactory()
  {
    factory = new JobApplicationFactory(resumeRepository);
  }

  private void setUpResumeRepo()
  {
    resumeRepository = new ResumeRepository();
    resumeRepository.add(jobseeker, resume);
  }

  private RecruiterJob setUpATSJob()
  {
    return new RecruiterJob(recruiter, new ATSJob("Software"));
  }

  private RecruiterJob setUpJReqJob()
  {
    return new RecruiterJob(recruiter, new JReqJob("Software"));
  }
}
