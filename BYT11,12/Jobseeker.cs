using System;
using System.Collections.Generic;

namespace BYT11
{
    public class Jobseeker : User
    {
        public Jobseeker(string FirstName, string LastName, string Email, string Country, string City, int YearOfExperience, string Description, Roles roles, string ContactNumber, List<string> skills) : base(FirstName, LastName, Email, Country, City, YearOfExperience, ContactNumber, Description, roles)
        {
            Skills = skills;
        }

        public List<string> Skills { get; set; }

        public void ApplyForJob() { Console.WriteLine("You are successfully applied!"); }
    }
}
