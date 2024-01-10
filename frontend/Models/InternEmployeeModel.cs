using InternshipsFrontEnd.Helper;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InternshipsFrontEnd.Models
{
    public class InternEmployeeModel : IRestModel
    {
        private int? id = 0;

        private string lastName = "-";

        private string firstName = "-";

        private string contact = "-";

        private DepartamentEnum? departament = DepartamentEnum.BACKEND_DEVELOPMENT;

        private string specialization = "-";

        private InternshipsModel internship = null;

        private List<EquipmentModel> equipments = null;

        private List<ReviewModel> reviews = null;

        private TeamModel team = null;

        public InternEmployeeModel() { }

        public InternEmployeeModel(string lastName, string firstName, string contact, DepartamentEnum departament,
            string specialization, InternshipsModel internship, TeamModel team)
        {
            this.lastName = lastName;
            this.firstName = firstName;
            this.contact = contact;
            this.departament = departament;
            this.specialization = specialization;
            this.internship = internship;
            this.team = team;
        }

        public int? Id
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

        public string Contact
        {
            get { return contact; }
            set { contact = value; }
        }

        public DepartamentEnum? Departament
        {
            get { return departament; }
            set { departament = value; }
        }

        public string Specialization
        {
            get { return specialization; }
            set { specialization = value; }
        }

        public InternshipsModel Internship
        {
            get { return internship; }
            set { internship = value; }
        }

        public List<EquipmentModel> Equipments
        {
            get { return equipments; }
            set { equipments = value; }
        }

        public List<ReviewModel> Reviews
        {
            get { return reviews; }
            set { reviews = value; }
        }

        public TeamModel Team
        {
            get { return team; }
            set { team = value; }
        }

        public static InternEmployeeModel FromResponse(string v)
        {
            var x = JsonConvert.DeserializeObject<InternEmployeeModel>(v);
            return x;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, SerializerSettings.Settings);
        }

        override
        public string ToString()
        {
            return this.id + ": " + this.firstName + " " + this.lastName;
        }
    }
}
