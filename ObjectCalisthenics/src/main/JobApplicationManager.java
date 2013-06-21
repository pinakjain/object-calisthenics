package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobApplicationManager
{

  private final JobApplications jobApplications;
  private final Applier         applier;

  public JobApplicationManager(JobApplications jobApplications,
                               Applier applier)
  {
    this.jobApplications = jobApplications;
    this.applier = applier;
  }

  public JobApplication apply(Jobseeker jobseeker,
                              RecruiterJob job) throws NullPointerException
  {
    if (job == null)
      throw new NullPointerException("Job applied to cannot be null");
    if (jobseeker == null)
      throw new NullPointerException("Jobseeker cannot be null");
    return submitJobApplication(applier.createApplication(jobseeker, job));
  }

  public JobApplication submitJobApplication(JobApplication jobApplication)
  {
    return jobApplications.add(jobApplication);
  }

  public JobApplications appliedJobs(Jobseeker jobseeker)
  {
    return jobApplications.jobsAppliedBy(jobseeker);
  }

  public Jobseekers applications(RecruiterJob recruiterJob)
  {
    // TODO Auto-generated method stub
    List<Jobseeker> jobseekers = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addJobseekerIfAppliedFor(recruiterJob, jobseekers, application);
    }
    return new Jobseekers(jobseekers);
  }

  public void addJobseekerIfAppliedFor(RecruiterJob recruiterJob,
                                       List<Jobseeker> jobseekers,
                                       JobApplication application)
  {
    if (application.isAppliedFor(recruiterJob))
    {
      jobseekers.add(application.applier());
    }
  }

  public Jobseekers applications(Date date)
  {
    // TODO Auto-generated method stub
    List<Jobseeker> jobseekers = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addJobseekerIfAppliedOn(date, jobseekers, application);
    }
    return new Jobseekers(jobseekers);
  }

  public void addJobseekerIfAppliedOn(Date date,
                                        List<Jobseeker> jobseekers,
                                        JobApplication application)
  {
    if (application.isAppliedOn(date))
    {
      jobseekers.add(application.applier());
    }
  }

  public Jobseekers applications(RecruiterJob recruiterJob,
                                 Date date)
  {
    // TODO Auto-generated method stub
    List<Jobseeker> jobseekers = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addJobseekerIfAppliedForAJobOnAGivenDate(recruiterJob, date, jobseekers, application);
    }
    return new Jobseekers(jobseekers);
  }

  public void addJobseekerIfAppliedForAJobOnAGivenDate(RecruiterJob recruiterJob,
                                                       Date date,
                                                       List<Jobseeker> jobseekers,
                                                       JobApplication application)
  {
    if (application.isAppliedFor(recruiterJob) && application.isAppliedOn(date))
    {
      jobseekers.add(application.applier());
    }
  }

  public int numberOfApplicationForRecruiter(Recruiter recruiter)
  {
    List<JobApplication> applications = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addApplicationIfPostedBy(recruiter, applications, application);
    }
    return applications.size();
  }

  public void addApplicationIfPostedBy(Recruiter recruiter,
                                       List<JobApplication> applications,
                                       JobApplication application)
  {
    if (application.isPostedBy(recruiter))
    {
      applications.add(application);
    }
  }

  public int numberOfApplicationForJob(RecruiterJob recruiterJob)
  {
    List<JobApplication> applications = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addApplicationIfAppliedFor(recruiterJob, applications, application);
    }
    return applications.size();
  }

  public void addApplicationIfAppliedFor(RecruiterJob recruiterJob,
                                         List<JobApplication> applications,
                                         JobApplication application)
  {
    if (application.isAppliedFor(recruiterJob))
    {
      applications.add(application);
    }
  }  
}
