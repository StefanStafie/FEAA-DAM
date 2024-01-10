using InternshipsFrontEnd.Models;
using InternshipsFrontEnd.RestApi;
using System;
using System.ComponentModel;
using System.Linq;
using System.Windows.Forms;

namespace InternshipsFrontEnd.Views
{
    public partial class TasksForm : Form
    {
        private TasksService tasksService;
        private BindingList<TasksModel> tasks;
        private bool rowWasAdded;

        public TasksForm()
        {
            InitializeComponent();
            try
            {
                tasksService = new TasksService();
                tasks = new BindingList<TasksModel>(tasksService.GetAll().Cast<TasksModel>().ToList());
                tasks.AllowNew = true;
                gridView.DataSource = tasks;

                gridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
                gridView.Columns[0].Visible = false;
                gridView.Columns[8].Visible = false;

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
                var task = tasks.ToList().Find(x => x.Id == (int)gridView[0, e.RowIndex].Value);
                if (task == null || task.Id == 312412)
                {
                    return;
                }

                tasksService.Update(task);
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

                tasks = new BindingList<TasksModel>(tasksService.GetAll().Cast<TasksModel>().ToList());
                tasks.AllowNew = true;
                gridView.DataSource = tasks;

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

                tasksService.Add();
                var aux = tasksService.GetAll().Cast<TasksModel>().ToList();
                tasks[tasks.Count - 1] = aux[tasks.Count - 1];
                gridView.DataSource = tasks;


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
                tasksService.Delete(tasks[e.Row.Index]);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }
    }
}
