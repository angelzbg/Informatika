using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SimplePaint
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
            lines = new List<Line>();
        }

        List<Line> lines;
        int oldX, oldY;

        private void pCanvas_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                oldX = e.X;
                oldY = e.Y;
            }
        }

        private void pCanvas_Paint(object sender, PaintEventArgs e)
        {
            foreach (Line l in lines)
            {
                Pen pen = new Pen(Color.Navy, 2);

                e.Graphics.DrawLine(pen, l.X1, l.Y1, l.X2, l.Y2);

                pen.Dispose();
            }
        }

        private void pCanvas_MouseMove(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                Graphics gr = pCanvas.CreateGraphics();
                Pen pen = new Pen(Color.Navy, 2);
                gr.DrawLine(pen, oldX, oldY, e.X, e.Y);
                
                Line newLine = new Line()
                {
                    X1 = oldX,
                    Y1 = oldY,
                    X2 = e.X,
                    Y2 = e.Y
                };
                lines.Add(newLine);

                oldX = e.X; oldY = e.Y;
            }
        }
    }
}
