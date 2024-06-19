public class Job{
    static int incrementer = 1;
    int Job_Id;
    String title;
    String Description;
    String Location;
    String Job_Type;
    double salary;
    // ArrayList<String> requirements = new ArrayList<>();

    public Job(String title, String Description, String Location, String Job_Type, double salary ){
        this.title = title;
        this.Description = Description;
        this.Location = Location;
        this.Job_Type = Job_Type;
        this.salary = salary;
        // this.requirements = requiremets;
        Job.incrementer = incrementer+1;
        this.Job_Id = incrementer;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return Description;
    }
    public String getLocation(){
        return Location;
    }
    public String getJob_Type(){
        return Job_Type;
    }
    public double getSalary(){
        return salary;
    }
    // public ArrayList<String> getRequirements(){
    //     return requirements;
    // }


    public void setDescription(String Description){
        this.Description = Description;
    }
    public void setLocation(String Location){
        this.Location = Location;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }


}