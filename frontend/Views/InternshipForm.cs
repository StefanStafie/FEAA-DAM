using InternshipsFrontEnd.Models;
using InternshipsFrontEnd.RestApi;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Windows.Forms;

namespace InternshipsFrontEnd.Views
{
    public partial class InternshipForm : Form
    {
        InternshipsModel internship = null;
        List<InternEmployeeModel> interns = null;
        private List<TasksModel> tasks;

        public InternshipForm(InternshipsModel internship)
        {
            this.internship = internship;
            InitializeComponent();
            try
            {
                label1.Text = internship.Name;
                internshipName.Text = internship.Id.ToString();
                label2.Text = internship.Payed.ToString();
                label3.Text = internship.StartDate.ToString();
                label4.Text = internship.FinishDate.ToString();
                label5.Text = internship.State.ToString();
                label6.Text = internship.Departament.ToString();
                label7.Text = internship.NumberOfHoursWeekly.ToString();
                label8.Text = internship.NumberOfSeatsAvailable.ToString();

                label19.Text = internship.Employee.Id.ToString();
                label22.Text = internship.Employee.LastName;
                label24.Text = internship.Employee.FirstName;
                label26.Text = internship.Employee.Skills;
                label29.Text = internship.Employee.Position;
                label32.Text = internship.Employee.Contact;

                var internEmployeeService = new InternEmployeeService();
                interns = internEmployeeService.GetAll().Cast<InternEmployeeModel>().ToList();
                interns = interns.FindAll(x => x.Internship?.Id == internship.Id);
                internsGridView.DataSource = interns;
                internsGridView.Columns[0].Visible = false;
                internsGridView.Columns[6].Visible = false;
                internsGridView.Columns[7].Visible = false;
                internsGridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

                var tasksService = new TasksService();
                tasks = tasksService.GetAll().Cast<TasksModel>().ToList();
                tasks = tasks.FindAll(x => x.Intership?.Id == internship.Id);
                tasksGridView.DataSource = tasks;
                tasksGridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
                tasksGridView.Columns[0].Visible = false;
                tasksGridView.Columns[8].Visible = false;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void internsGridView_DoubleClick(object sender, EventArgs e)
        {
            try
            {
                if (internsGridView.SelectedCells.Count > 0)
                {
                    var intern = interns.Find(x => x.Id == (int)internsGridView[0, internsGridView.SelectedCells[0].RowIndex].Value);
                    var dialog = new InternForm(intern);
                    dialog.ShowDialog(this);
                    dialog.Dispose();
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }
    }
}
