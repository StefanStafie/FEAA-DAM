using InternshipsFrontEnd.Helper;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InternshipsFrontEnd.Models
{
    public class EmployeeModel : IRestModel
    {
        private int id;

        private string lastName;

        private string firstName;

        private string skills;

        private string position;

        private DepartamentEnum departament;

        private string contact;

        private TeamModel team;

        public EmployeeModel() { }

        public EmployeeModel(string lastName, string firstName, string skills, string position, DepartamentEnum departament, string contact)
        {
            this.lastName = lastName;
            this.firstName = firstName;
            this.skills = skills;
            this.position = position;
            this.departament = departament;
            this.contact = contact;
        }

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }

        public string FirstName
        {
            get { return firstName; }
            set { firstName = value; }
        }

        public string Skills
        {
            get { return skills; }
            set { skills = value; }
        }

        public string Position
        {
            get { return position; }
            set { position = value; }
        }

        public DepartamentEnum Departament
        {
            get { return departament; }
            set { departament = value; }
        }

        public string Contact
        {
            get { return contact; }
            set { contact = value; }
        }

        public TeamModel Team
        {
            get { return team; }
            set { team = value; }
        }

        public static EmployeeModel FromResponse(string v)
        {
            var x = JsonConvert.DeserializeObject<EmployeeModel>(v);
            return x;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, SerializerSettings.Settings);
        }
    }
}
