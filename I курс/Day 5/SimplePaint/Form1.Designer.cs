namespace SimplePaint
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.pCanvas = new System.Windows.Forms.Panel();
            this.SuspendLayout();
            // 
            // pCanvas
            // 
            this.pCanvas.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.pCanvas.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pCanvas.Location = new System.Drawing.Point(12, 84);
            this.pCanvas.Name = "pCanvas";
            this.pCanvas.Size = new System.Drawing.Size(871, 448);
            this.pCanvas.TabIndex = 0;
            this.pCanvas.Paint += new System.Windows.Forms.PaintEventHandler(this.pCanvas_Paint);
            this.pCanvas.MouseDown += new System.Windows.Forms.MouseEventHandler(this.pCanvas_MouseDown);
            this.pCanvas.MouseMove += new System.Windows.Forms.MouseEventHandler(this.pCanvas_MouseMove);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(895, 544);
            this.Controls.Add(this.pCanvas);
            this.Name = "MainForm";
            this.Text = "Simple Paint";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel pCanvas;
    }
}

