namespace IntroGraphics
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
            this.bDrawSomething = new System.Windows.Forms.Button();
            this.pCanvas = new System.Windows.Forms.Panel();
            this.SuspendLayout();
            // 
            // bDrawSomething
            // 
            this.bDrawSomething.Location = new System.Drawing.Point(12, 12);
            this.bDrawSomething.Name = "bDrawSomething";
            this.bDrawSomething.Size = new System.Drawing.Size(180, 94);
            this.bDrawSomething.TabIndex = 0;
            this.bDrawSomething.Text = "Draw Something";
            this.bDrawSomething.UseVisualStyleBackColor = true;
            this.bDrawSomething.Click += new System.EventHandler(this.bDrawSomething_Click);
            // 
            // pCanvas
            // 
            this.pCanvas.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pCanvas.Location = new System.Drawing.Point(26, 151);
            this.pCanvas.Name = "pCanvas";
            this.pCanvas.Size = new System.Drawing.Size(1038, 570);
            this.pCanvas.TabIndex = 1;
            this.pCanvas.Paint += new System.Windows.Forms.PaintEventHandler(this.pCanvas_Paint);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1076, 733);
            this.Controls.Add(this.pCanvas);
            this.Controls.Add(this.bDrawSomething);
            this.Name = "MainForm";
            this.Text = "Intro Graphics";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button bDrawSomething;
        private System.Windows.Forms.Panel pCanvas;
    }
}

