package main;

import java.util.Date;

public class Recruiter
{

  private final String name;
  private final int    id;

  public Recruiter(String name) throws IllegalArgumentException
  {
    if (name == null || name.equals(""))
      throw new IllegalArgumentException("Name cannot be empty or null");
    this.name = name;
    this.id = IdGenerator.createId();
  }

  public void display()
  {
    System.out.println("Recruiter :- " + name + " (ID = " + id + ")");
  }

  public RecruiterJob postJob(Job job,
                              JobsManager manager) throws NullPointerException
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
    return jobApplicationManager.applications(recruiterJob);
  }

  public Jobseekers applicantsByDate(Date date,
                                     JobApplicationManager jobApplicationManager)
  {
    return jobApplicationManager.applications(date);
  }

  public Jobseekers applicantsByJobAndByDate(RecruiterJob recruiterJob,
                                             Date date,
                                             JobApplicationManager jobApplicationManager)
  {
    return jobApplicationManager.applications(recruiterJob, date);
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Recruiter other = (Recruiter) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "Recruiter :- " + name;
  }
}
