package main.jobApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.jobseeker.Jobseekers;
import main.recruiter.Recruiter;

public class JobApplicationManager
{

  private final JobApplications       jobApplications;
  private final JobApplicationFactory applicationFactory;

  public JobApplicationManager(JobApplications jobApplications,
                               JobApplicationFactory applicationFactory)
  {
    if (jobApplications == null)
      throw new IllegalArgumentException("Job applications cannot be null");
    if (applicationFactory == null)
      throw new IllegalArgumentException("Application factory cannot be null");
    this.jobApplications = jobApplications;
    this.applicationFactory = applicationFactory;
  }

  public JobApplication apply(Jobseeker jobseeker,
                              RecruiterJob job)
  {
    if (job == null)
      throw new IllegalArgumentException("Job applied to cannot be null");
    if (jobseeker == null)
      throw new IllegalArgumentException("Jobseeker cannot be null");
    return submitJobApplication(applicationFactory.createApplication(jobseeker, job));
  }

  private JobApplication submitJobApplication(JobApplication jobApplication)
  {
    return jobApplications.add(jobApplication);
  }

  public JobApplications appliedJobs(Jobseeker jobseeker)
  {
    return jobApplications.jobsAppliedBy(jobseeker);
  }

  public Jobseekers applicationsFor(RecruiterJob recruiterJob)
  {
    List<Jobseeker> jobseekers = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addJobseekerIfAppliedFor(recruiterJob, jobseekers, application);
    }
    return new Jobseekers(jobseekers);
  }

  private void addJobseekerIfAppliedFor(RecruiterJob recruiterJob,
                                        List<Jobseeker> jobseekers,
                                        JobApplication application)
  {
    if (application.wasAppliedFor(recruiterJob))
    {
      jobseekers.add(application.applicant());
    }
  }

  public Jobseekers applicationsFor(Date date)
  {
    List<Jobseeker> jobseekers = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addJobseekerIfAppliedOn(date, jobseekers, application);
    }
    return new Jobseekers(jobseekers);
  }

  private void addJobseekerIfAppliedOn(Date date,
                                       List<Jobseeker> jobseekers,
                                       JobApplication application)
  {
    if (application.wasAppliedOn(date))
    {
      jobseekers.add(application.applicant());
    }
  }

  public Jobseekers applicationsFor(RecruiterJob recruiterJob,
                                 Date date)
  {
    List<Jobseeker> jobseekers = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addJobseekerIfAppliedForAJobOnAGivenDate(recruiterJob, date, jobseekers, application);
    }
    return new Jobseekers(jobseekers);
  }

  private void addJobseekerIfAppliedForAJobOnAGivenDate(RecruiterJob recruiterJob,
                                                        Date date,
                                                        List<Jobseeker> jobseekers,
                                                        JobApplication application)
  {
    if (application.wasAppliedFor(recruiterJob) && application.wasAppliedOn(date))
    {
      jobseekers.add(application.applicant());
    }
  }

  public int numberOfApplicationsForRecruiter(Recruiter recruiter)
  {
    List<JobApplication> applications = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addApplicationIfPostedBy(recruiter, applications, application);
    }
    return applications.size();
  }

  private void addApplicationIfPostedBy(Recruiter recruiter,
                                        List<JobApplication> applications,
                                        JobApplication application)
  {
    if (application.forJobPostedBy(recruiter))
    {
      applications.add(application);
    }
  }

  public int numberOfApplicationsForJob(RecruiterJob recruiterJob)
  {
    List<JobApplication> applications = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addApplicationIfAppliedFor(recruiterJob, applications, application);
    }
    return applications.size();
  }

  private void addApplicationIfAppliedFor(RecruiterJob recruiterJob,
                                          List<JobApplication> applications,
                                          JobApplication application)
  {
    if (application.wasAppliedFor(recruiterJob))
    {
      applications.add(application);
    }
  }
}
