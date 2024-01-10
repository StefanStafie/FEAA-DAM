using InternshipsFrontEnd.Helper;
using Newtonsoft.Json;
using System.Threading.Tasks;

namespace InternshipsFrontEnd.Models
{
    public class TaskAssignmentModel : IRestModel
    {
        private int id;

        private TeamModel team;

        private Task task;

        public TaskAssignmentModel() { }

        public TaskAssignmentModel(TeamModel team, Task task)
        {
            this.team = team;
            this.task = task;
        }

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public TeamModel Team
        {
            get { return team; }
            set { team = value; }
        }

        public Task Task
        {
            get { return task; }
            set { task = value; }
        }

        public static TaskAssignmentModel FromResponse(string v)
        {
            var x = JsonConvert.DeserializeObject<TaskAssignmentModel>(v);
            return x;
        }

        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, SerializerSettings.Settings);
        }
    }
}
