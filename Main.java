import java.util.*;

public class Main {
    static ArrayList<User> user_list = new ArrayList<>();
    static ArrayList<Job> job_list = new ArrayList<>();
    static ArrayList<Applicant> applicant_list = new ArrayList<>();
    static ArrayList<HiringManager> hiringManager_Posts = new ArrayList<>();


    public static void addUser(String name, String password){
        User member = new User(name, password);
        user_list.add(member); 
    }

    public static boolean checkLogin(String name, String password){
        return true;
    }

    public static void postJob(String title, String Description, String Location, String Job_Type, double salary, int User_Id){
        Job newJob = new Job(title,Description,Location,Job_Type,salary);
        int Job_Id = newJob.Job_Id;
        job_list.add(newJob); 
        HiringManager x = new HiringManager(User_Id, Job_Id); 
        hiringManager_Posts.add(x);
    }

    public static void applyJob(int Job_Id, int User_Id){
        Applicant newApplicant = new Applicant(User_Id, Job_Id);
        applicant_list.add(newApplicant);

    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("click 0 to login , 1 to register");
            int login = sc.nextInt();
            User member = new User("user1","pass");
            user_list.add(member);

            switch (login) {

                case 0:
                System.out.println("enter the details");
                System.out.println("enter the name");
                String name1 = sc.next();
                System.out.println("enter the password");
                String password1 = sc.next();
                //User member = new User(name1, password1);
                if(checkLogin(name1,password1)){
                    System.out.println("Login successful");
                }else{
                    System.out.println("login failed");
                }    
                break;

                case 1:    
                    System.out.println("enter the details");
                    System.out.println("enter the name");
                    String name = sc.next();
                    System.out.println("enter the password");
                    String password = sc.next();
                    addUser(name,password);
                    System.out.println("Registration successful");
                    break;
            
                default:
                    System.out.println("Enter a valid number");
                    break;
            }



            while(true){

            System.out.println("Want to search job (enter 0 ) or post job (enter 1) or view applicants (enter 2) or anyother to logout");

            int searchOrPost = sc.nextInt();

            if(searchOrPost == 0){

                System.out.println("List of jobs");
                for(Job i : job_list){
                    System.out.println("Job Id :"+i.Job_Id);
                    System.out.println("Job title :"+i.title);
                    System.out.println("Job Description :"+i.Description);
                    System.out.println("Job Location :"+i.Location);
                    System.out.println("Job Type :"+i.Job_Type);
                    System.out.println("salary :"+i.salary);
                    System.out.println("======================");
                    System.out.println();
                }

                System.out.println("Enter the job id you want to apply");
                int Job_Id = sc.nextInt();
                for(Job i : job_list){
                    if(i.Job_Id == Job_Id){
                        System.out.println("Successfully Applied");
                        applyJob(i.Job_Id,member.User_Id);
                    }
                }



            }else if(searchOrPost == 1){
                System.out.println("enter the job details");
                System.out.println("enter the job title");
                String title = sc.next();
                System.out.println("enter the job description");
                String Description = sc.next();
                System.out.println("enter the job location");
                String Location = sc.next();
                System.out.println("enter the job type");
                String Job_Type = sc.next();
                System.out.println("enter the job salary");
                double salary = sc.nextDouble();

                postJob(title,Description,Location,Job_Type,salary,member.User_Id);



            }
            else if(searchOrPost == 2){

                ArrayList<Job> user_listed_jobs = new ArrayList<>();
                for(HiringManager i : hiringManager_Posts){
                    if(i.User_Id == member.User_Id){
                        for(Job j : job_list){
                            if(i.Job_Id == j.Job_Id){
                                user_listed_jobs.add(j);
                            }
                        }
                    }
                }
                for(Job i : user_listed_jobs){
                    System.out.println("Job name : "+i.title);
                    System.out.println("=================");
                    System.out.println("List of applicants");
                    for(Applicant j : applicant_list){
                        if(j.Job_Id == i.Job_Id){
                            for(User k : user_list){
                                if(j.User_Id == k.User_Id){
                                    System.out.println("Name:" + k.name);
                                }
                            }
                        }
                    }
                }


            }
            else{
                break;
            }

            }




        }

    }
}
