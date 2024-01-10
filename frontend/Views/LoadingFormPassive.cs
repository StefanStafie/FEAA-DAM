using System;
using System.Windows.Forms;

namespace InternshipsFrontEnd.Views
{
    public partial class LoadingFormPassive : Form
    {
        public LoadingFormPassive()
        {
            InitializeComponent();
        }
        public static bool IsShown { get; internal set; } = false;

        private void LoadingFormPassive_Shown(object sender, EventArgs e)
        {
            IsShown = true;
        }

        private void LoadingFormPassive_FormClosed(object sender, FormClosedEventArgs e)
        {
            IsShown = false;
        }
    }
}