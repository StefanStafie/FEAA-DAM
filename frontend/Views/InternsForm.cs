using InternshipsFrontEnd.Models;
using InternshipsFrontEnd.RestApi;
using System;
using System.ComponentModel;
using System.Linq;
using System.Windows.Forms;

namespace InternshipsFrontEnd.Views
{
    public partial class InternsForm : Form
    {
        private InternEmployeeService internsService;
        private BindingList<InternEmployeeModel> InternEmployees;

        public InternsForm()
        {
            InitializeComponent();

            try
            {
                internsService = new InternEmployeeService();
                InternEmployees = new BindingList<InternEmployeeModel>(internsService.GetAll().Cast<InternEmployeeModel>().ToList());
                InternEmployees.AllowNew = true;
                gridView.DataSource = InternEmployees;

                gridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
                gridView.Columns[0].Visible = false;

                gridView.CellValueChanged += new DataGridViewCellEventHandler(gridView_CellValueChanged);
                gridView.UserAddedRow += new DataGridViewRowEventHandler(gridView_UserAddedRow);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void gridView_CellValueChanged(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                var task = InternEmployees.ToList().Find(x => x.Id == (int)gridView[0, e.RowIndex].Value);
                if (task == null || task.Id == 312412)
                {
                    return;
                }

                internsService.Update(task);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void refresh_Click(object sender, EventArgs e)
        {
            try
            {
                gridView.UserAddedRow -= new DataGridViewRowEventHandler(gridView_UserAddedRow);
                gridView.CellValueChanged -= new DataGridViewCellEventHandler(gridView_CellValueChanged);

                InternEmployees = new BindingList<InternEmployeeModel>(internsService.GetAll().Cast<InternEmployeeModel>().ToList());
                InternEmployees.AllowNew = true;
                gridView.DataSource = InternEmployees;

                gridView.CellValueChanged += new DataGridViewCellEventHandler(gridView_CellValueChanged);
                gridView.UserAddedRow += new DataGridViewRowEventHandler(gridView_UserAddedRow);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void gridView_UserAddedRow(object sender, DataGridViewRowEventArgs e)
        {
            try
            {
                gridView.UserAddedRow -= new DataGridViewRowEventHandler(gridView_UserAddedRow);
                gridView.CellValueChanged -= new DataGridViewCellEventHandler(gridView_CellValueChanged);

                internsService.Add();
                var aux = internsService.GetAll().Cast<InternEmployeeModel>().ToList();
                InternEmployees[InternEmployees.Count - 1] = aux[InternEmployees.Count - 1];
                gridView.DataSource = InternEmployees;


                gridView.CellValueChanged += new DataGridViewCellEventHandler(gridView_CellValueChanged);
                gridView.UserAddedRow += new DataGridViewRowEventHandler(gridView_UserAddedRow);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void gridView_UserDeletingRow(object sender, DataGridViewRowCancelEventArgs e)
        {
            try
            {
                internsService.Delete(InternEmployees[e.Row.Index]);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }
    }
}
