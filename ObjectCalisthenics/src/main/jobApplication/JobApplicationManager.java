package main.jobApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.jobs.RecruiterJob;
import main.jobseeker.Jobseeker;
import main.jobseeker.Jobseekers;

public class JobApplicationManager
{

  private final JobApplications jobApplications;

  public JobApplicationManager(JobApplications jobApplications)
  {
    if (jobApplications == null)
      throw new IllegalArgumentException("Job applications cannot be null");
    this.jobApplications = jobApplications;
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

  private static void addJobseekerIfAppliedFor(RecruiterJob recruiterJob,
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

  private static void addJobseekerIfAppliedOn(Date date,
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

  private static void addJobseekerIfAppliedForAJobOnAGivenDate(RecruiterJob recruiterJob,
                                                               Date date,
                                                               List<Jobseeker> jobseekers,
                                                               JobApplication application)
  {
    if (application.wasAppliedFor(recruiterJob) && application.wasAppliedOn(date))
    {
      jobseekers.add(application.applicant());
    }
  }

}
