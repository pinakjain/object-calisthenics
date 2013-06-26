package test;

import static org.junit.Assert.*;

import java.util.Date;

import main.jobs.ATSJob;
import main.jobApplication.JobApplicationFactory;
import main.jobApplication.JobApplication;
import main.jobApplication.JobApplicationManager;
import main.jobApplication.JobApplications;
import main.jobseeker.Jobseeker;
import main.jobseeker.Jobseekers;
import main.recruiter.Recruiter;
import main.jobs.RecruiterJob;
import main.resume.Resume;
import main.resume.ResumeRepository;
import main.utils.DateUtils;

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

  @Before
  public void setUp()
  {
    setUpRecruiter();
    setUpJobseeker();
    setUpResumeRepo();
    setUpATSJob();
    setUpFactory();
    setUpJobApplication();
    setUpJobApplications();
    setUpJobApplicationManager();
  }

  private void setUpFactory()
  {
    factory = new JobApplicationFactory(resumeRepository, DateUtils.createDate());
  }

  @Test
  public void jobseekersWhoHaveAppliedToRecruiterJob()
  {
    jobApplications.add(application2);
    Jobseekers applicants = recruiter.applicantsByJob(recruiterJob, jobApplicationManager);
    Jobseekers jobseekers = new Jobseekers();
    jobseekers.add(jobseeker1);
    jobseekers.add(jobseeker2);
    assertEquals(2, applicants.size());
    assertTrue(applicants.contains(jobseeker1));
    assertTrue(applicants.contains(jobseeker2));
    assertTrue(applicants.equals(jobseekers));
  }

  @Test
  public void jobseekersWhoHaveAppliedOnAGivenDate()
  {
    Date date = DateUtils.createDate();
    Jobseekers applicants = recruiter.applicantsByDate(date, jobApplicationManager);
    assertEquals(1, applicants.size());
    assertTrue(applicants.contains(jobseeker1));
  }

  @Test
  public void jobseekersWhoHaveAppliedForARecruiterJobOnAGivenDate()
  {
    Jobseekers applicants = recruiter.applicantsByJobAndByDate(recruiterJob,
                                                               DateUtils.createDate(),
                                                               jobApplicationManager);
    assertEquals(1, applicants.size());
    assertTrue(applicants.contains(jobseeker1));
  }

  private void setUpJobApplications()
  {
    jobApplications = new JobApplications();
    jobApplications.add(application1);
  }

  private void setUpJobApplication()
  {
    application1 = factory.createApplication(jobseeker1, recruiterJob);
    application2 = factory.createApplication(jobseeker2, recruiterJob);
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
