package DTO;

public class CourseInstructorDTO 
{
    private int CourseID;
    private int PersonID;
    
    public CourseInstructorDTO()
    {
        // none parameters
    }

    public CourseInstructorDTO(int PersonID, int CourseID) 
    {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }

    public int getCourseID() 
    {
        return CourseID;
    }

    public void setCourseID(int CourseID) 
    {
        this.CourseID = CourseID;
    }

    public int getPersonID() 
    {
        return PersonID;
    }

    public void setPersonID(int PersonID) 
    {
        this.PersonID = PersonID;
    }
    
}
