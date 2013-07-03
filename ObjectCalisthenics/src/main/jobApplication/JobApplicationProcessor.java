package main.jobApplication;

import java.util.ArrayList;
import java.util.List;

import main.jobs.RecruiterJob;
import main.recruiter.Recruiter;

public class JobApplicationProcessor
{
  private final JobApplications jobApplications;

  public JobApplicationProcessor(JobApplications jobApplications)
  {
    if (jobApplications == null)
      throw new IllegalArgumentException("Job applications cannot be null");
    this.jobApplications = jobApplications;
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

  private static void addApplicationIfPostedBy(Recruiter recruiter,
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

  private static void addApplicationIfAppliedFor(RecruiterJob recruiterJob,
                                                 List<JobApplication> applications,
                                                 JobApplication application)
  {
    if (application.wasAppliedFor(recruiterJob))
    {
      applications.add(application);
    }
  }
}
