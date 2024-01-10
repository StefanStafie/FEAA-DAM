using InternshipsFrontEnd.Helper;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InternshipsFrontEnd.Models
{
    public class InternshipsModel : IRestModel
    {
        private int? id;

        private string name = string.Empty;

        private bool? payed = false;

        private int? numberOfSeatsAvailable = 1;

        private int? numberOfHoursWeekly = 40;

        private DateTime? startDate;

        private DateTime? finishDate;

        private StateEnum? state;

        private DepartamentEnum? departament;

        private List<Task> tasks;

        private EmployeeModel employee;

        public InternshipsModel() { }

        public InternshipsModel(string name, bool payed, int numberOfSeatsAvailable, int numberOfHoursWeekly,
            DateTime startDate, DateTime finishDate, StateEnum state, DepartamentEnum departament, EmployeeModel employee)
        {
            this.name = name;
            this.payed = payed;
            this.numberOfSeatsAvailable = numberOfSeatsAvailable;
            this.numberOfHoursWeekly = numberOfHoursWeekly;
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.state = state;
            this.departament = departament;
            this.employee = employee;
        }

        public int? Id
        {
            get { return id; }
            set { id = value; }
        }

        public string Name
        {
            get { return name==null?"":name; }
            set { name = value; }
        }

        public bool? Payed
        {
            get { return payed == null ? false : payed; }
            set { payed = value; }
        }

        public int? NumberOfSeatsAvailable
        {
            get { return numberOfSeatsAvailable == null ? 0 : numberOfSeatsAvailable; }
            set { numberOfSeatsAvailable = value; }
        }

        public int? NumberOfHoursWeekly
        {
            get { return numberOfHoursWeekly == null ? 0 : numberOfHoursWeekly; }
            set { numberOfHoursWeekly = value; }
        }

        public DateTime? StartDate
        {
            get { return startDate; }
            set { startDate = value; }
        }

        public DateTime? FinishDate
        {
            get { return finishDate; }
            set { finishDate = value; }
        }

        public StateEnum? State
        {
            get { return state == null ? StateEnum.IN_PROGRESS : state; }
            set { state = value; }
        }

        public DepartamentEnum? Departament
        {
            get { return departament == null ? DepartamentEnum.SUPPORT : departament; }
            set { departament = value; }
        }

        public List<Task> Tasks
        {
            get { return tasks; }
            set { tasks = value; }
        }

        public EmployeeModel Employee
        {
            get { return employee; }
            set { employee = value; }
        }

        public static InternshipsModel FromResponse(string v)
        {
            var x = JsonConvert.DeserializeObject<InternshipsModel>(v);
            return x;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, SerializerSettings.Settings);
        }
    }
}
