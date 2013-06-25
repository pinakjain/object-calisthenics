package main.recruiter;

public class RecruiterId
{
  private int id;

  public RecruiterId(int id)
  {
    this.id = id;
  }

  @Override
  public int hashCode()
  {
    return 31 + id;
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
    RecruiterId other = (RecruiterId) obj;
    return id == other.id;
  }

}
