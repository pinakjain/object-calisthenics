package main.jobs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.display.JobDisplayer;
import main.recruiter.Recruiter;

public class Jobs implements Iterable<RecruiterJob>
{

  private final List<RecruiterJob> jobs;

  public Jobs()
  {
    this.jobs = new ArrayList<>();
  }

  public Jobs(List<RecruiterJob> jobs)
  {
    this.jobs = jobs;
  }

  public RecruiterJob add(RecruiterJob job)
  {
    if (job == null)
      throw new IllegalArgumentException("Job needed to be added cannot be null");
    jobs.add(job);
    return job;
  }

  public void display(JobDisplayer displayer)
  {
    for (RecruiterJob job : jobs)
    {
      job.display(displayer);
    }
  }

  public Jobs jobPostingsBy(Recruiter recruiter)
  {
    List<RecruiterJob> jobPostings = new ArrayList<>();
    for (RecruiterJob job : jobs)
    {
      addJobIfPostedBy(recruiter, jobPostings, job);
    }
    return new Jobs(jobPostings);
  }

  private static void addJobIfPostedBy(Recruiter recruiter,
                                       List<RecruiterJob> jobPostings,
                                       RecruiterJob job)
  {
    if (job.isPostedBy(recruiter))
    {
      jobPostings.add(job);
    }
  }

  public int size()
  {
    return jobs.size();
  }

  @Override
  public Iterator<RecruiterJob> iterator()
  {
    Iterator<RecruiterJob> iter = jobs.iterator();
    return iter;
  }

  public boolean contains(RecruiterJob recruiterJob)
  {
    return jobs.contains(recruiterJob);
  }
}
