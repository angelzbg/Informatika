namespace ArenaWinforms
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
            this.components = new System.ComponentModel.Container();
            this.bNewGame = new System.Windows.Forms.Button();
            this.timerGame = new System.Windows.Forms.Timer(this.components);
            this.pictureBox = new System.Windows.Forms.PictureBox();
            this.lWinner = new System.Windows.Forms.Label();
            this.timerStopAnimation = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox)).BeginInit();
            this.SuspendLayout();
            // 
            // bNewGame
            // 
            this.bNewGame.Location = new System.Drawing.Point(12, 13);
            this.bNewGame.Name = "bNewGame";
            this.bNewGame.Size = new System.Drawing.Size(75, 23);
            this.bNewGame.TabIndex = 0;
            this.bNewGame.Text = "New Game";
            this.bNewGame.UseVisualStyleBackColor = true;
            this.bNewGame.Click += new System.EventHandler(this.bNewGame_Click);
            // 
            // timerGame
            // 
            this.timerGame.Interval = 2000;
            this.timerGame.Tick += new System.EventHandler(this.timerGame_Tick);
            // 
            // pictureBox
            // 
            this.pictureBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.pictureBox.BackColor = System.Drawing.SystemColors.Control;
            this.pictureBox.Location = new System.Drawing.Point(12, 42);
            this.pictureBox.Name = "pictureBox";
            this.pictureBox.Size = new System.Drawing.Size(687, 386);
            this.pictureBox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox.TabIndex = 1;
            this.pictureBox.TabStop = false;
            // 
            // lWinner
            // 
            this.lWinner.AutoSize = true;
            this.lWinner.BackColor = System.Drawing.Color.Black;
            this.lWinner.Font = new System.Drawing.Font("Arial Narrow", 27.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lWinner.ForeColor = System.Drawing.Color.White;
            this.lWinner.Location = new System.Drawing.Point(26, 57);
            this.lWinner.Name = "lWinner";
            this.lWinner.Size = new System.Drawing.Size(105, 43);
            this.lWinner.TabIndex = 2;
            this.lWinner.Text = "label1";
            this.lWinner.Visible = false;
            // 
            // timerStopAnimation
            // 
            this.timerStopAnimation.Interval = 10200;
            this.timerStopAnimation.Tick += new System.EventHandler(this.timerStopAnimation_Tick);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(711, 440);
            this.Controls.Add(this.lWinner);
            this.Controls.Add(this.pictureBox);
            this.Controls.Add(this.bNewGame);
            this.Name = "MainForm";
            this.Text = "Arena";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button bNewGame;
        private System.Windows.Forms.Timer timerGame;
        private System.Windows.Forms.PictureBox pictureBox;
        private System.Windows.Forms.Label lWinner;
        private System.Windows.Forms.Timer timerStopAnimation;
    }
}

