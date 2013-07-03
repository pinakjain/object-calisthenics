package main.jobs;

import main.display.JobDisplayer;

public interface Job
{

  boolean requiresResume();
  
  void display(JobDisplayer displayer);

}
