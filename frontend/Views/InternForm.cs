using InternshipsFrontEnd.Models;
using InternshipsFrontEnd.RestApi;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Windows.Forms;

namespace InternshipsFrontEnd.Views
{
    public partial class InternForm : Form
    {
        InternEmployeeModel intern = null;
        private List<TasksModel> tasks;
        private List<ReviewModel> reviews;

        public InternForm(InternEmployeeModel intern)
        {
            try
            {
                this.intern = intern;
                InitializeComponent();

                label19.Text = intern.Id.ToString();
                label22.Text = intern.LastName;
                label24.Text = intern.FirstName;
                label26.Text = intern.Specialization;
                label29.Text = intern.Departament.ToString();
                label32.Text = intern.Contact;


                var internEmployeeService = new ReviewsService();
                reviews = internEmployeeService.GetAll().Cast<ReviewModel>().ToList();
                reviews = reviews.FindAll(x => x.InternEmployee?.Id == intern.Id);
                internsGridView.DataSource = reviews;
                internsGridView.Columns[0].Visible = false;
                internsGridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }

        }
    }
}
