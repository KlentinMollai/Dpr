/**
 *  In the class Employee, fields firstName, lastName and hourlyRate are defined.
 *  It also implements getters and setters and a toString method.   
 */
class Employee
{
   
  public String firstName;
  public String lastName;
  public double hourlyRate;

public Employee() {
  }

  public Employee(String last, String first, double rate) 
  {
    this.lastName = last; 
    this.firstName = first;
    this.hourlyRate = rate;
  }
  
  public  String getLastName() 
  {
	return lastName;
}

private void setLastName(String lastName) 
{
	this.lastName = lastName;
}

public String getFirstName() 
{
	return firstName;
}

private void setFirstName(String firstName) 
{
	this.firstName = firstName;
}

public  double getHourlyRate() 
{
	return hourlyRate;
}

private  void setHourlyRate(double rate) 
{
	rate = hourlyRate;
}

  public  String toString()
  {
    return  String.format("%s  %s  %S ", firstName, lastName, hourlyRate);
  }




  
}
