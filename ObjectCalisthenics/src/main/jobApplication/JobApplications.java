package main.jobApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.jobseeker.Jobseeker;

public class JobApplications implements Iterable<JobApplication>
{

  private final List<JobApplication> jobApplications;

  public JobApplications()
  {
    this.jobApplications = new ArrayList<>();
  }

  public JobApplications(List<JobApplication> applications)
  {
    if(applications == null) throw new IllegalArgumentException("Applications cannot be null");
    this.jobApplications = applications;
  }

  public JobApplication add(JobApplication jobApplication) throws IllegalArgumentException
  {
    if (jobApplication == null)
      throw new IllegalArgumentException("Job application cannot be null");
    jobApplications.add(jobApplication);
    return jobApplication;
  }

  public JobApplications jobsAppliedBy(Jobseeker jobseeker)
  {
    List<JobApplication> applicationsByJobseeker = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addApplicationIfAppliedBy(jobseeker, applicationsByJobseeker, application);
    }
    return new JobApplications(applicationsByJobseeker);
  }

  private void addApplicationIfAppliedBy(Jobseeker jobseeker,
                                        List<JobApplication> applicationsByJobseeker,
                                        JobApplication application)
  {
    if (application.wasSubmittedBy(jobseeker))
    {
      applicationsByJobseeker.add(application);
    }
  }

  public void display()
  {
    for (JobApplication application : jobApplications)
    {
      application.display();
    }
  }

  public int size()
  {
    return jobApplications.size();
  }

  @Override
  public Iterator<JobApplication> iterator()
  {
    Iterator<JobApplication> iter = jobApplications.iterator();
    return iter;
  }

  public boolean contains(JobApplication jobApplication)
  {
    return jobApplications.contains(jobApplication);
  }

  public boolean containsAll(JobApplications applications)
  {
    for (JobApplication application : applications)
    {
      if (!jobApplications.contains(application))
        return false;
    }
    return true;
  }
}
