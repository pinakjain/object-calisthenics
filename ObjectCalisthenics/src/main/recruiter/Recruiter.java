package main.recruiter;

import java.util.Date;

import main.jobApplication.JobApplicationManager;
import main.jobs.Job;
import main.jobs.Jobs;
import main.jobs.JobsManager;
import main.jobs.RecruiterJob;
import main.jobseeker.Jobseekers;

public class Recruiter
{

  private final RecruiterName name;
  private final RecruiterId   id;

  public Recruiter(String name)
  {
    this.name = new RecruiterName(name);
    this.id = RecruiterId.createRecruiterId();
  }

  public void display()
  {
    System.out.println("Recruiter :- " + name + " (ID = " + id + ")");
  }

  public RecruiterJob postJob(Job job,
                              JobsManager manager) throws IllegalArgumentException
  {
    RecruiterJob myJob = new RecruiterJob(this, job);
    return manager.postjob(myJob);
  }

  public Jobs myJobs(JobsManager jobsManager)
  {
    return jobsManager.jobsPostedBy(this);
  }

  public Jobseekers applicantsByJob(RecruiterJob recruiterJob,
                                    JobApplicationManager jobApplicationManager)
  {
    return jobApplicationManager.applicationsFor(recruiterJob);
  }

  public Jobseekers applicantsByDate(Date date,
                                     JobApplicationManager jobApplicationManager)
  {
    return jobApplicationManager.applicationsFor(date);
  }

  public Jobseekers applicantsByJobAndByDate(RecruiterJob recruiterJob,
                                             Date date,
                                             JobApplicationManager jobApplicationManager)
  {
    return jobApplicationManager.applicationsFor(recruiterJob, date);
  }

  @Override
  public int hashCode()
  {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (!(obj instanceof Recruiter))
      return false;
    Recruiter other = (Recruiter) obj;
    return id.equals(other.id);
  }

  @Override
  public String toString()
  {
    return "Recruiter :- " + name;
  }
}
