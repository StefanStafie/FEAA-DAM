using System.Threading.Tasks;

namespace InternshipsFrontEnd.Models
{
    using InternshipsFrontEnd.Helper;
    using Newtonsoft.Json;
    using System.Collections.Generic;


    public class TeamModel : IRestModel
    {
        private int id;

        private string teamName;

        private DepartamentEnum departament;

        private List<EmployeeModel> employees;

        private List<InternEmployeeModel> internEmployees;

        private List<TasksModel> tasks;

        public TeamModel() { }

        public TeamModel(string teamName, DepartamentEnum departament)
        {
            this.teamName = teamName;
            this.departament = departament;
        }

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string TeamName
        {
            get { return teamName; }
            set { teamName = value; }
        }

        public DepartamentEnum Departament
        {
            get { return departament; }
            set { departament = value; }
        }

        public List<EmployeeModel> Employees
        {
            get { return employees; }
            set { employees = value; }
        }

        public List<InternEmployeeModel> InternEmployees
        {
            get { return internEmployees; }
            set { internEmployees = value; }
        }

        public List<TasksModel> Tasks
        {
            get { return tasks; }
            set { tasks = value; }
        }

        public static TeamModel FromResponse(string v)
        {
            var x = JsonConvert.DeserializeObject<TeamModel>(v);
            return x;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, SerializerSettings.Settings);
        }
    }


}
