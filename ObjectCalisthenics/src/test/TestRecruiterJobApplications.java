package test;

import static org.junit.Assert.*;

import java.util.Date;

import main.ATSJob;
import main.Applier;
import main.JobApplication;
import main.JobApplicationManager;
import main.JobApplications;
import main.Jobseeker;
import main.Jobseekers;
import main.Recruiter;
import main.RecruiterJob;
import main.ResumeRepository;

import org.junit.Before;
import org.junit.Test;

public class TestRecruiterJobApplications
{

  private Recruiter             recruiter;
  private JobApplications       jobApplications;
  private JobApplicationManager jobApplicationManager;
  private ResumeRepository      resumeRepository;
  private RecruiterJob          recruiterJob;
  private JobApplication application;
  private Jobseeker jobseeker;

  @Before
  public void setUp() throws NullPointerException
  {
    setUpRecruiter();
    setUpResumeRepo();
    setUpATSJob();
    setUpJobseeker();
    setUpJobApplication();
    setUpJobApplications();
    setUpJobApplicationManager();
  }

  @Test
  public void jobseekersForApplicationsToRecruiterJob() throws NullPointerException
  {
    Jobseekers jobseekers = recruiter.applicantsByJob(recruiterJob, jobApplicationManager);
    jobseekers.display();
    assertTrue(application.isAppliedBy(jobseeker));
  }

  @Test
  public void jobseekersForApplicationsByDate() throws NullPointerException
  {
    Jobseekers jobseekers = recruiter.applicantsByDate(new Date(), jobApplicationManager);
    jobseekers.display();
    assertTrue(application.isAppliedBy(jobseeker));
  }

  @Test
  public void jobseekersForApplicationsByJobAndByDate() throws NullPointerException
  {
    Jobseekers jobseekers = recruiter.applicantsByJobAndByDate(recruiterJob, new Date(), jobApplicationManager);
    jobseekers.display();
    assertTrue(application.isAppliedBy(jobseeker));
  }

  public void setUpJobApplications() throws NullPointerException
  {
    jobApplications = new JobApplications();
    jobApplications.add(application);
  }

  public void setUpJobApplication()
  {
    application = new JobApplication(jobseeker, recruiterJob, null);
  }

  public void setUpJobseeker()
  {
    jobseeker = new Jobseeker("Tom");
  }

  public void setUpRecruiter() throws NullPointerException
  {
    recruiter = new Recruiter("Ladders");
  }

  public void setUpResumeRepo()
  {
    resumeRepository = new ResumeRepository();
  }

  public void setUpJobApplicationManager()
  {
    jobApplicationManager = new JobApplicationManager(jobApplications, new Applier(resumeRepository));
  }

  public void setUpATSJob() throws NullPointerException
  {
    recruiterJob = new RecruiterJob(recruiter, new ATSJob("Software"));
  }

}
