using System;

namespace BYT11
{
    public abstract class User
    {
        public string FirstName {
            get { return FirstName; }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else FirstName = value; }
        }
        public string LastName {
            get { return LastName; }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else LastName = value; }
        }
        public string Email
        {
            get { return LastName; }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else LastName = value; }
        }
        public string Country {
            get { return Country; }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else Country = value; }
        }
        public string City {
            get { return City; }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else City = value; }
        }
        public int YearsOfExperience {
            get { return YearsOfExperience; }
            set { if ((value <= 0) || (value >= 70)) throw new Exception("Set the correct years of experience"); else YearsOfExperience = value; }
        }
        public string ContactNumber {
            get { return ContactNumber; }
            set { if (value.Length <= 9) throw new Exception("Input the correct phone number"); else ContactNumber = value; }
        }
        public string Description {
            get { return Description; }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else Description = value; }
        }
        public Roles Role {
            get { return Role ; }
            set { Role = value; }
        }

        public User(string firstName, string lastName, string email, string country, string city, int yearsOfExperience, string contactNumber, string description, Roles role)
        {
            FirstName = firstName;
            LastName = lastName;
            Email = email;
            Country = country;
            City = city;
            YearsOfExperience = yearsOfExperience;
            ContactNumber = contactNumber;
            Description = description;
            Role = role;
        }
        public User()
        {

        }

    }
}
