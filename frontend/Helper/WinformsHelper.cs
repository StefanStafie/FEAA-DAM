using System;
using System.Diagnostics;
using System.Windows.Forms;

namespace InternshipsFrontEnd.Helper
{
    public static class WinformsHelper
    {
        public static void InvokeIfRequired(this Control control, MethodInvoker action)
        {
            if (control.InvokeRequired)
            {
                control.Invoke(action);
            }
            else
            {
                action();
            }
        }

        public static int GetWeek(DateTime date)
        {
            var cal = System.Globalization.CultureInfo.CurrentCulture.Calendar;
            var weekNum = cal.GetWeekOfYear(date, System.Globalization.CalendarWeekRule.FirstFourDayWeek, DayOfWeek.Monday);

            if (weekNum == 1 && date.Month == 12)
            {
                return cal.GetWeekOfYear(date.AddDays(7), System.Globalization.CalendarWeekRule.FirstFourDayWeek, DayOfWeek.Monday);
            }

            return weekNum;
        }

        public static int CalculateAge(DateTime birthdate)
        {
            DateTime currentDate = DateTime.Now;
            int age = currentDate.Year - birthdate.Year;
            if (birthdate > currentDate.AddYears(-age))
            {
                age--;
            }
            return age;
        }

        public static void OpenGoogleSearch(string query)
        {
            try
            {
                string searchQuery = "https://www.google.com/search?q=" + query;
                Process.Start(new ProcessStartInfo(searchQuery));
            }
            catch (Exception ex)
            {
                MessageBox.Show("An error occurred: " + ex.Message);
            }
        }
    }
}
