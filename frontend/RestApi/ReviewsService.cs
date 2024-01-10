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
    public class ReviewsService : IRestService
    {   
        public List<IRestModel> GetAll()
        {
            string endpoint = $"reviews";

            var client = ApiService.Client;
            HttpResponseMessage response = client.GetAsync(endpoint).Result;

            if (response.IsSuccessStatusCode)
            {
                return JsonConvert.DeserializeObject<List<ReviewModel>>(response.Content.ReadAsStringAsync().Result).Cast<IRestModel>().ToList();
            }
            else
            {
                MessageBox.Show($"API request failed with status code {response.StatusCode}");
                return null;
            }
        }

        public string Update(IRestModel model)
        {
            ReviewModel obj = (ReviewModel)model;
            string endpoint = $"reviews/updateReview/{obj.Id}";

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
            ReviewModel obj = (ReviewModel)model;
            string endpoint = $"reviews/deleteReview/{obj.Id}";

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
            string endpoint = $"reviews/addReview";

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
