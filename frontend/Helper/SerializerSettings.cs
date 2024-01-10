using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Serialization;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InternshipsFrontEnd.Helper
{
    internal class SerializerSettings
    {
        private static JsonSerializerSettings settings;
        public static JsonSerializerSettings Settings
        {
            get
            {
                if(settings == null)
                {
                    settings = new JsonSerializerSettings
                    {
                        ContractResolver = new Newtonsoft.Json.Serialization.DefaultContractResolver
                        {
                            NamingStrategy = new Newtonsoft.Json.Serialization.CamelCaseNamingStrategy()
                        },

                        Formatting = Newtonsoft.Json.Formatting.Indented, // Optional: Indented formatting for better readability
                        Converters = { new IsoDateTimeConverter { DateTimeFormat = "yyyy-MM-dd" } }
                    };
                }

                return settings;
            }
        }
    }
}
