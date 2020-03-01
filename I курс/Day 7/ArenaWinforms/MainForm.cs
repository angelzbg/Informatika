using ArenaEngine;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ArenaWinforms
{
    public partial class MainForm : Form
    {
        Arena arena;

        public MainForm()
        {
            InitializeComponent();
        }

        private void timerGame_Tick(object sender, EventArgs e)
        {
            arena.MakeRound();
            if (arena.IsBattleOver)
            {
                timerGame.Enabled = false;
                pictureBox.Image = Image.FromFile("kill.gif");
                lWinner.Text = "Winner: " + arena.Winner.Name;
                lWinner.Visible = true;
                timerStopAnimation.Enabled = true;
            }
        }

        private void bNewGame_Click(object sender, EventArgs e)
        {
            Knight knight = new Knight("Sir John")
            {
                Weapon = new Sword()
            };
            Assassin assassin = new Assassin("Sneaky Patrick")
            {
                Weapon = new Dagger()
            };
            arena = new Arena(knight, assassin);

            //Start the timer now:
            timerGame.Enabled = true;

            //Start animation sequence.
            pictureBox.Image = Image.FromFile("battle.gif");

            //Disable New Game button and hide the Winner label.
            bNewGame.Enabled = false;
            lWinner.Visible = false;
        }

        private void timerStopAnimation_Tick(object sender, EventArgs e)
        {
            pictureBox.Enabled = false;
            timerStopAnimation.Enabled = false;
            bNewGame.Enabled = true;
        }
    }
}
