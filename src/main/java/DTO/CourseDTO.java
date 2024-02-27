package DTO;

public class CourseDTO 
{
    private int courseID;
    private String title;
    private int credits;
    private int departmentID;
    private String type;
    private String departmentName;
    public CourseDTO()
    {
        // none paremeters
    }
    
    public CourseDTO(int courseID, String title, int credits, int departmentID,String type) 
    {
        this.courseID = courseID;
        this.title = title;
        this.credits = credits;
        this.departmentID = departmentID;
        this.type = type;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCourseID() 
    {
        return courseID;
    }

    public void setCourseID(int courseID) 
    {
        this.courseID = courseID;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public int getCredits() 
    {
        return credits;
    }

    public void setCredits(int credits) 
    {
        this.credits = credits;
    }

    public int getDepartmentID() 
    {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) 
    {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Course{title=" +title+", credits=" + credits+ ",departmentID="  + departmentID + ", type= " + type +"}";
    }
    
    
    
}
