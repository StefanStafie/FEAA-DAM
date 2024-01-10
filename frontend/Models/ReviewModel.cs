using InternshipsFrontEnd.Helper;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InternshipsFrontEnd.Models
{
    public class ReviewModel : IRestModel
    {
        private int? id;

        private DateTime createDate;

        private string positiveMessage;

        private string negativeMessage;

        private int? mark;

        private string comment;

        private string criteria;

        private InternEmployeeModel internEmployee;

        public ReviewModel() { }

        public ReviewModel(DateTime createDate, string positiveMessage, string negativeMessage, int mark, string comment,
            string criteria, InternEmployeeModel internEmployee)
        {
            this.createDate = createDate;
            this.positiveMessage = positiveMessage;
            this.negativeMessage = negativeMessage;
            this.mark = mark;
            this.comment = comment;
            this.criteria = criteria;
            this.internEmployee = internEmployee;
        }

        public int? Id
        {
            get { return id; }
            set { id = value; }
        }

        public DateTime CreateDate
        {
            get { return createDate; }
            set { createDate = value; }
        }

        public string PositiveMessage
        {
            get { return positiveMessage; }
            set { positiveMessage = value; }
        }

        public string NegativeMessage
        {
            get { return negativeMessage; }
            set { negativeMessage = value; }
        }

        public int? Mark
        {
            get { return mark; }
            set { mark = value; }
        }

        public string Comment
        {
            get { return comment; }
            set { comment = value; }
        }

        public string Criteria
        {
            get { return criteria; }
            set { criteria = value; }
        }

        public InternEmployeeModel InternEmployee
        {
            get { return internEmployee; }
            set { internEmployee = value; }
        }


        public static ReviewModel FromResponse(string v)
        {
            var x = JsonConvert.DeserializeObject<ReviewModel>(v);
            return x;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, SerializerSettings.Settings);
        }
    }
}
