using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InternshipsFrontEnd.RestApi
{
    using System;
    using System.Net.Http;
    using System.Runtime.CompilerServices;
    using System.Threading.Tasks;

    public class ApiService
    {
        private readonly HttpClient _httpClient;
        private const string ApiBaseUrl = "http://localhost:8081/api/";

        // Singleton instance
        private static ApiService _instance;

        // Private constructor to prevent external instantiation
        private ApiService()
        {
            _httpClient = new HttpClient();
            _httpClient.BaseAddress = new Uri(ApiBaseUrl);
        }

        // Property to access the singleton instance
        public static ApiService Instance
        {
            get
            {
                if (_instance == null)
                {
                    _instance = new ApiService();
                }
                return _instance;
            }
        }

        public static HttpClient Client
        {
            get
            {
                 if (_instance == null)
                {
                    _instance = new ApiService();
                }
                return Instance._httpClient;
            }
        }
    }

}
