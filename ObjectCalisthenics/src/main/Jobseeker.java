package main;

public class Jobseeker
{

  private final String name;
  private final int    id;

  public Jobseeker(String name) throws IllegalArgumentException
  {
    if (name == null || name.equals(""))
      throw new IllegalArgumentException("Jobseeker name cannot be null or empty");
    this.name = name;
    this.id = IdGenerator.createId();
  }

  public RecruiterJob save(RecruiterJob recruiterJob,
                           SavedJobsManager savedJobsManager) throws NullPointerException
  {
    // TODO Auto-generated method stub
    return savedJobsManager.save(this, recruiterJob);
  }

  public Jobs viewSavedJobs(SavedJobsManager savedJobsManager)
  {
    return savedJobsManager.jobsSavedBy(this);
  }

  public JobApplication apply(RecruiterJob job,
                              JobApplicationManager applicationManager) throws NullPointerException
  {
    return applicationManager.apply(this, job);
  }

  public JobApplications viewAppliedJobs(JobApplicationManager applicationManager)
  {
    return applicationManager.appliedJobs(this);
  }

  public void display()
  {
    System.out.println("Jobseeker :- " + name + " (ID = " + id + ")");
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
    Jobseeker other = (Jobseeker) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "Jobseeker :- " + name;
  }

}
