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
    RecruiterId other = (RecruiterId) obj;
    if (id != other.id)
      return false;
    return true;
  }

}
