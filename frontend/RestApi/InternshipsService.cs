using InternshipsFrontEnd.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using static System.Net.Mime.MediaTypeNames;

namespace InternshipsFrontEnd.RestApi
{
    public class InternshipsService : IRestService
    {
        public string Add()
        {
            string endpoint = $"internships/addInternship";

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

        public string Delete(IRestModel model)
        {
            var obj = (InternshipsModel)model;
            string endpoint = $"internships/deleteInternship/{obj.Id}";

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

        public List<IRestModel> GetAll()
        {
            string endpoint = $"internships";

            var client = ApiService.Client;
            HttpResponseMessage response = client.GetAsync(endpoint).Result;

            if (response.IsSuccessStatusCode)
            {
                return JsonConvert.DeserializeObject<List<InternshipsModel>>(response.Content.ReadAsStringAsync().Result).Cast<IRestModel>().ToList();
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }

        public InternshipsModel GetInternshipById(int internshipId)
        {
            string endpoint = $"internships/{internshipId}";

            var client = ApiService.Client;
            HttpResponseMessage response = client.GetAsync(endpoint).Result;

            if (response.IsSuccessStatusCode)
            {
                return InternshipsModel.FromResponse(response.Content.ReadAsStringAsync().Result);
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }

        public List<InternshipsModel> GetInternships()
        {
            string endpoint = $"internships";

            var client = ApiService.Client;
            HttpResponseMessage response = client.GetAsync(endpoint).Result;

            if (response.IsSuccessStatusCode)
            {
                var x = JsonConvert.DeserializeObject<List<InternshipsModel>>(response.Content.ReadAsStringAsync().Result);
                return x;
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }

        public string Update(IRestModel model)
        {
            var obj = (InternshipsModel)model;
            string endpoint = $"internships/updateInternship/{obj.Id}";

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
    }
}
