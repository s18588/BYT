using System;

namespace BYT11
{
    public class Job
    {
        public string Name
        {
            get { return Name; }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else Name = value; }
        }

        public string Description
        {
            get { return Description; }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else Description = value; }
        }
        public string Category
        {
            get
            {
                return Category;
            }
            set { if (value == null) throw new ArgumentNullException(nameof(value)); else Category = value; }
        }
        public int SalaryLow {
            get { return SalaryLow; }
            set { if (value < 0) { SalaryLow = 0; } else { SalaryLow = value; } }
        }
        public int SalaryHigh
        {
            get { return SalaryHigh; }
            set { if (value < 0 | SalaryHigh < SalaryHigh) { SalaryHigh = SalaryLow; } else { SalaryHigh = value; } }
        } 
        public DateTime StartDate {
            get { return StartDate; }
            set { if (StartDate < DateTime.Now) { StartDate = DateTime.Now; } else { StartDate = value; } }
        }

        public Job(string name, string description, string category, int salaryLow, int salaryHigh, DateTime startDate)
        {
            Name = name;
            Description = description;
            Category = category;
            SalaryLow = salaryLow;
            SalaryHigh = salaryHigh;
            StartDate = startDate;
        }

        public void Add() { Console.WriteLine("Job has been successfully added to moderation queue"); }
        public void Update() { Console.WriteLine("Job update has been successfully added to moderation queue"); }
        public void Remove() { Console.WriteLine("Job has been successfully"); }
    }
}
