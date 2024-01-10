using InternshipsFrontEnd.Models;
using System.Collections.Generic;
using System.Data.OleDb;

namespace InternshipsFrontEnd.RestApi
{
    public interface IRestService
    {
        List<IRestModel> GetAll();
        string Update(IRestModel model);
        string Delete(IRestModel model);
        string Add();
    }
}