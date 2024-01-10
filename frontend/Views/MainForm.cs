using System;
using System.Drawing;
using System.IO;
using System.Threading;
using System.Windows.Forms;
using InternshipsFrontEnd.Helper;
using InternshipsFrontEnd.Views;

namespace InternshipsFrontEnd
{
    public partial class MainForm : Form
    {
        private static Thread loadingThread;
        public static LoadingFormPassive loadingFormPassive;

        public MainForm()
        {
            InitializeComponent();
            Directory.CreateDirectory($"{Application.StartupPath}\\Exports");
        }

        private void exitMenuItem_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            StartLoadingDialog();
            this.ShowChildForm(new InternshipsForm());

            // do stuff
            Thread.Sleep(1000);

            CloseLoadingDialog();
        }

        private void ResetMenuItems()
        {
            foreach (ToolStripMenuItem item in menuStrip1.Items)
            {
                item.BackColor = SystemColors.ActiveCaption;
            }
        }

        private void toolStripMenuItem_Click(object sender, EventArgs e)
        {
            ResetMenuItems();
            ((ToolStripMenuItem)sender).BackColor = SystemColors.MenuHighlight;
            ResetViews();
            ChangeView((ToolStripMenuItem)sender);
        }

        private void ResetViews()
        {
            foreach (Form form in this.MdiChildren)
            {
                form.Dispose();
            }
        }

        private void ShowChildForm(Form form)
        {
            form.MdiParent = this;
            form.WindowState = FormWindowState.Normal;
            form.FormBorderStyle = (FormBorderStyle)BorderStyle.None;
            form.Dock = DockStyle.Fill;
            form.ShowInTaskbar = false;
            form.Show();
        }

        private void ChangeView(ToolStripMenuItem sender)
        {
            MainForm.StartLoadingDialog();

            switch (sender.Text)
            {
                case "Internships":
                    this.ShowChildForm(new InternshipsForm());
                    break;

                case "Interns":
                    this.ShowChildForm(new InternsForm());
                    break;

                case "Reviews":
                    this.ShowChildForm(new ReviewsForm());
                    break;

                case "Tasks":
                    this.ShowChildForm(new TasksForm());
                    break;
            }

            MainForm.CloseLoadingDialog();
        }

        public static void StartLoadingDialog()
        {
            try
            {
                loadingThread = new Thread(() =>
                {
                    try
                    {
                        MainForm.loadingFormPassive = new LoadingFormPassive();
                        loadingFormPassive?.ShowDialog();
                    }
                    catch (Exception ex)
                    {
                        return;
                    }
                });

                loadingThread.Start();
            }
            catch (Exception)
            {
                return;
            }
        }

        public static void CloseLoadingDialog()
        {
            try
            {
                while (!LoadingFormPassive.IsShown)
                {
                    Thread.Sleep(50);
                }

                WinformsHelper.InvokeIfRequired(
                   MainForm.loadingFormPassive,
                       () =>
                       {
                           MainForm.loadingFormPassive?.Close();
                       }
                   );

                loadingThread.Join();
                loadingThread = null;
            }
            catch (Exception)
            {
                return;
            }
        }
    }
}
