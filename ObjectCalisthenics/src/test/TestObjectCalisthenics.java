package test;

import static org.junit.Assert.*;

import main.ATSJob;
import main.Applier;
import main.JReqJob;
import main.Job;
import main.JobApplicationManager;
import main.JobApplications;
import main.Jobs;
import main.JobsManager;
import main.Jobseeker;
import main.Jobseekers;
import main.Recruiter;
import main.RecruiterJob;
import main.Recruiters;
import main.ResumeRepository;

import org.junit.Before;
import org.junit.Test;

public class TestObjectCalisthenics {
	
	private Recruiters recruiters;
	private Jobs jobs; 
	private JobsManager jobsManager;
	private Jobseekers jobseekers;
	private JobApplications jobApplications;
	private ResumeRepository resumeRepository;

	@Before
	public void setUp() throws NullPointerException {
		setUpRecruiters();
		setUpJobs();
		setUpJobsManager();
		setUpJobSeekers();
		setUpJobApplications();
		setUpResumeRepository();
	}

	@Test
	public void displayRecruiters() {	
		recruiters.display();
	}
	
	@Test
	public void postJobs() throws NullPointerException {	
		Recruiter recruiter1 = new Recruiter("Chase1");
		recruiter1.postJob(new ATSJob("Software Engineer1"), jobsManager);
		Recruiter recruiter2 = new Recruiter("Ladders1");
		recruiter2.postJob(new JReqJob("Software Engineer1"), jobsManager);
		displayJobs();
	}
	
	@Test
	public void jobsPostedByRecruiters() throws NullPointerException {	
		Recruiter recruiter = new Recruiter("Chase");
		jobsManager.jobsPostedBy(recruiter);
	}
	
	@Test
	public void displayJobs() {	
		jobs.display();
	}
	
	@Test
	public void displayJobseekers() {	
		jobseekers.display();
	}
	
	@Test
	public void applyToJob() throws NullPointerException {	
		Jobseeker jobseeker = new Jobseeker("Tom");
		RecruiterJob job1 = new RecruiterJob(new Recruiter("Chase"),  new ATSJob("Software Engineer"));
		jobs.add(job1);
		JobApplicationManager applicationManager = new JobApplicationManager(jobApplications, new Applier(resumeRepository));
		jobseeker.apply(job1, applicationManager);
		viewAppliedJobs();
//		displayJobApplications();
	}
	
	@Test
	public void viewAppliedJobs() throws NullPointerException {	
		Jobseeker jobseeker = new Jobseeker("Tom");
		JobApplicationManager applicationManager = new JobApplicationManager(jobApplications, new Applier(resumeRepository));
		jobseeker.viewAppliedJobs(applicationManager).display();
	}
	
	@Test
	public void displayJobApplications() {	
		jobApplications.display();
	}
	
	
	public void setUpRecruiters() throws NullPointerException {	
		recruiters = new Recruiters();
		recruiters.add(new Recruiter("Chase"));
		recruiters.add(new Recruiter("Ladders"));
	}
	
	public void setUpJobs() throws NullPointerException{
		jobs = new Jobs();
		RecruiterJob job2 = new RecruiterJob(new Recruiter("ladders"),  new JReqJob("Software Engineer"));
		jobs.add(job2);
	}
	
	public void setUpJobsManager(){
		jobsManager = new JobsManager(jobs);
	}
	
	public void setUpJobSeekers() throws NullPointerException{
		jobseekers = new Jobseekers();
		jobseekers.add(new Jobseeker("Mike"));
		jobseekers.add(new Jobseeker("Paul"));
	}
	
	public void setUpJobApplications(){
		jobApplications =  new JobApplications();
	}
	
	public void setUpResumeRepository(){
		resumeRepository = new ResumeRepository();
	}
	

}
