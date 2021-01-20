using System;

namespace BYT11
{
    public class Recruiter : User
    {

        public string CompanyName { get { return Industry; } set { if (value.Length == 0 || value == null) throw new Exception("Provide correct Company"); } }
        public string CompanyWebsite { get { return Industry; } set { if (value.Length == 0 || value == null) throw new Exception("Provide correct website"); } }
        public string Industry { get { return Industry; } set { if (value.Length == 0 || value == null) throw new Exception("Provide correct industy"); } }
        public int Size { get { return Size; } set { if (value <= 0) throw new Exception("Size number cannot be negative"); } }
        public int YearFounded { get { return YearFounded; } set { if (value <= 0) throw new Exception("Year cannot be negative"); } }

        public Recruiter(string FirstName, string LastName, string Email, string Country, string City, int YearOfExperience, string Description, Roles roles, string ContactNumber, string companyName, string companyWebsite, string industry, int size, int yearFounded) : base(FirstName, LastName, Email, Country, City, YearOfExperience, ContactNumber, Description, roles)
        {
            CompanyName = companyName;
            CompanyWebsite = companyWebsite;
            Industry = industry;
            Size = size;
            YearFounded = yearFounded;
        }
    }
}
