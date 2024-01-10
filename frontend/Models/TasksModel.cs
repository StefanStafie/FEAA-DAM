namespace InternshipsFrontEnd.Models
{
    using InternshipsFrontEnd.Helper;
    using Newtonsoft.Json.Linq;
    using System;
    using System.Collections.Generic;
    using Newtonsoft.Json.Linq;
    using System.Runtime.CompilerServices;
    using Newtonsoft.Json;

    public class TasksModel : IRestModel
    {
        private int? id;

        private string name;

        private string description;

        private DateTime? createDate;

        private DateTime? finishDate;

        private int? estimatedHours;

        private StateEnum? state;

        private string remarks;

        private InternshipsModel intership;

        private List<TeamModel> teams;

        public TasksModel() { }

        public TasksModel(string name, string description, DateTime createDate, DateTime finishDate, int estimatedHours,
            StateEnum state, string remarks, InternshipsModel internship)
        {
            this.name = name;
            this.description = description;
            this.createDate = createDate;
            this.finishDate = finishDate;
            this.estimatedHours = estimatedHours;
            this.state = state;
            this.remarks = remarks;
            this.intership = internship;
        }

        public int? Id
        {
            get { return id; }
            set { id = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public string Description
        {
            get { return description; }
            set { description = value; }
        }

        public DateTime? CreateDate
        {
            get { return createDate; }
            set { createDate = value; }
        }

        public DateTime? FinishDate
        {
            get { return finishDate; }
            set { finishDate = value; }
        }

        public int? EstimatedHours
        {
            get { return estimatedHours; }
            set { estimatedHours = value; }
        }

        public StateEnum? State
        {
            get { return state; }
            set { state = value; }
        }

        public string Remarks
        {
            get { return remarks; }
            set { remarks = value; }
        }

        public InternshipsModel Intership
        {
            get { return intership; }
            set { intership = value; }
        }

        public List<TeamModel> Teams
        {
            get { return teams; }
            set { teams = value; }
        }

        public static TasksModel FromResponse(string v)
        {
            var x = JsonConvert.DeserializeObject<TasksModel>(v);
            return x;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, SerializerSettings.Settings);
        }
    }


}
