using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Winery.Presenters
{
    internal class MainFormPresenter
    {
        private DataSet2 dataSet;

        public MainFormPresenter()
        {
            this.dataSet = new Winery.DataSet2();
            this.dataSet.DataSetName = "DataSet2";
            this.dataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
        }

        public DataSet2TableAdapters.WINESTableAdapter getWines()
        {
            DataSet2TableAdapters.WINESTableAdapter WinesTableAdapter = new DataSet2TableAdapters.WINESTableAdapter();
            WinesTableAdapter.Fill(this.dataSet.WINES);
            return WinesTableAdapter;
        }


    public DataSet2 DataSet { get; set; } 
    }
}
