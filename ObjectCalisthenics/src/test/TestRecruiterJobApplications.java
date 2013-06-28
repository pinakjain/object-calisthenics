package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import main.jobApplication.JobApplication;
import main.jobApplication.JobApplicationFactory;
import main.jobApplication.JobApplicationManager;
import main.jobApplication.JobApplications;
import main.jobs.ATSJob;
import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.jobseeker.Jobseekers;
import main.recruiter.Recruiter;
import main.resume.Resume;
import main.resume.ResumeRepository;
import main.utils.DateUtils;
import main.utils.TestApplicationDateGenerator;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiterJobApplications
{

  private Recruiter             recruiter;
  private JobApplications       jobApplications;
  private JobApplicationManager jobApplicationManager;
  private ResumeRepository      resumeRepository;
  private RecruiterJob          recruiterJob;
  private JobApplication        application1;
  private JobApplication        application2;
  private Jobseeker             jobseeker1;
  private Jobseeker             jobseeker2;
  private JobApplicationFactory factory;
  private JobApplicationFactory factoryWithYesterdayDate;

  @Before
  public void setUp()
  {
    setUpRecruiter();
    setUpJobseeker();
    setUpResumeRepo();
    setUpATSJob();
    setUpFactory();
    setUpFactoryWithYesterdayDate();
    setUpJobApplication();
    setUpJobApplications();
    setUpJobApplicationManager();
  }

  private void setUpFactory()
  {
    factory = new JobApplicationFactory(resumeRepository, new TestApplicationDateGenerator(DateUtils.currentDate()));
  }

  private void setUpFactoryWithYesterdayDate()
  {
    factoryWithYesterdayDate = new JobApplicationFactory(resumeRepository, new TestApplicationDateGenerator(DateUtils.yesterdayDate()));
  }

  @Test
  public void jobseekersWhoHaveAppliedToRecruiterJob()
  {
    jobApplications.add(application2);
    Jobseekers applicants = recruiter.applicantsByJob(recruiterJob, jobApplicationManager);
    Jobseekers jobseekers = new Jobseekers();
    jobseekers.add(jobseeker1);
    jobseekers.add(jobseeker2);
    assertEquals(jobseekers, applicants);
  }

  @Test
  public void jobseekersWhoHaveAppliedOnAToday()
  {
    Date yesterday = DateUtils.yesterdayDate();
    Jobseekers applicants = recruiter.applicantsByDate(DateUtils.currentDate(), jobApplicationManager);
    assertEquals(1, applicants.size());
    assertTrue(applicants.contains(jobseeker1));
    assertFalse(application1.wasAppliedOn(yesterday));
  }

  @Test
  public void jobseekersWhoHaveAppliedOnAGivenDate()
  {
    Date yesterday = DateUtils.yesterdayDate();
    jobApplications.add(application2);
    Jobseekers applicants = recruiter.applicantsByDate(yesterday, jobApplicationManager);
    assertEquals(1, applicants.size());
    assertTrue(applicants.contains(jobseeker2));
    assertFalse(application2.wasAppliedOn(DateUtils.currentDate()));
  }

  @Test
  public void jobseekersWhoHaveAppliedForARecruiterJobOnAGivenDate()
  {
    Jobseekers applicants = recruiter.applicantsByJobAndByDate(recruiterJob,
                                                               DateUtils.currentDate(),
                                                               jobApplicationManager);
    Jobseekers jobseekers = new Jobseekers();
    jobseekers.add(jobseeker1);
    assertEquals(jobseekers, applicants);
  }

  private void setUpJobApplications()
  {
    jobApplications = new JobApplications();
    jobApplications.add(application1);
  }

  private void setUpJobApplication()
  {
    application1 = factory.createApplication(jobseeker1, recruiterJob);
    application2 = factoryWithYesterdayDate.createApplication(jobseeker2, recruiterJob);
  }

  private void setUpJobseeker()
  {
    jobseeker1 = new Jobseeker("Tom");
    jobseeker2 = new Jobseeker("Joe");
  }

  private void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  private void setUpResumeRepo()
  {
    resumeRepository = new ResumeRepository();
    resumeRepository.add(jobseeker1, new Resume("Resume"));
    resumeRepository.add(jobseeker2, new Resume("Resume"));
  }

  private void setUpJobApplicationManager()
  {
    jobApplicationManager = new JobApplicationManager(jobApplications, factory);
  }

  private void setUpATSJob()
  {
    recruiterJob = new RecruiterJob(recruiter, new ATSJob("Software"));
  }

}
