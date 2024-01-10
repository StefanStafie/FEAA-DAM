using InternshipsFrontEnd.Models;
using InternshipsFrontEnd.RestApi;
using System;
using System.ComponentModel;
using System.Linq;
using System.Windows.Forms;

namespace InternshipsFrontEnd.Views
{
    public partial class InternshipsForm : Form
    {
        BindingList<InternshipsModel> internships = null;
        InternshipsService internshipsService = null;

        public InternshipsForm()
        {
            InitializeComponent();
            try
            {
                internshipsService = new InternshipsService();
                internships = new BindingList<InternshipsModel>(internshipsService.GetInternships());
                internships.AllowNew = true;
                gridView.DataSource = internships;

                gridView.Columns[0].Visible = false;
                gridView.Columns[9].Visible = false;
                gridView.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

                gridView.CellValueChanged += new DataGridViewCellEventHandler(gridView_CellValueChanged);
                gridView.UserAddedRow += new DataGridViewRowEventHandler(gridView_UserAddedRow);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void refreshButton_Click(object sender, EventArgs e)
        {
            try
            {
                gridView.CellValueChanged -= new DataGridViewCellEventHandler(gridView_CellValueChanged);
                gridView.UserAddedRow -= new DataGridViewRowEventHandler(gridView_UserAddedRow);

                internships = new BindingList<InternshipsModel>(internshipsService.GetInternships());
                internships.AllowNew = true;
                gridView.DataSource = internships;

                gridView.UserAddedRow += new DataGridViewRowEventHandler(gridView_UserAddedRow);
                gridView.CellValueChanged += new DataGridViewCellEventHandler(gridView_CellValueChanged);
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
                var internship = internships.ToList().Find(x => x.Id == (int)gridView[0, e.RowIndex].Value);
                if (internship == null || internship.Id == 312412)
                {
                    return;
                }

                internshipsService.Update(internship);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void gridView_DoubleClick(object sender, EventArgs e)
        {
            try
            {
                if (gridView.SelectedCells[0].RowIndex >= gridView.Rows.Count - 1)
                {
                    return;
                }

                if (gridView.SelectedCells.Count > 0)
                {
                    var internship = internships.ToList().Find(x => x.Id == (int)gridView[0, gridView.SelectedCells[0].RowIndex]?.Value);
                    var dialog = new InternshipForm(internship);
                    dialog.ShowDialog(this);
                    dialog.Dispose();
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }

        private void gridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }


        private void gridView_UserAddedRow(object sender, DataGridViewRowEventArgs e)
        {
            try
            {
                gridView.UserAddedRow -= new DataGridViewRowEventHandler(gridView_UserAddedRow);
                gridView.CellValueChanged -= new DataGridViewCellEventHandler(gridView_CellValueChanged);

                internshipsService.Add();
                var aux = internshipsService.GetInternships();
                internships[internships.Count - 1] = aux[internships.Count - 1];
                gridView.DataSource = internships;

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
                internshipsService.Delete(internships[e.Row.Index]);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
        }
    }
}
