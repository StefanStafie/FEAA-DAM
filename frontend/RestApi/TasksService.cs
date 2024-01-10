using InternshipsFrontEnd.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using static System.Net.Mime.MediaTypeNames;

namespace InternshipsFrontEnd.RestApi
{
    public class TasksService : IRestService
    {
        public TasksModel GetTaskById(int taskId)
        {
            string endpoint = $"tasks/{taskId}";

            var client = ApiService.Client;
            HttpResponseMessage response = client.GetAsync(endpoint).Result;

            if (response.IsSuccessStatusCode)
            {
                return TasksModel.FromResponse(response.Content.ReadAsStringAsync().Result);
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }

        public List<IRestModel> GetAll()
        {
            string endpoint = $"tasks";

            var client = ApiService.Client;
            HttpResponseMessage response = client.GetAsync(endpoint).Result;

            if (response.IsSuccessStatusCode)
            {
                return JsonConvert.DeserializeObject<List<TasksModel>>(response.Content.ReadAsStringAsync().Result).Cast<IRestModel>().ToList();
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }

        public string Update(IRestModel model)
        {
            TasksModel obj = (TasksModel)model;
            string endpoint = $"tasks/updateTask/{obj.Id}";

            var client = ApiService.Client;
            string cont = obj.ToJson();

            HttpContent content = new StringContent(cont, Encoding.UTF8, "application/json");
            Console.WriteLine(cont);
            HttpResponseMessage response = client.PutAsync(endpoint, content).Result;

            if (response.IsSuccessStatusCode)
            {
                return response.Content.ReadAsStringAsync().Result.ToString();
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }

        public string Delete(IRestModel model)
        {
            TasksModel obj = (TasksModel)model;
            string endpoint = $"tasks/deleteTask/{obj.Id}";

            var client = ApiService.Client;

            HttpResponseMessage response = client.DeleteAsync(endpoint).Result;

            if (response.IsSuccessStatusCode)
            {
                return response.Content.ReadAsStringAsync().Result.ToString();
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }

        public string Add()
        {
            string endpoint = $"tasks/addTask";

            var client = ApiService.Client;

            HttpContent content = new StringContent("{}", Encoding.UTF8, "application/json");
            HttpResponseMessage response = client.PostAsync(endpoint, content).Result;

            if (response.IsSuccessStatusCode)
            {
                return response.Content.ReadAsStringAsync().Result.ToString();
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }
    }
}
