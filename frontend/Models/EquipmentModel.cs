using InternshipsFrontEnd.Helper;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InternshipsFrontEnd.Models
{
    public class EquipmentModel : IRestModel
    {
        private int id;

        private string name;

        private int serialNumber;

        private string type;

        private InternEmployeeModel internEmployee;

        public EquipmentModel() { }

        public EquipmentModel(string name, int serialNumber, string type, InternEmployeeModel internEmployee)
        {
            this.name = name;
            this.serialNumber = serialNumber;
            this.type = type;
            this.internEmployee = internEmployee;
        }

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public int SerialNumber
        {
            get { return serialNumber; }
            set { serialNumber = value; }
        }

        public string Type
        {
            get { return type; }
            set { type = value; }
        }

        public InternEmployeeModel InternEmployee
        {
            get { return internEmployee; }
            set { internEmployee = value; }
        }

        public static EquipmentModel FromResponse(string v)
        {
            var x = JsonConvert.DeserializeObject<EquipmentModel>(v);
            return x;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, SerializerSettings.Settings);
        }
    }
}
