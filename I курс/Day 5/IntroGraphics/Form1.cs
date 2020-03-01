using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace IntroGraphics
{
    public partial class MainForm : Form
    {
        Random rand;
        public MainForm()
        {
            InitializeComponent();
            rand = new Random();
        }

        private Color GenerateRandomColor()
        {
            byte r = (byte)rand.Next(256);
            byte g = (byte)rand.Next(256);
            byte b = (byte)rand.Next(256);
            return Color.FromArgb(r, g, b);
        }

        private void bDrawSomething_Click(object sender, EventArgs e)
        {
            Graphics gr = pCanvas.CreateGraphics();
            gr.FillRectangle(Brushes.White, pCanvas.ClientRectangle);

            //Brush brush = new SolidBrush(Color.Red);
            Brush brush =
                new System.Drawing.Drawing2D.LinearGradientBrush(
                    pCanvas.ClientRectangle, Color.Red, Color.Yellow, 45, true);

            gr.FillEllipse(brush, pCanvas.ClientRectangle);
        }

        private void pCanvas_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.FillRectangle(Brushes.White, pCanvas.ClientRectangle);
            for (int i = 0; i < 50; i++)
            {
                Pen pen = new Pen(GenerateRandomColor(), rand.Next(10) + 1);

                int x1 = rand.Next(pCanvas.ClientSize.Width);
                int y1 = rand.Next(pCanvas.ClientSize.Height);
                int x2 = rand.Next(pCanvas.ClientSize.Width);
                int y2 = rand.Next(pCanvas.ClientSize.Height);

                e.Graphics.DrawLine(pen, x1, y1, x2, y2);

                pen.Dispose();
            }
        }
    }
}
