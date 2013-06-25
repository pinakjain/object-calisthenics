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
  private JobApplication        application;
  private Jobseeker             jobseeker;
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
    factory = new JobApplicationFactory(resumeRepository);
  }

  @Test
  public void jobseekersForApplicationToRecruiterJob()
  {
    Jobseekers jobseekers = recruiter.applicantsByJob(recruiterJob, jobApplicationManager);
    jobseekers.display();
    for (Jobseeker applicant : jobseekers)
    {
      assertTrue(application.wasSubmittedBy(applicant));
    }
  }

  @Test
  public void jobseekersForApplicationsByDate()
  {
    Date date = DateUtils.createDate();
    Jobseekers jobseekers = recruiter.applicantsByDate(date, jobApplicationManager);
    jobseekers.display();
    for (Jobseeker applicant : jobseekers)
    {
      assertTrue(application.wasSubmittedBy(applicant));
      assertTrue(application.isAppliedOn(date));
      // TO-DO implement for a different date
      // assertFalse(application.isAppliedOn(date));
    }
  }

  @Test
  public void jobseekersForApplicationsByJobAndByDate()
  {
    Jobseekers jobseekers = recruiter.applicantsByJobAndByDate(recruiterJob,
                                                               DateUtils.createDate(),
                                                               jobApplicationManager);
    jobseekers.display();
    for (Jobseeker applicant : jobseekers)
    {
      assertTrue(application.wasSubmittedBy(applicant));
    }
  }

  private void setUpJobApplications()
  {
    jobApplications = new JobApplications();
    jobApplications.add(application);
  }

  private void setUpJobApplication()
  {
    application = factory.createApplication(jobseeker, recruiterJob);
  }

  private void setUpJobseeker()
  {
    jobseeker = new Jobseeker("Tom");
  }

  private void setUpRecruiter()
  {
    recruiter = new Recruiter("Ladders");
  }

  private void setUpResumeRepo()
  {
    resumeRepository = new ResumeRepository();
    resumeRepository.add(jobseeker, new Resume("Resume"));
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
